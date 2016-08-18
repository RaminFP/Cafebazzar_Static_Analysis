package com.farsitel.bazaar.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.b.j;
import com.farsitel.bazaar.BazaarApplication;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class v extends BroadcastReceiver {
    final int d = new Random().nextInt(999999);
    boolean e;

    public static void a(c cVar, int i) {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.NETWORK_ERROR");
        intent.putExtra("request_key", i);
        intent.putExtra("error_code", cVar.b);
        intent.putExtra("error_msgs", cVar.c);
        j.a(BazaarApplication.c()).a(intent);
    }

    public static void a(Object obj, int i) {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.NETWORK_RESPONSE");
        intent.putExtra("request_key", i);
        intent.putExtra("response_body", obj.toString());
        intent.putExtra("response_class_type", obj.getClass());
        j.a(BazaarApplication.c()).a(intent);
    }

    public abstract void a(c cVar);

    public abstract void a(Object obj);

    public void b() {
        if (this.e) {
            j.a(BazaarApplication.c()).a((BroadcastReceiver) this);
            this.e = false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.farsitel.bazaar.NETWORK_RESPONSE".equals(intent.getAction())) {
            if (intent.getIntExtra("request_key", -1) == this.d) {
                try {
                    String stringExtra = intent.getStringExtra("response_body");
                    if (stringExtra != null) {
                        Object jSONObject;
                        Class cls = (Class) intent.getSerializableExtra("response_class_type");
                        if (cls.equals(JSONObject.class)) {
                            jSONObject = new JSONObject(stringExtra);
                        } else if (cls.equals(JSONArray.class)) {
                            jSONObject = new JSONArray(stringExtra);
                        } else if (cls.equals(String.class)) {
                            String str = stringExtra;
                        } else {
                            jSONObject = cls.equals(Long.class) ? Long.valueOf(Long.parseLong(stringExtra)) : cls.equals(Integer.class) ? Integer.valueOf(Integer.parseInt(stringExtra)) : cls.equals(Boolean.class) ? Boolean.valueOf(Boolean.parseBoolean(stringExtra)) : null;
                        }
                        a(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    a(new c((byte) 0));
                } catch (Throwable th) {
                    b();
                }
                b();
            }
        } else if ("com.farsitel.bazaar.NETWORK_ERROR".equals(intent.getAction()) && intent.getIntExtra("request_key", -1) == this.d) {
            try {
                a(new c(intent.getIntExtra("error_code", -1), (HashMap) intent.getSerializableExtra("error_msgs")));
            } finally {
                b();
            }
        }
    }
}
