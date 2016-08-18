package com.c.a.a.d;

import android.support.v4.app.NotificationCompat;
import d.j;
import d.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

final class m implements b {
    final h a = new h(4096, this.c);
    private final j b;
    private final k c = new k(this.b);
    private final boolean d;

    m(j jVar, int i, boolean z) {
        this.b = jVar;
        this.d = z;
    }

    private List a(int i, short s, byte b, int i2) {
        k kVar = this.c;
        this.c.d = i;
        kVar.a = i;
        this.c.e = s;
        this.c.b = b;
        this.c.c = i2;
        h hVar = this.a;
        while (!hVar.b.e()) {
            int g = hVar.b.g() & 255;
            if (g == NotificationCompat.FLAG_HIGH_PRIORITY) {
                throw new IOException("index == 0");
            } else if ((g & NotificationCompat.FLAG_HIGH_PRIORITY) == NotificationCompat.FLAG_HIGH_PRIORITY) {
                g = hVar.a(g, 127) - 1;
                if (h.c(g)) {
                    hVar.a.add(g.a[g]);
                } else {
                    int a = hVar.a(g - g.a.length);
                    if (a < 0 || a > hVar.e.length - 1) {
                        throw new IOException("Header index too large " + (g + 1));
                    }
                    hVar.a.add(hVar.e[a]);
                }
            } else if (g == 64) {
                hVar.a(-1, new e(g.a(hVar.b()), hVar.b()));
            } else if ((g & 64) == 64) {
                hVar.a(-1, new e(hVar.b(hVar.a(g, 63) - 1), hVar.b()));
            } else if ((g & 32) == 32) {
                hVar.d = hVar.a(g, 31);
                if (hVar.d < 0 || hVar.d > hVar.c) {
                    throw new IOException("Invalid dynamic table size update " + hVar.d);
                }
                hVar.a();
            } else if (g == 16 || g == 0) {
                hVar.a.add(new e(g.a(hVar.b()), hVar.b()));
            } else {
                hVar.a.add(new e(hVar.b(hVar.a(g, 15) - 1), hVar.b()));
            }
        }
        hVar = this.a;
        List arrayList = new ArrayList(hVar.a);
        hVar.a.clear();
        return arrayList;
    }

    private void a(c cVar, int i) {
        this.b.i();
        this.b.g();
    }

    public final void a() {
        if (!this.d) {
            k c = this.b.c((long) j.b.c.length);
            if (j.a.isLoggable(Level.FINE)) {
                j.a.fine(String.format("<< CONNECTION %s", new Object[]{c.b()}));
            }
            if (!j.b.equals(c)) {
                throw j.c("Expected a connection header but was %s", c.a());
            }
        }
    }

