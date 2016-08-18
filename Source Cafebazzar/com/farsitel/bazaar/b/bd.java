package com.farsitel.bazaar.b;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.a.a;
import com.farsitel.bazaar.util.af;

public final class bd extends m {
    public bd(Activity activity, a aVar) {
        super(activity, e.b(activity.getString(2131165229, new Object[]{String.valueOf(aVar.k)})), true);
        View inflate = LayoutInflater.from(activity).inflate(2130903069, null);
        if (aVar.j > 0.0f) {
            View findViewById = inflate.findViewById(2131624091);
            View findViewById2 = inflate.findViewById(2131624092);
            View findViewById3 = inflate.findViewById(2131624093);
            View findViewById4 = inflate.findViewById(2131624094);
            View findViewById5 = inflate.findViewById(2131624095);
            TextView textView = (TextView) findViewById2.findViewById(2131624395);
            TextView textView2 = (TextView) findViewById3.findViewById(2131624395);
            TextView textView3 = (TextView) findViewById4.findViewById(2131624395);
            TextView textView4 = (TextView) findViewById5.findViewById(2131624395);
            ((TextView) findViewById.findViewById(2131624395)).setText(activity.getString(2131165388));
            textView.setText(activity.getString(2131165391));
            textView2.setText(activity.getString(2131165693));
            textView3.setText(activity.getString(2131165702));
            textView4.setText(activity.getString(2131165484));
            ProgressBar progressBar = (ProgressBar) findViewById.findViewById(2131624396);
            ProgressBar progressBar2 = (ProgressBar) findViewById2.findViewById(2131624396);
            ProgressBar progressBar3 = (ProgressBar) findViewById3.findViewById(2131624396);
            ProgressBar progressBar4 = (ProgressBar) findViewById4.findViewById(2131624396);
            ProgressBar progressBar5 = (ProgressBar) findViewById5.findViewById(2131624396);
            int max = Math.max(aVar.l, Math.max(aVar.m, Math.max(aVar.n, Math.max(aVar.o, aVar.p))));
            progressBar.setMax(max);
            progressBar2.setMax(max);
            progressBar3.setMax(max);
            progressBar4.setMax(max);
            progressBar5.setMax(max);
            if (VERSION.SDK_INT >= 11) {
                progressBar.setProgressDrawable(activity.getResources().getDrawable(g.rate_bar_style_5));
                progressBar2.setProgressDrawable(activity.getResources().getDrawable(g.rate_bar_style_4));
                progressBar3.setProgressDrawable(activity.getResources().getDrawable(g.rate_bar_style_3));
                progressBar4.setProgressDrawable(activity.getResources().getDrawable(g.rate_bar_style_2));
                progressBar5.setProgressDrawable(activity.getResources().getDrawable(g.rate_bar_style_1));
            }
            progressBar.setProgress(aVar.p);
            progressBar2.setProgress(aVar.o);
            progressBar3.setProgress(aVar.n);
            progressBar4.setProgress(aVar.m);
            progressBar5.setProgress(aVar.l);
        }
        a(17170443);
        a(inflate);
        a(2131165482, new be(this));
        af afVar = af.INSTANCE;
        if (af.c(aVar.g())) {
            b(2131165797, new bf(this, aVar));
        }
    }
}
