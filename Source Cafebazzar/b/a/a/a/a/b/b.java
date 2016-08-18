package b.a.a.a.a.b;

public final class b {
    public final String a;
    public final boolean b;

    b(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b) {
                return false;
            }
            if (this.a != null) {
                if (!this.a.equals(bVar.a)) {
                    return false;
                }
            } else if (bVar.a != null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.a != null ? this.a.hashCode() : 0;
        if (this.b) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }
}
