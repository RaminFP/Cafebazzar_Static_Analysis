package com.farsitel.bazaar.g;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;

public final class j {
    private static final j c = new j();
    public final SharedPreferences a;
    public String b;

    private j() {
        this.a = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        this.b = null;
        this.b = this.a.getString("jsonrpc_session_key", null);
    }

    public static j a() {
        return c;
    }

    public static void b(long j) {
        Editor edit = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit();
        edit.putLong("reg_authenticated", j);
        edit.commit();
    }

    public static void c(long j) {
        Editor edit = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit();
        edit.putLong("reg_anonymous", j);
        edit.commit();
    }

    public static long q() {
        return BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getLong("reg_authenticated", 0);
    }

    public static long r() {
        return BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getLong("reg_anonymous", 0);
    }

    public final void a(long j) {
        this.a.edit().putLong("user_credit", j).commit();
    }

    public final boolean b() {
        return this.a.getBoolean("user_has_usable_password", true);
    }

    public final long c() {
        return this.a.getLong("user_credit", 0);
    }

    public final String d() {
        return this.a.getString("user_id", null);
    }

    public final String e() {
        return this.a.getString("user_phone_number", null);
    }

    public final String f() {
        return e.b(e());
    }

    public final String g() {
        return this.a.getString("user_email", null);
    }

    public final String h() {
        Object g = g();
        return (g == null || TextUtils.isEmpty(g)) ? e.b(e()) : g;
    }

    public final boolean i() {
        return (g() == null || TextUtils.isEmpty(g())) ? false : true;
    }

    public final boolean j() {
        return (e() == null || TextUtils.isEmpty(e())) ? false : true;
    }

    public final String k() {
        return this.a.getString("user_nickname", null);
    }

    public final String l() {
        return this.a.getString("user_cdnprefix", null);
    }

    public final int m() {
        return this.a.getInt("device_id_int", 0);
    }

    public final boolean n() {
        return this.b != null;
    }

    public final boolean o() {
        return this.a.getBoolean("update_all_enabled", false);
    }

    public final String p() {
        return n() ? "Authenticated" : "Anonymous";
    }

    public final k s() {
        return new k();
    }
}
