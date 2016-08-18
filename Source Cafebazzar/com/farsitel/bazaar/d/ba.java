package com.farsitel.bazaar.d;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class ba implements OnEditorActionListener {
    final /* synthetic */ aw a;

    ba(aw awVar) {
        this.a = awVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        Editable text = this.a.a.getText();
        this.a.c(text != null ? text.toString() : null);
        return true;
    }
}
