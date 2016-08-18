package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.a.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.a.a.a.s;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.c.b.a;
import com.farsitel.bazaar.d.am;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.receiver.b;
import com.farsitel.bazaar.receiver.c;
import com.farsitel.bazaar.receiver.d;
import com.farsitel.bazaar.receiver.h;
import com.farsitel.bazaar.util.x;
import com.farsitel.bazaar.widget.HeaderGridView;

public final class br extends y implements OnClickListener, OnItemClickListener, c {
    private static final BazaarApplication a = BazaarApplication.c();
    private ax b;
    private AbsListView c;
    private TextView d;
    private View e;
    private View f;
    private b j;
    private int k;
    private h l = new bs(this);
    private d m = new bt(this);

    public static br a() {
        return new br();
    }

    private void a(ViewGroup viewGroup, int i, int i2, int i3) {
        View inflate = LayoutInflater.from(getActivity()).inflate(2130903128, null);
        ((TextView) inflate.findViewById(2131624328)).setText(i2);
        ((ImageView) inflate.findViewById(g.icon)).setImageResource(i3);
        inflate.setTag(Integer.valueOf(i));
        inflate.setOnClickListener(this);
        viewGroup.addView(inflate, -1, -2);
    }

    static /* synthetic */ void a(br brVar, int i) {
        TextView textView = (TextView) ((LinearLayout) brVar.f.findViewById(2131624348)).findViewWithTag(Integer.valueOf(0)).findViewById(2131624329);
        textView.setText(e.b(String.valueOf(i)));
        if (i > 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    private void a(boolean z, boolean z2) {
        if (z) {
            a((int) com.farsitel.bazaar.g.ic_pause_downloads, new bv(this));
            this.e.setVisibility(0);
        } else if (z2) {
            a((int) com.farsitel.bazaar.g.ic_clear_history, new bw(this));
            this.e.setVisibility(0);
        } else {
            j();
            this.e.setVisibility(8);
        }
    }

    private void d() {
        ViewGroup viewGroup = (ViewGroup) this.f.findViewById(2131624348);
        viewGroup.removeAllViews();
        if (com.farsitel.bazaar.database.g.a().c(BazaarApplication.c().getPackageName())) {
            View inflate = LayoutInflater.from(getActivity()).inflate(2130903128, null);
            inflate.setTag(Integer.valueOf(5));
            inflate.setBackgroundColor(getActivity().getResources().getColor(2131558418));
            ((ImageView) inflate.findViewById(g.icon)).setImageResource(com.farsitel.bazaar.g.ic_launcher);
            TextView textView = (TextView) inflate.findViewById(2131624328);
            textView.setText(2131165710);
            textView.setTextColor(-1);
            inflate.setOnClickListener(this);
            viewGroup.addView(inflate, -1, -2);
        }
        a(viewGroup, 0, 2131165723, com.farsitel.bazaar.g.ic_action_upgrades);
        a(viewGroup, 3, 2131165424, com.farsitel.bazaar.g.ic_action_installed);
        if (j.a().n()) {
            a(viewGroup, 2, 2131165311, com.farsitel.bazaar.g.ic_bookmarks);
            a(viewGroup, 1, 2131165313, com.farsitel.bazaar.g.ic_billing);
        }
    }

    public final void a(boolean z) {
        boolean z2 = !z && a.a().b.size() > 0;
        a(z, z2);
        if (!z) {
            this.d.setText("");
        }
    }

    public final void b() {
        this.b.notifyDataSetChanged();
    }

    public final void c() {
        long f = x.f();
        this.d.setText(getActivity().getString(2131165573, new Object[]{com.congenialmobile.util.h.a(getActivity(), f)}));
    }

    public final void f() {
        super.f();
        if (this.c != null) {
            this.c.smoothScrollToPosition(0);
        }
    }

    public final void onClick(View view) {
        boolean z = true;
        int i = -1;
        if (!(view == null || view.getTag() == null)) {
            i = ((Integer) view.getTag()).intValue();
        }
        com.farsitel.bazaar.g.a a;
        com.farsitel.bazaar.g.c cVar;
        Intent intent;
        HomeActivity homeActivity;
        switch (i) {
            case 0:
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.c = "my_apps_frag";
                cVar.e = "click";
                a.a(cVar.b("item", "upgradable_apps"));
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("bazaar://apps?slug=upgradable&user=1"));
                homeActivity = (HomeActivity) getActivity();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(intent, z, false);
                return;
            case 1:
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.c = "my_apps_frag";
                cVar.e = "click";
                a.a(cVar.b("item", "upgradable_apps"));
                y amVar = new am();
                homeActivity = (HomeActivity) getActivity();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(amVar, z);
                return;
            case 2:
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.c = "my_apps_frag";
                cVar.e = "click";
                a.a(cVar.b("item", "bookmarked_apps"));
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("bazaar://apps?slug=bookmarked&user=1"));
                homeActivity = (HomeActivity) getActivity();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(intent, z, false);
                return;
            case 3:
                a = com.farsitel.bazaar.g.a.a();
                cVar = new com.farsitel.bazaar.g.c();
                cVar.c = "my_apps_frag";
                cVar.e = "click";
                a.a(cVar.b("item", "installed_apps"));
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("bazaar://apps?slug=installed&user=1"));
                homeActivity = (HomeActivity) getActivity();
                if (getDialog() == null) {
                    z = false;
                }
                homeActivity.a(intent, z, false);
                return;
            case 5:
                a = com.farsitel.bazaar.g.a.a();
                com.farsitel.bazaar.g.c cVar2 = new com.farsitel.bazaar.g.c();
                cVar2.c = "my_apps_frag";
                cVar2.e = "click";
                a.a(cVar2.b("item", "upgradable_bazaar"));
                a.a(getActivity(), BazaarApplication.c().getPackageName(), getActivity().getString(2131165276), getActivity().getString(2131165320), 5.0f, "upgrade_my_bazaar");
                return;
            default:
                return;
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int a = this.b.a(getResources());
        View view = getView();
        if (view != null) {
            AbsListView absListView = (AbsListView) view.findViewById(2131624286);
            if (absListView instanceof HeaderGridView) {
                ((HeaderGridView) absListView).setNumColumns(a);
                this.k = a;
            }
            if (this.b != null) {
                this.b.notifyDataSetChanged();
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903117, null);
        this.c = (AbsListView) inflate.findViewById(2131624286);
        this.f = layoutInflater.inflate(2130903139, null);
        this.b = new ax(getActivity(), LayoutInflater.from(getActivity()), new bu(this));
        if (this.c instanceof HeaderGridView) {
            ((HeaderGridView) this.c).a(this.f, null, true);
            ((HeaderGridView) this.c).setNumColumns(this.b.k);
            ((HeaderGridView) this.c).setAdapter(this.b);
            this.k = this.b.k;
        } else {
            ((ListView) this.c).addHeaderView(this.f);
            ((ListView) this.c).setAdapter(this.b);
            this.k = 1;
        }
        this.c.setOnItemClickListener(this);
        this.j = new b(this.c);
        this.j.a();
        this.j.a = this;
        this.e = this.f.findViewById(2131624349);
        this.d = (TextView) this.f.findViewById(2131624350);
        com.a.a.a.a.c().a(new s().b(getString(2131165251)).a("downloads").c("downloads page"));
        return inflate;
    }

    public final void onDetach() {
        super.onDetach();
        if (this.j != null) {
            this.j.b();
        }
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = i - this.k;
        k kVar = (k) this.b.a(i2);
        if (kVar != null) {
            a.a(getActivity(), kVar.a, kVar.b, "", 0.0f, "downloads|" + i2);
        }
    }

    public final void onPause() {
        super.onPause();
        this.l.b();
        android.support.v4.b.j.a(BazaarApplication.c()).a(this.m);
    }

    public final void onResume() {
        super.onResume();
        String string = getString(2131165449);
        if (this.h != null) {
            this.h.setTitle(string);
            this.h.a();
        }
        d();
        this.b.notifyDataSetChanged();
        this.l.a();
        android.support.v4.b.j.a(BazaarApplication.c()).a(this.m, new IntentFilter("com.farsitel.bazaar.ON_LOGIN"));
        a(this.b.a, this.b.b);
        com.farsitel.bazaar.database.g.a().b();
        ((HomeActivity) getActivity()).c.a(com.farsitel.bazaar.database.g.a().a.size());
    }

    public final void onStart() {
        super.onStart();
        a.d();
        i.a("/Downloads");
    }
}
