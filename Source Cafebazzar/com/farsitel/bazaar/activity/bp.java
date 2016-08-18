package com.farsitel.bazaar.activity;

import android.accounts.Account;
import android.os.AsyncTask;
import com.farsitel.bazaar.h.a.p;
import com.google.android.gms.auth.a;
import com.google.android.gms.auth.b;
import com.google.android.gms.auth.f;
import com.google.android.gms.plus.d;
import java.io.IOException;

final class bp extends AsyncTask {
    final /* synthetic */ JoinActivity a;

    bp(JoinActivity joinActivity) {
        this.a = joinActivity;
    }

    private String a() {
        try {
            return b.a(this.a.getApplicationContext(), new Account(d.h.a(this.a.f), "com.google"), "audience:server:client_id:683351534335-50d94qavithm437jchm8uc25rtkh0p50.apps.googleusercontent.com");
        } catch (f e) {
            e.printStackTrace();
            return "";
        } catch (a e2) {
            e2.printStackTrace();
            return "";
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        new p(str).a(this.a.o);
    }
}
