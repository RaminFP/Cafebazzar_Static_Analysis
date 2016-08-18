package com.farsitel.bazaar.activity;

import android.os.CountDownTimer;

final class dh extends CountDownTimer {
    final /* synthetic */ SmsAuthenticationActivity a;

    dh(SmsAuthenticationActivity smsAuthenticationActivity, long j, long j2) {
        this.a = smsAuthenticationActivity;
        super(j, j2);
    }

    public final void onFinish() {
        this.a.j.setText(2131165590);
        this.a.j.setEnabled(true);
    }

    public final void onTick(long j) {
        long j2 = j / 1000;
        int i = (int) (j2 - ((long) (((int) (j2 / 60)) * 60)));
        this.a.j.setText(this.a.getString(2131165589, new Object[]{Integer.valueOf(r2), Integer.valueOf(i)}));
    }
}
