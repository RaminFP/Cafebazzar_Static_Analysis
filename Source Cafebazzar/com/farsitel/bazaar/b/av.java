package com.farsitel.bazaar.b;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class av implements OnEditorActionListener {
    final /* synthetic */ au a;

    av(au auVar) {
        this.a = auVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        au.a(this.a);
        return true;
    }
}
