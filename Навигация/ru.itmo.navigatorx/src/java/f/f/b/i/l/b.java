/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$b
 *  f.f.b.i.e
 *  java.lang.Object
 *  java.util.ArrayList
 */
package f.f.b.i.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.b.i.d;
import f.f.b.i.e;
import java.util.ArrayList;

public class b {
    public final ArrayList<d> a = new ArrayList();
    public a b = new a();
    public e c;

    public b(e e2) {
        this.c = e2;
    }

    public final boolean a(b b2, d d2, boolean bl) {
        int n2;
        d.a a2 = d.a.e;
        d.a a3 = d.a.g;
        this.b.a = d2.j();
        this.b.b = d2.n();
        this.b.c = d2.o();
        this.b.d = d2.i();
        a a4 = this.b;
        a4.i = false;
        a4.j = bl;
        d.a a5 = a4.a;
        int n3 = 1;
        int n4 = a5 == a3 ? n3 : 0;
        int n5 = this.b.b == a3 ? n3 : 0;
        int n6 = n4 != 0 && d2.N > 0.0f ? n3 : 0;
        int n7 = n5 != 0 && d2.N > 0.0f ? n3 : 0;
        if (n6 != 0 && d2.l[0] == 4) {
            this.b.a = a2;
        }
        if (n7 != 0 && d2.l[n3] == 4) {
            this.b.b = a2;
        }
        a a6 = this.b;
        ((ConstraintLayout.b)b2).a(d2, a6);
        d2.B(this.b.e);
        d2.w(this.b.f);
        a a7 = this.b;
        d2.w = a7.h;
        d2.R = n2 = a7.g;
        if (n2 <= 0) {
            n3 = 0;
        }
        d2.w = n3;
        a a8 = this.b;
        a8.j = false;
        return a8.i;
    }

    public final void b(e e2, int n2, int n3) {
        int n4 = e2.S;
        int n5 = e2.T;
        e2.z(0);
        e2.y(0);
        e2.L = n2;
        int n6 = e2.S;
        if (n2 < n6) {
            e2.L = n6;
        }
        e2.M = n3;
        int n7 = e2.T;
        if (n3 < n7) {
            e2.M = n7;
        }
        e2.z(n4);
        e2.y(n5);
        this.c.E();
    }

    public static class a {
        public d.a a;
        public d.a b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public boolean j;
    }

    public static interface b {
    }

}

