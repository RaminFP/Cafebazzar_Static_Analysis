package d;

public abstract class m implements ab {
    private final ab a;

    public m(ab abVar) {
        if (abVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = abVar;
    }

    public void a_(f fVar, long j) {
        this.a.a_(fVar, j);
    }

    public void close() {
        this.a.close();
    }

    public void flush() {
        this.a.flush();
    }

    public final ad j_() {
        return this.a.j_();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
