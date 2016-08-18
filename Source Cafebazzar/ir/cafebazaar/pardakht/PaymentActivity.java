package ir.cafebazaar.pardakht;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.a.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.a.a.a.aa;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.ai;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.activity.s;
import com.farsitel.bazaar.b.ag;
import com.farsitel.bazaar.b.an;
import com.farsitel.bazaar.b.bj;
import com.farsitel.bazaar.b.k;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.b.z;
import com.farsitel.bazaar.database.f;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ac;
import com.farsitel.bazaar.h.b.o;
import com.farsitel.bazaar.h.b.r;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.aj;
import com.farsitel.bazaar.util.p;
import com.farsitel.bazaar.util.q;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity extends s implements OnClickListener {
    public static final BazaarApplication a = BazaarApplication.c();
    public Intent b;
    public an c;
    public ag d;
    public boolean e = false;
    private View f;
    private View g;
    private int h = -1;
    private Context i;
    private PaymentActivity j;
    private af k;
    private ae l;
    private ah m;
    private h n;
    private TextView o;
    private TextView p;
    private ProgressDialog q;

    static /* synthetic */ Intent a(PaymentActivity paymentActivity, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.putExtra("INAPP_PURCHASE_DATA", jSONObject.getString("json"));
        intent.putExtra("INAPP_DATA_SIGNATURE", jSONObject.getString("sign"));
        if (jSONObject.has("json") && jSONObject.has("sign")) {
            intent.putExtra("RESPONSE_CODE", 0);
        }
        return intent;
    }

    private void a(int i, Intent intent) {
        setResult(i, intent);
        if (i == -1) {
            new f().execute(new Void[0]);
        }
        finish();
    }

    private void a(int i, boolean z) {
        a.d();
        i.a("/Pay/ValidationFail/" + getCallingPackage() + "/" + i);
        new ag((Activity) this, i, z).e.show();
    }

    static /* synthetic */ void a(PaymentActivity paymentActivity, String str, String str2) {
        Intent intent = new Intent(paymentActivity.j, AuthenticateActivity.class);
        intent.putExtra("request_type", str);
        intent.putExtra("authenticate_message", str2);
        paymentActivity.startActivityForResult(intent, 40007);
    }

    private void a(String str) {
        Intent intent = new Intent(this.j, AuthenticateActivity.class);
        intent.putExtra("request_type", str);
        startActivityForResult(intent, 40007);
    }

    private void a(String str, String str2) {
        Intent intent = new Intent(this.j, AuthenticateActivity.class);
        intent.putExtra("request_type", str);
        intent.putExtra("android.intent.extra.TITLE", str2);
        startActivityForResult(intent, 40007);
    }

    private void a(String str, boolean z) {
        new ag((Activity) this, str, z).e.show();
    }

    private static boolean a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                ai aiVar = new ai(jSONArray.getJSONObject(i));
                if (aiVar.f.equals("credit") && aiVar.a) {
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private String b(String str) {
        CharSequence applicationLabel;
        PackageManager packageManager = getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(str, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        if (applicationInfo != null) {
            applicationLabel = packageManager.getApplicationLabel(applicationInfo);
        } else {
            Object obj = str;
        }
        return (String) applicationLabel;
    }

    static /* synthetic */ void b(PaymentActivity paymentActivity, JSONObject jSONObject) {
        j.a().a(jSONObject.getLong("credit"));
        if (paymentActivity.h == 2) {
            paymentActivity.d();
            paymentActivity.e();
            ListView listView = (ListView) paymentActivity.g.findViewById(2131624261);
            listView.setAdapter(new com.farsitel.bazaar.a.ag(jSONObject.getJSONArray("options"), paymentActivity.j, paymentActivity.h, jSONObject.has("nonce") ? jSONObject.getString("nonce") : ""));
            View inflate = LayoutInflater.from(paymentActivity).inflate(2130903161, null);
            inflate.setOnClickListener(paymentActivity);
            listView.addFooterView(inflate);
            paymentActivity.g.setVisibility(0);
            return;
        }
        paymentActivity.d.a(jSONObject.getString("title"), jSONObject.getLong("price"), jSONObject.getString("kind").charAt(0));
        int i = (paymentActivity.d.f > j.a().c() || !a(jSONObject.getJSONArray("options"))) ? 0 : 1;
        paymentActivity.h = i;
        if (paymentActivity.h == 1) {
            a.d();
            i.a("/Pay/Buy/OneClick/");
        } else if (paymentActivity.h == 0) {
            a.d();
            i.a("/Pay/Buy/Checkout/");
        }
        m akVar;
        switch (paymentActivity.h) {
            case 0:
                if (paymentActivity.a()) {
                    akVar = new ak(paymentActivity, paymentActivity.d.g, paymentActivity.d.f);
                    akVar.g = new ac(paymentActivity);
                    akVar.e.show();
                }
                paymentActivity.d();
                paymentActivity.e();
                listView = (ListView) paymentActivity.g.findViewById(2131624261);
                listView.setAdapter(new com.farsitel.bazaar.a.ag(jSONObject.getJSONArray("options"), paymentActivity.j, paymentActivity.h, jSONObject.has("nonce") ? jSONObject.getString("nonce") : ""));
                inflate = LayoutInflater.from(paymentActivity).inflate(2130903161, null);
                inflate.setOnClickListener(paymentActivity);
                listView.addFooterView(inflate);
                paymentActivity.g.setVisibility(0);
                return;
            case 1:
                if (a.getPackageName().equals(paymentActivity.d.a)) {
                    if (ab.a()) {
                        paymentActivity.a("buy_with_credit", paymentActivity.getString(2131165694, new Object[]{paymentActivity.d.e, aj.a(paymentActivity.d.f)}));
                        return;
                    }
                    akVar = new k(paymentActivity.j, paymentActivity.d.e, paymentActivity.d.f);
                    akVar.g = new ai(paymentActivity, (byte) 0);
                    akVar.e.show();
                    return;
                } else if (paymentActivity.d.g == 'P') {
                    if (ab.a()) {
                        paymentActivity.a("buy_with_credit", paymentActivity.getString(2131165695, new Object[]{paymentActivity.d.e, paymentActivity.b(paymentActivity.d.a), aj.a(paymentActivity.d.f)}));
                        return;
                    }
                    m zVar = new z(paymentActivity.j, paymentActivity.d.a, paymentActivity.b(paymentActivity.d.a), paymentActivity.d.e, paymentActivity.d.f);
                    zVar.g = new ai(paymentActivity, (byte) 0);
                    zVar.e.show();
                    return;
                } else if (paymentActivity.d.g != 'A' && paymentActivity.d.g != 'M') {
                    return;
                } else {
                    if (ab.a()) {
                        paymentActivity.a("buy_with_credit", paymentActivity.getString(2131165696, new Object[]{paymentActivity.d.e, paymentActivity.b(paymentActivity.d.a), aj.a(paymentActivity.d.f)}));
                        return;
                    }
                    akVar = new bj(paymentActivity.j, paymentActivity.d.a, paymentActivity.b(paymentActivity.d.a), paymentActivity.d.e, paymentActivity.d.g, paymentActivity.d.f);
                    akVar.g = new ai(paymentActivity, (byte) 0);
                    akVar.e.show();
                    return;
                }
            default:
                return;
        }
    }

    private void c() {
        Object obj;
        a a;
        c cVar;
        long c;
        ag agVar = null;
        this.b = new Intent();
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 1);
        setResult(0, intent);
        Intent intent2 = getIntent();
        Uri data = intent2.getData();
        String packageName = VERSION.SDK_INT < 18 ? getCallingActivity() != null ? getCallingActivity().getPackageName() : getPackageName() : getCallingPackage();
        if (data != null) {
            List pathSegments = data.getPathSegments();
            if (!"pardakht".equals(data.getHost()) || pathSegments.size() < 2) {
                a(2131165495, false);
                this.d = agVar;
                obj = "";
                switch (this.h) {
                    case -1:
                        obj = "unknown";
                        break;
                    case 0:
                        obj = "not_enough_credit";
                        break;
                    case 1:
                        obj = "has_enough_credit";
                        break;
                    case 2:
                        obj = "buy_credit";
                        break;
                }
                if (this.d != null) {
                    a = a.a();
                    cVar = new c();
                    cVar.c = "payment_act";
                    cVar.e = "start_act";
                    a.a(cVar.b("mode", obj).b("kind", Character.valueOf(this.d.g)).b("price", Long.valueOf(this.d.f)));
                }
                switch (this.h) {
                    case -1:
                        if (this.d != null) {
                            this.k = new af();
                            d.INSTANCE.a(this.k, new r(), a.a.getLanguage(), this.d.a, this.d.b, j.a().d(), p.a(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), Integer.valueOf(q.c()), Integer.valueOf(q.d()));
                            return;
                        }
                        a(2131165495, false);
                        return;
                    case 2:
                        c = this.d.f - j.a().c();
                        if (c <= 0) {
                            c = 0;
                        }
                        this.l = new ae(this, c);
                        d.INSTANCE.a(this.l, new o(), a.a.getLanguage());
                        return;
                    default:
                        a(getString(2131165704, new Object[]{Integer.valueOf(601)}), false);
                        this.q.dismiss();
                        return;
                }
            }
            if (!"v1".equals(pathSegments.get(0))) {
                a(2131165496, true);
            } else if ("pay".equals(pathSegments.get(1))) {
                if (packageName == null) {
                    a(2131165494, true);
                } else {
                    String stringExtra = intent2.getStringExtra("PARDAKHT_PACKAGE_NAME");
                    if (packageName.equals(stringExtra) || packageName.equals("com.farsitel.bazaar")) {
                        packageName = intent2.getStringExtra("PARDAKHT_SKU");
                        String stringExtra2 = intent2.getStringExtra("PARDAKHT_DEV_PAYLOAD");
                        String stringExtra3 = intent2.getStringExtra("PARDAKHT_NAME");
                        int intExtra = intent2.getIntExtra("PACKAGE_ID", 0);
                        long longExtra = intent2.getLongExtra("PARDAKHT_PRICE", 0);
                        this.b.putExtras(intent2);
                        agVar = new ag(stringExtra, packageName, (long) intExtra, stringExtra3, longExtra, stringExtra2);
                        this.h = -1;
                    } else {
                        a(2131165493, true);
                    }
                }
            } else if ("buy_credit".equals(pathSegments.get(1))) {
                this.h = 2;
                this.b.putExtras(intent2);
                agVar = new ag(intent2.getLongExtra("PARDAKHT_PRICE", 0));
            }
            this.d = agVar;
            obj = "";
            switch (this.h) {
                case -1:
                    obj = "unknown";
                    break;
                case 0:
                    obj = "not_enough_credit";
                    break;
                case 1:
                    obj = "has_enough_credit";
                    break;
                case 2:
                    obj = "buy_credit";
                    break;
            }
            if (this.d != null) {
                a = a.a();
                cVar = new c();
                cVar.c = "payment_act";
                cVar.e = "start_act";
                a.a(cVar.b("mode", obj).b("kind", Character.valueOf(this.d.g)).b("price", Long.valueOf(this.d.f)));
            }
            switch (this.h) {
                case -1:
                    if (this.d != null) {
                        a(2131165495, false);
                        return;
                    }
                    this.k = new af();
                    d.INSTANCE.a(this.k, new r(), a.a.getLanguage(), this.d.a, this.d.b, j.a().d(), p.a(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), Integer.valueOf(q.c()), Integer.valueOf(q.d()));
                    return;
                case 2:
                    c = this.d.f - j.a().c();
                    if (c <= 0) {
                        c = 0;
                    }
                    this.l = new ae(this, c);
                    d.INSTANCE.a(this.l, new o(), a.a.getLanguage());
                    return;
                default:
                    a(getString(2131165704, new Object[]{Integer.valueOf(601)}), false);
                    this.q.dismiss();
                    return;
            }
        }
        a(2131165495, false);
        this.d = agVar;
        obj = "";
        switch (this.h) {
            case -1:
                obj = "unknown";
                break;
            case 0:
                obj = "not_enough_credit";
                break;
            case 1:
                obj = "has_enough_credit";
                break;
            case 2:
                obj = "buy_credit";
                break;
        }
        if (this.d != null) {
            a = a.a();
            cVar = new c();
            cVar.c = "payment_act";
            cVar.e = "start_act";
            a.a(cVar.b("mode", obj).b("kind", Character.valueOf(this.d.g)).b("price", Long.valueOf(this.d.f)));
        }
        switch (this.h) {
            case -1:
                if (this.d != null) {
                    this.k = new af();
                    d.INSTANCE.a(this.k, new r(), a.a.getLanguage(), this.d.a, this.d.b, j.a().d(), p.a(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), Integer.valueOf(q.c()), Integer.valueOf(q.d()));
                    return;
                }
                a(2131165495, false);
                return;
            case 2:
                c = this.d.f - j.a().c();
                if (c <= 0) {
                    c = 0;
                }
                this.l = new ae(this, c);
                d.INSTANCE.a(this.l, new o(), a.a.getLanguage());
                return;
            default:
                a(getString(2131165704, new Object[]{Integer.valueOf(601)}), false);
                this.q.dismiss();
                return;
        }
    }

    private void d() {
        Drawable loadIcon;
        setContentView(2130903078);
        this.p = (TextView) findViewById(2131624384);
        this.o = (TextView) findViewById(g.title);
        this.f = findViewById(2131624142);
        this.g = findViewById(2131624143);
        this.n = new h(this.f, this.i);
        String str = (!getPackageName().equals(this.d.a) || this.h == 2) ? this.d.a : this.d.b;
        af afVar = af.INSTANCE;
        if (af.c(str)) {
            try {
                loadIcon = BazaarApplication.c().getPackageManager().getPackageInfo(str, 0).applicationInfo.loadIcon(BazaarApplication.c().getApplicationContext().getPackageManager());
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            if (loadIcon == null) {
                this.n.a(loadIcon);
            } else {
                this.n.a(new com.farsitel.bazaar.g.a.j(str).j());
            }
        }
        loadIcon = null;
        if (loadIcon == null) {
            this.n.a(new com.farsitel.bazaar.g.a.j(str).j());
        } else {
            this.n.a(loadIcon);
        }
    }

    private void e() {
        this.p.setText(aj.a(this.d.f, this.d.g));
        this.o.setText(this.d.e);
        this.n.a(Character.valueOf(this.d.g));
        this.n.a(!this.d.a.equals(BazaarApplication.c().getPackageName()));
    }

    public final boolean a() {
        return this.d.g == 'M' || this.d.g == 'A';
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 40001:
                if (!this.d.a.equals("com.farsitel.bazaar")) {
                    com.a.a.a.a.c().a(new aa().a(true).a(this.d.a).b("in-app purchase").a(Currency.getInstance(new Locale("fa", "ir"))).a(new BigDecimal(this.d.f)));
                } else if (this.d.b != null) {
                    com.a.a.a.a.c().a(new aa().a(true).a(this.d.b).b("app purchase").a(Currency.getInstance(new Locale("fa", "ir"))).a(new BigDecimal(this.d.f)));
                } else {
                    com.a.a.a.a.c().a(new aa().a(true).a(this.d.f + " credit").b("credit purchase").a(Currency.getInstance(new Locale("fa", "ir"))).a(new BigDecimal(this.d.f)));
                }
                a(i2, intent);
                return;
            case 40003:
                if (i2 == -1) {
                    c();
                    return;
                } else {
                    finish();
                    return;
                }
            case 40006:
                if (i2 == -1) {
                    a("increase_&_buy");
                    return;
                }
                return;
            case 40007:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("user_password");
                    boolean booleanExtra = intent.getBooleanExtra("password_asked", true);
                    if (!(booleanExtra || ab.c() == null)) {
                        stringExtra = ab.c();
                    }
                    this.m = new ah(this, booleanExtra, stringExtra);
                    d.INSTANCE.a(this.m, new ac(), a.a.getLanguage(), j.a().d(), stringExtra, this.d.a, this.d.b, Long.valueOf(this.d.d), this.d.c);
                    return;
                }
                finish();
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        a.d();
        i.a("/Pay/Cancel/");
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131624389:
                Intent intent = new Intent();
                intent.setData(Uri.parse("bazaar://webview?title=" + getString(2131165534) + "&url" + "=http://cafebazaar.ir/client/payment/?l=" + (BazaarApplication.c().b() ? "fa" : "en")));
                com.farsitel.bazaar.util.c.a(this, intent, view);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = getApplicationContext();
        this.j = this;
        this.q = new ProgressDialog(this);
        this.q.setMessage(getString(2131165546));
        this.q.setCancelable(false);
        if (j.a().n()) {
            this.q.show();
            c();
            return;
        }
        Intent intent = new Intent(this, JoinActivity.class);
        intent.putExtra("android.intent.extra.TITLE", getString(2131165497));
        try {
            if (!getCallingPackage().equals(getPackageName())) {
                intent.putExtra("package_name", getCallingPackage());
                intent.putExtra("extra_referer", "payment");
                ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getCallingPackage(), NotificationCompat.FLAG_HIGH_PRIORITY);
                Resources resourcesForApplication = BazaarApplication.c().getPackageManager().getResourcesForApplication(applicationInfo);
                Configuration configuration = new Configuration();
                configuration.locale = BazaarApplication.c().getResources().getConfiguration().locale;
                resourcesForApplication.updateConfiguration(configuration, BazaarApplication.c().getResources().getDisplayMetrics());
                if (applicationInfo.labelRes != 0) {
                    intent.putExtra("android.intent.extra.TITLE", getString(2131165286, new Object[]{resourcesForApplication.getString(applicationInfo.labelRes)}));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivityForResult(intent, 40003);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.m != null) {
            this.m.b();
        }
        if (this.l != null) {
            this.l.b();
        }
        if (this.k != null) {
            this.k.b();
        }
    }
}
