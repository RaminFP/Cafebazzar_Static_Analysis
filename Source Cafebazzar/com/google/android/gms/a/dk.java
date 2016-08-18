package com.google.android.gms.a;

import java.io.IOException;

public final class dk extends IOException {
    private dk(String str) {
        super(str);
    }

    static dk a() {
        return new dk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static dk b() {
        return new dk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static dk c() {
        return new dk("CodedInputStream encountered a malformed varint.");
    }

    static dk d() {
        return new dk("Protocol message contained an invalid tag (zero).");
    }

    static dk e() {
        return new dk("Protocol message end-group tag did not match expected tag.");
    }

    static dk f() {
        return new dk("Protocol message tag had invalid wire type.");
    }

    static dk g() {
        return new dk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
