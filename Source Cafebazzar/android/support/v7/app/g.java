package android.support.v7.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public final class g extends ArrayAdapter {
    final /* synthetic */ ListView a;
    final /* synthetic */ f b;

    public g(f fVar, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        this.b = fVar;
        this.a = listView;
        super(context, i, 16908308, charSequenceArr);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.b.C != null && this.b.C[i]) {
            this.a.setItemChecked(i, true);
        }
        return view2;
    }
}
