package com.congenialmobile.util;

import android.view.View;
import android.view.View.OnClickListener;

final class i implements OnClickListener {
    final /* synthetic */ WhatsNewActivity a;

    i(WhatsNewActivity whatsNewActivity) {
        this.a = whatsNewActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
    }
}
