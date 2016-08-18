package com.congenialmobile.util;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

public final class g {
    private static final String a = g.class.getSimpleName();

    public static KeyStore a(Context context) {
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream openRawResource = context.getResources().openRawResource(2131099651);
        try {
            instance.load(openRawResource, "String".toCharArray());
            openRawResource.close();
        } catch (IOException e) {
            Log.w(a, "getServerTrustStore :: IOException");
        } catch (Throwable th) {
            openRawResource.close();
        }
        return instance;
    }
}
