package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class bb implements OnItemClickListener {
    final /* synthetic */ SpinnerCompat a;
    final /* synthetic */ ba b;

    bb(ba baVar, SpinnerCompat spinnerCompat) {
        this.b = baVar;
        this.a = spinnerCompat;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.b.a.setSelection(i);
        if (this.b.a.t != null) {
            this.b.a.a(view, i, this.b.c.getItemId(i));
        }
        this.b.dismiss();
    }
}
