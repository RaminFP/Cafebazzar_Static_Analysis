package com.d.a.b;

import com.d.a.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public final class d {
    public static boolean a = false;
    public static boolean b = false;
    private static String h = "";
    private static d i = null;
    private static d j = null;
    private static d k = null;
    private static int l = 25000;
    private final Process c;
    private final BufferedReader d;
    private final OutputStreamWriter e;
    private final List f = new ArrayList();
    private boolean g = false;
    private int m = 1000;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private boolean r = false;
    private Runnable s = new e(this);
    private Runnable t = new g(this);

    private d(String str) {
        a.a("Starting shell: " + str);
        this.c = new ProcessBuilder(new String[]{str}).redirectErrorStream(true).start();
        this.d = new BufferedReader(new InputStreamReader(this.c.getInputStream(), "UTF-8"));
        this.e = new OutputStreamWriter(this.c.getOutputStream(), "UTF-8");
        h hVar = new h(this.c, this.d, this.e);
        hVar.start();
        try {
            hVar.join((long) l);
            if (hVar.a == -911) {
                try {
                    this.c.destroy();
                } catch (Exception e) {
                }
                a(this.d);
                a(this.e);
                throw new TimeoutException(h);
            } else if (hVar.a == -42) {
                try {
                    this.c.destroy();
                } catch (Exception e2) {
                }
                a(this.d);
                a(this.e);
                throw new com.d.a.a.a("Root Access Denied");
            } else {
                Thread thread = new Thread(this.s, "Shell Input");
                thread.setPriority(5);
                thread.start();
                thread = new Thread(this.t, "Shell Output");
                thread.setPriority(5);
                thread.start();
            }
        } catch (InterruptedException e3) {
            hVar.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    public static d a(int i) {
        return a(i, 3);
    }

    private static d a(int i, int i2) {
        l = i;
        if (i == null) {
            a.a("Starting Root Shell!");
            int i3 = 0;
            while (i == null) {
                try {
                    i = new d("su");
                } catch (IOException e) {
                    if (i3 >= 3) {
                        a.a("IOException, could not start shell");
                        throw e;
                    }
                    i3++;
                }
            }
        } else {
            a.a("Using Existing Root Shell!");
        }
        return i;
    }

    public static void a() {
        if (j != null) {
            j.b();
        }
        if (i != null) {
            i.b();
        }
        if (k != null) {
            k.b();
        }
    }

    private static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }

    private static void a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static d b(int i) {
        l = i;
        try {
            if (j == null) {
                a.a("Starting Shell!");
                j = new d("/system/bin/sh");
            } else {
                a.a("Using Existing Shell!");
            }
            return j;
        } catch (com.d.a.a.a e) {
            throw new IOException();
        }
    }

    private void b() {
        if (this == i) {
            i = null;
        } else if (this == j) {
            j = null;
        } else if (this == k) {
            k = null;
        }
        synchronized (this.f) {
            this.g = true;
            c();
        }
    }

    private void c() {
        new f(this).start();
    }

    static /* synthetic */ void f(d dVar) {
        dVar.r = true;
        int abs = Math.abs(dVar.m - (dVar.m / 4));
        a.a("Cleaning up: " + abs);
        for (int i = 0; i < abs; i++) {
            dVar.f.remove(0);
        }
        dVar.n = dVar.f.size() - 1;
        dVar.o = dVar.f.size() - 1;
        dVar.r = false;
    }

    public final a a(a aVar) {
        if (this.g) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        }
        this.f.add(aVar);
        c();
        return aVar;
    }
}
