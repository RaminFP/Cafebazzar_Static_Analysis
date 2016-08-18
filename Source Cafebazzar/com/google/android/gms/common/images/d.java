package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class d implements Runnable {
    final /* synthetic */ ImageManager a;
    private final Uri b;
    private final Bitmap c;
    private final CountDownLatch d;
    private boolean e;

    public d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.a = imageManager;
        this.b = uri;
        this.c = bitmap;
        this.e = z;
        this.d = countDownLatch;
    }

    private void a(ImageReceiver imageReceiver, boolean z) {
        ArrayList a = imageReceiver.c;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            e eVar = (e) a.get(i);
            if (z) {
                eVar.a(this.a.c, this.c, false);
            } else {
                this.a.j.put(this.b, Long.valueOf(SystemClock.elapsedRealtime()));
                eVar.a(this.a.c, this.a.g, false);
            }
            if (!(eVar instanceof g)) {
                this.a.h.remove(eVar);
            }
        }
    }

    public final void run() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException("OnBitmapLoadedRunnable must be executed in the main thread");
        }
        boolean z = this.c != null;
        if (this.a.f != null) {
            if (this.e) {
                this.a.f.a();
                System.gc();
                this.e = false;
                this.a.d.post(this);
                return;
            } else if (z) {
                this.a.f.a(new f(this.b), this.c);
            }
        }
        ImageReceiver imageReceiver = (ImageReceiver) this.a.i.remove(this.b);
        if (imageReceiver != null) {
            a(imageReceiver, z);
        }
        this.d.countDown();
        synchronized (ImageManager.a) {
            ImageManager.b.remove(this.b);
        }
    }
}
