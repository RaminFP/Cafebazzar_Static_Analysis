package android.support.v7.e;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public abstract class a {
    public Object b;
    public boolean c;

    public abstract MenuInflater a();

    public abstract void a(int i);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public void a(boolean z) {
        this.c = z;
    }

    public abstract Menu b();

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public boolean h() {
        return false;
    }

    public abstract View i();
}
