package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.av;

final class ay implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ as b;

    ay(as asVar, AppMetadata appMetadata) {
        this.b = asVar;
        this.a = appMetadata;
    }

    public final void run() {
        this.b.a(this.a.h);
        ap a = this.b.a;
        AppMetadata appMetadata = this.a;
        a.f().e();
        a.a();
        av.a((Object) appMetadata);
        av.a(appMetadata.b);
        if (!TextUtils.isEmpty(appMetadata.c)) {
            a.a(appMetadata);
            if (a.h().a(appMetadata.b, "_f") == null) {
                long a2 = a.d.a();
                a.a(new UserAttributeParcel("_fot", a2, Long.valueOf(((a2 / 3600000) + 1) * 3600000), "auto"), appMetadata);
                Bundle bundle = new Bundle();
                bundle.putLong("_c", 1);
                a.a(new EventParcel("_f", new EventParams(bundle), "auto", a2), appMetadata);
            }
        }
    }
}
