package com.farsitel.bazaar.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.b.m;

final class bw implements OnClickListener {
    final /* synthetic */ br a;

    bw(br brVar) {
        this.a = brVar;
    }

    public final void onClick(View view) {
        m byVar = new by(this.a.getActivity());
        byVar.g = new bx(this);
        byVar.e.show();
    }
}
