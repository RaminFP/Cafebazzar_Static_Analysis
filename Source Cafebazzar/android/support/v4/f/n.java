package android.support.v4.f;

public final class n {
    public final Object a;
    public final Object b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (a(nVar.a, this.a) && a(nVar.b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.a == null ? 0 : this.a.hashCode();
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode ^ i;
    }
}
