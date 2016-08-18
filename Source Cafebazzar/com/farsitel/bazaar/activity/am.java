package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.s;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.f.a.a;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.f.j;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.widget.RetryView;
import com.farsitel.bazaar.widget.SlidingTabBar;
import com.farsitel.bazaar.widget.ViewPager;
import java.util.Map;

public final class am extends y implements OnItemClickListener, a, b {
    private Handler a = new Handler();
    private SlidingTabBar b;
    private ViewPager c;
    private j d;
    private ListView e;
    private ListView f;
    private RetryView j;
    private View k;
    private View l;
    private aw m;

    public static am d() {
        return new am();
    }

    public final void a() {
        this.a.post(new as(this));
    }

    public final void a(int i, Map map) {
        this.a.post(new au(this, i, (String) map.get("general"), this));
    }

    public final void b() {
        e();
        LayoutInflater from = LayoutInflater.from(getActivity());
        ListAdapter sVar = new s(getActivity(), from, this.d.a);
        ListAdapter sVar2 = new s(getActivity(), from, this.d.b);
        if (this.b != null) {
            this.b.setListPager(this.c);
            this.b.setOnTabChangeListener(new aq(this));
            this.b.setOnPageChangeListener(new ar(this));
            this.m = new aw(this, sVar, sVar2);
            this.c.setAdapter(this.m);
            if (BazaarApplication.c().b()) {
                this.c.setCurrentItem(1);
                return;
            }
            return;
        }
        this.l.findViewById(2131624246).setVisibility(0);
        this.e.setAdapter(sVar);
        this.f.setAdapter(sVar2);
        this.e.setOnItemClickListener(this);
        this.f.setOnItemClickListener(this);
        BazaarApplication.c().d();
        i.a("/Categories/Apps");
        BazaarApplication.c().d();
        i.a("/Categories/Games");
    }

    public final void c() {
        this.d.a();
    }

    public final void e() {
        this.a.post(new at(this));
    }

    public final void f() {
        super.f();
        if (this.b != null) {
            if (this.c.getChildAt(0) != null) {
                ((ListView) this.c.getChildAt(0)).smoothScrollToPosition(0);
            }
            if (this.c.getChildAt(1) != null) {
                ((ListView) this.c.getChildAt(1)).smoothScrollToPosition(0);
            }
        } else if (this.e != null && this.f != null) {
            this.e.smoothScrollToPosition(0);
            this.f.smoothScrollToPosition(0);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.l = layoutInflater.inflate(2130903095, null);
        this.b = (SlidingTabBar) this.l.findViewById(2131624115);
        if (this.b != null) {
            this.c = (ViewPager) this.l.findViewById(2131624245);
            this.b.setAdapter(new an(this));
        } else {
            this.e = (ListView) this.l.findViewById(2131624248);
            this.f = (ListView) this.l.findViewById(2131624247);
        }
        this.j = (RetryView) this.l.findViewById(2131624207);
        this.k = this.l.findViewById(2131624179);
        getActivity();
        this.d = new j(this);
        this.d.a();
        return this.l;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = (String) view.getTag(2131165866);
        String str2 = (String) view.getTag(2131165865);
        Intent intent = new Intent();
        intent.setData(Uri.parse("bazaar://page?slug=category/?cat=" + str + "&title=" + str2 + "&ref=categories"));
        ((HomeActivity) getActivity()).a(intent, getDialog() != null, false);
    }

    public final void onResume() {
        super.onResume();
        i();
        h();
    }
}
