package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

final class f implements m {
    final /* synthetic */ a a;
    final /* synthetic */ e b;

    f(e eVar, a aVar) {
        this.b = eVar;
        this.a = aVar;
    }

    public final Object a(View view) {
        r accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
        return accessibilityNodeProvider != null ? accessibilityNodeProvider.a : null;
    }

    public final void a(View view, int i) {
        this.a.sendAccessibilityEvent(view, i);
    }

    public final void a(View view, Object obj) {
        this.a.onInitializeAccessibilityNodeInfo(view, new android.support.v4.view.a.f(obj));
    }

    public final boolean a(View view, int i, Bundle bundle) {
        return this.a.performAccessibilityAction(view, i, bundle);
    }

    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public final void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public final void d(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
