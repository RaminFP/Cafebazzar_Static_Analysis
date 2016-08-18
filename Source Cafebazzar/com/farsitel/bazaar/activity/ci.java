package com.farsitel.bazaar.activity;

import android.view.View;
import android.view.View.OnClickListener;

final class ci implements OnClickListener {
    final /* synthetic */ ScreenshotActivity a;

    ci(ScreenshotActivity screenshotActivity) {
        this.a = screenshotActivity;
    }

    public final void onClick(View view) {
        ScreenshotActivity.i(this.a);
    }
}
