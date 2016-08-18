package com.farsitel.bazaar.database;

import android.database.AbstractCursor;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.p;

final class d extends AbstractCursor {
    private final String a = p.a();

    private static int a() {
        return j.a().n() ? 1 : 0;
    }

    public final String[] getColumnNames() {
        return new String[]{"_id", "bazaar_uid", "bazaar_loggedin", "bazaar_baseUrl", "bazaar_cdnPrefix", "ghollak_baseUrl"};
    }

    public final int getCount() {
        return 1;
    }

    public final double getDouble(int i) {
        if (i == 0) {
            return 0.0d;
        }
        if (i == 2) {
            return (double) a();
        }
        throw new UnsupportedOperationException();
    }

    public final float getFloat(int i) {
        if (i == 0) {
            return 0.0f;
        }
        if (i == 2) {
            return (float) a();
        }
        throw new UnsupportedOperationException();
    }

    public final int getInt(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 2) {
            return a();
        }
        throw new UnsupportedOperationException();
    }

    public final long getLong(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 2) {
            return (long) a();
        }
        throw new UnsupportedOperationException();
    }

    public final short getShort(int i) {
        if (i == 0) {
            return (short) 0;
        }
        if (i == 2) {
            return (short) a();
        }
        throw new UnsupportedOperationException();
    }

    public final String getString(int i) {
        return i == 0 ? "0" : i == 1 ? this.a : i == 2 ? a() : null;
    }

    public final boolean isNull(int i) {
        return i <= 0 || i >= 3;
    }

    public final String toString() {
        return "BazaarUidCursor(uid=" + this.a + ")";
    }
}
