package com.farsitel.bazaar.receiver;

final class e implements Runnable {
    String a;

    public e(String str) {
        this.a = str;
    }

    public final void run() {
        try {
            Thread.sleep(2000);
            try {
                PackageChangeReceiver.a(this.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
