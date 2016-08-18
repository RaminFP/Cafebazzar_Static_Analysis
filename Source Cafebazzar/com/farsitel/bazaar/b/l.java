package com.farsitel.bazaar.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class l implements OnCancelListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.e();
    }
}
