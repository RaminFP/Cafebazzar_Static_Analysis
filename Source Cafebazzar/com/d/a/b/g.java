package com.d.a.b;

import com.d.a.a;

final class g implements Runnable {
    final /* synthetic */ d a;

    g(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        a aVar = null;
        while (!this.a.g) {
            try {
                d.b = false;
                String readLine = this.a.d.readLine();
                d.b = true;
                if (readLine == null) {
                    break;
                }
                if (aVar == null) {
                    if (this.a.n < this.a.f.size()) {
                        aVar = (a) this.a.f.get(this.a.n);
                    } else if (this.a.g) {
                        break;
                    }
                }
                int indexOf = readLine.indexOf("F*D^W@#FGF");
                if (indexOf == -1) {
                    aVar.a(aVar.n, readLine);
                }
                if (indexOf > 0) {
                    aVar.a(aVar.n, readLine.substring(0, indexOf));
                }
                if (indexOf >= 0) {
                    String[] split = readLine.substring(indexOf).split(" ");
                    if (split.length >= 2 && split[1] != null) {
                        int parseInt;
                        try {
                            indexOf = Integer.parseInt(split[1]);
                        } catch (NumberFormatException e) {
                            indexOf = 0;
                        }
                        try {
                            parseInt = Integer.parseInt(split[2]);
                        } catch (NumberFormatException e2) {
                            parseInt = -1;
                        }
                        if (indexOf == this.a.q) {
                            aVar.a(parseInt);
                            aVar.b();
                            this.a.n = this.a.n + 1;
                            this.a.q = this.a.q + 1;
                            aVar = null;
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e3) {
                a.a(e3.getMessage(), 2, e3);
                return;
            }
        }
        a.a("Read all output");
        try {
            this.a.c.waitFor();
            this.a.c.destroy();
        } catch (Exception e4) {
        }
        d.a(this.a.e);
        d.a(this.a.d);
        a.a("Shell destroyed");
        while (this.a.n < this.a.f.size()) {
            if (aVar == null) {
                aVar = (a) this.a.f.get(this.a.n);
            }
            aVar.b("Unexpected Termination.");
            this.a.n = this.a.n + 1;
            aVar = null;
        }
        this.a.n = 0;
    }
}
