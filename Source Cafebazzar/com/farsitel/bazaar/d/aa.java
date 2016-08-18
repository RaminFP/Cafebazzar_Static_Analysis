package com.farsitel.bazaar.d;

public final class aa implements Runnable {
    final /* synthetic */ y a;

    public aa(y yVar) {
        this.a = yVar;
    }

    public final void run() {
        try {
            if (this.a.getView() != null) {
                this.a.a(this.a.getView());
            }
        } catch (Exception e) {
        }
    }
}
