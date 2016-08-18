package com.farsitel.bazaar.g.c;

import org.json.JSONObject;

public final class b {
    public long a;
    public String b;

    private b(long j, String str) {
        this.a = j;
        this.b = str;
    }

    public b(JSONObject jSONObject) {
        this(jSONObject.getLong("id"), jSONObject.getString("name"));
    }
}
