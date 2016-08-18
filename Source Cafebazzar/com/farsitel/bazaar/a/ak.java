package com.farsitel.bazaar.a;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.e.e;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.w;

public final class ak extends Adapter {
    private final Boolean a;
    private Activity b;
    private e[] c;
    private String d;
    private int e;

    public ak(Activity activity, e[] eVarArr, String str, int i, Boolean bool) {
        this.b = activity;
        this.d = str;
        this.c = eVarArr;
        this.e = i;
        this.a = bool;
    }

    public final int getItemCount() {
        return this.c.length;
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        am amVar = (am) viewHolder;
        e eVar = this.c[i];
        amVar.a.setTag(2131165843, eVar.a());
        amVar.a.getImageView().setTag(2131165843, eVar.a());
        amVar.a.getImageView().setTag(2131165842, Integer.valueOf(w.a(10)));
        amVar.a.getImageView().setTag(2131165844, Integer.valueOf(this.e));
        amVar.a.getImageView().setTag(2131165841, Integer.valueOf(this.e / 2));
        amVar.a.setForegroundResource(g.splash_selector);
        ab.a().a(eVar.a(), amVar.a.getImageView(), true, g.icon_not_loaded, w.a(10), this.e, this.e / 2);
        amVar.a.setOnClickListener(new al(this, eVar));
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130903124, viewGroup, false);
        inflate.setLayoutParams(new LayoutParams(this.e, this.e / 2));
        return new am(inflate);
    }
}
