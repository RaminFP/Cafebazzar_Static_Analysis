package com.farsitel.bazaar.g.a;

import org.json.JSONObject;

public final class c {
    public final int a;
    public final String b;
    public final String c;

    public c(JSONObject jSONObject) {
        this.a = jSONObject.getInt("id");
        this.b = jSONObject.getString("title");
        this.c = jSONObject.getString("url");
    }
}
