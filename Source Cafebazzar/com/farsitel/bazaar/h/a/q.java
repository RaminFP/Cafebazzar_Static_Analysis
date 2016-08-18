package com.farsitel.bazaar.h.a;

import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.receiver.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class q extends v {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public final void a(c cVar) {
        this.a.b.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.has("error")) {
                Map hashMap = new HashMap();
                int i = jSONObject.getInt("error");
                Object string = this.a.a.getString(2131165374);
                if (jSONObject.has("error_message")) {
                    string = jSONObject.getString("error_message");
                } else if (i == 602) {
                    string = this.a.a.getString(2131165697);
                }
                hashMap.put("general", string);
                this.a.b.a(i, hashMap);
                return;
            }
            j a = j.a();
            boolean n = a.n();
            this.a.a(jSONObject);
            if (n != a.n()) {
                d.b();
            }
            this.a.b.b();
        } catch (Exception e) {
            c cVar = new c();
            this.a.b.a(cVar.b, cVar.c);
        }
    }
}
