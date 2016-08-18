package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class ac extends AccessibilityNodeProvider {
    final /* synthetic */ ad a;

    ac(ad adVar) {
        this.a = adVar;
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.a.a(i);
    }

    public final List findAccessibilityNodeInfosByText(String str, int i) {
        return this.a.a(str, i);
    }

    public final AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.a.b(i);
    }

    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.a(i, i2, bundle);
    }
}
