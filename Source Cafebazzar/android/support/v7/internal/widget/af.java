package android.support.v7.internal.widget;

final class af implements Runnable {
    final /* synthetic */ aa a;

    private af(aa aaVar) {
        this.a = aaVar;
    }

    public final void run() {
        if (!this.a.v) {
            this.a.a();
        } else if (this.a.getAdapter() != null) {
            this.a.post(this);
        }
    }
}
