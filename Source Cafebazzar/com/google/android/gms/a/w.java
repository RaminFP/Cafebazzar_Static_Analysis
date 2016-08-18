package com.google.android.gms.a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.av;

public final class w implements k, l {
    public final a a;
    ba b;
    private final int c;

    public w(a aVar, int i) {
        this.a = aVar;
        this.c = i;
    }

    private void a() {
        av.a(this.b, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public final void a(int i) {
        a();
        this.b.a(i);
    }

    public final void a(Bundle bundle) {
        a();
        ba baVar = this.b;
        baVar.a.lock();
        try {
            baVar.k.a(bundle);
        } finally {
            baVar.a.unlock();
        }
    }

    public final void a(ConnectionResult connectionResult) {
        a();
        ba baVar = this.b;
        a aVar = this.a;
        int i = this.c;
        baVar.a.lock();
        try {
            baVar.k.a(connectionResult, aVar, i);
        } finally {
            baVar.a.unlock();
        }
    }
}
