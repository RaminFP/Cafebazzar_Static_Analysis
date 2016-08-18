package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

final class af implements Runnable {
    final /* synthetic */ ac a;
    private final URL b;
    private final byte[] c;
    private final ad d;

    public af(ac acVar, URL url, byte[] bArr, ad adVar) {
        this.a = acVar;
        this.b = url;
        this.c = bArr;
        this.d = adVar;
    }

    public final void run() {
        Throwable th;
        int i;
        OutputStream outputStream;
        Throwable th2;
        this.a.d();
        HttpURLConnection httpURLConnection;
        int responseCode;
        try {
            byte[] a = this.a.j().a(this.c);
            ac acVar = this.a;
            URLConnection openConnection = this.b.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDefaultUseCaches(false);
                i.u();
                httpURLConnection.setConnectTimeout(60000);
                i.v();
                httpURLConnection.setReadTimeout(61000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoInput(true);
                try {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(a.length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(a);
                        outputStream2.close();
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (Throwable e) {
                        th = e;
                        i = 0;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                                this.a.l().a.a("Error closing HTTP compressed POST connection output stream", e2);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.a.k().a(new ae(this.d, i, th, null));
                    } catch (Throwable e3) {
                        th2 = e3;
                        outputStream = outputStream2;
                        responseCode = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e22) {
                                this.a.l().a.a("Error closing HTTP compressed POST connection output stream", e22);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.a.k().a(new ae(this.d, responseCode, null, null));
                        throw th2;
                    }
                } catch (Throwable e32) {
                    th = e32;
                    i = 0;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.a.k().a(new ae(this.d, i, th, null));
                } catch (Throwable e322) {
                    th2 = e322;
                    responseCode = 0;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.a.k().a(new ae(this.d, responseCode, null, null));
                    throw th2;
                }
                try {
                    ac acVar2 = this.a;
                    byte[] a2 = ac.a(httpURLConnection);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.a.k().a(new ae(this.d, responseCode, null, a2));
                    return;
                } catch (Throwable e3222) {
                    th = e3222;
                    i = responseCode;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.a.k().a(new ae(this.d, i, th, null));
                } catch (Throwable e32222) {
                    th2 = e32222;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.a.k().a(new ae(this.d, responseCode, null, null));
                    throw th2;
                }
            }
            throw new IOException("Failed to obtain HTTP connection");
        } catch (Throwable e4) {
            th = e4;
            outputStream = null;
            i = 0;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.a.k().a(new ae(this.d, i, th, null));
        } catch (Throwable e42) {
            th2 = e42;
            outputStream = null;
            responseCode = 0;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.a.k().a(new ae(this.d, responseCode, null, null));
            throw th2;
        }
    }
}
