package com.farsitel.bazaar.widget;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

final class c implements OnClickListener {
    final /* synthetic */ OnClickListener a;
    final /* synthetic */ b b;

    c(b bVar, OnClickListener onClickListener) {
        this.b = bVar;
        this.a = onClickListener;
    }

    public final void onClick(View view) {
        this.a.onClick(view);
        new Handler().postDelayed(new d(this), 500);
    }
}
