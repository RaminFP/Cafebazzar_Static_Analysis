package com.c.a;

import d.j;
import java.io.Closeable;
import java.io.InputStream;

public abstract class ar implements Closeable {
    public abstract long a();

    public abstract j b();

    public final InputStream c() {
        return b().f();
    }

    public void close() {
        b().close();
    }
}
