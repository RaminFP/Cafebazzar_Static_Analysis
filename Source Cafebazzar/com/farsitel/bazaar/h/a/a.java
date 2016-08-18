package com.farsitel.bazaar.h.a;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.telephony.TelephonyManager;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.database.e;
import com.farsitel.bazaar.database.f;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.g.k;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.p;
import com.farsitel.bazaar.util.q;
import java.math.BigInteger;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {
    protected BazaarApplication a = BazaarApplication.c();

    protected static String a() {
        String str = Build.FINGERPRINT;
        return str.length() > 120 ? Build.FINGERPRINT.substring(0, 120) : str;
    }

    public final void a(JSONObject jSONObject) {
        int i;
        String str;
        j a = j.a();
        k s = a.s();
        if (jSONObject.has("key")) {
            s.a(jSONObject.getString("key"));
        } else if (a.n()) {
            s.a(null).d(null);
        }
        if (jSONObject.has("update_time_interval")) {
            s.a.putLong("update_time_interval", jSONObject.getLong("update_time_interval"));
        }
        if (jSONObject.has("sms_panel_numbers")) {
            s.a.putString("user_panel_sms_numbers", jSONObject.getString("sms_panel_numbers"));
        }
        if (jSONObject.has("sms_patterns")) {
            s.a.putString("user_sms_patterns", jSONObject.getString("sms_patterns"));
        }
        if (jSONObject.has("cdn_prefix")) {
            s.a.putString("user_cdnprefix", jSONObject.getString("cdn_prefix"));
        }
        if (jSONObject.has("sign_up_with_phone_enabled")) {
            s.b(jSONObject.getBoolean("sign_up_with_phone_enabled"));
        } else {
            s.b(false);
        }
        if (jSONObject.has("user_id")) {
            s.b(jSONObject.getString("user_id"));
        }
        if (jSONObject.has("phone")) {
            s.c(jSONObject.getString("phone"));
        }
        if (jSONObject.has("email")) {
            s.d(jSONObject.getString("email"));
        }
        if (jSONObject.has("has_password")) {
            s.a(jSONObject.getBoolean("has_password"));
        }
        if (jSONObject.has("nickname")) {
            s.e(jSONObject.getString("nickname"));
        }
        if (jSONObject.has("device_id")) {
            s.a(jSONObject.getInt("device_id"));
        }
        if (jSONObject.has("stats_urls")) {
            JSONArray jSONArray = jSONObject.getJSONArray("stats_urls");
            String[] strArr = new String[jSONArray.length()];
            for (i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.getString(i);
            }
            s.a(strArr);
        } else {
            if (jSONObject.has("stats_url")) {
                String[] strArr2 = new String[1];
                strArr2[0] = jSONObject.getString("stats_url");
                s.a(strArr2);
            }
        }
        if (jSONObject.has("update_all_enabled")) {
            s.a.putBoolean("update_all_enabled", jSONObject.getBoolean("update_all_enabled"));
        }
        if (jSONObject.has("support_knowledgebase_enabled")) {
            s.a.putBoolean("support_knowledgebase_enabled", jSONObject.getBoolean("support_knowledgebase_enabled"));
        }
        if (jSONObject.has("notable_apps")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("notable_apps");
            Iterator keys = jSONObject2.keys();
            e.a().b();
            while (keys.hasNext()) {
                JSONArray jSONArray2;
                str = (String) keys.next();
                jSONArray2 = jSONObject2.getJSONArray(str);
                String string = jSONArray2.getString(0);
                if (jSONArray2.getInt(2) == 1) {
                    e.a().a(str, string);
                }
            }
        }
        if (jSONObject.has("bazaar")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("bazaar");
            if (jSONObject3.has("fvc")) {
                com.farsitel.bazaar.util.k.a(jSONObject3.getLong("fvc"));
            } else {
                com.farsitel.bazaar.util.k.a(0);
            }
            long j = jSONObject3.getLong("vc");
            if (j > ((long) com.farsitel.bazaar.util.k.b())) {
                String str2;
                String string2 = jSONObject3.getString("t");
                long j2 = jSONObject3.getLong("s");
                BigInteger bigInteger = new BigInteger(jSONObject3.getString("h"), 16);
                str = null;
                if (jSONObject3.has("cp")) {
                    jSONArray2 = jSONObject3.getJSONArray("cp");
                    if (jSONArray2.length() > 0) {
                        str = jSONArray2.getString(0);
                    }
                    for (int i2 = 1; i2 < jSONArray2.length(); i2++) {
                        str = str + ";" + jSONArray2.getString(i2);
                    }
                    str2 = str;
                } else {
                    str2 = null;
                }
                String str3 = null;
                BigInteger bigInteger2 = null;
                long j3 = 0;
                if (jSONObject3.has("df")) {
                    af afVar = af.INSTANCE;
                    d b = af.b(BazaarApplication.c().getPackageName());
                    JSONArray jSONArray3 = jSONObject3.getJSONArray("df");
                    for (i = 0; i < jSONArray3.length(); i++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i);
                        if (jSONObject4.getLong("ovc") == b.d && jSONObject4.getLong("nvc") == j) {
                            str3 = jSONObject4.getString("t");
                            bigInteger2 = new BigInteger(jSONObject4.getString("h"), 16);
                            j3 = jSONObject4.getLong("s");
                            break;
                        }
                    }
                }
                AppDownloadService.a(BazaarApplication.c().getPackageName(), BazaarApplication.c().getString(2131165276), true, "register", str2, string2, bigInteger, j2, str3, bigInteger2, j3);
                NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
                Intent intent = new Intent(this.a, HomeActivity.class);
                intent.setData(com.farsitel.bazaar.activity.a.a(this.a.getPackageName(), "new_bazaar_notification"));
                notificationManager.notify(2, new Builder(BazaarApplication.c()).setSmallIcon(g.ic_stat_basket).setTicker(this.a.getString(2131165456)).setContentTitle(this.a.getString(2131165456)).setContentText(this.a.getString(2131165455)).setOngoing(false).setAutoCancel(true).setLights(this.a.getResources().getColor(2131558414), 50, 2000).setContentIntent(PendingIntent.getActivity(this.a, 0, intent, 0)).build());
            }
        } else {
            com.farsitel.bazaar.util.k.a(0);
        }
        if (jSONObject.has("ganal_sample_rate")) {
            s.a.putString("ganal_sample_rate", String.valueOf(jSONObject.getDouble("ganal_sample_rate")));
        }
        if (jSONObject.has("ganal_key")) {
            s.a.putString("ganal_key", jSONObject.getString("ganal_key"));
        }
        if (jSONObject.has("us")) {
            s.a.putString("user_specs", jSONObject.getJSONObject("us").toString());
        }
        s.a();
        if (j.a().n()) {
            new f().execute(new Void[0]);
        }
    }

    public final Object[] a(String str) {
        return new Object[]{str, p.a(), Integer.valueOf(VERSION.SDK_INT), Build.DEVICE, this.a.a.toString(), this.a.b.toString(), com.farsitel.bazaar.util.k.c(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), a(), Integer.valueOf(q.c()), Integer.valueOf(q.d()), null, b()};
    }

    public final Object[] a(String str, String str2) {
        return new Object[]{j.a().b, p.a(), j.a().d(), str, str2, Integer.valueOf(VERSION.SDK_INT), Build.DEVICE, this.a.a.toString(), this.a.b.toString(), com.farsitel.bazaar.util.k.c(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), a(), Integer.valueOf(q.c()), Integer.valueOf(q.d()), null, b()};
    }

    public final Object[] a(String str, String str2, boolean z) {
        return new Object[]{str, str2, Boolean.valueOf(z), p.a(), Integer.valueOf(VERSION.SDK_INT), Build.DEVICE, this.a.a.toString(), this.a.b.toString(), com.farsitel.bazaar.util.k.c(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), a(), Integer.valueOf(q.c()), Integer.valueOf(q.d()), null, b()};
    }

    protected final JSONObject b() {
        Object deviceId;
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        WifiManager wifiManager = (WifiManager) this.a.getSystemService("wifi");
        if (wifiManager != null) {
            i = wifiManager.getWifiState();
        }
        try {
            deviceId = ((TelephonyManager) BazaarApplication.c().getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            deviceId = "-";
        }
        try {
            jSONObject.put("wifi", i);
            jSONObject.put("device_id_int", j.a().m());
            jSONObject.put("gcm_id", com.farsitel.bazaar.e.a.a());
            jSONObject.put("device_imei", deviceId);
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    public final Object[] b(String str) {
        return new Object[]{j.a().b, str, p.a(), Integer.valueOf(VERSION.SDK_INT), Build.DEVICE, this.a.a.toString(), this.a.b.toString(), com.farsitel.bazaar.util.k.c(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), a(), Integer.valueOf(q.c()), Integer.valueOf(q.d()), null, b()};
    }

    public final Object[] b(String str, String str2) {
        return new Object[]{j.a().b, str, str2, p.a(), Integer.valueOf(VERSION.SDK_INT), Build.DEVICE, this.a.a.toString(), this.a.b.toString(), com.farsitel.bazaar.util.k.c(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), a(), Integer.valueOf(q.c()), Integer.valueOf(q.d()), null, b()};
    }

    public final Object[] c() {
        return new Object[]{j.a().b, p.a(), Integer.valueOf(VERSION.SDK_INT), Build.DEVICE, this.a.a.toString(), this.a.b.toString(), com.farsitel.bazaar.util.k.c(), Integer.valueOf(com.farsitel.bazaar.util.k.b()), a(), Integer.valueOf(q.c()), Integer.valueOf(q.d()), null, b()};
    }
}
