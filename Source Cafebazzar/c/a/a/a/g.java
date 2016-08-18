package c.a.a.a;

import android.content.Intent;
import c.a.a.b;
import java.util.Arrays;
import java.util.List;

public class g extends b {
    public final List a() {
        return Arrays.asList(new String[]{"com.majeur.launcher"});
    }

    protected final void a(int i) {
        Intent intent = new Intent("com.majeur.launcher.intent.action.UPDATE_BADGE");
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_PACKAGE", c());
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_COUNT", i);
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_CLASS", b());
        this.a.sendBroadcast(intent);
    }
}
