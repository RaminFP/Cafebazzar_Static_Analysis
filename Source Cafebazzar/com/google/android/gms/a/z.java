package com.google.android.gms.a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class z implements bg {
    final /* synthetic */ x a;

    z(x xVar) {
        this.a = xVar;
    }

    public final void a(int i) {
        this.a.f.lock();
        try {
            x.a(this.a, this.a.a, i);
        } finally {
            this.a.f.unlock();
        }
    }

    public final void a(Bundle bundle) {
        this.a.f.lock();
        try {
            this.a.e = ConnectionResult.a;
            x.a(this.a);
        } finally {
            this.a.f.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.a.f.lock();
        try {
            this.a.e = connectionResult;
            x.a(this.a);
        } finally {
            this.a.f.unlock();
        }
    }
}
