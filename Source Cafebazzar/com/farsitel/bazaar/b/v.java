package com.farsitel.bazaar.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class v implements OnCancelListener {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.e();
    }
}
