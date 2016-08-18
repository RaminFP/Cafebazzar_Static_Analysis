package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListAdapter;

final class ay implements OnClickListener, bd {
    final /* synthetic */ SpinnerCompat a;
    private AlertDialog b;
    private ListAdapter c;
    private CharSequence d;

    private ay(SpinnerCompat spinnerCompat) {
        this.a = spinnerCompat;
    }

    public final void a(CharSequence charSequence) {
        this.d = charSequence;
    }

    public final void dismiss() {
        if (this.b != null) {
            this.b.dismiss();
            this.b = null;
        }
    }

    public final boolean isShowing() {
        return this.b != null ? this.b.isShowing() : false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.setSelection(i);
        if (this.a.t != null) {
            this.a.a(null, i, this.c.getItemId(i));
        }
        dismiss();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        this.c = listAdapter;
    }

    public final void show() {
        if (this.c != null) {
            Builder builder = new Builder(this.a.getContext());
            if (this.d != null) {
                builder.setTitle(this.d);
            }
            this.b = builder.setSingleChoiceItems(this.c, this.a.getSelectedItemPosition(), this).create();
            this.b.show();
        }
    }
}
