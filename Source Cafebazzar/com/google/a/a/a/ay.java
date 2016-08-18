package com.google.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.impl.client.DefaultHttpClient;

final class ay implements f {
    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private final ba b;
    private volatile o c;
    private final g d;
    private final Context e;
    private final String f;
    private long g;
    private l h;

    ay(g gVar, Context context) {
        this(gVar, context, "google_analytics_v2.db");
    }

    private ay(g gVar, Context context, String str) {
        this.e = context.getApplicationContext();
        this.f = str;
        this.d = gVar;
        this.h = new az(this);
        this.b = new ba(this, this.e, this.f);
        this.c = new be(new DefaultHttpClient(), this.e);
        this.g = 0;
    }

    private SQLiteDatabase a(String str) {
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            as.d(str);
            return null;
        }
    }

    private static String a(Map map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(ar.a((String) entry.getKey()) + "=" + ar.a((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    private List a(int i) {
        SQLiteException e;
        Throwable th;
        Cursor cursor = null;
        List arrayList = new ArrayList();
        if (i <= 0) {
            as.d("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase a = a("Error opening database for peekHitIds.");
        if (a == null) {
            return arrayList;
        }
        Cursor query;
        try {
            String[] strArr = new String[]{"hit_id"};
            query = a.query("hits2", strArr, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    as.d("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            as.d("Error in peekHits fetching hitIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    @Deprecated
    private void a(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            as.d("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (aq aqVar : collection) {
            strArr[i] = String.valueOf(aqVar.b);
            i++;
        }
        a(strArr);
    }

    private static void a(Map map, Collection collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (Command command : collection) {
                if ("appendVersion".equals(command.a)) {
                    map.put(substring, command.b);
                    return;
                }
            }
        }
    }

    private void a(String[] strArr) {
        boolean z = false;
        if (strArr == null || strArr.length == 0) {
            as.d("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase a = a("Error opening database for deleteHits.");
        if (a != null) {
            try {
                a.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                g gVar = this.d;
                if (d() == 0) {
                    z = true;
                }
                gVar.a(z);
            } catch (SQLiteException e) {
                as.d("Error deleting hits " + strArr);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List b(int r17) {
        /*
        r16 = this;
        r13 = 1;
        r12 = 0;
        r11 = 0;
        r14 = new java.util.ArrayList;
        r14.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.a(r2);
        if (r2 != 0) goto L_0x0014;
    L_0x0012:
        r2 = r14;
    L_0x0013:
        return r2;
    L_0x0014:
        r3 = "%s ASC";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r9 = java.lang.String.format(r3, r4);	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r3 = 40;
        r10 = java.lang.Integer.toString(r3);	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r3 = "hits2";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00df, all -> 0x0199 }
        r15 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0184, all -> 0x0193 }
        r15.<init>();	 Catch:{ SQLiteException -> 0x0184, all -> 0x0193 }
        r3 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x0189, all -> 0x0193 }
        if (r3 == 0) goto L_0x0063;
    L_0x004a:
        r4 = new com.google.a.a.a.aq;	 Catch:{ SQLiteException -> 0x0189, all -> 0x0193 }
        r5 = 0;
        r3 = 0;
        r6 = r11.getLong(r3);	 Catch:{ SQLiteException -> 0x0189, all -> 0x0193 }
        r3 = 1;
        r8 = r11.getLong(r3);	 Catch:{ SQLiteException -> 0x0189, all -> 0x0193 }
        r4.<init>(r5, r6, r8);	 Catch:{ SQLiteException -> 0x0189, all -> 0x0193 }
        r15.add(r4);	 Catch:{ SQLiteException -> 0x0189, all -> 0x0193 }
        r3 = r11.moveToNext();	 Catch:{ SQLiteException -> 0x0189, all -> 0x0193 }
        if (r3 != 0) goto L_0x004a;
    L_0x0063:
        if (r11 == 0) goto L_0x0068;
    L_0x0065:
        r11.close();
    L_0x0068:
        r3 = "%s ASC";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r9 = java.lang.String.format(r3, r4);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r3 = 40;
        r10 = java.lang.Integer.toString(r3);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r3 = "hits2";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r5 = 1;
        r6 = "hit_string";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r5 = 2;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0196 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        if (r2 == 0) goto L_0x00d7;
    L_0x009e:
        r4 = r12;
    L_0x009f:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        if (r2 <= 0) goto L_0x015a;
    L_0x00ad:
        r2 = r15.get(r4);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = (com.google.a.a.a.aq) r2;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2.a = r5;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = r15.get(r4);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = (com.google.a.a.a.aq) r2;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r5 = 2;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        if (r5 == 0) goto L_0x00d1;
    L_0x00c7:
        r6 = r5.trim();	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        if (r6 == 0) goto L_0x0106;
    L_0x00d1:
        r2 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        if (r2 != 0) goto L_0x018e;
    L_0x00d7:
        if (r3 == 0) goto L_0x00dc;
    L_0x00d9:
        r3.close();
    L_0x00dc:
        r2 = r15;
        goto L_0x0013;
    L_0x00df:
        r2 = move-exception;
        r3 = r2;
        r2 = r14;
    L_0x00e2:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ff }
        r5 = "Error in peekHits fetching hitIds: ";
        r4.<init>(r5);	 Catch:{ all -> 0x00ff }
        r3 = r3.getMessage();	 Catch:{ all -> 0x00ff }
        r3 = r4.append(r3);	 Catch:{ all -> 0x00ff }
        r3 = r3.toString();	 Catch:{ all -> 0x00ff }
        com.google.a.a.a.as.d(r3);	 Catch:{ all -> 0x00ff }
        if (r11 == 0) goto L_0x0013;
    L_0x00fa:
        r11.close();
        goto L_0x0013;
    L_0x00ff:
        r2 = move-exception;
    L_0x0100:
        if (r11 == 0) goto L_0x0105;
    L_0x0102:
        r11.close();
    L_0x0105:
        throw r2;
    L_0x0106:
        r5 = r5.toLowerCase();	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r6 = "http:";
        r5 = r5.startsWith(r6);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        if (r5 == 0) goto L_0x00d1;
    L_0x0112:
        r5 = "http:";
        r2.d = r5;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        goto L_0x00d1;
    L_0x0117:
        r2 = move-exception;
    L_0x0118:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0153 }
        r5 = "Error in peekHits fetching hitString: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0153 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0153 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0153 }
        r2 = r2.toString();	 Catch:{ all -> 0x0153 }
        com.google.a.a.a.as.d(r2);	 Catch:{ all -> 0x0153 }
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x0153 }
        r5.<init>();	 Catch:{ all -> 0x0153 }
        r6 = r15.iterator();	 Catch:{ all -> 0x0153 }
        r4 = r12;
    L_0x0138:
        r2 = r6.hasNext();	 Catch:{ all -> 0x0153 }
        if (r2 == 0) goto L_0x0179;
    L_0x013e:
        r2 = r6.next();	 Catch:{ all -> 0x0153 }
        r2 = (com.google.a.a.a.aq) r2;	 Catch:{ all -> 0x0153 }
        r7 = r2.a;	 Catch:{ all -> 0x0153 }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x0153 }
        if (r7 == 0) goto L_0x014f;
    L_0x014c:
        if (r4 != 0) goto L_0x0179;
    L_0x014e:
        r4 = r13;
    L_0x014f:
        r5.add(r2);	 Catch:{ all -> 0x0153 }
        goto L_0x0138;
    L_0x0153:
        r2 = move-exception;
    L_0x0154:
        if (r3 == 0) goto L_0x0159;
    L_0x0156:
        r3.close();
    L_0x0159:
        throw r2;
    L_0x015a:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r7 = 0;
        r2 = r15.get(r4);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = (com.google.a.a.a.aq) r2;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r8 = r2.b;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        com.google.a.a.a.as.d(r2);	 Catch:{ SQLiteException -> 0x0117, all -> 0x0177 }
        goto L_0x00d1;
    L_0x0177:
        r2 = move-exception;
        goto L_0x0154;
    L_0x0179:
        if (r3 == 0) goto L_0x017e;
    L_0x017b:
        r3.close();
    L_0x017e:
        r2 = r5;
        goto L_0x0013;
    L_0x0181:
        r2 = move-exception;
        r3 = r11;
        goto L_0x0118;
    L_0x0184:
        r2 = move-exception;
        r3 = r2;
        r2 = r14;
        goto L_0x00e2;
    L_0x0189:
        r2 = move-exception;
        r3 = r2;
        r2 = r15;
        goto L_0x00e2;
    L_0x018e:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x009f;
    L_0x0193:
        r2 = move-exception;
        goto L_0x0100;
    L_0x0196:
        r2 = move-exception;
        r3 = r11;
        goto L_0x0154;
    L_0x0199:
        r2 = move-exception;
        goto L_0x0100;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a.ay.b(int):java.util.List");
    }

    private int d() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase a = a("Error opening database for getNumStoredHits.");
        if (a != null) {
            try {
                cursor = a.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                as.d("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public final void a() {
        as.c("Dispatch running...");
        if (this.c.a()) {
            List b = b(40);
            if (b.isEmpty()) {
                as.c("...nothing to dispatch");
                this.d.a(true);
                return;
            }
            int a = this.c.a(b);
            as.c("sent " + a + " of " + b.size() + " hits");
            a(b.subList(0, Math.min(a, b.size())));
            if (a == b.size() && d() > 0) {
                x.a().c();
            }
        }
    }

    public final void a(long j) {
        boolean z = false;
        SQLiteDatabase a = a("Error opening database for clearHits");
        if (a != null) {
            if (0 == 0) {
                a.delete("hits2", null, null);
            } else {
                a.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(0).toString()});
            }
            g gVar = this.d;
            if (d() == 0) {
                z = true;
            }
            gVar.a(z);
        }
    }

    public final void a(Map map, long j, String str, Collection collection) {
        SQLiteDatabase a;
        boolean z = true;
        long a2 = this.h.a();
        if (a2 > this.g + 86400000) {
            this.g = a2;
            a = a("Error opening database for deleteStaleHits.");
            if (a != null) {
                a.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.h.a() - 2592000000L)});
                g gVar = this.d;
                if (d() != 0) {
                    z = false;
                }
                gVar.a(z);
            }
        }
        int d = (d() - 2000) + 1;
        if (d > 0) {
            List a3 = a(d);
            as.c("Store full, deleting " + a3.size() + " hits to make room.");
            a((String[]) a3.toArray(new String[0]));
        }
        a(map, collection);
        a = a("Error opening database for putHit");
        if (a != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", a(map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    parseLong = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                }
                contentValues.put("hit_app_id", Long.valueOf(parseLong));
                if (str == null) {
                    str = "http://www.google-analytics.com/collect";
                }
                if (str.length() != 0) {
                    as.d("Empty path: not sending hit");
                }
                contentValues.put("hit_url", str);
                try {
                    a.insert("hits2", null, contentValues);
                    this.d.a(false);
                    return;
                } catch (SQLiteException e2) {
                    as.d("Error storing hit");
                    return;
                }
            }
            parseLong = 0;
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() != 0) {
                contentValues.put("hit_url", str);
                a.insert("hits2", null, contentValues);
                this.d.a(false);
                return;
            }
            as.d("Empty path: not sending hit");
        }
    }

    public final o b() {
        return this.c;
    }
}
