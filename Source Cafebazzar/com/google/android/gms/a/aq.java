package com.google.android.gms.a;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import java.util.Collections;

public final class aq implements az {
    private final ba a;

    public aq(ba baVar) {
        this.a = baVar;
    }

    public final t a(t tVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void a() {
        for (c a : this.a.f.values()) {
            a.a();
        }
        this.a.m.e = Collections.emptySet();
    }

    public final void a(int i) {
    }

    public final void a(Bundle bundle) {
    }

    public final void a(ConnectionResult connectionResult, a aVar, int i) {
    }

    public final void b() {
        this.a.m.e();
    }

    public final void c() {
        ba baVar = this.a;
        baVar.a.lock();
        try {
            baVar.k = new ac(baVar, baVar.h, baVar.i, baVar.d, baVar.j, baVar.a, baVar.c);
            baVar.k.a();
            baVar.b.signalAll();
        } finally {
            baVar.a.unlock();
        }
    }
}
