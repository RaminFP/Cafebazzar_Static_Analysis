package android.support.v7.app;

final class y implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    y(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void run() {
        this.a.q.showAtLocation(this.a.p, 55, 0, 0);
    }
}
