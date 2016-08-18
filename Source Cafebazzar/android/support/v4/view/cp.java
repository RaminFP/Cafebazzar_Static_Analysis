package android.support.v4.view;

final class cp implements Runnable {
    final /* synthetic */ ViewPager a;

    cp(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final void run() {
        this.a.setScrollState(0);
        this.a.b();
    }
}
