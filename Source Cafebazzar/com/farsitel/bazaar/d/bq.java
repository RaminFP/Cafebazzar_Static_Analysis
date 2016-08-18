package com.farsitel.bazaar.d;

import android.util.Log;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONException;
import org.json.JSONObject;

final class bq extends v {
    final /* synthetic */ bp a;

    private bq(bp bpVar) {
        this.a = bpVar;
    }

    public final void a(c cVar) {
        this.a.a(0, null);
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a.n) {
            Log.i(getClass().getSimpleName(), "Response :: " + jSONObject.toString());
        }
        try {
            if (jSONObject.has("url")) {
                this.a.p = jSONObject.getString("url");
            }
            if (jSONObject.has("error")) {
                this.a.a(0, null);
                return;
            }
            this.a.a = this.a.a(this.a.getActivity(), jSONObject);
            this.a.b();
        } catch (JSONException e) {
            this.a.a(0, null);
        }
    }
}
