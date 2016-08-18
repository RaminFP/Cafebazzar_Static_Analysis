package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.n;
import android.support.v7.a.e;
import android.support.v7.a.g;
import android.support.v7.a.i;
import android.support.v7.a.j;
import android.support.v7.a.l;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public final class ActivityChooserView extends ViewGroup {
    n a;
    private final y b;
    private final z c;
    private final LinearLayoutCompat d;
    private final Drawable e;
    private final FrameLayout f;
    private final ImageView g;
    private final FrameLayout h;
    private final ImageView i;
    private final int j;
    private final DataSetObserver k;
    private final OnGlobalLayoutListener l;
    private ListPopupWindow m;
    private OnDismissListener n;
    private boolean o;
    private int p;
    private boolean q;
    private int r;

    public class InnerLayout extends LinearLayoutCompat {
        private static final int[] a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            bk bkVar = new bk(context, context.obtainStyledAttributes(attributeSet, a));
            setBackgroundDrawable(bkVar.a(0));
            bkVar.a.recycle();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    private ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.k = new u(this);
        this.l = new v(this);
        this.p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ActivityChooserView, 0, 0);
        this.p = obtainStyledAttributes.getInt(l.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(l.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(i.abc_activity_chooser_view, this, true);
        this.c = new z();
        this.d = (LinearLayoutCompat) findViewById(g.activity_chooser_view_content);
        this.e = this.d.getBackground();
        this.h = (FrameLayout) findViewById(g.default_activity_button);
        this.h.setOnClickListener(this.c);
        this.h.setOnLongClickListener(this.c);
        this.i = (ImageView) this.h.findViewById(g.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(g.expand_activities_button);
        frameLayout.setOnClickListener(this.c);
        frameLayout.setOnTouchListener(new w(this, frameLayout));
        this.f = frameLayout;
        this.g = (ImageView) frameLayout.findViewById(g.image);
        this.g.setImageDrawable(drawable);
        this.b = new y();
        this.b.registerDataSetObserver(new x(this));
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
    }

    private void a(int i) {
        if (this.b.a == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        boolean z = this.h.getVisibility() == 0;
        int a = this.b.a.a();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || a <= i2 + i) {
            this.b.a(false);
            this.b.a(i);
        } else {
            this.b.a(true);
            this.b.a(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.o || !z) {
                this.b.a(true, z);
            } else {
                this.b.a(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.b.a(), this.j));
            listPopupWindow.show();
            if (this.a != null) {
                this.a.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(j.abc_activitychooserview_choose_application));
        }
    }

    static /* synthetic */ void c(ActivityChooserView activityChooserView) {
        if (activityChooserView.b.getCount() > 0) {
            activityChooserView.f.setEnabled(true);
        } else {
            activityChooserView.f.setEnabled(false);
        }
        int a = activityChooserView.b.a.a();
        int c = activityChooserView.b.a.c();
        if (a == 1 || (a > 1 && c > 0)) {
            activityChooserView.h.setVisibility(0);
            ResolveInfo b = activityChooserView.b.a.b();
            PackageManager packageManager = activityChooserView.getContext().getPackageManager();
            activityChooserView.i.setImageDrawable(b.loadIcon(packageManager));
            if (activityChooserView.r != 0) {
                CharSequence loadLabel = b.loadLabel(packageManager);
                activityChooserView.h.setContentDescription(activityChooserView.getContext().getString(activityChooserView.r, new Object[]{loadLabel}));
            }
        } else {
            activityChooserView.h.setVisibility(8);
        }
        if (activityChooserView.h.getVisibility() == 0) {
            activityChooserView.d.setBackgroundDrawable(activityChooserView.e);
        } else {
            activityChooserView.d.setBackgroundDrawable(null);
        }
    }

    public final boolean a() {
        if (getListPopupWindow().isShowing() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    public final boolean b() {
        if (getListPopupWindow().isShowing()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.l);
            }
        }
        return true;
    }

    public final n getDataModel() {
        return this.b.a;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.m == null) {
            this.m = new ListPopupWindow(getContext());
            this.m.setAdapter(this.b);
            this.m.setAnchorView(this);
            this.m.setModal(true);
            this.m.setOnItemClickListener(this.c);
            this.m.setOnDismissListener(this.c);
        }
        return this.m;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        n nVar = this.b.a;
        if (nVar != null) {
            nVar.registerObserver(this.k);
        }
        this.q = true;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.b.a;
        if (nVar != null) {
            nVar.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (getListPopupWindow().isShowing()) {
            b();
        }
        this.q = false;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.d.layout(0, 0, i3 - i, i4 - i2);
        if (!getListPopupWindow().isShowing()) {
            b();
        }
    }

    protected final void onMeasure(int i, int i2) {
        View view = this.d;
        if (this.h.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public final void setActivityChooserModel(n nVar) {
        y yVar = this.b;
        n nVar2 = yVar.c.b.a;
        if (nVar2 != null && yVar.c.isShown()) {
            nVar2.unregisterObserver(yVar.c.k);
        }
        yVar.a = nVar;
        if (nVar != null && yVar.c.isShown()) {
            nVar.registerObserver(yVar.c.k);
        }
        yVar.notifyDataSetChanged();
        if (getListPopupWindow().isShowing()) {
            b();
            a();
        }
    }

    public final void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    public final void setExpandActivityOverflowButtonContentDescription(int i) {
        this.g.setContentDescription(getContext().getString(i));
    }

    public final void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.g.setImageDrawable(drawable);
    }

    public final void setInitialActivityCount(int i) {
        this.p = i;
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public final void setProvider(n nVar) {
        this.a = nVar;
    }
}
