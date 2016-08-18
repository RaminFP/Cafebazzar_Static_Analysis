package android.support.v4.f;

public final class f implements Cloneable {
    public static final Object a = new Object();
    public boolean b;
    public long[] c;
    public Object[] d;
    public int e;

    public f() {
        this(10);
    }

    private f(int i) {
        this.b = false;
        int b = c.b(10);
        this.c = new long[b];
        this.d = new Object[b];
        this.e = 0;
    }

    private long b(int i) {
        if (this.b) {
            a();
        }
        return this.c[i];
    }

    private f c() {
        try {
            f fVar = (f) super.clone();
            try {
                fVar.c = (long[]) this.c.clone();
                fVar.d = (Object[]) this.d.clone();
                return fVar;
            } catch (CloneNotSupportedException e) {
                return fVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final Object a(int i) {
        if (this.b) {
            a();
        }
        return this.d[i];
    }

    public void a() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public final int b() {
        if (this.b) {
            a();
        }
        return this.e;
    }

    public final /* synthetic */ Object clone() {
        return c();
    }

    public final String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(b(i));
            stringBuilder.append('=');
            f a = a(i);
            if (a != this) {
                stringBuilder.append(a);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
