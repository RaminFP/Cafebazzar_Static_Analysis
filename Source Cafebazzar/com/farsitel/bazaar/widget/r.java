package com.farsitel.bazaar.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

final class r implements Filterable, WrapperListAdapter {
    final DataSetObservable a = new DataSetObservable();
    ArrayList b;
    boolean c;
    private final ListAdapter d;
    private int e = 1;
    private final boolean f;

    public r(ArrayList arrayList, ListAdapter listAdapter) {
        this.d = listAdapter;
        this.f = listAdapter instanceof Filterable;
        if (arrayList == null) {
            throw new IllegalArgumentException("headerViewInfos cannot be null");
        }
        this.b = arrayList;
        this.c = a(this.b);
    }

    private static boolean a(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((p) it.next()).d) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Number of columns must be 1 or more");
        } else if (this.e != i) {
            this.e = i;
            this.a.notifyChanged();
        }
    }

    public final boolean areAllItemsEnabled() {
        return this.d == null || (this.c && this.d.areAllItemsEnabled());
    }

    public final int getCount() {
        return this.d != null ? (this.b.size() * this.e) + this.d.getCount() : this.b.size() * this.e;
    }

    public final Filter getFilter() {
        return this.f ? ((Filterable) this.d).getFilter() : null;
    }

    public final Object getItem(int i) {
        int size = this.b.size() * this.e;
        if (i < size) {
            return i % this.e == 0 ? ((p) this.b.get(i / this.e)).c : null;
        } else {
            size = i - size;
            if (this.d != null && size < this.d.getCount()) {
                return this.d.getItem(size);
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public final long getItemId(int i) {
        int size = this.b.size() * this.e;
        if (this.d != null && i >= size) {
            size = i - size;
            if (size < this.d.getCount()) {
                return this.d.getItemId(size);
            }
        }
        return -1;
    }

    public final int getItemViewType(int i) {
        int size = this.b.size() * this.e;
        if (i < size && i % this.e != 0) {
            return this.d != null ? this.d.getViewTypeCount() : 1;
        } else {
            if (this.d != null && i >= size) {
                size = i - size;
                if (size < this.d.getCount()) {
                    return this.d.getItemViewType(size);
                }
            }
            return -2;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int size = this.b.size() * this.e;
        if (i < size) {
            View view2 = ((p) this.b.get(i / this.e)).b;
            if (i % this.e == 0) {
                return view2;
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            view.setMinimumHeight(view2.getHeight());
            return view;
        }
        size = i - size;
        if (this.d != null && size < this.d.getCount()) {
            return this.d.getView(size, view, viewGroup);
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final int getViewTypeCount() {
        return this.d != null ? this.d.getViewTypeCount() + 1 : 2;
    }

    public final ListAdapter getWrappedAdapter() {
        return this.d;
    }

    public final boolean hasStableIds() {
        return this.d != null ? this.d.hasStableIds() : false;
    }

    public final boolean isEmpty() {
        return (this.d == null || this.d.isEmpty()) && this.b.size() == 0;
    }

    public final boolean isEnabled(int i) {
        int size = this.b.size() * this.e;
        if (i < size) {
            return i % this.e == 0 && ((p) this.b.get(i / this.e)).d;
        } else {
            size = i - size;
            if (this.d != null && size < this.d.getCount()) {
                return this.d.isEnabled(size);
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
        if (this.d != null) {
            this.d.registerDataSetObserver(dataSetObserver);
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
        if (this.d != null) {
            this.d.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
