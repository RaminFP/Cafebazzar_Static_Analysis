package b.a.a.a;

import java.util.concurrent.CountDownLatch;

final class h implements l {
    final CountDownLatch a = new CountDownLatch(this.b);
    final /* synthetic */ int b;
    final /* synthetic */ f c;

    h(f fVar, int i) {
        this.c = fVar;
        this.b = i;
    }

    public final void a() {
        this.a.countDown();
        if (this.a.getCount() == 0) {
            this.c.n.set(true);
            this.c.k.a();
        }
    }

    public final void a(Exception exception) {
        this.c.k.a(exception);
    }
}
