package com.farsitel.bazaar.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.ReviewActivity;
import com.farsitel.bazaar.g.a.a;

final class bf implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ bd b;

    bf(bd bdVar, a aVar) {
        this.b = bdVar;
        this.a = aVar;
    }

    public final void onClick(View view) {
        ReviewActivity.a(this.b.f, 40005, this.a.g());
        this.b.e.dismiss();
    }
}
