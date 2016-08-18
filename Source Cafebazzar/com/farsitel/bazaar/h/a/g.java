package com.farsitel.bazaar.h.a;

import android.content.Intent;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.receiver.d;
import com.farsitel.bazaar.util.a;
import org.json.JSONException;
import org.json.JSONObject;

final class g extends v {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void a(c cVar) {
        f.a(this.a);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        boolean n = j.a().n();
        try {
            this.a.a(jSONObject);
            if (n != j.a().n()) {
                d.b();
            }
            a.a();
            if (this.a instanceof l) {
                j.a();
                j.c(System.currentTimeMillis());
            } else if (this.a instanceof m) {
                j.a();
                j.b(System.currentTimeMillis());
            }
            f fVar = this.a;
            Intent intent = new Intent();
            intent.setAction("com.farsitel.bazaar.ON_REGISTER_SUCCESS");
            android.support.v4.b.j.a(BazaarApplication.c()).a(intent);
        } catch (JSONException e) {
            e.printStackTrace();
            f.a(this.a);
        }
    }
}
