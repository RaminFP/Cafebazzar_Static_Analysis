package com.google.android.gms.common.stats;

import com.google.android.gms.a.bm;

public final class d {
    public static bm a = bm.a("gms:common:stats:connections:level", Integer.valueOf(e.b));
    public static bm b = bm.a("gms:common:stats:connections:ignored_calling_processes", "");
    public static bm c = bm.a("gms:common:stats:connections:ignored_calling_services", "");
    public static bm d = bm.a("gms:common:stats:connections:ignored_target_processes", "");
    public static bm e = bm.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static bm f = bm.a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
}
