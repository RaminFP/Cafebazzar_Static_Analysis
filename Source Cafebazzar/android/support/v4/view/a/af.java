package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

class af extends aj {
    af() {
    }

    public final Object a() {
        return AccessibilityRecord.obtain();
    }

    public final void a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public final void a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public final void b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public final void c(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    public final void d(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    public final void e(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
