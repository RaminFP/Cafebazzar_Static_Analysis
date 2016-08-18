package com.farsitel.bazaar.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewConfiguration;

public final class au {
    final int a;
    final boolean b;
    final int c;
    final int d;
    private final boolean e;
    private final boolean f;
    private final int g;
    private final boolean h;
    private final float i;

    private au(Activity activity, boolean z, boolean z2) {
        int dimensionPixelSize;
        boolean z3 = true;
        Resources resources = activity.getResources();
        this.h = resources.getConfiguration().orientation == 1;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.i = Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
        this.a = a(resources, "status_bar_height");
        if (VERSION.SDK_INT >= 14) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843499, typedValue, true);
            dimensionPixelSize = activity.getResources().getDimensionPixelSize(typedValue.resourceId);
        } else {
            dimensionPixelSize = 0;
        }
        this.g = dimensionPixelSize;
        resources = activity.getResources();
        if (VERSION.SDK_INT < 14 || ViewConfiguration.get(activity).hasPermanentMenuKey()) {
            dimensionPixelSize = 0;
        } else {
            dimensionPixelSize = a(resources, this.h ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }
        this.c = dimensionPixelSize;
        dimensionPixelSize = (VERSION.SDK_INT < 14 || ViewConfiguration.get(activity).hasPermanentMenuKey()) ? 0 : a(activity.getResources(), "navigation_bar_width");
        this.d = dimensionPixelSize;
        if (this.c <= 0) {
            z3 = false;
        }
        this.b = z3;
        this.e = z;
        this.f = z2;
    }

    private static int a(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    public final boolean a() {
        return this.i >= 600.0f || this.h;
    }
}
