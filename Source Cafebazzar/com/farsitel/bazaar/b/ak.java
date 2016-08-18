package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

final class ak implements OnClickListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ ag b;

    ak(ag agVar, Activity activity) {
        this.b = agVar;
        this.a = activity;
    }

    public final void onClick(View view) {
        this.a.finish();
        this.b.e.dismiss();
    }
}
