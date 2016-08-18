package com.farsitel.bazaar.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.farsitel.bazaar.BazaarApplication;
import java.util.ArrayList;

public final class o {
    public static void a(String str) {
        int i = 0;
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        String string = sharedPreferences.getString("emails", "");
        String[] split = string.split("\n");
        while (i < split.length) {
            if (!str.equals(split[i])) {
                i++;
            } else {
                return;
            }
        }
        String str2 = (string.length() != 0 ? string + "\n" : string) + str;
        Editor edit = sharedPreferences.edit();
        edit.putString("emails", str2);
        edit.commit();
    }

    public static String[] a(boolean z) {
        Context c = BazaarApplication.c();
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (String str : BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).getString("emails", "").split("\n")) {
                if (!str.equals("")) {
                    arrayList.add(str);
                }
            }
        }
        Account[] accountsByType = AccountManager.get(c).getAccountsByType("com.google");
        Account[] accountsByType2 = AccountManager.get(c).getAccountsByType("com.yahoo.mobile.client.share.sync");
        for (Account account : accountsByType) {
            if (!arrayList.contains(account.name)) {
                arrayList.add(account.name);
            }
        }
        for (Account account2 : accountsByType2) {
            String str2 = account2.name + "@yahoo.com";
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
