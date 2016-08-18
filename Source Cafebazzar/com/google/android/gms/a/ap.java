package com.google.android.gms.a;

abstract class ap implements Runnable {
    final /* synthetic */ ac b;

    private ap(ac acVar) {
        this.b = acVar;
    }

    protected abstract void a();

    public void run() {
        this.b.b.lock();
        try {
            if (!Thread.interrupted()) {
                a();
                this.b.b.unlock();
            }
        } catch (RuntimeException e) {
            ba baVar = this.b.a;
            baVar.e.sendMessage(baVar.e.obtainMessage(2, e));
        } finally {
            this.b.b.unlock();
        }
    }
}
