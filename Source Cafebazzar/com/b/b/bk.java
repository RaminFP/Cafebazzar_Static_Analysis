package com.b.b;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class bk implements Runnable {
    private static final String a = bk.class.getSimpleName();
    PrintStream g;
    PrintWriter h;

    public abstract void a();

    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            if (this.g != null) {
                th.printStackTrace(this.g);
            } else if (this.h != null) {
                th.printStackTrace(this.h);
            } else {
                th.printStackTrace();
            }
            ba.a(6, a, "", th);
        }
    }
}
