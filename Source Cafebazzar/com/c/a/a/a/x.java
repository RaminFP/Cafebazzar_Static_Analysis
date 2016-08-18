package com.c.a.a.a;

import java.io.IOException;

public final class x extends Exception {
    public x(IOException iOException) {
        super(iOException);
    }

    public final IOException a() {
        return (IOException) super.getCause();
    }

    public final /* bridge */ /* synthetic */ Throwable getCause() {
        return (IOException) super.getCause();
    }
}
