package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import org.json.JSONException;
import org.json.JSONObject;

final class o extends v {
    final /* synthetic */ NativePaymentActivity a;

    private o(NativePaymentActivity nativePaymentActivity) {
        this.a = nativePaymentActivity;
    }

    public final void a(c cVar) {
        this.a.d.clearAnimation();
        this.a.p.setVisibility(8);
        this.a.x = 1;
        this.a.a();
        this.a.m.setText((CharSequence) cVar.c.get("general"));
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        this.a.d.clearAnimation();
        try {
            if (jSONObject.getInt("error") != 0) {
                this.a.x = 1;
                this.a.m.setText(jSONObject.getString("error_message"));
            } else {
                this.a.s = this.a.c.a(jSONObject.getString("card"), jSONObject.getString("card_id"), jSONObject.getString("code"), jSONObject.getString("bank"));
                this.a.t.add(this.a.s);
                this.a.x = 2;
            }
        } catch (JSONException e) {
            this.a.x = 1;
            this.a.m.setText(2131165289);
        }
        this.a.p.setVisibility(8);
        this.a.a();
    }
}
