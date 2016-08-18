package com.a.a.c;

import b.a.a.a.f;
import java.io.File;
import java.io.FilenameFilter;

final class ag implements Runnable {
    final /* synthetic */ ac a;

    ag(ac acVar) {
        this.a = acVar;
    }

    public final void run() {
        ac acVar = this.a;
        File[] a = this.a.a(d.a);
        File file = new File(acVar.g.j(), "invalidClsFiles");
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
            file.delete();
        }
        for (File file2 : a) {
            f.a().a("CrashlyticsCore", "Found invalid session part file: " + file2);
            String a2 = ac.a(file2);
            FilenameFilter ahVar = new ah(acVar, a2);
            f.a().a("CrashlyticsCore", "Deleting all part files for invalid session: " + a2);
            for (File file3 : acVar.a(ahVar)) {
                f.a().a("CrashlyticsCore", "Deleting session file: " + file3);
                file3.delete();
            }
        }
    }
}
