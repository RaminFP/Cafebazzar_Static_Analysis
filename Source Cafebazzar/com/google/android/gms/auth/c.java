package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.a.b;
import com.google.android.gms.auth.firstparty.shared.d;
import java.io.IOException;

final class c implements d {
    final /* synthetic */ Account a;
    final /* synthetic */ String b;
    final /* synthetic */ Bundle c;

    c(Account account, String str, Bundle bundle) {
        this.a = account;
        this.b = str;
        this.c = bundle;
    }

    public final /* synthetic */ Object a(IBinder iBinder) {
        Bundle bundle = (Bundle) b.a(b.a(iBinder).a(this.a, this.b, this.c));
        TokenData a = TokenData.a(bundle, "tokenDetails");
        if (a != null) {
            return a;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        d a2 = d.a(string);
        if (d.a(a2)) {
            throw new f(string, intent);
        } else if (d.b(a2)) {
            throw new IOException(string);
        } else {
            throw new a(string);
        }
    }
}
