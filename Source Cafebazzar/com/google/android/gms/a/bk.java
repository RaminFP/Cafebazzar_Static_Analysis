package com.google.android.gms.a;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.b;

final class bk implements Runnable {
    final /* synthetic */ bi a;
    private final int b;
    private final ConnectionResult c;

    public bk(bi biVar, int i, ConnectionResult connectionResult) {
        this.a = biVar;
        this.b = i;
        this.c = connectionResult;
    }

    public final void run() {
        if (this.a.a && !this.a.b) {
            this.a.b = true;
            this.a.e = this.b;
            this.a.f = this.c;
            if (this.c.a()) {
                try {
                    this.c.a(this.a.getActivity(), ((this.a.getActivity().getSupportFragmentManager().getFragments().indexOf(this.a) + 1) << 16) + 1);
                    return;
                } catch (SendIntentException e) {
                    this.a.b();
                    return;
                }
            }
            bi.d;
            if (b.a(this.c.c)) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.c.c, this.a.getActivity(), this.a, 2, this.a);
            } else if (this.c.c == 18) {
                bi.d;
                this.a.h = be.a(this.a.getActivity().getApplicationContext(), new bl(this, b.a(this.a.getActivity(), this.a)));
            } else {
                this.a.a(this.b, this.c);
            }
        }
    }
}
