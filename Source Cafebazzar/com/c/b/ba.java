package com.c.b;

import android.graphics.Bitmap;
import java.io.InputStream;

public final class ba {
    final ap a;
    final Bitmap b;
    final InputStream c;
    final int d;

    public ba(Bitmap bitmap, ap apVar) {
        this((Bitmap) bj.a((Object) bitmap, "bitmap == null"), null, apVar, 0);
    }

    ba(Bitmap bitmap, InputStream inputStream, ap apVar, int i) {
        int i2 = 0;
        int i3 = bitmap != null ? 1 : 0;
        if (inputStream != null) {
            i2 = 1;
        }
        if ((i2 ^ i3) == 0) {
            throw new AssertionError();
        }
        this.b = bitmap;
        this.c = inputStream;
        this.a = (ap) bj.a((Object) apVar, "loadedFrom == null");
        this.d = i;
    }

    public ba(InputStream inputStream, ap apVar) {
        this(null, (InputStream) bj.a((Object) inputStream, "stream == null"), apVar, 0);
    }
}
