/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  f.h.l.l
 *  java.lang.Object
 */
package c.e.a.a.a0;

import android.view.View;

public final class l
implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        f.h.l.l.Q((View)view);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}

