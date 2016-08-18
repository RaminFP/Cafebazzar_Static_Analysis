package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.support.v4.f.a;
import android.util.Pair;
import com.google.android.gms.a.cn;
import com.google.android.gms.a.dc;
import com.google.android.gms.a.dd;
import com.google.android.gms.common.internal.av;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class j extends ba {
    private static final Map a;
    private final k b = new k(this, i(), x());
    private final c c = new c(h());

    static {
        Map aVar = new a(5);
        a = aVar;
        aVar.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    }

    j(ap apVar) {
        super(apVar);
    }

    private SQLiteDatabase w() {
        e();
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            l().b.a("Error opening database", e);
            throw e;
        }
    }

    private String x() {
        if (!i.B()) {
            return i.y();
        }
        if (n().C()) {
            return i.y();
        }
        l().c.a("Using secondary database");
        return i.z();
    }

    private boolean y() {
        return i().getDatabasePath(x()).exists();
    }

    long a(String str, String[] strArr, long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            cursor = w().rawQuery(str, null);
            try {
                if (cursor.moveToFirst()) {
                    long j2 = cursor.getLong(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return j2;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return 0;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    l().a.a("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            l().a.a("Database error", str, e);
            throw e;
        }
    }

    public final p a(String str, String str2) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        av.a(str);
        av.a(str2);
        e();
        u();
        try {
            query = w().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    p pVar = new p(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        l().a.a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return pVar;
                    }
                    query.close();
                    return pVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    l().a.a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            l().a.a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final List a(String str) {
        Object e;
        Throwable th;
        av.a(str);
        e();
        u();
        List arrayList = new ArrayList();
        Cursor query;
        try {
            SQLiteDatabase w = w();
            i.s();
            query = w.query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "21");
            if (query.moveToFirst()) {
                do {
                    int type;
                    Object obj;
                    String string = query.getString(0);
                    long j = query.getLong(1);
                    if (VERSION.SDK_INT >= 11) {
                        type = query.getType(2);
                    } else {
                        try {
                            CursorWindow window = ((SQLiteCursor) query).getWindow();
                            int position = query.getPosition();
                            type = window.isNull(position, 2) ? 0 : window.isLong(position, 2) ? 1 : window.isFloat(position, 2) ? 2 : window.isString(position, 2) ? 3 : window.isBlob(position, 2) ? 4 : -1;
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    }
                    switch (type) {
                        case 0:
                            l().a.a("Loaded invalid null value from database");
                            obj = null;
                            break;
                        case 1:
                            obj = Long.valueOf(query.getLong(2));
                            break;
                        case 2:
                            obj = Float.valueOf(query.getFloat(2));
                            break;
                        case 3:
                            obj = query.getString(2);
                            break;
                        case 4:
                            l().a.a("Loaded invalid blob type value, ignoring it");
                            obj = null;
                            break;
                        default:
                            l().a.a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                            obj = null;
                            break;
                    }
                    if (obj == null) {
                        l().a.a("Read invalid user attribute value, ignoring it");
                    } else {
                        arrayList.add(new e(str, string, j, obj));
                    }
                } while (query.moveToNext());
                if (arrayList.size() > i.s()) {
                    l().a.a("Loaded too many user attributes");
                    arrayList.remove(i.s());
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                l().a.a("Error querying user attributes", str, e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final List a(String str, int i, int i2) {
        Cursor query;
        List arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        e();
        u();
        av.b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        av.b(z);
        av.a(str);
        try {
            query = w().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = j().b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            dc dcVar = new dc(b, 0, b.length);
                            cn cnVar = new cn();
                            try {
                                cnVar.b(dcVar);
                                length = b.length + i3;
                                arrayList.add(Pair.create(cnVar, Long.valueOf(j)));
                            } catch (IOException e2) {
                                l().a.a("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            l().a.a("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                l().a.a("Error querying bundles", str, e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    protected final void a() {
    }

    public final void a(long j) {
        e();
        u();
        if (w().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            l().a.a("Deleted fewer rows from queue than expected");
        }
    }

    public final void a(cn cnVar) {
        e();
        u();
        av.a((Object) cnVar);
        av.a(cnVar.o);
        av.a(cnVar.f);
        r();
        long a = h().a();
        if (cnVar.f.longValue() < a - i.D() || cnVar.f.longValue() > i.D() + a) {
            l().b.a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), cnVar.f);
        }
        try {
            byte[] bArr = new byte[cnVar.d()];
            dd a2 = dd.a(bArr);
            cnVar.a(a2);
            a2.a();
            bArr = j().a(bArr);
            l().g.a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", cnVar.o);
            contentValues.put("bundle_end_timestamp", cnVar.f);
            contentValues.put("data", bArr);
            try {
                if (w().insert("queue", null, contentValues) == -1) {
                    l().a.a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                l().a.a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            l().a.a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public final void a(b bVar) {
        av.a((Object) bVar);
        e();
        u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", bVar.a);
        contentValues.put("app_instance_id", bVar.b);
        contentValues.put("gmp_app_id", bVar.c);
        contentValues.put("resettable_device_id_hash", bVar.d);
        contentValues.put("last_bundle_index", Long.valueOf(bVar.e));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(bVar.f));
        contentValues.put("app_version", bVar.g);
        contentValues.put("app_store", bVar.h);
        contentValues.put("gmp_version", Long.valueOf(bVar.i));
        contentValues.put("dev_cert_hash", Long.valueOf(bVar.j));
        contentValues.put("measurement_enabled", Boolean.valueOf(bVar.k));
        try {
            if (w().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                l().a.a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            l().a.a("Error storing app", e);
        }
    }

    public final void a(e eVar) {
        av.a((Object) eVar);
        e();
        u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", eVar.a);
        contentValues.put("name", eVar.b);
        contentValues.put("set_timestamp", Long.valueOf(eVar.c));
        Object obj = eVar.d;
        av.a("value");
        av.a(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Float) {
            contentValues.put("value", (Float) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
        try {
            if (w().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                l().a.a("Failed to insert/update user attribute (got -1)");
            }
        } catch (SQLiteException e) {
            l().a.a("Error storing user attribute", e);
        }
    }

    public final void a(p pVar) {
        av.a((Object) pVar);
        e();
        u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", pVar.a);
        contentValues.put("name", pVar.b);
        contentValues.put("lifetime_count", Long.valueOf(pVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(pVar.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(pVar.e));
        try {
            if (w().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                l().a.a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            l().a.a("Error storing event aggregates", e);
        }
    }

    public final b b(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        av.a(str);
        e();
        u();
        Cursor cursor2 = null;
        try {
            cursor2 = w().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (cursor2.moveToFirst()) {
                    b bVar = new b(str, cursor2.getString(0), cursor2.getString(1), cursor2.getString(2), cursor2.getLong(3), cursor2.getLong(4), cursor2.getString(5), cursor2.getString(6), cursor2.getLong(7), cursor2.getLong(8), (cursor2.isNull(9) ? 1 : cursor2.getInt(9)) != 0);
                    if (cursor2.moveToNext()) {
                        l().a.a("Got multiple records for app, expected one");
                    }
                    if (cursor2 == null) {
                        return bVar;
                    }
                    cursor2.close();
                    return bVar;
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursor2;
                try {
                    l().a.a("Error querying app", str, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            l().a.a("Error querying app", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void b() {
        u();
        w().beginTransaction();
    }

    public final void b(String str, String str2) {
        av.a(str);
        av.a(str2);
        e();
        u();
        try {
            l().g.a("Deleted user attribute rows:", Integer.valueOf(w().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            l().a.a("Error deleting user attribute", str, str2, e);
        }
    }

    public final void o() {
        u();
        w().setTransactionSuccessful();
    }

    public final void p() {
        u();
        w().endTransaction();
    }

    public final String q() {
        Cursor rawQuery;
        String string;
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            rawQuery = w().rawQuery("SELECT q.app_id FROM queue q JOIN apps a ON a.app_id=q.app_id WHERE a.measurement_enabled!=0 ORDER BY q.rowid LIMIT 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    l().a.a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            l().a.a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return string;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return string;
    }

    final void r() {
        e();
        u();
        if (y()) {
            long a = m().f.a();
            long b = h().b();
            if (Math.abs(b - a) > i.E()) {
                m().f.a(b);
                e();
                u();
                if (y()) {
                    int delete = w().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(h().a()), String.valueOf(i.D())});
                    if (delete > 0) {
                        l().g.a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }
}
