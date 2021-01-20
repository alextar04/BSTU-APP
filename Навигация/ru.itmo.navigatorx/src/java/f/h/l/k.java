/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package f.h.l;

import android.view.View;
import android.view.ViewTreeObserver;

public final class k
implements ViewTreeObserver.OnPreDrawListener,
View.OnAttachStateChangeListener {
    public final View e;
    public ViewTreeObserver f;
    public final Runnable g;

    public k(View view, Runnable runnable) {
        this.e = view;
        this.f = view.getViewTreeObserver();
        this.g = runnable;
    }

    public static k a(View view, Runnable runnable) {
        if (view != null) {
            k k2 = new k(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)k2);
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)k2);
            return k2;
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        ViewTreeObserver viewTreeObserver = this.f.isAlive() ? this.f : this.e.getViewTreeObserver();
        viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        this.e.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public boolean onPreDraw() {
        this.b();
        this.g.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        this.b();
    }
}

