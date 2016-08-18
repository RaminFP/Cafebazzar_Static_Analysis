package com.farsitel.bazaar.h.a;

import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends v {
    final /* synthetic */ d a;

    public e(d dVar) {
        this.a = dVar;
    }

    public final void a(c cVar) {
        this.a.d.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Map hashMap = new HashMap();
        try {
            if (jSONObject.has("error")) {
                int i = jSONObject.getInt("error");
                if (jSONObject.has("error_message")) {
                    hashMap.put("general", jSONObject.getString("error_message"));
                } else if (i == 600) {
                    hashMap.put("general", this.a.a.getString(2131165737));
                } else if (i == 601) {
                    hashMap.put("general", this.a.a.getString(2131165730));
                } else if (i == 603) {
                    hashMap.put("general", this.a.a.getString(2131165698));
                } else if (i == 602) {
                    hashMap.put("general", this.a.a.getString(2131165697));
                } else {
                    hashMap.put("general", this.a.a.getString(2131165374));
                }
                if (hashMap.size() > 0) {
                    this.a.d.a(i, hashMap);
                    return;
                } else {
                    this.a.d.b();
                    return;
                }
            }
            this.a.d.b();
        } catch (Exception e) {
            c cVar = new c();
            this.a.d.a(cVar.b, cVar.c);
        }
    }
}
