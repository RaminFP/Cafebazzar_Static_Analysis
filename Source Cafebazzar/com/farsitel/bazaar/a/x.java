package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

public final class x extends BaseAdapter {
    private final String[] a;
    private final LayoutInflater b;
    private final Activity c;
    private final int d;

    public x(Activity activity, String[] strArr, int i) {
        this.c = activity;
        this.b = LayoutInflater.from(activity);
        this.a = strArr;
        this.d = i;
    }

    public final int getCount() {
        return this.a.length;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        y yVar;
        if (view == null) {
            view = this.b.inflate(2130903125, null);
            y yVar2 = new y();
            yVar2.a = (CheckedTextView) view.findViewById(2131624244);
            view.setTag(yVar2);
            yVar = yVar2;
        } else {
            yVar = (y) view.getTag();
        }
        yVar.a.setText(this.a[i]);
        yVar.a.setChecked(i == this.d);
        return view;
    }
}
