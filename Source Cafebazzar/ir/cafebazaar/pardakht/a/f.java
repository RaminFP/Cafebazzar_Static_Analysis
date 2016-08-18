package ir.cafebazaar.pardakht.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.farsitel.bazaar.BazaarApplication;

public final class f extends SQLiteOpenHelper {
    public f(Context context) {
        super(context, "purchases.db", null, 3);
    }

    protected final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS purchases;");
        onCreate(sQLiteDatabase);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS purchases ( _id INTEGER PRIMARY KEY, state INTEGER DEFAULT 0, userId TEXT, purchaseToken TEXT UNIQUE,purchaseTime INTEGER, packageName TEXT, productId TEXT, productType TEXT, jsonPurchaseInfo TEXT, signature TEXT);");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        e eVar = new e(BazaarApplication.c());
        e.a(0);
        a(sQLiteDatabase);
    }
}
