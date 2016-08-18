package com.farsitel.bazaar.d;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.util.c;

final class cd implements OnClickListener {
    final /* synthetic */ cb a;

    cd(cb cbVar) {
        this.a = cbVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.a.c));
        c.a(this.a.getActivity(), intent, view);
    }
}
