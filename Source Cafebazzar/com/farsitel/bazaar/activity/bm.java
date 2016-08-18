package com.farsitel.bazaar.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class bm implements OnEditorActionListener {
    final /* synthetic */ JoinActivity a;

    bm(JoinActivity joinActivity) {
        this.a = joinActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        this.a.b();
        return true;
    }
}
