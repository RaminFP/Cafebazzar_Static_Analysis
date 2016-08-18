package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.a.g;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.a.a;
import com.a.a.a.ac;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.b.ab;
import com.farsitel.bazaar.database.m;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.g.l;
import com.farsitel.bazaar.h.b.aw;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.q;
import java.util.Iterator;

public class ReviewActivity extends s implements OnRatingBarChangeListener {
    private String a;
    private String b;
    private int c = 0;
    private RatingBar d;
    private EditText e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private View i;
    private ImageView j;
    private RelativeLayout k;
    private TextView l;
    private boolean m;

    public static void a() {
        Iterator it = m.a().b().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            l a = m.a().a(str);
            if (a != null) {
                boolean z = (a.c.trim() == null || a.c.trim().equals("")) ? false : true;
                d.INSTANCE.a(new cf(str, z, false), new aw(), j.a().b, str, Integer.valueOf(a.b), a.c.trim(), Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(a.d));
                a.c().a(new ac().a(str).a(a.b).b("sending offline"));
            }
        }
    }

    public static void a(Activity activity, int i, String str) {
        af afVar = af.INSTANCE;
        if (af.c(str)) {
            Intent intent = new Intent(activity, ReviewActivity.class);
            intent.putExtra("extra_package_name", str);
            activity.startActivityForResult(intent, 40005);
            return;
        }
        Toast.makeText(activity, 2131165410, 0).show();
    }

    public static void a(Context context, String str) {
        af afVar = af.INSTANCE;
        if (af.c(str)) {
            Intent intent = new Intent(context, ReviewActivity.class);
            intent.putExtra("extra_package_name", str);
            intent.putExtra("extra_is_third_party_app", true);
            context.startActivity(intent);
            return;
        }
        Toast.makeText(context, 2131165410, 0).show();
    }

    static /* synthetic */ void b(ReviewActivity reviewActivity) {
        if (reviewActivity.c == 0) {
            reviewActivity.d.startAnimation(AnimationUtils.loadAnimation(reviewActivity, 2130968637));
            return;
        }
        int i;
        String obj = reviewActivity.e.getText() != null ? reviewActivity.e.getText().toString() : "";
        try {
            i = reviewActivity.getApplicationContext().getPackageManager().getPackageInfo(reviewActivity.a, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            i = 0;
        }
        boolean e2 = q.e();
        m.a().a(new l(reviewActivity.a, reviewActivity.c, obj.trim(), i));
        boolean z = (reviewActivity.e.getText() == null || reviewActivity.e.getText().toString().equals("")) ? false : true;
        if (e2) {
            com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
            c cVar = new c();
            cVar.c = "review_act";
            cVar.e = "review";
            a.a(cVar.b("is_3rdparty", Boolean.valueOf(reviewActivity.m)).b("rate", Integer.valueOf(reviewActivity.c)));
            d.INSTANCE.a(new cf(reviewActivity.a, z, true), new aw(), j.a().b, reviewActivity.a, Integer.valueOf(reviewActivity.c), obj.trim(), Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i));
            a.c().a(new ac().a(reviewActivity.a).a(reviewActivity.c).b("review page"));
            Intent intent = new Intent();
            intent.putExtra("app_rate", reviewActivity.c);
            reviewActivity.setResult(-1, intent);
        } else {
            Toast.makeText(BazaarApplication.c(), 2131165665, 1).show();
        }
        reviewActivity.finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 40002:
                if (i2 != -1) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903105);
        if (VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.d = (RatingBar) findViewById(2131624225);
        this.g = (ImageView) findViewById(2131624270);
        this.h = (ImageView) findViewById(2131624269);
        this.j = (ImageView) findViewById(2131624268);
        this.l = (TextView) findViewById(2131624257);
        this.k = (RelativeLayout) findViewById(g.action_bar);
        this.i = findViewById(2131624265);
        this.a = getIntent().getExtras().getString("extra_package_name");
        l a = m.a().a(this.a);
        this.c = a != null ? a.b : 0;
        this.b = a != null ? a.c : "";
        this.m = getIntent().getExtras().getBoolean("extra_is_third_party_app", false);
        this.d.setRating((float) this.c);
        this.e = (EditText) findViewById(2131624266);
        this.f = (TextView) findViewById(2131624198);
        this.f.setText("140");
        String str = this.m ? "device_locale" : "bazaar_locale";
        af afVar = af.INSTANCE;
        com.farsitel.bazaar.g.d a2 = af.a(this.a, str);
        if (a2 == null) {
            Toast.makeText(this, getString(2131165704, new Object[]{Integer.valueOf(2404)}), 0).show();
            finish();
            return;
        }
        EditText editText = this.e;
        str = a2 != null ? a2.b : "";
        editText.setHint(getString(2131165798, new Object[]{str}));
        if (!(this.b == null || this.b.equals(""))) {
            this.e.setText(this.b);
            findViewById(2131624267).setVisibility(0);
        }
        this.e.addTextChangedListener(new cb(this));
        this.d.setOnRatingBarChangeListener(this);
        findViewById(2131624432).setOnClickListener(new cc(this));
        if (this.m) {
            this.k.setVisibility(0);
            this.i.setVisibility(0);
            this.h.setVisibility(0);
            af afVar2 = af.INSTANCE;
            a2 = af.b(this.a);
            if (a2 != null) {
                this.g.setImageDrawable(a2.a().a());
                this.g.setVisibility(0);
            }
            this.j.setOnClickListener(new cd(this));
        }
        j a3 = j.a();
        if (!a3.n()) {
            Intent intent = new Intent(this, JoinActivity.class);
            intent.putExtra("extra_referer", "review");
            intent.putExtra("android.intent.extra.TITLE", getString(2131165597));
            startActivityForResult(intent, 40002);
        } else if (a3.k() == null || TextUtils.isEmpty(a3.k())) {
            com.farsitel.bazaar.b.m abVar = new ab(this);
            abVar.g = new ce(this, a3);
            abVar.e.show();
        } else {
            this.l.setText(a3.k());
            BazaarApplication.c().d();
            i.a("/WriteReview/" + this.a);
            com.farsitel.bazaar.g.a a4 = com.farsitel.bazaar.g.a.a();
            c cVar = new c();
            cVar.c = "review_act";
            cVar.e = "start_act";
            a4.a(cVar.b("is_3rdparty", Boolean.valueOf(this.m)));
        }
    }

    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        this.c = (int) f;
    }
}
