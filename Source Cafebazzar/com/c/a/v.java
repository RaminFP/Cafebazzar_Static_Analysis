package com.c.a;

public final class v {
    boolean a;
    String[] b;
    String[] c;
    boolean d;

    public v(u uVar) {
        this.a = uVar.d;
        this.b = uVar.e;
        this.c = uVar.f;
        this.d = uVar.g;
    }

    v(boolean z) {
        this.a = z;
    }

    public final u a() {
        return new u();
    }

    public final v a(boolean z) {
        if (this.a) {
            this.d = true;
            return this;
        }
        throw new IllegalStateException("no TLS extensions for cleartext connections");
    }

    public final v a(at... atVarArr) {
        if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        } else if (atVarArr.length == 0) {
            throw new IllegalArgumentException("At least one TlsVersion is required");
        } else {
            String[] strArr = new String[atVarArr.length];
            for (int i = 0; i < atVarArr.length; i++) {
                strArr[i] = atVarArr[i].e;
            }
            this.c = strArr;
            return this;
        }
    }

    public final v a(String... strArr) {
        if (this.a) {
            if (strArr == null) {
                this.b = null;
            } else {
                this.b = (String[]) strArr.clone();
            }
            return this;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    public final v b(String... strArr) {
        if (this.a) {
            if (strArr == null) {
                this.c = null;
            } else {
                this.c = (String[]) strArr.clone();
            }
            return this;
        }
        throw new IllegalStateException("no TLS versions for cleartext connections");
    }
}
