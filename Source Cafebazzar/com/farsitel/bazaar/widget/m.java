package com.farsitel.bazaar.widget;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

public final class m implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ BazaarTitleBar b;

    public m(BazaarTitleBar bazaarTitleBar, Dialog dialog) {
        this.b = bazaarTitleBar;
        this.a = dialog;
    }

    public final void onClick(View view) {
        this.a.dismiss();
    }
}
