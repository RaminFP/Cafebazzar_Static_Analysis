package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

final class aj implements OnClickListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ ag b;

    aj(ag agVar, Activity activity) {
        this.b = agVar;
        this.a = activity;
    }

    public final void onClick(View view) {
        this.a.finish();
        this.b.e.dismiss();
    }
}
