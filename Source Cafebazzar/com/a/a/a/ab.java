package com.a.a.a;

import b.a.a.a.a.c.a.a;
import java.util.Random;

final class ab implements a {
    final a a;
    final Random b;
    final double c;

    public ab(a aVar, double d) {
        this(aVar, 0.1d, new Random());
    }

    private ab(a aVar, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        } else {
            this.a = aVar;
            this.c = d;
            this.b = random;
        }
    }

    public final long a(int i) {
        double d = 1.0d - this.c;
        return (long) ((d + (((this.c + 1.0d) - d) * this.b.nextDouble())) * ((double) this.a.a(i)));
    }
}
