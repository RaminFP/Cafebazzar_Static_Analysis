package android.support.v4.widget;

final class b {
    int a;
    int b;
    float c;
    float d;
    long e = Long.MIN_VALUE;
    long f = 0;
    int g = 0;
    int h = 0;
    long i = -1;
    float j;
    int k;

    float a(long j) {
        if (j < this.e) {
            return 0.0f;
        }
        if (this.i < 0 || j < this.i) {
            return a.b(((float) (j - this.e)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
        }
        long j2 = this.i;
        float f = this.j;
        return (a.b(((float) (j - j2)) / ((float) this.k), 0.0f, 1.0f) * this.j) + (1.0f - f);
    }
}
