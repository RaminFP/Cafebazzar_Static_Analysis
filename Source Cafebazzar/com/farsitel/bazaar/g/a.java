package com.farsitel.bazaar.g;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.k;
import com.farsitel.bazaar.h.b.am;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.util.p;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static a a;
    private String b;

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public final void a(c cVar) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        new Thread(new b(this, cVar)).start();
    }

    public final void b() {
        synchronized (this) {
            Map d = com.farsitel.bazaar.database.a.e().d();
            if (this.b == null) {
                this.b = ((JSONObject) d.INSTANCE.a(new am(), null, null, null)).getString("nonce");
            }
            d dVar = d.INSTANCE;
            k amVar = new am();
            String language = BazaarApplication.c().a.getLanguage();
            Collection<c> values = d.values();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("android_id", p.a());
            jSONObject.put("device_id", j.a().m());
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("is_table", o.e());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", jSONObject);
            JSONArray jSONArray = new JSONArray();
            for (c cVar : values) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("when", cVar.a);
                if (!TextUtils.isEmpty(cVar.f)) {
                    jSONObject3.put("agent", cVar.f);
                }
                if (cVar.b != null) {
                    jSONObject3.put("who", cVar.b);
                }
                if (cVar.d != null) {
                    jSONObject3.put("where", new JSONArray().put(cVar.c).put(cVar.d));
                } else {
                    try {
                        jSONObject3.put("where", cVar.c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (cVar.g != null) {
                    jSONObject3.put("what", new JSONArray().put(cVar.e).put(cVar.g));
                } else {
                    jSONObject3.put("what", cVar.e);
                }
                jSONArray.put(jSONObject3);
            }
            jSONObject2.put("actions", jSONArray);
            JSONObject jSONObject4 = (JSONObject) dVar.a(amVar, language, jSONObject2, this.b);
            this.b = jSONObject4.getString("nonce");
            if (!jSONObject4.has("error_code")) {
                com.farsitel.bazaar.database.a e2 = com.farsitel.bazaar.database.a.e();
                Integer[] numArr = (Integer[]) d.keySet().toArray(new Integer[d.keySet().size()]);
                synchronized (e2) {
                    e2.getWritableDatabase().delete("actions", com.farsitel.bazaar.database.a.a[0] + " in " + Arrays.toString(numArr).replace("[", "(").replace("]", ")"), null);
                }
            }
        }
    }
}
