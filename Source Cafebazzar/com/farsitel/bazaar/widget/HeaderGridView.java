package com.farsitel.bazaar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class HeaderGridView extends GridView {
    private ArrayList a = new ArrayList();

    public HeaderGridView(Context context) {
        super(context);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setClipChildren(false);
    }

    public final void a(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter == null || (adapter instanceof r)) {
            p pVar = new p();
            ViewGroup qVar = new q(this, getContext());
            qVar.addView(view);
            pVar.a = view;
            pVar.b = qVar;
            pVar.c = null;
            pVar.d = z;
            this.a.add(pVar);
            if (adapter != null) {
                ((r) adapter).a.notifyChanged();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public int getHeaderViewCount() {
        return this.a.size();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof r)) {
            ((r) adapter).a(getNumColumns());
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.a.size() > 0) {
            ListAdapter rVar = new r(this.a, listAdapter);
            int numColumns = getNumColumns();
            if (numColumns > 1) {
                rVar.a(numColumns);
            }
            super.setAdapter(rVar);
            return;
        }
        super.setAdapter(listAdapter);
    }

    public void setClipChildren(boolean z) {
    }
}
