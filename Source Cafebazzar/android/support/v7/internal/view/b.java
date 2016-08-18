package android.support.v7.internal.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.a.k;
import android.view.LayoutInflater;

public final class b extends ContextWrapper {
    public int a;
    private Theme b;
    private LayoutInflater c;

    public b(Context context, int i) {
        super(context);
        this.a = i;
    }

    private void a() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.a, true);
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    public final Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = k.Theme_AppCompat_Light;
        }
        a();
        return this.b;
    }

    public final void setTheme(int i) {
        this.a = i;
        a();
    }
}
