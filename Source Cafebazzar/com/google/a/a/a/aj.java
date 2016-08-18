package com.google.a.a.a;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

final class aj extends Thread implements h {
    private static aj g;
    private final LinkedBlockingQueue a = new LinkedBlockingQueue();
    private volatile boolean b = false;
    private volatile boolean c = false;
    private volatile List d;
    private volatile String e;
    private volatile String f;
    private volatile bd h;
    private final Context i;

    private aj(Context context) {
        super("GAThread");
        if (context != null) {
            this.i = context.getApplicationContext();
        } else {
            this.i = context;
        }
        start();
    }

    static aj a(Context context) {
        if (g == null) {
            g = new aj(context);
        }
        return g;
    }

    private static String a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    private void a(Runnable runnable) {
        this.a.add(runnable);
    }

    static /* synthetic */ boolean a(aj ajVar, Map map) {
        if (map.get("&sf") != null) {
            double a = bi.a((String) map.get("&sf"), 100.0d);
            if (a < 100.0d) {
                int i;
                String str = (String) map.get("&cid");
                if (TextUtils.isEmpty(str)) {
                    i = 1;
                } else {
                    int i2 = 0;
                    for (int length = str.length() - 1; length >= 0; length--) {
                        char charAt = str.charAt(length);
                        i2 = (((i2 << 6) & 268435455) + charAt) + (charAt << 14);
                        int i3 = 266338304 & i2;
                        if (i3 != 0) {
                            i2 ^= i3 >> 21;
                        }
                    }
                    i = i2;
                }
                if (((double) (i % 10000)) >= a * 100.0d) {
                    str = map.get("&t") == null ? "unknown" : (String) map.get("&t");
                    as.c(String.format("%s hit sampled out", new Object[]{str}));
                    return true;
                }
            }
        }
        return false;
    }

    private static String b(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
            int read = openFileInput.read(bArr, 0, FragmentTransaction.TRANSIT_EXIT_MASK);
            if (openFileInput.available() > 0) {
                as.a("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                as.d("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            as.b("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            as.b("No campaign data found.");
            return null;
        } catch (IOException e2) {
            as.a("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    static /* synthetic */ void b(aj ajVar, Map map) {
        n a = i.a();
        bi.a(map, "&an", a.a("&an"));
        bi.a(map, "&av", a.a("&av"));
        bi.a(map, "&aid", a.a("&aid"));
        bi.a(map, "&aiid", a.a("&aiid"));
        map.put("&v", "1");
    }

    static /* synthetic */ String c(aj ajVar, Map map) {
        return map.containsKey("useSecure") ? bi.a((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    public final void a() {
        a(new al(this));
    }

    public final void a(Map map) {
        Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        a(new ak(this, hashMap));
    }

    public final void b() {
        a(new am(this));
    }

    public final LinkedBlockingQueue c() {
        return this.a;
    }

    public final Thread d() {
        return this;
    }

    public final void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            as.d("sleep interrupted in GAThread initialize");
        }
        if (this.h == null) {
            this.h = new aa(this.i, this);
        }
        this.h.e();
        this.d = new ArrayList();
        this.d.add(new Command("appendVersion", "&_v".substring(1), "ma3.0.0"));
        this.d.add(new Command("appendQueueTime", "&qt".substring(1), null));
        this.d.add(new Command("appendCacheBuster", "&z".substring(1), null));
        try {
            this.f = j.a().a("&cid");
            this.e = b(this.i);
        } catch (Throwable th) {
            as.a("Error initializing the GAThread: " + a(th));
            as.a("Google Analytics will not start up.");
            this.b = true;
        }
        while (!this.c) {
            try {
                Runnable runnable = (Runnable) this.a.take();
                if (!this.b) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                as.b(e2.toString());
            } catch (Throwable th2) {
                as.a("Error on GAThread: " + a(th2));
                as.a("Google Analytics is shutting down.");
                this.b = true;
            }
        }
    }
}
