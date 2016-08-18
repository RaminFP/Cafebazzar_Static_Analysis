package com.farsitel.bazaar.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.a.g;
import android.text.Html;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class m {
    private String a;
    private View b;
    public final AlertDialog e;
    public final Activity f;
    public n g;

    public m(Activity activity, int i) {
        this(activity, activity.getString(i));
    }

    public m(Activity activity, int i, boolean z) {
        this(activity, activity.getString(i), true);
    }

    private m(Activity activity, String str) {
        this(activity, str, true);
    }

    public m(Activity activity, String str, boolean z) {
        this.f = activity;
        this.b = LayoutInflater.from(activity).inflate(2130903092, null);
        this.a = str;
        TextView textView = (TextView) this.b.findViewById(g.title);
        if (this.a == null || TextUtils.isEmpty(this.a)) {
            textView.setVisibility(8);
        } else {
            textView.setText(Html.fromHtml(this.a));
        }
        this.e = new Builder(new ContextThemeWrapper(activity, 2131427450)).setCancelable(z).setView(this.b).create();
        this.e.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.e.requestWindowFeature(1);
        this.e.setInverseBackgroundForced(true);
    }

    public final void a(int i) {
        this.b.setBackgroundResource(17170443);
    }

    protected final void a(int i, OnClickListener onClickListener) {
        if (i != 0) {
            Button button = (Button) this.b.findViewById(2131624229);
            button.setText(this.f.getString(i).toUpperCase());
            button.setOnClickListener(onClickListener);
            button.setVisibility(0);
        }
    }

    public final void a(OnCancelListener onCancelListener) {
        this.e.setOnCancelListener(onCancelListener);
    }

    public void a(View view) {
        ((FrameLayout) this.b.findViewById(2131624098)).addView(view, -1, -2);
    }

    public final void a(boolean z) {
        Button button = (Button) this.b.findViewById(2131624229);
        if (button.getVisibility() == 0) {
            button.setEnabled(z);
        }
    }

    public final void a(boolean z, Drawable drawable) {
        this.b.findViewById(g.action_bar).setVisibility(z ? 0 : 8);
        if (drawable != null) {
            ((ImageView) this.b.findViewById(g.icon)).setImageDrawable(drawable);
        }
    }

    protected final void b(int i, OnClickListener onClickListener) {
        if (i != 0) {
            Button button = (Button) this.b.findViewById(2131624230);
            button.setText(this.f.getString(i).toUpperCase());
            button.setOnClickListener(onClickListener);
            button.setVisibility(0);
        }
    }

    protected final void c(int i, OnClickListener onClickListener) {
        if (i != 0) {
            Button button = (Button) this.b.findViewById(2131624231);
            button.setText(this.f.getString(i).toUpperCase());
            button.setOnClickListener(onClickListener);
            button.setVisibility(0);
        }
    }

    public final void d() {
        if (this.g != null) {
            this.g.a();
        }
    }

    public final void e() {
        if (this.g != null) {
            this.g.b();
        }
    }
}
