package com.farsitel.bazaar.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.a;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.ax;

final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        m mVar = this.a;
        String replaceAll = mVar.a.getText().toString().trim().replaceAll("\\s", "");
        if (ax.a(replaceAll)) {
            mVar.c.setVisibility(8);
            mVar.a.setVisibility(8);
            mVar.b.setVisibility(0);
            d.INSTANCE.a(new d(mVar, replaceAll), new a(), j.a().b, BazaarApplication.c().a.getLanguage(), replaceAll);
            return;
        }
        mVar.a.startAnimation(AnimationUtils.loadAnimation(mVar.f, 2130968637));
        mVar.c.setVisibility(0);
        mVar.c.setText(2131165371);
    }
}
