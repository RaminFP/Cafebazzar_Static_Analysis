package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class bq extends v {
    final /* synthetic */ JoinActivity a;

    private bq(JoinActivity joinActivity) {
        this.a = joinActivity;
    }

    public final void a(c cVar) {
        this.a.n.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Map hashMap = new HashMap();
        try {
            if (jSONObject.has("has_password") && jSONObject.has("is_new_user")) {
                this.a.e = jSONObject.getBoolean("has_password");
                this.a.d = jSONObject.getBoolean("is_new_user");
                this.a.n.b();
            } else if (jSONObject.has("error")) {
                hashMap.put("general", jSONObject.getString("error_message"));
                this.a.n.a(jSONObject.getInt("error"), hashMap);
            }
        } catch (Exception e) {
            c cVar = new c();
            this.a.n.a(cVar.b, cVar.c);
        }
    }
}
