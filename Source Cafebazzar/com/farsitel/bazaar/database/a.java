package com.farsitel.bazaar.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends SQLiteOpenHelper {
    public static final String[] a = new String[]{"_id", "_when", "who", "_where", "where_details", "what", "what_details", "agent"};
    private static a b;

    private a(Context context) {
        super(context, "actions.db", null, 1);
    }

    public static a e() {
        if (b == null) {
            b = new a(BazaarApplication.c());
        }
        return b;
    }

    public final int a() {
        int count;
        synchronized (this) {
            count = getReadableDatabase().query("actions", null, null, null, null, null, null).getCount();
        }
        return count;
    }

    public final long b() {
        synchronized (this) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String str = a[1];
            String[] strArr = new String[]{str};
            Cursor query = readableDatabase.query("actions", strArr, null, null, null, null, a[1]);
            if (query.getCount() > 0) {
                query.moveToFirst();
                long j = query.getLong(0);
                return j;
            }
            return Long.MAX_VALUE;
        }
    }

    public final int c() {
        synchronized (this) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String str = a[0];
            String[] strArr = new String[]{str};
            Cursor query = readableDatabase.query("actions", strArr, null, null, null, null, a[1]);
            if (query.getCount() > 0) {
                query.moveToFirst();
                int i = query.getInt(0);
                return i;
            }
            return -1;
        }
    }

    public final Map d() {
        Map hashMap;
        synchronized (this) {
            Cursor query = getReadableDatabase().query("actions", a, null, null, null, null, null);
            hashMap = new HashMap();
            query.moveToFirst();
            while (!query.isAfterLast()) {
                c cVar = new c();
                cVar.a = query.getLong(1);
                cVar.b = query.getString(2);
                cVar.c = query.getString(3);
                cVar.e = query.getString(5);
                cVar.f = query.getString(7);
                try {
                    JSONObject jSONObject;
                    Iterator keys;
                    String str;
                    if (query.getString(4) != null) {
                        jSONObject = new JSONObject(query.getString(4));
                        keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            str = (String) keys.next();
                            cVar.a(str, jSONObject.get(str));
                        }
                    }
                    if (query.getString(6) != null) {
                        jSONObject = new JSONObject(query.getString(6));
                        keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            str = (String) keys.next();
                            cVar.b(str, jSONObject.get(str));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                hashMap.put(Integer.valueOf(query.getInt(0)), cVar);
                query.moveToNext();
            }
        }
        return hashMap;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS actions ( _id INTEGER PRIMARY KEY, _when INTEGER, who TEXT, _where TEXT, where_details TEXT, what TEXT, what_details TEXT, agent TEXT);");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS actions;");
    }
}
