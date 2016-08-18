package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.widget.o;

public final class bh extends y implements OnClickListener {
    private WebView a;
    private long b;
    private long c;
    private String d;
    private String e;
    private View f;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private TextView o;
    private View p;
    private View q;

    private void a() {
        Handler handler = new Handler();
        handler.postDelayed(new bl(this), 2100);
        handler.postDelayed(new bm(this), 2000);
    }

    public final void onClick(View view) {
        Animation oVar = new o(this.m, this.n);
        oVar.setDuration(300);
        oVar.a = false;
        a a;
        c cVar;
        switch (view.getId()) {
            case 2131624185:
                BazaarApplication.c().d();
                i.a("/KnowledgeBase/" + BazaarApplication.c().a.getLanguage() + "/folder/" + this.b + "/article/" + this.c + "/rate/sad/" + this.e);
                a = a.a();
                cVar = new c();
                cVar.c = "support";
                cVar.e = "article_rate";
                a.a(cVar.a("article_id", Long.valueOf(this.c)).b("rate", "sad"));
                this.o.setText(2131165657);
                this.o.setTextColor(getResources().getColor(2131558529));
                if (BazaarApplication.c().b()) {
                    this.o.setCompoundDrawablesWithIntrinsicBounds(0, 0, g.ic_face_sad, 0);
                } else {
                    this.o.setCompoundDrawablesWithIntrinsicBounds(g.ic_face_sad, 0, 0, 0);
                }
                this.p.startAnimation(oVar);
                a();
                return;
            case 2131624186:
                BazaarApplication.c().d();
                i.a("/KnowledgeBase/" + BazaarApplication.c().a.getLanguage() + "/folder/" + this.b + "/article/" + this.c + "/rate/satisfied/" + this.e);
                a = a.a();
                cVar = new c();
                cVar.c = "support";
                cVar.e = "article_rate";
                a.a(cVar.a("article_id", Long.valueOf(this.c)).b("rate", "satisfied"));
                this.o.setText(2131165658);
                this.o.setTextColor(getResources().getColor(2131558533));
                if (BazaarApplication.c().b()) {
                    this.o.setCompoundDrawablesWithIntrinsicBounds(0, 0, g.ic_face_satisfied, 0);
                } else {
                    this.o.setCompoundDrawablesWithIntrinsicBounds(g.ic_face_satisfied, 0, 0, 0);
                }
                this.p.startAnimation(oVar);
                a();
                return;
            case 2131624187:
                BazaarApplication.c().d();
                i.a("/KnowledgeBase/" + BazaarApplication.c().a.getLanguage() + "/folder/" + this.b + "/article/" + this.c + "/rate/happy/" + this.e);
                a = a.a();
                cVar = new c();
                cVar.c = "support";
                cVar.e = "article_rate";
                a.a(cVar.a("article_id", Long.valueOf(this.c)).b("rate", "happy"));
                this.o.setText(2131165656);
                this.o.setTextColor(getResources().getColor(2131558472));
                if (BazaarApplication.c().b()) {
                    this.o.setCompoundDrawablesWithIntrinsicBounds(0, 0, g.ic_face_happy, 0);
                } else {
                    this.o.setCompoundDrawablesWithIntrinsicBounds(g.ic_face_happy, 0, 0, 0);
                }
                this.p.startAnimation(oVar);
                a();
                return;
            default:
                return;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903082, viewGroup, false);
        this.a = (WebView) inflate.findViewById(2131624190);
        if (getArguments() != null) {
            this.b = getArguments().getLong("article_folder_id");
            this.c = getArguments().getLong("article_id");
            this.d = getArguments().getString("article_body");
            this.e = getArguments().getString("article_title");
        }
        this.a.getSettings().setDefaultTextEncodingName("utf-8");
        this.a.loadData(Base64.encodeToString(this.d.getBytes(), 0), "text/html; charset=utf-8", "base64");
        this.l = inflate.findViewById(2131624043);
        this.f = inflate.findViewById(2131624187);
        this.j = inflate.findViewById(2131624186);
        this.k = inflate.findViewById(2131624185);
        this.f.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p = inflate.findViewById(2131624183);
        this.q = inflate.findViewById(2131624182);
        this.m = inflate.findViewById(2131624184);
        this.n = inflate.findViewById(2131624188);
        this.o = (TextView) inflate.findViewById(2131624189);
        this.a.setWebViewClient(new bi(this));
        BazaarApplication.c().d();
        i.a("/KnowledgeBase/folder/" + this.b + "/article/" + this.c + "/" + this.e);
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(this.e);
    }
}
