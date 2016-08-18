package com.c.b;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;

final class ac extends o {
    private static final String[] b = new String[]{"orientation"};

    ac(Context context) {
        super(context);
    }

    private static int a(ContentResolver contentResolver, Uri uri) {
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = contentResolver.query(uri, b, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (RuntimeException e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final boolean a(aw awVar) {
        Uri uri = awVar.d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public final ba b(aw awVar) {
        int i = 1;
        ContentResolver contentResolver = this.a.getContentResolver();
        int a = a(contentResolver, awVar.d);
        String type = contentResolver.getType(awVar.d);
        int i2 = (type == null || !type.startsWith("video/")) ? 0 : 1;
        if (awVar.c()) {
            int i3 = awVar.h;
            int i4 = awVar.i;
            ad adVar = (i3 > ad.MICRO.e || i4 > ad.MICRO.f) ? (i3 > ad.MINI.e || i4 > ad.MINI.f) ? ad.FULL : ad.MINI : ad.MICRO;
            if (i2 == 0 && adVar == ad.FULL) {
                return new ba(null, c(awVar), ap.DISK, a);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(awVar.d);
            Options d = az.d(awVar);
            d.inJustDecodeBounds = true;
            az.a(awVar.h, awVar.i, adVar.e, adVar.f, d, awVar);
            if (i2 != 0) {
                if (adVar != ad.FULL) {
                    i = adVar.d;
                }
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, i, d);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, adVar.d, d);
            }
            if (thumbnail != null) {
                return new ba(thumbnail, null, ap.DISK, a);
            }
        }
        return new ba(null, c(awVar), ap.DISK, a);
    }
}
