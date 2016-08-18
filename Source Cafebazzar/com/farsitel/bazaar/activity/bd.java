package com.farsitel.bazaar.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class bd implements OnEditorActionListener {
    final /* synthetic */ EmailAuthenticationActivity a;

    bd(EmailAuthenticationActivity emailAuthenticationActivity) {
        this.a = emailAuthenticationActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            EmailAuthenticationActivity.g(this.a);
        }
        return true;
    }
}
