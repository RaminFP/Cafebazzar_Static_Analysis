package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.b.n;

final class ai implements n {
    final /* synthetic */ PaymentActivity a;

    private ai(PaymentActivity paymentActivity) {
        this.a = paymentActivity;
    }

    public final void a() {
        this.a.a("buy_with_credit");
    }

    public final void b() {
        this.a.finish();
    }
}
