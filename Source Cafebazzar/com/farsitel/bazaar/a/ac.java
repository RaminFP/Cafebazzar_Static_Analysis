package com.farsitel.bazaar.a;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.farsitel.bazaar.g.e.f;
import com.farsitel.bazaar.g.e.g;
import com.farsitel.bazaar.util.m;
import com.farsitel.bazaar.util.o;

public final class ac extends BaseAdapter {
    private final LayoutInflater a;
    private Activity b;
    private f[] c;
    private String d;
    private String e;
    private boolean f;
    private String g;
    private final float h = 0.08f;

    public ac(Activity activity, LayoutInflater layoutInflater, f[] fVarArr, String str, String str2, String str3, boolean z) {
        this.b = activity;
        this.a = layoutInflater;
        this.c = fVarArr;
        this.d = str;
        this.e = str2;
        this.f = z;
        this.g = str3;
    }

    public final int getCount() {
        return this.c.length;
    }

    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        return this.c[i];
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        af afVar;
        f fVar = this.c[i];
        int integer = fVar.a == g.PROMO_ROW ? this.b.getResources().getInteger(2131296264) : this.b.getResources().getInteger(2131296266);
        int f = o.f();
        int i2 = fVar.a == g.APP_ROW ? (int) (((double) f) / (((double) integer) + 0.6d)) : (int) (((double) f) / (((double) integer) + 0.35d));
        if (view == null) {
            view = this.a.inflate(2130903096, null);
            af afVar2 = new af(this, view);
            view.setTag(afVar2);
            afVar = afVar2;
        } else {
            afVar = (af) view.getTag();
        }
        if ((this.c.length + -1 != i ? 1 : 0) == 0) {
            afVar.f.setVisibility(8);
        }
        if (this.d != null) {
            afVar.d.setTextColor(Color.parseColor(this.d));
            afVar.f.setBackgroundColor(m.a(Color.parseColor(this.d), Color.parseColor(this.e), 0.08f));
            afVar.b.setTextColor(m.a(Color.parseColor(this.d), Color.parseColor(this.e), 0.6f));
            afVar.c.setColorFilter(m.a(Color.parseColor(this.d), Color.parseColor(this.e), 0.6f));
        }
        if (TextUtils.isEmpty(fVar.b) && TextUtils.isEmpty(fVar.e)) {
            afVar.a.setVisibility(8);
        } else {
            afVar.a.setVisibility(0);
        }
        if (TextUtils.isEmpty(fVar.b)) {
            afVar.d.setVisibility(8);
        } else {
            afVar.d.setText(fVar.b);
            afVar.d.setVisibility(0);
        }
        if (TextUtils.isEmpty(fVar.e)) {
            afVar.b.setVisibility(8);
            afVar.c.setVisibility(8);
        } else {
            afVar.a.setOnClickListener(new ad(this, fVar));
            afVar.b.setVisibility(0);
            afVar.c.setVisibility(0);
        }
        if (fVar.a == g.APP_ROW) {
            afVar.e.setAdapter(new e(this.b, fVar.d, this.d, this.e, this.g + "|" + fVar.f, i2));
        } else {
            afVar.e.setAdapter(new ak(this.b, fVar.c, this.g + "|" + fVar.f, i2, Boolean.valueOf(this.f)));
        }
        afVar.e.addOnScrollListener(new ae(this, fVar));
        if (this.e != null) {
            view.setBackgroundColor(Color.parseColor(this.e));
        }
        if (fVar.a == g.APP_ROW && (fVar.d == null || fVar.d.length == 0)) {
            view.setVisibility(8);
        } else if (fVar.a == g.PROMO_ROW && (fVar.c == null || fVar.c.length == 0)) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        return view;
    }
}
