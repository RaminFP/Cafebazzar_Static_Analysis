package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.a.b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class ae extends Dialog implements o {
    private p a;

    public ae(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(b.dialogTheme, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        a().a(null);
    }

    public final p a() {
        if (this.a == null) {
            Context context = getContext();
            Window window = getWindow();
            int i = VERSION.SDK_INT;
            p tVar = i >= 14 ? new t(context, window, this) : i >= 11 ? new s(context, window, this) : new AppCompatDelegateImplV7(context, window, this);
            this.a = tVar;
        }
        return this.a;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    public void invalidateOptionsMenu() {
        a().b();
    }

    protected void onCreate(Bundle bundle) {
        a().c();
        super.onCreate(bundle);
        a().a(bundle);
    }

    protected void onStop() {
        super.onStop();
        a().a();
    }

    public void setContentView(int i) {
        a().a(i);
    }

    public void setContentView(View view) {
        a().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }
}
