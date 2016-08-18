package com.farsitel.bazaar.util;

import android.content.SharedPreferences.Editor;
import com.farsitel.bazaar.BazaarApplication;
import java.util.Calendar;

public enum h {
    INSTANCE;
    
    public double b;
    public double c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private long h;

    private void e() {
        new i(this).start();
    }

    private void f() {
        Editor edit = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit();
        edit.putString("pref_lt", String.valueOf(this.b));
        edit.putString("pref_lg", String.valueOf(this.c));
        edit.putString("pref_city", this.d);
        edit.putString("pref_province", this.e);
        edit.putString("pref_country", this.f);
        edit.putBoolean("pref_is_foreign", this.g);
        edit.commit();
    }

    public final void a() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.d == null && timeInMillis > this.h + 7200000) {
            e();
        } else if (this.d != null && timeInMillis > this.h + 36000000) {
            e();
        }
    }

    public final String b() {
        return this.d != null ? this.d : "";
    }

    public final String c() {
        return this.e != null ? this.e : "";
    }

    public final String d() {
        return this.f != null ? this.f : "";
    }
}
