package com.farsitel.bazaar.h.a;

import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class k extends v {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void a(c cVar) {
        this.a.c.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Map hashMap = new HashMap();
        try {
            if (jSONObject.getInt("error_code") >= 0) {
                com.farsitel.bazaar.g.k s = j.a().s();
                s.a.putLong("user_credit", (long) jSONObject.getInt("balance"));
                s.a();
                this.a.c.b();
                return;
            }
            hashMap.put("general", jSONObject.getString("error"));
            this.a.c.a(2100, hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
