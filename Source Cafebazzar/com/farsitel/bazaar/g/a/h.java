package com.farsitel.bazaar.g.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.activity.VideoPlayerActivity;

final class h implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ g b;

    h(g gVar, Context context) {
        this.b = gVar;
        this.a = context;
    }

    public final void onClick(View view) {
        VideoPlayerActivity.a(this.a, this.b.d, this.b.a, view);
    }
}
