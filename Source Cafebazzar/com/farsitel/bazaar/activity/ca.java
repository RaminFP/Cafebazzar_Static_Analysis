package com.farsitel.bazaar.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.i;

public final class ca extends y {
    private static final BazaarApplication a = BazaarApplication.c();

    public static ca a() {
        return new ca();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        a.a(configuration);
        super.onConfigurationChanged(configuration);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903077, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(2131624139);
        textView.setText(Html.fromHtml(getString(2131165476)));
        Linkify.addLinks(textView, 15);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return inflate;
    }

    public final void onStart() {
        super.onStart();
        a.d();
        i.a("/Notes");
    }
}
