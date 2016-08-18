package android.support.v4.f;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a extends r implements Map {
    h a;

    public a(int i) {
        super(5);
    }

    private h a() {
        if (this.a == null) {
            this.a = new b(this);
        }
        return this.a;
    }

    public Set entrySet() {
        h a = a();
        if (a.b == null) {
            a.b = new j(a);
        }
        return a.b;
    }

    public Set keySet() {
        h a = a();
        if (a.c == null) {
            a.c = new k(a);
        }
        return a.c;
    }

    public void putAll(Map map) {
        int size = this.h + map.size();
        if (this.f.length < size) {
            Object obj = this.f;
            Object obj2 = this.g;
            super.a(size);
            if (this.h > 0) {
                System.arraycopy(obj, 0, this.f, 0, this.h);
                System.arraycopy(obj2, 0, this.g, 0, this.h << 1);
            }
            r.a(obj, obj2, this.h);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        h a = a();
        if (a.d == null) {
            a.d = new m(a);
        }
        return a.d;
    }
}
