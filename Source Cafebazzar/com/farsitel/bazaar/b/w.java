package com.farsitel.bazaar.b;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

final class w implements OnCheckedChangeListener {
    final /* synthetic */ u a;

    w(u uVar) {
        this.a = uVar;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.a.a(true);
    }
}
