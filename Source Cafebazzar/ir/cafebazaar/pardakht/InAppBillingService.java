package ir.cafebazaar.pardakht;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class InAppBillingService extends Service {
    private IBinder a = null;

    public IBinder onBind(Intent intent) {
        if (this.a == null) {
            this.a = new g(getApplicationContext());
        }
        return this.a;
    }
}
