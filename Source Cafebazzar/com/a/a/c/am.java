package com.a.a.c;

import b.a.a.a.a.b.l;
import b.a.a.a.f;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

final class am implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ ac d;

    am(ac acVar, String str, String str2, String str3) {
        this.d = acVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    private Void a() {
        Closeable bufferedWriter;
        Throwable e;
        Closeable closeable = null;
        String b = this.d.c();
        be beVar = new be(this.d.g());
        ce ceVar = new ce(this.a, this.b, this.c);
        File c = beVar.c(b);
        try {
            String a = be.a(ceVar);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c), be.a));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                l.a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    f.a().c("CrashlyticsCore", "Error serializing user metadata.", e);
                    l.a(bufferedWriter, "Failed to close user metadata file.");
                    return null;
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    l.a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            f.a().c("CrashlyticsCore", "Error serializing user metadata.", e);
            l.a(bufferedWriter, "Failed to close user metadata file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            l.a(closeable, "Failed to close user metadata file.");
            throw e;
        }
        return null;
    }

    public final /* synthetic */ Object call() {
        return a();
    }
}
