package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.internal.widget.am;

final class x implements am {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    x(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void a(Rect rect) {
        rect.top = AppCompatDelegateImplV7.b(this.a, rect.top);
    }
}
