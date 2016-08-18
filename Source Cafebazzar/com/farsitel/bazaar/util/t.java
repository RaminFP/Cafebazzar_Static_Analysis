package com.farsitel.bazaar.util;

import android.os.Environment;
import android.os.StatFs;
import com.farsitel.bazaar.BazaarApplication;
import java.io.File;

public final class t {
    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean a(long j) {
        try {
            StatFs statFs = a() ? new StatFs(Environment.getExternalStorageDirectory().getPath()) : new StatFs(Environment.getDataDirectory().getPath());
            return j < (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) - 5000000;
        } catch (Exception e) {
            return true;
        }
    }

    public static File b() {
        File filesDir = BazaarApplication.c().getFilesDir();
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalFilesDir = BazaarApplication.c().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return externalFilesDir;
            }
        }
        return filesDir;
    }

    public static File c() {
        File filesDir = BazaarApplication.c().getFilesDir();
        if (Environment.getExternalStorageState().equals("mounted")) {
            filesDir = new File(new File(Environment.getExternalStorageDirectory(), "icm"), "bazaar");
            if (!filesDir.exists()) {
                filesDir.mkdirs();
            }
        }
        return filesDir;
    }
}
