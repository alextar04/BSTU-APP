/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package f.f.b.i.l;

import f.f.b.i.c;
import f.f.b.i.d;
import f.f.b.i.l.d;
import f.f.b.i.l.f;
import f.f.b.i.l.g;
import f.f.b.i.l.j;
import f.f.b.i.l.k;
import f.f.b.i.l.l;
import java.util.List;

public abstract class m
implements d {
    public int a;
    public f.f.b.i.d b;
    public k c;
    public d.a d;
    public g e = new g(this);
    public int f = 0;
    public boolean g = false;
    public f h = new f(this);
    public f i = new f(this);
    public a j = a.e;

    public m(f.f.b.i.d d2) {
        this.b = d2;
    }

    @Override
    public void a(d d2) {
    }

    public final void b(f f2, f f3, int n2) {
        f2.l.add((Object)f3);
        f2.f = n2;
        f3.k.add((Object)f2);
    }

    public final void c(f f2, f f3, int n2, g g2) {
        f2.l.add((Object)f3);
        f2.l.add((Object)this.e);
        f2.h = n2;
        f2.i = g2;
        f3.k.add((Object)f2);
        g2.k.add((Object)f2);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int n2, int n3) {
        block6 : {
            int n4;
            block7 : {
                block5 : {
                    if (n3 != 0) break block5;
                    f.f.b.i.d d2 = this.b;
                    int n5 = d2.n;
                    n4 = Math.max((int)d2.m, (int)n2);
                    if (n5 > 0) {
                        n4 = Math.min((int)n5, (int)n2);
                    }
                    if (n4 == n2) break block6;
                    break block7;
                }
                f.f.b.i.d d3 = this.b;
                int n6 = d3.q;
                n4 = Math.max((int)d3.p, (int)n2);
                if (n6 > 0) {
                    n4 = Math.min((int)n6, (int)n2);
                }
                if (n4 == n2) break block6;
            }
            n2 = n4;
        }
        return n2;
    }

    public final f h(c c2) {
        m m2;
        c c3 = c2.d;
        if (c3 == null) {
            return null;
        }
        f.f.b.i.d d2 = c3.b;
        int n2 = c3.c.ordinal();
        if (n2 != 1) {
            if (n2 != 2) {
                m m3;
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return null;
                        }
                        return d2.e.k;
                    }
                    m3 = d2.e;
                } else {
                    m3 = d2.d;
                }
                return m3.i;
            }
            m2 = d2.e;
        } else {
            m2 = d2.d;
        }
        return m2.h;
    }

    public final f i(c c2, int n2) {
        c c3 = c2.d;
        if (c3 == null) {
            return null;
        }
        f.f.b.i.d d2 = c3.b;
        m m2 = n2 == 0 ? d2.d : d2.e;
        int n3 = c2.d.c.ordinal();
        if (n3 != 1 && n3 != 2) {
            if (n3 != 3 && n3 != 4) {
                return null;
            }
            return m2.i;
        }
        return m2.h;
    }

    public long j() {
        g g2 = this.e;
        if (g2.j) {
            return g2.g;
        }
        return 0L;
    }

    public abstract boolean k();

    public void l(c c2, c c3, int n2) {
        block4 : {
            int n3;
            f f2;
            int n4;
            int n5;
            f f3;
            block5 : {
                g g2;
                int n6;
                block10 : {
                    int n7;
                    block11 : {
                        block6 : {
                            g g3;
                            block7 : {
                                block8 : {
                                    block9 : {
                                        d.a a2;
                                        d.a a3;
                                        f2 = this.h(c2);
                                        f3 = this.h(c3);
                                        if (!f2.j) break block4;
                                        if (!f3.j) {
                                            return;
                                        }
                                        n3 = f2.g + c2.b();
                                        n5 = f3.g - c3.b();
                                        n4 = n5 - n3;
                                        g3 = this.e;
                                        if (g3.j || (a2 = this.d) != (a3 = d.a.g)) break block5;
                                        int n8 = this.a;
                                        if (n8 == 0) break block6;
                                        if (n8 == 1) break block7;
                                        if (n8 == 2) break block8;
                                        if (n8 != 3) break block5;
                                        f.f.b.i.d d2 = this.b;
                                        j j2 = d2.d;
                                        if (j2.d != a3 || j2.a != 3) break block9;
                                        l l2 = d2.e;
                                        if (l2.d == a3 && l2.a == 3) break block5;
                                    }
                                    f.f.b.i.d d3 = this.b;
                                    m m2 = n2 == 0 ? d3.e : d3.d;
                                    g g4 = m2.e;
                                    if (!g4.j) break block5;
                                    float f4 = this.b.N;
                                    n6 = n2 == 1 ? (int)(0.5f + (float)g4.g / f4) : (int)(0.5f + f4 * (float)g4.g);
                                    g2 = this.e;
                                    break block10;
                                }
                                f.f.b.i.d d4 = this.b.K;
                                if (d4 == null) break block5;
                                m m3 = n2 == 0 ? d4.d : d4.e;
                                if (!m3.e.j) break block5;
                                f.f.b.i.d d5 = this.b;
                                float f5 = n2 == 0 ? d5.o : d5.r;
                                n7 = (int)(0.5f + f5 * (float)m3.e.g);
                                break block11;
                            }
                            int n9 = this.g(g3.m, n2);
                            g2 = this.e;
                            n6 = Math.min((int)n9, (int)n4);
                            break block10;
                        }
                        n7 = n4;
                    }
                    g2 = this.e;
                    n6 = this.g(n7, n2);
                }
                g2.c(n6);
            }
            g g5 = this.e;
            if (!g5.j) {
                return;
            }
            if (g5.g == n4) {
                this.h.c(n3);
                this.i.c(n5);
                return;
            }
            f.f.b.i.d d6 = this.b;
            float f6 = n2 == 0 ? d6.U : d6.V;
            if (f2 == f3) {
                n3 = f2.g;
                n5 = f3.g;
                f6 = 0.5f;
            }
            int n10 = n5 - n3 - this.e.g;
            this.h.c((int)(0.5f + (float)n3 + f6 * (float)n10));
            this.i.c(this.h.g + this.e.g);
        }
    }

}

