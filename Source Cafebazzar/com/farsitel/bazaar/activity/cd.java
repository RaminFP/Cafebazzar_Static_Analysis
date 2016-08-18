package com.farsitel.bazaar.activity;

import android.view.View;
import android.view.View.OnClickListener;

final class cd implements OnClickListener {
    final /* synthetic */ ReviewActivity a;

    cd(ReviewActivity reviewActivity) {
        this.a = reviewActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
    }
}
