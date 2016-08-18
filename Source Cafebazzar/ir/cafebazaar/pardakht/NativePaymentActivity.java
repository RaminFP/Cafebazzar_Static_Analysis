package ir.cafebazaar.pardakht;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.s;
import com.farsitel.bazaar.b.e;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ab;
import com.farsitel.bazaar.h.b.h;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.ag;
import com.farsitel.bazaar.util.at;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.p;
import com.farsitel.bazaar.widget.o;
import ir.cafebazaar.pardakht.a.c;
import ir.cafebazaar.pardakht.b.a;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public class NativePaymentActivity extends s implements OnClickListener {
    private static final String a = NativePaymentActivity.class.getSimpleName();
    private String A;
    private boolean B = false;
    private String b = null;
    private c c;
    private View d;
    private View e;
    private View f;
    private EditText g;
    private ImageView h;
    private boolean i;
    private Button j;
    private Button k;
    private EditText l;
    private TextView m;
    private TextView n;
    private View o;
    private View p;
    private ImageView q;
    private String r;
    private a s;
    private ArrayList t;
    private ProgressDialog u;
    private Activity v;
    private Context w;
    private int x;
    private String y;
    private TextWatcher z = new l(this);

    static /* synthetic */ Intent a(NativePaymentActivity nativePaymentActivity, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.putExtra("INAPP_PURCHASE_DATA", jSONObject.getString("json"));
        intent.putExtra("INAPP_DATA_SIGNATURE", jSONObject.getString("sign"));
        if (jSONObject.has("json") && jSONObject.has("sign")) {
            intent.putExtra("RESPONSE_CODE", 0);
        }
        return intent;
    }

    private void a() {
        switch (this.x) {
            case 0:
                this.q.setVisibility(8);
                this.l.setEnabled(true);
                this.l.setText(null);
                this.l.addTextChangedListener(this.z);
                this.l.setBackgroundResource(g.edit_text_holo_light);
                this.l.requestFocus();
                this.n.setText(getString(2131165517));
                this.o.setVisibility(8);
                this.k.setVisibility(8);
                this.m.setVisibility(0);
                this.m.setText(2131165363);
                this.m.setTextColor(getResources().getColor(2131558533));
                return;
            case 1:
                this.q.setVisibility(8);
                this.l.setText(null);
                this.l.setEnabled(true);
                this.l.setBackgroundResource(g.edit_text_holo_light);
                this.l.addTextChangedListener(this.z);
                this.l.requestFocus();
                this.n.setText(getString(2131165517));
                this.o.setVisibility(8);
                this.k.setVisibility(8);
                this.m.setVisibility(0);
                this.m.setTextColor(getResources().getColor(2131558529));
                return;
            case 2:
                this.s = this.c.a();
                this.q.setVisibility(0);
                this.q.setImageResource(g.ic_edit);
                this.l.setEnabled(false);
                this.l.removeTextChangedListener(this.z);
                EditText editText = this.l;
                a aVar = this.s;
                editText.setText(String.format(Locale.ENGLISH, "**** **** **** %s", new Object[]{aVar.c}));
                this.l.setBackgroundResource(17170445);
                this.n.setText(this.s.d);
                this.o.setVisibility(8);
                this.k.setVisibility(0);
                this.m.setVisibility(0);
                this.m.setText(2131165333);
                this.m.setTextColor(getResources().getColor(2131558533));
                return;
            case 3:
                this.f.startAnimation(AnimationUtils.loadAnimation(this, 2130968637));
                this.m.setVisibility(0);
                this.m.setTextColor(getResources().getColor(2131558529));
                this.n.setText(getString(2131165517));
                return;
            case 4:
                this.q.setVisibility(0);
                this.q.setImageResource(g.ic_action_close);
                this.l.setEnabled(true);
                this.l.setText(null);
                this.l.setBackgroundResource(g.edit_text_holo_light);
                this.l.addTextChangedListener(this.z);
                this.l.requestFocus();
                this.n.setText(getString(2131165517));
                this.o.setVisibility(0);
                this.k.setVisibility(8);
                this.m.setVisibility(0);
                this.m.setText(2131165363);
                this.m.setTextColor(getResources().getColor(2131558533));
                return;
            case 5:
                Animation oVar = new o(this.d, this.f);
                oVar.a = false;
                this.e.startAnimation(oVar);
                this.m.setVisibility(0);
                this.m.setText(2131165364);
                this.m.setTextColor(getResources().getColor(2131558533));
                return;
            default:
                return;
        }
    }

    private void b() {
        Editable text = this.g.getText();
        if (text == null || text.length() == 0) {
            this.g.startAnimation(AnimationUtils.loadAnimation(this, 2130968637));
            this.m.setVisibility(0);
            this.m.setTextColor(getResources().getColor(2131558529));
            this.m.setText(2131165541);
        } else if (text.length() < 5 || text.length() > 12) {
            this.g.startAnimation(AnimationUtils.loadAnimation(this, 2130968637));
            this.m.setVisibility(0);
            this.m.setTextColor(getResources().getColor(2131558529));
            this.m.setText(2131165544);
        } else {
            ag.a(this, this.g.getWindowToken());
            Intent intent = getIntent();
            this.r = text.toString();
            String stringExtra = intent.getStringExtra("PARDAKHT_PACKAGE_NAME");
            String stringExtra2 = intent.getStringExtra("PARDAKHT_SKU");
            String stringExtra3 = intent.getStringExtra("PARDAKHT_DEV_PAYLOAD");
            long longExtra = intent.getLongExtra("PARDAKHT_CREDIT_AMOUNT", 0);
            this.u.show();
            this.m.setVisibility(8);
            d.INSTANCE.a(new m(), new ab(), BazaarApplication.c().a.getLanguage(), "ayandeh", j.a().d(), stringExtra, stringExtra2, stringExtra3, p.a(), Integer.valueOf(k.b()), this.s.a, this.s.b, this.r, Long.valueOf(longExtra), this.A, this.b);
        }
    }

    public void onBackPressed() {
        switch (this.x) {
            case 4:
                break;
            case 5:
                Animation oVar = new o(this.f, this.d);
                oVar.a = false;
                this.e.startAnimation(oVar);
                break;
            default:
                super.onBackPressed();
                return;
        }
        this.x = 2;
        a();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131624100:
                if (this.i) {
                    this.i = false;
                    this.g.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    this.h.setImageDrawable(getApplicationContext().getResources().getDrawable(g.ic_action_pass_hide));
                    return;
                }
                this.i = true;
                this.g.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                this.h.setImageDrawable(getApplicationContext().getResources().getDrawable(g.ic_action_pass_show));
                return;
            case 2131624125:
                Intent intent = new Intent();
                intent.setData(Uri.parse("bazaar://webview?title=" + getString(2131165534) + "&url" + "=http://cafebazaar.ir/client/payment/?l=" + (BazaarApplication.c().b() ? "fa" : "en")));
                com.farsitel.bazaar.util.c.a(this, intent, view);
                return;
            case 2131624130:
                switch (this.x) {
                    case 2:
                        this.x = 4;
                        break;
                    case 4:
                        this.x = 2;
                        break;
                    default:
                        this.x = 0;
                        break;
                }
                a();
                return;
            case 2131624133:
                new k(this, this, getString(2131165604), 2131165602, 0, 2131165463, true).e.show();
                return;
            case 2131624134:
                this.x = 5;
                a();
                return;
            case 2131624137:
                b();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903076);
        this.v = this;
        this.w = getApplicationContext();
        this.c = new c(this.w);
        this.u = new ProgressDialog(this);
        this.u.setMessage(getString(2131165546));
        this.u.setCancelable(false);
        this.y = "ayandeh";
        this.t = this.c.b();
        this.x = this.t.size() > 0 ? 2 : 0;
        this.e = findViewById(2131624128);
        this.f = findViewById(2131624135);
        findViewById(2131624125).setOnClickListener(this);
        this.g = (EditText) findViewById(2131624099);
        this.g.addTextChangedListener(new n(this));
        this.g.setOnEditorActionListener(new i(this));
        this.h = (ImageView) findViewById(2131624100);
        this.h.setOnClickListener(this);
        this.l = (EditText) findViewById(2131624132);
        this.l.setTypeface(Typeface.createFromAsset(getAssets(), "font/halter.ttf"));
        this.o = findViewById(2131624133);
        this.o.setOnClickListener(this);
        this.d = findViewById(2131624129);
        this.q = (ImageView) findViewById(2131624130);
        this.q.setOnClickListener(this);
        this.p = findViewById(2131624138);
        this.m = (TextView) findViewById(2131624126);
        this.k = (Button) findViewById(2131624134);
        this.k.setOnClickListener(this);
        this.j = (Button) findViewById(2131624137);
        this.j.setOnClickListener(this);
        this.n = (TextView) findViewById(2131624131);
        this.A = getIntent().getStringExtra("PARDAKHT_NONCE");
        a();
        if (VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        if (VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            LayoutParams attributes = window.getAttributes();
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
            at atVar = new at(this);
            atVar.a(true);
            atVar.a(getResources().getColor(2131558471));
        }
    }

    protected void onResume() {
        super.onResume();
        if (!j.a().j()) {
            m eVar = new e(this);
            eVar.g = new j(this);
            eVar.e.show();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.b != null && !this.B && this.b != null) {
            d.INSTANCE.a(null, new h(), this.b, j.a().d(), Boolean.valueOf(true));
        }
    }
}
