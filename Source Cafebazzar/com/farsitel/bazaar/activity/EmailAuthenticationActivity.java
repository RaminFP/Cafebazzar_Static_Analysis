package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.farsitel.bazaar.a.o;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.util.a;
import com.farsitel.bazaar.util.c;

public class EmailAuthenticationActivity extends s {
    public static int a = 4;
    private String b;
    private Intent c;
    private PackageManager d;
    private boolean e;
    private boolean f;
    private boolean g;
    private TextView h;
    private EditText i;
    private CheckBox j;
    private TextView k;
    private TextView l;
    private ProgressDialog m;
    private b n = new ay(this);

    public static void a(Activity activity, View view, int i, String str, boolean z, boolean z2, boolean z3) {
        Intent intent = new Intent(activity, EmailAuthenticationActivity.class);
        intent.putExtra("extra_email", str);
        intent.putExtra("extra_had_password", z);
        intent.putExtra("extra_is_new_user", z2);
        intent.putExtra("extra_then_login", z3);
        c.a(activity, intent, i, view);
    }

    private static boolean a(String str) {
        String[] a = o.a(false);
        if (a == null) {
            return false;
        }
        for (Object equals : a) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void g(EmailAuthenticationActivity emailAuthenticationActivity) {
        boolean isChecked = emailAuthenticationActivity.j.isChecked();
        CharSequence text = emailAuthenticationActivity.i.getText();
        if (text == null || TextUtils.isEmpty(text)) {
            emailAuthenticationActivity.i.startAnimation(AnimationUtils.loadAnimation(emailAuthenticationActivity, 2130968637));
            return;
        }
        emailAuthenticationActivity.m.show();
        if (emailAuthenticationActivity.f) {
            String str = emailAuthenticationActivity.b;
            String obj = text.toString();
            new com.farsitel.bazaar.h.a.b(str, obj, isChecked).a(emailAuthenticationActivity.n);
            return;
        }
        a.a(emailAuthenticationActivity.b, text.toString(), emailAuthenticationActivity.n);
    }

    public void onBackPressed() {
        new bf(this, this, 2131165778, 2131165801, 0, 2131165463, true).e.show();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onCreate(android.os.Bundle r12) {
        /*
        r11 = this;
        r5 = 1;
        r9 = 0;
        r4 = 0;
        super.onCreate(r12);
        r0 = 2130903071; // 0x7f03001f float:1.741295E38 double:1.052806002E-314;
        r11.setContentView(r0);
        r0 = com.farsitel.bazaar.BazaarApplication.c();
        r0 = r0.getPackageManager();
        r11.d = r0;
        r0 = r11.getIntent();
        r1 = "extra_email";
        r0 = r0.getStringExtra(r1);
        r11.b = r0;
        r0 = 2131624109; // 0x7f0e00ad float:1.8875388E38 double:1.053162242E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r11.j = r0;
        r0 = 2131624106; // 0x7f0e00aa float:1.8875382E38 double:1.0531622406E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r11.h = r0;
        r1 = r11.h;
        r0 = r11.e;
        if (r0 == 0) goto L_0x01cb;
    L_0x003e:
        r0 = 2131165762; // 0x7f070242 float:1.794575E38 double:1.0529357886E-314;
    L_0x0041:
        r2 = new java.lang.Object[r5];
        r3 = r11.b;
        r2[r4] = r3;
        r0 = r11.getString(r0, r2);
        r1.setText(r0);
        r0 = new android.app.ProgressDialog;
        r0.<init>(r11);
        r11.m = r0;
        r0 = r11.m;
        r1 = 2131165546; // 0x7f07016a float:1.7945312E38 double:1.052935682E-314;
        r1 = r11.getString(r1);
        r0.setMessage(r1);
        r0 = r11.m;
        r0.setCancelable(r4);
        r0 = r11.getIntent();
        r0 = r0.getExtras();
        r1 = "extra_had_password";
        r0 = r0.getBoolean(r1);
        r11.g = r0;
        r0 = r11.getIntent();
        r0 = r0.getExtras();
        r1 = "extra_is_new_user";
        r0 = r0.getBoolean(r1);
        r11.e = r0;
        r0 = r11.getIntent();
        r0 = r0.getExtras();
        r1 = "extra_then_login";
        r0 = r0.getBoolean(r1);
        r11.f = r0;
        r0 = 2131624113; // 0x7f0e00b1 float:1.8875397E38 double:1.053162244E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r11.l = r0;
        r0 = r11.e;
        if (r0 == 0) goto L_0x00cf;
    L_0x00a5:
        r0 = r11.l;
        r1 = 2131165739; // 0x7f07022b float:1.7945704E38 double:1.052935777E-314;
        r1 = r11.getString(r1);
        r1 = android.text.Html.fromHtml(r1);
        r0.setText(r1);
        r0 = r11.l;
        r1 = 15;
        android.text.util.Linkify.addLinks(r0, r1);
        r0 = r11.l;
        r1 = android.text.method.LinkMovementMethod.getInstance();
        r0.setMovementMethod(r1);
        r0 = r11.l;
        r0.requestFocus();
        r0 = r11.l;
        r0.setVisibility(r4);
    L_0x00cf:
        r0 = 2131624112; // 0x7f0e00b0 float:1.8875395E38 double:1.0531622436E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r11.k = r0;
        r0 = r11.k;
        r1 = new com.farsitel.bazaar.activity.az;
        r1.<init>(r11);
        r0.setOnClickListener(r1);
        r0 = r11.g;
        if (r0 == 0) goto L_0x00ed;
    L_0x00e8:
        r0 = r11.k;
        r0.setVisibility(r4);
    L_0x00ed:
        r0 = r11.e;
        if (r0 == 0) goto L_0x00f6;
    L_0x00f1:
        r0 = r11.j;
        r0.setVisibility(r4);
    L_0x00f6:
        r0 = new android.util.DisplayMetrics;
        r0.<init>();
        r1 = r11.getWindowManager();
        r1 = r1.getDefaultDisplay();
        r1.getMetrics(r0);
        r1 = r0.widthPixels;
        r2 = r11.getResources();
        r3 = 2131361822; // 0x7f0a001e float:1.8343407E38 double:1.053032655E-314;
        r2 = r2.getDimension(r3);
        r2 = (int) r2;
        r1 = java.lang.Math.min(r1, r2);
        r2 = com.farsitel.bazaar.util.o.e();
        if (r2 == 0) goto L_0x01d0;
    L_0x011e:
        r0 = r0.heightPixels;
        r2 = r11.getResources();
        r3 = 2131361821; // 0x7f0a001d float:1.8343405E38 double:1.0530326546E-314;
        r2 = r2.getDimension(r3);
        r2 = (int) r2;
        r0 = java.lang.Math.min(r0, r2);
    L_0x0130:
        r2 = r11.getWindow();
        r2.setLayout(r1, r0);
        r0 = 2131624108; // 0x7f0e00ac float:1.8875386E38 double:1.0531622416E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r1 = com.farsitel.bazaar.BazaarApplication.c();
        r2 = r1.getResources();
        r3 = 2130837721; // 0x7f0200d9 float:1.7280404E38 double:1.052773715E-314;
        r2 = r2.getDrawable(r3);
        r1 = r1.getResources();
        r3 = 2131165315; // 0x7f070083 float:1.7944844E38 double:1.0529355677E-314;
        r3 = r1.getString(r3);
        r1 = r11.b;
        r6 = "@";
        r1 = r1.split(r6);
        r6 = r1[r5];
        r11.c = r9;
        r1 = -1;
        r7 = r6.hashCode();
        switch(r7) {
            case -1495636431: goto L_0x01d3;
            case -1311829293: goto L_0x01dd;
            case -827411055: goto L_0x01fd;
            case 329921603: goto L_0x01e7;
            case 1416545663: goto L_0x0208;
            case 2052377642: goto L_0x01f2;
            default: goto L_0x016e;
        };
    L_0x016e:
        switch(r1) {
            case 0: goto L_0x0213;
            case 1: goto L_0x026e;
            case 2: goto L_0x026e;
            case 3: goto L_0x026e;
            case 4: goto L_0x02c8;
            case 5: goto L_0x02db;
            default: goto L_0x0171;
        };
    L_0x0171:
        r1 = r2;
        r2 = r3;
    L_0x0173:
        r3 = r11.c;
        if (r3 == 0) goto L_0x02f3;
    L_0x0177:
        r3 = com.farsitel.bazaar.BazaarApplication.c();
        r3 = r3.b();
        if (r3 == 0) goto L_0x02ee;
    L_0x0181:
        r0.setCompoundDrawablesWithIntrinsicBounds(r9, r9, r1, r9);
    L_0x0184:
        r1 = 2131165485; // 0x7f07012d float:1.7945188E38 double:1.0529356517E-314;
        r3 = new java.lang.Object[r5];
        r3[r4] = r2;
        r1 = r11.getString(r1, r3);
        r0.setText(r1);
        r1 = new com.farsitel.bazaar.activity.bb;
        r1.<init>(r11);
        r0.setOnClickListener(r1);
    L_0x019a:
        r0 = 2131624111; // 0x7f0e00af float:1.8875392E38 double:1.053162243E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r1 = new com.farsitel.bazaar.activity.bc;
        r1.<init>(r11);
        r0.setOnClickListener(r1);
        r0 = 2131624110; // 0x7f0e00ae float:1.887539E38 double:1.0531622426E-314;
        r0 = r11.findViewById(r0);
        r0 = (android.widget.EditText) r0;
        r11.i = r0;
        r0 = r11.i;
        r1 = new com.farsitel.bazaar.activity.bd;
        r1.<init>(r11);
        r0.setOnEditorActionListener(r1);
        r0 = r11.i;
        r1 = new com.farsitel.bazaar.activity.be;
        r1.<init>(r11);
        r0.addTextChangedListener(r1);
        return;
    L_0x01cb:
        r0 = 2131165763; // 0x7f070243 float:1.7945752E38 double:1.052935789E-314;
        goto L_0x0041;
    L_0x01d0:
        r0 = -2;
        goto L_0x0130;
    L_0x01d3:
        r7 = "gmail.com";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x016e;
    L_0x01db:
        r1 = r4;
        goto L_0x016e;
    L_0x01dd:
        r7 = "yahoo.com";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x016e;
    L_0x01e5:
        r1 = r5;
        goto L_0x016e;
    L_0x01e7:
        r7 = "ymail.com";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x016e;
    L_0x01ef:
        r1 = 2;
        goto L_0x016e;
    L_0x01f2:
        r7 = "yahoo.co.uk";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x016e;
    L_0x01fa:
        r1 = 3;
        goto L_0x016e;
    L_0x01fd:
        r7 = "aol.com";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x016e;
    L_0x0205:
        r1 = 4;
        goto L_0x016e;
    L_0x0208:
        r7 = "live.com";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x016e;
    L_0x0210:
        r1 = 5;
        goto L_0x016e;
    L_0x0213:
        r1 = new android.content.Intent;
        r6 = "android.intent.action.VIEW";
        r7 = "http://mail.google.com";
        r7 = android.net.Uri.parse(r7);
        r1.<init>(r6, r7);
        r11.c = r1;
        r1 = com.farsitel.bazaar.util.af.INSTANCE;
        r1 = "com.google.android.gm";
        r1 = com.farsitel.bazaar.util.af.d(r1);
        if (r1 == 0) goto L_0x0171;
    L_0x022c:
        r1 = r11.b;
        r1 = a(r1);
        if (r1 == 0) goto L_0x0171;
    L_0x0234:
        r1 = r11.d;	 Catch:{ NameNotFoundException -> 0x0263 }
        r6 = r11.d;	 Catch:{ NameNotFoundException -> 0x0263 }
        r7 = "com.google.android.gm";
        r8 = 0;
        r6 = r6.getApplicationInfo(r7, r8);	 Catch:{ NameNotFoundException -> 0x0263 }
        r1 = r1.getApplicationLabel(r6);	 Catch:{ NameNotFoundException -> 0x0263 }
        r1 = (java.lang.String) r1;	 Catch:{ NameNotFoundException -> 0x0263 }
        r3 = r11.d;	 Catch:{ NameNotFoundException -> 0x02fa }
        r6 = "com.google.android.gm";
        r2 = r3.getApplicationIcon(r6);	 Catch:{ NameNotFoundException -> 0x02fa }
        r10 = r1;
        r1 = r2;
        r2 = r10;
    L_0x0250:
        r3 = r11.d;
        r6 = "com.google.android.gm";
        r3 = r3.getLaunchIntentForPackage(r6);
        r11.c = r3;
        r3 = r11.c;
        r6 = "android.intent.category.LAUNCHER";
        r3.addCategory(r6);
        goto L_0x0173;
    L_0x0263:
        r1 = move-exception;
        r10 = r1;
        r1 = r3;
        r3 = r10;
    L_0x0267:
        r3.printStackTrace();
        r10 = r1;
        r1 = r2;
        r2 = r10;
        goto L_0x0250;
    L_0x026e:
        r1 = new android.content.Intent;
        r6 = "android.intent.action.VIEW";
        r7 = "http://login.yahoo.com/t?.src=ym&_httpHost=m.yahoo.com";
        r7 = android.net.Uri.parse(r7);
        r1.<init>(r6, r7);
        r11.c = r1;
        r1 = com.farsitel.bazaar.util.af.INSTANCE;
        r1 = "com.yahoo.mobile.client.android.mail";
        r1 = com.farsitel.bazaar.util.af.c(r1);
        if (r1 == 0) goto L_0x0171;
    L_0x0287:
        r1 = r11.b;
        r1 = a(r1);
        if (r1 == 0) goto L_0x0171;
    L_0x028f:
        r1 = r11.d;	 Catch:{ NameNotFoundException -> 0x02fd }
        r6 = r11.d;	 Catch:{ NameNotFoundException -> 0x02fd }
        r7 = "com.yahoo.mobile.client.android.mail";
        r8 = 0;
        r6 = r6.getApplicationInfo(r7, r8);	 Catch:{ NameNotFoundException -> 0x02fd }
        r1 = r1.getApplicationLabel(r6);	 Catch:{ NameNotFoundException -> 0x02fd }
        r1 = (java.lang.String) r1;	 Catch:{ NameNotFoundException -> 0x02fd }
        r3 = r11.d;	 Catch:{ NameNotFoundException -> 0x02be }
        r6 = "com.yahoo.mobile.client.android.mail";
        r2 = r3.getApplicationIcon(r6);	 Catch:{ NameNotFoundException -> 0x02be }
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x02ab:
        r3 = r11.d;
        r6 = "com.yahoo.mobile.client.android.mail";
        r3 = r3.getLaunchIntentForPackage(r6);
        r11.c = r3;
        r3 = r11.c;
        r6 = "android.intent.category.LAUNCHER";
        r3.addCategory(r6);
        goto L_0x0173;
    L_0x02be:
        r3 = move-exception;
        r10 = r3;
        r3 = r1;
        r1 = r10;
    L_0x02c2:
        r1.printStackTrace();
        r1 = r2;
        r2 = r3;
        goto L_0x02ab;
    L_0x02c8:
        r1 = new android.content.Intent;
        r6 = "android.intent.action.VIEW";
        r7 = "http://mail.aol.com";
        r7 = android.net.Uri.parse(r7);
        r1.<init>(r6, r7);
        r11.c = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0173;
    L_0x02db:
        r1 = new android.content.Intent;
        r6 = "android.intent.action.VIEW";
        r7 = "http://mail.live.com";
        r7 = android.net.Uri.parse(r7);
        r1.<init>(r6, r7);
        r11.c = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0173;
    L_0x02ee:
        r0.setCompoundDrawablesWithIntrinsicBounds(r1, r9, r9, r9);
        goto L_0x0184;
    L_0x02f3:
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x019a;
    L_0x02fa:
        r3 = move-exception;
        goto L_0x0267;
    L_0x02fd:
        r1 = move-exception;
        goto L_0x02c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.activity.EmailAuthenticationActivity.onCreate(android.os.Bundle):void");
    }
}
