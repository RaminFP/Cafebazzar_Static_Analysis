package b.a.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings.Secure;
import b.a.a.a.f;
import b.a.a.a.p;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public final class x {
    private static final Pattern h = Pattern.compile("[^\\p{Alnum}]");
    private static final String i = Pattern.quote("/");
    public final boolean a;
    public final boolean b;
    public final Context c;
    public final String d;
    c e;
    b f;
    boolean g;
    private final ReentrantLock j = new ReentrantLock();
    private final z k;
    private final String l;
    private final Collection m;

    public x(Context context, String str, String str2, Collection collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.c = context;
            this.d = str;
            this.l = str2;
            this.m = collection;
            this.k = new z();
            this.e = new c(context);
            this.a = l.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.a) {
                f.a().a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.b = l.a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.b) {
                f.a().a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public static String a(String str) {
        return str.replaceAll(i, "");
    }

    private static void a(Map map, y yVar, String str) {
        if (str != null) {
            map.put(yVar, str);
        }
    }

    private static String b(String str) {
        return str == null ? null : h.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public final String a() {
        String str = this.l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = l.a(this.c);
        str = a.getString("crashlytics.installation.id", null);
        return str == null ? a(a) : str;
    }

    public String a(SharedPreferences sharedPreferences) {
        this.j.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = b(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.j.unlock();
            return string;
        } catch (Throwable th) {
            this.j.unlock();
        }
    }

    public final String b() {
        return String.format(Locale.US, "%s/%s", new Object[]{a(Build.MANUFACTURER), a(Build.MODEL)});
    }

    public final Map c() {
        Map hashMap = new HashMap();
        for (p pVar : this.m) {
            if (pVar instanceof s) {
                for (Entry entry : ((s) pVar).c().entrySet()) {
                    a(hashMap, (y) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        a(hashMap, y.ANDROID_ID, g());
        a(hashMap, y.ANDROID_ADVERTISING_ID, f());
        return Collections.unmodifiableMap(hashMap);
    }

    public final String d() {
        return this.k.a(this.c);
    }

    public final b e() {
        b bVar;
        synchronized (this) {
            if (!this.g) {
                this.f = this.e.a();
                this.g = true;
            }
            bVar = this.f;
        }
        return bVar;
    }

    public final String f() {
        if (!this.a) {
            return null;
        }
        b e = e();
        return e != null ? e.a : null;
    }

    public final String g() {
        if (!this.a) {
            return null;
        }
        String string = Secure.getString(this.c.getContentResolver(), "android_id");
        return !"9774d56d682e549c".equals(string) ? b(string) : null;
    }
}
