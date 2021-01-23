/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  java.lang.Object
 */
package c.e.a.a.z;

import android.view.ViewTreeObserver;
import c.e.a.a.z.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class g
implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ e e;

    public g(e e2) {
        this.e = e2;
    }

    public boolean onPreDraw() {
        e e2 = this.e;
        float f2 = e2.t.getRotation();
        if (e2.n != f2) {
            e2.n = f2;
            e2.s();
        }
        return true;
    }
}

