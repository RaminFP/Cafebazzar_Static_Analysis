package com.farsitel.bazaar.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.b.au;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.c;

final class az implements OnClickListener {
    final /* synthetic */ aw a;

    az(aw awVar) {
        this.a = awVar;
    }

    public final void onClick(View view) {
        if (j.a().n()) {
            new au(this.a.getActivity()).e.show();
            return;
        }
        Intent intent = new Intent(this.a.getActivity(), JoinActivity.class);
        intent.putExtra("extra_referer", "app-request");
        intent.putExtra("android.intent.extra.TITLE", this.a.getString(2131165587));
        c.a(this.a.getActivity(), intent, 40002, view);
    }
}
