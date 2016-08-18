package com.android.a.a;

import com.android.a.o;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class g implements f {
    private final h a;
    private final SSLSocketFactory b;

    public g() {
        this(null);
    }

    private g(h hVar) {
        this(null, null);
    }

    private g(h hVar, SSLSocketFactory sSLSocketFactory) {
        this.a = hVar;
        this.b = null;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    private static void a(HttpURLConnection httpURLConnection, o oVar) {
        byte[] e = oVar.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", oVar.d());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(e);
            dataOutputStream.close();
        }
    }

    public HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public final HttpResponse a(o oVar, Map map) {
        String a;
        String str = oVar.b;
        HashMap hashMap = new HashMap();
        hashMap.putAll(o.a());
        hashMap.putAll(map);
        if (this.a != null) {
            a = this.a.a();
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + str);
            }
        }
        a = str;
        URL url = new URL(a);
        HttpURLConnection a2 = a(url);
        int f = oVar.f();
        a2.setConnectTimeout(f);
        a2.setReadTimeout(f);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.b != null) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(this.b);
        }
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        switch (oVar.a) {
            case -1:
                byte[] c = oVar.c();
                if (c != null) {
                    a2.setDoOutput(true);
                    a2.setRequestMethod("POST");
                    a2.addRequestProperty("Content-Type", oVar.b());
                    DataOutputStream dataOutputStream = new DataOutputStream(a2.getOutputStream());
                    dataOutputStream.write(c);
                    dataOutputStream.close();
                    break;
                }
                break;
            case 0:
                a2.setRequestMethod("GET");
                break;
            case 1:
                a2.setRequestMethod("POST");
                a(a2, oVar);
                break;
            case 2:
                a2.setRequestMethod("PUT");
                a(a2, oVar);
                break;
            case 3:
                a2.setRequestMethod("DELETE");
                break;
            case 4:
                a2.setRequestMethod("HEAD");
                break;
            case 5:
                a2.setRequestMethod("OPTIONS");
                break;
            case 6:
                a2.setRequestMethod("TRACE");
                break;
            case 7:
                a(a2, oVar);
                a2.setRequestMethod("PATCH");
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
