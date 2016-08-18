package com.farsitel.bazaar.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import java.lang.reflect.Field;

public final class av {
    public static void a(AssetManager assetManager) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(assetManager, "font/IRAN Sans Light.ttf");
            Field declaredField = Typeface.class.getDeclaredField("SANS_SERIF");
            declaredField.setAccessible(true);
            declaredField.set(null, createFromAsset);
            createFromAsset = Typeface.createFromAsset(assetManager, "font/IRAN Sans Light.ttf");
            declaredField = Typeface.class.getDeclaredField("SERIF");
            declaredField.setAccessible(true);
            declaredField.set(null, createFromAsset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
