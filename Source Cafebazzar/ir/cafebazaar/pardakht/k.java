package ir.cafebazaar.pardakht;

import android.app.Activity;
import com.farsitel.bazaar.b.o;

final class k extends o {
    final /* synthetic */ NativePaymentActivity a;

    k(NativePaymentActivity nativePaymentActivity, Activity activity, String str, int i, int i2, int i3, boolean z) {
        this.a = nativePaymentActivity;
        super(activity, str, 2131165602, 0, 2131165463, true);
    }

    public final void a() {
        this.e.dismiss();
        if (this.a.s != null) {
            this.a.c.a(this.a.s.a);
            this.a.x = 0;
            this.a.a();
        }
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
