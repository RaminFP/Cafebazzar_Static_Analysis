package com.farsitel.bazaar.g;

import org.json.JSONObject;

public final class e {
    public final String a;
    public final String b;
    private final boolean c;
    private final int d;

    public e(JSONObject jSONObject) {
        this.a = jSONObject.getString("slug");
        this.b = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("game");
        this.d = jSONObject.getInt("id");
    }
}
