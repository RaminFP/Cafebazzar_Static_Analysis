package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;

final class dj extends v {
    final /* synthetic */ SmsAuthenticationActivity a;

    private dj(SmsAuthenticationActivity smsAuthenticationActivity) {
        this.a = smsAuthenticationActivity;
    }

    public final void a(c cVar) {
        this.a.h.setText(cVar.b == 10000 ? 2131165452 : 2131165374);
        this.a.h.setTextColor(this.a.getResources().getColor(2131558529));
    }

    public final /* synthetic */ void a(Object obj) {
        this.a.a();
    }
}
