package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.b;
import java.util.HashSet;
import java.util.Set;

final class aa {
    final ab a = new ab(this);
    final Set b = new HashSet();
    int c = 2;
    boolean d;
    IBinder e;
    final z f;
    ComponentName g;
    final /* synthetic */ y h;

    public aa(y yVar, z zVar) {
        this.h = yVar;
        this.f = zVar;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        this.h.d.a(this.h.b, b.a(serviceConnection), str, this.f.a(), 3);
        this.b.add(serviceConnection);
    }

    public final void a(String str) {
        this.c = 3;
        this.d = this.h.d.a(this.h.b, str, this.f.a(), this.a, 129);
        if (!this.d) {
            this.c = 2;
            try {
                this.h.d.a(this.h.b, this.a);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public final boolean a() {
        return this.b.isEmpty();
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.b.contains(serviceConnection);
    }
}
