package com.farsitel.bazaar.d;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.congenialmobile.util.h;

final class bc implements TextWatcher {
    int a = this.d.getResources().getInteger(2131296256);
    int b = 21;
    int c = 19;
    final /* synthetic */ aw d;

    bc(aw awVar) {
        this.d = awVar;
    }

    public final void afterTextChanged(Editable editable) {
        this.d.b();
        if (TextUtils.isEmpty(editable)) {
            this.d.a.setGravity(this.a);
            this.d.k.setVisibility(0);
            this.d.l.setVisibility(8);
            return;
        }
        if (h.a(String.valueOf(editable.charAt(0)))) {
            this.d.a.setGravity(this.b);
        } else {
            this.d.a.setGravity(this.c);
        }
        this.d.k.setVisibility(8);
        this.d.l.setVisibility(0);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
