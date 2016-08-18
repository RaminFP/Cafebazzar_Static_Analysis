package c.a.a.a;

import android.content.Intent;
import java.util.Arrays;
import java.util.List;

public class b extends c.a.a.b {
    public final List a() {
        return Arrays.asList(new String[]{"com.anddoes.launcher"});
    }

    protected final void a(int i) {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", c());
        intent.putExtra("count", i);
        intent.putExtra("class", b());
        this.a.sendBroadcast(intent);
    }
}
