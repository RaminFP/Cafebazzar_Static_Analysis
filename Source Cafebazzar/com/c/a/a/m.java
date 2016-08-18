package com.c.a.a;

public abstract class m implements Runnable {
    protected final String a;

    public m(String str, Object... objArr) {
        this.a = String.format(str, objArr);
    }

    public abstract void a();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
