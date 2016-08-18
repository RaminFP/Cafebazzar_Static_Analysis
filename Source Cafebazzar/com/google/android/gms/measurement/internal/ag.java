package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.av;

class ag extends BroadcastReceiver {
    static final String a = ag.class.getName();
    final ap b;
    boolean c;
    boolean d;

    ag(ap apVar) {
        av.a((Object) apVar);
        this.b = apVar;
    }

    public final void a() {
        this.b.a();
        this.b.f().e();
        this.b.f().e();
        if (this.c) {
            this.b.e().g.a("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                this.b.a.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.b.e().a.a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    Context b() {
        return this.b.a;
    }

    public void onReceive(Context context, Intent intent) {
        this.b.a();
        String action = intent.getAction();
        this.b.e().g.a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean b = this.b.i().b();
            if (this.d != b) {
                this.d = b;
                this.b.f().a(new ah(this, b));
                return;
            }
            return;
        }
        this.b.e().b.a("NetworkBroadcastReceiver received unknown action", action);
    }
}
