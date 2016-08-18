package com.farsitel.bazaar.g.c;

import org.json.JSONObject;

public final class a {
    public long a;
    public String b;
    public String c;

    private a(long j, String str, String str2) {
        this.a = j;
        this.b = str;
        this.c = str2;
    }

    public a(JSONObject jSONObject) {
        this(jSONObject.getLong("id"), jSONObject.getString("title"), jSONObject.getString("description"));
    }
}
