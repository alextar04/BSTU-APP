/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.b
 *  f.f.b.i.h
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.f.b.i;

import f.f.b.b;
import f.f.b.g;
import f.f.b.i.c;
import f.f.b.i.d;
import f.f.b.i.h;

public class a
extends h {
    public int h0 = 0;
    public boolean i0 = true;
    public int j0 = 0;

    public void b(f.f.b.d d2) {
        block10 : {
            c c2;
            g g2;
            block12 : {
                int n2;
                block14 : {
                    block13 : {
                        block11 : {
                            boolean bl;
                            c c3;
                            block9 : {
                                c[] arrc;
                                d.a a2 = d.a.g;
                                c[] arrc2 = ((d)this).G;
                                arrc2[0] = ((d)this).y;
                                arrc2[2] = ((d)this).z;
                                arrc2[1] = ((d)this).A;
                                arrc2[3] = ((d)this).B;
                                for (int i2 = 0; i2 < (arrc = ((d)this).G).length; ++i2) {
                                    arrc[i2].g = d2.l(arrc[i2]);
                                }
                                int n3 = this.h0;
                                if (n3 < 0 || n3 >= 4) break block10;
                                c3 = arrc[n3];
                                for (int i3 = 0; i3 < this.g0; ++i3) {
                                    int n4;
                                    int n5;
                                    d d3 = this.f0[i3];
                                    if (!this.i0 && !d3.c() || ((n5 = this.h0) != 0 && n5 != 1 || d3.j() != a2 || d3.y.d == null || d3.A.d == null) && ((n4 = this.h0) != 2 && n4 != 3 || d3.n() != a2 || d3.z.d == null || d3.B.d == null)) continue;
                                    bl = true;
                                    break block9;
                                }
                                bl = false;
                            }
                            boolean bl2 = ((d)this).y.c() || ((d)this).A.c();
                            boolean bl3 = ((d)this).z.c() || ((d)this).B.c();
                            boolean bl4 = !bl && (this.h0 == 0 && bl2 || this.h0 == 2 && bl3 || this.h0 == 1 && bl2 || this.h0 == 3 && bl3);
                            int n6 = 5;
                            if (!bl4) {
                                n6 = 4;
                            }
                            for (int i4 = 0; i4 < this.g0; ++i4) {
                                d d4 = this.f0[i4];
                                if (!this.i0 && !d4.c()) continue;
                                g g3 = d2.l(d4.G[this.h0]);
                                c[] arrc = d4.G;
                                int n7 = this.h0;
                                arrc[n7].g = g3;
                                int n8 = arrc[n7].d != null && arrc[n7].d.b == this ? 0 + arrc[n7].e : 0;
                                int n9 = this.h0;
                                if (n9 != 0 && n9 != 2) {
                                    g g4 = c3.g;
                                    int n10 = n8 + this.j0;
                                    b b2 = d2.m();
                                    g g5 = d2.n();
                                    g5.e = 0;
                                    b2.e(g4, g3, g5, n10);
                                    d2.c(b2);
                                } else {
                                    g g6 = c3.g;
                                    int n11 = this.j0 - n8;
                                    b b3 = d2.m();
                                    g g7 = d2.n();
                                    g7.e = 0;
                                    b3.f(g6, g3, g7, n11);
                                    d2.c(b3);
                                }
                                d2.d(c3.g, g3, n8 + this.j0, n6);
                            }
                            n2 = this.h0;
                            if (n2 != 0) break block11;
                            d2.d(this.A.g, this.y.g, 0, 8);
                            d2.d(this.y.g, this.K.A.g, 0, 4);
                            g2 = this.y.g;
                            c2 = this.K.y;
                            break block12;
                        }
                        if (n2 != 1) break block13;
                        d2.d(this.y.g, this.A.g, 0, 8);
                        d2.d(this.y.g, this.K.y.g, 0, 4);
                        g2 = this.y.g;
                        c2 = this.K.A;
                        break block12;
                    }
                    if (n2 != 2) break block14;
                    d2.d(this.B.g, this.z.g, 0, 8);
                    d2.d(this.z.g, this.K.B.g, 0, 4);
                    g2 = this.z.g;
                    c2 = this.K.z;
                    break block12;
                }
                if (n2 != 3) break block10;
                d2.d(this.z.g, this.B.g, 0, 8);
                d2.d(this.z.g, this.K.z.g, 0, 4);
                g2 = this.z.g;
                c2 = this.K.B;
            }
            d2.d(g2, c2.g, 0, 0);
        }
    }

    public boolean c() {
        return true;
    }

    public String toString() {
        String string = c.b.a.a.a.l(c.b.a.a.a.c("[Barrier] "), ((d)this).Y, " {");
        for (int i2 = 0; i2 < this.g0; ++i2) {
            d d2 = this.f0[i2];
            if (i2 > 0) {
                string = c.b.a.a.a.j(string, ", ");
            }
            StringBuilder stringBuilder = c.b.a.a.a.c(string);
            stringBuilder.append(d2.Y);
            string = stringBuilder.toString();
        }
        return c.b.a.a.a.j(string, "}");
    }
}

