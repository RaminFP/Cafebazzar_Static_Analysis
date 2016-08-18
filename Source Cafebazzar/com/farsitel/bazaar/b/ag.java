package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public final class ag extends m {
    public ag(Activity activity, int i, boolean z) {
        this(activity, activity.getString(i), z);
    }

    public ag(Activity activity, String str, boolean z) {
        super(activity, activity.getString(2131165374), false);
        a(new ah(this, activity));
        View inflate = activity.getLayoutInflater().inflate(2130903155, null);
        ((TextView) inflate.findViewById(2131624097)).setText(str);
        a(inflate);
        if (z) {
            a(2131165724, new ai(this, activity));
            c(2131165323, new aj(this, activity));
            return;
        }
        a(2131165482, new ak(this, activity));
    }
}
