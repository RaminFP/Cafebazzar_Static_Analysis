package android.support.v4.f;

public final class q implements p {
    private final Object[] a;
    private int b;

    public q(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i];
    }

    public final Object a() {
        if (this.b <= 0) {
            return null;
        }
        int i = this.b - 1;
        Object obj = this.a[i];
        this.a[i] = null;
        this.b--;
        return obj;
    }

    public final boolean a(Object obj) {
        boolean z;
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == obj) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.b >= this.a.length) {
            return false;
        } else {
            this.a[this.b] = obj;
            this.b++;
            return true;
        }
    }
}
