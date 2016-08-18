package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.g.e.e;

final class z implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ String b;
    final /* synthetic */ u c;

    z(u uVar, e eVar, String str) {
        this.c = uVar;
        this.a = eVar;
        this.b = str;
    }

    public final void onClick(View view) {
        if (!TextUtils.isEmpty(this.a.d)) {
            ((HomeActivity) this.c.getActivity()).a(new Intent("android.intent.action.VIEW", Uri.parse(this.a.d + ((this.a.d.contains("?") ? "&" : "?") + "ref=" + this.b + "|" + this.a.e))), this.c.getDialog() != null, false);
        }
    }
}
