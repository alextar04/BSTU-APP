/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.AutoCompleteTextView
 *  android.widget.AutoCompleteTextView$OnDismissListener
 *  c.e.a.a.i0.h
 *  java.lang.Object
 *  java.lang.System
 */
package c.e.a.a.i0;

import android.widget.AutoCompleteTextView;
import c.e.a.a.i0.h;

public class k
implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h h2) {
        this.a = h2;
    }

    public void onDismiss() {
        h h2 = this.a;
        h2.i = true;
        h2.k = System.currentTimeMillis();
        h.f((h)this.a, (boolean)false);
    }
}

