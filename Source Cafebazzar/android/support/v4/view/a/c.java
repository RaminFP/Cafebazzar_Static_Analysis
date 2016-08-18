package android.support.v4.view.a;

import android.view.accessibility.AccessibilityEvent;

final class c extends b {
    c() {
    }

    public final int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public final void a(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }
}
