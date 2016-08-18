package com.farsitel.bazaar.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.ab;
import com.farsitel.bazaar.util.o;

public final class ac extends Toast {
    private final String a;
    private final Context b;
    private final ImageView c;

    public ac(Context context, String str) {
        super(context);
        this.b = context;
        this.a = j.a().l() + "I/" + str + "_" + o.b() + ".jpg";
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Math.min(displayMetrics.widthPixels, 48);
        this.c = new ImageView(context);
        setView(this.c);
        setDuration(0);
    }

    public final void show() {
        ab.a().a(this.a, this.c, new ad(this));
    }
}
