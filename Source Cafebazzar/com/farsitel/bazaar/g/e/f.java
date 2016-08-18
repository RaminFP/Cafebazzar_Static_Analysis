package com.farsitel.bazaar.g.e;

import com.farsitel.bazaar.g.a.k;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    public g a;
    public String b;
    public e[] c;
    public k[] d;
    public String e;
    public String f;

    public static f a(JSONObject jSONObject) {
        int i = 0;
        f fVar = new f();
        JSONArray jSONArray;
        if (jSONObject.getString("type").equalsIgnoreCase("app")) {
            fVar.a = g.APP_ROW;
            if (jSONObject.has("title")) {
                fVar.b = jSONObject.getString("title");
            }
            if (jSONObject.has("more")) {
                fVar.e = jSONObject.getString("more");
            } else {
                fVar.e = null;
            }
            jSONArray = jSONObject.getJSONArray("content");
            k[] kVarArr = new k[jSONArray.length()];
            while (i < kVarArr.length) {
                kVarArr[i] = new k(jSONArray.getJSONObject(i));
                i++;
            }
            fVar.d = kVarArr;
        } else {
            fVar.a = g.PROMO_ROW;
            fVar.b = jSONObject.optString("title");
            jSONArray = jSONObject.getJSONArray("content");
            e[] eVarArr = new e[jSONArray.length()];
            while (i < eVarArr.length) {
                eVarArr[i] = new e(jSONArray.getJSONObject(i));
                i++;
            }
            fVar.c = eVarArr;
        }
        if (jSONObject.has("ref")) {
            fVar.f = jSONObject.getString("ref");
        }
        return fVar;
    }
}
