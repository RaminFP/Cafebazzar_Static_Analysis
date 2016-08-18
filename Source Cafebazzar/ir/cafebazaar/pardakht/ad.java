package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.b.n;
import com.farsitel.bazaar.b.u;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.r;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.p;
import com.farsitel.bazaar.util.q;

final class ad implements n {
    u a;
    final /* synthetic */ PaymentActivity b;

    private ad(PaymentActivity paymentActivity, u uVar) {
        this.b = paymentActivity;
        this.a = uVar;
    }

    public final void a() {
        u uVar = this.a;
        int checkedRadioButtonId = uVar.a.getCheckedRadioButtonId();
        long longValue = checkedRadioButtonId != -1 ? ((Long) uVar.a.findViewById(checkedRadioButtonId).getTag()).longValue() : -1;
        PaymentActivity.a.d();
        i.a("/Pay/Buy/Credit/" + Long.toString(longValue) + "/");
        if (longValue != -1) {
            this.b.d.a(PaymentActivity.a.getString(2131165321), longValue, 'C');
            this.b.b.putExtra("PARDAKHT_CREDIT_AMOUNT", longValue);
            this.b.q.show();
            this.b.k = new af(this.b);
            d.INSTANCE.a(this.b.k, new r(), PaymentActivity.a.a.getLanguage(), this.b.getPackageName(), null, j.a().d(), p.a(), Integer.valueOf(k.b()), Integer.valueOf(q.c()), Integer.valueOf(q.d()), Long.valueOf(longValue));
            return;
        }
        this.b.a(this.b.getString(2131165704, new Object[]{Integer.valueOf(602)}), false);
    }

    public final void b() {
        this.b.finish();
    }
}
