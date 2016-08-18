package com.google.android.gms.measurement;

import com.google.android.gms.measurement.internal.i;

final class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (!this.a.d.stopSelfResult(this.a.b)) {
            return;
        }
        if (i.B()) {
            this.a.c.g.a("Device AppMeasurementService processed last upload request");
        } else {
            this.a.c.g.a("Local AppMeasurementService processed last upload request");
        }
    }
}
