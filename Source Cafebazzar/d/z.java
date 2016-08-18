package d;

import android.support.v7.widget.RecyclerView.ItemAnimator;

final class z {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    z f;
    z g;

    z() {
        this.a = new byte[ItemAnimator.FLAG_MOVED];
        this.e = true;
        this.d = false;
    }

    z(z zVar) {
        this(zVar.a, zVar.b, zVar.c);
        zVar.d = true;
    }

    private z(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public final z a() {
        z zVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return zVar;
    }

    public final z a(z zVar) {
        zVar.g = this;
        zVar.f = this.f;
        this.f.g = zVar;
        this.f = zVar;
        return zVar;
    }

    public final void a(z zVar, int i) {
        if (zVar.e) {
            if (zVar.c + i > ItemAnimator.FLAG_MOVED) {
                if (zVar.d) {
                    throw new IllegalArgumentException();
                } else if ((zVar.c + i) - zVar.b > ItemAnimator.FLAG_MOVED) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(zVar.a, zVar.b, zVar.a, 0, zVar.c - zVar.b);
                    zVar.c -= zVar.b;
                    zVar.b = 0;
                }
            }
            System.arraycopy(this.a, this.b, zVar.a, zVar.c, i);
            zVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
