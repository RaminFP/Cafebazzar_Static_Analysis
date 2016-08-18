package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class ai implements OnClickListener {
    final /* synthetic */ u a;

    ai(u uVar) {
        this.a = uVar;
    }

    public final void onClick(View view) {
        ((HomeActivity) this.a.getActivity()).a(new Intent("android.intent.action.VIEW", Uri.parse(this.a.u.k)), this.a.getDialog() != null, true);
    }
}
