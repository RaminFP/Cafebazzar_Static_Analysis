package com.farsitel.bazaar.g.a;

import android.content.Context;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.g.j;
import org.json.JSONObject;

public final class d extends f {
    final String a;

    public d(JSONObject jSONObject) {
        super(j.a().l() + jSONObject.getString("t"));
        this.a = jSONObject.getString("f");
    }

    public final int a() {
        return -1;
    }

    public final OnClickListener a(Context context) {
        return new e(this, context);
    }
}
