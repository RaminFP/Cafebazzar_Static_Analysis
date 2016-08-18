package c.a.a.a;

import android.content.Context;
import android.content.Intent;
import c.a.a.b;
import java.util.ArrayList;
import java.util.List;

public final class d extends b {
    public d(Context context) {
        super(context);
    }

    public final List a() {
        return new ArrayList(0);
    }

    protected final void a(int i) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", c());
        intent.putExtra("badge_count_class_name", b());
        this.a.sendBroadcast(intent);
    }
}
