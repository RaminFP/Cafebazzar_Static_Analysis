package ir.cafebazaar.pardakht;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.AnimationUtils;

final class n implements TextWatcher {
    final /* synthetic */ NativePaymentActivity a;

    n(NativePaymentActivity nativePaymentActivity) {
        this.a = nativePaymentActivity;
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().length() > 0) {
            if (this.a.h.getVisibility() == 8) {
                this.a.h.setAnimation(AnimationUtils.loadAnimation(this.a.getApplicationContext(), 17432576));
            }
            this.a.h.setVisibility(0);
            return;
        }
        if (this.a.h.getVisibility() == 0) {
            this.a.h.setAnimation(AnimationUtils.loadAnimation(this.a.getApplicationContext(), 17432577));
        }
        this.a.h.setVisibility(8);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
