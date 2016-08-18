package com.farsitel.bazaar.activity;

import android.support.v4.view.bj;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.s;
import com.farsitel.bazaar.g;

final class aw extends bj {
    final /* synthetic */ am a;
    private final s b;
    private final s c;

    public aw(am amVar, s sVar, s sVar2) {
        this.a = amVar;
        this.b = sVar;
        this.c = sVar2;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getCount() {
        return 2;
    }

    public final CharSequence getPageTitle(int i) {
        return BazaarApplication.c().b() ? i == 0 ? "/Categories/Games" : "/Categories/Apps" : i == 0 ? "/Categories/Apps" : "/Categories/Games";
    }

    public final /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i) {
        View listView = new ListView(this.a.getActivity());
        listView.setDivider(null);
        listView.setCacheColorHint(0);
        listView.setSelector(this.a.getResources().getDrawable(g.selector));
        listView.setDrawSelectorOnTop(true);
        if (BazaarApplication.c().b()) {
            if (i != 0) {
                listView.setAdapter(this.b);
            }
            listView.setAdapter(this.c);
        } else {
            if (i == 0) {
                listView.setAdapter(this.b);
            }
            listView.setAdapter(this.c);
        }
        listView.setOnItemClickListener(this.a);
        viewGroup.addView(listView);
        return listView;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
