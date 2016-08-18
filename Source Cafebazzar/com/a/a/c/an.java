package com.a.a.c;

import b.a.a.a.a.b.l;
import b.a.a.a.f;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.Callable;

final class an implements Callable {
    final /* synthetic */ Map a;
    final /* synthetic */ ac b;

    an(ac acVar, Map map) {
        this.b = acVar;
        this.a = map;
    }

    private Void a() {
        Throwable e;
        Closeable closeable = null;
        String b = this.b.c();
        be beVar = new be(this.b.g());
        Map map = this.a;
        File d = beVar.d(b);
        Closeable bufferedWriter;
        try {
            String a = be.a(map);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d), be.a));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                l.a(bufferedWriter, "Failed to close key/value metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    f.a().c("CrashlyticsCore", "Error serializing key/value metadata.", e);
                    l.a(bufferedWriter, "Failed to close key/value metadata file.");
                    return null;
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    l.a(closeable, "Failed to close key/value metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            f.a().c("CrashlyticsCore", "Error serializing key/value metadata.", e);
            l.a(bufferedWriter, "Failed to close key/value metadata file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            l.a(closeable, "Failed to close key/value metadata file.");
            throw e;
        }
        return null;
    }

    public final /* synthetic */ Object call() {
        return a();
    }
}
