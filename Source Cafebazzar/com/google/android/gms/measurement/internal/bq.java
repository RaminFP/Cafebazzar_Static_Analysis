package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.AppMeasurementService;

final class bq implements Runnable {
    final /* synthetic */ bm a;

    bq(bm bmVar) {
        this.a = bmVar;
    }

    public final void run() {
        bg.a(this.a.c, new ComponentName(this.a.c.i(), AppMeasurementService.class));
    }
}
