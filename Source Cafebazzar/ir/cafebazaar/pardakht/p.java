package ir.cafebazaar.pardakht;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

final class p implements OnClickListener {
    final /* synthetic */ InputMethodManager a;
    final /* synthetic */ PardakhtActivity b;

    p(PardakhtActivity pardakhtActivity, InputMethodManager inputMethodManager) {
        this.b = pardakhtActivity;
        this.a = inputMethodManager;
    }

    public final void onClick(View view) {
        this.a.showSoftInput(this.b.j, 1);
    }
}
