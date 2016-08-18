package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public final class e extends m {
    EditText a;
    View b;
    TextView c;
    boolean d = false;

    public e(Activity activity) {
        super(activity, 2131165367);
        View inflate = LayoutInflater.from(this.f).inflate(2130903098, null);
        this.c = (TextView) inflate.findViewById(2131624042);
        this.a = (EditText) inflate.findViewById(2131624085);
        this.b = inflate.findViewById(2131624255);
        super.a(inflate);
        a(2131165550, new f(this));
        c(2131165323, new g(this));
        this.e.setOnDismissListener(new h(this));
    }

    protected final void a(View view) {
        super.a(view);
    }
}
