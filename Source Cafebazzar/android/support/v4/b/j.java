package android.support.v4.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

public final class j {
    private static final Object f = new Object();
    private static j g;
    private final Context a;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final ArrayList d = new ArrayList();
    private final Handler e;

    private j(Context context) {
        this.a = context;
        this.e = new k(this, context.getMainLooper());
    }

    public static j a(Context context) {
        j jVar;
        synchronized (f) {
            if (g == null) {
                g = new j(context.getApplicationContext());
            }
            jVar = g;
        }
        return jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(android.support.v4.b.j r8) {
        /*
        r2 = 0;
    L_0x0001:
        r1 = r8.b;
        monitor-enter(r1);
        r0 = r8.d;	 Catch:{ all -> 0x003f }
        r0 = r0.size();	 Catch:{ all -> 0x003f }
        if (r0 > 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        return;
    L_0x000e:
        r4 = new android.support.v4.b.l[r0];	 Catch:{ all -> 0x003f }
        r0 = r8.d;	 Catch:{ all -> 0x003f }
        r0.toArray(r4);	 Catch:{ all -> 0x003f }
        r0 = r8.d;	 Catch:{ all -> 0x003f }
        r0.clear();	 Catch:{ all -> 0x003f }
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        r3 = r2;
    L_0x001c:
        r0 = r4.length;
        if (r3 >= r0) goto L_0x0001;
    L_0x001f:
        r5 = r4[r3];
        r1 = r2;
    L_0x0022:
        r0 = r5.b;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0042;
    L_0x002a:
        r0 = r5.b;
        r0 = r0.get(r1);
        r0 = (android.support.v4.b.m) r0;
        r0 = r0.b;
        r6 = r8.a;
        r7 = r5.a;
        r0.onReceive(r6, r7);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0022;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        throw r0;
    L_0x0042:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.j.a(android.support.v4.b.j):void");
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            ArrayList arrayList = (ArrayList) this.b.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.c.get(action);
                    if (arrayList2 != null) {
                        int i3 = 0;
                        while (i3 < arrayList2.size()) {
                            int i4;
                            if (((m) arrayList2.get(i3)).b == broadcastReceiver) {
                                arrayList2.remove(i3);
                                i4 = i3 - 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4 + 1;
                        }
                        if (arrayList2.size() <= 0) {
                            this.c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            m mVar = new m(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                arrayList = (ArrayList) this.c.get(action);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.c.put(action, arrayList);
                }
                arrayList.add(mVar);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Intent r17) {
        /*
        r16 = this;
        r0 = r16;
        r13 = r0.b;
        monitor-enter(r13);
        r2 = r17.getAction();	 Catch:{ all -> 0x00ef }
        r0 = r16;
        r1 = r0.a;	 Catch:{ all -> 0x00ef }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x00ef }
        r0 = r17;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x00ef }
        r5 = r17.getData();	 Catch:{ all -> 0x00ef }
        r4 = r17.getScheme();	 Catch:{ all -> 0x00ef }
        r6 = r17.getCategories();	 Catch:{ all -> 0x00ef }
        r1 = r17.getFlags();	 Catch:{ all -> 0x00ef }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x014b;
    L_0x002b:
        r1 = 1;
        r12 = r1;
    L_0x002d:
        if (r12 == 0) goto L_0x0059;
    L_0x002f:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ef }
        r8 = "Resolving type ";
        r7.<init>(r8);	 Catch:{ all -> 0x00ef }
        r7 = r7.append(r3);	 Catch:{ all -> 0x00ef }
        r8 = " scheme ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x00ef }
        r7 = r7.append(r4);	 Catch:{ all -> 0x00ef }
        r8 = " of intent ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x00ef }
        r0 = r17;
        r7 = r7.append(r0);	 Catch:{ all -> 0x00ef }
        r7 = r7.toString();	 Catch:{ all -> 0x00ef }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x00ef }
    L_0x0059:
        r0 = r16;
        r1 = r0.c;	 Catch:{ all -> 0x00ef }
        r7 = r17.getAction();	 Catch:{ all -> 0x00ef }
        r1 = r1.get(r7);	 Catch:{ all -> 0x00ef }
        r0 = r1;
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x00ef }
        r8 = r0;
        if (r8 == 0) goto L_0x0146;
    L_0x006b:
        if (r12 == 0) goto L_0x0081;
    L_0x006d:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ef }
        r9 = "Action list: ";
        r7.<init>(r9);	 Catch:{ all -> 0x00ef }
        r7 = r7.append(r8);	 Catch:{ all -> 0x00ef }
        r7 = r7.toString();	 Catch:{ all -> 0x00ef }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x00ef }
    L_0x0081:
        r10 = 0;
        r1 = 0;
        r11 = r1;
    L_0x0084:
        r1 = r8.size();	 Catch:{ all -> 0x00ef }
        if (r11 >= r1) goto L_0x015b;
    L_0x008a:
        r1 = r8.get(r11);	 Catch:{ all -> 0x00ef }
        r0 = r1;
        r0 = (android.support.v4.b.m) r0;	 Catch:{ all -> 0x00ef }
        r9 = r0;
        if (r12 == 0) goto L_0x00aa;
    L_0x0094:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ef }
        r14 = "Matching against filter ";
        r7.<init>(r14);	 Catch:{ all -> 0x00ef }
        r14 = r9.a;	 Catch:{ all -> 0x00ef }
        r7 = r7.append(r14);	 Catch:{ all -> 0x00ef }
        r7 = r7.toString();	 Catch:{ all -> 0x00ef }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x00ef }
    L_0x00aa:
        r1 = r9.c;	 Catch:{ all -> 0x00ef }
        if (r1 == 0) goto L_0x00bd;
    L_0x00ae:
        if (r12 == 0) goto L_0x010d;
    L_0x00b0:
        r1 = "LocalBroadcastManager";
        r7 = "  Filter's target already added";
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x00ef }
        r1 = r10;
    L_0x00b8:
        r7 = r11 + 1;
        r10 = r1;
        r11 = r7;
        goto L_0x0084;
    L_0x00bd:
        r1 = r9.a;	 Catch:{ all -> 0x00ef }
        r7 = "LocalBroadcastManager";
        r1 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00ef }
        if (r1 < 0) goto L_0x00f2;
    L_0x00c7:
        if (r12 == 0) goto L_0x00e1;
    L_0x00c9:
        r7 = "LocalBroadcastManager";
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ef }
        r15 = "  Filter matched!  match=0x";
        r14.<init>(r15);	 Catch:{ all -> 0x00ef }
        r1 = java.lang.Integer.toHexString(r1);	 Catch:{ all -> 0x00ef }
        r1 = r14.append(r1);	 Catch:{ all -> 0x00ef }
        r1 = r1.toString();	 Catch:{ all -> 0x00ef }
        android.util.Log.v(r7, r1);	 Catch:{ all -> 0x00ef }
    L_0x00e1:
        if (r10 != 0) goto L_0x0149;
    L_0x00e3:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00ef }
        r1.<init>();	 Catch:{ all -> 0x00ef }
    L_0x00e8:
        r1.add(r9);	 Catch:{ all -> 0x00ef }
        r7 = 1;
        r9.c = r7;	 Catch:{ all -> 0x00ef }
        goto L_0x00b8;
    L_0x00ef:
        r1 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x00ef }
        throw r1;
    L_0x00f2:
        if (r12 == 0) goto L_0x010d;
    L_0x00f4:
        switch(r1) {
            case -4: goto L_0x0152;
            case -3: goto L_0x014f;
            case -2: goto L_0x0155;
            case -1: goto L_0x0158;
            default: goto L_0x00f7;
        };
    L_0x00f7:
        r1 = "unknown reason";
    L_0x00f9:
        r7 = "LocalBroadcastManager";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ef }
        r14 = "  Filter did not match: ";
        r9.<init>(r14);	 Catch:{ all -> 0x00ef }
        r1 = r9.append(r1);	 Catch:{ all -> 0x00ef }
        r1 = r1.toString();	 Catch:{ all -> 0x00ef }
        android.util.Log.v(r7, r1);	 Catch:{ all -> 0x00ef }
    L_0x010d:
        r1 = r10;
        goto L_0x00b8;
    L_0x010f:
        r1 = r10.size();	 Catch:{ all -> 0x00ef }
        if (r2 >= r1) goto L_0x0122;
    L_0x0115:
        r1 = r10.get(r2);	 Catch:{ all -> 0x00ef }
        r1 = (android.support.v4.b.m) r1;	 Catch:{ all -> 0x00ef }
        r3 = 0;
        r1.c = r3;	 Catch:{ all -> 0x00ef }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x010f;
    L_0x0122:
        r0 = r16;
        r1 = r0.d;	 Catch:{ all -> 0x00ef }
        r2 = new android.support.v4.b.l;	 Catch:{ all -> 0x00ef }
        r0 = r17;
        r2.<init>(r0, r10);	 Catch:{ all -> 0x00ef }
        r1.add(r2);	 Catch:{ all -> 0x00ef }
        r0 = r16;
        r1 = r0.e;	 Catch:{ all -> 0x00ef }
        r2 = 1;
        r1 = r1.hasMessages(r2);	 Catch:{ all -> 0x00ef }
        if (r1 != 0) goto L_0x0143;
    L_0x013b:
        r0 = r16;
        r1 = r0.e;	 Catch:{ all -> 0x00ef }
        r2 = 1;
        r1.sendEmptyMessage(r2);	 Catch:{ all -> 0x00ef }
    L_0x0143:
        monitor-exit(r13);	 Catch:{ all -> 0x00ef }
        r1 = 1;
    L_0x0145:
        return r1;
    L_0x0146:
        monitor-exit(r13);	 Catch:{ all -> 0x00ef }
        r1 = 0;
        goto L_0x0145;
    L_0x0149:
        r1 = r10;
        goto L_0x00e8;
    L_0x014b:
        r1 = 0;
        r12 = r1;
        goto L_0x002d;
    L_0x014f:
        r1 = "action";
        goto L_0x00f9;
    L_0x0152:
        r1 = "category";
        goto L_0x00f9;
    L_0x0155:
        r1 = "data";
        goto L_0x00f9;
    L_0x0158:
        r1 = "type";
        goto L_0x00f9;
    L_0x015b:
        if (r10 == 0) goto L_0x0146;
    L_0x015d:
        r1 = 0;
        r2 = r1;
        goto L_0x010f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.j.a(android.content.Intent):boolean");
    }
}
