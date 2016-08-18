package android.support.v4.f;

public final class s implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public s() {
        this(10);
    }

    public s(int i) {
        this.b = false;
        if (i == 0) {
            this.c = c.a;
            this.d = c.c;
        } else {
            int a = c.a(i);
            this.c = new int[a];
            this.d = new Object[a];
        }
        this.e = 0;
    }

    private s c() {
        try {
            s sVar = (s) super.clone();
            try {
                sVar.c = (int[]) this.c.clone();
                sVar.d = (Object[]) this.d.clone();
                return sVar;
            } catch (CloneNotSupportedException e) {
                return sVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public final int a() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public final Object a(int i) {
        int a = c.a(this.c, this.e, i);
        return (a < 0 || this.d[a] == a) ? null : this.d[a];
    }

    public final void a(int i, Object obj) {
        int a = c.a(this.c, this.e, i);
        if (a >= 0) {
            this.d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.e || this.d[a] != a) {
            if (this.b && this.e >= this.c.length) {
                d();
                a = c.a(this.c, this.e, i) ^ -1;
            }
            if (this.e >= this.c.length) {
                int a2 = c.a(this.e + 1);
                Object obj2 = new int[a2];
                Object obj3 = new Object[a2];
                System.arraycopy(this.c, 0, obj2, 0, this.c.length);
                System.arraycopy(this.d, 0, obj3, 0, this.d.length);
                this.c = obj2;
                this.d = obj3;
            }
            if (this.e - a != 0) {
                System.arraycopy(this.c, a, this.c, a + 1, this.e - a);
                System.arraycopy(this.d, a, this.d, a + 1, this.e - a);
            }
            this.c[a] = i;
            this.d[a] = obj;
            this.e++;
            return;
        }
        this.c[a] = i;
        this.d[a] = obj;
    }

    public final void b() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public final void b(int i) {
        int a = c.a(this.c, this.e, i);
        if (a >= 0 && this.d[a] != a) {
            this.d[a] = a;
            this.b = true;
        }
    }

    public final void c(int i) {
        if (this.d[i] != a) {
            this.d[i] = a;
            this.b = true;
        }
    }

    public final /* synthetic */ Object clone() {
        return c();
    }

    public final int d(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public final Object e(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public final int f(int i) {
        if (this.b) {
            d();
        }
        return c.a(this.c, this.e, i);
    }

    public final String toString() {
        if (a() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(d(i));
            stringBuilder.append('=');
            s e = e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
