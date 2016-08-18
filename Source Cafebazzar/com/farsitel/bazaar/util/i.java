package com.farsitel.bazaar.util;

import android.location.Address;
import android.location.Geocoder;
import com.farsitel.bazaar.BazaarApplication;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

final class i extends Thread {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        try {
            h.a(this.a);
            if (this.a.b == 0.0d) {
                h.c(this.a);
            }
            if (this.a.b != 0.0d) {
                try {
                    List fromLocation = new Geocoder(BazaarApplication.c(), Locale.ENGLISH).getFromLocation(this.a.b, this.a.c, 1);
                    if (!(fromLocation == null || fromLocation.isEmpty())) {
                        this.a.d = ((Address) fromLocation.get(0)).getLocality();
                        this.a.e = ((Address) fromLocation.get(0)).getAdminArea();
                        this.a.f = ((Address) fromLocation.get(0)).getCountryName();
                        this.a.g = !((Address) fromLocation.get(0)).getCountryCode().toLowerCase().equals("ir");
                        this.a.f();
                    }
                } catch (IOException e) {
                }
            }
            this.a.h = Calendar.getInstance().getTimeInMillis();
        } catch (Exception e2) {
        }
    }
}
