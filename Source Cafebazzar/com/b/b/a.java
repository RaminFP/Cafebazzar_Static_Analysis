package com.b.b;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a implements ac, ak, bg, UncaughtExceptionHandler {
    private static final String d = a.class.getSimpleName();
    private static a e;
    public y a;
    public Map b = new HashMap();
    public h c;
    private String f = "";
    private boolean g;

    private a() {
        bh.a().a((bg) this);
        at a = at.a();
        synchronized (a.b) {
            a.b.put(this, null);
        }
        aj a2 = ai.a();
        this.g = ((Boolean) a2.a("CaptureUncaughtExceptions")).booleanValue();
        a2.a("CaptureUncaughtExceptions", (ak) this);
        ba.a(4, d, "initSettings, CrashReportingEnabled = " + this.g);
        String str = (String) a2.a("VesionName");
        a2.a("VesionName", (ak) this);
        as.a(str);
        ba.a(4, d, "initSettings, VersionName = " + str);
    }

    public static a a() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    public static Map a(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        Bundle extras = ((Activity) context).getIntent().getExtras();
        if (extras == null) {
            return null;
        }
        ba.a(3, d, "Launch Options Bundle is present " + extras.toString());
        Map hashMap = new HashMap();
        for (String str : extras.keySet()) {
            if (str != null) {
                Object obj = extras.get(str);
                hashMap.put(str, new ArrayList(Arrays.asList(new String[]{obj != null ? obj.toString() : "null"})));
                ba.a(3, d, "Launch options Key: " + str + ". Its value: " + r1);
            }
        }
        return hashMap;
    }

    public static int b() {
        int intValue = ((Integer) ai.a().a("AgentVersion")).intValue();
        ba.a(4, d, "getAgentVersion() = " + intValue);
        return intValue;
    }

    public static int c() {
        return 0;
    }

    public static Location d() {
        ao a = ao.a();
        Location location = null;
        if (a.d) {
            location = a.a(a.f());
            if (location != null) {
                a.b = location;
            }
            location = a.b;
        }
        ba.a(4, ao.a, "getLocation() = " + location);
        return location;
    }

    public final void a(String str) {
        if (this.b.containsKey(str)) {
            y yVar = this.a;
            if (yVar != null && TextUtils.equals(yVar.g, str)) {
                this.a = null;
            }
            this.b.remove(str);
        } else {
            ba.a(6, d, "Ended session is not in the session map! Maybe it was already destroyed.");
        }
        if (this.b.isEmpty()) {
            ba.a(5, d, "LocationProvider is going to be unsubscribed");
            ao.a().d();
        }
    }

    public final void a(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.g = ((Boolean) obj).booleanValue();
            ba.a(4, d, "onSettingUpdate, CrashReportingEnabled = " + this.g);
        } else if (str.equals("VesionName")) {
            String str2 = (String) obj;
            as.a(str2);
            ba.a(4, d, "onSettingUpdate, VersionName = " + str2);
        } else {
            ba.a(6, d, "onSettingUpdate internal error!");
        }
    }

    public final void a(boolean z) {
    }

    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        if (this.g) {
            String str = "";
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                if (th.getMessage() != null) {
                    stringBuilder.append(" (" + th.getMessage() + ")\n");
                }
                str = stringBuilder.toString();
            } else if (th.getMessage() != null) {
                str = th.getMessage();
            }
            com.b.a.a.a("uncaught", str, th);
        }
        for (y yVar : new HashMap(this.b).values()) {
            if (yVar != null) {
                yVar.c();
            }
        }
        ao a = ao.a();
        a.e = 0;
        a.e();
    }
}
