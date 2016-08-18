package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.a.b;
import android.support.v7.a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public final class d {
    TextView A;
    public TextView B;
    public View C;
    public ListAdapter D;
    public int E = -1;
    int F;
    int G;
    public int H;
    public int I;
    public int J;
    public int K;
    int L = 0;
    Handler M;
    final OnClickListener N = new e(this);
    public final Context a;
    final ae b;
    final Window c;
    CharSequence d;
    public CharSequence e;
    public ListView f;
    public View g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m = false;
    Button n;
    CharSequence o;
    Message p;
    Button q;
    CharSequence r;
    Message s;
    Button t;
    CharSequence u;
    Message v;
    ScrollView w;
    public int x = 0;
    public Drawable y;
    public ImageView z;

    public d(Context context, ae aeVar, Window window) {
        this.a = context;
        this.b = aeVar;
        this.c = window;
        this.M = new k(aeVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, l.AlertDialog, b.alertDialogStyle, 0);
        this.F = obtainStyledAttributes.getResourceId(l.AlertDialog_android_layout, 0);
        this.G = obtainStyledAttributes.getResourceId(l.AlertDialog_buttonPanelSideLayout, 0);
        this.H = obtainStyledAttributes.getResourceId(l.AlertDialog_listLayout, 0);
        this.I = obtainStyledAttributes.getResourceId(l.AlertDialog_multiChoiceItemLayout, 0);
        this.J = obtainStyledAttributes.getResourceId(l.AlertDialog_singleChoiceItemLayout, 0);
        this.K = obtainStyledAttributes.getResourceId(l.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }

    static void a(Button button) {
        LayoutParams layoutParams = (LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i) {
        this.y = null;
        this.x = i;
        if (this.z == null) {
            return;
        }
        if (i != 0) {
            this.z.setImageResource(this.x);
        } else {
            this.z.setVisibility(8);
        }
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.u = charSequence;
                this.v = message;
                return;
            case -2:
                this.r = charSequence;
                this.s = message;
                return;
            case -1:
                this.o = charSequence;
                this.p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void a(CharSequence charSequence) {
        this.d = charSequence;
        if (this.A != null) {
            this.A.setText(charSequence);
        }
    }
}
