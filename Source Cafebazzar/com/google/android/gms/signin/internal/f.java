package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface f extends IInterface {
    void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult);

    void a(Status status);

    void a(Status status, GoogleSignInAccount googleSignInAccount);

    void b(Status status);
}
