package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.a.l;
import android.support.v7.internal.a.e;
import android.view.KeyEvent;
import android.view.Window;
import android.view.Window.Callback;

abstract class q extends p {
    final Context a;
    final Window b;
    final Callback c = this.b.getCallback();
    final Callback d;
    final o e;
    a f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    CharSequence l;
    boolean m;

    q(Context context, Window window, o oVar) {
        this.a = context;
        this.b = window;
        this.e = oVar;
        if (this.c instanceof r) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = a(this.c);
        this.b.setCallback(this.d);
    }

    Callback a(Callback callback) {
        return new r(this, callback);
    }

    public void a(Bundle bundle) {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(l.Theme);
        if (obtainStyledAttributes.hasValue(l.Theme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(l.Theme_windowActionBar, false)) {
                this.g = true;
            }
            if (obtainStyledAttributes.getBoolean(l.Theme_windowActionBarOverlay, false)) {
                this.h = true;
            }
            if (obtainStyledAttributes.getBoolean(l.Theme_windowActionModeOverlay, false)) {
                this.i = true;
            }
            this.j = obtainStyledAttributes.getBoolean(l.Theme_android_windowIsFloating, false);
            this.k = obtainStyledAttributes.getBoolean(l.Theme_windowNoTitle, false);
            obtainStyledAttributes.recycle();
            return;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public final void a(CharSequence charSequence) {
        this.l = charSequence;
        b(charSequence);
    }

    abstract boolean a(int i, KeyEvent keyEvent);

    abstract boolean a(KeyEvent keyEvent);

    abstract void b(CharSequence charSequence);

    abstract boolean c(int i);

    abstract a d();

    abstract boolean d(int i);

    public final a e() {
        if (this.g) {
            if (this.f == null) {
                this.f = d();
            }
        } else if (this.f instanceof e) {
            this.f = null;
        }
        return this.f;
    }

    final Context f() {
        Context context = null;
        a e = e();
        if (e != null) {
            context = e.a();
        }
        return context == null ? this.a : context;
    }
}
