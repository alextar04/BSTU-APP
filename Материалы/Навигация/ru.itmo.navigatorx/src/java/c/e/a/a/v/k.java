/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  c.e.a.a.v.g
 *  java.lang.Object
 */
package c.e.a.a.v;

import android.view.View;
import c.e.a.a.v.g;

public class k
implements View.OnClickListener {
    public final /* synthetic */ g e;

    public k(g g2) {
        this.e = g2;
    }

    public void onClick(View view) {
        g g2 = this.e;
        g.e e2 = g.e.e;
        g.e e3 = g2.e0;
        g.e e4 = g.e.f;
        if (e3 == e4) {
            g2.A0(e2);
            return;
        }
        if (e3 == e2) {
            g2.A0(e4);
        }
    }
}

