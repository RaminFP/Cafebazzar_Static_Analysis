package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;

public final class f {
    public static final j a;
    public final Object b;

    static {
        if (VERSION.SDK_INT >= 22) {
            a = new h();
        } else if (VERSION.SDK_INT >= 21) {
            a = new g();
        } else if (VERSION.SDK_INT >= 19) {
            a = new n();
        } else if (VERSION.SDK_INT >= 18) {
            a = new m();
        } else if (VERSION.SDK_INT >= 17) {
            a = new l();
        } else if (VERSION.SDK_INT >= 16) {
            a = new k();
        } else if (VERSION.SDK_INT >= 14) {
            a = new i();
        } else {
            a = new o();
        }
    }

    public f(Object obj) {
        this.b = obj;
    }

    public final void a(int i) {
        a.a(this.b, i);
    }

    public final void a(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public final void a(Object obj) {
        a.b(this.b, ((q) obj).a);
    }

    public final void a(boolean z) {
        a.a(this.b, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            if (this.b == null) {
                if (fVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(fVar.b)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a.a(this.b, rect);
        stringBuilder.append("; boundsInParent: " + rect);
        a.b(this.b, rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(a.d(this.b));
        stringBuilder.append("; className: ").append(a.b(this.b));
        stringBuilder.append("; text: ").append(a.e(this.b));
        stringBuilder.append("; contentDescription: ").append(a.c(this.b));
        stringBuilder.append("; viewId: ").append(a.p(this.b));
        stringBuilder.append("; checkable: ").append(a.f(this.b));
        stringBuilder.append("; checked: ").append(a.g(this.b));
        stringBuilder.append("; focusable: ").append(a.j(this.b));
        stringBuilder.append("; focused: ").append(a.k(this.b));
        stringBuilder.append("; selected: ").append(a.o(this.b));
        stringBuilder.append("; clickable: ").append(a.h(this.b));
        stringBuilder.append("; longClickable: ").append(a.l(this.b));
        stringBuilder.append("; enabled: ").append(a.i(this.b));
        stringBuilder.append("; password: ").append(a.m(this.b));
        stringBuilder.append("; scrollable: " + a.n(this.b));
        stringBuilder.append("; [");
        int a = a.a(this.b);
        while (a != 0) {
            String str;
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a);
            int i = (numberOfTrailingZeros ^ -1) & a;
            switch (numberOfTrailingZeros) {
                case 1:
                    str = "ACTION_FOCUS";
                    break;
                case 2:
                    str = "ACTION_CLEAR_FOCUS";
                    break;
                case 4:
                    str = "ACTION_SELECT";
                    break;
                case 8:
                    str = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    str = "ACTION_CLICK";
                    break;
                case 32:
                    str = "ACTION_LONG_CLICK";
                    break;
                case 64:
                    str = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case NotificationCompat.FLAG_HIGH_PRIORITY /*128*/:
                    str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case NotificationCompat.FLAG_LOCAL_ONLY /*256*/:
                    str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case NotificationCompat.FLAG_GROUP_SUMMARY /*512*/:
                    str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case 1024:
                    str = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case ItemAnimator.FLAG_MOVED /*2048*/:
                    str = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case 4096:
                    str = "ACTION_SCROLL_FORWARD";
                    break;
                case FragmentTransaction.TRANSIT_EXIT_MASK /*8192*/:
                    str = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    str = "ACTION_COPY";
                    break;
                case 32768:
                    str = "ACTION_PASTE";
                    break;
                case 65536:
                    str = "ACTION_CUT";
                    break;
                case 131072:
                    str = "ACTION_SET_SELECTION";
                    break;
                default:
                    str = "ACTION_UNKNOWN";
                    break;
            }
            stringBuilder.append(str);
            if (i != 0) {
                stringBuilder.append(", ");
            }
            a = i;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
