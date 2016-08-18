package ir.cafebazaar.pardakht.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private static final String[] a = new String[]{"productId", "jsonPurchaseInfo", "signature", "productType"};
    private final f b;
    private final Context c;
    private SQLiteDatabase d;

    public e(Context context) {
        this.c = context;
        this.b = new f(context);
    }

    public static long a() {
        return BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getLong("purchases_fetch_timestamp", 0);
    }

    private static ContentValues a(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(jSONObject.optInt("purchaseState")));
        contentValues.put("userId", str);
        contentValues.put("purchaseToken", jSONObject.optString("purchaseToken"));
        contentValues.put("purchaseTime", Long.valueOf(jSONObject.optLong("purchaseTime")));
        contentValues.put("packageName", jSONObject.optString("packageName"));
        contentValues.put("productId", jSONObject.optString("productId"));
        contentValues.put("jsonPurchaseInfo", str2);
        contentValues.put("productType", str4);
        contentValues.put("signature", str3);
        return contentValues;
    }

    static void a(long j) {
        Editor edit = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit();
        edit.putLong("purchases_fetch_timestamp", j);
        edit.commit();
    }

    private void c() {
        this.d = this.b.getWritableDatabase();
    }

    public final int a(String str, String str2) {
        j a = j.a();
        String d = a.d();
        if (!a.n() || d == null) {
            return 6;
        }
        int delete;
        synchronized (this) {
            c();
            delete = this.d.delete("purchases", "userId = ? AND packageName = ? AND purchaseToken = ?", new String[]{d, str, str2});
            this.d.close();
        }
        return delete == 1 ? 0 : 8;
    }

    public final boolean a(String str) {
        j a = j.a();
        String d = a.d();
        if (!a.n() || d == null) {
            return false;
        }
        boolean z;
        String packageName = BazaarApplication.c().getPackageName();
        synchronized (this) {
            c();
            Cursor query = this.d.query("purchases", new String[]{"signature"}, "userId = ? AND packageName = ? AND productId = ?", new String[]{d, packageName, str}, null, null, null);
            query.moveToFirst();
            z = !query.isAfterLast();
            query.close();
            this.d.close();
        }
        return z;
    }

    public final boolean a(String str, String str2, String str3) {
        boolean z = true;
        j a = j.a();
        String d = a.d();
        if (!a.n() || d == null) {
            z = false;
        } else {
            try {
                ContentValues a2 = a(d, str, str2, new JSONObject(str), str3);
                synchronized (this) {
                    c();
                    try {
                        this.d.insertOrThrow("purchases", null, a2);
                        this.d.close();
                    } catch (Throwable e) {
                        Log.w("Bazaar-BillingService", "addPurchase, purchase was previously registered - purchaseToken=" + a2.getAsString("purchaseToken"), e);
                        this.d.close();
                    } catch (Exception e2) {
                        Toast.makeText(this.c, this.c.getResources().getString(2131165659), 1).show();
                        this.d.close();
                        return false;
                    } catch (Throwable th) {
                        this.d.close();
                    }
                }
            } catch (JSONException e3) {
                return false;
            }
        }
        return z;
    }

    public final boolean a(JSONObject jSONObject, String str, String str2, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        j a = j.a();
        String d = a.d();
        if (a.n() && d != null) {
            synchronized (this) {
                c();
                try {
                    long j = jSONObject.getLong("fetch_timestamp");
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        boolean z = jSONArray2.getBoolean(0);
                        String string = jSONArray2.getString(1);
                        String string2 = jSONArray2.getString(2);
                        String string3 = jSONArray2.getString(3);
                        JSONObject jSONObject2 = new JSONObject(string);
                        String string4 = jSONObject2.getString("purchaseToken");
                        this.d.delete("purchases", "userId = ? AND purchaseToken = ?", new String[]{d, string4});
                        if (!z) {
                            try {
                                this.d.insert("purchases", null, a(d, string, string2, jSONObject2, string3));
                            } catch (Exception e) {
                                return false;
                            }
                        }
                    }
                    a(j);
                    Cursor query = this.d.query("purchases", a, "userId = ? AND packageName = ?", new String[]{d, str}, null, null, "_id");
                    query.moveToFirst();
                    if (query.getCount() > 0) {
                        while (!query.isAfterLast()) {
                            if (str2 != null) {
                                if (!str2.equals(query.getString(3))) {
                                    query.moveToNext();
                                }
                            }
                            arrayList.add(query.getString(0));
                            arrayList2.add(query.getString(1));
                            arrayList3.add(query.getString(2));
                            query.moveToNext();
                        }
                    }
                    query.close();
                    this.d.close();
                } catch (Throwable e2) {
                    Log.e("Bazaar-BillingService", "updateAndReturnPurchases :: purchasesDiff= " + jSONObject, e2);
                    return false;
                }
            }
        }
        bundle.putStringArrayList("INAPP_PURCHASE_ITEM_LIST", arrayList);
        bundle.putStringArrayList("INAPP_PURCHASE_DATA_LIST", arrayList2);
        bundle.putStringArrayList("INAPP_DATA_SIGNATURE_LIST", arrayList3);
        return true;
    }

    public final void b() {
        a(0);
        synchronized (this) {
            c();
            this.b.a(this.d);
            this.d.close();
        }
    }
}
