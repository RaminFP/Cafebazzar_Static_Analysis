package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

final class as implements OnClickListener {
    final /* synthetic */ Activity a;
    final /* synthetic */ ar b;

    as(ar arVar, Activity activity) {
        this.b = arVar;
        this.a = activity;
    }

    public final void onClick(View view) {
        if (this.b.j != 'O' || this.b.d.getText().toString().length() >= 10) {
            ar.c(this.b);
        } else {
            Toast.makeText(this.a, 2131165580, 0).show();
        }
    }
}
