package com.farsitel.bazaar.g.e;

import android.os.Build.VERSION;
import com.farsitel.bazaar.g.f;
import com.farsitel.bazaar.util.ae;
import java.util.Locale;
import org.json.JSONObject;

public final class e extends f {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    private e(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public e(JSONObject jSONObject) {
        this(jSONObject.getString("im"), jSONObject.has("t") ? jSONObject.getString("t") : "", jSONObject.has("st") ? jSONObject.getString("st") : "", jSONObject.getString("l"), jSONObject.has("ref") ? jSONObject.getString("ref") : null);
    }

    public final String a() {
        Locale locale = Locale.ENGLISH;
        String str = this.a;
        String a = ae.a();
        String str2 = VERSION.SDK_INT >= 17 ? "webp" : "jpg";
        return String.format(locale, str, new Object[]{a, str2});
    }

    public final String b() {
        Locale locale = Locale.ENGLISH;
        String str = this.a;
        String a = ae.a();
        String str2 = VERSION.SDK_INT >= 17 ? "webp" : "jpg";
        return String.format(locale, str, new Object[]{a, str2});
    }
}
