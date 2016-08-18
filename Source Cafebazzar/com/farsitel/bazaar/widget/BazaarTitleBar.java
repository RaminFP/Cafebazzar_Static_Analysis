package com.farsitel.bazaar.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.activity.bj;
import com.farsitel.bazaar.activity.co;
import com.farsitel.bazaar.d.a;
import com.farsitel.bazaar.d.bo;
import com.farsitel.bazaar.d.bs;
import com.farsitel.bazaar.d.y;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.c;
import com.farsitel.bazaar.util.w;

public class BazaarTitleBar extends RelativeLayout implements OnClickListener {
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ProgressBar f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public final int j = 10800000;
    private View k;
    private Context l;
    private TextView m;

    public BazaarTitleBar(Context context) {
        super(context);
        this.l = context;
        d();
    }

    public BazaarTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = context;
        d();
    }

    public BazaarTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = context;
        d();
    }

    private void d() {
        this.k = LayoutInflater.from(getContext()).inflate(2130903093, this, true);
        this.a = (ImageView) this.k.findViewById(2131624234);
        this.c = (ImageView) this.k.findViewById(2131624238);
        this.b = (ImageView) this.k.findViewById(2131624239);
        this.d = (ImageView) this.k.findViewById(2131624237);
        this.e = (ImageView) this.k.findViewById(2131624241);
        this.f = (ProgressBar) this.k.findViewById(2131624242);
        this.g = (ImageView) this.k.findViewById(2131624240);
        this.h = (ImageView) this.k.findViewById(2131624243);
        this.i = (ImageView) this.k.findViewById(2131624236);
        this.m = (TextView) this.k.findViewById(2131624235);
        this.i.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    public final void a() {
        this.a.setVisibility(8);
    }

    public final void b() {
        this.k.findViewById(2131624140).setVisibility(8);
        setBottomMargin(0);
    }

    public final void c() {
        this.i.setVisibility(0);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomMargin(w.a(-4));
    }

    public void onClick(View view) {
        boolean z = false;
        switch (view.getId()) {
            case 2131624236:
                HomeActivity homeActivity = (HomeActivity) this.l;
                if (homeActivity.b == 0 && homeActivity.a.b[0].getChildFragmentManager().getBackStackEntryCount() < 2) {
                    z = true;
                }
                if (!z) {
                    homeActivity.onBackPressed();
                    return;
                }
                return;
            case 2131624237:
                if (j.a().n()) {
                    ((HomeActivity) this.l).a(a.a(), true);
                    return;
                }
                Intent intent = new Intent(this.l, JoinActivity.class);
                intent.putExtra("extra_referer", "my_bazaar");
                c.a(this.l, intent, view);
                return;
            case 2131624238:
                ((HomeActivity) this.l).a(co.a(), true, bj.SLIDE_FROM_TOP);
                return;
            case 2131624239:
                y g;
                if (j.a().a.getBoolean("support_knowledgebase_enabled", false)) {
                    bo boVar = new bo();
                    g = bo.g();
                } else {
                    bs bsVar = new bs();
                    g = bs.a();
                }
                ((HomeActivity) this.l).a(g, true, bj.SLIDE_FROM_TOP);
                return;
            default:
                return;
        }
    }

    public void setBottomMargin(int i) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(0, 0, 0, i);
        setLayoutParams(layoutParams);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.m.setText(str);
            this.m.setVisibility(0);
        }
    }
}
