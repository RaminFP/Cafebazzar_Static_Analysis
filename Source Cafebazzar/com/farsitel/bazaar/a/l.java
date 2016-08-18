package com.farsitel.bazaar.a;

import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.util.af;
import org.json.JSONArray;
import org.json.JSONObject;

final class l extends v {
    final /* synthetic */ h a;

    private l(h hVar) {
        this.a = hVar;
    }

    public final void a(c cVar) {
        this.a.s = false;
        if (this.a.f != null) {
            this.a.f.a(cVar.b, cVar.c);
        }
    }

    public final /* synthetic */ void a(Object obj) {
        int i = 0;
        JSONObject jSONObject = (JSONObject) obj;
        this.a.s = false;
        if (this.a.f != null) {
            try {
                if (jSONObject.has("error")) {
                    c cVar = new c((byte) 0);
                    this.a.f.a(cVar.b, cVar.c);
                    return;
                }
                int length;
                h hVar;
                a aVar = this.a.i;
                if (jSONObject.has("app_list")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("app_list");
                    if (jSONArray.length() > 0) {
                        JSONArray jSONArray2 = jSONArray.get(0) instanceof JSONArray ? jSONArray.getJSONArray(0) : jSONArray;
                        length = jSONArray2.length();
                        while (i < length) {
                            k kVar = new k(jSONArray2.getJSONObject(i));
                            if (!aVar.c) {
                                af afVar = af.INSTANCE;
                                if (af.c(kVar.a)) {
                                    i++;
                                }
                            }
                            aVar.d.add(kVar);
                            i++;
                        }
                        if (jSONObject.has("show_if_installed")) {
                            aVar.c = jSONObject.getBoolean("show_if_installed");
                        }
                        if (jSONObject.has("name")) {
                            aVar.b = jSONObject.getString("name");
                        }
                        hVar = this.a;
                        hVar.g += length;
                        if (length < 24) {
                            this.a.c();
                        }
                        if (this.a.f != null) {
                            this.a.notifyDataSetChanged();
                        }
                        this.a.f.b();
                    }
                }
                length = 0;
                if (jSONObject.has("show_if_installed")) {
                    aVar.c = jSONObject.getBoolean("show_if_installed");
                }
                if (jSONObject.has("name")) {
                    aVar.b = jSONObject.getString("name");
                }
                hVar = this.a;
                hVar.g += length;
                if (length < 24) {
                    this.a.c();
                }
                if (this.a.f != null) {
                    this.a.notifyDataSetChanged();
                }
                this.a.f.b();
            } catch (Exception e) {
                cVar = new c();
                this.a.f.a(cVar.b, cVar.c);
            }
        }
    }
}
