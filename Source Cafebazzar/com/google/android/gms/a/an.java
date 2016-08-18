package com.google.android.gms.a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;

final class an implements k, l {
    final /* synthetic */ ac a;

    private an(ac acVar) {
        this.a = acVar;
    }

    public final void a(int i) {
    }

    public final void a(Bundle bundle) {
        this.a.d.a(new ag(this.a));
    }

    public final void a(ConnectionResult connectionResult) {
        this.a.b.lock();
        try {
            if (this.a.a(connectionResult)) {
                this.a.h();
                this.a.g();
            } else {
                this.a.b(connectionResult);
            }
            this.a.b.unlock();
        } catch (Throwable th) {
            this.a.b.unlock();
        }
    }
}
