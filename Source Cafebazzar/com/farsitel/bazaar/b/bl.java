package com.farsitel.bazaar.b;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class bl implements OnCheckedChangeListener {
    final /* synthetic */ bj a;

    bl(bj bjVar) {
        this.a = bjVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.a(z);
    }
}
