package com.farsitel.bazaar.activity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.o;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.h.b.an;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.ag;
import com.farsitel.bazaar.util.ax;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.av;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JoinActivity extends t implements OnClickListener, k, l {
    private static final BazaarApplication a = BazaarApplication.c();
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private h f;
    private TextView g;
    private AutoCompleteTextView h;
    private Button i;
    private TextView j;
    private TextView k;
    private Dialog l;
    private String m;
    private b n = new bk(this);
    private b o = new bl(this);

    private void a(String str) {
        this.g.setVisibility(0);
        this.g.setText(str);
    }

    private void b() {
        Object replaceAll = this.h.getText().toString().toLowerCase().trim().replaceAll("\\s", "");
        if (ax.b(replaceAll)) {
            new bn(this, this, getString(2131165429, new Object[]{e.b(replaceAll)}), 2131165801, 0, 2131165463, true, replaceAll).e.show();
        } else if (ax.a(replaceAll)) {
            boolean z;
            for (Account account : AccountManager.get(BazaarApplication.c()).getAccountsByType("com.google")) {
                if (account.name.contentEquals(replaceAll)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                this.g.setVisibility(8);
                new bo(this, this, getString(2131165283, new Object[]{replaceAll}), 2131165801, 0, 2131165463, true, replaceAll).e.show();
                return;
            }
            this.l.show();
            d.INSTANCE.a(new bq(), new an(), a.a.getLanguage(), replaceAll);
        } else {
            this.h.startAnimation(AnimationUtils.loadAnimation(this, 2130968637));
            a(getString(2131165766));
        }
    }

    public final void a(int i) {
    }

    public final void a(Bundle bundle) {
        this.b = false;
        new bp(this).execute(new Void[0]);
    }

    public final void a(ConnectionResult connectionResult) {
        if (this.c || !this.b) {
            this.l.dismiss();
            Toast.makeText(getApplicationContext(), getString(2131165396), 1).show();
        } else if (connectionResult.a()) {
            try {
                connectionResult.a(this, 217);
                this.c = true;
            } catch (SendIntentException e) {
                this.c = false;
                this.f.a();
            }
        } else {
            this.l.dismiss();
            Toast.makeText(getApplicationContext(), getString(2131165396), 1).show();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 217:
                if (i2 != -1) {
                    this.b = false;
                }
                this.c = false;
                this.f.a();
                return;
            case 218:
            case 219:
                setResult(i2);
                setIntent(intent);
                finish();
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        a.d();
        i.a("/Join/Cancel");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131624120:
                b();
                return;
            default:
                return;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        a.a(configuration);
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        a a;
        c cVar;
        a.a((ContextWrapper) this);
        super.onCreate(bundle);
        setContentView(2130903074);
        com.google.android.gms.common.api.i iVar = new com.google.android.gms.common.api.i(this);
        av.a((Object) this, (Object) "Listener must not be null");
        iVar.e.add(this);
        av.a((Object) this, (Object) "Listener must not be null");
        iVar.f.add(this);
        Object obj = com.google.android.gms.plus.d.c;
        av.a(obj, (Object) "Api must not be null");
        iVar.c.put(obj, null);
        obj.a();
        Collection emptyList = Collections.emptyList();
        iVar.b.addAll(emptyList);
        iVar.a.addAll(emptyList);
        obj = new Scope("https://www.googleapis.com/auth/plus.me");
        av.a(obj, (Object) "Scope must not be null");
        iVar.a.add(obj);
        this.f = iVar.b();
        this.h = (AutoCompleteTextView) findViewById(2131624119);
        this.j = (TextView) findViewById(2131624121);
        this.k = (TextView) findViewById(2131624118);
        this.g = (TextView) findViewById(2131624042);
        this.h.setOnEditorActionListener(new bm(this));
        this.i = (Button) findViewById(2131624120);
        this.k.setText(2131165370);
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("android.intent.extra.TITLE")) {
                this.k.setText(getIntent().getStringExtra("android.intent.extra.TITLE").trim());
            }
            if (getIntent().getExtras().containsKey("package_name")) {
                try {
                    this.m = getIntent().getStringExtra("package_name");
                    Drawable applicationIcon = getPackageManager().getApplicationIcon(this.m);
                    int dimension = (int) getResources().getDimension(17104896);
                    applicationIcon.setBounds(0, 0, dimension, dimension);
                    if (BazaarApplication.c().b()) {
                        this.k.setCompoundDrawables(null, null, applicationIcon, null);
                    } else {
                        this.k.setCompoundDrawables(applicationIcon, null, null, null);
                    }
                } catch (Exception e) {
                }
            }
        }
        obj = o.a(true);
        Context c = BazaarApplication.c();
        ArrayList arrayList = new ArrayList();
        for (String str : BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getString("phone_numbers", "").split("\n")) {
            String str2;
            if (!str2.equals("")) {
                arrayList.add(str2);
            }
        }
        Account[] accountsByType = AccountManager.get(c).getAccountsByType("com.viber.voip");
        Account[] accountsByType2 = AccountManager.get(c).getAccountsByType("org.telegram.messenger");
        Account[] accountsByType3 = AccountManager.get(c).getAccountsByType("com.bistalk.bisphone");
        for (Account account : accountsByType) {
            if (!arrayList.contains(account.name) && ax.b(account.name)) {
                arrayList.add(account.name);
            }
        }
        for (Account account2 : accountsByType2) {
            str2 = "+" + account2.name;
            if (!arrayList.contains(str2) && ax.b(str2)) {
                arrayList.add(str2);
            }
        }
        for (Account account3 : accountsByType3) {
            String str3 = "+" + account3.name;
            if (!arrayList.contains(str3) && ax.b(str3)) {
                arrayList.add(str3);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        Object obj2 = new String[(obj.length + strArr.length)];
        System.arraycopy(obj, 0, obj2, 0, obj.length);
        System.arraycopy(strArr, 0, obj2, obj.length, strArr.length);
        this.h.setAdapter(new ArrayAdapter(this, 17367050, obj2));
        if (obj2.length == 1) {
            a = a.a();
            cVar = new c();
            cVar.f = "user";
            cVar.c = "join_dialog";
            cVar.e = "auto_fill";
            a.a(cVar.b("length", Integer.valueOf(1)).b("server", obj2[0].indexOf(64) != -1 ? obj2[0].substring(obj2[0].lastIndexOf(64) + 1) : "phone"));
            this.h.setThreshold(Integer.MAX_VALUE);
            this.h.setText(obj2[0]);
            this.h.setThreshold(0);
            ag.a(this, this.h.getWindowToken());
        } else {
            this.h.setThreshold(0);
        }
        this.i.setOnClickListener(this);
        this.l = new ProgressDialog(this);
        ((ProgressDialog) this.l).setMessage(getString(2131165546));
        this.l.setCancelable(false);
        if (VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(displayMetrics.widthPixels, (int) getResources().getDimension(2131361822)), -2);
        a = a.a();
        cVar = new c();
        cVar.f = "user";
        cVar.c = "join_dialog";
        c a2 = cVar.a("source_pn", this.m);
        a2.e = "dialog_visit";
        a.a(a2.b("predicted", Boolean.valueOf(!TextUtils.isEmpty(this.h.getText().toString()))));
    }

    protected void onStart() {
        super.onStart();
        a.d();
        i.a("/Join");
    }
}
