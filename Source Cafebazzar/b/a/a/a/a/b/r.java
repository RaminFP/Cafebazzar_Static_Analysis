package b.a.a.a.a.b;

public enum r {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    public final int e;

    private r(int i) {
        this.e = i;
    }

    public static r a(String str) {
        return "io.crash.air".equals(str) ? TEST_DISTRIBUTION : str != null ? APP_STORE : DEVELOPER;
    }

    public final String toString() {
        return Integer.toString(this.e);
    }
}
