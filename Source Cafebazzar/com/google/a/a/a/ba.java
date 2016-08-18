package com.google.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

final class ba extends SQLiteOpenHelper {
    final /* synthetic */ ay a;
    private boolean b;
    private long c = 0;

    ba(ay ayVar, Context context, String str) {
        this.a = ayVar;
        super(context, str, null, 1);
    }

    private static boolean a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (SQLiteException e) {
                try {
                    as.d("Error querying for table " + str);
                    if (query != null) {
                        query.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                cursor = query;
                th = th22;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            query = null;
            as.d("Error querying for table " + str);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th222) {
            th = th222;
            cursor2 = null;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (!this.b || this.c + 3600000 <= this.a.h.a()) {
            SQLiteDatabase sQLiteDatabase = null;
            this.b = true;
            this.c = this.a.h.a();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.a.e.getDatabasePath(this.a.f).delete();
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.b = false;
            return sQLiteDatabase;
        }
        throw new SQLiteException("Database creation failed");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (v.a() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        Object obj = null;
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (a("hits2", sQLiteDatabase)) {
            Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery2.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                    if (!hashSet.remove("hit_app_id")) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                rawQuery2.close();
            }
        } else {
            sQLiteDatabase.execSQL(ay.a);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
