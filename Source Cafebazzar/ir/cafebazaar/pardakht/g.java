package ir.cafebazaar.pardakht;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.s;
import com.farsitel.bazaar.h.b.v;
import com.farsitel.bazaar.h.d;
import ir.cafebazaar.pardakht.a.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends Stub {
    private static final BazaarApplication a = BazaarApplication.c();
    private final Context b;
    private final Handler c = new Handler();
    private final e d = new e(this.b);

    public g(Context context) {
        this.b = context;
    }

    private static boolean a(String str, Bundle bundle) {
        if (str == null) {
            Log.i("Bazaar-BillingService", "InAppBillingServiceFunc :: securityCheck :: packageName= null");
            bundle.putInt("RESPONSE_CODE", 5);
            return false;
        }
        if (str.equals(a.getPackageManager().getNameForUid(getCallingUid()))) {
            return true;
        }
        Log.e("Bazaar-BillingService", "InAppBillingServiceFunc :: getSkuDetails :: packageName forging");
        bundle.putInt("RESPONSE_CODE", 5);
        return false;
    }

    public final int a(int i, String str, String str2) {
        return i < 3 ? 3 : 0;
    }

    public final Bundle a(int i, String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (i < 3) {
            bundle2.putInt("RESPONSE_CODE", 3);
            return bundle2;
        } else if (!a(str, bundle2)) {
            return bundle2;
        } else {
            JSONArray jSONArray = new JSONArray();
            Object stringArrayList = bundle.getStringArrayList("ITEM_ID_LIST");
            Collections.sort(stringArrayList);
            Iterator it = stringArrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            try {
                JSONArray jSONArray2 = (JSONArray) d.INSTANCE.a(new v(), a.a.getLanguage(), Integer.valueOf(i), str, str2, jSONArray);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(jSONArray2.getJSONObject(i2).toString());
                }
                bundle2.putStringArrayList("DETAILS_LIST", arrayList);
                bundle2.putInt("RESPONSE_CODE", 0);
            } catch (Exception e) {
                bundle2.putInt("RESPONSE_CODE", 6);
            }
            return bundle2;
        }
    }

    public final Bundle a(int i, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        if (i < 3 || !("inapp".equals(str2) || "subs".equals(str2))) {
            bundle.putInt("RESPONSE_CODE", 3);
        } else if (!a(str, bundle)) {
            return bundle;
        } else {
            bundle.putInt("RESPONSE_CODE", 0);
            j a = j.a();
            String d = a.d();
            long currentTimeMillis;
            if (!a.n() || d == null) {
                bundle.putInt("RESPONSE_CODE", 6);
                aa aaVar = aa.INSTANCE;
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - aaVar.d >= 259200000) {
                    aaVar.d = currentTimeMillis;
                    aaVar.e.edit().putLong("last_iab_notification", aaVar.d).commit();
                    try {
                        PackageManager packageManager = aaVar.b.getPackageManager();
                        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                        Intent intent = new Intent(aaVar.b, JoinActivity.class);
                        intent.putExtra("extra_referer", "iap-notif");
                        intent.putExtra("package_name", str);
                        intent.putExtra("android.intent.extra.TITLE", aaVar.b.getString(2131165285));
                        PendingIntent activity = PendingIntent.getActivity(aaVar.b, 0, intent, 134217728);
                        Style bigTextStyle = new BigTextStyle();
                        bigTextStyle.bigText(aaVar.b.getString(2131165285));
                        Builder builder = new Builder(aaVar.b);
                        builder.setTicker(aaVar.b.getString(2131165441)).setContentText(aaVar.b.getString(2131165285)).setContentTitle(aaVar.b.getString(2131165441)).setStyle(bigTextStyle).setSmallIcon(com.farsitel.bazaar.g.ic_stat_basket).setContentIntent(activity).setOngoing(false).setAutoCancel(true);
                        try {
                            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                            Resources resourcesForApplication = BazaarApplication.c().getPackageManager().getResourcesForApplication(applicationInfo);
                            intent.putExtra("android.intent.extra.TITLE", aaVar.b.getString(2131165286, new Object[]{resourcesForApplication.getString(applicationInfo.labelRes)}));
                            Configuration configuration = new Configuration();
                            configuration.locale = BazaarApplication.c().getResources().getConfiguration().locale;
                            resourcesForApplication.updateConfiguration(configuration, BazaarApplication.c().getResources().getDisplayMetrics());
                            if (applicationInfo.labelRes != 0) {
                                String string = resourcesForApplication.getString(applicationInfo.labelRes);
                                intent.putExtra("android.intent.extra.TITLE", aaVar.b.getString(2131165286, new Object[]{string}));
                                PendingIntent activity2 = PendingIntent.getActivity(aaVar.b, 0, intent, 134217728);
                                bigTextStyle.bigText(aaVar.b.getString(2131165286, new Object[]{string}));
                                builder.setContentText(aaVar.b.getString(2131165286, new Object[]{string}));
                                builder.setContentIntent(activity2);
                            }
                        } catch (Exception e) {
                        }
                        try {
                            builder.setLargeIcon(((BitmapDrawable) packageManager.getApplicationIcon(str)).getBitmap());
                        } catch (Exception e2) {
                        }
                        aaVar.c.notify(2323, builder.build());
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                try {
                    currentTimeMillis = e.a();
                    this.d.a((JSONObject) d.INSTANCE.a(new s(), Integer.valueOf(i), d, Long.valueOf(currentTimeMillis)), str, str2, bundle);
                } catch (Exception e4) {
                    bundle.putInt("RESPONSE_CODE", 6);
                }
            }
        }
        return bundle;
    }

    public final Bundle a(int i, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        if (i < 3 || !("inapp".equals(str3) || "subs".equals(str3))) {
            bundle.putInt("RESPONSE_CODE", 3);
        } else if (a(str, bundle)) {
            bundle.putInt("RESPONSE_CODE", 0);
            Intent intent = new Intent("ir.cafebazaar.intent.action.PAY", Uri.parse("bazaar://pardakht/v1/pay/"));
            intent.setPackage(this.b.getPackageName());
            intent.putExtra("PARDAKHT_PACKAGE_NAME", str);
            intent.putExtra("PARDAKHT_SKU", str2);
            intent.putExtra("PARDAKHT_DEV_PAYLOAD", str4);
            bundle.putParcelable("BUY_INTENT", PendingIntent.getActivity(this.b, 1, intent, 268435456));
        }
        return bundle;
    }

    public final int b(int i, String str, String str2) {
        if (!a(str, new Bundle())) {
            return 5;
        }
        j a = j.a();
        String d = a.d();
        if (!a.n() || d == null) {
            return 5;
        }
        try {
            int intValue = ((Integer) d.INSTANCE.a(new com.farsitel.bazaar.h.b.g(), Integer.valueOf(i), d, str, str2)).intValue();
            if (intValue != 0) {
                return intValue;
            }
            this.d.a(str, str2);
            return intValue;
        } catch (Throwable e) {
            Log.e("Bazaar-BillingService", "InAppBillingServiceFunc :: consumePurchase :: remote call failed:", e);
            return 6;
        }
    }
}
