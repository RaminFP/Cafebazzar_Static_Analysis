package android.support.v4.b;

import android.support.v4.f.d;

public final class g {
    public int a;
    public i b;
    public h c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public final void a(h hVar) {
        if (this.c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.c != hVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.c = null;
        }
    }

    public final void a(i iVar) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.b != iVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.b = null;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
