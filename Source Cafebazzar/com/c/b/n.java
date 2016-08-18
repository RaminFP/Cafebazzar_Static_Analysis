package com.c.b;

import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;

final class n extends az {
    private static final UriMatcher a;
    private final Context b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        a = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        a.addURI("com.android.contacts", "contacts/#/photo", 2);
        a.addURI("com.android.contacts", "contacts/#", 3);
        a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    n(Context context) {
        this.b = context;
    }

    public final boolean a(aw awVar) {
        Uri uri = awVar.d;
        return "content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && a.match(awVar.d) != -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.c.b.ba b(com.c.b.aw r6) {
        /*
        r5 = this;
        r1 = 0;
        r0 = r5.b;
        r2 = r0.getContentResolver();
        r0 = r6.d;
        r3 = a;
        r3 = r3.match(r0);
        switch(r3) {
            case 1: goto L_0x0027;
            case 2: goto L_0x004b;
            case 3: goto L_0x0038;
            case 4: goto L_0x004b;
            default: goto L_0x0012;
        };
    L_0x0012:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r3 = "Invalid uri: ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0027:
        r0 = android.provider.ContactsContract.Contacts.lookupContact(r2, r0);
        if (r0 != 0) goto L_0x0038;
    L_0x002d:
        r2 = r1;
    L_0x002e:
        if (r2 == 0) goto L_0x0051;
    L_0x0030:
        r0 = new com.c.b.ba;
        r1 = com.c.b.ap.DISK;
        r0.<init>(r2, r1);
    L_0x0037:
        return r0;
    L_0x0038:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 14;
        if (r3 >= r4) goto L_0x0044;
    L_0x003e:
        r0 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r2, r0);
        r2 = r0;
        goto L_0x002e;
    L_0x0044:
        r3 = 1;
        r0 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r2, r0, r3);
        r2 = r0;
        goto L_0x002e;
    L_0x004b:
        r0 = r2.openInputStream(r0);
        r2 = r0;
        goto L_0x002e;
    L_0x0051:
        r0 = r1;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.n.b(com.c.b.aw):com.c.b.ba");
    }
}
