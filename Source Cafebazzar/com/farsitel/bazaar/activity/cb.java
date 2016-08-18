package com.farsitel.bazaar.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.congenialmobile.util.e;

final class cb implements TextWatcher {
    final /* synthetic */ ReviewActivity a;

    cb(ReviewActivity reviewActivity) {
        this.a = reviewActivity;
    }

    public final void afterTextChanged(Editable editable) {
        int length = 140 - editable.toString().length();
        if (length < 20) {
            this.a.f.setText(e.b(String.valueOf(length)));
            this.a.f.setVisibility(0);
            return;
        }
        this.a.f.setVisibility(4);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
