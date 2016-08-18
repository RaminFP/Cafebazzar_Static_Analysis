package com.farsitel.bazaar.d;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.congenialmobile.util.a;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.ax;

public final class cb extends y {
    private WebView a;
    private View b;
    private String c;
    private String d;
    private boolean e;

    public static cb a(Intent intent) {
        cb cbVar = new cb();
        Bundle bundle = new Bundle();
        if (intent.getExtras() == null || !intent.getExtras().containsKey("url")) {
            String queryParameter = intent.getData().getQueryParameter("url");
            if (queryParameter != null) {
                bundle.putString("url", queryParameter);
                bundle.putString("title", intent.getData().getQueryParameter("title"));
                bundle.putBoolean("login", ax.a(intent.getData().getQueryParameter("login"), false));
                bundle.putBoolean("is_internal", ax.a(intent.getData().getQueryParameter("is_internal"), true));
            }
        } else {
            bundle = intent.getExtras();
        }
        cbVar.setArguments(bundle);
        return cbVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903087, viewGroup, false);
        if (getArguments() == null || !getArguments().containsKey("url")) {
            getActivity().onBackPressed();
            return inflate;
        }
        this.c = getArguments().getString("url");
        if (getArguments().getBoolean("login")) {
            if (j.a().n()) {
                this.c = String.format(this.c, new Object[]{Uri.encode(a.a(j.a().b.getBytes()))});
            } else {
                this.c = String.format(this.c, new Object[]{""});
            }
        }
        if (getArguments().containsKey("title")) {
            this.d = getArguments().getString("title");
        }
        this.e = getArguments().getBoolean("is_internal", true);
        this.b = inflate.findViewById(2131624043);
        this.a = (WebView) inflate.findViewById(2131624190);
        this.a.setDrawingCacheEnabled(true);
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.setWebViewClient(new cc(this));
        if (getArguments().getString("post_data") != null) {
            this.a.postUrl(this.c, getArguments().getString("post_data").getBytes());
        } else {
            this.a.loadUrl(this.c);
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        a(this.d);
        if (this.e) {
            j();
        } else {
            a((int) g.ic_action_open_in_browser, new cd(this));
        }
    }
}
