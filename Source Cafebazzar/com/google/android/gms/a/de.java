package com.google.android.gms.a;

import java.io.IOException;

public final class de extends IOException {
    de(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
    }
}
