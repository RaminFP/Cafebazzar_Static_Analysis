package b.a.a.a.a.e;

import android.support.v4.app.FragmentTransaction;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

public final class e {
    private static final String[] b = new String[0];
    private static h c = h.a;
    public final URL a;
    private HttpURLConnection d = null;
    private final String e;
    private l f;
    private boolean g;
    private boolean h = true;
    private boolean i = false;
    private int j = FragmentTransaction.TRANSIT_EXIT_MASK;
    private String k;
    private int l;

    private e(CharSequence charSequence, String str) {
        try {
            this.a = new URL(charSequence.toString());
            this.e = str;
        } catch (IOException e) {
            throw new j(e);
        }
    }

    private e a(InputStream inputStream, OutputStream outputStream) {
        return (e) new f(this, inputStream, this.h, inputStream, outputStream).call();
    }

    public static e a(CharSequence charSequence) {
        return new e(charSequence, "PUT");
    }

    public static e a(CharSequence charSequence, Map map, boolean z) {
        return new e(c(a(charSequence, map)), "GET");
    }

    private e a(String str, String str2, String str3, String str4) {
        try {
            i();
            b(str, str2, null);
            this.f.a(str4);
            return this;
        } catch (IOException e) {
            throw new j(e);
        }
    }

    private static String a(CharSequence charSequence, Map map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        if (charSequence2.indexOf(58) + 2 == charSequence2.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        int indexOf = charSequence2.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && charSequence2.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static e b(CharSequence charSequence) {
        return new e(charSequence, "DELETE");
    }

    public static e b(CharSequence charSequence, Map map, boolean z) {
        return new e(c(a(charSequence, map)), "POST");
    }

    private e b(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        c("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            c("Content-Type", str3);
        }
        return d((CharSequence) "\r\n");
    }

    private static String b(String str, String str2) {
        String str3;
        if (str == null || str.length() == 0) {
            str3 = null;
        } else {
            int length = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf == 0 || indexOf == length) {
                return null;
            }
            int i;
            int indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
                indexOf = length;
            } else {
                i = indexOf2;
                indexOf2 = indexOf;
                indexOf = i;
            }
            while (indexOf2 < indexOf) {
                int indexOf3 = str.indexOf(61, indexOf2);
                if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                    str3 = str.substring(indexOf3 + 1, indexOf).trim();
                    indexOf3 = str3.length();
                    if (indexOf3 != 0) {
                        if (indexOf3 > 2 && '\"' == str3.charAt(0) && '\"' == str3.charAt(indexOf3 - 1)) {
                            return str3.substring(1, indexOf3 - 1);
                        }
                    }
                }
                indexOf++;
                indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length;
                }
                i = indexOf2;
                indexOf2 = indexOf;
                indexOf = i;
            }
            return null;
        }
        return str3;
    }

    private e c(String str, String str2) {
        return d((CharSequence) str).d((CharSequence) ": ").d((CharSequence) str2).d((CharSequence) "\r\n");
    }

    private static String c(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new j(iOException);
            }
        } catch (IOException e2) {
            throw new j(e2);
        }
    }

    private static String c(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private e d(CharSequence charSequence) {
        try {
            h();
            this.f.a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new j(e);
        }
    }

    private String d(String str) {
        g();
        int headerFieldInt = a().getHeaderFieldInt("Content-Length", -1);
        OutputStream byteArrayOutputStream = headerFieldInt > 0 ? new ByteArrayOutputStream(headerFieldInt) : new ByteArrayOutputStream();
        try {
            a(new BufferedInputStream(e(), this.j), byteArrayOutputStream);
            return byteArrayOutputStream.toString(c(str));
        } catch (IOException e) {
            throw new j(e);
        }
    }

    private HttpURLConnection d() {
        try {
            HttpURLConnection a = this.k != null ? c.a(this.a, new Proxy(Type.HTTP, new InetSocketAddress(this.k, this.l))) : c.a(this.a);
            a.setRequestMethod(this.e);
            return a;
        } catch (IOException e) {
            throw new j(e);
        }
    }

    private InputStream e() {
        if (b() < 400) {
            try {
                InputStream inputStream = a().getInputStream();
            } catch (IOException e) {
                throw new j(e);
            }
        }
        inputStream = a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = a().getInputStream();
            } catch (IOException e2) {
                throw new j(e2);
            }
        }
        if (!this.i || !"gzip".equals(a("Content-Encoding"))) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new j(e22);
        }
    }

    private e f() {
        if (this.f != null) {
            if (this.g) {
                this.f.a("\r\n--00content0boundary00--\r\n");
            }
            if (this.h) {
                try {
                    this.f.close();
                } catch (IOException e) {
                }
            } else {
                this.f.close();
            }
            this.f = null;
        }
        return this;
    }

    private e g() {
        try {
            return f();
        } catch (IOException e) {
            throw new j(e);
        }
    }

    private e h() {
        if (this.f == null) {
            a().setDoOutput(true);
            this.f = new l(a().getOutputStream(), b(a().getRequestProperty("Content-Type"), "charset"), this.j);
        }
        return this;
    }

    private e i() {
        if (this.g) {
            this.f.a("\r\n--00content0boundary00\r\n");
        } else {
            this.g = true;
            a("Content-Type", "multipart/form-data; boundary=00content0boundary00").h();
            this.f.a("--00content0boundary00\r\n");
        }
        return this;
    }

    public final e a(String str, Number number) {
        return a(str, null, number != null ? number.toString() : null);
    }

    public final e a(String str, String str2) {
        a().setRequestProperty(str, str2);
        return this;
    }

    public final e a(String str, String str2, String str3) {
        return a(str, str2, null, str3);
    }

    public final e a(String str, String str2, String str3, File file) {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                e a = a(str, str2, str3, bufferedInputStream);
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new j(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new j(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public final e a(String str, String str2, String str3, InputStream inputStream) {
        try {
            i();
            b(str, str2, str3);
            a(inputStream, this.f);
            return this;
        } catch (IOException e) {
            throw new j(e);
        }
    }

    public final String a(String str) {
        g();
        return a().getHeaderField(str);
    }

    public final HttpURLConnection a() {
        if (this.d == null) {
            this.d = d();
        }
        return this.d;
    }

    public final int b() {
        try {
            f();
            return a().getResponseCode();
        } catch (IOException e) {
            throw new j(e);
        }
    }

    public final String c() {
        return d(b(a("Content-Type"), "charset"));
    }

    public final String toString() {
        return a().getRequestMethod() + ' ' + a().getURL();
    }
}
