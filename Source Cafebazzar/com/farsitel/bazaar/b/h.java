package com.farsitel.bazaar.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class h implements OnDismissListener {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.a.d) {
            this.a.d();
        } else {
            this.a.e();
        }
    }
}
