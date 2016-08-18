package com.farsitel.bazaar.f;

import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.k;
import com.farsitel.bazaar.h.b.l;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.util.af;
import java.math.BigInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends v {
    final String a;
    final String b;
    private final boolean c;
    private c f;

    public a(String str, boolean z, String str2, c cVar) {
        this.a = str != null ? str.trim() : "null";
        this.c = z;
        this.b = str2;
        this.f = cVar;
    }

    public final void a() {
        if (this.c) {
            d.INSTANCE.a(this, this.b, new k(), this.a, Integer.valueOf(VERSION.SDK_INT));
            return;
        }
        d.INSTANCE.a(this, this.b, new l(), j.a().b, this.a, Integer.valueOf(VERSION.SDK_INT));
    }

    public final void a(c cVar) {
        this.f.e();
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String str = null;
        long j = 0;
        String str2 = null;
        BigInteger bigInteger = null;
        long j2 = 0;
        try {
            int i;
            if (jSONObject.has("t")) {
                String str3;
                JSONArray jSONArray;
                if (jSONObject.has("cp")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("cp");
                    if (jSONArray2.length() > 0) {
                        str = jSONArray2.getString(0);
                    }
                    str3 = str;
                    for (i = 1; i < jSONArray2.length(); i++) {
                        str3 = str3 + ";" + jSONArray2.getString(i);
                    }
                } else {
                    str3 = null;
                }
                String string = jSONObject.getString("t");
                BigInteger bigInteger2 = new BigInteger(jSONObject.getString("h"), 16);
                if (jSONObject.has("s")) {
                    j = jSONObject.getLong("s");
                }
                af afVar = af.INSTANCE;
                com.farsitel.bazaar.g.d b = af.b(this.a);
                if (b != null) {
                    if (jSONObject.has("df")) {
                        jSONArray = jSONObject.getJSONArray("df");
                        com.farsitel.bazaar.g.d b2 = g.a().b(this.a);
                        if (b2 != null) {
                            for (i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                if (jSONObject2.getLong("ovc") == b.d && jSONObject2.getLong("nvc") == b2.d) {
                                    str2 = jSONObject2.getString("t");
                                    bigInteger = new BigInteger(jSONObject2.getString("h"), 16);
                                    j2 = jSONObject2.getLong("s");
                                    break;
                                }
                            }
                        }
                    }
                }
                Object obj2 = 1;
                if (jSONObject.has("cd")) {
                    jSONArray = jSONObject.getJSONArray("cd");
                    int length = jSONArray.length();
                    obj2 = null;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (jSONArray.getString(i2).equals(Build.DEVICE)) {
                            obj2 = 1;
                            break;
                        }
                    }
                }
                if (obj2 != null) {
                    this.f.a(str3, string, bigInteger2, j, str2, bigInteger, j2);
                    return;
                } else {
                    this.f.b();
                    return;
                }
            }
            if (jSONObject.has("error")) {
                i = jSONObject.getInt("error");
                if (i == 403) {
                    this.f.a();
                    return;
                } else if (i == 404) {
                    this.f.b();
                    return;
                } else if (i == 405 || i != 800) {
                    this.f.c();
                    return;
                } else {
                    if (j.a().n()) {
                        com.farsitel.bazaar.util.a.a(new b(this));
                        Toast.makeText(BazaarApplication.c(), 2131165437, 0).show();
                    }
                    this.f.d();
                    return;
                }
            }
            this.f.e();
        } catch (JSONException e) {
            e.printStackTrace();
            this.f.e();
        }
    }
}
