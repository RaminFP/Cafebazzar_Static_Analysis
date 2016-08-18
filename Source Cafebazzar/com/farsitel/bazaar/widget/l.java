package com.farsitel.bazaar.widget;

import android.text.format.DateUtils;
import android.widget.TextView;

final class l {
    TextView a;
    int b;
    final /* synthetic */ h c;

    private l(h hVar, TextView textView) {
        this.c = hVar;
        this.b = -1;
        this.a = textView;
        a(0);
    }

    public final void a(long j) {
        int i = (int) (j / 1000);
        if (this.b != i) {
            this.b = i;
            this.a.setText(DateUtils.formatElapsedTime((long) this.b));
        }
    }
}
