package com.farsitel.bazaar.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.b.an;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.i;
import ir.cafebazaar.pardakht.NativePaymentActivity;
import ir.cafebazaar.pardakht.PaymentActivity;
import ir.cafebazaar.pardakht.aj;

final class ah implements OnItemClickListener {
    final /* synthetic */ ag a;

    ah(ag agVar) {
        this.a = agVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ai aiVar = (ai) this.a.a.get(i);
        String str = aiVar.f;
        Object obj = "";
        switch (this.a.b) {
            case -1:
                obj = "unknown";
                break;
            case 0:
                obj = "not_enough_credit";
                break;
            case 1:
                obj = "has_enough_credit";
                break;
            case 2:
                obj = "buy_credit";
                break;
        }
        a a = a.a();
        c cVar = new c();
        cVar.c = "payment_options";
        cVar.e = "payment_option_click";
        a.a(cVar.b("current_mode", obj).b("type", str).b("kind", Character.valueOf(this.a.d.d.g)).b("price", Long.valueOf(this.a.d.d.f)));
        byte b = (byte) -1;
        switch (str.hashCode()) {
            case -1352291591:
                if (str.equals("credit")) {
                    b = (byte) 0;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    b = (byte) 4;
                    break;
                }
                break;
            case -903445275:
                if (str.equals("shetab")) {
                    b = (byte) 1;
                    break;
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    b = (byte) 2;
                    break;
                }
                break;
            case 849792064:
                if (str.equals("giftcard")) {
                    b = (byte) 3;
                    break;
                }
                break;
        }
        Intent intent;
        switch (b) {
            case (byte) 0:
                intent = new Intent("ir.cafebazaar.intent.action.PAY");
                intent.putExtra("PARDAKHT_TYPE", str);
                intent.setPackage(BazaarApplication.c().getPackageName());
                intent.setData(Uri.parse("bazaar://pardakht/v1/buy_credit/"));
                intent.putExtra("PARDAKHT_PACKAGE_NAME", BazaarApplication.c().getPackageName());
                intent.putExtra("PARDAKHT_PRICE", this.a.d.d.f);
                this.a.d.startActivityForResult(intent, 40006);
                break;
            case (byte) 1:
            case (byte) 2:
                intent = new Intent(this.a.c);
                intent.setAction("ir.cafebazaar.intent.action.PAY_WEB");
                intent.setData(Uri.parse("bazaar://pardakht/v1/pay/"));
                intent.putExtra("PARDAKHT_TYPE", str);
                intent.putExtra("PARDAKHT_METHOD", aiVar.e);
                intent.putExtra("USER_AGREED", this.a.d.e);
                intent.putExtra("SHOULD_AGREE", this.a.d.a());
                this.a.d.startActivityForResult(intent, 40001);
                break;
            case (byte) 3:
                Activity c = this.a.d;
                c.c = new an(c);
                c.c.g = new aj(c, (byte) 0);
                c.c.e.show();
                PaymentActivity.a.d();
                i.a("/Pay/Redeem/EnterCode");
                break;
            case (byte) 4:
                intent = new Intent(this.a.d, NativePaymentActivity.class);
                intent.putExtras(this.a.d.b.getExtras());
                intent.putExtra("PARDAKHT_NONCE", this.a.f);
                this.a.d.startActivityForResult(intent, 40001);
                break;
        }
        BazaarApplication.c().d();
        i.a("/Pay/Buy/Checkout/Option/" + str + "/" + aiVar.e);
    }
}
