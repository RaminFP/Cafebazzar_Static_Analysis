package com.android.a.a;

import com.android.a.c;
import com.android.a.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

final class d {
    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public Map g;

    private d() {
    }

    public d(String str, c cVar) {
        this.b = str;
        this.a = (long) cVar.a.length;
        this.c = cVar.b;
        this.d = cVar.c;
        this.e = cVar.d;
        this.f = cVar.e;
        this.g = cVar.f;
    }

    public static d a(InputStream inputStream) {
        d dVar = new d();
        if (c.a(inputStream) != 538051844) {
            throw new IOException();
        }
        dVar.b = c.c(inputStream);
        dVar.c = c.c(inputStream);
        if (dVar.c.equals("")) {
            dVar.c = null;
        }
        dVar.d = c.b(inputStream);
        dVar.e = c.b(inputStream);
        dVar.f = c.b(inputStream);
        dVar.g = c.d(inputStream);
        return dVar;
    }

    public final boolean a(OutputStream outputStream) {
        try {
            c.a(outputStream, 538051844);
            c.a(outputStream, this.b);
            c.a(outputStream, this.c == null ? "" : this.c);
            c.a(outputStream, this.d);
            c.a(outputStream, this.e);
            c.a(outputStream, this.f);
            Map map = this.g;
            if (map != null) {
                c.a(outputStream, map.size());
                for (Entry entry : map.entrySet()) {
                    c.a(outputStream, (String) entry.getKey());
                    c.a(outputStream, (String) entry.getValue());
                }
            } else {
                c.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            z.b("%s", e.toString());
            return false;
        }
    }
}
