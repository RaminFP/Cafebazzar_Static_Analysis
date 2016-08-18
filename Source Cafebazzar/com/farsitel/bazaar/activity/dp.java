package com.farsitel.bazaar.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.f.a.a;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.f.l;
import com.farsitel.bazaar.widget.RetryView;
import com.farsitel.bazaar.widget.SlidingTabBar;
import com.farsitel.bazaar.widget.ViewPager;
import java.util.Map;

public final class dp extends y implements a, b {
    private Handler a = new Handler();
    private SlidingTabBar b;
    private ViewPager c;
    private l d;
    private RetryView e;
    private View f;
    private View j;
    private dy k;

    public static dp d() {
        return new dp();
    }

    public final void a() {
        this.a.post(new du(this));
    }

    public final void a(int i, Map map) {
        this.a.post(new dw(this, i, (String) map.get("general"), this));
    }

    public final void b() {
        e();
        this.b.setAdapter(new dq(this));
        this.b.setListPager(this.c);
        this.b.setOnTabChangeListener(new ds(this));
        this.b.setOnPageChangeListener(new dt(this));
        this.k = new dy(this, getChildFragmentManager(), this.d.a);
        this.c.setAdapter(this.k);
        if (BazaarApplication.c().b()) {
            this.c.setCurrentItem(this.d.a.length - 1);
        }
    }

    public final void c() {
        this.d.a();
    }

    public final void e() {
        this.a.post(new dv(this));
    }

    public final void f() {
        super.f();
        if (this.k != null) {
            for (int i = 0; i < this.k.getCount(); i++) {
                this.k.a(i).f();
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.j = layoutInflater.inflate(2130903122, null);
        this.b = (SlidingTabBar) this.j.findViewById(2131624317);
        this.c = (ViewPager) this.j.findViewById(2131624318);
        this.e = (RetryView) this.j.findViewById(2131624207);
        this.f = this.j.findViewById(2131624179);
        getActivity();
        this.d = new l(this);
        this.d.a();
        return this.j;
    }

    public final void onResume() {
        super.onResume();
        i();
        h();
    }
}
