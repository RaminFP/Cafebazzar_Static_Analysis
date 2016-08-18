package com.a.a.c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.r;
import b.a.a.a.a.b.x;
import b.a.a.a.a.f.a;
import b.a.a.a.a.g.p;
import b.a.a.a.f;
import com.a.a.c.a.a.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ac implements UncaughtExceptionHandler {
    static final FilenameFilter a = new ad();
    static final Comparator b = new ai();
    static final Comparator c = new aj();
    static final FilenameFilter d = new ak();
    private static final Pattern h = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map i = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] j = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    final AtomicBoolean e;
    final v f;
    final h g;
    private final AtomicInteger k = new AtomicInteger(0);
    private final UncaughtExceptionHandler l;
    private final a m;
    private final x n;
    private final bb o;
    private final av p;
    private final String q;

    ac(UncaughtExceptionHandler uncaughtExceptionHandler, v vVar, x xVar, cd cdVar, a aVar, h hVar) {
        this.l = uncaughtExceptionHandler;
        this.f = vVar;
        this.n = xVar;
        this.g = hVar;
        this.q = cdVar.a();
        this.m = aVar;
        this.e = new AtomicBoolean(false);
        Context context = hVar.p;
        this.o = new bb(context, aVar);
        this.p = new av(context);
    }

    static String a(File file) {
        return file.getName().substring(0, 35);
    }

    static /* synthetic */ void a(ac acVar, d dVar) {
        Throwable th;
        Flushable flushable;
        Throwable th2;
        Throwable th3;
        Closeable closeable = null;
        Closeable dVar2;
        Flushable a;
        try {
            File[] e = acVar.e();
            String a2 = e.length > 1 ? a(e[1]) : null;
            if (a2 == null) {
                f.a().c("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                l.a(null, "Failed to flush to session begin file.");
                l.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            h.a(a2);
            dVar2 = new d(acVar.g(), a2 + "SessionCrash");
            try {
                a = f.a((OutputStream) dVar2);
                try {
                    bg.a(dVar, new bb(acVar.g.p, acVar.m, a2), new be(acVar.g()).b(a2), a);
                    l.a(a, "Failed to flush to session begin file.");
                    l.a(dVar2, "Failed to close fatal exception file output stream.");
                } catch (Throwable e2) {
                    th = e2;
                    flushable = a;
                    th2 = th;
                    try {
                        f.a().c("CrashlyticsCore", "An error occurred in the native crash logger", th2);
                        az.a(th2, (OutputStream) dVar2);
                        l.a(flushable, "Failed to flush to session begin file.");
                        l.a(dVar2, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th22) {
                        th = th22;
                        a = flushable;
                        closeable = dVar2;
                        th3 = th;
                        l.a(a, "Failed to flush to session begin file.");
                        l.a(closeable, "Failed to close fatal exception file output stream.");
                        throw th3;
                    }
                } catch (Throwable e22) {
                    th = e22;
                    closeable = dVar2;
                    th3 = th;
                    l.a(a, "Failed to flush to session begin file.");
                    l.a(closeable, "Failed to close fatal exception file output stream.");
                    throw th3;
                }
            } catch (Exception e3) {
                th22 = e3;
                f.a().c("CrashlyticsCore", "An error occurred in the native crash logger", th22);
                az.a(th22, (OutputStream) dVar2);
                l.a(flushable, "Failed to flush to session begin file.");
                l.a(dVar2, "Failed to close fatal exception file output stream.");
            } catch (Throwable th222) {
                th = th222;
                a = null;
                closeable = dVar2;
                th3 = th;
                l.a(a, "Failed to flush to session begin file.");
                l.a(closeable, "Failed to close fatal exception file output stream.");
                throw th3;
            }
        } catch (Exception e4) {
            th222 = e4;
            dVar2 = null;
            f.a().c("CrashlyticsCore", "An error occurred in the native crash logger", th222);
            az.a(th222, (OutputStream) dVar2);
            l.a(flushable, "Failed to flush to session begin file.");
            l.a(dVar2, "Failed to close fatal exception file output stream.");
        } catch (Throwable th2222) {
            th3 = th2222;
            a = null;
            l.a(a, "Failed to flush to session begin file.");
            l.a(closeable, "Failed to close fatal exception file output stream.");
            throw th3;
        }
    }

    static /* synthetic */ void a(ac acVar, Date date, Thread thread, Throwable th) {
        Throwable e;
        Throwable th2;
        Closeable closeable;
        Throwable th3;
        Throwable th4;
        Flushable flushable = null;
        acVar.g.b.a();
        try {
            String c = acVar.c();
            if (c == null) {
                f.a().c("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                l.a(null, "Failed to flush to session begin file.");
                l.a(null, "Failed to close fatal exception file output stream.");
            } else {
                h.a(c);
                Closeable dVar = new d(acVar.g(), c + "SessionCrash");
                Flushable a;
                try {
                    a = f.a((OutputStream) dVar);
                    try {
                        acVar.a(a, date, thread, th, "crash", true);
                        l.a(a, "Failed to flush to session begin file.");
                        l.a(dVar, "Failed to close fatal exception file output stream.");
                    } catch (Exception e2) {
                        e = e2;
                        th2 = e;
                        flushable = a;
                        closeable = dVar;
                        try {
                            f.a().c("CrashlyticsCore", "An error occurred in the fatal exception logger", th2);
                            az.a(th2, (OutputStream) closeable);
                            l.a(flushable, "Failed to flush to session begin file.");
                            l.a(closeable, "Failed to close fatal exception file output stream.");
                            acVar.a(false);
                            acVar.d();
                            cf.a(acVar.g(), a, 4, c);
                            if (acVar.g.k()) {
                                acVar.f();
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            l.a(flushable, "Failed to flush to session begin file.");
                            l.a(closeable, "Failed to close fatal exception file output stream.");
                            throw th2;
                        }
                    } catch (Throwable e3) {
                        th3 = e3;
                        flushable = a;
                        th4 = th3;
                        th2 = th4;
                        closeable = dVar;
                        l.a(flushable, "Failed to flush to session begin file.");
                        l.a(closeable, "Failed to close fatal exception file output stream.");
                        throw th2;
                    }
                } catch (Throwable th42) {
                    th3 = th42;
                    a = null;
                    e3 = th3;
                    th2 = e3;
                    flushable = a;
                    closeable = dVar;
                    f.a().c("CrashlyticsCore", "An error occurred in the fatal exception logger", th2);
                    az.a(th2, (OutputStream) closeable);
                    l.a(flushable, "Failed to flush to session begin file.");
                    l.a(closeable, "Failed to close fatal exception file output stream.");
                    acVar.a(false);
                    acVar.d();
                    cf.a(acVar.g(), a, 4, c);
                    if (acVar.g.k()) {
                        acVar.f();
                    }
                } catch (Throwable th6) {
                    th42 = th6;
                    th2 = th42;
                    closeable = dVar;
                    l.a(flushable, "Failed to flush to session begin file.");
                    l.a(closeable, "Failed to close fatal exception file output stream.");
                    throw th2;
                }
            }
        } catch (Throwable th422) {
            th2 = th422;
            closeable = null;
            f.a().c("CrashlyticsCore", "An error occurred in the fatal exception logger", th2);
            az.a(th2, (OutputStream) closeable);
            l.a(flushable, "Failed to flush to session begin file.");
            l.a(closeable, "Failed to close fatal exception file output stream.");
            acVar.a(false);
            acVar.d();
            cf.a(acVar.g(), a, 4, c);
            if (acVar.g.k()) {
                acVar.f();
            }
        } catch (Throwable th4222) {
            th2 = th4222;
            closeable = null;
            l.a(flushable, "Failed to flush to session begin file.");
            l.a(closeable, "Failed to close fatal exception file output stream.");
            throw th2;
        }
        acVar.a(false);
        acVar.d();
        cf.a(acVar.g(), a, 4, c);
        if (acVar.g.k()) {
            acVar.f();
        }
    }

    private static void a(f fVar, File file) {
        Throwable th;
        if (file.exists()) {
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    a((InputStream) fileInputStream, fVar, (int) file.length());
                    l.a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    l.a(fileInputStream, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                l.a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        f.a().c("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private void a(f fVar, String str) {
        for (String str2 : j) {
            File[] a = a(new ap(str + str2));
            if (a.length == 0) {
                f.a().c("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                f.a().a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                a(fVar, a[0]);
            }
        }
    }

    private void a(f fVar, Date date, Thread thread, Throwable th, String str, boolean z) {
        Map treeMap;
        Context context = this.g.p;
        long time = date.getTime() / 1000;
        float c = l.c(context);
        int a = l.a(context, this.p.e);
        boolean d = l.d(context);
        int i = context.getResources().getConfiguration().orientation;
        long b = l.b();
        long b2 = l.b(context);
        long b3 = l.b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = l.a(context.getPackageName(), context);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        String str2 = this.g.g;
        String str3 = this.n.d;
        Map allStackTraces = Thread.getAllStackTraces();
        Thread[] threadArr = new Thread[allStackTraces.size()];
        int i2 = 0;
        for (Entry entry : allStackTraces.entrySet()) {
            threadArr[i2] = (Thread) entry.getKey();
            linkedList.add(entry.getValue());
            i2++;
        }
        if (l.a(context, "com.crashlytics.CollectCustomKeys", true)) {
            allStackTraces = Collections.unmodifiableMap(this.g.a);
            treeMap = (allStackTraces == null || allStackTraces.size() <= 1) ? allStackTraces : new TreeMap(allStackTraces);
        } else {
            treeMap = new TreeMap();
        }
        cb.a(fVar, time, str, th, thread, stackTrace, threadArr, linkedList, treeMap, this.o, a2, i, str3, str2, c, a, d, b - b2, b3);
    }

    private static void a(f fVar, File[] fileArr, String str) {
        Arrays.sort(fileArr, l.a);
        for (File name : fileArr) {
            try {
                f.a().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                a(fVar, name);
            } catch (Throwable e) {
                f.a().c("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void a(File file, String str, File[] fileArr, File file2) {
        OutputStream dVar;
        Flushable a;
        Throwable e;
        Flushable flushable;
        Throwable th;
        Object obj;
        Throwable th2;
        Closeable closeable = null;
        boolean z = file2 != null;
        try {
            dVar = new d(g(), str);
            try {
                a = f.a(dVar);
            } catch (Exception e2) {
                e = e2;
                try {
                    f.a().c("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    az.a(e, dVar);
                    l.a(flushable, "Error flushing session file stream");
                    if (dVar == null) {
                        try {
                            dVar.a();
                        } catch (Throwable e3) {
                            f.a().c("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e3);
                            return;
                        }
                    }
                } catch (Throwable e4) {
                    th = e4;
                    a = flushable;
                    obj = dVar;
                    th2 = th;
                    l.a(a, "Error flushing session file stream");
                    l.a(closeable, "Failed to close CLS file");
                    throw th2;
                }
            } catch (Throwable e42) {
                th = e42;
                a = null;
                obj = dVar;
                th2 = th;
                l.a(a, "Error flushing session file stream");
                l.a(closeable, "Failed to close CLS file");
                throw th2;
            }
            try {
                f.a().a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                a((f) a, file);
                a.a(4, new Date().getTime() / 1000);
                a.a(5, z);
                a((f) a, str);
                a((f) a, fileArr, str);
                if (z) {
                    a((f) a, file2);
                }
                a.a(11, 1);
                a.b(12, 3);
                l.a(a, "Error flushing session file stream");
                l.a((Closeable) dVar, "Failed to close CLS file");
            } catch (Throwable e32) {
                th = e32;
                flushable = a;
                e42 = th;
                f.a().c("CrashlyticsCore", "Failed to write session file for session ID: " + str, e42);
                az.a(e42, dVar);
                l.a(flushable, "Error flushing session file stream");
                if (dVar == null) {
                    dVar.a();
                }
            } catch (Throwable e322) {
                th = e322;
                obj = dVar;
                th2 = th;
                l.a(a, "Error flushing session file stream");
                l.a(closeable, "Failed to close CLS file");
                throw th2;
            }
        } catch (Exception e5) {
            e42 = e5;
            dVar = null;
            f.a().c("CrashlyticsCore", "Failed to write session file for session ID: " + str, e42);
            az.a(e42, dVar);
            l.a(flushable, "Error flushing session file stream");
            if (dVar == null) {
                dVar.a();
            }
        } catch (Throwable e422) {
            th2 = e422;
            a = null;
            l.a(a, "Error flushing session file stream");
            l.a(closeable, "Failed to close CLS file");
            throw th2;
        }
    }

    private static void a(InputStream inputStream, f fVar, int i) {
        Object obj = new byte[i];
        int i2 = 0;
        while (i2 < obj.length) {
            int read = inputStream.read(obj, i2, obj.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        i2 = obj.length;
        if (fVar.b - fVar.c >= i2) {
            System.arraycopy(obj, 0, fVar.a, fVar.c, i2);
            fVar.c = i2 + fVar.c;
            return;
        }
        read = fVar.b - fVar.c;
        System.arraycopy(obj, 0, fVar.a, fVar.c, read);
        int i3 = read + 0;
        i2 -= read;
        fVar.c = fVar.b;
        fVar.a();
        if (i2 <= fVar.b) {
            System.arraycopy(obj, i3, fVar.a, 0, i2);
            fVar.c = i2;
            return;
        }
        fVar.d.write(obj, i3, i2);
    }

    private void a(String str) {
        for (File delete : a(new ar(str))) {
            delete.delete();
        }
    }

    private void a(boolean z) {
        Flushable a;
        Throwable e;
        Flushable flushable;
        int i = 1;
        Closeable closeable = null;
        int i2 = z ? 1 : 0;
        Set hashSet = new HashSet();
        File[] e2 = e();
        int min = Math.min(i2 + 8, e2.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(a(e2[i3]));
        }
        this.o.a(hashSet);
        for (File file : a(new ao())) {
            Object name = file.getName();
            Matcher matcher = h.matcher(name);
            matcher.matches();
            if (!hashSet.contains(matcher.group(1))) {
                f.a().a("CrashlyticsCore", "Trimming open session file: " + name);
                file.delete();
            }
        }
        e2 = e();
        if (e2.length <= i2) {
            f.a().a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        String a2 = a(e2[i2]);
        try {
            Closeable dVar = new d(g(), a2 + "SessionUser");
            try {
                a = f.a((OutputStream) dVar);
            } catch (Exception e3) {
                e = e3;
                flushable = null;
                closeable = dVar;
                try {
                    az.a(e, (OutputStream) closeable);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    l.a(flushable, "Failed to flush session user file.");
                    l.a(closeable, "Failed to close session user file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                flushable = null;
                closeable = dVar;
                l.a(flushable, "Failed to flush session user file.");
                l.a(closeable, "Failed to close session user file.");
                throw e;
            }
            try {
                ce ceVar = this.e.get() ? new ce(this.g.g(), this.g.i(), this.g.h()) : new be(g()).a(a2);
                if (!(ceVar.b == null && ceVar.c == null && ceVar.d == null)) {
                    i = 0;
                }
                if (i != 0) {
                    l.a(a, "Failed to flush session user file.");
                    l.a(dVar, "Failed to close session user file.");
                } else {
                    cb.a((f) a, ceVar.b, ceVar.c, ceVar.d);
                    l.a(a, "Failed to flush session user file.");
                    l.a(dVar, "Failed to close session user file.");
                }
                p l = h.l();
                if (l == null) {
                    f.a().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
                } else {
                    a(e2, i2, l.c);
                }
            } catch (Exception e4) {
                e = e4;
                closeable = dVar;
                flushable = a;
                az.a(e, (OutputStream) closeable);
                throw e;
            } catch (Throwable th3) {
                e = th3;
                flushable = a;
                closeable = dVar;
                l.a(flushable, "Failed to flush session user file.");
                l.a(closeable, "Failed to close session user file.");
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            flushable = null;
            az.a(e, (OutputStream) closeable);
            throw e;
        } catch (Throwable th4) {
            e = th4;
            flushable = null;
            l.a(flushable, "Failed to flush session user file.");
            l.a(closeable, "Failed to close session user file.");
            throw e;
        }
    }

    private void a(File[] fileArr, int i, int i2) {
        f.a().a("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String a = a(file);
            f.a().a("CrashlyticsCore", "Closing session: " + a);
            f.a().a("CrashlyticsCore", "Collecting session parts for ID " + a);
            File[] a2 = a(new ap(a + "SessionCrash"));
            boolean z = a2 != null && a2.length > 0;
            f.a().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{a, Boolean.valueOf(z)}));
            File[] a3 = a(new ap(a + "SessionEvent"));
            boolean z2 = a3 != null && a3.length > 0;
            f.a().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{a, Boolean.valueOf(z2)}));
            if (z || z2) {
                File[] a4;
                if (a3.length > i2) {
                    f.a().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i2)}));
                    cf.a(g(), new ap(a + "SessionEvent"), i2, c);
                    a4 = a(new ap(a + "SessionEvent"));
                } else {
                    a4 = a3;
                }
                a(file, a, a4, z ? a2[0] : null);
            } else {
                f.a().a("CrashlyticsCore", "No events present for session ID " + a);
            }
            f.a().a("CrashlyticsCore", "Removing session part files for ID " + a);
            a(a);
            i++;
        }
    }

    private String c() {
        File[] e = e();
        return e.length > 0 ? a(e[0]) : null;
    }

    private void d() {
        Flushable a;
        Closeable closeable;
        Throwable th;
        Throwable e;
        Throwable th2;
        Flushable flushable;
        Flushable flushable2;
        Throwable th3;
        Closeable closeable2;
        Closeable closeable3;
        OutputStream outputStream;
        Date date = new Date();
        String cVar = new c(this.n).toString();
        f.a().a("CrashlyticsCore", "Opening an new session with ID " + cVar);
        Flushable flushable3 = null;
        try {
            Closeable dVar = new d(g(), cVar + "BeginSession");
            try {
                flushable3 = f.a((OutputStream) dVar);
                try {
                    Locale locale = Locale.US;
                    h hVar = this.g;
                    String str = cVar;
                    cb.a((f) flushable3, str, String.format(locale, "Crashlytics Android SDK/%s", new Object[]{"2.3.8.97"}), date.getTime() / 1000);
                    l.a(flushable3, "Failed to flush to session begin file.");
                    l.a(dVar, "Failed to close begin session file.");
                    flushable3 = null;
                    try {
                        Closeable dVar2 = new d(g(), cVar + "SessionApp");
                        try {
                            a = f.a((OutputStream) dVar2);
                        } catch (Throwable e2) {
                            closeable = dVar2;
                            th = e2;
                            flushable3 = null;
                            try {
                                az.a(th, (OutputStream) closeable);
                                throw th;
                            } catch (Throwable th4) {
                                th = th4;
                                l.a(flushable3, "Failed to flush to session app file.");
                                l.a(closeable, "Failed to close session app file.");
                                throw th;
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            closeable = dVar2;
                            l.a(flushable3, "Failed to flush to session app file.");
                            l.a(closeable, "Failed to close session app file.");
                            throw th;
                        }
                        try {
                            cb.a((f) a, this.n.d, this.g.h, this.g.j, this.g.k, this.n.a(), r.a(this.g.i).e, this.q);
                            l.a(a, "Failed to flush to session app file.");
                            l.a(dVar2, "Failed to close session app file.");
                            closeable = null;
                            flushable3 = null;
                            try {
                                dVar = new d(g(), cVar + "SessionOS");
                                try {
                                    flushable3 = f.a((OutputStream) dVar);
                                    try {
                                        cb.a((f) flushable3, l.f(this.g.p));
                                        l.a(flushable3, "Failed to flush to session OS file.");
                                        l.a(dVar, "Failed to close session OS file.");
                                        flushable3 = null;
                                        flushable = null;
                                        try {
                                            closeable = new d(g(), cVar + "SessionDevice");
                                            try {
                                                flushable3 = f.a((OutputStream) closeable);
                                            } catch (Exception e3) {
                                                e2 = e3;
                                                flushable2 = flushable;
                                                th = e2;
                                                flushable3 = flushable2;
                                                try {
                                                    az.a(th, (OutputStream) closeable);
                                                    throw th;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    l.a(flushable3, "Failed to flush session device info.");
                                                    l.a(closeable, "Failed to close session device file.");
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                flushable3 = null;
                                                l.a(flushable3, "Failed to flush session device info.");
                                                l.a(closeable, "Failed to close session device file.");
                                                throw th;
                                            }
                                            try {
                                                Context context = this.g.p;
                                                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                                                x xVar = this.n;
                                                String str2 = "";
                                                if (xVar.a) {
                                                    str2 = xVar.g();
                                                    if (str2 == null) {
                                                        SharedPreferences a2 = l.a(xVar.c);
                                                        str2 = a2.getString("crashlytics.installation.id", null);
                                                        if (str2 == null) {
                                                            str2 = xVar.a(a2);
                                                        }
                                                    }
                                                }
                                                long blockCount = (long) statFs.getBlockCount();
                                                long blockSize = (long) statFs.getBlockSize();
                                                cb.a(flushable3, str2, l.a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), l.b(), blockSize * blockCount, l.e(context), this.n.c(), l.g(context), Build.MANUFACTURER, Build.PRODUCT);
                                                l.a(flushable3, "Failed to flush session device info.");
                                                l.a(closeable, "Failed to close session device file.");
                                                this.o.a(cVar);
                                            } catch (Throwable th7) {
                                                th3 = th7;
                                                flushable = flushable3;
                                                e2 = th3;
                                                flushable2 = flushable;
                                                th7 = e2;
                                                flushable3 = flushable2;
                                                az.a(th7, (OutputStream) closeable);
                                                throw th7;
                                            } catch (Throwable th8) {
                                                th7 = th8;
                                                l.a(flushable3, "Failed to flush session device info.");
                                                l.a(closeable, "Failed to close session device file.");
                                                throw th7;
                                            }
                                        } catch (Throwable th222) {
                                            flushable3 = null;
                                            th7 = th222;
                                            closeable = null;
                                            az.a(th7, (OutputStream) closeable);
                                            throw th7;
                                        } catch (Throwable th9) {
                                            th7 = th9;
                                            closeable = null;
                                            l.a(flushable3, "Failed to flush session device info.");
                                            l.a(closeable, "Failed to close session device file.");
                                            throw th7;
                                        }
                                    } catch (Exception e4) {
                                        th222 = e4;
                                        closeable2 = dVar;
                                        flushable = flushable3;
                                        closeable3 = closeable2;
                                        try {
                                            az.a(th222, outputStream);
                                            throw th222;
                                        } catch (Throwable th2222) {
                                            th3 = th2222;
                                            closeable = outputStream;
                                            flushable3 = flushable;
                                            th7 = th3;
                                            l.a(flushable3, "Failed to flush to session OS file.");
                                            l.a(closeable, "Failed to close session OS file.");
                                            throw th7;
                                        }
                                    } catch (Throwable th22222) {
                                        th3 = th22222;
                                        closeable = dVar;
                                        th7 = th3;
                                        l.a(flushable3, "Failed to flush to session OS file.");
                                        l.a(closeable, "Failed to close session OS file.");
                                        throw th7;
                                    }
                                } catch (Exception e5) {
                                    th22222 = e5;
                                    flushable3 = null;
                                    closeable2 = dVar;
                                    flushable = flushable3;
                                    closeable3 = closeable2;
                                    az.a(th22222, outputStream);
                                    throw th22222;
                                } catch (Throwable th222222) {
                                    flushable3 = null;
                                    closeable2 = dVar;
                                    th7 = th222222;
                                    closeable = closeable2;
                                    l.a(flushable3, "Failed to flush to session OS file.");
                                    l.a(closeable, "Failed to close session OS file.");
                                    throw th7;
                                }
                            } catch (Exception e6) {
                                th222222 = e6;
                                outputStream = null;
                                flushable = null;
                                az.a(th222222, outputStream);
                                throw th222222;
                            } catch (Throwable th10) {
                                th7 = th10;
                                l.a(flushable3, "Failed to flush to session OS file.");
                                l.a(closeable, "Failed to close session OS file.");
                                throw th7;
                            }
                        } catch (Throwable e22) {
                            th7 = e22;
                            flushable3 = a;
                            closeable = dVar2;
                            az.a(th7, (OutputStream) closeable);
                            throw th7;
                        } catch (Throwable e222) {
                            th7 = e222;
                            flushable3 = a;
                            closeable = dVar2;
                            l.a(flushable3, "Failed to flush to session app file.");
                            l.a(closeable, "Failed to close session app file.");
                            throw th7;
                        }
                    } catch (Throwable th2222222) {
                        flushable3 = null;
                        th7 = th2222222;
                        closeable = null;
                        az.a(th7, (OutputStream) closeable);
                        throw th7;
                    } catch (Throwable th11) {
                        th7 = th11;
                        closeable = null;
                        l.a(flushable3, "Failed to flush to session app file.");
                        l.a(closeable, "Failed to close session app file.");
                        throw th7;
                    }
                } catch (Exception e7) {
                    th2222222 = e7;
                    closeable2 = dVar;
                    flushable = flushable3;
                    closeable3 = closeable2;
                    try {
                        az.a(th2222222, outputStream);
                        throw th2222222;
                    } catch (Throwable th22222222) {
                        th3 = th22222222;
                        closeable = outputStream;
                        flushable3 = flushable;
                        th7 = th3;
                        l.a(flushable3, "Failed to flush to session begin file.");
                        l.a(closeable, "Failed to close begin session file.");
                        throw th7;
                    }
                } catch (Throwable th222222222) {
                    th3 = th222222222;
                    closeable = dVar;
                    th7 = th3;
                    l.a(flushable3, "Failed to flush to session begin file.");
                    l.a(closeable, "Failed to close begin session file.");
                    throw th7;
                }
            } catch (Exception e8) {
                th222222222 = e8;
                flushable3 = null;
                closeable2 = dVar;
                flushable = flushable3;
                closeable3 = closeable2;
                az.a(th222222222, outputStream);
                throw th222222222;
            } catch (Throwable th2222222222) {
                flushable3 = null;
                closeable2 = dVar;
                th7 = th2222222222;
                closeable = closeable2;
                l.a(flushable3, "Failed to flush to session begin file.");
                l.a(closeable, "Failed to close begin session file.");
                throw th7;
            }
        } catch (Exception e9) {
            th2222222222 = e9;
            outputStream = null;
            flushable = null;
            az.a(th2222222222, outputStream);
            throw th2222222222;
        } catch (Throwable th12) {
            th7 = th12;
            closeable = null;
            l.a(flushable3, "Failed to flush to session begin file.");
            l.a(closeable, "Failed to close begin session file.");
            throw th7;
        }
    }

    private File[] e() {
        File[] a = a(new ap("BeginSession"));
        Arrays.sort(a, b);
        return a;
    }

    private void f() {
        for (File aqVar : a(a)) {
            this.f.a(new aq(this.g, aqVar));
        }
    }

    private File g() {
        return this.m.a();
    }

    public final void a(String str, String str2, String str3) {
        this.f.b(new am(this, str, str2, str3));
    }

    File[] a(FilenameFilter filenameFilter) {
        File[] listFiles = g().listFiles(filenameFilter);
        return listFiles == null ? new File[0] : listFiles;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (this) {
            this.e.set(true);
            try {
                f.a().a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
                av avVar = this.p;
                if (avVar.a.getAndSet(false)) {
                    avVar.b.unregisterReceiver(avVar.d);
                    avVar.b.unregisterReceiver(avVar.c);
                }
                this.f.a(new al(this, new Date(), thread, th));
                f.a().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
                this.l.uncaughtException(thread, th);
                this.e.set(false);
            } catch (Throwable e) {
                f.a().c("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
                f.a().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
                this.l.uncaughtException(thread, th);
                this.e.set(false);
            } catch (Throwable th2) {
                f.a().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
                this.l.uncaughtException(thread, th);
                this.e.set(false);
            }
        }
    }
}
