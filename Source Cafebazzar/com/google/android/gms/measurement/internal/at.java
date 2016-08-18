package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.av;

final class at implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ as b;

    at(as asVar, AppMetadata appMetadata) {
        this.b = asVar;
        this.a = appMetadata;
    }

    public final void run() {
        this.b.a(this.a.h);
        ap a = this.b.a;
        AppMetadata appMetadata = this.a;
        a.f().e();
        a.a();
        av.a(appMetadata.b);
        a.a(appMetadata);
    }
}
