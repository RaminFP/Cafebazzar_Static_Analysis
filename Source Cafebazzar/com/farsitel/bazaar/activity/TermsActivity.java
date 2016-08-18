package com.farsitel.bazaar.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class TermsActivity extends s {
    ProgressBar a;
    WebView b;
    String c;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903085);
        this.c = getIntent().getData().getQueryParameter("url");
        if (this.c == null) {
            finish();
        }
        this.a = (ProgressBar) findViewById(2131624043);
        this.b = (WebView) findViewById(2131624190);
        this.b.setDrawingCacheEnabled(true);
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.setWebViewClient(new do(this));
        this.b.loadUrl(this.c);
    }
}
