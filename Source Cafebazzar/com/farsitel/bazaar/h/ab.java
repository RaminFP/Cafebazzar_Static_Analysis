package com.farsitel.bazaar.h;

import com.farsitel.bazaar.BazaarApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab {
    public static Object a(u uVar) {
        Object obj;
        JSONObject jSONObject = null;
        if (uVar.a() > 0) {
            JSONObject b;
            try {
                b = b(uVar);
            } catch (JSONException e) {
                e.printStackTrace();
                b = jSONObject;
            }
            if (b != null) {
                try {
                    obj = b.get("result");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return obj;
    }

    public static void a(u uVar, JSONObject jSONObject) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(BazaarApplication.c().getCacheDir(), uVar.c + ".json")));
            outputStreamWriter.write(jSONObject.toString());
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONObject b(com.farsitel.bazaar.h.u r10) {
        /*
        r2 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r10.c;
        r0 = r0.append(r1);
        r1 = ".json";
        r0 = r0.append(r1);
        r1 = r0.toString();
        r3 = com.farsitel.bazaar.BazaarApplication.c();
        r4 = r10.a();
        if (r4 <= 0) goto L_0x0062;
    L_0x0020:
        r0 = new java.io.File;
        r3 = r3.getCacheDir();
        r0.<init>(r3, r1);
        r6 = java.lang.System.currentTimeMillis();
        r1 = r0.exists();
        if (r1 == 0) goto L_0x0062;
    L_0x0033:
        r8 = r0.lastModified();
        r6 = r6 - r8;
        r4 = (long) r4;
        r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r1 >= 0) goto L_0x0062;
    L_0x003d:
        if (r0 == 0) goto L_0x0061;
    L_0x003f:
        r3 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x008a, all -> 0x008d }
        r3.<init>();	 Catch:{ IOException -> 0x008a, all -> 0x008d }
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x008a, all -> 0x008d }
        r4 = new java.io.FileReader;	 Catch:{ IOException -> 0x008a, all -> 0x008d }
        r4.<init>(r0);	 Catch:{ IOException -> 0x008a, all -> 0x008d }
        r1.<init>(r4);	 Catch:{ IOException -> 0x008a, all -> 0x008d }
    L_0x004e:
        r0 = r1.readLine();	 Catch:{ IOException -> 0x0058 }
        if (r0 == 0) goto L_0x0064;
    L_0x0054:
        r3.append(r0);	 Catch:{ IOException -> 0x0058 }
        goto L_0x004e;
    L_0x0058:
        r0 = move-exception;
    L_0x0059:
        r0.printStackTrace();	 Catch:{ all -> 0x007d }
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r1.close();	 Catch:{ IOException -> 0x0078 }
    L_0x0061:
        return r2;
    L_0x0062:
        r0 = r2;
        goto L_0x003d;
    L_0x0064:
        r0 = new org.json.JSONObject;	 Catch:{ IOException -> 0x0058 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0058 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x0058 }
        r1.close();	 Catch:{ IOException -> 0x0072 }
        r2 = r0;
        goto L_0x0061;
    L_0x0072:
        r1 = move-exception;
        r1.printStackTrace();
        r2 = r0;
        goto L_0x0061;
    L_0x0078:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0061;
    L_0x007d:
        r0 = move-exception;
        r2 = r1;
    L_0x007f:
        if (r2 == 0) goto L_0x0084;
    L_0x0081:
        r2.close();	 Catch:{ IOException -> 0x0085 }
    L_0x0084:
        throw r0;
    L_0x0085:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0084;
    L_0x008a:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0059;
    L_0x008d:
        r0 = move-exception;
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.h.ab.b(com.farsitel.bazaar.h.u):org.json.JSONObject");
    }
}
