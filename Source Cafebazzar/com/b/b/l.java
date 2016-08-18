package com.b.b;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class l extends bk {
    static int a = 15000;
    private static final String i = l.class.getSimpleName();
    String b;
    String c;
    String d;
    byte[] e;
    u f;

    public l(String str, String str2, String str3, byte[] bArr, u uVar) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bArr;
        this.f = uVar;
    }

    public final void a() {
        HttpClient defaultHttpClient;
        HttpResponse execute;
        Throwable e;
        HttpClient httpClient = null;
        Thread.currentThread().setName("DataSender Sending Executor Thread, id = " + Long.valueOf(Thread.currentThread().getId()));
        try {
            HttpEntity byteArrayEntity = new ByteArrayEntity(this.e);
            byteArrayEntity.setContentType("application/octet-stream");
            HttpUriRequest httpPost = new HttpPost(this.b);
            httpPost.setEntity(byteArrayEntity);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, a);
            httpPost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
            defaultHttpClient = new DefaultHttpClient(new SingleClientConnManager(basicHttpParams, az.a()), basicHttpParams);
            try {
                execute = defaultHttpClient.execute(httpPost);
                defaultHttpClient.getConnectionManager().shutdown();
            } catch (Exception e2) {
                e = e2;
                try {
                    ba.a(6, i, "Exception: ", e);
                    if (defaultHttpClient != null) {
                        defaultHttpClient.getConnectionManager().shutdown();
                    }
                    if (execute != null) {
                    }
                    this.f.a(this.c, this.d);
                    return;
                } catch (Throwable th) {
                    e = th;
                    httpClient = defaultHttpClient;
                    if (httpClient != null) {
                        httpClient.getConnectionManager().shutdown();
                    }
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            defaultHttpClient = httpClient;
            ba.a(6, i, "Exception: ", e);
            if (defaultHttpClient != null) {
                defaultHttpClient.getConnectionManager().shutdown();
            }
            if (execute != null) {
            }
            this.f.a(this.c, this.d);
            return;
        } catch (Throwable th2) {
            e = th2;
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
            throw e;
        }
        if (execute != null || execute.getStatusLine() == null) {
            this.f.a(this.c, this.d);
            return;
        }
        StatusLine statusLine = execute.getStatusLine();
        this.f.a(statusLine.getStatusCode(), statusLine.getReasonPhrase(), this.c, this.d);
    }
}
