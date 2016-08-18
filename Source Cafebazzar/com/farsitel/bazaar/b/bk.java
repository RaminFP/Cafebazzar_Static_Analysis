package com.farsitel.bazaar.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class bk implements OnCancelListener {
    final /* synthetic */ bj a;

    bk(bj bjVar) {
        this.a = bjVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.e();
    }
}
