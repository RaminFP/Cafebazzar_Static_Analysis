package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public final class a extends m {
    EditText a;
    View b;
    TextView c;

    public a(Activity activity) {
        super(activity, 2131165366);
        View inflate = LayoutInflater.from(this.f).inflate(2130903097, null);
        this.c = (TextView) inflate.findViewById(2131624042);
        this.a = (EditText) inflate.findViewById(2131624083);
        this.b = inflate.findViewById(2131624255);
        super.a(inflate);
        a(2131165550, new b(this));
        c(2131165323, new c(this));
    }

    protected final void a(View view) {
        super.a(view);
    }
}
