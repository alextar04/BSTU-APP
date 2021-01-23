/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  c.e.a.a.v.c0
 *  c.e.a.a.v.g
 *  java.lang.Object
 */
package c.e.a.a.v;

import android.view.View;
import c.e.a.a.v.a;
import c.e.a.a.v.c0;
import c.e.a.a.v.g;
import c.e.a.a.v.s;

public class b0
implements View.OnClickListener {
    public final /* synthetic */ int e;
    public final /* synthetic */ c0 f;

    public b0(c0 c02, int n2) {
        this.f = c02;
        this.e = n2;
    }

    public void onClick(View view) {
        s s2 = s.b(this.e, this.f.c.d0.g);
        a a2 = this.f.c.c0;
        if (s2.a(a2.e) < 0) {
            s2 = a2.e;
        } else if (s2.a(a2.f) > 0) {
            s2 = a2.f;
        }
        this.f.c.z0(s2);
        this.f.c.A0(g.e.e);
    }
}

