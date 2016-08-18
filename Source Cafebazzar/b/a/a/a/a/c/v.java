package b.a.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class v implements l, u, y {
    private final List a = new ArrayList();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference c = new AtomicReference(null);

    public static boolean a(Object obj) {
        try {
            return (((l) obj) == null || ((y) obj) == null || ((u) obj) == null) ? false : true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int a() {
        return o.b;
    }

    public final void a(y yVar) {
        synchronized (this) {
            this.a.add(yVar);
        }
    }

    public final void a(Throwable th) {
        this.c.set(th);
    }

    public final void b(boolean z) {
        synchronized (this) {
            this.b.set(z);
        }
    }

    public final Collection c() {
        Collection unmodifiableCollection;
        synchronized (this) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.a);
        }
        return unmodifiableCollection;
    }

    public final /* synthetic */ void c(Object obj) {
        a((y) obj);
    }

    public int compareTo(Object obj) {
        return o.a(this, obj);
    }

    public final boolean d() {
        for (y e : c()) {
            if (!e.e()) {
                return false;
            }
        }
        return true;
    }

    public final boolean e() {
        return this.b.get();
    }
}
