package ir.cafebazaar.pardakht.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class d extends SQLiteOpenHelper {
    public d(Context context) {
        super(context, "uoeno.db", null, 4);
    }

    protected final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS uoeno;");
        onCreate(sQLiteDatabase);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS uoeno ( _id INTEGER PRIMARY KEY, patek TEXT UNIQUE, asded TEXT NOT NULL, vacheron TEXT NOT NULL, arnold TEXT NOT NULL);");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
    }
}
