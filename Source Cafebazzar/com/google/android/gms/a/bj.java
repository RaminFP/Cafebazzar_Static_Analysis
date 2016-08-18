package com.google.android.gms.a;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.l;

public final class bj implements l {
    public final int a;
    public final h b;
    public final l c;
    final /* synthetic */ bi d;

    public bj(bi biVar, int i, h hVar, l lVar) {
        this.d = biVar;
        this.a = i;
        this.b = hVar;
        this.c = lVar;
        hVar.a((l) this);
    }

    public final void a(ConnectionResult connectionResult) {
        this.d.g.post(new bk(this.d, this.a, connectionResult));
    }
}
