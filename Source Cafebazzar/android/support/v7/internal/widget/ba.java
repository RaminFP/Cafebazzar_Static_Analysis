package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.widget.ListAdapter;

final class ba extends ListPopupWindow implements bd {
    final /* synthetic */ SpinnerCompat a;
    private CharSequence b;
    private ListAdapter c;

    public ba(SpinnerCompat spinnerCompat, Context context, AttributeSet attributeSet, int i) {
        this.a = spinnerCompat;
        super(context, attributeSet, i);
        setAnchorView(spinnerCompat);
        setModal(true);
        setPromptPosition(0);
        setOnItemClickListener(new bb(this, spinnerCompat));
    }

    public final void a(CharSequence charSequence) {
        this.b = charSequence;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.c = listAdapter;
    }
}
