package com.c.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

final class q {
    final t a = new t();
    final Context b;
    final ExecutorService c;
    final v d;
    final Map e;
    final Map f;
    final Map g;
    final Set h;
    final Handler i;
    final Handler j;
    final k k;
    final bc l;
    final List m;
    final u n;
    final boolean o;
    boolean p;

    q(Context context, ExecutorService executorService, Handler handler, v vVar, k kVar, bc bcVar) {
        this.a.start();
        bj.a(this.a.getLooper());
        this.b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new r(this.a.getLooper(), this);
        this.d = vVar;
        this.j = handler;
        this.k = kVar;
        this.l = bcVar;
        this.m = new ArrayList(4);
        this.p = bj.d(this.b);
        this.o = bj.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new u(this);
        BroadcastReceiver broadcastReceiver = this.n;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (broadcastReceiver.a.o) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        broadcastReceiver.a.b.registerReceiver(broadcastReceiver, intentFilter);
    }

    private void a(a aVar) {
        Object c = aVar.c();
        if (c != null) {
            aVar.k = true;
            this.f.put(c, aVar);
        }
    }

    static void a(List list) {
        if (!list.isEmpty() && ((d) list.get(0)).b.n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (d dVar : list) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(bj.a(dVar));
            }
            bj.a("Dispatcher", "delivered", stringBuilder.toString());
        }
    }

    private void e(d dVar) {
        a aVar = dVar.k;
        if (aVar != null) {
            a(aVar);
        }
        List list = dVar.l;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a((a) list.get(i));
            }
        }
    }

    final void a(NetworkInfo networkInfo) {
        if (this.c instanceof au) {
            au auVar = (au) this.c;
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                switch (networkInfo.getType()) {
                    case 0:
                        switch (networkInfo.getSubtype()) {
                            case 1:
                            case 2:
                                auVar.a(1);
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 12:
                                auVar.a(2);
                                break;
                            case 13:
                            case 14:
                            case 15:
                                auVar.a(3);
                                break;
                            default:
                                auVar.a(3);
                                break;
                        }
                    case 1:
                    case 6:
                    case 9:
                        auVar.a(4);
                        break;
                    default:
                        auVar.a(3);
                        break;
                }
            }
            auVar.a(3);
        }
        if (networkInfo != null && networkInfo.isConnected() && !this.f.isEmpty()) {
            Iterator it = this.f.values().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                it.remove();
                if (aVar.a.n) {
                    bj.a("Dispatcher", "replaying", aVar.b.a());
                }
                a(aVar, false);
            }
        }
    }

    final void a(a aVar, boolean z) {
        if (this.h.contains(aVar.j)) {
            this.g.put(aVar.c(), aVar);
            if (aVar.a.n) {
                bj.a("Dispatcher", "paused", aVar.b.a(), "because tag '" + aVar.j + "' is paused");
                return;
            }
            return;
        }
        d dVar = (d) this.e.get(aVar.i);
        if (dVar != null) {
            boolean z2 = dVar.b.n;
            aw awVar = aVar.b;
            if (dVar.k == null) {
                dVar.k = aVar;
                if (!z2) {
                    return;
                }
                if (dVar.l == null || dVar.l.isEmpty()) {
                    bj.a("Hunter", "joined", awVar.a(), "to empty hunter");
                    return;
                } else {
                    bj.a("Hunter", "joined", awVar.a(), bj.a(dVar, "to "));
                    return;
                }
            }
            if (dVar.l == null) {
                dVar.l = new ArrayList(3);
            }
            dVar.l.add(aVar);
            if (z2) {
                bj.a("Hunter", "joined", awVar.a(), bj.a(dVar, "to "));
            }
            int i = aVar.b.r;
            if (i - 1 > dVar.s - 1) {
                dVar.s = i;
            }
        } else if (!this.c.isShutdown()) {
            Object a = d.a(aVar.a, this, this.k, this.l, aVar);
            a.n = this.c.submit(a);
            this.e.put(aVar.i, a);
            if (z) {
                this.f.remove(aVar.c());
            }
            if (aVar.a.n) {
                bj.a("Dispatcher", "enqueued", aVar.b.a());
            }
        } else if (aVar.a.n) {
            bj.a("Dispatcher", "ignored", aVar.b.a(), "because shut down");
        }
    }

    final void a(d dVar) {
        this.i.sendMessageDelayed(this.i.obtainMessage(5, dVar), 500);
    }

    final void a(d dVar, boolean z) {
        if (dVar.b.n) {
            bj.a("Dispatcher", "batched", bj.a(dVar), "for error" + (z ? " (will replay)" : ""));
        }
        this.e.remove(dVar.f);
        d(dVar);
    }

    final void a(Object obj) {
        if (this.h.remove(obj)) {
            Iterator it = this.g.values().iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.j.equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(aVar);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.j.sendMessage(this.j.obtainMessage(13, obj2));
            }
        }
    }

    final void b(d dVar) {
        this.i.sendMessage(this.i.obtainMessage(6, dVar));
    }

    final void c(d dVar) {
        boolean z = true;
        if (!dVar.b()) {
            if (this.c.isShutdown()) {
                a(dVar, false);
                return;
            }
            NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) bj.a(this.b, "connectivity")).getActiveNetworkInfo() : null;
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            boolean z3 = this.p;
            if (dVar.r > 0) {
                dVar.r--;
                z3 = dVar.j.a(activeNetworkInfo);
            } else {
                z3 = false;
            }
            boolean b = dVar.j.b();
            if (!z3) {
                if (!(this.o && b)) {
                    z = false;
                }
                a(dVar, z);
                if (z) {
                    e(dVar);
                }
            } else if (!this.o || z2) {
                if (dVar.b.n) {
                    bj.a("Dispatcher", "retrying", bj.a(dVar));
                }
                if (dVar.p instanceof ah) {
                    dVar.i |= af.NO_CACHE.d;
                }
                dVar.n = this.c.submit(dVar);
            } else {
                a(dVar, b);
                if (b) {
                    e(dVar);
                }
            }
        }
    }

    void d(d dVar) {
        if (!dVar.b()) {
            this.m.add(dVar);
            if (!this.i.hasMessages(7)) {
                this.i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }
}
