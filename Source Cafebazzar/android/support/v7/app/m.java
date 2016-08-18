package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.a.b;
import android.support.v7.a.g;
import android.support.v7.a.l;
import android.support.v7.internal.widget.bk;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public final class m extends ae implements DialogInterface {
    private d a = new d(getContext(), this, getWindow());

    public m(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected final void onCreate(Bundle bundle) {
        int indexOfChild;
        boolean z = false;
        super.onCreate(bundle);
        d dVar = this.a;
        dVar.b.a().b(1);
        int i = (dVar.G == 0 || dVar.L != 1) ? dVar.F : dVar.G;
        dVar.b.setContentView(i);
        ViewGroup viewGroup = (ViewGroup) dVar.c.findViewById(g.contentPanel);
        dVar.w = (ScrollView) dVar.c.findViewById(g.scrollView);
        dVar.w.setFocusable(false);
        dVar.B = (TextView) dVar.c.findViewById(16908299);
        if (dVar.B != null) {
            if (dVar.e != null) {
                dVar.B.setText(dVar.e);
            } else {
                dVar.B.setVisibility(8);
                dVar.w.removeView(dVar.B);
                if (dVar.f != null) {
                    viewGroup = (ViewGroup) dVar.w.getParent();
                    indexOfChild = viewGroup.indexOfChild(dVar.w);
                    viewGroup.removeViewAt(indexOfChild);
                    viewGroup.addView(dVar.f, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    viewGroup.setVisibility(8);
                }
            }
        }
        dVar.n = (Button) dVar.c.findViewById(16908313);
        dVar.n.setOnClickListener(dVar.N);
        if (TextUtils.isEmpty(dVar.o)) {
            dVar.n.setVisibility(8);
            indexOfChild = 0;
        } else {
            dVar.n.setText(dVar.o);
            dVar.n.setVisibility(0);
            indexOfChild = 1;
        }
        dVar.q = (Button) dVar.c.findViewById(16908314);
        dVar.q.setOnClickListener(dVar.N);
        if (TextUtils.isEmpty(dVar.r)) {
            dVar.q.setVisibility(8);
        } else {
            dVar.q.setText(dVar.r);
            dVar.q.setVisibility(0);
            indexOfChild |= 2;
        }
        dVar.t = (Button) dVar.c.findViewById(16908315);
        dVar.t.setOnClickListener(dVar.N);
        if (TextUtils.isEmpty(dVar.u)) {
            dVar.t.setVisibility(8);
        } else {
            dVar.t.setText(dVar.u);
            dVar.t.setVisibility(0);
            indexOfChild |= 4;
        }
        Context context = dVar.a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (indexOfChild == 1) {
                d.a(dVar.n);
            } else if (indexOfChild == 2) {
                d.a(dVar.q);
            } else if (indexOfChild == 4) {
                d.a(dVar.t);
            }
        }
        boolean z2 = indexOfChild != 0;
        viewGroup = (ViewGroup) dVar.c.findViewById(g.topPanel);
        bk a = bk.a(dVar.a, null, l.AlertDialog, b.alertDialogStyle, 0);
        if (dVar.C != null) {
            viewGroup.addView(dVar.C, 0, new LayoutParams(-1, -2));
            dVar.c.findViewById(g.title_template).setVisibility(8);
        } else {
            dVar.z = (ImageView) dVar.c.findViewById(16908294);
            if (!TextUtils.isEmpty(dVar.d)) {
                dVar.A = (TextView) dVar.c.findViewById(g.alertTitle);
                dVar.A.setText(dVar.d);
                if (dVar.x != 0) {
                    dVar.z.setImageResource(dVar.x);
                } else if (dVar.y != null) {
                    dVar.z.setImageDrawable(dVar.y);
                } else {
                    dVar.A.setPadding(dVar.z.getPaddingLeft(), dVar.z.getPaddingTop(), dVar.z.getPaddingRight(), dVar.z.getPaddingBottom());
                    dVar.z.setVisibility(8);
                }
            } else {
                dVar.c.findViewById(g.title_template).setVisibility(8);
                dVar.z.setVisibility(8);
                viewGroup.setVisibility(8);
            }
        }
        View findViewById = dVar.c.findViewById(g.buttonPanel);
        if (!z2) {
            findViewById.setVisibility(8);
            findViewById = dVar.c.findViewById(g.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        FrameLayout frameLayout = (FrameLayout) dVar.c.findViewById(g.customPanel);
        View inflate = dVar.g != null ? dVar.g : dVar.h != 0 ? LayoutInflater.from(dVar.a).inflate(dVar.h, frameLayout, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && d.a(inflate))) {
            dVar.c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout2 = (FrameLayout) dVar.c.findViewById(g.custom);
            frameLayout2.addView(inflate, new LayoutParams(-1, -1));
            if (dVar.m) {
                frameLayout2.setPadding(dVar.i, dVar.j, dVar.k, dVar.l);
            }
            if (dVar.f != null) {
                ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).weight = 0.0f;
            }
        } else {
            frameLayout.setVisibility(8);
        }
        ListView listView = dVar.f;
        if (!(listView == null || dVar.D == null)) {
            listView.setAdapter(dVar.D);
            indexOfChild = dVar.E;
            if (indexOfChild >= 0) {
                listView.setItemChecked(indexOfChild, true);
                listView.setSelection(indexOfChild);
            }
        }
        a.a.recycle();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        d dVar = this.a;
        boolean z = dVar.w != null && dVar.w.executeKeyEvent(keyEvent);
        return z ? true : super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        d dVar = this.a;
        boolean z = dVar.w != null && dVar.w.executeKeyEvent(keyEvent);
        return z ? true : super.onKeyUp(i, keyEvent);
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }
}
