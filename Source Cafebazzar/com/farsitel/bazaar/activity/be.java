package com.farsitel.bazaar.activity;

import android.text.Editable;
import android.text.TextWatcher;

final class be implements TextWatcher {
    final /* synthetic */ EmailAuthenticationActivity a;

    be(EmailAuthenticationActivity emailAuthenticationActivity) {
        this.a = emailAuthenticationActivity;
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.length() == EmailAuthenticationActivity.a) {
            EmailAuthenticationActivity.g(this.a);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
