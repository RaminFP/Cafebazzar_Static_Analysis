package com.farsitel.bazaar.util;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.c.b.aj;
import com.c.b.ax;
import com.c.b.ay;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g;
import java.util.ArrayList;

public final class ab {
    private static ab a;
    private aj b = aj.a(BazaarApplication.c());

    private ab() {
    }

    public static ab a() {
        if (a == null) {
            a = new ab();
        }
        return a;
    }

    public final void a(String str, ImageView imageView) {
        a(str, imageView, false, null);
    }

    public final void a(String str, ImageView imageView, int i) {
        a(str, imageView, false, g.icon_not_loaded, null, 0, 0, 0);
    }

    public final void a(String str, ImageView imageView, ad adVar) {
        a(str, imageView, false, adVar);
    }

    public final void a(String str, ImageView imageView, boolean z, int i) {
        a(str, imageView, z, i, null, 0, 0, 0);
    }

    public final void a(String str, ImageView imageView, boolean z, int i, int i2, int i3, int i4) {
        a(str, imageView, z, g.icon_not_loaded, null, i2, i3, i4);
    }

    public final void a(String str, ImageView imageView, boolean z, int i, ad adVar, int i2, int i3, int i4) {
        if (!TextUtils.isEmpty(str)) {
            ay ayVar;
            aj ajVar = this.b;
            if (str == null) {
                ayVar = new ay(ajVar, null, 0);
            } else if (str.trim().length() == 0) {
                throw new IllegalArgumentException("Path must not be empty.");
            } else {
                ayVar = new ay(ajVar, Uri.parse(str), 0);
            }
            if (!(i3 == 0 || i4 == 0)) {
                ayVar = ayVar.a(i3, i4);
            }
            if (i != 0) {
                if (!ayVar.d) {
                    throw new IllegalStateException("Already explicitly declared as no placeholder.");
                } else if (i == 0) {
                    throw new IllegalArgumentException("Placeholder image resource invalid.");
                } else if (ayVar.f != null) {
                    throw new IllegalStateException("Placeholder image already set.");
                } else {
                    ayVar.e = i;
                }
            }
            if (i2 != 0) {
                am amVar = new am(i2, 0);
                ax axVar = ayVar.a;
                if (amVar == null) {
                    throw new IllegalArgumentException("Transformation must not be null.");
                }
                if (axVar.m == null) {
                    axVar.m = new ArrayList(2);
                }
                axVar.m.add(amVar);
            }
            if (!z) {
                ayVar.b = true;
            }
            ayVar.a(imageView, new ac(this, adVar));
        }
    }

    public final void a(String str, ImageView imageView, boolean z, ad adVar) {
        a(str, imageView, z, 0, adVar, 0, 0, 0);
    }
}
