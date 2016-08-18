package com.farsitel.bazaar.util;

import com.congenialmobile.util.a;
import com.farsitel.bazaar.BazaarApplication;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class y {
    static PublicKey a = a();

    public static String a(String str, String str2, String str3, String str4, String str5) {
        String trim = str.trim();
        String trim2 = str2.trim();
        String trim3 = str3.trim();
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, a);
            return a.a(instance.doFinal((trim + "|" + trim2 + "|" + trim3 + "|" + str4 + "|" + str5).getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private static PublicKey a() {
        FileNotFoundException fileNotFoundException;
        IOException iOException;
        ClassNotFoundException classNotFoundException;
        PublicKey publicKey = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(BazaarApplication.c().getResources().openRawResource(2131099648));
            PublicKey publicKey2 = (PublicKey) objectInputStream.readObject();
            try {
                objectInputStream.close();
                return publicKey2;
            } catch (FileNotFoundException e) {
                FileNotFoundException fileNotFoundException2 = e;
                publicKey = publicKey2;
                fileNotFoundException = fileNotFoundException2;
                fileNotFoundException.printStackTrace();
                return publicKey;
            } catch (IOException e2) {
                IOException iOException2 = e2;
                publicKey = publicKey2;
                iOException = iOException2;
                iOException.printStackTrace();
                return publicKey;
            } catch (ClassNotFoundException e3) {
                ClassNotFoundException classNotFoundException2 = e3;
                publicKey = publicKey2;
                classNotFoundException = classNotFoundException2;
                classNotFoundException.printStackTrace();
                return publicKey;
            }
        } catch (FileNotFoundException e4) {
            fileNotFoundException = e4;
            fileNotFoundException.printStackTrace();
            return publicKey;
        } catch (IOException e5) {
            iOException = e5;
            iOException.printStackTrace();
            return publicKey;
        } catch (ClassNotFoundException e6) {
            classNotFoundException = e6;
            classNotFoundException.printStackTrace();
            return publicKey;
        }
    }
}
