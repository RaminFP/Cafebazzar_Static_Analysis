package com.farsitel.bazaar.g.a;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.util.o;

public class j {
    protected String M;
    protected String N;
    protected long O;
    protected boolean P;
    protected boolean Q;
    protected boolean R;
    protected boolean S;
    protected ApplicationInfo T;
    protected PackageInfo U;

    public j(String str) {
        this.T = null;
        this.M = str;
    }

    public j(String str, String str2) {
        this(str);
        this.N = str2;
    }

    public final void a(Activity activity) {
        if (this.Q) {
            activity.startActivityForResult(new Intent("android.intent.action.DELETE", Uri.parse("package:" + this.M)), 43);
        }
    }

    public void e() {
        j jVar;
        boolean z;
        boolean z2 = true;
        try {
            PackageManager packageManager = BazaarApplication.c().getPackageManager();
            this.U = packageManager.getPackageInfo(this.M, 0);
            this.T = this.U.applicationInfo;
            this.P = false;
            this.Q = false;
            if (this.T != null) {
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(this.M);
                this.P = packageManager.queryIntentActivities(intent, 0).size() > 0;
                this.Q = (this.T.flags & 1) == 0;
            }
        } catch (NameNotFoundException e) {
            this.U = null;
            this.T = null;
            this.P = false;
            this.Q = false;
        }
        if (this.U != null && ((long) this.U.versionCode) < this.O) {
            jVar = this;
            z = true;
        } else {
            jVar = this;
            z = false;
        }
        jVar.S = z;
        if (this.T == null) {
            z2 = false;
        }
        this.R = z2;
    }

    public final String g() {
        return this.M;
    }

    public final String h() {
        return this.N;
    }

    public final long i() {
        return this.O;
    }

    public final String j() {
        return String.format(VERSION.SDK_INT >= 17 ? "%sicons/%s_%s.webp" : "%sicons/%s_%s.png", new Object[]{com.farsitel.bazaar.g.j.a().l(), this.M, o.b()});
    }

    public final void k() {
        if (this.P) {
            try {
                Intent launchIntentForPackage = BazaarApplication.c().getPackageManager().getLaunchIntentForPackage(this.M);
                launchIntentForPackage.addFlags(268435456);
                BazaarApplication.c().startActivity(launchIntentForPackage);
            } catch (Throwable e) {
                Log.e("Bazaar", "AppInfo :: open", e);
            }
        } else if (this.R) {
            Toast.makeText(BazaarApplication.c(), 2131165278, 1).show();
        } else {
            Toast.makeText(BazaarApplication.c(), 2131165277, 1).show();
        }
    }

    public final boolean l() {
        return this.R;
    }

    public final boolean m() {
        return this.S;
    }

    public final boolean n() {
        return this.P;
    }

    public final boolean o() {
        return this.Q;
    }

    public String toString() {
        return "AppInfo(pkgname=" + this.M + ")";
    }
}
