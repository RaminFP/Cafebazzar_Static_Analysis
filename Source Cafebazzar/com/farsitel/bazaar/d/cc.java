package com.farsitel.bazaar.d;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.i;

final class cc extends WebViewClient {
    final /* synthetic */ cb a;

    cc(cb cbVar) {
        this.a = cbVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.a.setVisibility(0);
        this.a.b.setVisibility(8);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        BazaarApplication.c().d();
        i.a("/WebView/" + str);
        this.a.b.setVisibility(0);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.contains("bazaar://")) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            ((HomeActivity) this.a.getActivity()).a(intent, this.a.getDialog() != null, false);
            return true;
        }
        webView.loadUrl(str);
        return false;
    }
}
