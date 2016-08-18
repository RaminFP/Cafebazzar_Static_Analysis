package com.farsitel.bazaar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.receiver.h;
import com.farsitel.bazaar.util.o;

public class HomeTabBar extends LinearLayout {
    private int a;
    private int b;
    private Object c;
    private w d;
    private TextView e;
    private h f;

    public HomeTabBar(Context context) {
        super(context);
        a();
    }

    public HomeTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setOrientation(0);
        setGravity(17);
        this.a = getContext().getResources().getColor(2131558471);
        this.b = getContext().getResources().getColor(2131558468);
        x xVar = new x(Integer.valueOf(0), g.ic_home, 2131165443);
        x xVar2 = new x(Integer.valueOf(1), g.ic_top_charts, 2131165699);
        x xVar3 = new x(Integer.valueOf(2), g.ic_categs, 2131165324);
        x xVar4 = new x(Integer.valueOf(3), g.ic_search, 2131165623);
        x xVar5 = new x(Integer.valueOf(4), g.ic_download, 2131165449);
        boolean b = BazaarApplication.c().b();
        boolean e = o.e();
        for (int i = 0; i < 5; i++) {
            LayoutParams layoutParams;
            x xVar6 = new x[]{xVar, xVar2, xVar3, xVar4, xVar5}[i];
            View inflate = LayoutInflater.from(getContext()).inflate(2130903127, null);
            TextView textView = (TextView) inflate.findViewById(2131624327);
            textView.setVisibility(0);
            textView.setText(xVar6.c);
            ((ImageView) inflate.findViewById(android.support.v7.a.g.icon)).setImageResource(xVar6.b);
            inflate.setTag(xVar6.a);
            if (xVar6.a.equals(Integer.valueOf(0))) {
                a(inflate);
            } else {
                b(inflate);
            }
            inflate.setOnClickListener(new v(this, xVar6));
            if (e) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
            }
            if (b) {
                addView(inflate, 0, layoutParams);
            } else {
                addView(inflate, layoutParams);
            }
        }
        this.e = (TextView) findViewWithTag(Integer.valueOf(4)).findViewById(2131624326);
        this.f = new u(this);
        this.f.a();
    }

    private void a(View view) {
        if (this.c != null) {
            b(findViewWithTag(this.c));
        }
        ((TextView) view.findViewById(2131624327)).setTextColor(this.a);
        ((ImageView) view.findViewById(android.support.v7.a.g.icon)).setColorFilter(this.a);
        this.c = view.getTag();
    }

    private void a(Object obj, boolean z) {
        if (!obj.equals(this.c)) {
            if (this.d != null) {
                this.d.a(obj, z);
            }
            a(findViewWithTag(obj));
        } else if (this.d != null) {
            this.d.b(obj, z);
        }
    }

    private void b(View view) {
        ((TextView) view.findViewById(2131624327)).setTextColor(this.b);
        ((ImageView) view.findViewById(android.support.v7.a.g.icon)).setColorFilter(this.b);
    }

    public final void a(int i) {
        int i2 = com.farsitel.bazaar.database.g.a().c() > 0 ? 1 : 0;
        if (i <= 0 || i2 == 0) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setText(e.b(String.valueOf(i)));
        this.e.setVisibility(0);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f != null) {
            this.f.b();
        }
    }

    public void setOnTabItemClickListener(w wVar) {
        this.d = wVar;
    }

    public void setSelectedTab(Object obj) {
        a(obj, false);
    }
}
