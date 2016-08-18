package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.aj;

public final class bj extends m {
    private static BazaarApplication a = BazaarApplication.c();

    public bj(Activity activity, String str, String str2, String str3, char c, long j) {
        super(activity, e.b(String.format(a.getString(2131165805), new Object[]{str3, str2, aj.a(j, c)})), false);
        a(new bk(this));
        View inflate = activity.getLayoutInflater().inflate(2130903181, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131624427);
        checkBox.setChecked(false);
        checkBox.setText(2131165675);
        a(inflate);
        checkBox.setOnCheckedChangeListener(new bl(this));
        a(2131165317, new bm(this));
        c(2131165323, new bn(this));
        a(false);
        af afVar = af.INSTANCE;
        a(true, af.b(str).a().a());
    }
}
