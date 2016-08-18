package com.c.b;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.List;

public final class ax {
    Uri a;
    int b;
    String c;
    int d;
    int e;
    boolean f;
    boolean g;
    boolean h;
    float i;
    float j;
    float k;
    boolean l;
    public List m;
    Config n;
    int o;

    ax(Uri uri, int i, Config config) {
        this.a = uri;
        this.b = i;
        this.n = config;
    }

    public final ax a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Width must be positive number or 0.");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Height must be positive number or 0.");
        } else if (i2 == 0 && i == 0) {
            throw new IllegalArgumentException("At least one dimension has to be positive number.");
        } else {
            this.d = i;
            this.e = i2;
            return this;
        }
    }
}
