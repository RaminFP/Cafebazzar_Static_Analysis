package com.google.android.gms.a;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.t;
import java.lang.ref.WeakReference;

final class av implements DeathRecipient, ax {
    private final WeakReference a;
    private final WeakReference b;
    private final WeakReference c;

    private av(ay ayVar, t tVar, IBinder iBinder) {
        this.b = new WeakReference(tVar);
        this.a = new WeakReference(ayVar);
        this.c = new WeakReference(iBinder);
    }

    private void a() {
        ay ayVar = (ay) this.a.get();
        t tVar = (t) this.b.get();
        if (!(tVar == null || ayVar == null)) {
            ayVar.e().intValue();
            tVar.a();
        }
        IBinder iBinder = (IBinder) this.c.get();
        if (this.c != null) {
            iBinder.unlinkToDeath(this, 0);
        }
    }

    public final void binderDied() {
        a();
    }
}
