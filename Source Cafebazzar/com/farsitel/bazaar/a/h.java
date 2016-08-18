package com.farsitel.bazaar.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.f.f;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.util.w;
import ir.cafebazaar.pardakht.a.e;

public abstract class h extends BaseAdapter {
    private static float a;
    private final boolean b;
    protected Context c;
    protected LayoutInflater d;
    protected String e;
    protected b f;
    protected int g;
    protected boolean h;
    public a i;
    public OnClickListener j;
    public int k;
    public boolean l;
    protected String m;
    public f n;
    private final int o;
    private final Activity p;
    private final e q;
    private boolean r;
    private boolean s;
    private long t;
    private boolean u;
    private String v;
    private boolean w;
    private String x;

    private h(Activity activity, LayoutInflater layoutInflater, boolean z, b bVar, boolean z2, int i, String str) {
        this(activity, layoutInflater, z, bVar, z2, 0, null, false, str);
    }

    public h(Activity activity, LayoutInflater layoutInflater, boolean z, b bVar, boolean z2, int i, String str, boolean z3, String str2) {
        this.g = 0;
        this.h = false;
        this.i = null;
        this.s = false;
        this.l = true;
        this.p = activity;
        this.c = this.p.getApplicationContext();
        this.d = layoutInflater;
        this.x = str2;
        this.w = z3;
        this.r = z;
        this.f = bVar;
        this.v = str;
        this.e = BazaarApplication.c().a.getLanguage();
        this.b = z2;
        this.o = i;
        this.t = System.currentTimeMillis();
        this.u = o.e();
        this.q = new e(this.c);
        this.k = a(this.c.getResources());
        a = (float) this.c.getResources().getInteger(2131296274);
    }

    public h(Activity activity, LayoutInflater layoutInflater, boolean z, b bVar, boolean z2, String str) {
        this(activity, layoutInflater, z, bVar, false, 0, str);
    }

    private com.farsitel.bazaar.g.f c(int i) {
        return (i < 0 || i >= this.i.d.size()) ? null : (com.farsitel.bazaar.g.f) this.i.d.get(i);
    }

    public final int a(Resources resources) {
        return (VERSION.SDK_INT >= 11 && !this.w && ((int) (((float) resources.getDisplayMetrics().widthPixels) / resources.getDimension(2131361891))) > 1) ? 2 : 1;
    }

    public final com.farsitel.bazaar.g.f a(int i) {
        return BazaarApplication.c().b() ? c(b(i)) : c(i);
    }

    public abstract void a();

    public final int b(int i) {
        int i2 = i / this.k;
        return (((this.k * i2) + this.k) - 1) - (i - (i2 * this.k));
    }

    public final a b() {
        return this.i;
    }

    public final void c() {
        this.h = true;
    }

    public final boolean d() {
        return this.h;
    }

    public final void e() {
        this.h = false;
        a();
    }

    public final v f() {
        return new l();
    }

