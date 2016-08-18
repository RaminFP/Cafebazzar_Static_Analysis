package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.a.g;
import android.widget.Button;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.a.j;
import com.farsitel.bazaar.util.af;
import ir.cafebazaar.pardakht.h;

public class SubsRenewActivity extends t {
    private String a;
    private h b;

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 16 && i2 == -1) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        Drawable loadIcon;
        super.onCreate(bundle);
        setContentView(2130903121);
        Button button = (Button) findViewById(2131624137);
        TextView textView = (TextView) findViewById(g.text);
        TextView textView2 = (TextView) findViewById(g.title);
        this.b = new h(findViewById(2131624142), this);
        this.a = getIntent().getStringExtra("extra_package_name");
        String stringExtra = getIntent().getStringExtra("extra_sku");
        CharSequence stringExtra2 = getIntent().getStringExtra("extra_text");
        CharSequence stringExtra3 = getIntent().getStringExtra("android.intent.extra.TITLE");
        String stringExtra4 = getIntent().getStringExtra("extra_type");
        textView2.setText(stringExtra3);
        af afVar = af.INSTANCE;
        if (af.c(this.a)) {
            try {
                loadIcon = BazaarApplication.c().getPackageManager().getPackageInfo(this.a, 0).applicationInfo.loadIcon(BazaarApplication.c().getApplicationContext().getPackageManager());
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            if (loadIcon == null) {
                this.b.a(loadIcon);
            } else {
                this.b.a(new j(this.a).j());
            }
            this.b.a(Character.valueOf(stringExtra4.equals("M") ? 'M' : 'A'));
            this.b.a(true);
            textView.setText(stringExtra2);
            button.setOnClickListener(new dn(this, stringExtra));
        }
        loadIcon = null;
        if (loadIcon == null) {
            this.b.a(new j(this.a).j());
        } else {
            this.b.a(loadIcon);
        }
        if (stringExtra4.equals("M")) {
        }
        this.b.a(Character.valueOf(stringExtra4.equals("M") ? 'M' : 'A'));
        this.b.a(true);
        textView.setText(stringExtra2);
        button.setOnClickListener(new dn(this, stringExtra));
    }
}
