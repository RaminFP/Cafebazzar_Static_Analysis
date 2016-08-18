package com.farsitel.bazaar.d;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.b.an;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.a.d;
import com.farsitel.bazaar.h.a.e;
import com.farsitel.bazaar.h.a.n;
import com.farsitel.bazaar.h.b.f;
import com.farsitel.bazaar.h.b.p;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.ag;
import com.farsitel.bazaar.util.g;
import ir.cafebazaar.pardakht.AuthenticateActivity;

public final class a extends y implements OnClickListener {
    private ProgressDialog A;
    private Handler B = new Handler();
    private int a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private EditText f;
    private View j;
    private EditText k;
    private TextView l;
    private Button m;
    private View n;
    private View o;
    private b p = new b(this);
    private b q = new k(this);
    private TextView r;
    private RelativeLayout s;
    private RelativeLayout t;
    private RelativeLayout u;
    private TextView v;
    private View w;
    private an x;
    private long y;
    private View z;

    public static a a() {
        return new a();
    }

    private void b() {
        if (j.a().n()) {
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            this.v.setText(getString(2131165339, Long.valueOf(j.a().c() / 10)));
            this.y = j.a().c();
        } else {
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        }
        this.d.setText(j.a().i() ? getString(2131165241) + " " + j.a().g() : getString(2131165631));
        this.e.setText(j.a().j() ? getString(2131165244) + " " + j.a().f() : getString(2131165632));
        this.f.setText("");
        this.k.setText("");
        String k = j.a().k();
        if (k == null || k.equals("")) {
            k = getString(2131165472);
        }
        this.r.setText(getString(2131165459, k));
        ((View) this.r.getParent()).setOnClickListener(new n(this));
        this.z.setOnClickListener(new p(this));
        this.A = new ProgressDialog(getActivity());
        this.A.setMessage(getString(2131165546));
        this.A.setCancelable(false);
        switch (this.a) {
            case 0:
                this.f.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                this.b.setVisibility(0);
                this.n.setVisibility(0);
                this.o.setVisibility(8);
                if (j.a().b()) {
                    this.b.setText(2131165731);
                    this.b.setOnClickListener(new r(this));
                    return;
                }
                this.b.setText(2131165752);
                this.b.setOnClickListener(new q(this));
                return;
            case 1:
                this.f.setVisibility(8);
                this.j.setVisibility(8);
                this.l.setText(2131165753);
                g.a(getActivity(), this.k, 1.0f);
                this.k.setVisibility(0);
                g.a(getActivity(), this.l, 1.0f);
                this.l.setVisibility(0);
                g.a(getActivity(), this.m, 2.0f);
                this.m.setVisibility(0);
                g.b(getActivity(), this.b, 0.0f);
                this.m.setText(2131165353);
                this.b.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(0);
                this.k.setOnEditorActionListener(new s(this));
                this.m.setOnClickListener(new t(this));
                return;
            case 2:
                this.l.setText(2131165744);
                this.m.setText(2131165731);
                g.a(getActivity(), this.f, 0.0f);
                this.f.setVisibility(0);
                g.a(getActivity(), this.j, 0.0f);
                this.j.setVisibility(0);
                g.a(getActivity(), this.k, 1.0f);
                this.k.setVisibility(0);
                g.a(getActivity(), this.l, 1.0f);
                this.l.setVisibility(0);
                g.a(getActivity(), this.m, 2.0f);
                this.m.setVisibility(0);
                g.b(getActivity(), this.b, 0.0f);
                this.b.setVisibility(8);
                this.n.setVisibility(8);
                this.o.setVisibility(0);
                this.k.setOnEditorActionListener(new d(this));
                this.m.setOnClickListener(new e(this));
                return;
            default:
                return;
        }
    }

    private void b(String str) {
        this.c.setText(str);
        this.c.setBackgroundResource(2131558529);
        this.c.startAnimation(AnimationUtils.loadAnimation(getActivity(), 2130968594));
        this.c.setVisibility(0);
    }

