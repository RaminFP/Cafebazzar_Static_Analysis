package com.farsitel.bazaar.b;

import android.app.Activity;

public final class bg extends o {
    public bg(Activity activity) {
        super(activity, 2131165606, 2131165801, 0, 2131165463);
    }

    public final void a() {
        new Thread(new bh(this)).start();
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
