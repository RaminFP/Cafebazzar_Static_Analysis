package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.receiver.g;

final class dl extends g {
    final /* synthetic */ SplashActivity a;

    dl(SplashActivity splashActivity) {
        this.a = splashActivity;
    }

    public final void a() {
        long currentTimeMillis = System.currentTimeMillis() - this.a.b;
        if (currentTimeMillis > 0) {
            this.a.a.postDelayed(new dm(this), currentTimeMillis);
        } else {
            this.a.b();
        }
    }

    public final void b() {
        this.a.d.setVisibility(0);
        this.a.c.setVisibility(8);
    }
}
