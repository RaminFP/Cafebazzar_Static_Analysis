package com.b.b;

import android.location.Criteria;

public final class ai {
    public static final Integer a = Integer.valueOf(155);
    public static final String b = null;
    public static final Boolean c = Boolean.valueOf(true);
    public static final Boolean d = Boolean.valueOf(false);
    public static final String e = null;
    public static final Boolean f = Boolean.valueOf(true);
    public static final Criteria g = null;
    public static final Long h = Long.valueOf(10000);
    public static final Boolean i = Boolean.valueOf(true);
    public static final Long j = Long.valueOf(0);
    public static final Byte k = Byte.valueOf((byte) -1);
    private static aj l;

    public static aj a() {
        synchronized (ai.class) {
            Class cls;
            try {
                aj ajVar;
                if (l == null) {
                    ajVar = new aj();
                    l = ajVar;
                    if (ajVar == null) {
                        l = new aj();
                    }
                    l.a("AgentVersion", a);
                    l.a("VesionName", b);
                    l.a("CaptureUncaughtExceptions", c);
                    l.a("UseHttps", d);
                    l.a("ReportUrl", e);
                    l.a("ReportLocation", f);
                    l.a("LocationCriteria", g);
                    l.a("ContinueSessionMillis", h);
                    l.a("LogEvents", i);
                    l.a("Age", j);
                    l.a("Gender", k);
                    cls = "UserId";
                    l.a((String) cls, (Object) "");
                }
                ajVar = l;
                return ajVar;
            } finally {
                cls = ai.class;
            }
        }
    }
}
