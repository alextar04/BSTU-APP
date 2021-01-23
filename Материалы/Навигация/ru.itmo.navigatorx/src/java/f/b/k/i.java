/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  f.h.l.l
 *  f.h.l.u
 *  f.h.l.u$c
 *  java.lang.Object
 */
package f.b.k;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import f.b.k.h;
import f.h.f.b;
import f.h.l.j;
import f.h.l.l;
import f.h.l.u;

public class i
implements j {
    public final /* synthetic */ h a;

    public i(h h2) {
        this.a = h2;
    }

    @Override
    public u a(View view, u u2) {
        int n2;
        int n3 = u2.d();
        if (n3 != (n2 = this.a.N(u2, null))) {
            int n4 = u2.b();
            int n5 = u2.c();
            int n6 = u2.a();
            u.c c2 = Build.VERSION.SDK_INT >= 29 ? new u.b(u2) : new u.a(u2);
            c2.c(b.a(n4, n2, n5, n6));
            u2 = c2.a();
        }
        return l.H((View)view, (u)u2);
    }
}

