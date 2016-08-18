package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

final class aw implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ UserAttributeParcel b;
    final /* synthetic */ as c;

    aw(as asVar, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.c = asVar;
        this.a = appMetadata;
        this.b = userAttributeParcel;
    }

    public final void run() {
        this.c.a(this.a.h);
        ap a = this.c.a;
        UserAttributeParcel userAttributeParcel = this.b;
        AppMetadata appMetadata = this.a;
        a.f().e();
        a.a();
        if (!TextUtils.isEmpty(appMetadata.c)) {
            a.e().f.a("Removing user attribute", userAttributeParcel.b);
            a.h().b();
            try {
                a.a(appMetadata);
                a.h().b(appMetadata.b, userAttributeParcel.b);
                a.h().o();
                a.e().f.a("User attribute removed", userAttributeParcel.b);
            } finally {
                a.h().p();
            }
        }
    }
}
