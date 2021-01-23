/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.util.AndroidRuntimeException
 *  android.view.View
 *  android.view.ViewGroup
 *  f.r.e
 *  f.r.i
 *  f.r.i$c
 *  f.r.i$d
 *  f.r.n
 *  f.r.o$a
 *  f.r.o$b
 *  f.r.q
 *  f.r.r
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package f.r;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import f.r.e;
import f.r.i;
import f.r.n;
import f.r.o;
import f.r.q;
import f.r.r;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Exception performing whole class analysis.
 */
public class o
extends i {
    public ArrayList<i> M;
    public boolean N;
    public int O;
    public boolean P;
    public int Q;

    public o() {
        this.M = new ArrayList();
        this.N = true;
        this.P = false;
        this.Q = 0;
    }

    public i A(long l2) {
        ArrayList<i> arrayList;
        this.g = l2;
        if (l2 >= 0L && (arrayList = this.M) != null) {
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ((i)this.M.get(i2)).A(l2);
            }
        }
        return this;
    }

    public void B(i.c c2) {
        this.H = c2;
        this.Q = 8 | this.Q;
        int n2 = this.M.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((i)this.M.get(i2)).B(c2);
        }
    }

    public i C(TimeInterpolator timeInterpolator) {
        this.Q = 1 | this.Q;
        ArrayList<i> arrayList = this.M;
        if (arrayList != null) {
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ((i)this.M.get(i2)).C(timeInterpolator);
            }
        }
        this.h = timeInterpolator;
        return this;
    }

    public void D(e e2) {
        e e3 = e2 == null ? i.K : e2;
        this.I = e3;
        this.Q = 4 | this.Q;
        if (this.M != null) {
            for (int i2 = 0; i2 < this.M.size(); ++i2) {
                ((i)this.M.get(i2)).D(e2);
            }
        }
    }

    public void E(n n2) {
        this.G = n2;
        this.Q = 2 | this.Q;
        int n3 = this.M.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            ((i)this.M.get(i2)).E(n2);
        }
    }

    public i F(long l2) {
        this.f = l2;
        return this;
    }

    public String H(String string) {
        String string2 = super.H(string);
        for (int i2 = 0; i2 < this.M.size(); ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("\n");
            i i3 = (i)this.M.get(i2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append("  ");
            stringBuilder.append(i3.H(stringBuilder2.toString()));
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public o I(i i2) {
        this.M.add((Object)i2);
        i2.v = this;
        long l2 = this.g;
        if (l2 >= 0L) {
            i2.A(l2);
        }
        if ((1 & this.Q) != 0) {
            i2.C(this.h);
        }
        if ((2 & this.Q) != 0) {
            i2.E(null);
        }
        if ((4 & this.Q) != 0) {
            i2.D(this.I);
        }
        if ((8 & this.Q) != 0) {
            i2.B(this.H);
        }
        return this;
    }

    public i J(int n2) {
        if (n2 >= 0 && n2 < this.M.size()) {
            return (i)this.M.get(n2);
        }
        return null;
    }

    public o K(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                this.N = false;
                return this;
            }
            throw new AndroidRuntimeException(c.b.a.a.a.b("Invalid parameter for TransitionSet ordering: ", n2));
        }
        this.N = true;
        return this;
    }

    public i a(i.d d2) {
        super.a(d2);
        return this;
    }

    public i b(View view) {
        for (int i2 = 0; i2 < this.M.size(); ++i2) {
            ((i)this.M.get(i2)).b(view);
        }
        this.j.add((Object)view);
        return this;
    }

    public void d() {
        super.d();
        int n2 = this.M.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((i)this.M.get(i2)).d();
        }
    }

    public void e(q q2) {
        if (this.t(q2.b)) {
            for (i i2 : this.M) {
                if (!i2.t(q2.b)) continue;
                i2.e(q2);
                q2.c.add((Object)i2);
            }
        }
    }

    public void g(q q2) {
        int n2 = this.M.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((i)this.M.get(i2)).g(q2);
        }
    }

    public void h(q q2) {
        if (this.t(q2.b)) {
            for (i i2 : this.M) {
                if (!i2.t(q2.b)) continue;
                i2.h(q2);
                q2.c.add((Object)i2);
            }
        }
    }

    public i k() {
        o o2 = (o)super.k();
        o2.M = new ArrayList();
        int n2 = this.M.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = ((i)this.M.get(i2)).k();
            o2.M.add((Object)i3);
            i3.v = o2;
        }
        return o2;
    }

    public void m(ViewGroup viewGroup, r r2, r r3, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        long l2 = this.f;
        int n2 = this.M.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = (i)this.M.get(i2);
            if (l2 > 0L && (this.N || i2 == 0)) {
                long l3 = i3.f;
                if (l3 > 0L) {
                    i3.F(l3 + l2);
                } else {
                    i3.F(l2);
                }
            }
            i3.m(viewGroup, r2, r3, arrayList, arrayList2);
        }
    }

    public void v(View view) {
        super.v(view);
        int n2 = this.M.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((i)this.M.get(i2)).v(view);
        }
    }

    public i w(i.d d2) {
        super.w(d2);
        return this;
    }

    public i x(View view) {
        for (int i2 = 0; i2 < this.M.size(); ++i2) {
            ((i)this.M.get(i2)).x(view);
        }
        this.j.remove((Object)view);
        return this;
    }

    public void y(View view) {
        super.y(view);
        int n2 = this.M.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((i)this.M.get(i2)).y(view);
        }
    }

    public void z() {
        if (this.M.isEmpty()) {
            this.G();
            this.n();
            return;
        }
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        Iterator iterator = this.M.iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).a((i.d)b2);
        }
        this.O = this.M.size();
        if (!this.N) {
            for (int i2 = 1; i2 < this.M.size(); ++i2) {
                ((i)this.M.get(i2 - 1)).a((i.d)new a(this, (i)this.M.get(i2)));
            }
            i i3 = (i)this.M.get(0);
            if (i3 != null) {
                i3.z();
                return;
            }
        } else {
            Iterator iterator2 = this.M.iterator();
            while (iterator2.hasNext()) {
                ((i)iterator2.next()).z();
            }
        }
    }
}

