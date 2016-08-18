package c.a.a.a;

import android.content.Intent;
import c.a.a.b;
import java.util.Arrays;
import java.util.List;

public class c extends b {
    public final List a() {
        return Arrays.asList(new String[]{"com.asus.launcher"});
    }

    protected final void a(int i) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", c());
        intent.putExtra("badge_count_class_name", b());
        intent.putExtra("badge_vip_count", 0);
        this.a.sendBroadcast(intent);
    }
}
