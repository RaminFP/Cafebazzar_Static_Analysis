package com.b.b;

import android.widget.Toast;

final class j implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ i b;

    j(i iVar, int i) {
        this.b = iVar;
        this.a = i;
    }

    public final void run() {
        Toast.makeText(ah.a.b, "SD HTTP Response Code: " + this.a, 0).show();
    }
}
