package com.farsitel.bazaar.b;

import android.app.Activity;

public abstract class o extends m {
    public o(Activity activity, int i, int i2, int i3, int i4) {
        this(activity, i, i2, i3, i4, true);
    }

    public o(Activity activity, int i, int i2, int i3, int i4, boolean z) {
        this(activity, activity.getString(i), i2, i3, i4, z);
    }

    public o(Activity activity, String str, int i, int i2, int i3, boolean z) {
        super(activity, str, z);
        if (i != 0) {
            a(i, new p(this));
        }
        if (i2 != 0) {
            b(i2, new q(this));
        }
        if (i3 != 0) {
            c(i3, new r(this));
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();
}
