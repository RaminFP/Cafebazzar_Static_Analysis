package com.farsitel.bazaar.b;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class ad implements OnEditorActionListener {
    final /* synthetic */ ab a;

    ad(ab abVar) {
        this.a = abVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        ab.c(this.a);
        return true;
    }
}
