package com.a.a.c;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

final class o implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ u b;
    final /* synthetic */ ay c;
    final /* synthetic */ b.a.a.a.a.g.o d;
    final /* synthetic */ h e;

    o(h hVar, Activity activity, u uVar, ay ayVar, b.a.a.a.a.g.o oVar) {
        this.e = hVar;
        this.a = activity;
        this.b = uVar;
        this.c = ayVar;
        this.d = oVar;
    }

    public final void run() {
        Builder builder = new Builder(this.a);
        OnClickListener pVar = new p(this);
        float f = this.a.getResources().getDisplayMetrics().density;
        int a = ((int) (((float) 5) * f));
        View textView = new TextView(this.a);
        textView.setAutoLinkMask(15);
        ay ayVar = this.c;
        textView.setText(ayVar.a("com.crashlytics.CrashSubmissionPromptMessage", ayVar.a.b));
        textView.setTextAppearance(this.a, 16973892);
        textView.setPadding(a, a, a, a);
        textView.setFocusable(false);
        View scrollView = new ScrollView(this.a);
        scrollView.setPadding(((int) (((float) 14) * f)), ((int) (((float) 2) * f)), ((int) (((float) 10) * f)), ((int) (((float) 12) * f)));
        scrollView.addView(textView);
        Builder view = builder.setView(scrollView);
        ay ayVar2 = this.c;
        view = view.setTitle(ayVar2.a("com.crashlytics.CrashSubmissionPromptTitle", ayVar2.a.a)).setCancelable(false);
        ayVar2 = this.c;
        view.setNeutralButton(ayVar2.a("com.crashlytics.CrashSubmissionSendTitle", ayVar2.a.c), pVar);
        if (this.d.d) {
            pVar = new q(this);
            ay ayVar3 = this.c;
            builder.setNegativeButton(ayVar3.a("com.crashlytics.CrashSubmissionCancelTitle", ayVar3.a.e), pVar);
        }
        if (this.d.f) {
            pVar = new r(this);
            ayVar3 = this.c;
            builder.setPositiveButton(ayVar3.a("com.crashlytics.CrashSubmissionAlwaysSendTitle", ayVar3.a.g), pVar);
        }
        builder.show();
    }
}
