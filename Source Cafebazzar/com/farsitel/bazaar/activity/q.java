package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.d.cb;

final class q implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    q(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("bazaar://webview?title=" + this.b.e.h() + "&url" + "=" + Uri.parse(this.a) + "&is_internal" + "=false"));
        ((HomeActivity) this.b.getActivity()).a(cb.a(intent), this.b.getDialog() != null);
    }
}
