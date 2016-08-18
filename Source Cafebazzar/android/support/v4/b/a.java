package android.support.v4.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.File;

public class a {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";

    private static File buildPath(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            File file3 = file2 == null ? new File(str) : str != null ? new File(file2, str) : file2;
            i++;
            file2 = file3;
        }
        return file2;
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    private static File createFilesDir(File file) {
        synchronized (a.class) {
            try {
                if (!(file.exists() || file.mkdirs() || file.exists())) {
                    Log.w(TAG, "Unable to create files subdir " + file.getPath());
                    file = null;
                }
            } catch (Throwable th) {
                Class cls = a.class;
            }
        }
        return file;
    }

    public static File getCodeCacheDir(Context context) {
        return VERSION.SDK_INT >= 21 ? context.getCodeCacheDir() : createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    public static final int getColor(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    public static final ColorStateList getColorStateList(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    public static final Drawable getDrawable(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? context.getDrawable(i) : context.getResources().getDrawable(i);
    }

    public static File[] getExternalCacheDirs(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return context.getExternalCacheDirs();
        }
        File externalCacheDir;
        if (i >= 8) {
            externalCacheDir = context.getExternalCacheDir();
        } else {
            externalCacheDir = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_CACHE);
        }
        return new File[]{externalCacheDir};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return context.getExternalFilesDirs(str);
        }
        File externalFilesDir;
        if (i >= 8) {
            externalFilesDir = context.getExternalFilesDir(str);
        } else {
            externalFilesDir = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_DATA, context.getPackageName(), DIR_FILES, str);
        }
        return new File[]{externalFilesDir};
    }

    public static File[] getObbDirs(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return context.getObbDirs();
        }
        File obbDir;
        if (i >= 11) {
            obbDir = context.getObbDir();
        } else {
            obbDir = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB, context.getPackageName());
        }
        return new File[]{obbDir};
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            context.startActivities(intentArr);
            return true;
        }
    }

    public final File getNoBackupFilesDir(Context context) {
        return VERSION.SDK_INT >= 21 ? context.getNoBackupFilesDir() : createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
}
