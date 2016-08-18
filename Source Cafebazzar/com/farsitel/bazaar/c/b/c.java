package com.farsitel.bazaar.c.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class c extends SQLiteOpenHelper {
    public c(Context context) {
        super(context, "bazaar_downloads.db", null, 17);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE dls( apasdasdas TEXT PRIMARY KEY, bkalksd TEXT, kmqwlqsalk INTEGER, lelksalksl INTEGER, melksalksl INTEGER);");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS dls;");
        onCreate(sQLiteDatabase);
    }
}
