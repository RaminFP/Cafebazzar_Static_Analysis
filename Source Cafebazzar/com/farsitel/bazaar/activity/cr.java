package com.farsitel.bazaar.activity;

import android.widget.Toast;

final class cr implements Runnable {
    final /* synthetic */ cq a;

    cr(cq cqVar) {
        this.a = cqVar;
    }

    public final void run() {
        Toast.makeText(this.a.a.a.getActivity(), this.a.a.a.getActivity().getResources().getText(2131165475), 1).show();
        this.a.a.a.r.setChecked(false);
    }
}
