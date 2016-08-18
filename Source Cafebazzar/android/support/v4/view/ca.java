package android.support.v4.view;

import android.view.View;
import android.view.WindowInsets;

class ca extends bz {
    ca() {
    }

    public final eb a(View view, eb ebVar) {
        if (!(ebVar instanceof ec)) {
            return ebVar;
        }
        WindowInsets windowInsets = ((ec) ebVar).a;
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        return onApplyWindowInsets != windowInsets ? new ec(onApplyWindowInsets) : ebVar;
    }

    public final void a(View view, bi biVar) {
        if (biVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new cg(biVar));
        }
    }

    public final eb b(View view, eb ebVar) {
        if (!(ebVar instanceof ec)) {
            return ebVar;
        }
        WindowInsets windowInsets = ((ec) ebVar).a;
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        return dispatchApplyWindowInsets != windowInsets ? new ec(dispatchApplyWindowInsets) : ebVar;
    }

    public final void e(View view, float f) {
        view.setElevation(f);
    }

    public final void u(View view) {
        view.requestApplyInsets();
    }

    public final float v(View view) {
        return view.getElevation();
    }

    public final void y(View view) {
        view.stopNestedScroll();
    }
}
