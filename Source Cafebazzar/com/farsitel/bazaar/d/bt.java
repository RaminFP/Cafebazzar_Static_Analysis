package com.farsitel.bazaar.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

final class bt extends ArrayAdapter {
    final /* synthetic */ bs a;

    bt(bs bsVar, Context context, int i, int i2) {
        this.a = bsVar;
        super(context, 2130903180, 16908308);
    }

    public final int getCount() {
        return super.getCount() - 1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (i == getCount()) {
            ((TextView) view2.findViewById(16908308)).setText("");
            ((TextView) view2.findViewById(16908308)).setHint((CharSequence) getItem(getCount()));
        }
        return view2;
    }
}
