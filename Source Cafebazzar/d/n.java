package d;

public abstract class n implements ac {
    private final ac a;

    public n(ac acVar) {
        if (acVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = acVar;
    }

    public long a(f fVar, long j) {
        return this.a.a(fVar, j);
    }

    public void close() {
        this.a.close();
    }

    public final ad j_() {
        return this.a.j_();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
