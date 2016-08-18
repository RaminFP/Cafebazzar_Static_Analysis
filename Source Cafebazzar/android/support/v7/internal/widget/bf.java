package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

public final class bf extends ContextWrapper {
    private Resources a;

    private bf(Context context) {
        super(context);
    }

    public static Context a(Context context) {
        return !(context instanceof bf) ? new bf(context) : context;
    }

    public final Resources getResources() {
        if (this.a == null) {
            this.a = new bg(super.getResources(), bi.a((Context) this));
        }
        return this.a;
    }
}
