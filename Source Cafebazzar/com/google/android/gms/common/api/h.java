package com.google.android.gms.common.api;

import com.google.android.gms.a.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class h {
    private static final Set a = Collections.newSetFromMap(new WeakHashMap());

    public t a(t tVar) {
        throw new UnsupportedOperationException();
    }

    public c a(d dVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void a();

    public abstract void a(l lVar);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public boolean a(a aVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void b();

    public abstract void b(l lVar);

    public abstract boolean b(a aVar);

    public abstract boolean c();
}
