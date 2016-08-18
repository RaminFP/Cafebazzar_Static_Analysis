package com.farsitel.bazaar.activity;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.widget.ViewPager;

public class ScreenshotActivity extends s {
    boolean a = true;
    private ViewPager b;
    private cl c;
    private String[] d;
    private String[] e;
    private int f = 0;
    private LinearLayout g;
    private LinearLayout h;
    private final BazaarApplication i = BazaarApplication.c();
    private Animation j;
    private Animation k;
    private Animation l;
    private Animation m;

    private void a() {
        if (this.d.length > 1) {
            if (this.b.getCurrentItem() == this.c.getCount() - 1) {
                this.g.setVisibility(0);
                this.g.startAnimation(this.l);
            } else if (this.b.getCurrentItem() == 0) {
                this.h.startAnimation(this.m);
                this.h.setVisibility(0);
            } else {
                this.h.startAnimation(this.m);
                this.g.startAnimation(this.l);
                this.h.setVisibility(0);
                this.g.setVisibility(0);
            }
        }
        this.a = false;
        this.f++;
        new Handler().postDelayed(new ck(this, this.f), 2000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean a(com.farsitel.bazaar.activity.ScreenshotActivity r7, float r8, float r9, double r10) {
        /*
        r2 = new android.graphics.Point;
        r2.<init>();
        r0 = r7.getWindowManager();
        r1 = android.os.Build.VERSION.SDK_INT;
        r3 = 13;
        if (r1 < r3) goto L_0x003a;
    L_0x000f:
        r0 = r0.getDefaultDisplay();
        r0.getSize(r2);
        r0 = r2.x;
        r0 = (double) r0;
        r2 = r2.y;
        r2 = (double) r2;
    L_0x001c:
        r4 = r0 / r2;
        r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0049;
    L_0x0022:
        r4 = r0 / r10;
        r4 = r2 - r4;
        r4 = (int) r4;
        r4 = r4 / 2;
        r0 = r0 / r10;
        r0 = r0 + r2;
        r0 = (int) r0;
        r0 = r0 / 2;
        r1 = (float) r4;
        r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r1 < 0) goto L_0x0038;
    L_0x0033:
        r0 = (float) r0;
        r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x005f;
    L_0x0038:
        r0 = 1;
    L_0x0039:
        return r0;
    L_0x003a:
        r2 = r0.getDefaultDisplay();
        r0 = r2.getWidth();
        r0 = (double) r0;
        r2 = r2.getHeight();
        r2 = (double) r2;
        goto L_0x001c;
    L_0x0049:
        r4 = r2 * r10;
        r4 = r0 - r4;
        r4 = (int) r4;
        r4 = r4 / 2;
        r2 = r2 * r10;
        r0 = r0 + r2;
        r0 = (int) r0;
        r0 = r0 / 2;
        r1 = (float) r4;
        r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r1 < 0) goto L_0x0038;
    L_0x005a:
        r0 = (float) r0;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x0038;
    L_0x005f:
        r0 = 0;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.activity.ScreenshotActivity.a(com.farsitel.bazaar.activity.ScreenshotActivity, float, float, double):boolean");
    }

    static /* synthetic */ void h(ScreenshotActivity screenshotActivity) {
        if (screenshotActivity.b.getCurrentItem() > 0) {
            screenshotActivity.b.a(screenshotActivity.b.getCurrentItem() - 1, true);
        }
        screenshotActivity.f++;
    }

    static /* synthetic */ void i(ScreenshotActivity screenshotActivity) {
        if (screenshotActivity.c.getCount() > screenshotActivity.b.getCurrentItem()) {
            screenshotActivity.b.a(screenshotActivity.b.getCurrentItem() + 1, true);
        }
        screenshotActivity.f++;
    }

    static /* synthetic */ void l(ScreenshotActivity screenshotActivity) {
        if (screenshotActivity.d.length > 1) {
            if (screenshotActivity.b.getCurrentItem() == screenshotActivity.c.getCount() - 1) {
                screenshotActivity.g.startAnimation(screenshotActivity.k);
                screenshotActivity.g.setVisibility(8);
            } else if (screenshotActivity.b.getCurrentItem() == 0) {
                screenshotActivity.h.startAnimation(screenshotActivity.j);
                screenshotActivity.h.setVisibility(8);
            } else {
                screenshotActivity.g.startAnimation(screenshotActivity.k);
                screenshotActivity.h.startAnimation(screenshotActivity.j);
                screenshotActivity.g.setVisibility(8);
                screenshotActivity.h.setVisibility(8);
            }
        }
        screenshotActivity.a = true;
        screenshotActivity.f++;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903169);
        this.j = AnimationUtils.loadAnimation(this, 2130968634);
        this.k = AnimationUtils.loadAnimation(this, 2130968636);
        this.l = AnimationUtils.loadAnimation(this, 2130968633);
        this.m = AnimationUtils.loadAnimation(this, 2130968635);
        this.j.setDuration(300);
        this.k.setDuration(300);
        this.l.setDuration(300);
        this.m.setDuration(300);
        this.b = (ViewPager) findViewById(2131624245);
        this.c = new cl(this);
        this.b.setOnPageChangeListener(new cg(this));
        int i = getIntent().getExtras().getInt("scrid");
        this.d = getIntent().getExtras().getStringArray("scrarr");
        this.e = getIntent().getExtras().getStringArray("scrth");
        String string = getIntent().getExtras().getString("pkgName");
        this.b.setAdapter(this.c);
        this.b.setCurrentItem(i);
        if (VERSION.SDK_INT >= 11) {
            getWindow().getDecorView().setSystemUiVisibility(1);
        }
        this.g = (LinearLayout) findViewById(2131624412);
        this.g.setOnClickListener(new ch(this));
        this.h = (LinearLayout) findViewById(2131624414);
        this.h.setOnClickListener(new ci(this));
        this.b.setOnTouchListener(new cj(this));
        a();
        this.i.d();
        i.a("/AppInfo/" + string + "/Screenshots/");
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
