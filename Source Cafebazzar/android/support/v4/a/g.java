package android.support.v4.a;

final class g implements Runnable {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        float drawingTime = ((float) (this.a.c.getDrawingTime() - this.a.d)) / ((float) this.a.e);
        if (drawingTime > 1.0f || this.a.c.getParent() == null) {
            drawingTime = 1.0f;
        }
        this.a.f = drawingTime;
        l lVar = this.a;
        for (int size = lVar.b.size() - 1; size >= 0; size--) {
            ((d) lVar.b.get(size)).onAnimationUpdate(lVar);
        }
        if (this.a.f >= 1.0f) {
            this.a.b();
        } else {
            this.a.c.postDelayed(this.a.g, 16);
        }
    }
}
