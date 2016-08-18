package com.farsitel.bazaar.b;

import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;

final class bi implements Runnable {
    final /* synthetic */ bh a;

    bi(bh bhVar) {
        this.a = bhVar;
    }

    public final void run() {
        Toast.makeText(BazaarApplication.c(), BazaarApplication.c().getText(2131165475), 1).show();
    }
}
