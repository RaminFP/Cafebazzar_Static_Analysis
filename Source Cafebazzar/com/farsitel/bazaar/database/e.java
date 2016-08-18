package com.farsitel.bazaar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class e extends SQLiteOpenHelper {
    private static e a;
    private static String[] b = new String[]{"_id", "packagename", "name"};

    private e(Context context) {
        super(context, "bookmarked_apps.db", null, 1);
    }

    public static e a() {
        if (a == null) {
            a = new e(BazaarApplication.c());
        }
        return a;
    }

    public final void a(String str, String str2) {
        Context c = BazaarApplication.c();
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("packagename", str);
            contentValues.put("name", str2);
            try {
                writableDatabase.insert("bookmarked", null, contentValues);
                writableDatabase.close();
            } catch (Exception e) {
                Toast.makeText(c, c.getResources().getString(2131165659), 1).show();
                writableDatabase.close();
            } catch (Throwable th) {
                writableDatabase.close();
            }
        }
    }

    public final boolean a(String str) {
        if (str == null) {
            return false;
        }
        boolean z;
        synchronized (this) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor query = readableDatabase.query("bookmarked", b, "packagename = ?", new String[]{str}, null, null, null);
            query.moveToFirst();
            z = !query.isAfterLast();
            query.close();
            readableDatabase.close();
        }
        return z;
    }

    public final void b() {
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete("bookmarked", null, null);
            writableDatabase.close();
        }
    }

    public final void b(String str) {
        synchronized (this) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            writableDatabase.delete("bookmarked", "packagename = ?", new String[]{str});
            writableDatabase.close();
        }
    }

    public final Set c() {
        Map treeMap = new TreeMap();
        synchronized (this) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor query = readableDatabase.query("bookmarked", null, null, null, null, null, null);
            if (query.getCount() > 0) {
                while (query.moveToNext()) {
                    treeMap.put(query.getString(1), query.getString(2));
                }
            }
            query.close();
            readableDatabase.close();
        }
        return treeMap.entrySet();
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bookmarked ( _id INTEGER PRIMARY KEY, packagename TEXT, name TEXT);");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bookmarked;");
        onCreate(sQLiteDatabase);
    }
}
