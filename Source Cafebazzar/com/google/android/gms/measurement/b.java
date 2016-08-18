package com.google.android.gms.measurement;

import com.google.android.gms.measurement.internal.ap;
import com.google.android.gms.measurement.internal.z;

final class b implements Runnable {
    final /* synthetic */ ap a;
    final /* synthetic */ int b;
    final /* synthetic */ z c;
    final /* synthetic */ AppMeasurementService d;

    b(AppMeasurementService appMeasurementService, ap apVar, int i, z zVar) {
        this.d = appMeasurementService;
        this.a = apVar;
        this.b = i;
        this.c = zVar;
    }

    public final void run() {
        this.a.k();
        this.d.a.post(new c(this));
    }
}
