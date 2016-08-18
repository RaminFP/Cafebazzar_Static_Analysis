package com.farsitel.bazaar.a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.g.e.f;

final class ad implements OnClickListener {
    final /* synthetic */ f a;
    final /* synthetic */ ac b;

    ad(ac acVar, f fVar) {
        this.b = acVar;
        this.a = fVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.a.e + "&title" + "=" + this.a.b + "&ref=" + this.b.g + "|" + this.a.f));
        ((HomeActivity) this.b.b).a(intent, this.b.f, false);
    }
}
