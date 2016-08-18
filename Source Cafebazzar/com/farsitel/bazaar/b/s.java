package com.farsitel.bazaar.b;

import android.app.Activity;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.farsitel.bazaar.g.a.a;

public final class s extends m {
    public s(Activity activity, a aVar) {
        super(activity, 2131165331, true);
        View inflate = LayoutInflater.from(activity).inflate(2130903067, null);
        Spanned spanned = aVar.w;
        String str = "";
        if (spanned != null) {
            String[] split = spanned.toString().split("\n");
            int i = 0;
            while (i < split.length) {
                String str2 = split[i];
                if (str2.matches("\\s*")) {
                    str2 = str;
                } else {
                    str2 = str + str2;
                    if (i < split.length - 1) {
                        str2 = str2 + "<BR/>";
                    }
                }
                i++;
                str = str2;
            }
            if (!str.equals("")) {
                ((TextView) inflate.findViewById(2131624047)).setText(Html.fromHtml(str));
            }
        }
        a(17170443);
        a(inflate);
        a(2131165482, new t(this));
    }
}
