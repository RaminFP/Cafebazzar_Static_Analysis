package com.farsitel.bazaar.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public final class at {
    private final au a;
    private boolean b;
    private boolean c;
    private boolean d;
    private View e;
    private View f;

    @TargetApi(19)
    public at(Activity activity) {
        LayoutParams layoutParams;
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.b = obtainStyledAttributes.getBoolean(0, false);
                this.c = obtainStyledAttributes.getBoolean(1, false);
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((attributes.flags & 67108864) != 0) {
                    this.b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.c = true;
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.a = new au(activity, this.b, this.c);
        if (!this.a.b) {
            this.c = false;
        }
        if (this.b) {
            this.e = new View(activity);
            layoutParams = new FrameLayout.LayoutParams(-1, this.a.a);
            layoutParams.gravity = 48;
            if (this.c && !this.a.a()) {
                layoutParams.rightMargin = this.a.d;
            }
            this.e.setLayoutParams(layoutParams);
            this.e.setBackgroundColor(-1728053248);
            this.e.setVisibility(8);
            viewGroup.addView(this.e);
        }
        if (this.c) {
            this.f = new View(activity);
            if (this.a.a()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.a.c);
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.a.d, -1);
                layoutParams.gravity = 5;
            }
            this.f.setLayoutParams(layoutParams);
            this.f.setBackgroundColor(-1728053248);
            this.f.setVisibility(8);
            viewGroup.addView(this.f);
        }
    }

    public final void a(int i) {
        if (this.b) {
            this.e.setBackgroundColor(i);
        }
    }

    public final void a(boolean z) {
        this.d = true;
        if (this.b) {
            this.e.setVisibility(0);
        }
    }
}
