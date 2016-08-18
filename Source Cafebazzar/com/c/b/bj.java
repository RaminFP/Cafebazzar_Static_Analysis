package com.c.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

final class bj {
    static final StringBuilder a = new StringBuilder();

    static int a(Resources resources, aw awVar) {
        if (awVar.e != 0 || awVar.d == null) {
            return awVar.e;
        }
        String authority = awVar.d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + awVar.d);
        }
        List pathSegments = awVar.d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + awVar.d);
        } else if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt((String) pathSegments.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + awVar.d);
            }
        } else if (pathSegments.size() == 2) {
            return resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + awVar.d);
        }
    }

    static int a(Bitmap bitmap) {
        int byteCount = VERSION.SDK_INT >= 12 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
        if (byteCount >= 0) {
            return byteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static long a(File file) {
        long blockSize;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            blockSize = 5242880;
        }
        return Math.max(Math.min(blockSize, 52428800), 5242880);
    }

    static Resources a(Context context, aw awVar) {
        if (awVar.e != 0 || awVar.d == null) {
            return context.getResources();
        }
        String authority = awVar.d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + awVar.d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + awVar.d);
        }
    }

    static v a(Context context) {
        try {
            Class.forName("com.c.a.ag");
            return new ai(context);
        } catch (ClassNotFoundException e) {
            return new bh(context);
        }
    }

    static Object a(Context context, String str) {
        return context.getSystemService(str);
    }

    static Object a(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static String a(aw awVar) {
        String uri;
        StringBuilder stringBuilder = a;
        if (awVar.f != null) {
            stringBuilder.ensureCapacity(awVar.f.length() + 50);
            stringBuilder.append(awVar.f);
        } else if (awVar.d != null) {
            uri = awVar.d.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(awVar.e);
        }
        stringBuilder.append('\n');
        if (awVar.m != 0.0f) {
            stringBuilder.append("rotation:").append(awVar.m);
            if (awVar.p) {
                stringBuilder.append('@').append(awVar.n).append('x').append(awVar.o);
            }
            stringBuilder.append('\n');
        }
        if (awVar.c()) {
            stringBuilder.append("resize:").append(awVar.h).append('x').append(awVar.i);
            stringBuilder.append('\n');
        }
        if (awVar.j) {
            stringBuilder.append("centerCrop\n");
        } else if (awVar.k) {
            stringBuilder.append("centerInside\n");
        }
        if (awVar.g != null) {
            int size = awVar.g.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((bg) awVar.g.get(i)).a());
                stringBuilder.append('\n');
            }
        }
        uri = stringBuilder.toString();
        a.setLength(0);
        return uri;
    }

    static String a(d dVar) {
        return a(dVar, "");
    }

    static String a(d dVar, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        a aVar = dVar.k;
        if (aVar != null) {
            stringBuilder.append(aVar.b.a());
        }
        List list = dVar.l;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || aVar != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((a) list.get(i)).b.a());
            }
        }
        return stringBuilder.toString();
    }

    static void a() {
        if ((Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : null) == null) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static void a(Looper looper) {
        Handler bkVar = new bk(looper);
        bkVar.sendMessageDelayed(bkVar.obtainMessage(), 1000);
    }

    static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    static boolean a(String str) {
        if (str != null) {
            String[] split = str.split(" ", 2);
            if ("CACHE".equals(split[0])) {
                return true;
            }
            if (split.length != 1) {
                try {
                    if ("CONDITIONAL_CACHE".equals(split[0]) && Integer.parseInt(split[1]) == 304) {
                        return true;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static int c(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || VERSION.SDK_INT < 11) ? activityManager.getMemoryClass() : activityManager.getLargeMemoryClass();
        return (memoryClass * 1048576) / 7;
    }

    static boolean c(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    static boolean d(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
