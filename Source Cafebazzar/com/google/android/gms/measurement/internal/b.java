package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.av;

final class b {
    final String a;
    final String b;
    final String c;
    final String d;
    final long e;
    final long f;
    final String g;
    final String h;
    final long i;
    final long j;
    final boolean k;

    b(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, long j3, long j4, boolean z) {
        av.a(str);
        av.b(j >= 0);
        this.a = str;
        this.b = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = null;
        }
        this.c = str3;
        this.d = str4;
        this.e = j;
        this.f = j2;
        this.g = str5;
        this.h = str6;
        this.i = j3;
        this.j = j4;
        this.k = z;
    }
}
