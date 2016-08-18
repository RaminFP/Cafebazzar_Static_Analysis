package com.farsitel.bazaar.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.g.g;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.al;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.c;

final class ap implements OnClickListener {
    final /* synthetic */ g a;
    final /* synthetic */ au b;
    final /* synthetic */ ao c;

    ap(ao aoVar, g gVar, au auVar) {
        this.c = aoVar;
        this.a = gVar;
        this.b = auVar;
    }

    public final void onClick(View view) {
        if (j.a().n()) {
            af afVar = af.INSTANCE;
            if (af.c(this.c.n)) {
                if (d.INSTANCE.b(new al(), j.a().b, Integer.valueOf(this.a.a), "L")) {
                    this.b.f.setAnimation(AnimationUtils.loadAnimation(this.c.i, 2130968624));
                    g gVar = this.a;
                    if (gVar.i == null || !gVar.i.booleanValue()) {
                        gVar.i = Boolean.valueOf(true);
                    } else {
                        gVar.i = null;
                    }
                    this.c.a(this.b, this.a);
                    BazaarApplication.c().d();
                    i.a("/VoteUpComment/" + this.c.n);
                    return;
                }
                Toast.makeText(this.c.i, 2131165701, 0).show();
                return;
            }
            Toast.makeText(this.c.i, 2131165420, 0).show();
            return;
        }
        Intent intent = new Intent(this.c.i, JoinActivity.class);
        intent.putExtra("extra_referer", "review-rate-voteup");
        intent.putExtra("android.intent.extra.TITLE", this.c.i.getString(2131165442));
        c.a(this.c.i, intent, 40002, view);
    }
}
