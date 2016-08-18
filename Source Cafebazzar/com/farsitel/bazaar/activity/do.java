package com.farsitel.bazaar.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class do extends WebViewClient {
    final /* synthetic */ TermsActivity a;

    do(TermsActivity termsActivity) {
        this.a = termsActivity;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a.a.setVisibility(0);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return false;
    }
}
