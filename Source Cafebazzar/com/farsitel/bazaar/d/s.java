package com.farsitel.bazaar.d;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class s implements OnEditorActionListener {
    final /* synthetic */ a a;

    s(a aVar) {
        this.a = aVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        a.g(this.a);
        return true;
    }
}
