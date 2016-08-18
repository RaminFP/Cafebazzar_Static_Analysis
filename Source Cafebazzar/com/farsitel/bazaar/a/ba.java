package com.farsitel.bazaar.a;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.g.h;

final class ba implements OnMenuItemClickListener {
    final /* synthetic */ h a;
    final /* synthetic */ int b;
    final /* synthetic */ az c;

    ba(az azVar, h hVar, int i) {
        this.c = azVar;
        this.a = hVar;
        this.b = i;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624436:
                m beVar = new be(this.c.c.getActivity(), this.a);
                beVar.g = new bb(this);
                beVar.e.show();
                break;
            case 2131624437:
                Intent intent = new Intent("ir.cafebazaar.intent.action.PAY", Uri.parse("bazaar://pardakht/v1/pay/"));
                intent.setPackage(this.c.c.getActivity().getPackageName());
                intent.putExtra("PARDAKHT_PACKAGE_NAME", this.a.a);
                intent.putExtra("PARDAKHT_SKU", this.a.f);
                intent.putExtra("PARDAKHT_DEV_PAYLOAD", "");
                this.c.c.startActivityForResult(intent, 16);
                break;
        }
        return true;
    }
}
