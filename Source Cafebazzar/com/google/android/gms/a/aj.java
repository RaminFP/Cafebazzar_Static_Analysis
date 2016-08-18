package com.google.android.gms.a;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.internal.av;
import java.lang.ref.WeakReference;

final class aj implements o {
    private final WeakReference a;
    private final a b;
    private final int c;

    public aj(ac acVar, a aVar, int i) {
        this.a = new WeakReference(acVar);
        this.b = aVar;
        this.c = i;
    }

    public final void a(ConnectionResult connectionResult) {
        boolean z = false;
        ac acVar = (ac) this.a.get();
        if (acVar != null) {
            if (Looper.myLooper() == acVar.a.m.a) {
                z = true;
            }
            av.a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            acVar.b.lock();
            try {
                if (acVar.b(0)) {
                    if (!connectionResult.b()) {
                        acVar.b(connectionResult, this.b, this.c);
                    }
                    if (acVar.d()) {
                        acVar.e();
                    }
                    acVar.b.unlock();
                }
            } finally {
                acVar.b.unlock();
            }
        }
    }

    public final void b(ConnectionResult connectionResult) {
        boolean z = true;
        ac acVar = (ac) this.a.get();
        if (acVar != null) {
            if (Looper.myLooper() != acVar.a.m.a) {
                z = false;
            }
            av.a(z, (Object) "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            acVar.b.lock();
            try {
                if (acVar.b(1)) {
                    if (!connectionResult.b()) {
                        acVar.b(connectionResult, this.b, this.c);
                    }
                    if (acVar.d()) {
                        acVar.f();
                    }
                    acVar.b.unlock();
                }
            } finally {
                acVar.b.unlock();
            }
        }
    }
}
