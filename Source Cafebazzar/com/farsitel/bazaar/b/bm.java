package com.farsitel.bazaar.b;

import android.view.View;
import android.view.View.OnClickListener;

final class bm implements OnClickListener {
    final /* synthetic */ bj a;

    bm(bj bjVar) {
        this.a = bjVar;
    }

    public final void onClick(View view) {
        this.a.d();
        this.a.e.dismiss();
    }
}
