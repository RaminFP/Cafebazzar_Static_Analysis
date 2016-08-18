package com.c.b;

final class h implements Runnable {
    final /* synthetic */ StringBuilder a;

    h(StringBuilder stringBuilder) {
        this.a = stringBuilder;
    }

    public final void run() {
        throw new NullPointerException(this.a.toString());
    }
}
