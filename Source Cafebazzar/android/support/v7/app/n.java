package android.support.v7.app;

import android.content.Context;
import android.view.ContextThemeWrapper;

public final class n {
    public final f a;
    public int b;

    public n(Context context) {
        this(context, m.a(context, 0));
    }

    private n(Context context, int i) {
        this.a = new f(new ContextThemeWrapper(context, m.a(context, i)));
        this.b = i;
    }
}
