package com.farsitel.bazaar.a;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.m;

public final class e extends Adapter {
    private Activity a;
    private k[] b;
    private String c;
    private String d;
    private String e;
    private int f;

    public e(Activity activity, k[] kVarArr, String str, String str2, String str3, int i) {
        this.a = activity;
        this.c = str;
        this.e = str3;
        this.b = kVarArr;
        this.f = i;
        this.d = str2;
    }

    public final int getItemCount() {
        return this.b.length;
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        g gVar = (g) viewHolder;
        int dimension = (int) this.a.getResources().getDimension(2131361889);
        k kVar = this.b[i];
        if (kVar.k) {
            gVar.d.setVisibility(0);
            if (this.c != null) {
                gVar.d.setColorFilter(m.a(Color.parseColor(this.c), Color.parseColor(this.d), 0.6f));
            }
        } else {
            gVar.d.setVisibility(8);
        }
        gVar.a.setText(kVar.b);
        gVar.b.setText(kVar.h);
        if (this.c != null) {
            gVar.a.setTextColor(Color.parseColor(this.c));
            gVar.b.setTextColor(m.a(Color.parseColor(this.c), Color.parseColor(this.d), 0.6f));
        }
        gVar.c.setPaintFlags(gVar.c.getPaintFlags() | 16);
        if (TextUtils.isEmpty(kVar.i)) {
            gVar.c.setVisibility(8);
        } else {
            gVar.c.setText(kVar.i);
            gVar.c.setVisibility(0);
        }
        gVar.e.setTag(2131165843, kVar.m);
        gVar.e.getImageView().setTag(2131165843, kVar.m);
        ab.a().a(kVar.m, gVar.e.getImageView(), true, (int) g.icon_not_loaded);
        gVar.e.getLayoutParams().width = this.f;
        gVar.e.getLayoutParams().height = this.f;
        gVar.e.getImageView().setPadding(dimension, dimension, dimension, dimension);
        gVar.f.setOnClickListener(new f(this, kVar));
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130903124, viewGroup, false);
        inflate.setLayoutParams(new LayoutParams(this.f, -2));
        return new g(inflate);
    }
}
