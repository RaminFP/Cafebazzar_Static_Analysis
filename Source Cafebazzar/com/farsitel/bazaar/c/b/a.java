package com.farsitel.bazaar.c.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.c.a.f;
import com.farsitel.bazaar.g.a.i;
import com.farsitel.bazaar.util.af;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public final class a {
    public static final String[] a = new String[]{"2", "1", "0", "11", "4", "5", "6", "7", "8", "9", "3", "10", "2"};
    private static final String[] c = new String[]{"12", "4", "9"};
    private static final String[] d = new String[]{"13", "14"};
    private static final String[] e = new String[]{"2"};
    private static final String[] f = new String[]{"12", "13", "14"};
    private static a g;
    public HashMap b = new HashMap();

    private a() {
        Iterator it;
        c cVar = new c(BazaarApplication.c());
        synchronized (this) {
            SQLiteDatabase writableDatabase = cVar.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("lelksalksl", Integer.valueOf(12));
            writableDatabase.update("dls", contentValues, "lelksalksl = ? OR lelksalksl = ?", d);
            contentValues = new ContentValues();
            contentValues.put("lelksalksl", Integer.valueOf(10));
            writableDatabase.update("dls", contentValues, "lelksalksl = ?", e);
            Cursor query = writableDatabase.query("dls", null, "lelksalksl = ?", new String[]{"1"}, null, null, null);
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            query.close();
            writableDatabase.close();
            it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                af afVar = af.INSTANCE;
                if (!af.c(str)) {
                    a(str, 0);
                }
            }
        }
        it = c().iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            this.b.put(iVar.g(), Integer.valueOf(iVar.f()));
        }
    }

    public static a a() {
        if (g == null) {
            g = new a();
        }
        return g;
    }

    public final int a(String str) {
        Integer num = (Integer) this.b.get(str);
        return num != null ? num.intValue() : 10;
    }

    public final void a(String str, int i) {
        boolean b = f.b(i);
        if (!b) {
            Integer num = (Integer) this.b.get(str);
            if (num != null && num.intValue() == i) {
                return;
            }
        }
        c cVar = new c(BazaarApplication.c());
        synchronized (this) {
            SQLiteDatabase writableDatabase = cVar.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("apasdasdas", str);
            contentValues.put("lelksalksl", Integer.valueOf(i));
            if (b) {
                contentValues.put("kmqwlqsalk", Long.valueOf(System.currentTimeMillis()));
            }
            writableDatabase.update("dls", contentValues, "apasdasdas = ?", new String[]{str});
            writableDatabase.close();
        }
        this.b.put(str, Integer.valueOf(i));
    }

    public final void a(String str, String str2, int i, boolean z) {
        synchronized (this) {
            c cVar = new c(BazaarApplication.c());
            synchronized (this) {
                SQLiteDatabase writableDatabase = cVar.getWritableDatabase();
                writableDatabase.execSQL("INSERT OR REPLACE INTO dls (apasdasdas,bkalksd,kmqwlqsalk,lelksalksl,melksalksl) VALUES ('" + str + "','" + str2.replaceAll("'", " ") + "'," + System.currentTimeMillis() + ",12" + "," + (z ? "1" : "0") + ");");
                writableDatabase.close();
            }
        }
        this.b.put(str, Integer.valueOf(12));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(java.lang.String r11) {
        /*
        r10 = this;
        r8 = 0;
        r0 = new com.farsitel.bazaar.c.b.c;
        r1 = com.farsitel.bazaar.BazaarApplication.c();
        r0.<init>(r1);
        monitor-enter(r10);	 Catch:{ all -> 0x004f }
        r0 = r0.getReadableDatabase();	 Catch:{ all -> 0x0043 }
        r1 = "dls";
        r2 = 0;
        r3 = "apasdasdas = ?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0053 }
        r5 = 0;
        r4[r5] = r11;	 Catch:{ all -> 0x0053 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0053 }
        r1 = r8.getCount();	 Catch:{ all -> 0x0053 }
        if (r1 <= 0) goto L_0x0039;
    L_0x0027:
        r8.moveToNext();	 Catch:{ all -> 0x0053 }
        r1 = 3;
        r2 = r8.getLong(r1);	 Catch:{ all -> 0x0053 }
        r1 = (int) r2;	 Catch:{ all -> 0x0053 }
        monitor-exit(r10);	 Catch:{ all -> 0x0053 }
        r8.close();
        r0.close();
        r0 = r1;
    L_0x0038:
        return r0;
    L_0x0039:
        monitor-exit(r10);	 Catch:{ all -> 0x0053 }
        r8.close();
        r0.close();
        r0 = 10;
        goto L_0x0038;
    L_0x0043:
        r1 = move-exception;
        r0 = r8;
    L_0x0045:
        monitor-exit(r10);	 Catch:{ all -> 0x0058 }
        throw r1;	 Catch:{ all -> 0x0047 }
    L_0x0047:
        r1 = move-exception;
    L_0x0048:
        r0.close();
        r8.close();
        throw r1;
    L_0x004f:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
        goto L_0x0048;
    L_0x0053:
        r1 = move-exception;
        r9 = r8;
        r8 = r0;
        r0 = r9;
        goto L_0x0045;
    L_0x0058:
        r1 = move-exception;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.c.b.a.b(java.lang.String):int");
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(BazaarApplication.c());
        synchronized (this) {
            SQLiteDatabase readableDatabase = cVar.getReadableDatabase();
            Cursor query = readableDatabase.query("dls", null, "lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ?", c, null, null, null);
            while (query.moveToNext()) {
                arrayList.add(new i(query.getString(0), query.getString(1), query.getLong(4) == 1, query.getInt(3)));
            }
            query.close();
            readableDatabase.close();
        }
        return arrayList;
    }

    public final ArrayList c() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(BazaarApplication.c());
        synchronized (this) {
            SQLiteDatabase readableDatabase = cVar.getReadableDatabase();
            Cursor query = readableDatabase.query("dls", null, null, null, null, null, "kmqwlqsalk DESC");
            if (query.getCount() > 0) {
                while (query.moveToNext()) {
                    arrayList.add(new i(query.getString(0), query.getString(1), query.getInt(4) == 1, query.getInt(3)));
                }
            }
            query.close();
            readableDatabase.close();
        }
        ArrayList arrayList2 = new ArrayList();
        Object arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            i iVar = (i) arrayList.get(i);
            if (f.a(iVar.f())) {
                arrayList2.add(iVar);
            } else {
                arrayList3.add(iVar);
            }
        }
        Collections.sort(arrayList2, new b(this));
        arrayList2.addAll(arrayList3);
        arrayList.clear();
        arrayList3.clear();
        return arrayList2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.lang.String r13) {
        /*
        r12 = this;
        r8 = 1;
        r9 = 0;
        r10 = 0;
        r0 = new com.farsitel.bazaar.c.b.c;
        r1 = com.farsitel.bazaar.BazaarApplication.c();
        r0.<init>(r1);
        monitor-enter(r12);	 Catch:{ all -> 0x0040 }
        r0 = r0.getReadableDatabase();	 Catch:{ all -> 0x0034 }
        r1 = "dls";
        r2 = 0;
        r3 = "apasdasdas = ?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0044 }
        r5 = 0;
        r4[r5] = r13;	 Catch:{ all -> 0x0044 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r10 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0044 }
        r1 = r10.getCount();	 Catch:{ all -> 0x0044 }
        if (r1 <= 0) goto L_0x0032;
    L_0x0029:
        r1 = r8;
    L_0x002a:
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        r10.close();
        r0.close();
        return r1;
    L_0x0032:
        r1 = r9;
        goto L_0x002a;
    L_0x0034:
        r1 = move-exception;
        r0 = r10;
    L_0x0036:
        monitor-exit(r12);	 Catch:{ all -> 0x0049 }
        throw r1;	 Catch:{ all -> 0x0038 }
    L_0x0038:
        r1 = move-exception;
    L_0x0039:
        r0.close();
        r10.close();
        throw r1;
    L_0x0040:
        r0 = move-exception;
        r1 = r0;
        r0 = r10;
        goto L_0x0039;
    L_0x0044:
        r1 = move-exception;
        r11 = r10;
        r10 = r0;
        r0 = r11;
        goto L_0x0036;
    L_0x0049:
        r1 = move-exception;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.c.b.a.c(java.lang.String):boolean");
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(BazaarApplication.c());
        synchronized (this) {
            SQLiteDatabase writableDatabase = cVar.getWritableDatabase();
            Cursor query = writableDatabase.query("dls", null, "lelksalksl = ? OR lelksalksl = ? OR lelksalksl = ?", f, null, null, null);
            if (query.getCount() > 0) {
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
                }
            }
            query.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                ContentValues contentValues = new ContentValues();
                contentValues.put("lelksalksl", Integer.valueOf(11));
                writableDatabase.update("dls", contentValues, "apasdasdas = ?", new String[]{str});
                this.b.put(str, Integer.valueOf(11));
            }
            writableDatabase.close();
        }
        return arrayList;
    }
}
