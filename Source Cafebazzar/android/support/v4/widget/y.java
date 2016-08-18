package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.a;
import android.support.v4.view.a.ae;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

final class y extends a {
    y() {
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        ae a = android.support.v4.view.a.a.a(accessibilityEvent);
        a.a(nestedScrollView.getScrollRange() > 0);
        ae.a.c(a.b, nestedScrollView.getScrollX());
        ae.a.d(a.b, nestedScrollView.getScrollY());
        ae.a.f(a.b, nestedScrollView.getScrollX());
        ae.a.g(a.b, nestedScrollView.getScrollRange());
    }

    public final void onInitializeAccessibilityNodeInfo(View view, f fVar) {
        super.onInitializeAccessibilityNodeInfo(view, fVar);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        fVar.a(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            int a = nestedScrollView.getScrollRange();
            if (a > 0) {
                fVar.a(true);
                if (nestedScrollView.getScrollY() > 0) {
                    fVar.a((int) FragmentTransaction.TRANSIT_EXIT_MASK);
                }
                if (nestedScrollView.getScrollY() < a) {
                    fVar.a(4096);
                }
            }
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int min;
        switch (i) {
            case 4096:
                min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.a(0, min);
                return true;
            case FragmentTransaction.TRANSIT_EXIT_MASK /*8192*/:
                min = nestedScrollView.getHeight();
                int paddingBottom = nestedScrollView.getPaddingBottom();
                min = Math.max(nestedScrollView.getScrollY() - ((min - paddingBottom) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.a(0, min);
                return true;
            default:
                return false;
        }
    }
}
