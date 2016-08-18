package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.a.bz;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.measurement.a;

public final class z extends ba {
    public final ab a;
    public final ab b;
    final ab c;
    final ab d;
    final ab e;
    final ab f;
    public final ab g;
    private final String j = i.a();
    private final char k;
    private final long l = i.A();
    private final ab m;
    private final ab n;

    z(ap apVar) {
        super(apVar);
        if (super.n().C()) {
            this.k = i.B() ? 'P' : 'C';
        } else {
            this.k = i.B() ? 'p' : 'c';
        }
        this.a = new ab(this, 6, false, false);
        this.m = new ab(this, 6, true, false);
        this.n = new ab(this, 6, false, true);
        this.b = new ab(this, 5, false, false);
        this.c = new ab(this, 5, true, false);
        this.d = new ab(this, 5, false, true);
        this.e = new ab(this, 4, false, false);
        this.f = new ab(this, 3, false, false);
        this.g = new ab(this, 2, false, false);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    private static String a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return str + Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d);
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(th.toString());
                String a = a(a.class.getCanonicalName());
                String a2 = a(ap.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    private static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = a(z, obj);
        Object a2 = a(z, obj2);
        Object a3 = a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    protected final void a() {
    }

    protected final void a(int i, String str) {
        Log.println(i, this.j, str);
    }

    protected final void a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(this.j, i)) {
            a(i, a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            av.a((Object) str);
            ba baVar = this.h.c;
            if (baVar == null || !baVar.t() || baVar.i) {
                a(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
                return;
            }
            int i2 = i < 0 ? 0 : i;
            if (i2 >= 9) {
                i2 = 8;
            }
            String str2 = "1" + "01VDIWEA?".charAt(i2) + this.k + this.l + ":" + a(true, str, obj, obj2, obj3);
            if (str2.length() > 1024) {
                str2 = str.substring(0, 1024);
            }
            baVar.a(new aa(this, str2));
        }
    }

    public final String b() {
        Pair pair;
        ak akVar = super.m().b;
        akVar.e.e();
        akVar.e.e();
        long b = akVar.b();
        if (b == 0) {
            akVar.a();
            b = 0;
        } else {
            b = Math.abs(b - akVar.e.h().a());
        }
        if (b < akVar.d) {
            pair = null;
        } else if (b > (akVar.d << 1)) {
            akVar.a();
            pair = null;
        } else {
            String string = akVar.e.s().getString(akVar.c, null);
            long j = akVar.e.s().getLong(akVar.b, 0);
            akVar.a();
            pair = (string == null || j <= 0) ? ai.a : new Pair(string, Long.valueOf(j));
        }
        return pair == null ? null : String.valueOf(pair.second) + ":" + ((String) pair.first);
    }

    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public final /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    public final /* bridge */ /* synthetic */ x f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ bg g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ bz h() {
        return super.h();
    }

    public final /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ g j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ al k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ z l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ ai m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ i n() {
        return super.n();
    }
}
