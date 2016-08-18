package com.farsitel.bazaar.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LoginCheckService extends Service {
    public IBinder onBind(Intent intent) {
        return new g(this);
    }
}
