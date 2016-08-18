package com.farsitel.bazaar.a;

import android.widget.ImageView;
import com.farsitel.bazaar.util.ad;

final class aw implements ad {
    final /* synthetic */ ImageView a;
    final /* synthetic */ av b;

    aw(av avVar, ImageView imageView) {
        this.b = avVar;
        this.a = imageView;
    }

    public final void a() {
        this.a.setBackgroundDrawable(null);
        this.b.f = null;
        if (this.b.e.size() > 0) {
            this.b.f = (ax) this.b.e.poll();
            this.b.a(this.b.f.a, this.b.f.b);
        }
    }

    public final void b() {
        this.b.f = null;
        if (this.b.e.size() > 0) {
            this.b.f = (ax) this.b.e.poll();
            this.b.a(this.b.f.a, this.b.f.b);
        }
    }
}
