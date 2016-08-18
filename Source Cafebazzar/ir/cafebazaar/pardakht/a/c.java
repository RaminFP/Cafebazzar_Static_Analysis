package ir.cafebazaar.pardakht.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import ir.cafebazaar.pardakht.b.a;
import java.util.ArrayList;

public final class c {
    private static final String[] a = new String[]{"_id", "patek", "asded", "vacheron", "arnold"};
    private final d b;
    private final Context c;
    private SQLiteDatabase d;

    public c(Context context) {
        this.c = context;
        this.b = new d(context);
    }

    private static a a(Cursor cursor) {
        return new a(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
    }

    private void d() {
        this.d = this.b.getWritableDatabase();
    }

    public final a a() {
        a a;
        synchronized (this) {
            d();
            Cursor query = this.d.query("uoeno", a, null, null, null, null, null);
            query.moveToFirst();
            query.moveToLast();
            a = a(query);
            query.close();
            this.d.close();
        }
        return a;
    }

    public final a a(String str, String str2, String str3, String str4) {
        a a;
        synchronized (this) {
            d();
            this.d.execSQL("DELETE FROM uoeno");
            ContentValues contentValues = new ContentValues();
            contentValues.put("patek", str);
            contentValues.put("vacheron", str3);
            contentValues.put("arnold", str4);
            contentValues.put("asded", str2);
            Cursor query = this.d.query("uoeno", a, "_id=" + this.d.insert("uoeno", null, contentValues), null, null, null, null);
            query.moveToFirst();
            a = a(query);
            query.close();
            this.d.close();
        }
        return a;
    }

    public final void a(String str) {
        d();
        this.d.delete("uoeno", "patek = '" + str + "'", null);
        this.d.close();
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            d();
            Cursor query = this.d.query("uoeno", a, null, null, null, null, null);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                arrayList.add(a(query));
                query.moveToNext();
            }
            query.close();
            this.d.close();
        }
        return arrayList;
    }

    public final void c() {
        synchronized (this) {
            d();
            this.b.a(this.d);
            this.d.close();
        }
    }
}
