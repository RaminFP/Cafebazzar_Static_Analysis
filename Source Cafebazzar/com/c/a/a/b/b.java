package com.c.a.a.b;

import com.c.a.a.a.af;
import com.c.a.a.a.m;
import com.c.a.a.a.o;
import com.c.a.a.a.s;
import com.c.a.a.a.u;
import com.c.a.a.a.x;
import com.c.a.a.k;
import com.c.a.a.q;
import com.c.a.a.v;
import com.c.a.aa;
import com.c.a.ag;
import com.c.a.ak;
import com.c.a.al;
import com.c.a.am;
import com.c.a.an;
import com.c.a.ao;
import com.c.a.ap;
import com.c.a.as;
import com.c.a.r;
import com.c.a.y;
import com.c.a.z;
import d.ab;
import d.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class b extends HttpURLConnection {
    private static final Set e = new LinkedHashSet(Arrays.asList(new String[]{"OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"}));
    private static final an f;
    final ag a;
    protected IOException b;
    protected o c;
    y d;
    private aa g = new aa();
    private long h = -1;
    private int i;
    private z j;
    private as k;

    static {
        byte[] bArr = new byte[0];
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        v.a((long) bArr.length, 0, (long) null);
        f = new ao(null, 0, bArr, 0);
    }

    public b(URL url, ag agVar) {
        super(url);
        this.a = agVar;
    }

    private o a(String str, r rVar, com.c.a.a.a.z zVar, ap apVar) {
        am a = new am().a(getURL()).a(str, s.b(str) ? f : null);
        z a2 = this.g.a();
        int length = a2.a.length / 2;
        for (int i = 0; i < length; i++) {
            a.b(a2.a(i), a2.b(i));
        }
        boolean z = false;
        boolean z2 = false;
        if (s.c(str)) {
            if (this.h != -1) {
                a.a("Content-Length", Long.toString(this.h));
            } else if (this.chunkLength > 0) {
                a.a("Transfer-Encoding", "chunked");
            } else {
                z2 = true;
            }
            if (a2.a("Content-Type") == null) {
                a.a("Content-Type", "application/x-www-form-urlencoded");
                z = z2;
            } else {
                z = z2;
            }
        }
        if (a2.a("User-Agent") == null) {
            String property = System.getProperty("http.agent");
            if (property == null) {
                property = "Java" + System.getProperty("java.version");
            }
            a.a("User-Agent", property);
        }
        al a3 = a.a();
        ag agVar = this.a;
        if (!(k.b.a(agVar) == null || getUseCaches())) {
            agVar = this.a.b().a(null);
        }
        return new o(agVar, a3, z, true, false, rVar, null, zVar, apVar);
    }

    private z a() {
        if (this.j == null) {
            ap f = c().f();
            aa a = f.f.a();
            StringBuilder stringBuilder = new StringBuilder();
            q.a();
            String stringBuilder2 = stringBuilder.append(q.b()).append("-Response-Source").toString();
            String str = f.h == null ? f.i == null ? "NONE" : "CACHE " + f.c : f.i == null ? "NETWORK " + f.c : "CONDITIONAL_CACHE " + f.h.c;
            this.j = a.a(stringBuilder2, str).a();
        }
        return this.j;
    }

    private void a(String str, boolean z) {
        List arrayList = new ArrayList();
        if (z) {
            arrayList.addAll(this.a.d);
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                arrayList.add(ak.a(split[i]));
                i++;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        ag agVar = this.a;
        arrayList = v.a(arrayList);
        if (!arrayList.contains(ak.HTTP_1_1)) {
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
        } else if (arrayList.contains(ak.HTTP_1_0)) {
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
        } else if (arrayList.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        } else {
            agVar.d = v.a(arrayList);
        }
    }

    private boolean a(boolean z) {
        IOException a;
        o a2;
        try {
            this.c.a();
            this.k = this.c.c;
            this.d = this.c.b != null ? this.c.b.i : null;
            if (z) {
                this.c.i();
            }
            return true;
        } catch (x e) {
            a = e.a();
            this.b = a;
            throw a;
        } catch (com.c.a.a.a.aa e2) {
            a2 = this.c.a(e2);
            if (a2 != null) {
                this.c = a2;
                return false;
            }
            a = e2.b;
            this.b = a;
            throw a;
        } catch (IOException e3) {
            a2 = this.c;
            a2 = a2.a(e3, a2.h);
            if (a2 != null) {
                this.c = a2;
                return false;
            }
            this.b = e3;
            throw e3;
        }
    }

    private void b() {
        if (this.b != null) {
            throw this.b;
        } else if (this.c == null) {
            this.connected = true;
            try {
                if (this.doOutput) {
                    if (this.method.equals("GET")) {
                        this.method = "POST";
                    } else if (!s.c(this.method)) {
                        throw new ProtocolException(this.method + " does not support writing");
                    }
                }
                this.c = a(this.method, null, null, null);
            } catch (IOException e) {
                this.b = e;
                throw e;
            }
        }
    }

    private o c() {
        b();
        if (this.c.e()) {
            return this.c;
        }
        while (true) {
            if (a(true)) {
                ap f = this.c.f();
                al j = this.c.j();
                if (j == null) {
                    this.c.g();
                    return this.c;
                }
                int i = this.i + 1;
                this.i = i;
                if (i > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + this.i);
                }
                this.url = j.a();
                this.g = j.c.a();
                ab d = this.c.d();
                if (!j.b.equals(this.method)) {
                    d = null;
                }
                if (d == null || (d instanceof com.c.a.a.a.z)) {
                    if (!this.c.b(j.a())) {
                        this.c.g();
                    }
                    this.c = a(j.b, this.c.h(), (com.c.a.a.a.z) d, f);
                } else {
                    throw new HttpRetryException("Cannot retry streamed HTTP body", this.responseCode);
                }
            }
        }
    }

    public final void addRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            q.a();
            q.a("Ignoring header " + str + " because its value was null.");
        } else if ("X-Android-Transports".equals(str) || "X-Android-Protocols".equals(str)) {
            a(str2, true);
        } else {
            this.g.a(str, str2);
        }
    }

    public final void connect() {
        b();
        do {
        } while (!a(false));
    }

    public final void disconnect() {
        if (this.c != null) {
            o oVar = this.c;
            if (oVar.d != null) {
                try {
                    oVar.d.a(oVar);
                } catch (IOException e) {
                }
            }
        }
    }

    public final int getConnectTimeout() {
        return this.a.t;
    }

    public final InputStream getErrorStream() {
        InputStream inputStream = null;
        try {
            o c = c();
            if (o.a(c.f()) && c.f().c >= 400) {
                inputStream = c.f().g.c();
            }
        } catch (IOException e) {
        }
        return inputStream;
    }

    public final String getHeaderField(int i) {
        try {
            return a().b(i);
        } catch (IOException e) {
            return null;
        }
    }

    public final String getHeaderField(String str) {
        if (str != null) {
            return a().a(str);
        }
        try {
            return af.a(c().f()).toString();
        } catch (IOException e) {
            return null;
        }
    }

    public final String getHeaderFieldKey(int i) {
        try {
            return a().a(i);
        } catch (IOException e) {
            return null;
        }
    }

    public final Map getHeaderFields() {
        try {
            return u.a(a(), af.a(c().f()).toString());
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    public final InputStream getInputStream() {
        if (this.doInput) {
            o c = c();
            if (getResponseCode() < 400) {
                return c.f().g.c();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public final OutputStream getOutputStream() {
        connect();
        o oVar = this.c;
        i iVar = oVar.i;
        if (iVar == null) {
            ab d = oVar.d();
            if (d != null) {
                iVar = d.r.a(d);
                oVar.i = iVar;
            } else {
                iVar = null;
            }
        }
        if (iVar == null) {
            throw new ProtocolException("method does not support a request body: " + this.method);
        } else if (!this.c.e()) {
            return iVar.c();
        } else {
            throw new ProtocolException("cannot write request body after response has been read");
        }
    }

    public final Permission getPermission() {
        String host = getURL().getHost();
        int a = v.a(getURL());
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.a.c.address();
            String hostName = inetSocketAddress.getHostName();
            a = inetSocketAddress.getPort();
            host = hostName;
        }
        return new SocketPermission(host + ":" + a, "connect, resolve");
    }

    public final int getReadTimeout() {
        return this.a.u;
    }

    public final Map getRequestProperties() {
        if (!this.connected) {
            return u.a(this.g.a(), null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public final String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        aa aaVar = this.g;
        for (int size = aaVar.a.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase((String) aaVar.a.get(size))) {
                return (String) aaVar.a.get(size + 1);
            }
        }
        return null;
    }

    public final int getResponseCode() {
        return c().f().c;
    }

    public final String getResponseMessage() {
        return c().f().d;
    }

    public final void setConnectTimeout(int i) {
        this.a.a((long) i, TimeUnit.MILLISECONDS);
    }

    public final void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode((long) i);
    }

    public final void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (j < 0) {
            throw new IllegalArgumentException("contentLength < 0");
        } else {
            this.h = j;
            this.fixedContentLength = (int) Math.min(j, 2147483647L);
        }
    }

    public final void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        if (this.ifModifiedSince != 0) {
            this.g.b("If-Modified-Since", m.a(new Date(this.ifModifiedSince)));
        } else {
            this.g.b("If-Modified-Since");
        }
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.a.r = z;
    }

    public final void setReadTimeout(int i) {
        this.a.b((long) i, TimeUnit.MILLISECONDS);
    }

    public final void setRequestMethod(String str) {
        if (e.contains(str)) {
            this.method = str;
            return;
        }
        throw new ProtocolException("Expected one of " + e + " but was " + str);
    }

    public final void setRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            q.a();
            q.a("Ignoring header " + str + " because its value was null.");
        } else if ("X-Android-Transports".equals(str) || "X-Android-Protocols".equals(str)) {
            a(str2, false);
        } else {
            this.g.b(str, str2);
        }
    }

    public final boolean usingProxy() {
        Proxy proxy = this.k != null ? this.k.b : this.a.c;
        return (proxy == null || proxy.type() == Type.DIRECT) ? false : true;
    }
}
