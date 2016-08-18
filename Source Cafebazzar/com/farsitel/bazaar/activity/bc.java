package com.farsitel.bazaar.activity;

import android.view.View;
import android.view.View.OnClickListener;

final class bc implements OnClickListener {
    final /* synthetic */ EmailAuthenticationActivity a;

    bc(EmailAuthenticationActivity emailAuthenticationActivity) {
        this.a = emailAuthenticationActivity;
    }

    public final void onClick(View view) {
        EmailAuthenticationActivity.g(this.a);
    }
}
