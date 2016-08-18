package ir.cafebazaar.pardakht;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class i implements OnEditorActionListener {
    final /* synthetic */ NativePaymentActivity a;

    i(NativePaymentActivity nativePaymentActivity) {
        this.a = nativePaymentActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        this.a.b();
        return true;
    }
}
