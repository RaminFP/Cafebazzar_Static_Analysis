package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.a.c;

public final class a {
    public Context a;

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public final boolean a() {
        return this.a.getApplicationInfo().targetSdkVersion >= 16 ? this.a.getResources().getBoolean(c.abc_action_bar_embed_tabs) : this.a.getResources().getBoolean(c.abc_action_bar_embed_tabs_pre_jb);
    }
}
