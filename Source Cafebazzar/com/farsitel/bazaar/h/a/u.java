package com.farsitel.bazaar.h.a;

import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u extends v {
    final /* synthetic */ b a;
    final /* synthetic */ t b;

    public u(t tVar, b bVar) {
        this.b = tVar;
        this.a = bVar;
    }

    public final void a(c cVar) {
        this.a.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.has("error")) {
                Map hashMap = new HashMap();
                int i = jSONObject.getInt("error");
                Object string = this.b.a.getString(2131165374);
                if (jSONObject.has("error_message")) {
                    string = jSONObject.getString("error_message");
                } else if (i == 602) {
                    string = this.b.a.getString(2131165697);
                }
                hashMap.put("general", string);
                this.b.d.a(i, hashMap);
                return;
            }
            this.b.a(jSONObject);
            this.b.d.b();
        } catch (Exception e) {
            c cVar = new c();
            this.a.a(cVar.b, cVar.c);
        }
    }
}
