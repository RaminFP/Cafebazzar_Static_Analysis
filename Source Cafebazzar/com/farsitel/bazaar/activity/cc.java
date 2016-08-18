package com.farsitel.bazaar.activity;

import android.view.View;
import android.view.View.OnClickListener;

final class cc implements OnClickListener {
    final /* synthetic */ ReviewActivity a;

    cc(ReviewActivity reviewActivity) {
        this.a = reviewActivity;
    }

    public final void onClick(View view) {
        ReviewActivity.b(this.a);
    }
}
