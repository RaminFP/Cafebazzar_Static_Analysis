package com.farsitel.bazaar.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.g.j;

final class bb implements OnClickListener {
    final /* synthetic */ ay a;

    bb(ay ayVar) {
        this.a = ayVar;
    }

    public final void onClick(View view) {
        if (j.a().i()) {
            ay.a(this.a, j.a().g());
        }
    }
}
