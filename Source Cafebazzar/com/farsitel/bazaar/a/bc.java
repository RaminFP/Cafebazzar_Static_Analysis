package com.farsitel.bazaar.a;

import com.farsitel.bazaar.g.h;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class bc extends v {
    final /* synthetic */ az a;

    bc(az azVar) {
        this.a = azVar;
    }

    public final void a(c cVar) {
        this.a.d.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        try {
            JSONArray jSONArray = ((JSONObject) obj).getJSONArray("subs");
            this.a.a.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.a.a.add(new h(jSONArray.getJSONObject(i)));
            }
            this.a.d.b();
        } catch (JSONException e) {
            e.printStackTrace();
            c cVar = new c((byte) 0);
            this.a.d.a(cVar.b, cVar.c);
        }
    }
}
