package com.farsitel.bazaar.a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.g.e.e;

final class al implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ ak b;

    al(ak akVar, e eVar) {
        this.b = akVar;
        this.a = eVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.a.d + ((this.a.d.contains("?") ? "&" : "?") + "ref=" + this.b.d + "|" + this.a.e)));
        intent.putExtra("name", this.a.b);
        ((HomeActivity) this.b.b).a(intent, this.b.a.booleanValue(), false);
    }
}
