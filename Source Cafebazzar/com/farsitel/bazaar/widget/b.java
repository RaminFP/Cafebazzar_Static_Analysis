package com.farsitel.bazaar.widget;

import a.a.a.a.a.a;
import a.a.a.a.a.c;
import a.a.a.a.a.f;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public final class b {
    static final a a;
    private c b;
    private Activity c;
    private View d;

    static {
        a.a.a.a.a.b bVar = new a.a.a.a.a.b();
        bVar.a = -1;
        a = bVar.a();
    }

    public b(Activity activity, Integer num, Integer num2, ViewGroup viewGroup, int i, boolean z, OnClickListener onClickListener) {
        this(activity, activity.getResources().getText(num.intValue()).toString(), num2, viewGroup, i, z, onClickListener);
    }

    private b(Activity activity, String str, Integer num, ViewGroup viewGroup, int i, boolean z, OnClickListener onClickListener) {
        this.c = activity;
        this.d = activity.getLayoutInflater().inflate(2130903091, null);
        if (num != null) {
            ((ImageView) this.d.findViewById(2131624227)).setImageResource(num.intValue());
        } else {
            this.d.findViewById(2131624227).setVisibility(8);
        }
        if (str != null) {
            ((TextView) this.d.findViewById(2131624228)).setText(str);
        }
        switch (f.a[i - 1]) {
            case 1:
                this.d.findViewById(2131624226).setBackgroundColor(activity.getResources().getColor(2131558415));
                break;
            case 2:
                this.d.findViewById(2131624226).setBackgroundColor(activity.getResources().getColor(2131558416));
                break;
            case 3:
                this.d.findViewById(2131624226).setBackgroundColor(activity.getResources().getColor(2131558417));
                ((TextView) this.d.findViewById(2131624228)).setTextColor(-16777216);
                break;
        }
        if (onClickListener != null) {
            this.d.setOnClickListener(new c(this, onClickListener));
        } else {
            this.d.setOnClickListener(new e(this));
        }
        if (viewGroup != null) {
            this.b = new c(activity, this.d, viewGroup);
        } else {
            this.b = new c(activity, this.d);
        }
        if (z) {
            this.b.b = a;
        }
    }

    public static void b() {
        f a = f.a();
        a.removeMessages(-1040157475);
        a.removeMessages(794631);
        a.removeMessages(-1040155167);
        for (c b : a.a) {
            f.b(b);
        }
        a.a.clear();
    }

    public final void a() {
        if (this.b != null) {
            c cVar = this.b;
            f a = f.a();
            a.a.add(cVar);
            a.b();
        }
    }
}
