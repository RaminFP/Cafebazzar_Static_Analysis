package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONException;
import org.json.JSONObject;

final class af extends v {
    final /* synthetic */ PaymentActivity a;

    private af(PaymentActivity paymentActivity) {
        this.a = paymentActivity;
    }

    public final void a(c cVar) {
        this.a.q.dismiss();
        if (cVar.b == 10000) {
            cVar.c.put("general", this.a.getString(2131165700));
        }
        this.a.a((String) cVar.c.get("general"), false);
    }

    public final /* synthetic */ void a(Object obj) {
        boolean z = false;
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.has("error_code") && jSONObject.getInt("error_code") < 0) {
                String string;
                int i = jSONObject.getInt("error_code");
                if (jSONObject.has("error_message")) {
                    string = jSONObject.getString("error_message");
                } else {
                    string = this.a.getString(2131165706, new Object[]{Integer.valueOf(i)});
                }
                PaymentActivity paymentActivity = this.a;
                if (i == -6 || i == -3) {
                    z = true;
                }
                paymentActivity.a(string, z);
                this.a.q.dismiss();
            } else if (jSONObject.has("json") && jSONObject.has("sign")) {
                try {
                    this.a.a(-1, PaymentActivity.a(this.a, jSONObject));
                } catch (JSONException e) {
                    PaymentActivity.b(this.a, jSONObject);
                }
                this.a.q.dismiss();
            } else {
                PaymentActivity.b(this.a, jSONObject);
                this.a.q.dismiss();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.a.a(this.a.getString(2131165430), false);
        }
    }
}
