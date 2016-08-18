package com.farsitel.bazaar.c.a;

import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager.WakeLock;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.a.i;
import com.farsitel.bazaar.g.j;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;

public final class g extends Thread {
    private static final BazaarApplication e = BazaarApplication.c();
    File a;
    long b;
    protected h c;
    InetAddress d;
    private final ArrayList f = new ArrayList();
    private WakeLock g = null;
    private WifiLock h = null;
    private long i;
    private BigInteger j;
    private boolean k = false;

    public g(String str, File file, String str2, BigInteger bigInteger, long j, boolean z, h hVar) {
        int i = 0;
        if (str != null && !str.equals("")) {
            String[] split = str.split(";");
            while (i < split.length) {
                if (z) {
                    this.f.add(i.b(split[i], str2));
                } else {
                    this.f.add(i.a(split[i], str2));
                }
                i++;
            }
        } else if (z) {
            this.f.add(i.b(j.a().l(), str2));
        } else {
            this.f.add(i.a(j.a().l(), str2));
        }
        this.a = file;
        this.i = j;
        this.j = bigInteger;
        this.c = hVar;
    }

    private HttpURLConnection a(String str, long j) {
        URL url = new URL(str);
        String host = url.getHost();
        InetAddress[] allByName = InetAddress.getAllByName(host);
        int length = allByName.length;
        int i = 0;
        while (i < length) {
            InetAddress inetAddress = allByName[i];
            this.d = inetAddress;
            String hostAddress = inetAddress.getHostAddress();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url.getProtocol(), hostAddress, url.getPort(), url.getFile()).openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.addRequestProperty("Host", host);
                if (j > 0) {
                    httpURLConnection.addRequestProperty("Range", "bytes=" + j + "-");
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 206 || responseCode == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                    this.c.c(hostAddress);
                    return httpURLConnection;
                }
                throw new IOException("Response code: " + responseCode);
            } catch (SocketTimeoutException e) {
            } catch (InterruptedIOException e2) {
                throw e2;
            } catch (IOException e3) {
            }
        }
        throw new MalformedURLException();
        i++;
    }

    private void a(int i) {
        this.c.b(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r11, boolean r12) {
        /*
        r10 = this;
        r4 = 0;
        r3 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r10.isInterrupted();
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return r2;
    L_0x000c:
        r0 = com.farsitel.bazaar.util.t.a();
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        r10.b = r4;
    L_0x0014:
        r4 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r5 = new byte[r4];
        r6 = r10.b;	 Catch:{ InterruptedIOException -> 0x0048, Exception -> 0x004a }
        r6 = r10.a(r11, r6);	 Catch:{ InterruptedIOException -> 0x0048, Exception -> 0x004a }
        r4 = r6.getResponseCode();	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        r7 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r4 != r7) goto L_0x004d;
    L_0x0026:
        r4 = r1;
    L_0x0027:
        if (r0 == 0) goto L_0x004f;
    L_0x0029:
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        r7 = r10.a;	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        r0.<init>(r7, r4);	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        r3 = r0;
    L_0x0031:
        if (r4 != 0) goto L_0x0037;
    L_0x0033:
        r8 = 0;
        r10.b = r8;	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
    L_0x0037:
        r0 = r10.isInterrupted();	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        if (r0 == 0) goto L_0x005f;
    L_0x003d:
        if (r3 == 0) goto L_0x000b;
    L_0x003f:
        r3.close();	 Catch:{ IOException -> 0x0043 }
        goto L_0x000b;
    L_0x0043:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x000b;
    L_0x0048:
        r0 = move-exception;
        throw r0;
    L_0x004a:
        r0 = move-exception;
        r2 = r1;
        goto L_0x000b;
    L_0x004d:
        r4 = r2;
        goto L_0x0027;
    L_0x004f:
        r0 = com.farsitel.bazaar.BazaarApplication.c();	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        r7 = r10.a;	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        r7 = r7.getName();	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        r8 = 1;
        r3 = r0.openFileOutput(r7, r8);	 Catch:{ FileNotFoundException -> 0x00f3, IOException -> 0x00b8, Exception -> 0x00ce }
        goto L_0x0031;
    L_0x005f:
        r0 = 13;
        r10.a(r0);	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r4 = r6.getInputStream();	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r0 = r10.c;	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r0.f();	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r0 = r1;
    L_0x006e:
        if (r0 <= 0) goto L_0x0098;
    L_0x0070:
        r0 = r10.isInterrupted();	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        if (r0 != 0) goto L_0x0098;
    L_0x0076:
        r0 = r4.read(r5);	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        if (r0 <= 0) goto L_0x006e;
    L_0x007c:
        r6 = 0;
        r3.write(r5, r6, r0);	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r6 = r10.b;	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r8 = (long) r0;	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r6 = r6 + r8;
        r10.b = r6;	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        goto L_0x006e;
    L_0x0087:
        r0 = move-exception;
        r2 = r3;
    L_0x0089:
        r0.printStackTrace();	 Catch:{ all -> 0x00f0 }
        r0 = 4;
        r10.a(r0);	 Catch:{ all -> 0x00f0 }
        if (r2 == 0) goto L_0x0095;
    L_0x0092:
        r2.close();	 Catch:{ IOException -> 0x00b3 }
    L_0x0095:
        r2 = r1;
        goto L_0x000b;
    L_0x0098:
        r3.close();	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        r0 = r10.isInterrupted();	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        if (r0 != 0) goto L_0x00b1;
    L_0x00a1:
        r0 = r1;
    L_0x00a2:
        r10.k = r0;	 Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x00b8, Exception -> 0x00ce }
        if (r3 == 0) goto L_0x000b;
    L_0x00a6:
        r3.close();	 Catch:{ IOException -> 0x00ab }
        goto L_0x000b;
    L_0x00ab:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x000b;
    L_0x00b1:
        r0 = r2;
        goto L_0x00a2;
    L_0x00b3:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0095;
    L_0x00b8:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00e4 }
        com.farsitel.bazaar.service.AppDownloadService.c();	 Catch:{ all -> 0x00e4 }
        r0 = 4;
        r10.a(r0);	 Catch:{ all -> 0x00e4 }
        if (r3 == 0) goto L_0x0095;
    L_0x00c5:
        r3.close();	 Catch:{ IOException -> 0x00c9 }
        goto L_0x0095;
    L_0x00c9:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0095;
    L_0x00ce:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00e4 }
        com.farsitel.bazaar.service.AppDownloadService.c();	 Catch:{ all -> 0x00e4 }
        r0 = 4;
        r10.a(r0);	 Catch:{ all -> 0x00e4 }
        if (r3 == 0) goto L_0x0095;
    L_0x00db:
        r3.close();	 Catch:{ IOException -> 0x00df }
        goto L_0x0095;
    L_0x00df:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0095;
    L_0x00e4:
        r0 = move-exception;
    L_0x00e5:
        if (r3 == 0) goto L_0x00ea;
    L_0x00e7:
        r3.close();	 Catch:{ IOException -> 0x00eb }
    L_0x00ea:
        throw r0;
    L_0x00eb:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00ea;
    L_0x00f0:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00e5;
    L_0x00f3:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.c.a.g.a(java.lang.String, boolean):boolean");
    }

    public final long a() {
        return this.i - this.b;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:80)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r1 = 0;
        r0 = r6.g;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 != 0) goto L_0x001e;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0005:
        r0 = e;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = "power";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.getSystemService(r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (android.os.PowerManager) r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = 1;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r3 = "Bazaar_Installable";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.newWakeLock(r2, r3);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r6.g = r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.g;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = 1;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0.setReferenceCounted(r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x001e:
        r0 = r6.g;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0.acquire();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = e;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = "wifi";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.getSystemService(r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = r6.h;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r2 != 0) goto L_0x0047;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0031:
        if (r0 == 0) goto L_0x0047;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0033:
        r2 = r0.isWifiEnabled();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r2 == 0) goto L_0x0047;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0039:
        r2 = "Bazaar_Installable_Wifi";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.createWifiLock(r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r6.h = r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.h;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = 1;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0.setReferenceCounted(r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0047:
        r0 = r6.h;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 == 0) goto L_0x0050;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x004b:
        r0 = r6.h;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0.acquire();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0050:
        r2 = 0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r6.b = r2;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.a;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.exists();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 == 0) goto L_0x0078;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x005c:
        r0 = r6.a;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.canRead();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 == 0) goto L_0x0078;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0064:
        r0 = r6.a;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = r0.length();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r4 = r6.i;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 >= 0) goto L_0x0078;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0070:
        r0 = r6.a;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = r0.length();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r6.b = r2;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0078:
        r0 = r6.f;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.size();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r1 >= r0) goto L_0x0097;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0080:
        r0 = r6.f;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.get(r1);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (java.lang.String) r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = 1;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.a(r0, r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = r6.k;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r2 != 0) goto L_0x0097;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0091:
        if (r0 == 0) goto L_0x0097;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0093:
        r0 = r1 + 1;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1 = r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        goto L_0x0078;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0097:
        r0 = r6.k;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 == 0) goto L_0x01e3;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x009b:
        r0 = r6.b;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = r6.i;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 == 0) goto L_0x00e0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x00a3:
        r0 = 4;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r6.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.b;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = 100;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 <= 0) goto L_0x00bd;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x00af:
        r0 = com.farsitel.bazaar.BazaarApplication.c();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1 = 2131165426; // 0x7f0700f2 float:1.7945069E38 double:1.0529356226E-314;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.getString(r1);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        com.farsitel.bazaar.activity.ErrorDialogActivity.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x00bd:
        r0 = r6.g;
        if (r0 == 0) goto L_0x00ce;
    L_0x00c1:
        r0 = r6.g;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x00ce;
    L_0x00c9:
        r0 = r6.g;
        r0.release();
    L_0x00ce:
        r0 = r6.h;
        if (r0 == 0) goto L_0x00df;
    L_0x00d2:
        r0 = r6.h;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x00df;
    L_0x00da:
        r0 = r6.h;
        r0.release();
    L_0x00df:
        return;
    L_0x00e0:
        r0 = r6.a;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1 = r6.j;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = com.farsitel.bazaar.c.a.a.a(r0, r1);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 != 0) goto L_0x011f;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x00ea:
        r0 = 4;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r6.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = com.farsitel.bazaar.BazaarApplication.c();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1 = 2131165426; // 0x7f0700f2 float:1.7945069E38 double:1.0529356226E-314;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.getString(r1);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        com.farsitel.bazaar.activity.ErrorDialogActivity.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.g;
        if (r0 == 0) goto L_0x010d;
    L_0x0100:
        r0 = r6.g;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x010d;
    L_0x0108:
        r0 = r6.g;
        r0.release();
    L_0x010d:
        r0 = r6.h;
        if (r0 == 0) goto L_0x00df;
    L_0x0111:
        r0 = r6.h;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x00df;
    L_0x0119:
        r0 = r6.h;
        r0.release();
        goto L_0x00df;
    L_0x011f:
        r0 = 3;
        r6.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1 = com.a.a.a.a.c();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = new com.a.a.a.t;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = "App Downloaded";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0.<init>(r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = r6.i;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r4 = r0.b;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r5 = "size";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r4.a(r5, r2);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (com.a.a.a.t) r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = "network type";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r3 = com.farsitel.bazaar.util.q.g();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.a(r2, r3);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (com.a.a.a.t) r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = "operator";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r3 = com.farsitel.bazaar.util.q.a();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.a(r2, r3);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = (com.a.a.a.t) r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r0 != 0) goto L_0x0189;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x0157:
        r0 = new java.lang.NullPointerException;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1 = "event must not be null";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0.<init>(r1);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        throw r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x015f:
        r0 = move-exception;
        r0 = 11;
        r6.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.g;
        if (r0 == 0) goto L_0x0176;
    L_0x0169:
        r0 = r6.g;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x0176;
    L_0x0171:
        r0 = r6.g;
        r0.release();
    L_0x0176:
        r0 = r6.h;
        if (r0 == 0) goto L_0x00df;
    L_0x017a:
        r0 = r6.h;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x00df;
    L_0x0182:
        r0 = r6.h;
        r0.release();
        goto L_0x00df;
    L_0x0189:
        r2 = r1.a;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        if (r2 == 0) goto L_0x01bf;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x018d:
        r1 = r1.a;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = b.a.a.a.f.a();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r3 = "Answers";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r5 = "Logged custom event: ";	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r4.<init>(r5);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r4 = r4.append(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r4 = r4.toString();	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2.a(r3, r4);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1 = r1.b;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2 = new com.a.a.a.al;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r3 = com.a.a.a.am.CUSTOM;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2.<init>(r3);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r3 = r0.c;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2.d = r3;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.b;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r0.b;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r2.e = r0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = 0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r3 = 0;	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r1.a(r2, r0, r3);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
    L_0x01bf:
        r0 = r6.g;
        if (r0 == 0) goto L_0x01d0;
    L_0x01c3:
        r0 = r6.g;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x01d0;
    L_0x01cb:
        r0 = r6.g;
        r0.release();
    L_0x01d0:
        r0 = r6.h;
        if (r0 == 0) goto L_0x00df;
    L_0x01d4:
        r0 = r6.h;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x00df;
    L_0x01dc:
        r0 = r6.h;
        r0.release();
        goto L_0x00df;
    L_0x01e3:
        r0 = 4;
        r6.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        goto L_0x01bf;
    L_0x01e8:
        r0 = move-exception;
        r0 = 4;
        r6.a(r0);	 Catch:{ InterruptedIOException -> 0x015f, Exception -> 0x01e8, all -> 0x0211 }
        r0 = r6.g;
        if (r0 == 0) goto L_0x01fe;
    L_0x01f1:
        r0 = r6.g;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x01fe;
    L_0x01f9:
        r0 = r6.g;
        r0.release();
    L_0x01fe:
        r0 = r6.h;
        if (r0 == 0) goto L_0x00df;
    L_0x0202:
        r0 = r6.h;
        r0 = r0.isHeld();
        if (r0 == 0) goto L_0x00df;
    L_0x020a:
        r0 = r6.h;
        r0.release();
        goto L_0x00df;
    L_0x0211:
        r0 = move-exception;
        r1 = r6.g;
        if (r1 == 0) goto L_0x0223;
    L_0x0216:
        r1 = r6.g;
        r1 = r1.isHeld();
        if (r1 == 0) goto L_0x0223;
    L_0x021e:
        r1 = r6.g;
        r1.release();
    L_0x0223:
        r1 = r6.h;
        if (r1 == 0) goto L_0x0234;
    L_0x0227:
        r1 = r6.h;
        r1 = r1.isHeld();
        if (r1 == 0) goto L_0x0234;
    L_0x022f:
        r1 = r6.h;
        r1.release();
    L_0x0234:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.c.a.g.run():void");
    }
}
