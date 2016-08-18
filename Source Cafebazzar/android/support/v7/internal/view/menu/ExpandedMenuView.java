package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements k, z, OnItemClickListener {
    private static final int[] a = new int[]{16842964, 16843049};
    private i b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        bk a = bk.a(context, attributeSet, a, i, 0);
        if (a.d(0)) {
            setBackgroundDrawable(a.a(0));
        }
        if (a.d(1)) {
            setDivider(a.a(1));
        }
        a.a.recycle();
    }

    public final int getWindowAnimations() {
        return this.c;
    }

    public final void initialize(i iVar) {
        this.b = iVar;
    }

    public final boolean invokeItem(m mVar) {
        return this.b.a((MenuItem) mVar, null, 0);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((m) getAdapter().getItem(i));
    }
}
