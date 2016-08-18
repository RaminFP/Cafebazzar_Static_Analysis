package com.a.a.c;

import b.a.a.a.a.b.l;
import b.a.a.a.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

final class be {
    static final Charset a = Charset.forName("UTF-8");
    private final File b;

    public be(File file) {
        this.b = file;
    }

    static String a(ce ceVar) {
        return new bf(ceVar).toString();
    }

    static String a(Map map) {
        return new JSONObject(map).toString();
    }

    private static String a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }

    private static Map e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Map hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, a(jSONObject, str2));
        }
        return hashMap;
    }

    public final ce a(String str) {
        Throwable e;
        Closeable closeable = null;
        File c = c(str);
        if (!c.exists()) {
            return ce.a;
        }
        try {
            Closeable fileInputStream = new FileInputStream(c);
            try {
                JSONObject jSONObject = new JSONObject(l.a((InputStream) fileInputStream));
                ce ceVar = new ce(a(jSONObject, "userId"), a(jSONObject, "userName"), a(jSONObject, "userEmail"));
                l.a(fileInputStream, "Failed to close user metadata file.");
                return ceVar;
            } catch (Exception e2) {
                e = e2;
                closeable = fileInputStream;
                try {
                    f.a().c("CrashlyticsCore", "Error deserializing user metadata.", e);
                    l.a(closeable, "Failed to close user metadata file.");
                    return ce.a;
                } catch (Throwable th) {
                    e = th;
                    l.a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                closeable = fileInputStream;
                l.a(closeable, "Failed to close user metadata file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            f.a().c("CrashlyticsCore", "Error deserializing user metadata.", e);
            l.a(closeable, "Failed to close user metadata file.");
            return ce.a;
        } catch (Throwable th3) {
            e = th3;
            l.a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    public final Map b(String str) {
        Throwable e;
        Closeable closeable = null;
        File d = d(str);
        if (!d.exists()) {
            return Collections.emptyMap();
        }
        try {
            Closeable fileInputStream = new FileInputStream(d);
            try {
                Map e2 = e(l.a((InputStream) fileInputStream));
                l.a(fileInputStream, "Failed to close user metadata file.");
                return e2;
            } catch (Exception e3) {
                e = e3;
                closeable = fileInputStream;
                try {
                    f.a().c("CrashlyticsCore", "Error deserializing user metadata.", e);
                    l.a(closeable, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    l.a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                closeable = fileInputStream;
                l.a(closeable, "Failed to close user metadata file.");
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            f.a().c("CrashlyticsCore", "Error deserializing user metadata.", e);
            l.a(closeable, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th3) {
            e = th3;
            l.a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    File c(String str) {
        return new File(this.b, str + "user.meta");
    }

    File d(String str) {
        return new File(this.b, str + "keys.meta");
    }
}
