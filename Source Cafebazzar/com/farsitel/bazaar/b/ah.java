package com.farsitel.bazaar.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class ah implements OnCancelListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ ag b;

    ah(ag agVar, Activity activity) {
        this.b = agVar;
        this.a = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
        this.b.e.dismiss();
    }
}
