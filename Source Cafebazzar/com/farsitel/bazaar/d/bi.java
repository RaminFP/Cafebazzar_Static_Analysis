package com.farsitel.bazaar.d;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class bi extends WebViewClient {
    final /* synthetic */ bh a;

    bi(bh bhVar) {
        this.a = bhVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.l.setVisibility(8);
        this.a.p.postDelayed(new bj(this), 3500);
        this.a.q.postDelayed(new bk(this), 3000);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a.l.setVisibility(0);
    }
}
