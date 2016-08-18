package ir.cafebazaar.pardakht;

import android.content.Intent;
import com.a.a.a.a;
import com.a.a.a.aa;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

final class ah extends v {
    boolean a;
    final /* synthetic */ PaymentActivity b;
    private String c;

    private ah(PaymentActivity paymentActivity, boolean z, String str) {
        this.b = paymentActivity;
        this.a = z;
        this.c = str;
    }

    public final void a(c cVar) {
        if (cVar.b == 10002) {
            this.b.a((String) cVar.c.get("general"), false);
            return;
        }
        this.b.a(this.b.getString(2131165706, new Object[]{Integer.valueOf(cVar.b)}), false);
    }

    public final /* synthetic */ void a(Object obj) {
        String string;
        JSONObject jSONObject = (JSONObject) obj;
        int i = 0;
        try {
            i = jSONObject.getInt("error");
            string = jSONObject.getString("error_msg");
        } catch (JSONException e) {
            e.printStackTrace();
            string = " ";
        }
        switch (i) {
            case 0:
                try {
                    Intent a = PaymentActivity.a(this.b, jSONObject);
                    if (this.a) {
                        ab.a(this.c);
                    }
                    if (this.b.d.a.equals("com.farsitel.bazaar")) {
                        a.c().a(new aa().a(true).a(this.b.d.b).b("app purchase").a(Currency.getInstance(new Locale("fa", "ir"))).a(new BigDecimal(this.b.d.f)));
                    } else {
                        a.c().a(new aa().a(true).a(this.b.d.a).b("in-app purchase").a(Currency.getInstance(new Locale("fa", "ir"))).a(new BigDecimal(this.b.d.f)));
                    }
                    this.b.a(-1, a);
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.b.a(this.b.getString(2131165430), false);
                    return;
                }
            case 2:
                ab.d();
                PaymentActivity.a(this.b, "wrong_password", string);
                return;
            default:
                this.b.a(string, false);
                return;
        }
    }
}
