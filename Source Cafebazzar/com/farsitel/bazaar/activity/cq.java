package com.farsitel.bazaar.activity;

import android.content.SharedPreferences.Editor;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.ak;

final class cq implements Runnable {
    final /* synthetic */ cp a;

    cq(cp cpVar) {
        this.a = cpVar;
    }

    public final void run() {
        if (ak.b()) {
            if (!this.a.a.I.getBoolean("asroot", false)) {
                Editor edit = this.a.a.I.edit();
                edit.putBoolean("asroot", true);
                edit.commit();
                co.a.d();
                i.b("enable_root_install");
            }
        } else if (this.a.a.getActivity() != null) {
            this.a.a.getActivity().runOnUiThread(new cr(this));
        }
    }
}
