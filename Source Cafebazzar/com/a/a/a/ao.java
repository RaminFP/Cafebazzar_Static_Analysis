package com.a.a.a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import b.a.a.a.a.d.a;
import java.io.IOException;
import org.json.JSONObject;

final class ao implements a {
    ao() {
    }

    @TargetApi(9)
    private static JSONObject a(ak akVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            an anVar = akVar.a;
            jSONObject.put("appBundleId", anVar.a);
            jSONObject.put("executionId", anVar.b);
            jSONObject.put("installationId", anVar.c);
            jSONObject.put("androidId", anVar.d);
            jSONObject.put("advertisingId", anVar.e);
            jSONObject.put("limitAdTrackingEnabled", anVar.f);
            jSONObject.put("betaDeviceToken", anVar.g);
            jSONObject.put("buildId", anVar.h);
            jSONObject.put("osVersion", anVar.i);
            jSONObject.put("deviceModel", anVar.j);
            jSONObject.put("appVersionCode", anVar.k);
            jSONObject.put("appVersionName", anVar.l);
            jSONObject.put("timestamp", akVar.b);
            jSONObject.put("type", akVar.c.toString());
            if (akVar.d != null) {
                jSONObject.put("details", new JSONObject(akVar.d));
            }
            jSONObject.put("customType", akVar.e);
            if (akVar.f != null) {
                jSONObject.put("customAttributes", new JSONObject(akVar.f));
            }
            jSONObject.put("predefinedType", akVar.g);
            if (akVar.h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(akVar.h));
            }
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }

    public final /* synthetic */ byte[] a(Object obj) {
        return a((ak) obj).toString().getBytes("UTF-8");
    }
}
