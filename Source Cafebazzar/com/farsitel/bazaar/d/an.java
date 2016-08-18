package com.farsitel.bazaar.d;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.widget.ak;
import com.farsitel.bazaar.widget.al;

final class an extends ak {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    public final al[] a() {
        ao aoVar = new ao(this);
        ap apVar = new ap(this);
        aq aqVar = new aq(this);
        if (BazaarApplication.c().b()) {
            return new al[]{aqVar, apVar, aoVar};
        }
        return new al[]{aoVar, apVar, aqVar};
    }
}
