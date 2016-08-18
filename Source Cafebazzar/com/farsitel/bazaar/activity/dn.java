package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class dn implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ SubsRenewActivity b;

    dn(SubsRenewActivity subsRenewActivity, String str) {
        this.b = subsRenewActivity;
        this.a = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("ir.cafebazaar.intent.action.PAY", Uri.parse("bazaar://pardakht/v1/pay/"));
        intent.setPackage(this.b.getPackageName());
        intent.putExtra("PARDAKHT_PACKAGE_NAME", this.b.a);
        intent.putExtra("PARDAKHT_SKU", this.a);
        this.b.startActivityForResult(intent, 16);
    }
}
