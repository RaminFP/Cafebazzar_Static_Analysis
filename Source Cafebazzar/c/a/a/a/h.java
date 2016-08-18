package c.a.a.a;

import android.content.Intent;
import c.a.a.b;
import java.util.Arrays;
import java.util.List;

public class h extends b {
    public final List a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home"});
    }

    protected final void a(int i) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", c());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", b());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i > 0);
        this.a.sendBroadcast(intent);
    }
}
