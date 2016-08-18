package com.farsitel.bazaar.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.farsitel.bazaar.d.ai;
import com.farsitel.bazaar.d.aj;

final class bh implements OnGlobalLayoutListener {
    final /* synthetic */ Intent a;
    final /* synthetic */ HomeActivity b;

    bh(HomeActivity homeActivity, Intent intent) {
        this.b = homeActivity;
        this.a = intent;
    }

    @SuppressLint({"NewApi"})
    public final void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.b.findViewById(2131624115).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.b.findViewById(2131624115).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        aj a = this.b.a;
        ai aiVar = a.b[this.b.b];
        if (aiVar.getChildFragmentManager().getFragments() != null) {
            for (Fragment fragment : aiVar.getChildFragmentManager().getFragments()) {
                if (!(fragment == null || fragment.getTag() == null || !fragment.getTag().equals("dialog_fragment"))) {
                    ((DialogFragment) fragment).dismiss();
                }
            }
        }
        this.b.g = true;
        this.b.a(this.a, false, true);
        this.b.h = 0;
    }
}
