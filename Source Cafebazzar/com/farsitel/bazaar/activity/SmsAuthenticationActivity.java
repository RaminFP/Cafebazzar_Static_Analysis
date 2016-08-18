package com.farsitel.bazaar.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ao;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.a;

public class SmsAuthenticationActivity extends t implements OnClickListener {
    public static int a = 4;
    private static long b = 120000;
    private static long c = 1000;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private TextView h;
    private Button i;
    private TextView j;
    private TextView k;
    private TextView l;
    private EditText m;
    private ProgressDialog n;
    private b o = new dd(this);

    public static Intent a(Context context, String str) {
        Intent intent = new Intent(context, SmsAuthenticationActivity.class);
        intent.putExtra("extra_auth_code", str);
        return intent;
    }

    public static Intent a(Context context, String str, boolean z, boolean z2, boolean z3) {
        Intent intent = new Intent(context, SmsAuthenticationActivity.class);
        intent.putExtra("extra_phone_number", str);
        intent.putExtra("extra_had_password", z);
        intent.putExtra("extra_is_new_user", z2);
        intent.putExtra("extra_then_login", z3);
        return intent;
    }

    private void a() {
        new dh(this, b, c).start();
        this.j.setEnabled(false);
    }

    private void b() {
        CharSequence text = this.m.getText();
        if (text == null || TextUtils.isEmpty(text)) {
            this.m.startAnimation(AnimationUtils.loadAnimation(this, 2130968637));
            return;
        }
        this.n.show();
        if (this.f) {
            String str = this.d;
            String obj = text.toString();
            new com.farsitel.bazaar.h.a.b(str, obj, false).a(this.o);
            return;
        }
        a.a(this.d, text.toString(), this.o);
    }

    public void onBackPressed() {
        new di(this, this, 2131165778, 2131165801, 0, 2131165463, true).e.show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131624111:
                b();
                break;
            case 2131624177:
                break;
            default:
                return;
        }
        this.h.setTextColor(getResources().getColor(2131558561));
        this.h.setText(getString(this.e ? 2131165786 : 2131165787, new Object[]{e.b(this.d)}));
        view.setEnabled(false);
        if (this.f) {
            d.INSTANCE.a(new dj(), new ao(), BazaarApplication.c().a.getLanguage(), this.d, Boolean.valueOf(true));
        } else {
            d.INSTANCE.a(new dj(), new com.farsitel.bazaar.h.b.b(), j.a().b, BazaarApplication.c().a.getLanguage(), this.d, Boolean.valueOf(true));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        BazaarApplication.c().a(configuration);
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras().get("extra_auth_code") != null) {
            finish();
            return;
        }
        BazaarApplication.c().a((ContextWrapper) this);
        setContentView(2130903080);
        if (VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(displayMetrics.widthPixels, (int) getResources().getDimension(2131361822)), -2);
        this.n = new ProgressDialog(this);
        this.n.setMessage(getString(2131165546));
        this.n.setCancelable(false);
        this.d = getIntent().getExtras().getString("extra_phone_number");
        this.g = getIntent().getExtras().getBoolean("extra_had_password");
        this.f = getIntent().getExtras().getBoolean("extra_then_login");
        this.e = getIntent().getExtras().getBoolean("extra_is_new_user");
        this.k = (TextView) findViewById(2131624113);
        if (this.e) {
            this.k.setText(Html.fromHtml(getString(2131165739)));
            Linkify.addLinks(this.k, 15);
            this.k.setMovementMethod(LinkMovementMethod.getInstance());
            this.k.requestFocus();
            this.k.setVisibility(0);
        }
        this.l = (TextView) findViewById(2131624112);
        this.l.setOnClickListener(new de(this));
        if (this.g) {
            this.l.setVisibility(0);
        }
        this.h = (TextView) findViewById(2131624176);
        this.h.setTextColor(getResources().getColor(2131558561));
        this.h.setText(getString(this.e ? 2131165786 : 2131165787, new Object[]{e.b(this.d)}));
        this.m = (EditText) findViewById(2131624110);
        this.m.addTextChangedListener(new dg(this));
        this.i = (Button) findViewById(2131624111);
        this.i.setOnClickListener(this);
        this.j = (TextView) findViewById(2131624177);
        this.j.setOnClickListener(this);
        a();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!intent.getExtras().getString("extra_auth_code").isEmpty()) {
            this.m.setText(intent.getExtras().getString("extra_auth_code"));
            b();
        }
    }

    protected void onStart() {
        super.onStart();
        BazaarApplication.c().d();
        i.a("/SmsVerification");
    }
}
