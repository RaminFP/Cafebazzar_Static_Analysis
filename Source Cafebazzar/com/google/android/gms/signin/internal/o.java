package com.google.android.gms.signin.internal;

import com.google.android.gms.a.da;
import java.util.List;
import java.util.concurrent.ExecutorService;

final class o extends e {
    private final da a;
    private final ExecutorService b;

    public o(da daVar, ExecutorService executorService) {
        this.a = daVar;
        this.b = executorService;
    }

    public final void a(String str, String str2, i iVar) {
        this.b.submit(new q(this, str, str2, iVar));
    }

    public final void a(String str, List list, i iVar) {
        this.b.submit(new p(this, list, str, iVar));
    }
}
