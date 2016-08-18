package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.b.u;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONArray;
import org.json.JSONException;

final class ae extends v {
    long a;
    final /* synthetic */ PaymentActivity b;

    private ae(PaymentActivity paymentActivity, long j) {
        this.b = paymentActivity;
        this.a = j;
    }

    public final void a(c cVar) {
        this.b.q.dismiss();
        if (cVar.b == 10002) {
            this.b.a((String) cVar.c.get("general"), false);
            return;
        }
        this.b.a(this.b.getString(2131165706, new Object[]{Integer.valueOf(cVar.b)}), false);
    }

    public final void a(Object obj) {
        this.b.q.dismiss();
        try {
            m uVar = new u(this.b.j, (JSONArray) obj, this.a);
            uVar.g = new ad(this.b, uVar);
            uVar.e.show();
        } catch (JSONException e) {
            e.printStackTrace();
            this.b.a(this.b.getString(2131165430), false);
        }
    }
}
