package com.farsitel.bazaar.d;

final class bf implements Runnable {
    final /* synthetic */ aw a;

    bf(aw awVar) {
        this.a = awVar;
    }

    public final void run() {
        if (this.a.a.getText() != null) {
            this.a.d(this.a.a.getText().toString());
        } else {
            this.a.d("");
        }
    }
}
