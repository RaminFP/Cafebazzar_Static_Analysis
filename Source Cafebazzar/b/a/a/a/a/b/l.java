package b.a.a.a.a.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import b.a.a.a.f;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class l {
    public static final Comparator a = new m();
    private static Boolean b = null;
    private static final char[] c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long d = -1;

    public static int a() {
        return n.a().ordinal();
    }

    public static int a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int i = context.getApplicationContext().getApplicationInfo().icon;
        return resources.getIdentifier(str, str2, i > 0 ? context.getResources().getResourcePackageName(i) : context.getPackageName());
    }

    public static int a(Context context, boolean z) {
        float c = c(context);
        return !z ? 1 : (!z || ((double) c) < 99.0d) ? (!z || ((double) c) >= 99.0d) ? 0 : 2 : 3;
    }

    private static long a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    private static String a(File file, String str) {
        Closeable bufferedReader;
        Throwable e;
        String str2;
        Closeable closeable = null;
        if (file.exists()) {
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    f.a().c("Fabric", "Error parsing " + file, e);
                    a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedReader;
                    a(closeable, "Failed to close system file reader.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                a(closeable, "Failed to close system file reader.");
                throw e;
            }
        }
        return str2;
    }

    public static String a(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String a(String str) {
        return a(str.getBytes(), "SHA-1");
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i << 1] = c[i2 >>> 4];
            cArr[(i << 1) + 1] = c[i2 & 15];
        }
        return new String(cArr);
    }

    private static String a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return a(instance.digest());
        } catch (Throwable e) {
            f.a().c("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    public static String a(String... strArr) {
        List<String> arrayList = new ArrayList();
        for (int i = 0; i <= 0; i++) {
            String str = strArr[0];
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? a(append2) : null;
    }

    public static void a(Context context, int i, String str) {
        if (m(context)) {
            f.a().a(4, "Fabric", str);
        }
    }

    public static void a(Context context, String str) {
        if (m(context)) {
            f.a().a("Fabric", str);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                f.a().c("Fabric", str, e);
            }
        }
    }

    public static void a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                f.a().c("Fabric", str, e);
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int a = a(context, str, "bool");
        if (a > 0) {
            return resources.getBoolean(a);
        }
        int a2 = a(context, str, "string");
        return a2 > 0 ? Boolean.parseBoolean(context.getString(a2)) : z;
    }

    public static long b() {
        long a;
        synchronized (l.class) {
            String toUpperCase;
            try {
                if (d == -1) {
                    Object a2 = a(new File("/proc/meminfo"), "MemTotal");
                    if (!TextUtils.isEmpty(a2)) {
                        toUpperCase = a2.toUpperCase(Locale.US);
                        if (toUpperCase.endsWith("KB")) {
                            a = a(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            a = a(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            a = a(toUpperCase, "GB", 1073741824);
                        } else {
                            f.a().a("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                            a = 0;
                        }
                        d = a;
                    }
                    a = 0;
                    d = a;
                }
            } catch (Throwable e) {
                f.a().c("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
            } catch (Throwable th) {
                Class cls = l.class;
            }
            a = d;
        }
        return a;
    }

    public static long b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    private static String b(InputStream inputStream) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            f.a().c("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    public static void b(Context context, String str) {
        if (m(context)) {
            f.a().e("Fabric", str);
        }
    }

    public static float c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    public static String c(Context context, String str) {
        int a = a(context, str, "string");
        return a > 0 ? context.getString(a) : "";
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean d(Context context) {
        return e(context) ? false : ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static boolean e(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean f(Context context) {
        boolean e = e(context);
        String str = Build.TAGS;
        if ((e || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            File file = new File("/system/xbin/su");
            if (e || !file.exists()) {
                return false;
            }
        }
        return true;
    }

    public static int g(Context context) {
        Object obj = null;
        int i = e(context) ? 1 : 0;
        if (f(context)) {
            i |= 2;
        }
        if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
            obj = 1;
        }
        return obj != null ? i | 4 : i;
    }

    public static boolean h(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String i(Context context) {
        Closeable openRawResource;
        String str;
        Throwable e;
        Closeable closeable = null;
        try {
            openRawResource = context.getResources().openRawResource(j(context));
            try {
                String b = b((InputStream) openRawResource);
                if (!c(b)) {
                    str = b;
                }
                a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    f.a().c("Fabric", "Could not calculate hash for app icon.", e);
                    a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th) {
                    e = th;
                    closeable = openRawResource;
                    a(closeable, "Failed to close icon input stream.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            f.a().c("Fabric", "Could not calculate hash for app icon.", e);
            a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable th2) {
            e = th2;
            a(closeable, "Failed to close icon input stream.");
            throw e;
        }
        return str;
    }

    public static int j(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String k(Context context) {
        int a = a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        f.a().a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static boolean l(Context context) {
        if ((context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null) == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private static boolean m(Context context) {
        if (b == null) {
            b = Boolean.valueOf(a(context, "com.crashlytics.Trace", false));
        }
        return b.booleanValue();
    }
}
