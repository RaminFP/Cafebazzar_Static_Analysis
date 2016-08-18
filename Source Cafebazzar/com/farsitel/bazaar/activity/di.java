package com.farsitel.bazaar.activity;

import android.app.Activity;
import com.farsitel.bazaar.b.o;

final class di extends o {
    final /* synthetic */ SmsAuthenticationActivity a;

    di(SmsAuthenticationActivity smsAuthenticationActivity, Activity activity, int i, int i2, int i3, int i4, boolean z) {
        this.a = smsAuthenticationActivity;
        super(activity, 2131165778, 2131165801, 0, 2131165463, true);
    }

    public final void a() {
        this.e.dismiss();
        super.onBackPressed();
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
