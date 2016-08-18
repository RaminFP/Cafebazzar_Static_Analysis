package com.farsitel.bazaar.util;

import android.content.Intent;
import android.support.v4.b.j;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.c.a.a;
import com.farsitel.bazaar.g.a.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class x {
    private static ArrayList a = new ArrayList();

    public static a a() {
        return !a.isEmpty() ? (a) a.get(0) : null;
    }

    public static a a(String str) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(a aVar) {
        a.add(0, aVar);
        g();
    }

    public static void a(ArrayList arrayList) {
        a.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            a.add(new a(iVar.g(), iVar.h(), iVar.a(), "resume_all", com.farsitel.bazaar.c.b.a.a().a(iVar.g())));
        }
        g();
    }

    public static void b(a aVar) {
        a.add(aVar);
        g();
    }

    public static boolean b() {
        if (!a.isEmpty()) {
            a aVar = (a) a.get(0);
            if (aVar.i == 13 || aVar.i == 14) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).a.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList c() {
        return a;
    }

    public static void c(a aVar) {
        a.remove(aVar);
        g();
    }

    public static boolean d() {
        return a.isEmpty();
    }

    public static void e() {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.c();
            aVar.i = 11;
        }
        a.clear();
        g();
    }

    public static long f() {
        Iterator it = a.iterator();
        long j = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            j = aVar.i == 13 ? (aVar.e() - aVar.d()) + j : j;
        }
        return j;
    }

    private static void g() {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.DOWNLOAD_QUEUE_CHANGE");
        intent.putExtra("downloading_cunt_in_queue", !a.isEmpty());
        j.a(BazaarApplication.c()).a(intent);
    }
}
