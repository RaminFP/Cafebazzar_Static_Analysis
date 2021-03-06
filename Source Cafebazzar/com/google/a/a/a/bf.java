package com.google.a.a.a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public final class bf implements s {
    private final TreeSet a = new TreeSet();

    public bf(Context context, Collection collection) {
        a(context, collection);
    }

    private static Throwable a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private void a(Context context, Collection collection) {
        this.a.clear();
        Set<String> hashSet = new HashSet();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            try {
                String packageName = context.getApplicationContext().getPackageName();
                this.a.add(packageName);
                ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 15).activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        hashSet.add(activityInfo.packageName);
                    }
                }
            } catch (NameNotFoundException e) {
                as.b("No package found");
            }
        }
        for (String str : hashSet) {
            Iterator it = this.a.iterator();
            Object obj = 1;
            while (it.hasNext()) {
                packageName = (String) it.next();
                if (str.startsWith(packageName)) {
                    obj = null;
                } else {
                    if (packageName.startsWith(str)) {
                        this.a.remove(packageName);
                    }
                    if (obj != null) {
                        this.a.add(str);
                    }
                }
            }
            if (obj != null) {
                this.a.add(str);
            }
        }
    }

    public final String a(String str, Throwable th) {
        StackTraceElement stackTraceElement;
        Throwable a = a(th);
        StackTraceElement[] stackTrace = a(th).getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            stackTraceElement = null;
        } else {
            loop0:
            for (StackTraceElement stackTraceElement2 : stackTrace) {
                String className = stackTraceElement2.getClassName();
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    if (className.startsWith((String) it.next())) {
                        stackTraceElement = stackTraceElement2;
                        break loop0;
                    }
                }
            }
            stackTraceElement = stackTrace[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            String str2 = "unknown";
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            stringBuilder.append(String.format(" (@%s:%s:%s)", new Object[]{str2, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        if (str != null) {
            stringBuilder.append(String.format(" {%s}", new Object[]{str}));
        }
        return stringBuilder.toString();
    }
}
