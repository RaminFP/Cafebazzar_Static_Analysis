package android.support.v4.f;

import java.util.Map;

final class b extends h {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    protected final int a() {
        return this.a.h;
    }

    protected final int a(Object obj) {
        return this.a.a(obj);
    }

    protected final Object a(int i, int i2) {
        return this.a.g[(i << 1) + i2];
    }

    protected final Object a(int i, Object obj) {
        return this.a.a(i, obj);
    }

    protected final void a(int i) {
        this.a.d(i);
    }

    protected final void a(Object obj, Object obj2) {
        this.a.put(obj, obj2);
    }

    protected final int b(Object obj) {
        return this.a.b(obj);
    }

    protected final Map b() {
        return this.a;
    }

    protected final void c() {
        this.a.clear();
    }
}
