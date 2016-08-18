package ir.cafebazaar.pardakht;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.AnimationUtils;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.at;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.ag;

final class l implements TextWatcher {
    final /* synthetic */ NativePaymentActivity a;

    l(NativePaymentActivity nativePaymentActivity) {
        this.a = nativePaymentActivity;
    }

    public final void afterTextChanged(Editable editable) {
        if (editable != null) {
            String replaceAll = editable.toString().replaceAll(" ", "");
            if (replaceAll.length() == 16) {
                int parseInt;
                String str = replaceAll.toString();
                int i = 0;
                boolean z = false;
                int length = str.length() - 1;
                while (length >= 0) {
                    parseInt = Integer.parseInt(str.substring(length, length + 1));
                    if (z) {
                        parseInt <<= 1;
                        if (parseInt > 9) {
                            parseInt = (parseInt % 10) + 1;
                        }
                    }
                    i += parseInt;
                    length--;
                    z = !z;
                }
                if (i % 10 == 0) {
                    parseInt = 1;
                } else {
                    boolean z2 = false;
                }
                if (parseInt != 0) {
                    this.a.l.setEnabled(false);
                    this.a.p.setVisibility(0);
                    this.a.q.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.d.startAnimation(AnimationUtils.loadAnimation(this.a, 2130968614));
                    d.INSTANCE.a(new o(this.a, (byte) 0), new at(), BazaarApplication.c().a.getLanguage(), j.a().d(), this.a.y, replaceAll);
                    ag.a(this.a, this.a.l.getWindowToken());
                    return;
                }
                this.a.l.startAnimation(AnimationUtils.loadAnimation(this.a, 2130968637));
                this.a.m.setText(2131165800);
                this.a.m.setTextColor(this.a.getResources().getColor(2131558529));
                this.a.m.setAnimation(AnimationUtils.loadAnimation(this.a, 17432576));
                this.a.m.setVisibility(0);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        if (charSequence != null) {
            int i5;
            for (i5 = 0; i5 < charSequence.length() / 5; i5++) {
                if (charSequence.charAt((i5 * 5) + 4) != ' ') {
                    i5 = 0;
                    break;
                }
            }
            i5 = 1;
            if (i5 == 0 && i2 <= i3) {
                String replaceAll = charSequence.toString().replaceAll(" ", "");
                String str = "";
                while (i4 < replaceAll.length() / 4) {
                    str = str + replaceAll.substring(i4 << 2, (i4 + 1) << 2) + " ";
                    i4++;
                }
                if ((i4 << 2) < replaceAll.length()) {
                    str = str + replaceAll.substring(i4 << 2) + " ";
                }
                Object trim = str.trim();
                this.a.l.setText(trim);
                this.a.l.setSelection(trim.length());
            }
        }
    }
}
