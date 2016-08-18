package com.a.a.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class q implements OnClickListener {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.b.a(false);
        dialogInterface.dismiss();
    }
}
