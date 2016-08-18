package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.bp;
import android.support.v7.c.c;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ItemTouchUIUtilImpl {

    class Gingerbread implements ItemTouchUIUtil {
        Gingerbread() {
        }

        private void draw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public void clearView(View view) {
            view.setVisibility(0);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                draw(canvas, recyclerView, view, f, f2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i == 2) {
                draw(canvas, recyclerView, view, f, f2);
            }
        }

        public void onSelected(View view) {
            view.setVisibility(4);
        }
    }

    class Honeycomb implements ItemTouchUIUtil {
        Honeycomb() {
        }

        public void clearView(View view) {
            bp.a(view, 0.0f);
            bp.b(view, 0.0f);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            bp.a(view, f);
            bp.b(view, f2);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }

        public void onSelected(View view) {
        }
    }

    class Lollipop extends Honeycomb {
        Lollipop() {
        }

        private float findMaxElevation(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            int i = 0;
            while (i < childCount) {
                float s;
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    s = bp.s(childAt);
                    if (s > f) {
                        i++;
                        f = s;
                    }
                }
                s = f;
                i++;
                f = s;
            }
            return f;
        }

        public void clearView(View view) {
            Object tag = view.getTag(c.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                bp.e(view, ((Float) tag).floatValue());
            }
            view.setTag(c.item_touch_helper_previous_elevation, null);
            super.clearView(view);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(c.item_touch_helper_previous_elevation) == null) {
                float s = bp.s(view);
                bp.e(view, 1.0f + findMaxElevation(recyclerView, view));
                view.setTag(c.item_touch_helper_previous_elevation, Float.valueOf(s));
            }
            super.onDraw(canvas, recyclerView, view, f, f2, i, z);
        }
    }

    ItemTouchUIUtilImpl() {
    }
}
