package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.farsitel.bazaar.g.a.a;

public final class al extends m {
    public al(Activity activity, a aVar) {
        super(activity, 2131165536, true);
        View inflate = LayoutInflater.from(activity).inflate(2130903067, null);
        String str = "";
        String[] strArr = aVar.x;
        if (strArr.length > 0) {
            str = "";
            for (int i = 0; i < strArr.length; i++) {
                if (!strArr[i].contains(aVar.g())) {
                    str = str + strArr[i];
                    if (i < strArr.length - 1) {
                        str = str + "\n";
                    }
                }
            }
            CharSequence charSequence = str;
        } else {
            Object obj = str;
        }
        TextView textView = (TextView) inflate.findViewById(2131624047);
        if (charSequence != "") {
            textView.setText(charSequence);
        } else {
            textView.setText(activity.getString(2131165468));
        }
        a(17170443);
        a(inflate);
        a(2131165482, new am(this));
    }
}
