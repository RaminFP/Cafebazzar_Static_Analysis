package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.a.bz;
import com.google.android.gms.a.cl;
import com.google.android.gms.a.cm;
import com.google.android.gms.a.co;
import com.google.android.gms.a.dd;
import com.google.android.gms.common.internal.av;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class g extends az {
    g(ap apVar) {
        super(apVar);
    }

    static Object a(int i, Object obj, boolean z) {
        if (obj == null) {
            obj = null;
        } else if (!((obj instanceof Long) || (obj instanceof Float))) {
            if (obj instanceof Integer) {
                return Long.valueOf((long) ((Integer) obj).intValue());
            }
            if (obj instanceof Byte) {
                return Long.valueOf((long) ((Byte) obj).byteValue());
            }
            if (obj instanceof Short) {
                return Long.valueOf((long) ((Short) obj).shortValue());
            }
            if (obj instanceof Boolean) {
                return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
            } else if (obj instanceof Double) {
                return Float.valueOf((float) ((Double) obj).doubleValue());
            } else {
                if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                    return null;
                }
                obj = String.valueOf(obj);
                if (obj.length() > i) {
                    return z ? obj.substring(0, i) : null;
                }
            }
        }
        return obj;
    }

    private void a(String str, String str2, int i, Object obj) {
        if (obj == null) {
            super.l().d.a(str + " value can't be null. Ignoring " + str, str2);
        } else if (!(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.length() > i) {
                    super.l().d.a("Ignoring " + str + ". Value is too long. name, value length", str2, Integer.valueOf(valueOf.length()));
                }
            }
        }
    }

    public static boolean a(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean a(Context context, Class cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    private int c(String str) {
        return "_ldl".equals(str) ? i.r() : i.q();
    }

    public final void a(Bundle bundle, String str, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (str != null) {
            super.l().d.a("Not putting event parameter. Invalid value type. name, type", str, obj.getClass().getSimpleName());
        }
    }

    public final void a(cl clVar, Object obj) {
        av.a(obj);
        clVar.b = null;
        clVar.c = null;
        clVar.d = null;
        if (obj instanceof String) {
            clVar.b = (String) obj;
        } else if (obj instanceof Long) {
            clVar.c = (Long) obj;
        } else if (obj instanceof Float) {
            clVar.d = (Float) obj;
        } else {
            super.l().a.a("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void a(co coVar, Object obj) {
        av.a(obj);
        coVar.c = null;
        coVar.d = null;
        coVar.e = null;
        if (obj instanceof String) {
            coVar.c = (String) obj;
        } else if (obj instanceof Long) {
            coVar.d = (Long) obj;
        } else if (obj instanceof Float) {
            coVar.e = (Float) obj;
        } else {
            super.l().a.a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void a(String str) {
        int b = i.b();
        if (str == null) {
            throw new IllegalArgumentException("user attribute" + " name is required and can't be null");
        } else if (str.length() == 0) {
            throw new IllegalArgumentException("user attribute" + " name is required and can't be empty");
        } else {
            char charAt = str.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str.length()) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        throw new IllegalArgumentException("user attribute" + " name must consist of letters, digits or _ (underscores)");
                    }
                }
                if (str.length() > b) {
                    throw new IllegalArgumentException("user attribute" + " name is too long. The maximum supported length is " + b);
                }
                return;
            }
            throw new IllegalArgumentException("user attribute" + " name must start with a letter or _");
        }
    }

    public final void a(String str, Object obj) {
        if ("_ldl".equals(str)) {
            a("user attribute referrer", str, c(str), obj);
        } else {
            a("user attribute", str, c(str), obj);
        }
    }

    public final boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(super.h().a() - j) > j2;
    }

    public final byte[] a(cm cmVar) {
        try {
            byte[] bArr = new byte[cmVar.d()];
            dd a = dd.a(bArr);
            cmVar.a(a);
            a.a();
            return bArr;
        } catch (IOException e) {
            super.l().a.a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final byte[] a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            super.l().a.a("Failed to gzip content", e);
            throw e;
        }
    }

    public final Object b(String str, Object obj) {
        return "_ldl".equals(str) ? a(c(str), obj, true) : a(c(str), obj, false);
    }

    public final boolean b(String str) {
        super.e();
        return super.i().checkCallingOrSelfPermission(str) == 0;
    }

    public final byte[] b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            super.l().a.a("Failed to ungzip content", e);
            throw e;
        }
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
