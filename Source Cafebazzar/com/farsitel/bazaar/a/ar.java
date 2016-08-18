package com.farsitel.bazaar.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.g.g;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.c;

final class ar implements OnClickListener {
    final /* synthetic */ g a;
    final /* synthetic */ ao b;

    ar(ao aoVar, g gVar) {
        this.b = aoVar;
        this.a = gVar;
    }

    public final void onClick(View view) {
        if (j.a().n()) {
            af afVar = af.INSTANCE;
            if (af.c(this.b.n)) {
                new as(this.b, this.b.i, this.a.a).e.show();
                return;
            } else {
                Toast.makeText(this.b.i, 2131165420, 0).show();
                return;
            }
        }
        Intent intent = new Intent(this.b.i, JoinActivity.class);
        intent.putExtra("extra_referer", "review-rate-flag");
        intent.putExtra("android.intent.extra.TITLE", this.b.i.getString(2131165442));
        c.a(this.b.i, intent, 40002, view);
    }
}
