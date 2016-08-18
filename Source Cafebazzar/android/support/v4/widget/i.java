package android.support.v4.widget;

import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.view.View;

final class i extends a {
    public final void onInitializeAccessibilityNodeInfo(View view, f fVar) {
        super.onInitializeAccessibilityNodeInfo(view, fVar);
        if (!DrawerLayout.g(view)) {
            f.a.a(fVar.b, null);
        }
    }
}
