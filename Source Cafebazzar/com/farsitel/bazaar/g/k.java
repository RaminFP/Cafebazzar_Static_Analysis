package com.farsitel.bazaar.g;

import android.content.SharedPreferences.Editor;

public final class k {
    public Editor a;
    final /* synthetic */ j b;

    private k(j jVar) {
        this.b = jVar;
        this.a = jVar.a.edit();
    }

    public final k a(int i) {
        if (i == -1) {
            this.a.remove("device_id_int");
        } else {
            this.a.putInt("device_id_int", i);
        }
        return this;
    }

    public final k a(String str) {
        System.currentTimeMillis();
        this.b.b = str;
        if (this.b.b == null) {
            this.a.remove("jsonrpc_session_key");
        } else {
            this.a.putString("jsonrpc_session_key", this.b.b);
        }
        return this;
    }

    public final k a(boolean z) {
        this.a.putBoolean("user_has_usable_password", z);
        return this;
    }

    public final k a(String[] strArr) {
        String str = "";
        if (strArr.length > 0) {
            str = "" + strArr[0];
            for (int i = 1; i < strArr.length; i++) {
                str = str + " " + strArr[i];
            }
        }
        this.a.putString("stats_urls", str);
        return this;
    }

    public final void a() {
        this.a.commit();
    }

    public final k b(String str) {
        this.a.putString("user_id", str);
        return this;
    }

    public final k b(boolean z) {
        this.a.putBoolean("sign_up_with_phone_enabled", z);
        return this;
    }

    public final k c(String str) {
        this.a.putString("user_phone_number", str);
        return this;
    }

    public final k d(String str) {
        this.a.putString("user_email", str);
        return this;
    }

    public final k e(String str) {
        this.a.putString("user_nickname", str);
        return this;
    }
}
