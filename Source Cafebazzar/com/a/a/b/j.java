package com.a.a.b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import b.a.a.a.a.a.d;
import b.a.a.a.f;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class j implements d {
    private static String a(ZipInputStream zipInputStream) {
        String name;
        do {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return "";
            }
            name = nextEntry.getName();
        } while (!name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="));
        return name.substring(59, name.length() - 1);
    }

    private String b(Context context) {
        ZipInputStream zipInputStream;
        Throwable e;
        Throwable th;
        ZipInputStream zipInputStream2 = null;
        long nanoTime = System.nanoTime();
        String str = "";
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir));
            try {
                str = a(zipInputStream);
                try {
                    zipInputStream.close();
                } catch (Throwable e2) {
                    f.a().c("Beta", "Failed to close the APK file", e2);
                }
            } catch (NameNotFoundException e3) {
                e2 = e3;
                try {
                    f.a().c("Beta", "Failed to find this app in the PackageManager", e2);
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (Throwable e22) {
                            f.a().c("Beta", "Failed to close the APK file", e22);
                        }
                    }
                    f.a().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    zipInputStream2 = zipInputStream;
                    if (zipInputStream2 != null) {
                        try {
                            zipInputStream2.close();
                        } catch (Throwable e222) {
                            f.a().c("Beta", "Failed to close the APK file", e222);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e222 = e4;
                try {
                    f.a().c("Beta", "Failed to find the APK file", e222);
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (Throwable e2222) {
                            f.a().c("Beta", "Failed to close the APK file", e2222);
                        }
                    }
                    f.a().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
                    return str;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream2 = zipInputStream;
                    if (zipInputStream2 != null) {
                        zipInputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e2222 = e5;
                f.a().c("Beta", "Failed to read the APK file", e2222);
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (Throwable e22222) {
                        f.a().c("Beta", "Failed to close the APK file", e22222);
                    }
                }
                f.a().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
                return str;
            }
        } catch (NameNotFoundException e6) {
            e22222 = e6;
            zipInputStream = null;
            f.a().c("Beta", "Failed to find this app in the PackageManager", e22222);
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            f.a().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
            return str;
        } catch (FileNotFoundException e7) {
            e22222 = e7;
            zipInputStream = null;
            f.a().c("Beta", "Failed to find the APK file", e22222);
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            f.a().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
            return str;
        } catch (IOException e8) {
            e22222 = e8;
            zipInputStream = null;
            f.a().c("Beta", "Failed to read the APK file", e22222);
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            f.a().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
            return str;
        } catch (Throwable th4) {
            th = th4;
            if (zipInputStream2 != null) {
                zipInputStream2.close();
            }
            throw th;
        }
        f.a().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
        return str;
    }

    public final /* synthetic */ Object a(Context context) {
        return b(context);
    }
}
