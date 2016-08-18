package c.a.a.a;

import android.content.Context;
import android.content.Intent;
import c.a.a.b;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class i extends b {
    public i(Context context) {
        super(context);
    }

    public final List a() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2"});
    }

    protected final void a(int i) {
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, String.valueOf(i == 0 ? "" : Integer.valueOf(i)));
        } catch (Exception e) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", c() + "/" + b());
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(i == 0 ? "" : Integer.valueOf(i)));
            this.a.sendBroadcast(intent);
        }
    }
}
