package com.farsitel.bazaar.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.a.a.a.ar;
import com.a.a.a.y;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.o;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.util.ax;
import java.util.Map;

final class bk implements b {
    final /* synthetic */ JoinActivity a;

    bk(JoinActivity joinActivity) {
        this.a = joinActivity;
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        if (this.a.l != null) {
            this.a.l.dismiss();
            a a = a.a();
            c cVar = new c();
            cVar.f = "user";
            cVar.c = "join_dialog";
            cVar = cVar.a("source_pn", this.a.m);
            cVar.e = "join_request";
            a.a(cVar.b("state", "failed").b("error_code", Integer.valueOf(i)).b("type", "email_or_phone").b("email_or_phone", this.a.h.getText().toString()));
            switch (i) {
                case -1:
                    this.a.a((String) map.get("general"));
                    com.a.a.a.a.c().a((ar) new ar().a(false).a("reason", "invalid_email"));
                    return;
                case 10000:
                    this.a.a(this.a.getApplicationContext().getString(2131165452));
                    com.a.a.a.a.c().a((ar) new ar().a(false).a("reason", "network"));
                    return;
                default:
                    this.a.a(this.a.getApplicationContext().getString(2131165374));
                    com.a.a.a.a.c().a(new ar().a(false));
                    return;
            }
        }
    }

    public final void b() {
        int i = 0;
        if (!this.a.isFinishing()) {
            a a = a.a();
            c cVar = new c();
            cVar.f = "user";
            cVar.c = "join_dialog";
            cVar = cVar.a("source_pn", this.a.m);
            cVar.e = "join_request";
            a.a(cVar.b("state", "success").b("type", "email_or_phone").b("email_or_phone", this.a.h.getText().toString()));
            this.a.l.dismiss();
            String replaceAll = this.a.h.getText().toString().toLowerCase().trim().replaceAll("\\s", "");
            if (ax.b(replaceAll)) {
                SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
                String string = sharedPreferences.getString("phone_numbers", "");
                String[] split = string.split("\n");
                while (i < split.length) {
                    if (replaceAll.equals(split[i])) {
                        break;
                    }
                    i++;
                }
                String str = (string.length() != 0 ? string + "\n" : string) + replaceAll;
                Editor edit = sharedPreferences.edit();
                edit.putString("phone_numbers", str);
                edit.commit();
                com.farsitel.bazaar.util.c.a(this.a, SmsAuthenticationActivity.a(this.a, replaceAll, this.a.e, this.a.d, true), 218, this.a.findViewById(2131624120));
                if (this.a.d) {
                    com.a.a.a.a.c().a((ar) new ar().a("phone").a("state", "not_act"));
                } else {
                    com.a.a.a.a.c().a((y) new y().a("phone").a("state", "not_act"));
                }
            } else if (ax.a(replaceAll)) {
                o.a(replaceAll);
                EmailAuthenticationActivity.a(this.a, this.a.findViewById(2131624120), 219, replaceAll, this.a.e, this.a.d, true);
                if (this.a.d) {
                    com.a.a.a.a.c().a((ar) new ar().a("email").a("state", "not_act"));
                } else {
                    com.a.a.a.a.c().a((y) new y().a("email").a("state", "not_act"));
                }
            }
        }
    }
}
