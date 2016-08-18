package com.farsitel.bazaar.d;

import android.text.Editable;
import android.text.TextWatcher;
import com.congenialmobile.util.e;

final class bu implements TextWatcher {
    final /* synthetic */ bs a;

    bu(bs bsVar) {
        this.a = bsVar;
    }

    public final void afterTextChanged(Editable editable) {
        if (1000 - editable.length() < 40) {
            this.a.f.setVisibility(0);
            if (editable.length() <= 1000) {
                this.a.f.setText(e.b(String.valueOf(1000 - editable.length())));
                return;
            } else {
                editable.delete(1000, editable.length());
                return;
            }
        }
        this.a.f.setVisibility(4);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
