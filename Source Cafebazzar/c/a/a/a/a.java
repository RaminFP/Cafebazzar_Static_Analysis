package c.a.a.a;

import android.content.Intent;
import c.a.a.b;
import java.util.Arrays;
import java.util.List;

public class a extends b {
    public final List a() {
        return Arrays.asList(new String[]{"org.adw.launcher", "org.adwfreak.launcher"});
    }

    protected final void a(int i) {
        Intent intent = new Intent("org.adw.launcher.counter.SEND");
        intent.putExtra("PNAME", c());
        intent.putExtra("COUNT", i);
        this.a.sendBroadcast(intent);
    }
}
