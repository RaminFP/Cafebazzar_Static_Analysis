package com.farsitel.bazaar.h.a;

import com.a.a.a.a;
import com.a.a.a.y;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.receiver.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class s extends v {
    final /* synthetic */ b a;
    final /* synthetic */ r b;

    public s(r rVar, b bVar) {
        this.b = rVar;
        this.a = bVar;
    }

    public final void a(c cVar) {
        this.a.a(cVar.b, cVar.c);
        a.c().a((y) new y().a("email-token").a(false).a("reason", String.valueOf(cVar.b)));
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.has("error")) {
                Object hashMap = new HashMap();
                int i = jSONObject.getInt("error");
                if (i == 602) {
                    hashMap.put("general", this.b.a.getString(2131165258));
                } else {
                    hashMap.put("general", this.b.a.getString(2131165374));
                }
                this.b.c.a(i, hashMap);
                a.c().a((y) new y().a("email-token").a(false).a("reason", String.valueOf(i)));
                return;
            }
            j a = j.a();
            boolean n = a.n();
            this.b.a(jSONObject);
            if (n != a.n()) {
                d.b();
            }
            this.b.c.b();
            a.c().a(new y().a("email-token").a(true));
        } catch (Exception e) {
            c cVar = new c();
            this.a.a(cVar.b, cVar.c);
            a.c().a((y) new y().a("email-token").a(false).a("reason", String.valueOf(cVar.b)));
        }
    }
}
