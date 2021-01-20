/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.i.h
 *  f.f.b.i.l.f
 *  f.f.b.i.l.m
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.List
 */
package f.f.b.i.l;

import f.f.b.i.a;
import f.f.b.i.h;
import f.f.b.i.l.d;
import f.f.b.i.l.f;
import f.f.b.i.l.j;
import f.f.b.i.l.k;
import f.f.b.i.l.l;
import f.f.b.i.l.m;
import java.util.Iterator;
import java.util.List;

public class i
extends m {
    public i(f.f.b.i.d d2) {
        super(d2);
    }

    public void a(d d2) {
        a a2 = (a)((Object)this.b);
        int n2 = a2.h0;
        int n3 = 0;
        Iterator iterator = this.h.l.iterator();
        int n4 = -1;
        while (iterator.hasNext()) {
            int n5 = ((f)iterator.next()).g;
            if (n4 == -1 || n5 < n4) {
                n4 = n5;
            }
            if (n3 >= n5) continue;
            n3 = n5;
        }
        if (n2 != 0 && n2 != 2) {
            this.h.c(n3 + a2.j0);
            return;
        }
        this.h.c(n4 + a2.j0);
    }

    public void d() {
        block10 : {
            m m2;
            block13 : {
                block14 : {
                    boolean bl;
                    int n2;
                    a a2;
                    block11 : {
                        block12 : {
                            f.f.b.i.d d2 = this.b;
                            if (!(d2 instanceof a)) break block10;
                            f f2 = this.h;
                            f2.b = true;
                            a2 = (a)((Object)d2);
                            int n3 = a2.h0;
                            bl = a2.i0;
                            if (n3 == 0) break block11;
                            if (n3 == 1) break block12;
                            if (n3 != 2) {
                                if (n3 != 3) {
                                    return;
                                }
                                f2.e = f.a.k;
                                for (n2 = 0; n2 < a2.g0; ++n2) {
                                    f.f.b.i.d d3 = a2.f0[n2];
                                    if (!bl && d3.X == 8) continue;
                                    f f3 = d3.e.i;
                                    f3.k.add((Object)this.h);
                                    this.h.l.add((Object)f3);
                                }
                            } else {
                                f2.e = f.a.j;
                                while (n2 < a2.g0) {
                                    f.f.b.i.d d4 = a2.f0[n2];
                                    if (bl || d4.X != 8) {
                                        f f4 = d4.e.h;
                                        f4.k.add((Object)this.h);
                                        this.h.l.add((Object)f4);
                                    }
                                    ++n2;
                                }
                            }
                            this.m(this.b.e.h);
                            m2 = this.b.e;
                            break block13;
                        }
                        f2.e = f.a.i;
                        while (n2 < a2.g0) {
                            f.f.b.i.d d5 = a2.f0[n2];
                            if (bl || d5.X != 8) {
                                f f5 = d5.d.i;
                                f5.k.add((Object)this.h);
                                this.h.l.add((Object)f5);
                            }
                            ++n2;
                        }
                        break block14;
                    }
                    f2.e = f.a.h;
                    while (n2 < a2.g0) {
                        f.f.b.i.d d6 = a2.f0[n2];
                        if (bl || d6.X != 8) {
                            f f6 = d6.d.h;
                            f6.k.add((Object)this.h);
                            this.h.l.add((Object)f6);
                        }
                        ++n2;
                    }
                }
                this.m(this.b.d.h);
                m2 = this.b.d;
            }
            this.m(m2.i);
        }
    }

    public void e() {
        f.f.b.i.d d2 = this.b;
        if (d2 instanceof a) {
            int n2 = ((a)d2).h0;
            if (n2 != 0 && n2 != 1) {
                d2.Q = this.h.g;
                return;
            }
            this.b.P = this.h.g;
        }
    }

    public void f() {
        this.c = null;
        this.h.b();
    }

    public boolean k() {
        return false;
    }

    public final void m(f f2) {
        this.h.k.add((Object)f2);
        f2.l.add((Object)this.h);
    }
}

