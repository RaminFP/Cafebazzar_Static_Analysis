package d;

final class aa {
    static z a;
    static long b;

    private aa() {
    }

    static z a() {
        synchronized (aa.class) {
            try {
                if (a != null) {
                    z zVar = a;
                    a = zVar.f;
                    z zVar2 = null;
                    zVar.f = null;
                    b -= 2048;
                    return zVar;
                }
            } finally {
                while (true) {
                    break;
                }
                zVar2 = aa.class;
            }
        }
        return new z();
    }

    static void a(z zVar) {
        if (zVar.f != null || zVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!zVar.d) {
            synchronized (aa.class) {
                try {
                    Object obj = ((b + 2048) > 65536 ? 1 : ((b + 2048) == 65536 ? 0 : -1));
                    if (obj > null) {
                        return;
                    }
                    b += 2048;
                    zVar.f = a;
                    zVar.c = 0;
                    zVar.b = 0;
                    a = zVar;
                } finally {
                    Class cls = aa.class;
                }
            }
        }
    }
}
