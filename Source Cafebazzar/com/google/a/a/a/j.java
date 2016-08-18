package com.google.a.a.a;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

final class j implements n {
    private static j a;
    private static final Object b = new Object();
    private final Context c;
    private String d;
    private boolean e = false;
    private final Object f = new Object();

    private j(Context context) {
        this.c = context;
        new k(this, "client_id_fetcher").start();
    }

    public static j a() {
        j jVar;
        synchronized (b) {
            jVar = a;
        }
        return jVar;
    }

    public static void a(Context context) {
        synchronized (b) {
            if (a == null) {
                a = new j(context);
            }
        }
    }

    private boolean b(String str) {
        try {
            as.c("Storing clientId.");
            FileOutputStream openFileOutput = this.c.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            as.a("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            as.a("Error writing to clientId file.");
            return false;
        }
    }

    private String c() {
        if (!this.e) {
            synchronized (this.f) {
                if (!this.e) {
                    as.c("Waiting for clientId to load");
                    do {
                        try {
                            this.f.wait();
                        } catch (InterruptedException e) {
                            as.a("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.e);
                }
            }
        }
        as.c("Loaded clientId");
        return this.d;
    }

    public final String a(String str) {
        return "&cid".equals(str) ? c() : null;
    }

    final String b() {
        String str;
        try {
            FileInputStream openFileInput = this.c.openFileInput("gaClientId");
            byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
            int read = openFileInput.read(bArr, 0, NotificationCompat.FLAG_HIGH_PRIORITY);
            if (openFileInput.available() > 0) {
                as.a("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.c.deleteFile("gaClientId");
                str = null;
            } else if (read <= 0) {
                as.a("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.c.deleteFile("gaClientId");
                str = null;
            } else {
                str = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException e) {
                } catch (IOException e2) {
                    as.a("Error reading clientId file, deleting it.");
                    this.c.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
            str = null;
        } catch (IOException e4) {
            str = null;
            as.a("Error reading clientId file, deleting it.");
            this.c.deleteFile("gaClientId");
        }
        if (str != null) {
            return str;
        }
        str = UUID.randomUUID().toString().toLowerCase();
        return !b(str) ? "0" : str;
    }
}
