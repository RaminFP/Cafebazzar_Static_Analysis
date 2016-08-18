package com.farsitel.bazaar.receiver;

import com.farsitel.bazaar.g.a.i;
import java.io.File;

final class f implements Runnable {
    String a;

    public f(String str) {
        this.a = str;
    }

    public final void run() {
        try {
            Thread.sleep(10000);
            try {
                File file = new File(i.a(this.a));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