    public int getCount() {
        return this.i.d.isEmpty() ? 0 : BazaarApplication.c().b() ? ((int) Math.ceil(((double) this.i.d.size()) / ((double) this.k))) * this.k : this.i.d.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return c(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getItemViewType(int i) {
        return a(i) instanceof k ? 0 : 1;
    }

    @TargetApi(11)
    public View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        if (view == null) {
            View inflate;
            Object kVar;
            if (getItemViewType(i) == 0) {
                inflate = this.d.inflate(2130903123, viewGroup, false);
                kVar = new k(inflate);
            } else {
                inflate = this.d.inflate(2130903130, viewGroup, false);
                kVar = new m(inflate);
            }
            inflate.setTag(2131165869, kVar);
            inflate.setOnTouchListener(new i(this));
            if (this.o != 0) {
                inflate.setBackgroundResource(2131558545);
                obj = kVar;
                view = inflate;
            } else {
                obj = kVar;
                view = inflate;
            }
        } else {
            n nVar = (n) view.getTag(2131165869);
        }
        if (a(i) == null) {
            view.setVisibility(4);
        } else if (getItemViewType(i) == 1) {
            com.farsitel.bazaar.g.e.e eVar = (com.farsitel.bazaar.g.e.e) a(i);
            m mVar = (m) obj;
            mVar.a.setText(eVar.b);
            if (TextUtils.isEmpty(eVar.c)) {
                mVar.b.setVisibility(8);
            } else {
                mVar.b.setText(eVar.c);
                mVar.b.setVisibility(0);
            }
            mVar.c.setTag(2131165842, Integer.valueOf(w.a(10)));
            mVar.c.setTag(2131165843, eVar.a());
            ab.a().a(eVar.a(), mVar.c, true, g.icon_not_loaded, null, w.a(10), 0, 0);
            if (this.u) {
                mVar.e.setVisibility(8);
                mVar.d.setVisibility(8);
            } else if (getItemViewType(b(i + 1)) == 1) {
                mVar.e.setVisibility(8);
            } else {
                mVar.e.setVisibility(0);
                mVar.d.setVisibility(0);
            }
        } else {
            k kVar2 = (k) obj;
            k kVar3 = (k) a(i);
            kVar2.i.setVisibility(this.b ? 0 : 8);
            if (this.b) {
                kVar2.i.setText(com.congenialmobile.util.e.b(String.valueOf((BazaarApplication.c().b() ? b(i) : i) + 1)));
            }
            view.setVisibility(0);
            if (this.v != null) {
                kVar2.a.setTextColor(Color.parseColor(this.v));
                kVar2.i.setTextColor(Color.parseColor(this.v));
                ((LayerDrawable) kVar2.b.getProgressDrawable()).getDrawable(2).setColorFilter(Color.parseColor(this.v), Mode.SRC_ATOP);
            }
            if (kVar3.b != null) {
                kVar2.a.setText(kVar3.b);
            }
            if (this.r) {
                kVar2.c.setBackgroundDrawable(kVar3.a());
            } else if (this.u) {
                ab.a().a(kVar3.m, kVar2.c, true, (int) g.icon_not_loaded);
                kVar2.c.setTag(2131165843, kVar3.m);
            } else {
                ab.a().a(kVar3.l, kVar2.c, true, (int) g.icon_not_loaded);
                kVar2.c.setTag(2131165843, kVar3.l);
            }
            com.farsitel.bazaar.database.b.a();
            switch (com.farsitel.bazaar.database.b.a(kVar3.a)) {
                case 0:
                    kVar2.d.setText(2131165707);
                    kVar2.h.setVisibility(8);
                    break;
                case 1:
                    if (kVar3.g == 0 || kVar3.g == -1 || this.q.a(kVar3.a)) {
                        kVar2.d.setText(2131165409);
                    } else {
                        kVar2.d.setText(kVar3.h);
                    }
                    kVar2.h.setVisibility(8);
                    break;
                case 2:
                    kVar2.d.setText(2131165433);
                    kVar2.h.setVisibility(8);
                    break;
                case 3:
                    kVar2.d.setText(2131165514);
                    kVar2.h.setIndeterminate(false);
                    kVar2.h.setVisibility(0);
                    break;
                case 4:
                    kVar2.d.setText(2131165514);
                    kVar2.h.setIndeterminate(true);
                    kVar2.h.setVisibility(0);
                    break;
            }
            j jVar = new j(this, kVar2, kVar3, i);
            boolean z = (kVar3.i == null || kVar3.i.equals("")) ? false : true;
            if (z) {
                kVar2.e.setText(kVar3.i);
                kVar2.e.setVisibility(0);
            } else {
                kVar2.e.setVisibility(8);
            }
            if (kVar3.k) {
                kVar2.f.setVisibility(0);
            } else {
                kVar2.f.setVisibility(8);
            }
            if (!o.e()) {
                LayoutParams layoutParams = (LayoutParams) kVar2.a.getLayoutParams();
                if (kVar3.f > 0.0f) {
                    kVar2.b.setVisibility(0);
                    kVar2.b.setRating(kVar3.f);
                    layoutParams.addRule(10);
                    layoutParams.addRule(15, 0);
                } else {
                    kVar2.b.setVisibility(8);
                    layoutParams.addRule(10, 0);
                    layoutParams.addRule(15);
                }
            } else if (kVar3.f > 0.0f) {
                kVar2.b.setVisibility(0);
                kVar2.b.setRating(kVar3.f);
            } else {
                kVar2.b.setVisibility(8);
            }
            if (this.j != null) {
                kVar2.g.setVisibility(0);
                kVar2.g.setOnClickListener(this.j);
            } else {
                kVar2.g.setVisibility(8);
            }
            kVar2.g.setTag(2131165861, kVar3.a);
            kVar2.g.setTag(2131165864, kVar3.e);
            kVar2.g.setTag(2131165863, Long.valueOf(kVar3.d));
            kVar2.g.setTag(2131165860, Boolean.valueOf(kVar3.j));
            if (!kVar3.j) {
                if (VERSION.SDK_INT > 11) {
                    view.setAlpha(0.4f);
                }
                kVar2.a.setText(this.c.getString(2131165230, new Object[]{kVar3.b}));
            } else if (VERSION.SDK_INT > 11) {
                view.setAlpha(1.0f);
            }
            view.setTag(kVar3.a);
            view.setTag(2131165862, Long.valueOf(kVar3.g));
        }
        if (!(this.s || i <= this.i.d.size() - 5 || this.h)) {
            this.s = true;
            a();
        }
        if (!this.l || System.currentTimeMillis() - this.t >= 1000) {
            this.l = false;
        } else {
            com.farsitel.bazaar.util.g.d(this.c, view, com.farsitel.bazaar.util.g.a((float) b(i), a));
        }
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isEmpty() {
        return this.i.d.isEmpty();
    }

    public void notifyDataSetChanged() {
        this.l = false;
        super.notifyDataSetChanged();
        this.k = a(this.c.getResources());
    }
}
