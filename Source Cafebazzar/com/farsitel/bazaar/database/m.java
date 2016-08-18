package com.farsitel.bazaar.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.l;
import java.util.ArrayList;

public final class m extends SQLiteOpenHelper {
    private static m a;
    private static String[] b = new String[]{"packagename", "rate", "comment"};

    private m(Context context) {
        super(context, "user_reviews.db", null, 2);
    }

    public static m a() {
        if (a == null) {
            a = new m(BazaarApplication.c());
        }
        return a;
    }

    public final l a(String str) {
        synchronized (this) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor query = readableDatabase.query("review", null, "packagename = ?", new String[]{str}, null, null, null);
            try {
                if (query.getCount() <= 0 || !query.moveToNext()) {
                    query.close();
                    readableDatabase.close();
                    return null;
                }
                l lVar = new l(str, query.getInt(1), query.getString(2), query.getInt(3));
                query.close();
                readableDatabase.close();
                return lVar;
            } catch (Throwable th) {
                query.close();
                readableDatabase.close();
            }
        }
    }

    public final void a(l lVar) {
        int i = 0;
        try {
            i = BazaarApplication.c().getPackageManager().getPackageInfo(lVar.a, 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("INSERT OR REPLACE INTO review (packagename, rate, comment, version) VALUES ('" + lVar.a + "'," + lVar.b + ",'" + lVar.c + "', " + i + ");");
            writableDatabase.close();
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Cursor rawQuery = writableDatabase.rawQuery("SELECT packagename FROM review WHERE sent = 0", null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        do {
                            arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("packagename")));
                        } while (rawQuery.moveToNext());
                    }
                } catch (Throwable th) {
                    rawQuery.close();
                    writableDatabase.close();
                }
            }
            rawQuery.close();
            writableDatabase.close();
        }
        return arrayList;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS review ( packagename TEXT PRIMARY KEY, rate INTEGER, comment TEXT, version INTEGER NOT NULL DEFAULT 0, sent INTEGER NOT NULL DEFAULT 0 );");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (sQLiteDatabase.getVersion() < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE review ADD COLUMN comment TEXT; ");
            } catch (Exception e) {
            }
            try {
                sQLiteDatabase.execSQL("ALTER TABLE review ADD COLUMN version INTEGER NOT NULL DEFAULT 0; ");
            } catch (Exception e2) {
            }
            try {
                sQLiteDatabase.execSQL("ALTER TABLE review ADD COLUMN sent INTEGER NOT NULL DEFAULT 0; ");
            } catch (Exception e3) {
            }
        }
    }
}
