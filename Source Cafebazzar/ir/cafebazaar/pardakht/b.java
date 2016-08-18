package ir.cafebazaar.pardakht;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class b implements OnEditorActionListener {
    final /* synthetic */ AuthenticateActivity a;

    b(AuthenticateActivity authenticateActivity) {
        this.a = authenticateActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        if (this.a.g) {
            ab.a(this.a.f.isChecked());
        }
        this.a.c();
        return true;
    }
}
