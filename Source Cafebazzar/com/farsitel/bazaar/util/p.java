package com.farsitel.bazaar.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class p {
    public static String a() {
        String string = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getString("bazaar_unique_id", null);
        return string == null ? "null" : string;
    }

    public static JSONObject b() {
        Object obj;
        Object obj2 = null;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", a());
        jSONObject2.put("bv", k.c());
        jSONObject2.put("sd", VERSION.SDK_INT);
        jSONObject2.put("dm", Build.MANUFACTURER);
        jSONObject2.put("do", Build.MODEL);
        jSONObject2.put("dd", Build.DEVICE);
        jSONObject2.put("dp", Build.PRODUCT);
        jSONObject2.put("sz", o.a());
        jSONObject2.put("mc", q.c());
        jSONObject2.put("mn", q.d());
        String b = h.INSTANCE.b();
        String c = h.INSTANCE.c();
        String d = h.INSTANCE.d();
        jSONObject2.put("ct", b);
        jSONObject2.put("pr", c);
        jSONObject2.put("co", d);
        jSONObject2.put("dpi", o.g());
        if (VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            int length = strArr.length;
            obj = "";
            int i = 0;
            while (i < length) {
                try {
                    obj = obj + strArr[i] + ", ";
                    i++;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            obj = Build.CPU_ABI;
        }
        jSONObject2.put("abi", obj);
        jSONObject2.put("abi2", Build.CPU_ABI2);
        try {
            b = j.a().a.getString("user_specs", null);
            if (b != null) {
                obj2 = new JSONObject(b);
            }
            if (obj2 != null) {
                jSONObject2.put("us", obj2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        jSONObject.put("device", jSONObject2);
        return jSONObject;
    }
}
