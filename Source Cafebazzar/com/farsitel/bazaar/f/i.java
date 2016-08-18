package com.farsitel.bazaar.f;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.net.Uri;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;

final class i extends v {
    final /* synthetic */ f a;

    private i(f fVar) {
        this.a = fVar;
    }

    public final void a(c cVar) {
        this.a.j.dismiss();
        if (cVar.b == 10000) {
            cVar.c.put("general", this.a.e.getString(2131165700));
        }
        Toast.makeText(this.a.e, (CharSequence) cVar.c.get("general"), 1).show();
    }

    public final /* synthetic */ void a(Object obj) {
        this.a.j.dismiss();
        f fVar = this.a;
        Intent intent = new Intent("ir.cafebazaar.intent.action.PAY", Uri.parse("bazaar://pardakht/v1/pay/"));
        intent.setPackage(BazaarApplication.c().getPackageName());
        intent.putExtra("PARDAKHT_PACKAGE_NAME", f.a.getPackageName());
        intent.putExtra("PARDAKHT_SKU", fVar.b);
        intent.putExtra("PACKAGE_ID", 0);
        intent.putExtra("PARDAKHT_NAME", fVar.c);
        intent.putExtra("PARDAKHT_PRICE", fVar.d);
        intent.putExtra("PARDAKHT_DEV_PAYLOAD", "");
        try {
            fVar.e.startIntentSenderForResult(PendingIntent.getActivity(fVar.e, 1, intent, 268435456).getIntentSender(), 40001, new Intent(), 0, 0, 0);
        } catch (SendIntentException e) {
            e.printStackTrace();
        }
    }
}
