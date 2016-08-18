package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.f.a.c;
import com.farsitel.bazaar.g.g;
import com.farsitel.bazaar.h.b.m;
import com.farsitel.bazaar.h.d;
import java.util.ArrayList;

public final class ao extends BaseAdapter {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final Activity i;
    private ArrayList j;
    private LayoutInflater k;
    private final ListView l;
    private boolean m = false;
    private String n;
    private int o;
    private boolean p = false;
    private boolean q = false;
    private boolean r = true;
    private c s;
    private long t;
    private boolean u = false;

    public ao(Activity activity, LayoutInflater layoutInflater, ListView listView, String str, c cVar, long j) {
        this.i = activity;
        this.j = new ArrayList();
        this.k = layoutInflater;
        this.l = listView;
        this.n = str;
        this.s = cVar;
        this.t = j;
        this.a = this.i.getResources().getColor(2131558472);
        this.b = this.i.getResources().getColor(2131558529);
        this.c = this.i.getResources().getColor(2131558470);
        this.d = this.i.getResources().getColor(2131558498);
        this.e = this.i.getResources().getColor(2131558499);
        this.f = this.i.getResources().getColor(2131558500);
        this.g = this.i.getResources().getColor(2131558501);
        this.h = this.i.getResources().getColor(2131558502);
    }

    static /* synthetic */ int a(ao aoVar, int i) {
        int i2 = aoVar.o + i;
        aoVar.o = i2;
        return i2;
    }

    private void a(au auVar, g gVar) {
        int i = gVar.e;
        int i2 = (gVar.i == null || !gVar.i.booleanValue()) ? 0 : 1;
        i2 += i;
        auVar.d.setText(e.b(i2 > 0 ? "+" + i2 : "0"));
        Object obj = (gVar.i == null || !gVar.i.booleanValue()) ? null : 1;
        if (obj != null) {
            auVar.d.setTextColor(this.a);
            auVar.e.setColorFilter(this.a);
            auVar.g.setTextColor(this.c);
            auVar.h.setColorFilter(this.c);
        } else {
            obj = (gVar.i == null || gVar.i.booleanValue()) ? null : 1;
            if (obj != null) {
                auVar.d.setTextColor(this.c);
                auVar.e.setColorFilter(this.c);
                auVar.g.setTextColor(this.b);
                auVar.h.setColorFilter(this.b);
            } else {
                auVar.d.setTextColor(this.c);
                auVar.e.setColorFilter(this.c);
                auVar.g.setTextColor(this.c);
                auVar.h.setColorFilter(this.c);
            }
        }
        i = gVar.f;
        int i3 = gVar.e;
        i2 = (gVar.i == null || gVar.i.booleanValue()) ? 0 : 1;
        auVar.g.setText(e.a(-(i2 + (i - i3))));
    }

    public final void a() {
        if (!this.q && !this.p) {
            this.p = true;
            this.s.a();
            d.INSTANCE.a(new at(), new m(), this.n, Integer.valueOf(this.o), Integer.valueOf(this.o + 10));
            this.u = true;
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return !this.u ? 1 : this.j.size();
    }

    public final Object getItem(int i) {
        return !this.u ? null : this.j.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.u) {
            return LayoutInflater.from(this.i).inflate(2130903149, null);
        }
        au auVar;
        if (view == null || view.getTag() == null) {
            view = this.k.inflate(2130903167, null);
            auVar = new au();
            auVar.a = (TextView) view.findViewById(2131624244);
            auVar.b = (TextView) view.findViewById(2131624400);
            auVar.c = (ImageView) view.findViewById(2131624398);
            auVar.d = (TextView) view.findViewById(2131624404);
            auVar.e = (ImageView) view.findViewById(2131624405);
            auVar.f = view.findViewById(2131624403);
            auVar.g = (TextView) view.findViewById(2131624407);
            auVar.h = (ImageView) view.findViewById(2131624408);
            auVar.i = view.findViewById(2131624406);
            auVar.j = view.findViewById(2131624409);
            auVar.k = (RatingBar) view.findViewById(2131624225);
            auVar.l = (TextView) view.findViewById(2131624401);
            auVar.m = (TextView) view.findViewById(2131624402);
            view.setTag(auVar);
        } else {
            auVar = (au) view.getTag();
        }
        g gVar = (g) this.j.get(i);
        a(auVar, gVar);
        auVar.a.setText(gVar.b);
        auVar.b.setText(e.b(gVar.g));
        auVar.l.setText(gVar.d);
        float f = (float) gVar.c;
        if (f > 0.0f) {
            auVar.k.setRating(f);
        } else {
            auVar.k.setVisibility(4);
        }
        if (((long) gVar.h) < this.t) {
            auVar.m.setVisibility(0);
        } else {
            auVar.m.setVisibility(8);
        }
        if (gVar.h == 0) {
            auVar.m.setVisibility(8);
        }
        switch (gVar.c) {
            case 1:
                auVar.c.setColorFilter(this.d);
                break;
            case 2:
                auVar.c.setColorFilter(this.e);
                break;
            case 3:
                auVar.c.setColorFilter(this.f);
                break;
            case 4:
                auVar.c.setColorFilter(this.g);
                break;
            case 5:
                auVar.c.setColorFilter(this.h);
                break;
        }
        if (i > this.j.size() - 5 && !this.m) {
            a();
        }
        auVar.f.setOnClickListener(new ap(this, gVar, auVar));
        auVar.i.setOnClickListener(new aq(this, gVar, auVar));
        auVar.j.setOnClickListener(new ar(this, gVar));
        return view;
    }

    public final boolean isEnabled(int i) {
        return false;
    }
}
