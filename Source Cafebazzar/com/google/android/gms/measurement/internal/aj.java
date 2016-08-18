package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.av;

public final class aj {
    final /* synthetic */ ai a;
    private final String b;
    private final long c = 0;
    private boolean d;
    private long e;

    public aj(ai aiVar, String str, long j) {
        this.a = aiVar;
        av.a(str);
        this.b = str;
    }

    public final long a() {
        if (!this.d) {
            this.d = true;
            this.e = this.a.g.getLong(this.b, this.c);
        }
        return this.e;
    }

    public final void a(long j) {
        Editor edit = this.a.g.edit();
        edit.putLong(this.b, j);
        edit.apply();
        this.e = j;
    }
}
