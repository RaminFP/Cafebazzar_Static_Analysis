package com.farsitel.bazaar.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.util.ax;

final class f implements OnClickListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void onClick(View view) {
        m mVar = this.a;
        String replaceAll = mVar.a.getText().toString().trim().replaceAll("\\s", "");
        if (ax.b(replaceAll)) {
            new i(mVar, mVar.f, mVar.f.getString(2131165429, new Object[]{e.b(replaceAll)}), 2131165801, 0, 2131165463, true, replaceAll).e.show();
            return;
        }
        mVar.a.startAnimation(AnimationUtils.loadAnimation(mVar.f, 2130968637));
        mVar.c.setVisibility(0);
        mVar.c.setText(2131165372);
    }
}
