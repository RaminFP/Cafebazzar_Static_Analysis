package ir.cafebazaar.pardakht;

import android.view.animation.Animation;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.widget.o;
import org.json.JSONException;
import org.json.JSONObject;

final class m extends v {
    final /* synthetic */ NativePaymentActivity a;

    private m(NativePaymentActivity nativePaymentActivity) {
        this.a = nativePaymentActivity;
    }

    public final void a(c cVar) {
        this.a.u.dismiss();
        this.a.x = 3;
        this.a.m.setText((CharSequence) cVar.c.get("general"));
        this.a.a();
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        this.a.u.dismiss();
        try {
            if (jSONObject.has("token")) {
                this.a.b = jSONObject.getString("token");
            }
            if (jSONObject.has("error")) {
                if (jSONObject.getInt("error") == 506) {
                    this.a.c.a(this.a.s.a);
                    Animation oVar = new o(this.a.f, this.a.d);
                    oVar.a = false;
                    this.a.e.startAnimation(oVar);
                    this.a.m.setVisibility(8);
                    this.a.x = 1;
                } else {
                    this.a.x = 3;
                }
                this.a.m.setText(jSONObject.getString("error_message"));
            } else if (jSONObject.has("sign") && jSONObject.has("json")) {
                this.a.v.setResult(-1, NativePaymentActivity.a(this.a, jSONObject));
                this.a.B = true;
                this.a.v.finish();
            }
            if (jSONObject.has("nonce")) {
                this.a.A = jSONObject.getString("nonce");
            }
        } catch (JSONException e) {
            this.a.x = 3;
            this.a.m.setText(2131165289);
        }
        this.a.a();
    }
}
