package com.farsitel.bazaar.b;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class ao implements OnEditorActionListener {
    final /* synthetic */ an a;

    ao(an anVar) {
        this.a = anVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        an.a(this.a);
        return true;
    }
}
