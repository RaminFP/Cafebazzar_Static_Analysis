package b.a.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import b.a.a.a.a.b.l;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class k implements Callable {
    final String a;

    k(String str) {
        this.a = str;
    }

    private static r a(ZipEntry zipEntry, ZipFile zipFile) {
        Throwable e;
        Closeable closeable = null;
        Closeable inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                r rVar = new r(property, property2, property3);
                l.a(inputStream);
                return rVar;
            } catch (IOException e2) {
                e = e2;
                try {
                    f.a().c("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    l.a(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    closeable = inputStream;
                    l.a(closeable);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            f.a().c("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            l.a(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            l.a(closeable);
            throw e;
        }
    }

    private Map a() {
        Map hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile zipFile = new ZipFile(this.a);
        Enumeration entries = zipFile.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > 7) {
                r a = a(zipEntry, zipFile);
                if (a != null) {
                    hashMap.put(a.a, a);
                    f.a().b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.a, a.b}));
                }
            }
            i++;
        }
        try {
            zipFile.close();
        } catch (IOException e) {
        }
        f.a().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    public final /* synthetic */ Object call() {
        return a();
    }
}
