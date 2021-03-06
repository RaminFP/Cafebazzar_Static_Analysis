package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.a.ae;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class cu extends a {
    final /* synthetic */ ViewPager a;

    cu(ViewPager viewPager) {
        this.a = viewPager;
    }

    private boolean a() {
        return this.a.i != null && this.a.i.getCount() > 1;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        ae a = ae.a();
        a.a(a());
        if (accessibilityEvent.getEventType() == 4096 && this.a.i != null) {
            a.a(this.a.i.getCount());
            a.b(this.a.j);
            a.c(this.a.j);
        }
    }

    public final void onInitializeAccessibilityNodeInfo(View view, f fVar) {
        super.onInitializeAccessibilityNodeInfo(view, fVar);
        fVar.a(ViewPager.class.getName());
        fVar.a(a());
        if (this.a.canScrollHorizontally(1)) {
            fVar.a(4096);
        }
        if (this.a.canScrollHorizontally(-1)) {
            fVar.a((int) FragmentTransaction.TRANSIT_EXIT_MASK);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.a.canScrollHorizontally(1)) {
                    return false;
                }
                this.a.setCurrentItem(this.a.j + 1);
                return true;
            case FragmentTransaction.TRANSIT_EXIT_MASK /*8192*/:
                if (!this.a.canScrollHorizontally(-1)) {
                    return false;
                }
                this.a.setCurrentItem(this.a.j - 1);
                return true;
            default:
                return false;
        }
    }
}
