package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.h.c;
import org.json.JSONObject;

final class v extends com.farsitel.bazaar.h.v {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final void a(c cVar) {
        this.a.a(cVar.b, cVar.c);
    }

    public final /* synthetic */ void a(Object obj) {
        try {
            this.a.a((JSONObject) obj);
        } catch (Exception e) {
            c cVar = new c();
            this.a.a(cVar.b, cVar.c);
        }
    }
}
