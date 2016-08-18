package android.support.v7.internal.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class k implements Callback {
    final Callback c;

    public k(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.c = callback;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.c.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.c.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.c.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.c.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.c.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.c.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.c.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.c.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.c.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.c.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return this.c.onCreatePanelView(i);
    }

    public void onDetachedFromWindow() {
        this.c.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.c.onMenuItemSelected(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.c.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.c.onPanelClosed(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.c.onPreparePanel(i, view, menu);
    }

    public boolean onSearchRequested() {
        return this.c.onSearchRequested();
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.c.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.c.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.c.onWindowStartingActionMode(callback);
    }
}
