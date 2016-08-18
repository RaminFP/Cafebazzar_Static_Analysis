package com.farsitel.bazaar.activity;

import android.text.Editable;
import android.text.TextWatcher;

final class dg implements TextWatcher {
    final /* synthetic */ SmsAuthenticationActivity a;

    dg(SmsAuthenticationActivity smsAuthenticationActivity) {
        this.a = smsAuthenticationActivity;
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.length() == SmsAuthenticationActivity.a) {
            this.a.b();
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
