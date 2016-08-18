package com.farsitel.bazaar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.receiver.h;
import com.farsitel.bazaar.util.af;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public final class g extends SQLiteOpenHelper {
    private static g c;
    public HashMap a = new HashMap();
    public HashMap b = new HashMap();
    private Comparator d = new h(this);

    private g(Context context) {
        super(context, "upgradable-apps.db", null, 6);
        d();
    }

    public static g a() {
        if (c == null) {
            c = new g(BazaarApplication.c());
        }
        return c;
    }

    private void d() {
        synchronized (this) {
            this.a.clear();
            this.b.clear();
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor query = readableDatabase.query("upgradables_apps", null, null, null, null, null, "notified");
            while (query.moveToNext()) {
                String string = query.getString(0);
                String string2 = query.getString(1);
                long j = query.getLong(2);
                boolean z = query.getInt(4) > 0;
                d dVar = new d(string, j, string2, z, query.getInt(5) > 0);
                if (z) {
                    this.a.put(string, dVar);
                } else {
                    this.b.put(string, dVar);
                }
            }
            query.close();
            readableDatabase.close();
        }
    }

    private HashMap e() {
        HashMap hashMap = new HashMap();
        Iterator it = a(true).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            hashMap.put(dVar.a, dVar);
        }
        return hashMap;
    }

    public final TreeSet a(boolean z) {
        TreeSet treeSet = new TreeSet(this.d);
        synchronized (this) {
            treeSet.addAll(this.a.values());
            if (z) {
                treeSet.addAll(this.b.values());
            }
        }
        return treeSet;
    }

    public final void a(String str) {
        if (this.a.containsKey(str)) {
            this.a.remove(str);
        } else if (this.b.containsKey(str)) {
            this.b.remove(str);
        } else {
            return;
        }
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete("upgradables_apps", "pkgname = ?", new String[]{str});
            writableDatabase.close();
        }
        h.c();
    }

    public final boolean a(ArrayList arrayList) {
        boolean z;
        synchronized (this) {
            HashMap hashMap = new HashMap();
            for (d dVar : e().values()) {
                d dVar2;
                af afVar = af.INSTANCE;
                d b = af.b(dVar2.a);
                if (b == null || dVar2.d <= b.d || !b.e) {
                    a(dVar2.a);
                } else {
                    hashMap.put(dVar2.a, dVar2);
                }
            }
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Iterator it = arrayList.iterator();
            z = false;
            while (it.hasNext()) {
                dVar2 = (d) it.next();
                af afVar2 = af.INSTANCE;
                d b2 = af.b(dVar2.a);
                if (b2 == null || b2.c == null || dVar2.c == null || !dVar2.c.equals(b2.c)) {
                    int i = 1;
                } else {
                    Object obj = null;
                }
                ContentValues contentValues = new ContentValues();
                if (!hashMap.containsKey(dVar2.a)) {
                    afVar2 = af.INSTANCE;
                    if (af.a(dVar2.a)) {
                        contentValues.put("pkgname", dVar2.a);
                        contentValues.put("version_name", dVar2.c);
                        contentValues.put("version_code", Long.valueOf(dVar2.d));
                        contentValues.put("package_wolf", Integer.valueOf(dVar2.f ? 1 : 0));
                        contentValues.put("count_as_upgradable", Integer.valueOf(dVar2.e ? 1 : 0));
                        contentValues.put("notified", Integer.valueOf(obj != null ? 0 : 1));
                        try {
                            writableDatabase.insert("upgradables_apps", null, contentValues);
                            z = true;
                        } catch (Exception e) {
                            new Thread(new i(this)).start();
                            return false;
                        }
                    }
                    continue;
                } else if (dVar2.d > ((d) hashMap.get(dVar2.a)).d) {
                    afVar2 = af.INSTANCE;
                    if (af.a(dVar2.a)) {
                        z = ((d) hashMap.get(dVar2.a)).e;
                        contentValues.put("version_code", Long.valueOf(dVar2.d));
                        contentValues.put("version_name", dVar2.c);
                        contentValues.put("package_wolf", Integer.valueOf(dVar2.f ? 1 : 0));
                        contentValues.put("count_as_upgradable", Integer.valueOf(z ? 1 : 0));
                        contentValues.put("notified", Integer.valueOf(obj != null ? 0 : 1));
                        writableDatabase.update("upgradables_apps", contentValues, "pkgname = ?", new String[]{dVar2.a});
                        z = true;
                    }
                }
            }
            writableDatabase.close();
            h.c();
            if (z) {
                d();
            }
        }
        return z;
    }

    public final d b(String str) {
        return this.a.containsKey(str) ? (d) this.a.get(str) : this.b.containsKey(str) ? (d) this.b.get(str) : null;
    }

    public final void b() {
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("notified", Integer.valueOf(1));
            writableDatabase.update("upgradables_apps", contentValues, null, null);
            writableDatabase.close();
        }
        d();
    }

    public final int c() {
        int count;
        synchronized (this) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor query = readableDatabase.query("upgradables_apps", null, "count_as_upgradable = ? AND notified = ?", new String[]{"1", "0"}, null, null, null);
            try {
                count = query.getCount();
                query.close();
                readableDatabase.close();
            } catch (Throwable th) {
                query.close();
                readableDatabase.close();
            }
        }
        return count;
    }

    public final boolean c(String str) {
        return this.a.containsKey(str) || this.b.containsKey(str);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE upgradables_apps( pkgname TEXT PRIMARY KEY, version_name TEXT, version_code INTEGER, notified INTEGER DEFAULT 0, count_as_upgradable INTEGER DEFAULT 1, package_wolf INTEGER);");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS upgradables_apps;");
        onCreate(sQLiteDatabase);
    }
}
