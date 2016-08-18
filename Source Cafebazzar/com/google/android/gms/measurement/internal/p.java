package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.av;

final class p {
    final String a;
    final String b;
    final long c;
    final long d;
    final long e;

    p(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        av.a(str);
        av.a(str2);
        av.b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        av.b(z);
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
    }
}
