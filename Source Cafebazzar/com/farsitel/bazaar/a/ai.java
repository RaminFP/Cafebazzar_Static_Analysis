package com.farsitel.bazaar.a;

import android.text.TextUtils;
import org.json.JSONObject;

public final class ai {
    private static final String[] h = new String[]{"shetab", "push", "credit", "giftcard", "native"};
    public boolean a;
    boolean b;
    String c;
    String d;
    String e;
    public String f;
    String g;

    public ai(JSONObject jSONObject) {
        this.d = jSONObject.getString("title");
        this.c = jSONObject.getString("icon");
        boolean z = jSONObject.has("enabled") && jSONObject.getBoolean("enabled");
        this.a = z;
        this.f = jSONObject.getString("type");
        this.e = jSONObject.has("method") ? jSONObject.getString("method") : "no_method";
        this.b = jSONObject.getBoolean("buy_credit");
        this.g = jSONObject.has("desc") ? jSONObject.getString("desc") : "";
    }

    public final boolean a() {
        for (String equals : h) {
            if (equals.equals(this.f)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        return !TextUtils.isEmpty(this.g);
    }

    public final String toString() {
        return "PaymentOption(" + this.d + " " + this.f + " " + this.a + ")";
    }
}
