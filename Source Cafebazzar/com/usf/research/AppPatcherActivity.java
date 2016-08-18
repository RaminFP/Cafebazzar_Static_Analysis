package com.usf.research;

import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.i;
import java.io.File;

public class AppPatcherActivity {
    public final boolean a(File file, File file2, File file3) {
        try {
            System.loadLibrary("native");
            boolean z = patch(file.getAbsolutePath(), file2.getAbsolutePath(), file3.getAbsolutePath()) == 0;
            if (z) {
                BazaarApplication.c().d();
                i.a("/Landa/Patch/Success");
                return z;
            }
            BazaarApplication.c().d();
            i.a("/Landa/Patch/Fail");
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public native int patch(String str, String str2, String str3);
}
