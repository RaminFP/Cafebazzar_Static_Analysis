package com.farsitel.bazaar.activity;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.i;

public class ErrorDialogActivity extends s implements OnClickListener {
    public static void a(int i) {
        a(BazaarApplication.c().getString(2131165389));
    }

    public static void a(String str) {
        Intent intent = new Intent(BazaarApplication.c(), ErrorDialogActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("android.intent.extra.TEXT", str);
        BazaarApplication.c().startActivity(intent);
    }

    public void onClick(View view) {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        BazaarApplication.c().a((ContextWrapper) this);
        super.onCreate(bundle);
        setContentView(2130903072);
        String stringExtra = getIntent().getStringExtra("android.intent.extra.TEXT");
        if (stringExtra == null) {
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(2131624042);
        textView.setText(Html.fromHtml(stringExtra));
        Linkify.addLinks(textView, 15);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ((Button) findViewById(2131624114)).setOnClickListener(this);
        BazaarApplication.c().d();
        i.a("/ErrorDialog/" + stringExtra);
    }
}
