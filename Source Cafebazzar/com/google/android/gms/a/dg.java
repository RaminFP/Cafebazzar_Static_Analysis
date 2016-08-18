package com.google.android.gms.a;

import java.lang.reflect.Array;

public final class dg {
    protected final int a;
    protected final Class b;
    public final int c;
    protected final boolean d;

    private int b(Object obj) {
        int b = do.b(this.c);
        switch (this.a) {
            case 10:
                return (dd.b(b) << 1) + ((dl) obj).d();
            case 11:
                return dd.b(b, (dl) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.a);
        }
    }

    private void b(Object obj, dd ddVar) {
        try {
            ddVar.c(this.c);
            switch (this.a) {
                case 10:
                    dl dlVar = (dl) obj;
                    int b = do.b(this.c);
                    dlVar.a(ddVar);
                    ddVar.c(b, 4);
                    return;
                case 11:
                    ddVar.a((dl) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    final int a(Object obj) {
        int i = 0;
        if (!this.d) {
            return b(obj);
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += b(Array.get(obj, i2));
            }
        }
        return i;
    }

    final void a(Object obj, dd ddVar) {
        if (this.d) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    b(obj2, ddVar);
                }
            }
            return;
        }
        b(obj, ddVar);
    }
}
