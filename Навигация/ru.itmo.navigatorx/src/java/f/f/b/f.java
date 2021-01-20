/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.b
 *  java.lang.Comparable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Comparator
 */
package f.f.b;

import f.f.b.b;
import f.f.b.c;
import f.f.b.d;
import f.f.b.f;
import f.f.b.g;
import java.util.Arrays;
import java.util.Comparator;

public class f
extends f.f.b.b {
    public int g = 128;
    public g[] h = new g[128];
    public g[] i = new g[128];
    public int j = 0;
    public b k = new Comparable(this){
        public g e;

        public int compareTo(Object object) {
            g g2 = (g)object;
            return this.e.c - g2.c;
        }

        public String toString() {
            g g2 = this.e;
            String string = "[ ";
            if (g2 != null) {
                for (int i2 = 0; i2 < 9; ++i2) {
                    StringBuilder stringBuilder = c.b.a.a.a.c(string);
                    stringBuilder.append(this.e.i[i2]);
                    stringBuilder.append(" ");
                    string = stringBuilder.toString();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("] ");
            stringBuilder.append((Object)this.e);
            return stringBuilder.toString();
        }
    };

    public f(c c2) {
        super(c2);
    }

    public void a(g g2) {
        this.k.e = g2;
        Arrays.fill((float[])g2.i, (float)0.0f);
        g2.i[g2.e] = 1.0f;
        this.m(g2);
    }

    public g b(d d2, boolean[] arrbl) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.j; ++i2) {
            block12 : {
                block11 : {
                    g[] arrg;
                    boolean bl;
                    b b2;
                    int n3;
                    block9 : {
                        block10 : {
                            block7 : {
                                float f2;
                                arrg = this.h;
                                g g2 = arrg[i2];
                                if (arrbl[g2.c]) continue;
                                b2 = this.k;
                                b2.e = g2;
                                bl = true;
                                if (n2 != -1) break block9;
                                if (b2 == null) break block10;
                                for (n3 = 8; n3 >= 0 && !((f2 = b2.e.i[n3]) > 0.0f); --n3) {
                                    if (!(f2 < 0.0f)) {
                                        continue;
                                    }
                                    break block7;
                                }
                                bl = false;
                            }
                            if (!bl) continue;
                            break block11;
                        }
                        throw null;
                    }
                    g g3 = arrg[n2];
                    if (b2 != null) {
                        block8 : {
                            while (n3 >= 0) {
                                float f3 = b2.e.i[n3];
                                float f4 = g3.i[n3];
                                if (f3 == f4) {
                                    --n3;
                                    continue;
                                }
                                if (f3 < f4) break block8;
                            }
                            bl = false;
                        }
                        if (!bl) continue;
                    }
                    break block12;
                }
                n2 = i2;
                continue;
            }
            throw null;
        }
        if (n2 == -1) {
            return null;
        }
        return this.h[n2];
    }

    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    public void l(f.f.b.b b2, boolean bl) {
        g g2 = b2.a;
        if (g2 == null) {
            return;
        }
        b.a a2 = b2.e;
        int n2 = a2.k();
        for (int i2 = 0; i2 < n2; ++i2) {
            g g3 = a2.f(i2);
            float f2 = a2.a(i2);
            b b3 = this.k;
            b3.e = g3;
            boolean bl2 = g3.a;
            boolean bl3 = true;
            if (bl2) {
                for (int i3 = 0; i3 < 9; ++i3) {
                    float[] arrf = b3.e.i;
                    arrf[i3] = arrf[i3] + f2 * g2.i[i3];
                    if (Math.abs((float)arrf[i3]) < 1.0E-4f) {
                        b3.e.i[i3] = 0.0f;
                        continue;
                    }
                    bl3 = false;
                }
                if (bl3) {
                    b3.f.this.n(b3.e);
                }
                bl3 = false;
            } else {
                for (int i4 = 0; i4 < 9; ++i4) {
                    float f3 = g2.i[i4];
                    if (f3 != 0.0f) {
                        float f4 = f3 * f2;
                        if (Math.abs((float)f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        b3.e.i[i4] = f4;
                        continue;
                    }
                    b3.e.i[i4] = 0.0f;
                }
            }
            if (bl3) {
                this.m(g3);
            }
            this.b += f2 * b2.b;
        }
        this.n(g2);
    }

    public final void m(g g2) {
        int n2;
        int n3 = 1 + this.j;
        Object[] arrobject = this.h;
        if (n3 > arrobject.length) {
            Object[] arrobject2 = (g[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
            this.h = arrobject2;
            this.i = (g[])Arrays.copyOf((Object[])arrobject2, (int)(2 * arrobject2.length));
        }
        g[] arrg = this.h;
        int n4 = this.j;
        arrg[n4] = g2;
        this.j = n2 = n4 + 1;
        if (n2 > 1 && arrg[n2 - 1].c > g2.c) {
            int n5;
            int n6 = 0;
            for (int i2 = 0; i2 < (n5 = this.j); ++i2) {
                this.i[i2] = this.h[i2];
            }
            Arrays.sort((Object[])this.i, (int)0, (int)n5, (Comparator)new Comparator<g>(this){

                public int compare(Object object, Object object2) {
                    g g2 = (g)object;
                    g g3 = (g)object2;
                    return g2.c - g3.c;
                }
            });
            while (n6 < this.j) {
                this.h[n6] = this.i[n6];
                ++n6;
            }
        }
        g2.a = true;
        g2.a(this);
    }

    public final void n(g g2) {
        for (int i2 = 0; i2 < this.j; ++i2) {
            int n2;
            if (this.h[i2] != g2) continue;
            while (i2 < (n2 = this.j) - 1) {
                g[] arrg = this.h;
                int n3 = i2 + 1;
                arrg[i2] = arrg[n3];
                i2 = n3;
            }
            this.j = n2 - 1;
            g2.a = false;
            return;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(" goal -> (");
        stringBuilder.append(this.b);
        stringBuilder.append(") : ");
        String string = stringBuilder.toString();
        for (int i2 = 0; i2 < this.j; ++i2) {
            g g2;
            this.k.e = g2 = this.h[i2];
            StringBuilder stringBuilder2 = c.b.a.a.a.c(string);
            stringBuilder2.append((Object)this.k);
            stringBuilder2.append(" ");
            string = stringBuilder2.toString();
        }
        return string;
    }

}

