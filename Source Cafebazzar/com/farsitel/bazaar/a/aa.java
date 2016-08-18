package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

public final class aa extends BaseAdapter {
    private final String[] a;
    private final LayoutInflater b;
    private final Activity c;
    private final int d;

    public aa(Activity activity, String[] strArr, int i) {
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
        ab abVar;
        if (view == null) {
            view = this.b.inflate(2130903125, null);
            ab abVar2 = new ab();
            abVar2.a = (CheckedTextView) view.findViewById(2131624244);
            view.setTag(abVar2);
            abVar = abVar2;
        } else {
            abVar = (ab) view.getTag();
        }
        abVar.a.setText(this.a[i]);
        abVar.a.setChecked(i == this.d);
        return view;
    }
}
