package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class cg implements OnApplyWindowInsetsListener {
    final /* synthetic */ bi a;

    cg(bi biVar) {
        this.a = biVar;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((ec) this.a.a(view, new ec(windowInsets))).a;
    }
}
