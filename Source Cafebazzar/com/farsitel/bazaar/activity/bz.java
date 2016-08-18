package com.farsitel.bazaar.activity;

import android.app.Activity;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.service.AppDownloadService;

final class bz extends o {
    public bz(Activity activity) {
        super(activity, 2131165513, 2131165801, 0, 2131165463);
    }

    public final void a() {
        AppDownloadService.b();
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
