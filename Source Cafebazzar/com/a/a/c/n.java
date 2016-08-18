package com.a.a.c;

import android.app.Activity;
import b.a.a.a.a.g.s;
import b.a.a.a.a.g.v;
import b.a.a.a.f;

final class n implements s {
    final /* synthetic */ h a;

    n(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ Object a(v vVar) {
        f fVar = this.a.n;
        Activity activity = fVar.e != null ? (Activity) fVar.e.get() : null;
        boolean a = (activity == null || activity.isFinishing() || !this.a.k()) ? true : this.a.a(activity, vVar.c);
        return Boolean.valueOf(a);
    }
}
