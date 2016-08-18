package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

final class av implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ String c;
    final /* synthetic */ as d;

    av(as asVar, String str, EventParcel eventParcel, String str2) {
        this.d = asVar;
        this.a = str;
        this.b = eventParcel;
        this.c = str2;
    }

    public final void run() {
        this.d.a(this.a);
        ap a = this.d.a;
        EventParcel eventParcel = this.b;
        String str = this.c;
        b b = a.h().b(str);
        if (b == null || TextUtils.isEmpty(b.g)) {
            a.e().f.a("No app data available; dropping event", str);
        } else {
            a.a(eventParcel, new AppMetadata(str, b.c, b.g, b.h, b.i, b.j, null, b.k));
        }
    }
}
