package com.farsitel.bazaar.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public final class an extends BaseAdapter {
    private final String[] a;
    private final LayoutInflater b;

    public an(Context context) {
        this.b = LayoutInflater.from(context);
        this.a = context.getResources().getStringArray(2131230720);
    }

    public final int getCount() {
        return this.a.length;
    }

    public final Object getItem(int i) {
        return this.a[i];
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) this.b.inflate(2130903125, null);
        textView.setText(this.a[i]);
        return textView;
    }
}
