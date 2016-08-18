package android.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

public final class h extends CursorAdapter {
    final /* synthetic */ ListView a;
    final /* synthetic */ d b;
    final /* synthetic */ f c;
    private final int d;
    private final int e;

    public h(f fVar, Context context, Cursor cursor, boolean z, ListView listView, d dVar) {
        this.c = fVar;
        this.a = listView;
        this.b = dVar;
        super(context, cursor, false);
        Cursor cursor2 = getCursor();
        this.d = cursor2.getColumnIndexOrThrow(this.c.I);
        this.e = cursor2.getColumnIndexOrThrow(this.c.J);
    }

    public final void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.d));
        this.a.setItemChecked(cursor.getPosition(), cursor.getInt(this.e) == 1);
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.c.b.inflate(this.b.I, viewGroup, false);
    }
}
