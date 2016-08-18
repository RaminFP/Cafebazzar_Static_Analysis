package com.farsitel.bazaar.g.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;

public abstract class f {
    public final String b;
    Bundle c;

    protected f(String str) {
        this.b = str;
    }

    public abstract int a();

    public abstract OnClickListener a(Context context);
}
