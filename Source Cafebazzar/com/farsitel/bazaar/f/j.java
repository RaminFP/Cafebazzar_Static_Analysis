package com.farsitel.bazaar.f;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.e;
import com.farsitel.bazaar.h.b.n;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends v {
    public ArrayList a = new ArrayList();
    public ArrayList b = new ArrayList();
    private final b c;
    private Object f;

    public j(b bVar) {
        this.c = bVar;
    }

    public final void a() {
        this.c.a();
        this.f = d.INSTANCE.a(this, new n(), BazaarApplication.c().a.getLanguage());
    }

    public final void a(c cVar) {
        this.c.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        c cVar;
        try {
            if (jSONObject.has("error")) {
                cVar = new c((byte) 0);
                this.c.a(cVar.b, cVar.c);
            } else if (jSONObject.has("categs")) {
                JSONArray jSONArray = jSONObject.getJSONArray("categs");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (jSONArray.getJSONObject(i).getBoolean("game")) {
                        this.b.add(new e(jSONArray.getJSONObject(i)));
                    } else {
                        this.a.add(new e(jSONArray.getJSONObject(i)));
                    }
                }
                this.c.b();
            } else {
                cVar = new c((byte) 0);
                this.c.a(cVar.b, cVar.c);
            }
        } catch (Exception e) {
            cVar = new c();
            this.c.a(cVar.b, cVar.c);
        }
    }
}
