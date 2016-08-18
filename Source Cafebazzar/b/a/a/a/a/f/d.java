package b.a.a.a.a.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import b.a.a.a.p;

public final class d implements c {
    private final SharedPreferences a;
    private final String b;
    private final Context c;

    public d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.c = context;
        this.b = str;
        this.a = this.c.getSharedPreferences(this.b, 0);
    }

    @Deprecated
    public d(p pVar) {
        this(pVar.p, pVar.getClass().getName());
    }

    public final SharedPreferences a() {
        return this.a;
    }

    @TargetApi(9)
    public final boolean a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }

    public final Editor b() {
        return this.a.edit();
    }
}
