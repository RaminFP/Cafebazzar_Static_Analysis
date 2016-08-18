package com.farsitel.bazaar.f;

import com.farsitel.bazaar.g.a.a;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class e extends v {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void a(c cVar) {
        this.a.b.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.has("error")) {
            try {
                Map hashMap = new HashMap();
                hashMap.put("general", jSONObject.getString("error_msg"));
                this.a.b.a(jSONObject.getInt("error"), hashMap);
                return;
            } catch (Exception e) {
                c cVar = new c();
                this.a.b.a(cVar.b, cVar.c);
                return;
            }
        }
        try {
            this.a.c = new a(this.a.a, jSONObject);
            this.a.b.b();
        } catch (JSONException e2) {
            cVar = new c();
            this.a.b.a(cVar.b, cVar.c);
        }
    }
}
