package ir.cafebazaar.pardakht;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.farsitel.bazaar.activity.s;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.a.n;
import java.util.Map;

public class AuthenticateActivity extends s implements TextWatcher, OnClickListener, b {
    private TextView a;
    private TextView b;
    private Activity c;
    private EditText d;
    private ImageView e;
    private CheckBox f;
    private boolean g;
    private boolean h;
    private boolean i;
    private ProgressDialog j;
    private Button k;
    private Button l;
    private TextView m;
    private String n;

    private void c() {
        if (j.a().b()) {
            Intent intent = new Intent();
            intent.putExtra("user_password", d());
            intent.putExtra("password_asked", this.i);
            this.c.setResult(-1, intent);
            finish();
            return;
        }
        this.j.show();
        new n(d()).a(this);
    }

    private String d() {
        return this.i ? this.d.getText().toString() : "";
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        if (this.j.isShowing()) {
            this.j.dismiss();
        }
        if (i != -1) {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
            this.b.setText((CharSequence) map.get("general"));
        } else if ("increase_only".equals(getIntent().getStringExtra("request_type")) || "redeeem_only".equals(getIntent().getStringExtra("request_type"))) {
            this.b.setText(2131165397);
            this.d.setVisibility(8);
            this.l.setVisibility(8);
            this.f.setVisibility(8);
        } else {
            this.b.setText(String.format(getString(2131165368), new Object[]{j.a().h()}));
            this.d.setText(null);
            this.m.setVisibility(0);
        }
    }

    public void afterTextChanged(Editable editable) {
        if (editable.toString().length() > 0) {
            if (this.e.getVisibility() == 8) {
                this.e.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 17432576));
            }
            this.e.setVisibility(0);
            return;
        }
        if (this.e.getVisibility() == 0) {
            this.e.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 17432577));
        }
        this.e.setVisibility(8);
    }

    public final void b() {
        if (this.j.isShowing()) {
            this.j.dismiss();
        }
        Intent intent = new Intent();
        intent.putExtra("user_password", d());
        intent.putExtra("password_asked", this.i);
        this.c.setResult(-1, intent);
        finish();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131624100:
                if (this.h) {
                    this.h = false;
                    this.d.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    this.e.setImageDrawable(getApplicationContext().getResources().getDrawable(g.ic_action_pass_hide));
                    return;
                }
                this.h = true;
                this.d.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                this.e.setImageDrawable(getApplicationContext().getResources().getDrawable(g.ic_action_pass_show));
                return;
            case 2131624104:
                if (this.g) {
                    ab.a(this.f.isChecked());
                }
                c();
                return;
            case 2131624105:
                setResult(0);
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!j.a().n()) {
            finish();
        }
        this.i = ab.a();
        this.c = this;
        setContentView(2130903070);
        CharSequence stringExtra = getIntent().getStringExtra("authenticate_message");
        this.n = getIntent().getStringExtra("request_type");
        this.g = ab.b();
        setResult(0);
        this.j = new ProgressDialog(this);
        this.a = (TextView) findViewById(android.support.v7.a.g.title);
        this.b = (TextView) findViewById(2131624097);
        this.m = (TextView) findViewById(2131624101);
        this.m.setOnClickListener(new a(this));
        if (this.i) {
            if (VERSION.SDK_INT >= 11) {
                setFinishOnTouchOutside(false);
            }
            if ("increase_only".equals(this.n) || "redeeem_only".equals(this.n)) {
                if (j.a().b()) {
                    finish();
                } else {
                    this.a.setVisibility(8);
                    this.b.setText(getString(2131165500));
                    this.m.setVisibility(8);
                }
            } else if ("increase_&_buy".equals(this.n) || "redeem_&_buy".equals(this.n) || "buy_with_credit".equals(this.n)) {
                if (j.a().b()) {
                    CharSequence format = String.format(getString(2131165492), new Object[]{j.a().h()});
                    if (getIntent().hasExtra("android.intent.extra.TITLE")) {
                        format = getIntent().getStringExtra("android.intent.extra.TITLE") + format;
                    }
                    this.a.setText(format);
                    this.b.setVisibility(8);
                } else {
                    this.b.setText(getString(2131165500));
                    if (getIntent().hasExtra("android.intent.extra.TITLE")) {
                        this.a.setText(getIntent().getStringExtra("android.intent.extra.TITLE"));
                    } else {
                        this.a.setVisibility(8);
                    }
                    this.m.setVisibility(8);
                }
            } else if ("wrong_password".equals(this.n)) {
                this.a.setVisibility(8);
                this.b.setText(stringExtra);
            }
            this.f = (CheckBox) findViewById(2131624102);
            if (this.g) {
                this.f.setVisibility(0);
                this.f.setChecked(false);
            } else {
                this.f.setVisibility(8);
                this.f.setChecked(false);
            }
            this.k = (Button) findViewById(2131624104);
            this.k.setOnClickListener(this);
            this.l = (Button) findViewById(2131624105);
            this.l.setOnClickListener(this);
            this.d = (EditText) findViewById(2131624099);
            this.d.addTextChangedListener(this);
            this.d.setOnEditorActionListener(new b(this));
            this.e = (ImageView) findViewById(2131624100);
            this.e.setOnClickListener(this);
            return;
        }
        c();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
