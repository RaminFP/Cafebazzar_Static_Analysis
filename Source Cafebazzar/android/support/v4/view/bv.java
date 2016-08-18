package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class bv extends bt {
    static Field b;
    static boolean c = false;

    bv() {
    }

    public final void a(View view, a aVar) {
        view.setAccessibilityDelegate((AccessibilityDelegate) (aVar == null ? null : aVar.getBridge()));
    }

    public final boolean a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public final boolean b(View view) {
        if (c) {
            return false;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                c = true;
                return false;
            }
        }
        try {
            return b.get(view) != null;
        } catch (Throwable th2) {
            c = true;
            return false;
        }
    }

    public final boolean b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public final di s(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        di diVar = (di) this.a.get(view);
        if (diVar != null) {
            return diVar;
        }
        diVar = new di(view);
        this.a.put(view, diVar);
        return diVar;
    }
}
