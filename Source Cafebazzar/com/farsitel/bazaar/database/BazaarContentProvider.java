package com.farsitel.bazaar.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class BazaarContentProvider extends ContentProvider {
    public static final Uri a;
    public static final Uri b;
    public static final Uri c;
    public static final Uri d = Uri.withAppendedPath(b, "get_jaw");
    d e = null;
    Cursor f = null;

    static {
        Uri parse = Uri.parse("content://com.farsitel.bazaar");
        a = parse;
        parse = Uri.withAppendedPath(parse, "info");
        b = parse;
        c = Uri.withAppendedPath(parse, "get_uid");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uri.equals(c)) {
            if (this.e == null) {
                getContext();
                this.e = new d();
            }
            return this.e;
        } else if (!uri.equals(d)) {
            return null;
        } else {
            if (this.f == null) {
                this.f = new c();
            }
            return this.f;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
