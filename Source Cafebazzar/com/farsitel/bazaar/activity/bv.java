package com.farsitel.bazaar.activity;

import android.view.View;
import android.view.View.OnClickListener;

final class bv implements OnClickListener {
    final /* synthetic */ br a;

    bv(br brVar) {
        this.a = brVar;
    }

    public final void onClick(View view) {
        new bz(this.a.getActivity()).e.show();
    }
}
