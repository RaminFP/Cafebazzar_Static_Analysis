package com.congenialmobile.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.a.g;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.s;
import com.farsitel.bazaar.util.c;

public class WhatsNewActivity extends s {
    private c[] a;

    public WhatsNewActivity() {
        r0 = new c[4];
        r0[2] = new c(70102, 2131165570, new int[]{2131165770});
        r0[3] = new c(70000, 2131165569, new int[]{2131165769});
        this.a = r0;
    }

    public static void a() {
        int i;
        SharedPreferences sharedPreferences;
        int i2;
        Editor edit;
        Context c = BazaarApplication.c();
        try {
            PackageInfo packageInfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 0);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
                sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
                i2 = sharedPreferences.getInt("version_code", 0);
                edit = sharedPreferences.edit();
                edit.putInt("version_code", i);
                edit.commit();
                if (i > i2 && i2 > 0) {
                    a(i2);
                    return;
                }
            }
        } catch (Throwable e) {
            Log.e("WhatsNew", "", e);
        }
        i = 0;
        sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        i2 = sharedPreferences.getInt("version_code", 0);
        edit = sharedPreferences.edit();
        edit.putInt("version_code", i);
        edit.commit();
        if (i > i2) {
        }
    }

    private static void a(int i) {
        Context c = BazaarApplication.c();
        Intent intent = new Intent(c, WhatsNewActivity.class);
        intent.putExtra("version_code", i);
        intent.addFlags(268435456);
        c.a(c, intent);
    }

    public static void b() {
        a(0);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Application application = getApplication();
        if (application instanceof f) {
            ((f) application).a(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903088);
        int intExtra = getIntent().getIntExtra("version_code", 0);
        LayoutInflater from = LayoutInflater.from(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131624204);
        for (c cVar : this.a) {
            if (cVar.a > intExtra) {
                int[] iArr = cVar.c;
                View inflate = from.inflate(2130903166, null);
                ((TextView) inflate.findViewById(g.title)).setText(cVar.b);
                linearLayout.addView(inflate);
                for (int text : iArr) {
                    inflate = from.inflate(2130903165, null);
                    ((TextView) inflate.findViewById(g.title)).setText(text);
                    linearLayout.addView(inflate);
                }
            }
        }
        if (linearLayout.getChildCount() == 0) {
            finish();
        } else {
            ((Button) findViewById(2131624205)).setOnClickListener(new i(this));
        }
    }
}
