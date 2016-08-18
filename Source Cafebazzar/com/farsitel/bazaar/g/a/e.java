package com.farsitel.bazaar.g.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.ScreenshotActivity;
import com.farsitel.bazaar.util.c;

final class e implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ d b;

    e(d dVar, Context context) {
        this.b = dVar;
        this.a = context;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.a, ScreenshotActivity.class);
        intent.putExtras(this.b.c);
        c.a(this.a, intent, view);
    }
}
