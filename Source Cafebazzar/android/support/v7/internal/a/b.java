package android.support.v7.internal.a;

import android.content.Context;
import android.support.v4.view.bp;
import android.support.v7.app.a;
import android.support.v7.internal.widget.aj;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window.Callback;
import java.util.ArrayList;

public final class b extends a {
    aj a;
    Callback b;
    private boolean c;
    private boolean d;
    private ArrayList e;
    private final Runnable f;

    public final Context a() {
        return this.a.b();
    }

    public final void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public final void a(boolean z) {
    }

    public final boolean a(int i, KeyEvent keyEvent) {
        Menu d = d();
        return d != null ? d.performShortcut(i, keyEvent, 0) : false;
    }

    public final void b(boolean z) {
    }

    public final boolean b() {
        this.a.a().removeCallbacks(this.f);
        bp.a(this.a.a(), this.f);
        return true;
    }

    public final void c(boolean z) {
        if (z != this.d) {
            this.d = z;
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                this.e.get(i);
            }
        }
    }

    public final boolean c() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    Menu d() {
        if (!this.c) {
            this.a.a(new c(), new d());
            this.c = true;
        }
        return this.a.q();
    }
}
