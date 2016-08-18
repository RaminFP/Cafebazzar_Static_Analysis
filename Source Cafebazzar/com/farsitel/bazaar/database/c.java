package com.farsitel.bazaar.database;

import android.database.AbstractCursor;
import com.farsitel.bazaar.util.h;
import com.farsitel.bazaar.util.y;

final class c extends AbstractCursor {
    private String a;

    public c() {
        try {
            double[] dArr = h.INSTANCE.b == 0.0d ? null : new double[]{h.INSTANCE.b, h.INSTANCE.c};
            if (dArr != null) {
                this.a = y.a(String.valueOf(dArr[0]), String.valueOf(dArr[1]), h.INSTANCE.b(), h.INSTANCE.c(), h.INSTANCE.d());
            } else {
                this.a = null;
            }
        } catch (Exception e) {
            this.a = null;
        }
    }

    public final String[] getColumnNames() {
        return new String[]{"jaw"};
    }

    public final int getCount() {
        return 1;
    }

    public final double getDouble(int i) {
        throw new UnsupportedOperationException();
    }

    public final float getFloat(int i) {
        throw new UnsupportedOperationException();
    }

    public final int getInt(int i) {
        throw new UnsupportedOperationException();
    }

    public final long getLong(int i) {
        throw new UnsupportedOperationException();
    }

    public final short getShort(int i) {
        throw new UnsupportedOperationException();
    }

    public final String getString(int i) {
        return i == 0 ? this.a : null;
    }

    public final boolean isNull(int i) {
        return false;
    }
}
