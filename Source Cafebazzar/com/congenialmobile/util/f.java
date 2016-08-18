package com.congenialmobile.util;

import android.app.Application;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.farsitel.bazaar.BazaarApplication;
import java.text.Collator;
import java.util.Locale;

public abstract class f extends Application {
    public Locale a = null;
    public Locale b = null;
    public Collator c;

    public void a() {
    }

    public final void a(ContextWrapper contextWrapper) {
        if (this.b == null) {
            this.b = Locale.getDefault();
        }
        String string = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getString("locale", null);
        if (string == null) {
            string = "fa";
        } else if ("DEFAULT".equals(string)) {
            string = this.b.getLanguage();
            if (!(string.equals("fa") || string.equals("en"))) {
                string = "fa";
            }
        }
        this.a = new Locale(string, this.b.getCountry());
        Locale.setDefault(this.a);
        Resources resources = contextWrapper.getBaseContext().getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(string);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        this.c = Collator.getInstance();
    }

    public final void a(Configuration configuration) {
        if (configuration.locale.equals(this.b)) {
            Locale.setDefault(this.a);
            Configuration configuration2 = new Configuration();
            configuration2.locale = this.a;
            getBaseContext().getResources().updateConfiguration(configuration2, null);
            return;
        }
        this.b = configuration.locale;
        a((ContextWrapper) this);
    }

    public final boolean b() {
        return !this.a.getLanguage().equals("en");
    }

    public void onConfigurationChanged(Configuration configuration) {
        a(configuration);
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        super.onCreate();
        this.c = Collator.getInstance();
    }
}
