package com.farsitel.bazaar.g.a;

import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.t;
import java.io.File;

public class i extends j {
    protected int K = -1;
    protected boolean L;

    public i(String str, String str2, boolean z, int i) {
        super(str, str2);
        this.L = z;
        this.K = i;
        e();
    }

    public static String a(String str) {
        return new File(t.b(), str + ".fl.apk").getAbsolutePath();
    }

    public static String a(String str, String str2) {
        if (str == null || str.equals("")) {
            str = j.a().l();
        }
        return str2 != null ? str + "apks/" + str2 + ".apk?rand=" + System.currentTimeMillis() : null;
    }

    public static String b(String str, String str2) {
        if (str == null || str.equals("")) {
            str = j.a().l();
        }
        return str2 != null ? str + "apks/diffs/" + str2 + ".diff?rand=" + System.currentTimeMillis() : null;
    }

    public boolean a() {
        return this.L;
    }

    public final int f() {
        return this.K;
    }

    public String toString() {
        return "DownloadableAppInfo(pkgname=" + this.M + " isfree = " + this.L + ")";
    }
}
