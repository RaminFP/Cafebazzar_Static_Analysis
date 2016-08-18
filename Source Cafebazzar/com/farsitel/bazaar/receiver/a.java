package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class a extends BroadcastReceiver {
    private final String a;
    public boolean b = false;

    public a(String str) {
        this.a = str;
    }

    public abstract void a();

    public abstract void a(long j, long j2);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public void onReceive(Context context, Intent intent) {
        if ("com.farsitel.bazaar.DOWNLOAD_PROGRESS".equals(intent.getAction()) && intent.getStringExtra("package_name").equals(this.a)) {
            int intExtra = intent.getIntExtra("progress_status", 0);
            long longExtra = intent.getLongExtra("downloaded_size", 0);
            long longExtra2 = intent.getLongExtra("total_size", 0);
            switch (intExtra) {
                case 0:
                    e();
                    return;
                case 1:
                    d();
                    return;
                case 2:
                    c();
                    return;
                case 3:
                    g();
                    return;
                case 4:
                    h();
                    return;
                case 5:
                    i();
                    return;
                case 6:
                    j();
                    return;
                case 7:
                    k();
                    return;
                case 8:
                    l();
                    return;
                case 9:
                    m();
                    return;
                case 10:
                    return;
                case 11:
                    f();
                    return;
                case 12:
                    a();
                    return;
                case 13:
                    a(longExtra, longExtra2);
                    return;
                case 14:
                    b();
                    return;
                default:
                    return;
            }
        }
    }
}
