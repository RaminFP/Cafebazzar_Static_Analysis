package c.a.a.a;

import android.content.ComponentName;
import android.content.Intent;
import c.a.a.b;
import java.util.Arrays;
import java.util.List;

public class e extends b {
    public final List a() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }

    protected final void a(int i) {
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", new ComponentName(c(), b()).flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i);
        this.a.sendBroadcast(intent);
        intent = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent.putExtra("packagename", c());
        intent.putExtra("count", i);
        this.a.sendBroadcast(intent);
    }
}