    private void c() {
        long c = j.a().c() - this.y;
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "buy_credit";
        a.a(cVar.b("action", "success").b("amount", Long.valueOf(c)));
        this.y = j.a().c();
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setStartOffset(1000);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new f(this, c));
        this.v.startAnimation(alphaAnimation);
    }

    static /* synthetic */ void g(a aVar) {
        ag.a(aVar.getActivity(), aVar.getView().getWindowToken());
        String obj = aVar.k.getText().toString();
        if (obj.length() == 0) {
            aVar.b(aVar.getString(2131165307));
        } else if (obj.length() < 6) {
            aVar.b(aVar.getString(2131165698));
        } else {
            aVar.c.setVisibility(8);
            aVar.A.show();
            if (j.a().b != null) {
                com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
                c cVar = new c();
                cVar.c = "account_settings_frag";
                cVar.e = "set_password";
                a.a(cVar.b("action", "request"));
                new n(obj).a(aVar.q);
                BazaarApplication.c().d();
                i.a("/SetPassword");
                return;
            }
            aVar.b(aVar.getString(2131165437));
        }
    }

    static /* synthetic */ void h(a aVar) {
        ag.a(aVar.getActivity(), aVar.getView().getWindowToken());
        String obj = aVar.f.getText().toString();
        String obj2 = aVar.k.getText().toString();
        if (obj.length() < 6) {
            aVar.b(aVar.getString(2131165734));
        } else if (obj2.length() == 0) {
            aVar.b(aVar.getString(2131165307));
        } else if (obj2.length() < 6) {
            aVar.b(aVar.getString(2131165698));
        } else if (obj2.equals(obj)) {
            aVar.b(aVar.getString(2131165608));
        } else {
            aVar.c.setVisibility(8);
            aVar.A.show();
            if (j.a().b != null) {
                com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
                c cVar = new c();
                cVar.c = "account_settings_frag";
                cVar.e = "change_password";
                a.a(cVar.b("action", "request"));
                b bVar = aVar.p;
                d dVar = new d(obj, obj2);
                dVar.d = bVar;
                com.farsitel.bazaar.h.d.INSTANCE.a(new e(dVar), new f(), dVar.a(dVar.b, dVar.c));
                BazaarApplication.c().d();
                i.a("/ChangePassword");
                return;
            }
            aVar.b(aVar.getString(2131165437));
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.farsitel.bazaar.g.a a;
        c cVar;
        switch (i) {
            case 14:
                if (i2 == -1) {
                    Toast.makeText(getActivity(), 2131165314, 0).show();
                    Intent intent2 = new Intent(getActivity(), AuthenticateActivity.class);
                    intent2.putExtra("request_type", "increase_only");
                    startActivity(intent2);
                    c();
                    return;
                } else if (i2 == 0) {
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new c();
                    cVar.c = "account_settings_frag";
                    cVar.e = "buy_credit";
                    a.a(cVar.b("action", "failed"));
                    Toast.makeText(getActivity(), 2131165519, 0).show();
                    return;
                } else {
                    return;
                }
            case 55:
                if (i2 == -1) {
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new c();
                    cVar.c = "account_settings_frag";
                    cVar.e = "change_email";
                    a.a(cVar.b("action", "verified"));
                    Toast.makeText(getActivity(), 2131165361, 0).show();
                    b();
                    return;
                }
                return;
            case 56:
                if (i2 == -1) {
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new c();
                    cVar.c = "account_settings_frag";
                    cVar.e = "change_phone";
                    a.a(cVar.b("action", "verified"));
                    Toast.makeText(getActivity(), 2131165539, 0).show();
                    b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void onClick(View view) {
        com.farsitel.bazaar.g.a a;
        c cVar;
        m aVar;
        switch (view.getId()) {
            case 2131624272:
                if (j.a().i()) {
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new c();
                    cVar.c = "account_settings_frag";
                    cVar.e = "add_email";
                    a.a(cVar.b("action", "request"));
                    return;
                }
                a = com.farsitel.bazaar.g.a.a();
                cVar = new c();
                cVar.c = "account_settings_frag";
                cVar.e = "add_email";
                a.a(cVar.b("action", "request"));
                aVar = new com.farsitel.bazaar.b.a(getActivity());
                aVar.g = new h(this);
                aVar.e.show();
                return;
            case 2131624273:
                if (j.a().j()) {
                    a = com.farsitel.bazaar.g.a.a();
                    cVar = new c();
                    cVar.c = "account_settings_frag";
                    cVar.e = "change_phone";
                    a.a(cVar.b("action", "request"));
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("bazaar://change_phone"));
                    ((HomeActivity) getActivity()).a(intent, getDialog() != null, false);
                    return;
                }
                a = com.farsitel.bazaar.g.a.a();
                cVar = new c();
                cVar.c = "account_settings_frag";
                cVar.e = "add_phone";
                a.a(cVar.b("action", "request"));
                aVar = new com.farsitel.bazaar.b.e(getActivity());
                aVar.g = new i(this);
                aVar.e.show();
                return;
            case 2131624307:
                a = com.farsitel.bazaar.g.a.a();
                cVar = new c();
                cVar.c = "account_settings_frag";
                cVar.e = "redeem";
                a.a(cVar.b("action", "request"));
                this.x = new an(getActivity());
                this.x.g = new j(this);
                this.x.e.show();
                BazaarApplication.c().d();
                i.a("/Account/Redeem/EnterCode");
                return;
            case 2131624309:
                a = com.farsitel.bazaar.g.a.a();
                cVar = new c();
                cVar.c = "account_settings_frag";
                cVar.e = "buy_credit";
                a.a(cVar.b("action", "request"));
                Intent intent2 = new Intent("ir.cafebazaar.intent.action.PAY");
                intent2.setPackage(BazaarApplication.c().getPackageName());
                intent2.setData(Uri.parse("bazaar://pardakht/v1/buy_credit/"));
                intent2.putExtra("PARDAKHT_PACKAGE_NAME", BazaarApplication.c().getPackageName());
                getActivity().startActivityForResult(intent2, 14);
                BazaarApplication.c().d();
                i.b("/Account/BuyCredit");
                return;
            default:
                return;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903108, null);
        this.a = 0;
        this.d = (TextView) inflate.findViewById(2131624272);
        this.d.setOnClickListener(this);
        this.e = (TextView) inflate.findViewById(2131624273);
        this.e.setOnClickListener(this);
        this.b = (TextView) inflate.findViewById(2131624275);
        this.c = (TextView) inflate.findViewById(2131624274);
        this.f = (EditText) inflate.findViewById(2131624277);
        this.j = inflate.findViewById(2131624276);
        this.k = (EditText) inflate.findViewById(2131624279);
        this.l = (TextView) inflate.findViewById(2131624278);
        this.m = (Button) inflate.findViewById(2131624280);
        this.n = inflate.findViewById(2131624281);
        this.o = inflate.findViewById(2131624282);
        this.r = (TextView) inflate.findViewById(2131624285);
        this.z = inflate.findViewById(2131624283);
        this.v = (TextView) inflate.findViewById(2131624304);
        this.w = inflate.findViewById(2131624306);
        this.s = (RelativeLayout) inflate.findViewById(2131624302);
        this.t = (RelativeLayout) inflate.findViewById(2131624307);
        this.t.setOnClickListener(this);
        this.u = (RelativeLayout) inflate.findViewById(2131624309);
        this.u.setOnClickListener(this);
        this.A = new ProgressDialog(getActivity());
        this.A.setMessage(getString(2131165546));
        this.A.setCancelable(false);
        b();
        this.y = j.a().c();
        if (bundle == null) {
            this.w.setVisibility(0);
            com.farsitel.bazaar.h.d.INSTANCE.a(new m(this), new p(), j.a().d());
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        if (j.a().n()) {
            a(getString(2131165249));
        }
    }
}
