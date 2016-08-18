package com.farsitel.bazaar.b;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.a;

final class ai implements OnClickListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ ag b;

    ai(ag agVar, Activity activity) {
        this.b = agVar;
        this.a = activity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setData(a.a(this.a.getPackageName(), "pardakht_old_bazaar"));
        this.a.startActivity(intent);
        this.b.e.dismiss();
    }
}
