package ir.cafebazaar.pardakht;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.congenialmobile.util.g;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.t;
import com.farsitel.bazaar.b.ag;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.h;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.o;
import com.farsitel.bazaar.util.p;
import com.farsitel.bazaar.widget.b;
import ir.cafebazaar.pardakht.a.e;
import java.io.ByteArrayInputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PardakhtActivity extends t {
    private static final BazaarApplication f = BazaarApplication.c();
    private static final String[] g = new String[]{"1", "2", "3", "zeerak", "4"};
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
    SslCertificate e;
    private e h = null;
    private ArrayList i = null;
    private WebView j;
    private View k;
    private boolean l = false;
    private z m;

    private void a(int i, boolean z) {
        f.d();
        i.a("/Pay-web/ValidationFail/" + getCallingPackage() + "/" + i);
        new ag((Activity) this, i, z).e.show();
    }

    private void a(KeyStore keyStore) {
        for (String str : g) {
            try {
                this.i.add((X509Certificate) keyStore.getCertificate(str));
            } catch (GeneralSecurityException e) {
                Log.e("Bazaar-Payment-Web", str + "CAPublicKey :: GeneralSecurityException");
            }
        }
    }

    private boolean a(SslError sslError) {
        if (this.i == null || this.i.isEmpty()) {
            Log.w("Bazaar-Payment-Web", "isPageCertified :: null/empty trustedCerts! (" + this.i + ")");
        }
        byte[] byteArray = SslCertificate.saveState(sslError.getCertificate()).getByteArray("x509-certificate");
        if (byteArray != null) {
            X509Certificate x509Certificate;
            try {
                x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e) {
                x509Certificate = null;
            }
            if (x509Certificate != null) {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    try {
                        x509Certificate.verify(((X509Certificate) it.next()).getPublicKey());
                        return true;
                    } catch (GeneralSecurityException e2) {
                    }
                }
            }
        } else if (VERSION.SDK_INT < 14) {
            return true;
        }
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        if (this.i == null || this.i.isEmpty()) {
            KeyStore a;
            this.i = new ArrayList();
            try {
                a = g.a(f);
            } catch (GeneralSecurityException e) {
                Log.e("Bazaar-Payment-Web", "zeerakCAPublicKey :: GeneralSecurityException");
                a = null;
            }
            if (a != null) {
                a(a);
            }
        }
        this.j = (WebView) findViewById(2131624374);
        this.j.setDrawingCacheEnabled(true);
        WebSettings settings = this.j.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        this.j.setWebViewClient(new q(this));
        findViewById(2131624377).setOnClickListener(new r(this));
        this.j.setOnTouchListener(new s(this));
        this.j.addJavascriptInterface(new x(), "Bazaar");
        f.d();
        i.a("/Pay-web/Start/");
    }

    static /* synthetic */ void d(PardakhtActivity pardakhtActivity) {
        if (pardakhtActivity.m != null || pardakhtActivity.m.d != null) {
            d.INSTANCE.a(new w(pardakhtActivity), new h(), pardakhtActivity.m.d, j.a().d());
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 101) {
            this.j.loadUrl("javascript:startCheckLoop()");
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.l) {
            m yVar = new y(this);
            yVar.g = new v(this);
            yVar.e.show();
            return;
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.h == null) {
            this.h = new e(getApplicationContext());
        }
        if (j.a().n()) {
            String stringExtra;
            z zVar;
            DisplayMetrics displayMetrics;
            boolean z;
            InputMethodManager inputMethodManager;
            boolean z2;
            WebView webView;
            z zVar2;
            String g;
            String d;
            String stringExtra2;
            String str;
            long longExtra;
            String str2;
            Intent intent = new Intent();
            intent.putExtra("RESPONSE_CODE", 1);
            setResult(0, intent);
            Intent intent2 = getIntent();
            Uri data = intent2.getData();
            String packageName = VERSION.SDK_INT < 18 ? getCallingActivity() != null ? getCallingActivity().getPackageName() : getPackageName() : getCallingPackage();
            if (data == null) {
                a(2131165495, false);
            } else {
                List pathSegments = data.getPathSegments();
                if (!"pardakht".equals(data.getHost()) || pathSegments.size() < 2) {
                    a(2131165495, false);
                } else if (!"v1".equals(pathSegments.get(0))) {
                    a(2131165496, true);
                } else if ("pay".equals(pathSegments.get(1))) {
                    if (packageName == null) {
                        a(2131165494, true);
                    } else {
                        stringExtra = intent2.getStringExtra("PARDAKHT_PACKAGE_NAME");
                        if (packageName.equals(getPackageName())) {
                            zVar = new z(this, stringExtra, intent2.getStringExtra("PARDAKHT_SKU"), intent2.getStringExtra("PARDAKHT_DEV_PAYLOAD"));
                            this.m = zVar;
                            if (this.m != null) {
                                setContentView(2130903151);
                                if (o.e()) {
                                    displayMetrics = new DisplayMetrics();
                                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                                    getWindow().setLayout(Math.min(displayMetrics.widthPixels, (int) getResources().getDimension(2131361822)), Math.min(displayMetrics.heightPixels, (int) getResources().getDimension(2131361821)));
                                }
                                if (BazaarApplication.c().b()) {
                                    findViewById(2131624367).setVisibility(0);
                                } else {
                                    findViewById(2131624368).setVisibility(0);
                                }
                                this.l = true;
                                z = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getBoolean("show_payment_input_warning", true);
                                if (VERSION.SDK_INT >= 11) {
                                    inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService("input_method");
                                    if (!(inputMethodManager == null || inputMethodManager.getCurrentInputMethodSubtype() == null || !inputMethodManager.getCurrentInputMethodSubtype().getLocale().equals("fa"))) {
                                        new b((Activity) this, Integer.valueOf(2131165524), Integer.valueOf(com.farsitel.bazaar.g.ic_crouton_keyboard), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.a, true, new p(this, inputMethodManager)).a();
                                        z2 = false;
                                        if (z2) {
                                            new b((Activity) this, Integer.valueOf(2131165525), Integer.valueOf(com.farsitel.bazaar.g.ic_action_close), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.b, false, null).a();
                                        }
                                        b();
                                        this.k = findViewById(2131624375);
                                        webView = this.j;
                                        zVar2 = this.m;
                                        g = j.a().g();
                                        d = j.a().d();
                                        stringExtra2 = zVar2.e.getIntent().getStringExtra("PARDAKHT_METHOD");
                                        stringExtra = p.a().replace('\\', '|').replace('\"', '|');
                                        packageName = "sans-serif";
                                        if ("en".equals(f.a.getLanguage())) {
                                            packageName = "monospace";
                                        }
                                        str = "";
                                        if (zVar2.b != null) {
                                            longExtra = zVar2.e.getIntent().getLongExtra("PARDAKHT_CREDIT_AMOUNT", 0);
                                            str2 = f.BUY_CREDIT.g + "proceed/?l=" + f.a.getLanguage();
                                            stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='amount' value='" + longExtra + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n";
                                        } else {
                                            str2 = f.PAYMENT_WEB.g + "proceed/?l=" + f.a.getLanguage();
                                            stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='sku' value='" + zVar2.b + "' />\n<input type='hidden' name='device_id' value='" + stringExtra + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n";
                                            if (zVar2.e.getIntent().getBooleanExtra("SHOULD_AGREE", false)) {
                                                str = "<input type='hidden' name='accept' value='" + zVar2.e.getIntent().getBooleanExtra("USER_AGREED", false) + "' />\n";
                                            }
                                        }
                                        webView.loadData("<!doctype html><html><head><meta charset=\"utf-8\" />\n<title>Loading</title>\n<style>\nbody {color: #9E4957; font-family: " + packageName + "; text-align: center; font-size: 1.6em; padding: 1em 0.5em 0.5em;}\n</style></head>\n" + "<body>\n" + BazaarApplication.c().getString(2131165505) + "\n<form id='pardakht' action='" + str2 + "' method='post'>\n<input type='hidden' name='account' value='" + g + "' />\n<input type='hidden' name='user_id' value='" + d + "' />\n" + stringExtra + str + "<input type='hidden' name='on_finish' value='bazaar-v1' />\n<input type='hidden' name='no_header' value='1' />\n" + "<input type='hidden' name='method' value='" + stringExtra2 + "' />\n<input type='hidden' name='bazaar_version' value='" + (k.b() >= 10000 ? 40601 : k.b()) + "' />\n</form>\n" + "<script>document.forms.pardakht.submit();</script>\n</body></html>\n", "text/html; charset=utf-8", "utf-8");
                                    }
                                }
                                z2 = z;
                                if (z2) {
                                    new b((Activity) this, Integer.valueOf(2131165525), Integer.valueOf(com.farsitel.bazaar.g.ic_action_close), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.b, false, null).a();
                                }
                                b();
                                this.k = findViewById(2131624375);
                                webView = this.j;
                                zVar2 = this.m;
                                g = j.a().g();
                                d = j.a().d();
                                stringExtra2 = zVar2.e.getIntent().getStringExtra("PARDAKHT_METHOD");
                                stringExtra = p.a().replace('\\', '|').replace('\"', '|');
                                packageName = "sans-serif";
                                if ("en".equals(f.a.getLanguage())) {
                                    packageName = "monospace";
                                }
                                str = "";
                                if (zVar2.b != null) {
                                    str2 = f.PAYMENT_WEB.g + "proceed/?l=" + f.a.getLanguage();
                                    stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='sku' value='" + zVar2.b + "' />\n<input type='hidden' name='device_id' value='" + stringExtra + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n";
                                    if (zVar2.e.getIntent().getBooleanExtra("SHOULD_AGREE", false)) {
                                        str = "<input type='hidden' name='accept' value='" + zVar2.e.getIntent().getBooleanExtra("USER_AGREED", false) + "' />\n";
                                    }
                                } else {
                                    longExtra = zVar2.e.getIntent().getLongExtra("PARDAKHT_CREDIT_AMOUNT", 0);
                                    str2 = f.BUY_CREDIT.g + "proceed/?l=" + f.a.getLanguage();
                                    stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='amount' value='" + longExtra + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n";
                                }
                                if (k.b() >= 10000) {
                                }
                                webView.loadData("<!doctype html><html><head><meta charset=\"utf-8\" />\n<title>Loading</title>\n<style>\nbody {color: #9E4957; font-family: " + packageName + "; text-align: center; font-size: 1.6em; padding: 1em 0.5em 0.5em;}\n</style></head>\n" + "<body>\n" + BazaarApplication.c().getString(2131165505) + "\n<form id='pardakht' action='" + str2 + "' method='post'>\n<input type='hidden' name='account' value='" + g + "' />\n<input type='hidden' name='user_id' value='" + d + "' />\n" + stringExtra + str + "<input type='hidden' name='on_finish' value='bazaar-v1' />\n<input type='hidden' name='no_header' value='1' />\n" + "<input type='hidden' name='method' value='" + stringExtra2 + "' />\n<input type='hidden' name='bazaar_version' value='" + (k.b() >= 10000 ? 40601 : k.b()) + "' />\n</form>\n" + "<script>document.forms.pardakht.submit();</script>\n</body></html>\n", "text/html; charset=utf-8", "utf-8");
                            }
                        } else {
                            a(2131165493, true);
                        }
                    }
                } else if ("buy-credit".equals(pathSegments.get(1))) {
                    zVar = new z();
                    this.m = zVar;
                    if (this.m != null) {
                        setContentView(2130903151);
                        if (o.e()) {
                            displayMetrics = new DisplayMetrics();
                            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                            getWindow().setLayout(Math.min(displayMetrics.widthPixels, (int) getResources().getDimension(2131361822)), Math.min(displayMetrics.heightPixels, (int) getResources().getDimension(2131361821)));
                        }
                        if (BazaarApplication.c().b()) {
                            findViewById(2131624368).setVisibility(0);
                        } else {
                            findViewById(2131624367).setVisibility(0);
                        }
                        this.l = true;
                        z = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getBoolean("show_payment_input_warning", true);
                        if (VERSION.SDK_INT >= 11) {
                            inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService("input_method");
                            new b((Activity) this, Integer.valueOf(2131165524), Integer.valueOf(com.farsitel.bazaar.g.ic_crouton_keyboard), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.a, true, new p(this, inputMethodManager)).a();
                            z2 = false;
                            if (z2) {
                                new b((Activity) this, Integer.valueOf(2131165525), Integer.valueOf(com.farsitel.bazaar.g.ic_action_close), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.b, false, null).a();
                            }
                            b();
                            this.k = findViewById(2131624375);
                            webView = this.j;
                            zVar2 = this.m;
                            g = j.a().g();
                            d = j.a().d();
                            stringExtra2 = zVar2.e.getIntent().getStringExtra("PARDAKHT_METHOD");
                            stringExtra = p.a().replace('\\', '|').replace('\"', '|');
                            packageName = "sans-serif";
                            if ("en".equals(f.a.getLanguage())) {
                                packageName = "monospace";
                            }
                            str = "";
                            if (zVar2.b != null) {
                                longExtra = zVar2.e.getIntent().getLongExtra("PARDAKHT_CREDIT_AMOUNT", 0);
                                str2 = f.BUY_CREDIT.g + "proceed/?l=" + f.a.getLanguage();
                                stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='amount' value='" + longExtra + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n";
                            } else {
                                str2 = f.PAYMENT_WEB.g + "proceed/?l=" + f.a.getLanguage();
                                stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='sku' value='" + zVar2.b + "' />\n<input type='hidden' name='device_id' value='" + stringExtra + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n";
                                if (zVar2.e.getIntent().getBooleanExtra("SHOULD_AGREE", false)) {
                                    str = "<input type='hidden' name='accept' value='" + zVar2.e.getIntent().getBooleanExtra("USER_AGREED", false) + "' />\n";
                                }
                            }
                            if (k.b() >= 10000) {
                            }
                            webView.loadData("<!doctype html><html><head><meta charset=\"utf-8\" />\n<title>Loading</title>\n<style>\nbody {color: #9E4957; font-family: " + packageName + "; text-align: center; font-size: 1.6em; padding: 1em 0.5em 0.5em;}\n</style></head>\n" + "<body>\n" + BazaarApplication.c().getString(2131165505) + "\n<form id='pardakht' action='" + str2 + "' method='post'>\n<input type='hidden' name='account' value='" + g + "' />\n<input type='hidden' name='user_id' value='" + d + "' />\n" + stringExtra + str + "<input type='hidden' name='on_finish' value='bazaar-v1' />\n<input type='hidden' name='no_header' value='1' />\n" + "<input type='hidden' name='method' value='" + stringExtra2 + "' />\n<input type='hidden' name='bazaar_version' value='" + (k.b() >= 10000 ? 40601 : k.b()) + "' />\n</form>\n" + "<script>document.forms.pardakht.submit();</script>\n</body></html>\n", "text/html; charset=utf-8", "utf-8");
                        }
                        z2 = z;
                        if (z2) {
                            new b((Activity) this, Integer.valueOf(2131165525), Integer.valueOf(com.farsitel.bazaar.g.ic_action_close), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.b, false, null).a();
                        }
                        b();
                        this.k = findViewById(2131624375);
                        webView = this.j;
                        zVar2 = this.m;
                        g = j.a().g();
                        d = j.a().d();
                        stringExtra2 = zVar2.e.getIntent().getStringExtra("PARDAKHT_METHOD");
                        stringExtra = p.a().replace('\\', '|').replace('\"', '|');
                        packageName = "sans-serif";
                        if ("en".equals(f.a.getLanguage())) {
                            packageName = "monospace";
                        }
                        str = "";
                        if (zVar2.b != null) {
                            str2 = f.PAYMENT_WEB.g + "proceed/?l=" + f.a.getLanguage();
                            stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='sku' value='" + zVar2.b + "' />\n<input type='hidden' name='device_id' value='" + stringExtra + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n";
                            if (zVar2.e.getIntent().getBooleanExtra("SHOULD_AGREE", false)) {
                                str = "<input type='hidden' name='accept' value='" + zVar2.e.getIntent().getBooleanExtra("USER_AGREED", false) + "' />\n";
                            }
                        } else {
                            longExtra = zVar2.e.getIntent().getLongExtra("PARDAKHT_CREDIT_AMOUNT", 0);
                            str2 = f.BUY_CREDIT.g + "proceed/?l=" + f.a.getLanguage();
                            stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='amount' value='" + longExtra + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n";
                        }
                        if (k.b() >= 10000) {
                        }
                        webView.loadData("<!doctype html><html><head><meta charset=\"utf-8\" />\n<title>Loading</title>\n<style>\nbody {color: #9E4957; font-family: " + packageName + "; text-align: center; font-size: 1.6em; padding: 1em 0.5em 0.5em;}\n</style></head>\n" + "<body>\n" + BazaarApplication.c().getString(2131165505) + "\n<form id='pardakht' action='" + str2 + "' method='post'>\n<input type='hidden' name='account' value='" + g + "' />\n<input type='hidden' name='user_id' value='" + d + "' />\n" + stringExtra + str + "<input type='hidden' name='on_finish' value='bazaar-v1' />\n<input type='hidden' name='no_header' value='1' />\n" + "<input type='hidden' name='method' value='" + stringExtra2 + "' />\n<input type='hidden' name='bazaar_version' value='" + (k.b() >= 10000 ? 40601 : k.b()) + "' />\n</form>\n" + "<script>document.forms.pardakht.submit();</script>\n</body></html>\n", "text/html; charset=utf-8", "utf-8");
                    }
                }
            }
            zVar = null;
            this.m = zVar;
            if (this.m != null) {
                setContentView(2130903151);
                if (o.e()) {
                    displayMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    getWindow().setLayout(Math.min(displayMetrics.widthPixels, (int) getResources().getDimension(2131361822)), Math.min(displayMetrics.heightPixels, (int) getResources().getDimension(2131361821)));
                }
                if (BazaarApplication.c().b()) {
                    findViewById(2131624367).setVisibility(0);
                } else {
                    findViewById(2131624368).setVisibility(0);
                }
                this.l = true;
                z = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getBoolean("show_payment_input_warning", true);
                if (VERSION.SDK_INT >= 11) {
                    inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService("input_method");
                    new b((Activity) this, Integer.valueOf(2131165524), Integer.valueOf(com.farsitel.bazaar.g.ic_crouton_keyboard), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.a, true, new p(this, inputMethodManager)).a();
                    z2 = false;
                    if (z2) {
                        new b((Activity) this, Integer.valueOf(2131165525), Integer.valueOf(com.farsitel.bazaar.g.ic_action_close), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.b, false, null).a();
                    }
                    b();
                    this.k = findViewById(2131624375);
                    webView = this.j;
                    zVar2 = this.m;
                    g = j.a().g();
                    d = j.a().d();
                    stringExtra2 = zVar2.e.getIntent().getStringExtra("PARDAKHT_METHOD");
                    stringExtra = p.a().replace('\\', '|').replace('\"', '|');
                    packageName = "sans-serif";
                    if ("en".equals(f.a.getLanguage())) {
                        packageName = "monospace";
                    }
                    str = "";
                    if (zVar2.b != null) {
                        longExtra = zVar2.e.getIntent().getLongExtra("PARDAKHT_CREDIT_AMOUNT", 0);
                        str2 = f.BUY_CREDIT.g + "proceed/?l=" + f.a.getLanguage();
                        stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='amount' value='" + longExtra + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n";
                    } else {
                        str2 = f.PAYMENT_WEB.g + "proceed/?l=" + f.a.getLanguage();
                        stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='sku' value='" + zVar2.b + "' />\n<input type='hidden' name='device_id' value='" + stringExtra + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n";
                        if (zVar2.e.getIntent().getBooleanExtra("SHOULD_AGREE", false)) {
                            str = "<input type='hidden' name='accept' value='" + zVar2.e.getIntent().getBooleanExtra("USER_AGREED", false) + "' />\n";
                        }
                    }
                    if (k.b() >= 10000) {
                    }
                    webView.loadData("<!doctype html><html><head><meta charset=\"utf-8\" />\n<title>Loading</title>\n<style>\nbody {color: #9E4957; font-family: " + packageName + "; text-align: center; font-size: 1.6em; padding: 1em 0.5em 0.5em;}\n</style></head>\n" + "<body>\n" + BazaarApplication.c().getString(2131165505) + "\n<form id='pardakht' action='" + str2 + "' method='post'>\n<input type='hidden' name='account' value='" + g + "' />\n<input type='hidden' name='user_id' value='" + d + "' />\n" + stringExtra + str + "<input type='hidden' name='on_finish' value='bazaar-v1' />\n<input type='hidden' name='no_header' value='1' />\n" + "<input type='hidden' name='method' value='" + stringExtra2 + "' />\n<input type='hidden' name='bazaar_version' value='" + (k.b() >= 10000 ? 40601 : k.b()) + "' />\n</form>\n" + "<script>document.forms.pardakht.submit();</script>\n</body></html>\n", "text/html; charset=utf-8", "utf-8");
                }
                z2 = z;
                if (z2) {
                    new b((Activity) this, Integer.valueOf(2131165525), Integer.valueOf(com.farsitel.bazaar.g.ic_action_close), (ViewGroup) findViewById(2131624373), com.farsitel.bazaar.widget.g.b, false, null).a();
                }
                b();
                this.k = findViewById(2131624375);
                webView = this.j;
                zVar2 = this.m;
                g = j.a().g();
                d = j.a().d();
                stringExtra2 = zVar2.e.getIntent().getStringExtra("PARDAKHT_METHOD");
                stringExtra = p.a().replace('\\', '|').replace('\"', '|');
                packageName = "sans-serif";
                if ("en".equals(f.a.getLanguage())) {
                    packageName = "monospace";
                }
                str = "";
                if (zVar2.b != null) {
                    str2 = f.PAYMENT_WEB.g + "proceed/?l=" + f.a.getLanguage();
                    stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='sku' value='" + zVar2.b + "' />\n<input type='hidden' name='device_id' value='" + stringExtra + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n";
                    if (zVar2.e.getIntent().getBooleanExtra("SHOULD_AGREE", false)) {
                        str = "<input type='hidden' name='accept' value='" + zVar2.e.getIntent().getBooleanExtra("USER_AGREED", false) + "' />\n";
                    }
                } else {
                    longExtra = zVar2.e.getIntent().getLongExtra("PARDAKHT_CREDIT_AMOUNT", 0);
                    str2 = f.BUY_CREDIT.g + "proceed/?l=" + f.a.getLanguage();
                    stringExtra = "<input type='hidden' name='dealer' value='" + zVar2.a + "' />\n<input type='hidden' name='amount' value='" + longExtra + "' />\n<input type='hidden' name='token' value='" + zVar2.d + "' />\n<input type='hidden' name='payload' value='" + zVar2.c + "' />\n";
                }
                if (k.b() >= 10000) {
                }
                webView.loadData("<!doctype html><html><head><meta charset=\"utf-8\" />\n<title>Loading</title>\n<style>\nbody {color: #9E4957; font-family: " + packageName + "; text-align: center; font-size: 1.6em; padding: 1em 0.5em 0.5em;}\n</style></head>\n" + "<body>\n" + BazaarApplication.c().getString(2131165505) + "\n<form id='pardakht' action='" + str2 + "' method='post'>\n<input type='hidden' name='account' value='" + g + "' />\n<input type='hidden' name='user_id' value='" + d + "' />\n" + stringExtra + str + "<input type='hidden' name='on_finish' value='bazaar-v1' />\n<input type='hidden' name='no_header' value='1' />\n" + "<input type='hidden' name='method' value='" + stringExtra2 + "' />\n<input type='hidden' name='bazaar_version' value='" + (k.b() >= 10000 ? 40601 : k.b()) + "' />\n</form>\n" + "<script>document.forms.pardakht.submit();</script>\n</body></html>\n", "text/html; charset=utf-8", "utf-8");
            }
        } else {
            finish();
        }
        if (VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        b.b();
    }

    protected void onStart() {
        super.onStart();
    }
}
