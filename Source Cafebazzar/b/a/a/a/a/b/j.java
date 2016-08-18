package b.a.a.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import b.a.a.a.f;

public final class j {
    private static String b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    f.a().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            f.a().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    public final String a(Context context) {
        Object b = b(context);
        if (TextUtils.isEmpty(b)) {
            b = null;
            int a = l.a(context, "io.fabric.ApiKey", "string");
            if (a == 0) {
                f.a().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
                a = l.a(context, "com.crashlytics.ApiKey", "string");
            }
            if (a != 0) {
                b = context.getResources().getString(a);
            }
        }
        if (TextUtils.isEmpty(b)) {
            if (f.b() || l.h(context)) {
                throw new IllegalArgumentException("Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
            }
            f.a().e("Fabric", "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
        }
        return b;
    }
}
