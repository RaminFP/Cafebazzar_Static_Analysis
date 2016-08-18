package com.farsitel.bazaar.h.a;

import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class o extends v {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final void a(c cVar) {
        this.a.b.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.has("error")) {
                Map hashMap = new HashMap();
                switch (jSONObject.getInt("error")) {
                    case -1:
                        hashMap.put("general", this.a.a.getString(2131165397));
                        j.a().s().a(true).a();
                        this.a.b.a(-1, hashMap);
                        return;
                    default:
                        hashMap.put("general", jSONObject.getString("error_msg"));
                        this.a.b.a(jSONObject.getInt("error"), hashMap);
                        return;
                }
            }
            j.a().s().a(true).a();
            this.a.b.b();
        } catch (Exception e) {
            c cVar = new c();
            this.a.b.a(cVar.b, cVar.c);
        }
    }
}
