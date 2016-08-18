package com.farsitel.bazaar.g.d;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.util.c;

public final class a {
    public int a;
    private boolean b = false;
    private boolean c = false;
    private String d;
    private boolean e = false;
    private String f;
    private boolean g = false;
    private long h = 0;
    private String i;
    private String j;
    private String k;
    private String l;
    private Bundle m;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.os.Bundle r9) {
        /*
        r8 = this;
        r0 = 0;
        r8.<init>();
        r8.b = r0;
        r8.c = r0;
        r8.e = r0;
        r8.g = r0;
        r2 = 0;
        r8.h = r2;
        r1 = "s";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x0024;
    L_0x0018:
        r1 = "s";
        r1 = r9.getString(r1);
        r1 = java.lang.Boolean.parseBoolean(r1);
        r8.b = r1;
    L_0x0024:
        r1 = "n";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x0038;
    L_0x002c:
        r1 = "n";
        r1 = r9.getString(r1);
        r1 = java.lang.Boolean.parseBoolean(r1);
        r8.c = r1;
    L_0x0038:
        r1 = "k";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x0048;
    L_0x0040:
        r1 = "k";
        r1 = r9.getString(r1);
        r8.d = r1;
    L_0x0048:
        r1 = "o";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x005c;
    L_0x0050:
        r1 = "o";
        r1 = r9.getString(r1);
        r1 = java.lang.Boolean.parseBoolean(r1);
        r8.g = r1;
    L_0x005c:
        r1 = "d";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x006c;
    L_0x0064:
        r1 = "d";
        r2 = r9.getLong(r1);
        r8.h = r2;
    L_0x006c:
        r1 = "t";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x007c;
    L_0x0074:
        r1 = "t";
        r1 = r9.getString(r1);
        r8.i = r1;
    L_0x007c:
        r1 = "x";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x008c;
    L_0x0084:
        r1 = "x";
        r1 = r9.getString(r1);
        r8.j = r1;
    L_0x008c:
        r1 = "ay";
        r1 = r9.containsKey(r1);
        if (r1 == 0) goto L_0x00f7;
    L_0x0094:
        r1 = "ay";
        r1 = r9.getString(r1);
        r2 = r1.hashCode();
        switch(r2) {
            case 65: goto L_0x013c;
            case 66: goto L_0x0151;
            case 83: goto L_0x0146;
            default: goto L_0x00a1;
        };
    L_0x00a1:
        r0 = -1;
    L_0x00a2:
        switch(r0) {
            case 0: goto L_0x015c;
            case 1: goto L_0x0162;
            case 2: goto L_0x0168;
            default: goto L_0x00a5;
        };
    L_0x00a5:
        r0 = "aa";
        r0 = r9.getString(r0);
        r8.k = r0;
        r0 = "ad";
        r0 = r9.getString(r0);
        r8.l = r0;
        r0 = "ab";
        r0 = r9.containsKey(r0);
        if (r0 == 0) goto L_0x00f7;
    L_0x00bd:
        r0 = new android.os.Bundle;
        r0.<init>();
        r8.m = r0;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00f3 }
        r0 = "ab";
        r0 = r9.getString(r0);	 Catch:{ JSONException -> 0x00f3 }
        r2.<init>(r0);	 Catch:{ JSONException -> 0x00f3 }
        r3 = r2.keys();	 Catch:{ JSONException -> 0x00f3 }
    L_0x00d3:
        r0 = r3.hasNext();	 Catch:{ JSONException -> 0x00f3 }
        if (r0 == 0) goto L_0x00f7;
    L_0x00d9:
        r0 = r3.next();	 Catch:{ JSONException -> 0x00f3 }
        r0 = (java.lang.String) r0;	 Catch:{ JSONException -> 0x00f3 }
        r1 = r2.get(r0);	 Catch:{ JSONException -> 0x00f3 }
        r4 = r1 instanceof java.lang.Integer;	 Catch:{ JSONException -> 0x00f3 }
        if (r4 == 0) goto L_0x016e;
    L_0x00e7:
        r4 = r8.m;	 Catch:{ JSONException -> 0x00f3 }
        r1 = (java.lang.Integer) r1;	 Catch:{ JSONException -> 0x00f3 }
        r1 = r1.intValue();	 Catch:{ JSONException -> 0x00f3 }
        r4.putInt(r0, r1);	 Catch:{ JSONException -> 0x00f3 }
        goto L_0x00d3;
    L_0x00f3:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00f7:
        r0 = "ex";
        r0 = r9.containsKey(r0);
        if (r0 == 0) goto L_0x010b;
    L_0x00ff:
        r0 = "ex";
        r0 = r9.getString(r0);
        r0 = java.lang.Boolean.parseBoolean(r0);
        r8.e = r0;
    L_0x010b:
        r0 = "bx";
        r0 = r9.containsKey(r0);
        if (r0 == 0) goto L_0x011b;
    L_0x0113:
        r0 = "bx";
        r0 = r9.getString(r0);
        r8.f = r0;
    L_0x011b:
        r1 = com.farsitel.bazaar.g.a.a();
        r2 = new com.farsitel.bazaar.g.c;
        r2.<init>();
        r0 = "gcm";
        r2.c = r0;
        r0 = "message";
        r2.e = r0;
        r0 = r8.d;
        if (r0 == 0) goto L_0x01bf;
    L_0x0130:
        r0 = r8.d;
    L_0x0132:
        r3 = "ticker";
        r0 = r2.b(r3, r0);
        r1.a(r0);
        return;
    L_0x013c:
        r2 = "A";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00a1;
    L_0x0144:
        goto L_0x00a2;
    L_0x0146:
        r0 = "S";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x00a1;
    L_0x014e:
        r0 = 1;
        goto L_0x00a2;
    L_0x0151:
        r0 = "B";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x00a1;
    L_0x0159:
        r0 = 2;
        goto L_0x00a2;
    L_0x015c:
        r0 = com.farsitel.bazaar.g.d.c.a;
        r8.a = r0;
        goto L_0x00a5;
    L_0x0162:
        r0 = com.farsitel.bazaar.g.d.c.b;
        r8.a = r0;
        goto L_0x00a5;
    L_0x0168:
        r0 = com.farsitel.bazaar.g.d.c.c;
        r8.a = r0;
        goto L_0x00a5;
    L_0x016e:
        r4 = r1 instanceof java.lang.Boolean;	 Catch:{ JSONException -> 0x00f3 }
        if (r4 == 0) goto L_0x017f;
    L_0x0172:
        r4 = r8.m;	 Catch:{ JSONException -> 0x00f3 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ JSONException -> 0x00f3 }
        r1 = r1.booleanValue();	 Catch:{ JSONException -> 0x00f3 }
        r4.putBoolean(r0, r1);	 Catch:{ JSONException -> 0x00f3 }
        goto L_0x00d3;
    L_0x017f:
        r4 = r1 instanceof java.lang.Byte;	 Catch:{ JSONException -> 0x00f3 }
        if (r4 == 0) goto L_0x0190;
    L_0x0183:
        r4 = r8.m;	 Catch:{ JSONException -> 0x00f3 }
        r1 = (java.lang.Byte) r1;	 Catch:{ JSONException -> 0x00f3 }
        r1 = r1.byteValue();	 Catch:{ JSONException -> 0x00f3 }
        r4.putByte(r0, r1);	 Catch:{ JSONException -> 0x00f3 }
        goto L_0x00d3;
    L_0x0190:
        r4 = r1 instanceof java.lang.Character;	 Catch:{ JSONException -> 0x00f3 }
        if (r4 == 0) goto L_0x01a1;
    L_0x0194:
        r4 = r8.m;	 Catch:{ JSONException -> 0x00f3 }
        r1 = (java.lang.Character) r1;	 Catch:{ JSONException -> 0x00f3 }
        r1 = r1.charValue();	 Catch:{ JSONException -> 0x00f3 }
        r4.putChar(r0, r1);	 Catch:{ JSONException -> 0x00f3 }
        goto L_0x00d3;
    L_0x01a1:
        r4 = r1 instanceof java.lang.String;	 Catch:{ JSONException -> 0x00f3 }
        if (r4 == 0) goto L_0x01ae;
    L_0x01a5:
        r4 = r8.m;	 Catch:{ JSONException -> 0x00f3 }
        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x00f3 }
        r4.putString(r0, r1);	 Catch:{ JSONException -> 0x00f3 }
        goto L_0x00d3;
    L_0x01ae:
        r4 = r1 instanceof java.lang.Long;	 Catch:{ JSONException -> 0x00f3 }
        if (r4 == 0) goto L_0x00d3;
    L_0x01b2:
        r4 = r8.m;	 Catch:{ JSONException -> 0x00f3 }
        r1 = (java.lang.Long) r1;	 Catch:{ JSONException -> 0x00f3 }
        r6 = r1.longValue();	 Catch:{ JSONException -> 0x00f3 }
        r4.putLong(r0, r6);	 Catch:{ JSONException -> 0x00f3 }
        goto L_0x00d3;
    L_0x01bf:
        r0 = "";
        goto L_0x0132;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.g.d.a.<init>(android.os.Bundle):void");
    }

    public final boolean a() {
        return (!this.c || this.d == null || this.i == null || this.j == null) ? false : true;
    }

    public final Notification b() {
        PendingIntent pendingIntent = null;
        if (!a()) {
            return null;
        }
        Builder autoCancel = new Builder(BazaarApplication.c()).setSmallIcon(g.ic_stat_basket).setTicker(this.d).setContentTitle(this.i).setContentText(this.j).setOngoing(this.g).setAutoCancel(true);
        if (this.e) {
            autoCancel = autoCancel.setStyle(new BigTextStyle().bigText(this.f));
        }
        try {
            if (!(this.a == 0 || (this.k == null && this.l == null))) {
                Intent c = c();
                switch (b.a[this.a - 1]) {
                    case 1:
                        pendingIntent = PendingIntent.getActivity(BazaarApplication.c(), 0, c, 0);
                        break;
                    case 2:
                        pendingIntent = PendingIntent.getService(BazaarApplication.c(), 0, c, 0);
                        break;
                    case 3:
                        pendingIntent = PendingIntent.getBroadcast(BazaarApplication.c(), 0, c, 0);
                        break;
                }
                if (pendingIntent != null) {
                    autoCancel.setContentIntent(pendingIntent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoCancel.build();
    }

    public Intent c() {
        Intent intent = new Intent();
        if (this.l != null) {
            intent.setData(Uri.parse(this.l));
        }
        if (this.k != null) {
            intent.setAction(this.k);
        }
        if (this.m != null) {
            intent.putExtras(this.m);
        }
        c.a(intent);
        return intent;
    }
}