    public final boolean a(c cVar) {
        boolean z = false;
        try {
            this.b.a(9);
            int a = ((((this.b.g() & 255) << 16) | ((this.b.g() & 255) << 8)) | (this.b.g() & 255));
            if (a < 0 || a > 16384) {
                throw j.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte g = this.b.g();
            byte g2 = this.b.g();
            int i = this.b.i() & Integer.MAX_VALUE;
            if (j.a.isLoggable(Level.FINE)) {
                j.a.fine(l.a(true, i, a, g, g2));
            }
            short g3;
            int h;
            switch (g) {
                case (byte) 0:
                    boolean z2 = (g2 & 1) != 0;
                    if ((g2 & 32) != 0) {
                        throw j.c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                    }
                    if ((g2 & 8) != 0) {
                        g3 = (short) (this.b.g() & 255);
                    }
                    cVar.a(z2, i, this.b, j.a(a, g2, g3));
                    this.b.f((long) g3);
                    return true;
                case (byte) 1:
                    if (i == 0) {
                        throw j.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                    }
                    boolean z3 = (g2 & 1) != 0;
                    short g4 = (g2 & 8) != 0 ? (short) (this.b.g() & 255) : (short) 0;
                    if ((g2 & 32) != 0) {
                        a(cVar, i);
                        a -= 5;
                    }
                    cVar.a(false, z3, i, a(j.a(a, g2, g4), g4, g2, i), f.HTTP_20_HEADERS);
                    return true;
                case (byte) 2:
                    if (a != 5) {
                        throw j.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(a));
                    } else if (i == 0) {
                        throw j.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                    } else {
                        a(cVar, i);
                        return true;
                    }
                case (byte) 3:
                    if (a != 4) {
                        throw j.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(a));
                    } else if (i == 0) {
                        throw j.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                    } else {
                        a b = a.b(this.b.i());
                        if (b == null) {
                            throw j.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(a));
                        }
                        cVar.a(i, b);
                        return true;
                    }
                case (byte) 4:
                    if (i == 0) {
                        if ((g2 & 1) != 0) {
                            if (a != 0) {
                                throw j.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                            }
                        } else if (a % 6 != 0) {
                            throw j.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(a));
                        } else {
                            y yVar = new y();
                            for (i = 0; i < a; i += 6) {
                                h = this.b.h();
                                int i2 = this.b.i();
                                switch (h) {
                                    case 1:
                                    case 6:
                                        break;
                                    case 2:
                                        if (!(i2 == 0 || i2 == 1)) {
                                            throw j.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                        }
                                    case 3:
                                        h = 4;
                                        break;
                                    case 4:
                                        h = 7;
                                        if (i2 >= 0) {
                                            break;
                                        }
                                        throw j.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    case 5:
                                        if (i2 >= 16384 && i2 <= 16777215) {
                                            break;
                                        }
                                        throw j.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i2));
                                    default:
                                        throw j.c("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(h));
                                }
                                yVar.a(h, 0, i2);
                            }
                            cVar.a(false, yVar);
                            if (yVar.a() >= 0) {
                                h hVar = this.a;
                                int a2 = yVar.a();
                                hVar.c = a2;
                                hVar.d = a2;
                                hVar.a();
                                return true;
                            }
                        }
                        z = true;
                        break;
                    }
                    throw j.c("TYPE_SETTINGS streamId != 0", new Object[0]);
                    break;
                case (byte) 5:
                    if (i == 0) {
                        throw j.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                    }
                    if ((g2 & 8) != 0) {
                        g3 = (short) (this.b.g() & 255);
                    }
                    cVar.a(this.b.i() & Integer.MAX_VALUE, a(j.a(a - 4, g2, g3), g3, g2, i));
                    return true;
                case (byte) 6:
                    if (a != 8) {
                        throw j.c("TYPE_PING length != 8: %s", Integer.valueOf(a));
                    } else if (i != 0) {
                        throw j.c("TYPE_PING streamId != 0", new Object[0]);
                    } else {
                        a = this.b.i();
                        h = this.b.i();
                        if ((g2 & 1) != 0) {
                            z = true;
                        }
                        cVar.a(z, a, h);
                        return true;
                    }
                case (byte) 7:
                    if (a < 8) {
                        throw j.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(a));
                    } else if (i != 0) {
                        throw j.c("TYPE_GOAWAY streamId != 0", new Object[0]);
                    } else {
                        h = this.b.i();
                        int i3 = a - 8;
                        if (a.b(this.b.i()) == null) {
                            throw j.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.b.i()));
                        }
                        k kVar = k.b;
                        if (i3 > 0) {
                            kVar = this.b.c((long) i3);
                        }
                        cVar.a(h, kVar);
                        return true;
                    }
                case (byte) 8:
                    if (a != 4) {
                        throw j.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(a));
                    }
                    long i4 = ((long) this.b.i()) & 2147483647L;
                    if (i4 == 0) {
                        throw j.c("windowSizeIncrement was 0", Long.valueOf(i4));
                    }
                    cVar.a(i, i4);
                    return true;
                default:
                    this.b.f((long) a);
                    return true;
            }
            return z;
        } catch (IOException e) {
        }
    }

    public final void close() {
        this.b.close();
    }
}
