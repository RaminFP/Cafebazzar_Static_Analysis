package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.widget.ak;
import com.farsitel.bazaar.widget.al;

final class dq extends ak {
    final /* synthetic */ dp a;

    dq(dp dpVar) {
        this.a = dpVar;
    }

    public final al[] a() {
        al[] alVarArr = new al[this.a.d.a.length];
        for (int i = 0; i < this.a.d.a.length; i++) {
            alVarArr[i] = new dr(this, i);
        }
        return alVarArr;
    }
}
