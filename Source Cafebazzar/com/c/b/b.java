package com.c.b;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class b extends WeakReference {
    final a a;

    public b(a aVar, Object obj, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        this.a = aVar;
    }
}
