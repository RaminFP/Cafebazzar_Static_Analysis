package com.c.a.a.b;

import com.c.a.y;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

abstract class a extends HttpsURLConnection {
    private final HttpURLConnection a;

    public a(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.a = httpURLConnection;
    }

    protected abstract y a();

    public void addRequestProperty(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    public void connect() {
        this.connected = true;
        this.a.connect();
    }

    public void disconnect() {
        this.a.disconnect();
    }

    public boolean getAllowUserInteraction() {
        return this.a.getAllowUserInteraction();
    }

    public String getCipherSuite() {
        y a = a();
        return a != null ? a.a : null;
    }

    public int getConnectTimeout() {
        return this.a.getConnectTimeout();
    }

    public Object getContent() {
        return this.a.getContent();
    }

    public Object getContent(Class[] clsArr) {
        return this.a.getContent(clsArr);
    }

    public String getContentEncoding() {
        return this.a.getContentEncoding();
    }

    public int getContentLength() {
        return this.a.getContentLength();
    }

    public String getContentType() {
        return this.a.getContentType();
    }

    public long getDate() {
        return this.a.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.a.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.a.getDoInput();
    }

    public boolean getDoOutput() {
        return this.a.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.a.getErrorStream();
    }

    public long getExpiration() {
        return this.a.getExpiration();
    }

    public String getHeaderField(int i) {
        return this.a.getHeaderField(i);
    }

    public String getHeaderField(String str) {
        return this.a.getHeaderField(str);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.a.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.a.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.a.getHeaderFieldKey(i);
    }

    public Map getHeaderFields() {
        return this.a.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.a.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        return this.a.getInputStream();
    }

    public boolean getInstanceFollowRedirects() {
        return this.a.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.a.getLastModified();
    }

    public Certificate[] getLocalCertificates() {
        y a = a();
        if (a != null) {
            List list = a.c;
            if (!list.isEmpty()) {
                return (Certificate[]) list.toArray(new Certificate[list.size()]);
            }
        }
        return null;
    }

    public Principal getLocalPrincipal() {
        y a = a();
        return (a == null || a.c.isEmpty()) ? null : ((X509Certificate) a.c.get(0)).getSubjectX500Principal();
    }

    public OutputStream getOutputStream() {
        return this.a.getOutputStream();
    }

    public Principal getPeerPrincipal() {
        y a = a();
        return (a == null || a.b.isEmpty()) ? null : ((X509Certificate) a.b.get(0)).getSubjectX500Principal();
    }

    public Permission getPermission() {
        return this.a.getPermission();
    }

    public int getReadTimeout() {
        return this.a.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.a.getRequestMethod();
    }

    public Map getRequestProperties() {
        return this.a.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.a.getRequestProperty(str);
    }

    public int getResponseCode() {
        return this.a.getResponseCode();
    }

    public String getResponseMessage() {
        return this.a.getResponseMessage();
    }

    public Certificate[] getServerCertificates() {
        y a = a();
        if (a != null) {
            List list = a.b;
            if (!list.isEmpty()) {
                return (Certificate[]) list.toArray(new Certificate[list.size()]);
            }
        }
        return null;
    }

    public URL getURL() {
        return this.a.getURL();
    }

    public boolean getUseCaches() {
        return this.a.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.a.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i) {
        this.a.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i) {
        this.a.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean z) {
        this.a.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.a.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.a.setDoOutput(z);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.a.setFixedLengthStreamingMode(i);
    }

    public void setIfModifiedSince(long j) {
        this.a.setIfModifiedSince(j);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.a.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i) {
        this.a.setReadTimeout(i);
    }

    public void setRequestMethod(String str) {
        this.a.setRequestMethod(str);
    }

    public void setRequestProperty(String str, String str2) {
        this.a.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.a.setUseCaches(z);
    }

    public String toString() {
        return this.a.toString();
    }

    public boolean usingProxy() {
        return this.a.usingProxy();
    }
}
