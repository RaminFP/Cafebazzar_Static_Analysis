package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

final class az implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter a;
    private ListAdapter b;

    public az(SpinnerAdapter spinnerAdapter) {
        this.a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.b = (ListAdapter) spinnerAdapter;
        }
    }

    public final boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.b;
        return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
    }

    public final int getCount() {
        return this.a == null ? 0 : this.a.getCount();
    }

    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.a == null ? null : this.a.getDropDownView(i, view, viewGroup);
    }

    public final Object getItem(int i) {
        return this.a == null ? null : this.a.getItem(i);
    }

    public final long getItemId(int i) {
        return this.a == null ? -1 : this.a.getItemId(i);
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final boolean hasStableIds() {
        return this.a != null && this.a.hasStableIds();
    }

    public final boolean isEmpty() {
        return getCount() == 0;
    }

    public final boolean isEnabled(int i) {
        ListAdapter listAdapter = this.b;
        return listAdapter != null ? listAdapter.isEnabled(i) : true;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a != null) {
            this.a.registerDataSetObserver(dataSetObserver);
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.a != null) {
            this.a.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
