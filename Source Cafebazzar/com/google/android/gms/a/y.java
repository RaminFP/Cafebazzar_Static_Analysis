package com.google.android.gms.a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class y implements bg {
    final /* synthetic */ x a;

    y(x xVar) {
        this.a = xVar;
    }

    public final void a(int i) {
        this.a.f.lock();
        try {
            x.a(this.a, this.a.b, i);
        } finally {
            this.a.f.unlock();
        }
    }

    public final void a(Bundle bundle) {
        this.a.f.lock();
        try {
            x xVar = this.a;
            if (xVar.c == null) {
                xVar.c = bundle;
            } else if (bundle != null) {
                xVar.c.putAll(bundle);
            }
            this.a.d = ConnectionResult.a;
            x.a(this.a);
        } finally {
            this.a.f.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult) {
        this.a.f.lock();
        try {
            this.a.d = connectionResult;
            x.a(this.a);
        } finally {
            this.a.f.unlock();
        }
    }
}
