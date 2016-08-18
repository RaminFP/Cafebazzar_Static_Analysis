package com.farsitel.bazaar.activity;

import android.view.LayoutInflater;
import android.widget.Toast;
import com.a.a.a.a;
import com.a.a.a.ar;
import com.farsitel.bazaar.a.o;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.c;
import ir.cafebazaar.pardakht.aa;
import java.util.Map;

final class bl implements b {
    final /* synthetic */ JoinActivity a;

    bl(JoinActivity joinActivity) {
        this.a = joinActivity;
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        a.c().a((ar) new ar().a("google").a(false).a("reason", "errorrCode_" + Integer.toString(i)));
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "join_dialog";
        cVar = cVar.a("source_pn", this.a.m);
        cVar.e = "join_request";
        a.a(cVar.b("state", "failed").b("error_code", Integer.valueOf(i)).b("type", "google").b("email", this.a.h.getText().toString()));
        this.a.l.dismiss();
        this.a.a(this.a.getString(2131165374));
    }

    public final void b() {
        a.c().a(new ar().a("google").a(true));
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "join_dialog";
        cVar = cVar.a("source_pn", this.a.m);
        cVar.e = "join_request";
        a.a(cVar.b("state", "success").b("type", "google").b("email", this.a.h.getText().toString()));
        this.a.l.dismiss();
        Toast makeText = Toast.makeText(this.a, "", 1);
        makeText.setView(LayoutInflater.from(this.a).inflate(2130903137, null));
        makeText.show();
        o.a(this.a.h.getText().toString());
        aa.INSTANCE.a();
        this.a.setResult(-1);
        this.a.finish();
    }
}
