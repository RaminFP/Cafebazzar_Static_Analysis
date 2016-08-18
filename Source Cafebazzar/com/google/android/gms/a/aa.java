package com.google.android.gms.a;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;

public final class aa implements az {
    private final ba a;

    public aa(ba baVar) {
        this.a = baVar;
    }

    public final t a(t tVar) {
        try {
            this.a.m.a((ay) tVar);
            c a = this.a.m.a(tVar.c());
            if (a.b() || !this.a.g.containsKey(tVar.c())) {
                tVar.a(a);
                return tVar;
            }
            tVar.a(new Status(17));
            return tVar;
        } catch (DeadObjectException e) {
            this.a.a(new ab(this, this));
        }
    }

    public final void a() {
    }

    public final void a(int i) {
        this.a.a(null);
        this.a.n.a(i);
    }

    public final void a(Bundle bundle) {
    }

    public final void a(ConnectionResult connectionResult, a aVar, int i) {
    }

    public final void b() {
        this.a.a(null);
    }

    public final void c() {
    }
}
