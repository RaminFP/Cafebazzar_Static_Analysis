package com.farsitel.bazaar.f;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.i;
import com.farsitel.bazaar.h.b.q;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.util.f;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends v {
    public i[] a;
    private final b b;
    private Object c;

    public l(b bVar) {
        this.b = bVar;
    }

    public final void a() {
        this.b.a();
        this.c = d.INSTANCE.a(this, new q(), BazaarApplication.c().a.getLanguage(), "top-charts", Integer.valueOf(0));
    }

    public final void a(c cVar) {
        this.b.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        c cVar;
        try {
            if (jSONObject.has("error")) {
                cVar = new c((byte) 0);
                this.b.a(cVar.b, cVar.c);
            } else if (jSONObject.has("rows")) {
                JSONArray jSONArray = jSONObject.getJSONArray("rows");
                this.a = new i[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.a[i] = new i();
                    this.a[i].a = jSONArray.getJSONObject(i).getString("more");
                    this.a[i].c = jSONObject.getString("ref");
                    this.a[i].b = jSONArray.getJSONObject(i).getString("title");
                }
                if (BazaarApplication.c().b()) {
                    f.a(this.a);
                }
                this.b.b();
            } else {
                cVar = new c((byte) 0);
                this.b.a(cVar.b, cVar.c);
            }
        } catch (Exception e) {
            cVar = new c();
            this.b.a(cVar.b, cVar.c);
        }
    }
}
