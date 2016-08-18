package com.farsitel.bazaar.g.a;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.f;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.aj;
import com.farsitel.bazaar.util.o;
import org.json.JSONObject;

public final class k extends f {
    public final String a;
    public final String b;
    public final String c;
    public long d;
    public String e;
    public final float f;
    public final long g;
    public final String h;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final String m;
    public String n;
    private final long o;
    private final String p;
    private final boolean q;
    private String[] r;

    public k(String str, String str2, String str3, float f, boolean z, long j, String str4, String str5, boolean z2, long j2, String str6, boolean z3, String str7, String str8) {
        this.o = 1;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.e = str6;
        this.d = j2;
        this.f = f;
        this.q = z;
        this.n = str8;
        this.g = j;
        this.h = this.g == 0 ? BazaarApplication.c().getString(2131165392) : aj.a(this.g);
        this.i = str4;
        this.k = z3;
        this.p = str5.replaceAll("\\<.*?\\>", "");
        this.j = z2;
        this.l = String.format(VERSION.SDK_INT >= 17 ? "%sicons/%s_%s.webp" : "%sicons/%s_%s.png", new Object[]{j.a().l(), this.a, o.b()});
        this.m = String.format(VERSION.SDK_INT >= 17 ? "%sicons/%s_%s.webp" : "%sicons/%s_%s.png", new Object[]{j.a().l(), this.a, o.c()});
        if (str7 == null || TextUtils.isEmpty(str7)) {
            this.r = null;
        } else {
            this.r = str7.split(";");
        }
    }

    public k(String str, String str2, String str3, float f, boolean z, long j, String str4, String str5, boolean z2, String str6) {
        this(str, str2, str3, 0.0f, false, 0, str4, str5, true, 0, "", false, null, null);
    }

    private k(String str, String str2, String str3, float f, boolean z, long j, String str4, String str5, boolean z2, String str6, int i, String str7, String str8) {
        this(str, str2, str3, f, false, j, str4, str5, true, (long) i, str7, z2, str6, str8);
    }

    public k(JSONObject jSONObject) {
        String string;
        long j;
        String string2;
        String string3;
        boolean z;
        String str;
        int i;
        String str2;
        String str3;
        String string4 = jSONObject.getString("p");
        String string5 = jSONObject.getString("n");
        if (jSONObject.has("an")) {
            string = jSONObject.getString("an");
        } else {
            string = "";
        }
        float f = (float) jSONObject.getDouble("r");
        if (jSONObject.has("f")) {
            j = jSONObject.getLong("f");
        } else {
            j = 0;
        }
        if (jSONObject.has("dps")) {
            string2 = jSONObject.getString("dps");
        } else {
            string2 = "";
        }
        if (jSONObject.has("d")) {
            string3 = jSONObject.getString("d");
        } else {
            string3 = "";
        }
        if (jSONObject.has("i")) {
            if (jSONObject.getBoolean("i")) {
                z = true;
                if (jSONObject.has("cd")) {
                    str = null;
                } else {
                    str = jSONObject.getString("cd");
                }
                if (jSONObject.has("vc")) {
                    i = 0;
                } else {
                    i = jSONObject.getInt("vc");
                }
                if (jSONObject.has("vn")) {
                    str2 = "";
                } else {
                    str2 = jSONObject.getString("vn");
                }
                if (jSONObject.has("ref")) {
                    str3 = null;
                } else {
                    str3 = jSONObject.getString("ref");
                }
                this(string4, string5, string, f, false, j, string2, string3, z, str, i, str2, str3);
            }
        }
        z = false;
        if (jSONObject.has("cd")) {
            str = null;
        } else {
            str = jSONObject.getString("cd");
        }
        if (jSONObject.has("vc")) {
            i = 0;
        } else {
            i = jSONObject.getInt("vc");
        }
        if (jSONObject.has("vn")) {
            str2 = "";
        } else {
            str2 = jSONObject.getString("vn");
        }
        if (jSONObject.has("ref")) {
            str3 = null;
        } else {
            str3 = jSONObject.getString("ref");
        }
        this(string4, string5, string, f, false, j, string2, string3, z, str, i, str2, str3);
    }

    public final Drawable a() {
        if (this.q) {
            try {
                return BazaarApplication.c().getPackageManager().getPackageInfo(this.a, 0).applicationInfo.loadIcon(BazaarApplication.c().getApplicationContext().getPackageManager());
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
