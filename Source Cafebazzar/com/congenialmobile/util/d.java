package com.congenialmobile.util;

import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class d {
    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i] & 255)}));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            Log.w(d.class.getSimpleName(), "BazaarUtils :: CodingUtils :: byteArrayToSha1HexDigest", e);
            return null;
        }
    }

    public static byte[] a(File file, byte[] bArr) {
        Throwable th;
        FileInputStream fileInputStream;
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                int read = fileInputStream2.read(bArr);
                while (read > 0) {
                    instance.update(bArr, 0, read);
                    read = fileInputStream2.read(bArr);
                }
                fileInputStream2.close();
                return instance.digest();
            } catch (Throwable th2) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th2;
                fileInputStream = fileInputStream3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static byte[] a(String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        deflaterOutputStream.write(str.getBytes());
        deflaterOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(byte[] bArr) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new InflaterInputStream(new ByteArrayInputStream(bArr))));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str = str + readLine;
            } else {
                bufferedReader.close();
                return str;
            }
        }
    }
}
