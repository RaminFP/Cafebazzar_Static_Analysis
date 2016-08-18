package com.d.a.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;

public abstract class a {
    c d = null;
    Handler e = null;
    boolean f = false;
    String[] g = new String[0];
    boolean h = false;
    Context i = null;
    boolean j = false;
    boolean k = false;
    boolean l = true;
    int m = -1;
    int n = 0;
    int o = com.d.a.a.d;

    public a(int i, String... strArr) {
        this.g = strArr;
        this.n = i;
        boolean z = com.d.a.a.c;
        this.l = z;
        if (Looper.myLooper() == null || !z) {
            com.d.a.a.a("CommandHandler not created");
            return;
        }
        com.d.a.a.a("CommandHandler created");
        this.e = new b();
    }

    private void d() {
        this.f = false;
        this.j = true;
        notifyAll();
    }

    public abstract void a();

    protected final void a(int i) {
        synchronized (this) {
            this.m = i;
        }
    }

    public void a(int i, String str) {
        if (this.e != null && this.l) {
            Message obtainMessage = this.e.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("text", str);
            obtainMessage.setData(bundle);
            this.e.sendMessage(obtainMessage);
        }
    }

    public final void a(String str) {
        try {
            d.a();
            com.d.a.a.a("Terminating all shells.");
            b(str);
        } catch (IOException e) {
        }
    }

    protected final void b() {
        if (!this.k) {
            synchronized (this) {
                if (this.e == null || !this.l) {
                    a();
                } else {
                    Message obtainMessage = this.e.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 2);
                    obtainMessage.setData(bundle);
                    this.e.sendMessage(obtainMessage);
                }
                com.d.a.a.a("Command " + this.n + " finished.");
                d();
            }
        }
    }

    protected final void b(String str) {
        synchronized (this) {
            if (this.e != null && this.l) {
                Message obtainMessage = this.e.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 3);
                bundle.putString("text", str);
                obtainMessage.setData(bundle);
                this.e.sendMessage(obtainMessage);
            }
            com.d.a.a.a("Command " + this.n + " did not finish because it was terminated. Termination reason: " + str);
            a(-1);
            this.k = true;
            d();
        }
    }

    public final String c() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.h) {
            String path = this.i.getFilesDir().getPath();
            while (i < this.g.length) {
                stringBuilder.append("dalvikvm -cp " + path + "/anbuild.dex com.android.internal.util.WithFramework" + " com.stericson.RootTools.containers.RootClass " + this.g[i]);
                stringBuilder.append('\n');
                i++;
            }
        } else {
            while (i < this.g.length) {
                stringBuilder.append(this.g[i]);
                stringBuilder.append('\n');
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
