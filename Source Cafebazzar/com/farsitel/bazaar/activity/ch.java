package com.farsitel.bazaar.activity;

import android.view.View;
import android.view.View.OnClickListener;

final class ch implements OnClickListener {
    final /* synthetic */ ScreenshotActivity a;

    ch(ScreenshotActivity screenshotActivity) {
        this.a = screenshotActivity;
    }

    public final void onClick(View view) {
        ScreenshotActivity.h(this.a);
    }
}
