/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$m
 *  androidx.recyclerview.widget.RecyclerView$r
 *  androidx.recyclerview.widget.RecyclerView$w
 *  androidx.recyclerview.widget.RecyclerView$z
 *  f.p.d.a$a
 *  f.p.d.a$b
 *  f.p.d.c
 *  java.lang.Object
 *  java.util.ArrayList
 */
package f.p.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import f.p.d.a;
import f.p.d.c;
import java.util.ArrayList;

public class y
implements a.a {
    public final /* synthetic */ RecyclerView a;

    public y(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(a.b b2) {
        int n2 = b2.a;
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 4) {
                    if (n2 != 8) {
                        return;
                    }
                    RecyclerView recyclerView = this.a;
                    recyclerView.p.o0(recyclerView, b2.b, b2.d, 1);
                    return;
                }
                RecyclerView recyclerView = this.a;
                recyclerView.p.r0(recyclerView, b2.b, b2.d, b2.c);
                return;
            }
            RecyclerView recyclerView = this.a;
            recyclerView.p.p0(recyclerView, b2.b, b2.d);
            return;
        }
        RecyclerView recyclerView = this.a;
        recyclerView.p.m0(recyclerView, b2.b, b2.d);
    }

    public RecyclerView.z b(int n2) {
        RecyclerView recyclerView = this.a;
        int n3 = recyclerView.i.h();
        RecyclerView.z z2 = null;
        for (int i2 = 0; i2 < n3; ++i2) {
            RecyclerView.z z3 = RecyclerView.K((View)recyclerView.i.g(i2));
            if (z3 == null || z3.l() || z3.c != n2) continue;
            if (recyclerView.i.k(z3.a)) {
                z2 = z3;
                continue;
            }
            z2 = z3;
            break;
        }
        if (z2 == null) {
            return null;
        }
        if (this.a.i.k(z2.a)) {
            return null;
        }
        return z2;
    }

    public void c(int n2, int n3, Object object) {
        RecyclerView recyclerView = this.a;
        int n4 = recyclerView.i.h();
        int n5 = n3 + n2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n6;
            View view = recyclerView.i.g(i2);
            RecyclerView.z z2 = RecyclerView.K((View)view);
            if (z2 == null || z2.t() || (n6 = z2.c) < n2 || n6 >= n5) continue;
            z2.b(2);
            z2.a(object);
            ((RecyclerView.m)view.getLayoutParams()).c = true;
        }
        RecyclerView.r r2 = recyclerView.f;
        int n7 = r2.c.size();
        while (--n7 >= 0) {
            int n8;
            RecyclerView.z z3 = (RecyclerView.z)r2.c.get(n7);
            if (z3 == null || (n8 = z3.c) < n2 || n8 >= n5) continue;
            z3.b(2);
            r2.f(n7);
        }
        this.a.n0 = true;
    }

    public void d(int n2, int n3) {
        RecyclerView recyclerView = this.a;
        int n4 = recyclerView.i.h();
        int n5 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            RecyclerView.z z2 = RecyclerView.K((View)recyclerView.i.g(i2));
            if (z2 == null || z2.t() || z2.c < n2) continue;
            z2.p(n3, false);
            recyclerView.j0.f = true;
        }
        RecyclerView.r r2 = recyclerView.f;
        int n6 = r2.c.size();
        while (n5 < n6) {
            RecyclerView.z z3 = (RecyclerView.z)r2.c.get(n5);
            if (z3 != null && z3.c >= n2) {
                z3.p(n3, true);
            }
            ++n5;
        }
        recyclerView.requestLayout();
        this.a.m0 = true;
    }

    public void e(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        RecyclerView recyclerView = this.a;
        int n9 = recyclerView.i.h();
        int n10 = -1;
        if (n2 < n3) {
            n6 = n2;
            n4 = n3;
            n8 = n10;
        } else {
            n4 = n2;
            n6 = n3;
            n8 = 1;
        }
        for (int i2 = 0; i2 < n9; ++i2) {
            int n11;
            RecyclerView.z z2 = RecyclerView.K((View)recyclerView.i.g(i2));
            if (z2 == null || (n11 = z2.c) < n6 || n11 > n4) continue;
            if (n11 == n2) {
                z2.p(n3 - n2, false);
            } else {
                z2.p(n8, false);
            }
            recyclerView.j0.f = true;
        }
        RecyclerView.r r2 = recyclerView.f;
        if (n2 < n3) {
            n7 = n2;
            n5 = n3;
        } else {
            n5 = n2;
            n7 = n3;
            n10 = 1;
        }
        int n12 = r2.c.size();
        for (int i3 = 0; i3 < n12; ++i3) {
            int n13;
            RecyclerView.z z3 = (RecyclerView.z)r2.c.get(i3);
            if (z3 == null || (n13 = z3.c) < n7 || n13 > n5) continue;
            if (n13 == n2) {
                z3.p(n3 - n2, false);
                continue;
            }
            z3.p(n10, false);
        }
        recyclerView.requestLayout();
        this.a.m0 = true;
    }
}

