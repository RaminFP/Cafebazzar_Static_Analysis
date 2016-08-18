package com.google.android.gms.a;

import java.lang.ref.WeakReference;

final class aw extends be {
    private WeakReference b;

    aw(ar arVar) {
        this.b = new WeakReference(arVar);
    }

    public final void a() {
        ar arVar = (ar) this.b.get();
        if (arVar != null) {
            ar.a(arVar);
        }
    }
}
