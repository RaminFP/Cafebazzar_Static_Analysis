package com.farsitel.bazaar.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.g.j;

final class ba implements OnClickListener {
    final /* synthetic */ ay a;

    ba(ay ayVar) {
        this.a = ayVar;
    }

    public final void onClick(View view) {
        if (j.a().j()) {
            ay.a(this.a, j.a().e());
        } else {
            ay.a(this.a, j.a().g());
        }
    }
}
