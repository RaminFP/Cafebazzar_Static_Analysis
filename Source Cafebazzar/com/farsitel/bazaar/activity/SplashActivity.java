package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.a;
import com.farsitel.bazaar.util.at;
import com.farsitel.bazaar.util.h;

public class SplashActivity extends s implements OnClickListener {
    private Handler a = new Handler();
    private long b = 0;
    private View c;
    private Button d;

    private void a() {
        new dl(this).c();
        a.a(true);
    }

    private void b() {
        startActivity(new Intent(this, HomeActivity.class));
        overridePendingTransition(0, 0);
        finish();
    }

    public void onClick(View view) {
        this.d.setVisibility(8);
        this.c.setVisibility(0);
        a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && action != null && action.equals("android.intent.action.MAIN")) {
                finish();
                return;
            }
        }
        if (System.currentTimeMillis() - BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getLong("pref_last_shown_splash", 0) < 86400000) {
            h.INSTANCE.a();
            b();
            return;
        }
        BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit().putLong("pref_last_shown_splash", System.currentTimeMillis()).commit();
        setContentView(2130903083);
        if (VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            LayoutParams attributes = window.getAttributes();
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
            at atVar = new at(this);
            atVar.a(true);
            atVar.a(-1184275);
        }
        this.c = findViewById(2131624043);
        this.d = (Button) findViewById(2131624192);
        this.d.setOnClickListener(this);
        this.b = System.currentTimeMillis();
        if (j.a().l() != null) {
            this.d.setVisibility(4);
            this.c.setVisibility(4);
            this.a.postDelayed(new dk(this), 2000);
        } else {
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            a();
        }
        h.INSTANCE.a();
    }
}
