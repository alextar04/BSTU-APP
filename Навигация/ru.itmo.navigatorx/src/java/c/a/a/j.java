/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  c.a.a.a$b
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a;

import android.view.View;
import android.view.ViewTreeObserver;
import c.a.a.a;

public final class j
implements View.OnAttachStateChangeListener {
    public final /* synthetic */ a e;

    public j() {
        this.e = var1_1;
    }

    public void onViewAttachedToWindow(View view) {
        h.m.b.j.e((Object)view, (String)"view");
        view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.e.d);
    }

    public void onViewDetachedFromWindow(View view) {
        h.m.b.j.e((Object)view, (String)"view");
        view.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.e.d);
    }
}

