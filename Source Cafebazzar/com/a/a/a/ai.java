package com.a.a.a;

import android.app.Activity;
import b.a.a.a.a;
import b.a.a.a.f;
import java.util.Collections;
import java.util.Map;

public final class ai implements r {
    final long a;
    public final e b;
    final a c;
    final p d;
    final n e;

    ai(e eVar, a aVar, p pVar, n nVar, long j) {
        this.b = eVar;
        this.c = aVar;
        this.d = pVar;
        this.e = nVar;
        this.a = j;
    }

    public final void a() {
        f.a().a("Answers", "Flush events when app is backgrounded");
        e eVar = this.b;
        eVar.a(new j(eVar));
    }

    public final void a(Activity activity, am amVar) {
        f.a().a("Answers", "Logged lifecycle event: " + amVar.name());
        e eVar = this.b;
        Map singletonMap = Collections.singletonMap("activity", activity.getClass().getName());
        al alVar = new al(amVar);
        alVar.c = singletonMap;
        eVar.a(alVar, false, false);
    }

    public final void a(z zVar) {
        f.a().a("Answers", "Logged predefined event: " + zVar);
        e eVar = this.b;
        al alVar = new al(am.PREDEFINED);
        alVar.f = zVar.a();
        alVar.g = zVar.c.b;
        alVar.e = zVar.b.b;
        eVar.a(alVar, false, false);
    }
}
