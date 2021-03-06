package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.av;

public final class a extends DialogFragment {
    private Dialog a = null;
    private OnCancelListener b = null;

    public static a a(Dialog dialog, OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) av.a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        aVar.a = dialog2;
        if (onCancelListener != null) {
            aVar.b = onCancelListener;
        }
        return aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.b != null) {
            this.b.onCancel(dialogInterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    public final void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
