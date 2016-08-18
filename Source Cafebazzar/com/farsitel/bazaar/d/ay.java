package com.farsitel.bazaar.d;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;

final class ay implements OnClickListener {
    final /* synthetic */ aw a;

    ay(aw awVar) {
        this.a = awVar;
    }

    public final void onClick(View view) {
        Editable text = this.a.a.getText();
        this.a.c(text != null ? text.toString() : null);
    }
}
