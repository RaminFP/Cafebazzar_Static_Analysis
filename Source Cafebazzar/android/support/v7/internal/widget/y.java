package android.support.v7.internal.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.view.bp;
import android.support.v7.a.g;
import android.support.v7.a.i;
import android.support.v7.a.j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

final class y extends BaseAdapter {
    n a;
    boolean b;
    final /* synthetic */ ActivityChooserView c;
    private int d;
    private boolean e;
    private boolean f;

    private y(ActivityChooserView activityChooserView) {
        this.c = activityChooserView;
        this.d = 4;
    }

    public final int a() {
        int i = this.d;
        this.d = Integer.MAX_VALUE;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        int i2 = 0;
        View view = null;
        for (int i3 = 0; i3 < count; i3++) {
            view = getView(i3, view, null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        this.d = i;
        return i2;
    }

    public final void a(int i) {
        if (this.d != i) {
            this.d = i;
            notifyDataSetChanged();
        }
    }

    public final void a(boolean z) {
        if (this.f != z) {
            this.f = z;
            notifyDataSetChanged();
        }
    }

    public final void a(boolean z, boolean z2) {
        if (this.b != z || this.e != z2) {
            this.b = z;
            this.e = z2;
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        int a = this.a.a();
        if (!(this.b || this.a.b() == null)) {
            a--;
        }
        a = Math.min(a, this.d);
        return this.f ? a + 1 : a;
    }

    public final Object getItem(int i) {
        switch (getItemViewType(i)) {
            case 0:
                if (!(this.b || this.a.b() == null)) {
                    i++;
                }
                return this.a.a(i);
            case 1:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return (this.f && i == getCount() - 1) ? 1 : 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getId() != g.list_item) {
                    view = LayoutInflater.from(this.c.getContext()).inflate(i.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.c.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(g.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(g.title)).setText(resolveInfo.loadLabel(packageManager));
                if (this.b && i == 0 && this.e) {
                    bp.b(view, true);
                    return view;
                }
                bp.b(view, false);
                return view;
            case 1:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                view = LayoutInflater.from(this.c.getContext()).inflate(i.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView) view.findViewById(g.title)).setText(this.c.getContext().getString(j.abc_activity_chooser_view_see_all));
                return view;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final int getViewTypeCount() {
        return 3;
    }
}
