package com.farsitel.bazaar.b;

import com.farsitel.bazaar.activity.EmailAuthenticationActivity;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONException;
import org.json.JSONObject;

final class d extends v {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    d(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void a(c cVar) {
        this.b.a.setVisibility(0);
        this.b.c.setVisibility(0);
        this.b.c.setText(2131165374);
        this.b.b.setVisibility(8);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        this.b.b.setVisibility(8);
        if (jSONObject.has("error")) {
            try {
                if (jSONObject.getInt("error") == -2) {
                    j.a().s().d(this.a).a();
                    this.b.d();
                    this.b.e.dismiss();
                    return;
                }
                this.b.a.setVisibility(0);
                this.b.c.setVisibility(0);
                this.b.c.setText(jSONObject.getString("error_message"));
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                this.b.a.setVisibility(0);
                this.b.c.setVisibility(0);
                this.b.c.setText(2131165374);
                return;
            }
        }
        EmailAuthenticationActivity.a(this.b.f, null, 55, this.a, false, false, false);
        this.b.e.dismiss();
    }
}
