package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class bf {
    public boolean a;
    private final View b;
    private ViewParent c;
    private int[] d;

    public bf(View view) {
        this.b = view;
    }

    public final void a(boolean z) {
        if (this.a) {
            bp.y(this.b);
        }
        this.a = z;
    }

    public final boolean a() {
        return this.c != null;
    }

    public final boolean a(float f, float f2) {
        return (!this.a || this.c == null) ? false : db.a(this.c, this.b, f, f2);
    }

    public final boolean a(float f, float f2, boolean z) {
        return (!this.a || this.c == null) ? false : db.a(this.c, this.b, f, f2, z);
    }

    public final boolean a(int i) {
        if (a()) {
            return true;
        }
        if (this.a) {
            View view = this.b;
            for (ViewParent parent = this.b.getParent(); parent != null; parent = parent.getParent()) {
                if (db.a(parent, view, this.b, i)) {
                    this.c = parent;
                    db.b(parent, view, this.b, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public final boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!this.a || this.c == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.b.getLocationInWindow(iArr);
                i5 = iArr[0];
                i6 = iArr[1];
            } else {
                i5 = 0;
                i6 = 0;
            }
            db.a(this.c, this.b, i, i2, i3, i4);
            if (iArr != null) {
                this.b.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i5;
                iArr[1] = iArr[1] - i6;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public final boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!this.a || this.c == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.b.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                if (this.d == null) {
                    this.d = new int[2];
                }
                iArr = this.d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            db.a(this.c, this.b, i, i2, iArr);
            if (iArr2 != null) {
                this.b.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public final void b() {
        if (this.c != null) {
            db.a(this.c, this.b);
            this.c = null;
        }
    }
}
