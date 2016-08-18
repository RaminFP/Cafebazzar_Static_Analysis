package ir.cafebazaar.pardakht;

import android.app.Activity;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.util.aj;

final class ak extends o {
    public ak(Activity activity, char c, long j) {
        String str = "";
        switch (c) {
            case 'A':
                str = PaymentActivity.a.getString(2131165669);
                break;
            case 'M':
                str = PaymentActivity.a.getString(2131165676);
                break;
        }
        super(activity, e.b(String.format(PaymentActivity.a.getString(2131165667), new Object[]{str, aj.a(j)})), 2131165674, 0, 2131165323, false);
        a(true, null);
    }

    public final void a() {
        d();
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
        e();
        this.e.dismiss();
    }
}
