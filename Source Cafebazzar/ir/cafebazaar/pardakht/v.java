package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.b.n;
import com.farsitel.bazaar.i;

final class v implements n {
    final /* synthetic */ PardakhtActivity a;

    v(PardakhtActivity pardakhtActivity) {
        this.a = pardakhtActivity;
    }

    public final void a() {
        if ("shetab".equals(this.a.getIntent().getStringExtra("PARDAKHT_TYPE"))) {
            PardakhtActivity.d(this.a);
        }
        PardakhtActivity.f.d();
        i.a("/Pay-web/Cancel/");
        this.a.finish();
    }

    public final void b() {
    }
}
