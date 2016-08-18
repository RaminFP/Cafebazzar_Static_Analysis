package b.a.a.a.a.g;

import b.a.a.a.a.b.l;
import b.a.a.a.a.f.b;
import b.a.a.a.f;
import b.a.a.a.p;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

final class i implements g {
    private final p a;

    public i(p pVar) {
        this.a = pVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject;
        Throwable th;
        Closeable closeable;
        Throwable th2;
        Closeable closeable2 = null;
        f.a().a("Fabric", "Reading cached settings...");
        try {
            Closeable fileInputStream;
            File file = new File(new b(this.a).a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(l.a((InputStream) fileInputStream));
                } catch (Throwable e) {
                    th = e;
                    closeable = fileInputStream;
                    th2 = th;
                    try {
                        f.a().c("Fabric", "Failed to fetch cached settings", th2);
                        l.a(closeable, "Error while closing settings cache file.");
                        return jSONObject;
                    } catch (Throwable th3) {
                        th2 = th3;
                        closeable2 = closeable;
                        l.a(closeable2, "Error while closing settings cache file.");
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    closeable2 = fileInputStream;
                    th2 = th;
                    l.a(closeable2, "Error while closing settings cache file.");
                    throw th2;
                }
            }
            f.a().a("Fabric", "No cached settings found.");
            fileInputStream = null;
            l.a(fileInputStream, "Error while closing settings cache file.");
        } catch (Exception e2) {
            th2 = e2;
            closeable = null;
            f.a().c("Fabric", "Failed to fetch cached settings", th2);
            l.a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Throwable th5) {
            th2 = th5;
            l.a(closeable2, "Error while closing settings cache file.");
            throw th2;
        }
        return jSONObject;
    }

    public final void a(long j, JSONObject jSONObject) {
        Closeable fileWriter;
        Throwable e;
        Throwable th;
        Throwable th2;
        Closeable closeable = null;
        f.a().a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new b(this.a).a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    l.a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        f.a().c("Fabric", "Failed to cache settings", e);
                        l.a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable e3) {
                        th = e3;
                        closeable = fileWriter;
                        th2 = th;
                        l.a(closeable, "Failed to close settings writer.");
                        throw th2;
                    }
                }
            } catch (Throwable th22) {
                th = th22;
                fileWriter = null;
                e3 = th;
                f.a().c("Fabric", "Failed to cache settings", e3);
                l.a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th3) {
                th22 = th3;
                l.a(closeable, "Failed to close settings writer.");
                throw th22;
            }
        }
    }
}
