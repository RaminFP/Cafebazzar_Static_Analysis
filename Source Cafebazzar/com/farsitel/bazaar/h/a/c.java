package com.farsitel.bazaar.h.a;

import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.receiver.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class c extends v {
    final /* synthetic */ b a;
    final /* synthetic */ b b;

    c(b bVar, b bVar2) {
        this.b = bVar;
        this.a = bVar2;
    }

    public final void a(com.farsitel.bazaar.h.c cVar) {
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
                this.b.b.a(i, hashMap);
                return;
            }
            j a = j.a();
            boolean n = a.n();
            this.b.a(jSONObject);
            if (n != a.n()) {
                d.b();
            }
            this.b.b.b();
        } catch (Exception e) {
            com.farsitel.bazaar.h.c cVar = new com.farsitel.bazaar.h.c();
            this.a.a(cVar.b, cVar.c);
        }
    }
}
