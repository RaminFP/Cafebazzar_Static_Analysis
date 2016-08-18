package com.farsitel.bazaar.g;

import com.farsitel.bazaar.BazaarApplication;
import org.json.JSONObject;

public final class h {
    private static BazaarApplication m = BazaarApplication.c();
    public String a;
    public String b;
    public String c;
    public int d;
    public char e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;
    private String k;
    private int l;
    private final char n;
    private final char o;

    private h(String str, String str2, String str3, String str4, char c, int i, String str5, String str6, String str7, boolean z, int i2) {
        this.n = 'M';
        this.o = 'A';
        this.f = str;
        this.a = str2;
        this.c = str3;
        this.b = str4;
        this.e = c;
        this.d = i;
        this.k = str5;
        this.g = str6;
        this.h = str7;
        this.l = i2;
        this.j = z;
        this.i = this.l == 0;
    }

    public h(JSONObject jSONObject) {
        this(jSONObject.getString("sku"), jSONObject.getString("packagename"), jSONObject.getString("title"), jSONObject.getString("app"), jSONObject.getString("kind").charAt(0), jSONObject.getInt("price"), jSONObject.getString("start_time"), jSONObject.getString("end_time"), jSONObject.getString("status"), jSONObject.getBoolean("renewable"), jSONObject.getInt("status_code"));
    }
}
