package com.c.b;

import android.graphics.Bitmap;
import java.io.InputStream;

public final class w {
    final InputStream a;
    final Bitmap b;
    final boolean c;
    final long d;

    public w(InputStream inputStream, boolean z, long j) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream may not be null.");
        }
        this.a = inputStream;
        this.b = null;
        this.c = z;
        this.d = j;
    }
}
