package com.c.a;

import java.util.ArrayDeque;
import java.util.Deque;

public final class x {
    private int a = 64;
    private int b = 5;
    private final Deque c = new ArrayDeque();
    private final Deque d = new ArrayDeque();
    private final Deque e = new ArrayDeque();

    final void a(l lVar) {
        synchronized (this) {
            this.e.add(lVar);
        }
    }

    final void b(l lVar) {
        synchronized (this) {
            if (this.e.remove(lVar)) {
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
    }
}
