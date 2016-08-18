package com.c.b;

import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;

public abstract class az {
    static void a(int i, int i2, int i3, int i4, Options options, aw awVar) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                i5 = (int) Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = awVar.k ? Math.max(i5, floor) : Math.min(i5, floor);
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    static void a(int i, int i2, Options options, aw awVar) {
        a(i, i2, options.outWidth, options.outHeight, options, awVar);
    }

    static boolean a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static Options d(aw awVar) {
        boolean c = awVar.c();
        Object obj = awVar.q != null ? 1 : null;
        Options options = null;
        if (c || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = c;
            if (obj != null) {
                options.inPreferredConfig = awVar.q;
            }
        }
        return options;
    }

    int a() {
        return 0;
    }

    boolean a(NetworkInfo networkInfo) {
        return false;
    }

    public abstract boolean a(aw awVar);

    public abstract ba b(aw awVar);

    boolean b() {
        return false;
    }
}
