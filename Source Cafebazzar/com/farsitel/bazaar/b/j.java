package com.farsitel.bazaar.b;

import com.farsitel.bazaar.activity.SmsAuthenticationActivity;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONException;
import org.json.JSONObject;

final class j extends v {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void a(c cVar) {
        this.a.b.a.setVisibility(0);
        this.a.b.c.setVisibility(0);
        this.a.b.c.setText(2131165374);
        this.a.b.b.setVisibility(8);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        this.a.b.b.setVisibility(8);
        if (jSONObject.has("error")) {
            try {
                if (jSONObject.getInt("error") == -2) {
                    com.farsitel.bazaar.g.j.a().s().c(this.a.a).a();
                    this.a.b.d();
                    this.a.b.e.dismiss();
                    return;
                }
                this.a.b.a.setVisibility(0);
                this.a.b.c.setVisibility(0);
                this.a.b.c.setText(jSONObject.getString("error_message"));
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                this.a.b.a.setVisibility(0);
                this.a.b.c.setVisibility(0);
                this.a.b.c.setText(2131165374);
                return;
            }
        }
        this.a.b.d = true;
        this.a.f.startActivityForResult(SmsAuthenticationActivity.a(this.a.f, this.a.a, false, false, false), 56);
        this.a.b.e.dismiss();
    }
}
