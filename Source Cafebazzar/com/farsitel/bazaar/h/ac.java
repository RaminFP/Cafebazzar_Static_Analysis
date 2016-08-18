package com.farsitel.bazaar.h;

import android.content.res.Resources.NotFoundException;
import android.support.v4.app.NotificationCompat;
import com.congenialmobile.util.a;
import com.congenialmobile.util.b;
import com.congenialmobile.util.d;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.util.p;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac {
    private static byte[] a;
    private static PublicKey b;
    private static Cipher c;
    private static KeyGenerator d;
    private static IvParameterSpec e;
    private static String f;
    private static Signature g;
    private SecretKey h;
    private SecretKey i;
    private String j;
    private String k;
    private Cipher l;

    static {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(BazaarApplication.c().getResources().openRawResource(2131099649));
            b = (PublicKey) objectInputStream.readObject();
            objectInputStream.close();
            c = Cipher.getInstance("RSA/None/OAEPPADDING");
            d = KeyGenerator.getInstance("AES");
            a = new SecureRandom().generateSeed(16);
            e = new IvParameterSpec(a);
            c.init(1, b);
            f = a.a(c.doFinal(a));
            g = Signature.getInstance("SHA1withRSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (StreamCorruptedException e6) {
            e6.printStackTrace();
        } catch (NotFoundException e7) {
            e7.printStackTrace();
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (ClassNotFoundException e9) {
            e9.printStackTrace();
        }
    }

    public ac() {
        d.init(NotificationCompat.FLAG_HIGH_PRIORITY);
        try {
            this.h = d.generateKey();
            c.init(1, b);
            this.j = a.a(c.doFinal(this.h.getEncoded()));
            this.i = d.generateKey();
            c.init(1, b);
            this.k = a.a(c.doFinal(this.i.getEncoded()));
            this.l = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        try {
            g.initVerify(b);
            g.update(bArr);
            return g.verify(bArr2);
        } catch (SignatureException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private byte[] a(byte[] bArr) {
        try {
            this.l.init(1, this.h, e);
            return this.l.doFinal(bArr);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        } catch (BadPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private byte[] b(byte[] bArr) {
        try {
            this.l.init(2, this.i, e);
            return this.l.doFinal(bArr);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        } catch (BadPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final Object a(u uVar, byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject((uVar.a.e ? d.b(bArr) : new String(bArr)).trim());
            if (uVar.a.c) {
                if (!jSONObject.has("packed")) {
                    throw new c(10009, "result is not encrypted!");
                } else if (jSONObject.has("sign")) {
                    byte[] a = a.a(jSONObject.getString("packed"));
                    if (a(a, a.a(jSONObject.getString("sign")))) {
                        jSONObject = new JSONObject(new String(b(a), "UTF-8"));
                    } else {
                        throw new c(10011, "Signature verification failed!");
                    }
                } else {
                    throw new c(10010, "result is not signed!");
                }
            }
            if (jSONObject.has("error")) {
                Object obj = jSONObject.get("error");
                if (!obj.equals(null)) {
                    int i = 10006;
                    try {
                        i = Integer.parseInt(obj.toString());
                    } catch (Exception e) {
                    }
                    throw new c(i, "Server Error");
                } else if (uVar.c != null) {
                    ab.a(uVar, jSONObject);
                }
            } else if (uVar.c != null) {
                ab.a(uVar, jSONObject);
            }
            return jSONObject.get("result");
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (b e3) {
            e3.printStackTrace();
            return null;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        } catch (c e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String a(u uVar) {
        try {
            JSONObject b = uVar.b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", b.getInt("id"));
            jSONObject.put("method", uVar.a.b);
            jSONObject.put("params", new JSONArray());
            jSONObject.put("p1", this.j);
            jSONObject.put("p2", this.k);
            jSONObject.put("iv", f);
            jSONObject.put("packed", uVar.a.d ? a.a(a(d.a(b.toString()))) : a.a(a(b.toString().getBytes())));
            jSONObject.put("hash", uVar.c);
            b = p.b();
            String str = uVar.b;
            if (str != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", str);
                b.put("referer", jSONObject2);
            }
            jSONObject.put("non_enc_params", b.toString());
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
