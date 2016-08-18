package com.farsitel.bazaar.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.e;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.o;
import java.util.ArrayList;

public final class s extends BaseAdapter {
    private final Context a;
    private ArrayList b = new ArrayList(36);
    private LayoutInflater c;
    private long d;
    private boolean e = true;

    public s(Context context, LayoutInflater layoutInflater, ArrayList arrayList) {
        this.a = context;
        this.c = layoutInflater;
        this.b = arrayList;
        this.d = System.currentTimeMillis();
    }

    public final int getCount() {
        return this.b.size();
    }

    public final /* synthetic */ Object getItem(int i) {
        return (e) this.b.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        t tVar;
        e eVar = (e) this.b.get(i);
        if (view == null) {
            view = this.c.inflate(2130903094, null);
            t tVar2 = new t();
            tVar2.a = (TextView) view.findViewById(2131624244);
            tVar2.b = (ImageView) view.findViewById(2131624208);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        view.setTag(2131165866, eVar.a);
        view.setTag(2131165865, eVar.b);
        tVar.a.setText(eVar.b);
        ab.a().a(String.format(VERSION.SDK_INT >= 17 ? "%scat_icons/%s_%s.webp" : "%scat_icons/%s_%s.png", new Object[]{j.a().l(), eVar.a, o.b()}), tVar.b, (int) g.icon_not_loaded);
        if (!this.e || System.currentTimeMillis() - this.d >= 1000) {
            this.e = false;
        } else {
            com.farsitel.bazaar.util.g.d(this.a, view, com.farsitel.bazaar.util.g.a((float) i, 20.0f));
        }
        return view;
    }
}
