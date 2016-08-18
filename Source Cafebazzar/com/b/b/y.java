package com.b.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class y implements ag, ak {
    static int a = 100;
    static int b = 10;
    static int c = 1000;
    static int d = 160000;
    static int e = 50;
    static int f = 20;
    private static final String j = y.class.getSimpleName();
    private String A = "";
    private byte B = (byte) -1;
    private boolean C;
    private String D;
    private byte E;
    private long F;
    private long G;
    private final Map H = new HashMap();
    private final List I = new ArrayList();
    private boolean J;
    private int K;
    private final List L = new ArrayList();
    private int M;
    private int N;
    private final c O = new c();
    private final Handler P;
    private ae Q;
    private ac R;
    private int S;
    private boolean T = false;
    String g;
    boolean h;
    public Map i;
    private final AtomicInteger k = new AtomicInteger(0);
    private final AtomicInteger l = new AtomicInteger(0);
    private final AtomicInteger m = new AtomicInteger(0);
    private File n = null;
    private volatile boolean o = false;
    private String p;
    private List q;
    private final Map r = new HashMap();
    private long s;
    private List t = new ArrayList();
    private String u;
    private long v;
    private long w;
    private long x;
    private long y;
    private String z = "";

    public y(Context context, String str, ac acVar) {
        ba.a(4, j, "Initializing new Flurry session");
        HandlerThread handlerThread = new HandlerThread("FlurryAgentSession_" + str);
        handlerThread.start();
        this.P = new Handler(handlerThread.getLooper());
        if (TextUtils.isEmpty(this.u)) {
            a(new aa(this));
        }
        this.Q = new ae(this);
        this.R = acVar;
        this.g = str;
        this.n = context.getFileStreamPath(".flurryagent." + Integer.toString(this.g.hashCode(), 16));
        this.p = as.a();
        this.x = -1;
        this.M = 0;
        this.A = TimeZone.getDefault().getID();
        this.z = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
        this.J = true;
        this.K = 0;
        this.N = 0;
        aj a = ai.a();
        this.E = ((Byte) a.a("Gender")).byteValue();
        a.a("Gender", (ak) this);
        ba.a(4, j, "initSettings, Gender = " + this.E);
        this.D = (String) a.a("UserId");
        a.a("UserId", (ak) this);
        ba.a(4, j, "initSettings, UserId = " + this.D);
        this.C = ((Boolean) a.a("LogEvents")).booleanValue();
        a.a("LogEvents", (ak) this);
        ba.a(4, j, "initSettings, LogEvents = " + this.C);
        this.F = ((Long) a.a("Age")).longValue();
        a.a("Age", (ak) this);
        ba.a(4, j, "initSettings, BirthDate = " + this.F);
        this.G = ((Long) a.a("ContinueSessionMillis")).longValue();
        a.a("ContinueSessionMillis", (ak) this);
        ba.a(4, j, "initSettings, ContinueSessionMillis = " + this.G);
    }

    private void a(long j) {
        for (f fVar : this.I) {
            if (fVar.c && !fVar.d) {
                fVar.d = true;
                fVar.e = j - fVar.b;
                ba.a(3, "FlurryAgent", "Ended event '" + fVar.a + "' (" + fVar.b + ") after " + fVar.e + "ms");
            }
        }
    }

    private void a(bk bkVar) {
        this.P.post(bkVar);
    }

    static /* synthetic */ void b(y yVar, Context context) {
        try {
            byte[] a = an.a();
            if (a != null) {
                ba.a(3, j, "Fetched hashed IMEI");
                yVar.r.put(al.Sha1Imei, ByteBuffer.wrap(a));
            }
            yVar.f();
        } catch (Throwable th) {
            ba.a(6, j, "", th);
        }
    }

    static /* synthetic */ void c(y yVar, Context context) {
        try {
            Object obj;
            synchronized (yVar) {
                obj = yVar.t.size() > 0 ? 1 : null;
            }
            if (obj != null) {
                yVar.f();
            }
        } catch (Throwable th) {
            ba.a(6, j, "", th);
        }
    }

    private void f() {
        try {
            ba.a(3, j, "generating agent report");
            g gVar = new g(this.g, this.p, this.u, this.h, this.s, this.v, this.t, this.r, this.O.a(false), this.i, System.currentTimeMillis());
            this.q = new ArrayList(this.t);
            if (gVar.a != null) {
                ba.a(3, j, "generated report of size " + gVar.a.length + " with " + this.t.size() + " reports.");
                byte[] bArr = gVar.a;
                h hVar = a.a().c;
                StringBuilder stringBuilder = new StringBuilder();
                a.a();
                hVar.b(bArr, this.g, stringBuilder.append(a.b()).toString());
                this.t.removeAll(this.q);
                this.q = null;
                g();
                return;
            }
            ba.c(j, "Error generating report");
        } catch (Throwable th) {
            ba.a(6, j, "", th);
        }
    }

    private void g() {
        synchronized (this) {
            if (aw.a(this.n)) {
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.n));
                    ad adVar = new ad();
                    adVar.a = this.h;
                    adVar.c = this.s;
                    adVar.b = this.t;
                    adVar.a(dataOutputStream, this.g, this.u);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else {
                ba.c(j, "Error persisting report: could not create directory");
            }
        }
    }

    private void h() {
        Closeable dataInputStream;
        Throwable th;
        Closeable closeable = null;
        synchronized (this) {
            if (this.n.exists()) {
                ba.a(4, j, "loading persistent data: " + this.n.getAbsolutePath());
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(this.n));
                    try {
                        ad adVar = new ad();
                        this.o = adVar.a((DataInputStream) dataInputStream, this.g);
                        if (this.o) {
                            this.h = adVar.a;
                            this.s = adVar.c;
                            this.t = adVar.b;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ba.b(j, "Error when loading persistent file", th);
                            bj.a(dataInputStream);
                            if (!this.o) {
                                if (this.n.delete()) {
                                    ba.a(6, j, "Cannot delete persistence file");
                                } else {
                                    ba.a(3, j, "Deleted persistence file");
                                }
                            }
                            if (!this.o) {
                                this.h = false;
                                this.s = this.v;
                                this.o = true;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = dataInputStream;
                            bj.a(closeable);
                            throw th;
                        }
                    }
                    bj.a(dataInputStream);
                } catch (Throwable th4) {
                    th = th4;
                    bj.a(closeable);
                    throw th;
                }
                try {
                    if (this.o) {
                        if (this.n.delete()) {
                            ba.a(3, j, "Deleted persistence file");
                        } else {
                            ba.a(6, j, "Cannot delete persistence file");
                        }
                    }
                } catch (Throwable th5) {
                    ba.a(6, j, "", th5);
                }
            } else {
                ba.a(4, j, "Agent cache file doesn't exist.");
            }
            if (this.o) {
                this.h = false;
                this.s = this.v;
                this.o = true;
            }
        }
    }

    public final void a() {
        synchronized (this) {
            if (this.Q.b()) {
                this.Q.a();
            }
            this.S++;
            if (this.T) {
                ba.c(j, "Continuing previous session");
                if (!this.t.isEmpty()) {
                    this.t.remove(this.t.size() - 1);
                }
            } else {
                ba.c(j, "Start session");
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.v = System.currentTimeMillis();
                this.w = elapsedRealtime;
                a(new z(this));
                this.T = true;
            }
        }
    }

    public final void a(String str, Object obj) {
        if (str.equals("Gender")) {
            this.E = ((Byte) obj).byteValue();
            ba.a(4, j, "onSettingUpdate, Gender = " + this.E);
        } else if (str.equals("UserId")) {
            this.D = (String) obj;
            ba.a(4, j, "onSettingUpdate, UserId = " + this.D);
        } else if (str.equals("LogEvents")) {
            this.C = ((Boolean) obj).booleanValue();
            ba.a(4, j, "onSettingUpdate, LogEvents = " + this.C);
        } else if (str.equals("Age")) {
            this.F = ((Long) obj).longValue();
            ba.a(4, j, "onSettingUpdate, Birthdate = " + this.F);
        } else if (str.equals("ContinueSessionMillis")) {
            this.G = ((Long) obj).longValue();
            ba.a(4, j, "onSettingUpdate, ContinueSessionMillis = " + this.G);
        } else {
            ba.a(6, j, "onSettingUpdate internal error!");
        }
    }

    public final void a(String str, String str2, String str3, Throwable th) {
        synchronized (this) {
            Object obj;
            e eVar;
            int i;
            if (str != null) {
                if ("uncaught".equals(str)) {
                    obj = 1;
                    this.M++;
                    if (this.L.size() < e) {
                        eVar = new e(this.l.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), str, str2, str3, th);
                        this.L.add(eVar);
                        ba.c(j, "Error logged: " + eVar.a);
                    } else if (obj == null) {
                        for (i = 0; i < this.L.size(); i++) {
                            eVar = (e) this.L.get(i);
                            if (eVar.a == null && !"uncaught".equals(eVar.a)) {
                                this.L.set(i, new e(this.l.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), str, str2, str3, th));
                                break;
                            }
                        }
                    } else {
                        ba.c(j, "Max errors logged. No more errors logged.");
                    }
                }
            }
            obj = null;
            this.M++;
            if (this.L.size() < e) {
                eVar = new e(this.l.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), str, str2, str3, th);
                this.L.add(eVar);
                ba.c(j, "Error logged: " + eVar.a);
            } else if (obj == null) {
                ba.c(j, "Max errors logged. No more errors logged.");
            } else {
                while (i < this.L.size()) {
                    eVar = (e) this.L.get(i);
                    if (eVar.a == null) {
                    }
                }
            }
        }
    }

    public final void a(String str, Map map, boolean z) {
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.w;
            String a = bj.a(str);
            if (a.length() != 0) {
                b bVar = (b) this.H.get(a);
                if (bVar != null) {
                    bVar.a++;
                    ba.c(j, "Event count incremented: " + a);
                } else if (this.H.size() < a) {
                    bVar = new b();
                    bVar.a = 1;
                    this.H.put(a, bVar);
                    ba.c(j, "Event count started: " + a);
                } else {
                    ba.c(j, "Too many different events. Event not counted: " + a);
                }
                if (!this.C || this.I.size() >= c || this.K >= d) {
                    this.J = false;
                } else {
                    Map emptyMap = map == null ? Collections.emptyMap() : map;
                    if (emptyMap.size() > b) {
                        ba.c(j, "MaxEventParams exceeded: " + emptyMap.size());
                    } else {
                        f fVar = new f(this.k.incrementAndGet(), a, emptyMap, elapsedRealtime - j, false);
                        if (fVar.a().length + this.K <= d) {
                            this.I.add(fVar);
                            this.K = fVar.a().length + this.K;
                        } else {
                            this.K = d;
                            this.J = false;
                            ba.c(j, "Event Log size exceeded. No more event details logged.");
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        synchronized (this) {
            ba.c(j, "Trying to end session");
            if (this.T) {
                if (this.S > 0) {
                    this.S--;
                }
                if (this.S == 0) {
                    this.Q.a(this.G);
                }
            }
        }
    }

    public final void c() {
        synchronized (this) {
            if (this.S != 0) {
                ba.a(6, j, "Error! Session with apiKey = " + this.g + " was ended while getSessionCount() is not 0");
            }
            if (this.T) {
                ba.c(j, "Ending session");
                this.S = 0;
                if (this.Q.b()) {
                    this.Q.a();
                }
                this.x = SystemClock.elapsedRealtime() - this.w;
                a(this.x);
                a(new ab(this, ah.a.b));
                if (this.R != null) {
                    this.R.a(this.g);
                }
                ai.a().b("Gender", this);
                ai.a().b("UserId", this);
                ai.a().b("Age", this);
                ai.a().b("LogEvents", this);
                ai.a().b("ContinueSessionMillis", this);
                this.P.getLooper().quit();
            }
        }
    }

    final w d() {
        w wVar;
        synchronized (this) {
            x xVar = new x();
            xVar.a = this.p;
            xVar.b = this.v;
            xVar.c = this.x;
            xVar.d = this.y;
            xVar.e = this.z;
            xVar.f = this.A;
            xVar.g = this.B;
            xVar.h = this.D == null ? "" : this.D;
            a.a();
            xVar.i = a.d();
            xVar.j = this.N;
            xVar.k = this.E;
            xVar.l = Long.valueOf(this.F);
            xVar.m = this.H;
            xVar.n = this.I;
            xVar.o = this.J;
            xVar.q = this.L;
            xVar.p = this.M;
            try {
                wVar = new w(xVar);
            } catch (IOException e) {
                e.printStackTrace();
                wVar = null;
            }
            if (wVar == null) {
                ba.c(j, "New session report wasn't created");
            }
        }
        return wVar;
    }

    public final void e() {
        c();
    }
}
