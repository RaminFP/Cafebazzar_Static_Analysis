package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.av;

public final class ak {
    final String a;
    final String b;
    final String c;
    final long d;
    final /* synthetic */ ai e;

    private ak(ai aiVar, String str, long j) {
        this.e = aiVar;
        av.a(str);
        av.b(j > 0);
        this.a = str + ":start";
        this.b = str + ":count";
        this.c = str + ":value";
        this.d = j;
    }

    void a() {
        this.e.e();
        long a = this.e.h().a();
        Editor edit = this.e.g.edit();
        edit.remove(this.b);
        edit.remove(this.c);
        edit.putLong(this.a, a);
        edit.apply();
    }

    public final void a(String str, long j) {
        this.e.e();
        if (b() == 0) {
            a();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.e.g.getLong(this.b, 0);
        if (j2 <= 0) {
            Editor edit = this.e.g.edit();
            edit.putString(this.c, str);
            edit.putLong(this.b, j);
            edit.apply();
            return;
        }
        Object obj = (this.e.m.nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
        Editor edit2 = this.e.g.edit();
        if (obj != null) {
            edit2.putString(this.c, str);
        }
        edit2.putLong(this.b, j2 + j);
        edit2.apply();
    }

    long b() {
        return this.e.s().getLong(this.a, 0);
    }
}
