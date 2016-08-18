package com.farsitel.bazaar.g;

import com.congenialmobile.util.e;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public long a = System.currentTimeMillis();
    public String b;
    public String c;
    public JSONObject d;
    public String e;
    public String f;
    public JSONObject g;

    public c() {
        if (j.a().n()) {
            this.b = e.a(j.a().h());
        }
    }

    public final c a(String str, Object obj) {
        if (this.d == null) {
            this.d = new JSONObject();
        }
        try {
            this.d.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public final c b(String str, Object obj) {
        if (this.g == null) {
            this.g = new JSONObject();
        }
        try {
            this.g.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public final String toString() {
        return "Action :: when=" + new SimpleDateFormat().format(Long.valueOf(this.a)) + ";\n agent=" + this.f + ";\n who=" + this.b + ";\n where=" + this.c + "; details=" + (this.d != null ? this.d.toString() : "") + ";\n what=" + this.e + "; details=" + (this.g != null ? this.g.toString() : "");
    }
}
