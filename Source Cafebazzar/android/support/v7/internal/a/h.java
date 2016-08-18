package android.support.v7.internal.a;

import android.support.v4.view.ea;
import android.view.View;

final class h implements ea {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final void a() {
        ((View) this.a.o.getParent()).invalidate();
    }
}
