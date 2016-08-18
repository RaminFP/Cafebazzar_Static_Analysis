package android.support.v7.internal.widget;

import android.support.v7.app.c;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

final class at extends BaseAdapter {
    final /* synthetic */ ar a;

    private at(ar arVar) {
        this.a = arVar;
    }

    public final int getCount() {
        return this.a.e.getChildCount();
    }

    public final Object getItem(int i) {
        return ((av) this.a.e.getChildAt(i)).a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return ar.a(this.a, (c) getItem(i), true);
        }
        av avVar = (av) view;
        avVar.a = (c) getItem(i);
        avVar.a();
        return view;
    }
}
