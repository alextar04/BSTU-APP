/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package f.f.b;

import c.b.a.a.a;
import f.f.b.b;
import f.f.b.c;
import f.f.b.g;
import java.util.Arrays;

public class h
implements b.a {
    public int a = 16;
    public int b = 16;
    public int[] c = new int[16];
    public int[] d = new int[16];
    public int[] e = new int[16];
    public float[] f = new float[16];
    public int[] g = new int[16];
    public int[] h = new int[16];
    public int i = 0;
    public int j = -1;
    public final b k;
    public final c l;

    public h(b b2, c c2) {
        this.k = b2;
        this.l = c2;
        this.clear();
    }

    @Override
    public float a(int n2) {
        int n3 = this.i;
        int n4 = this.j;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (i2 == n2) {
                return this.f[n4];
            }
            if ((n4 = this.h[n4]) == -1) break;
        }
        return 0.0f;
    }

    @Override
    public float b(b b2, boolean bl) {
        float f2 = this.g(b2.a);
        this.d(b2.a, bl);
        h h2 = (h)b2.e;
        int n2 = h2.i;
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            int[] arrn = h2.e;
            if (arrn[n4] != -1) {
                float f3 = h2.f[n4];
                this.e(this.l.d[arrn[n4]], f3 * f2, bl);
                ++n3;
            }
            ++n4;
        }
        return f2;
    }

    @Override
    public void c(g g2, float f2) {
        int n2;
        int n3;
        block16 : {
            if (f2 > -0.001f && f2 < 0.001f) {
                this.d(g2, true);
                return;
            }
            if (this.i == 0) {
                this.m(0, g2, f2);
                this.l(g2, 0);
                this.j = 0;
                return;
            }
            int n4 = this.n(g2);
            if (n4 != -1) {
                this.f[n4] = f2;
                return;
            }
            int n5 = 1 + this.i;
            int n6 = this.a;
            if (n5 >= n6) {
                int n7 = n6 * 2;
                this.e = Arrays.copyOf((int[])this.e, (int)n7);
                this.f = Arrays.copyOf((float[])this.f, (int)n7);
                this.g = Arrays.copyOf((int[])this.g, (int)n7);
                this.h = Arrays.copyOf((int[])this.h, (int)n7);
                this.d = Arrays.copyOf((int[])this.d, (int)n7);
                for (int i2 = this.a; i2 < n7; ++i2) {
                    this.e[i2] = -1;
                    this.d[i2] = -1;
                }
                this.a = n7;
            }
            int n8 = this.i;
            int n9 = this.j;
            int n10 = 0;
            n3 = -1;
            do {
                n2 = 0;
                if (n10 >= n8) break;
                int[] arrn = this.e;
                int n11 = arrn[n9];
                int n12 = g2.c;
                if (n11 == n12) {
                    this.f[n9] = f2;
                    return;
                }
                if (arrn[n9] < n12) {
                    n3 = n9;
                }
                if ((n9 = this.h[n9]) == -1) {
                    n2 = 0;
                    break;
                }
                ++n10;
            } while (true);
            while (n2 < this.a) {
                if (this.e[n2] != -1) {
                    ++n2;
                    continue;
                }
                break block16;
            }
            n2 = -1;
        }
        this.m(n2, g2, f2);
        int[] arrn = this.g;
        if (n3 != -1) {
            arrn[n2] = n3;
            int[] arrn2 = this.h;
            arrn2[n2] = arrn2[n3];
            arrn2[n3] = n2;
        } else {
            arrn[n2] = -1;
            if (this.i > 0) {
                this.h[n2] = this.j;
                this.j = n2;
            } else {
                this.h[n2] = -1;
            }
        }
        int[] arrn3 = this.h;
        if (arrn3[n2] != -1) {
            this.g[arrn3[n2]] = n2;
        }
        this.l(g2, n2);
    }

    @Override
    public void clear() {
        int n2 = this.i;
        for (int i2 = 0; i2 < n2; ++i2) {
            g g2 = this.f(i2);
            if (g2 == null) continue;
            g2.b(this.k);
        }
        for (int i3 = 0; i3 < this.a; ++i3) {
            this.e[i3] = -1;
            this.d[i3] = -1;
        }
        for (int i4 = 0; i4 < this.b; ++i4) {
            this.c[i4] = -1;
        }
        this.i = 0;
        this.j = -1;
    }

    @Override
    public float d(g g2, boolean bl) {
        int[] arrn;
        int n2 = this.n(g2);
        if (n2 == -1) {
            return 0.0f;
        }
        int[] arrn2 = this.c;
        int n3 = g2.c;
        int n4 = n3 % this.b;
        int n5 = arrn2[n4];
        if (n5 != -1) {
            if (this.e[n5] == n3) {
                int[] arrn3 = this.d;
                arrn2[n4] = arrn3[n5];
                arrn3[n5] = -1;
            } else {
                int[] arrn4;
                while ((arrn4 = this.d)[n5] != -1 && this.e[arrn4[n5]] != n3) {
                    n5 = arrn4[n5];
                }
                int[] arrn5 = this.d;
                int n6 = arrn5[n5];
                if (n6 != -1 && this.e[n6] == n3) {
                    arrn5[n5] = arrn5[n6];
                    arrn5[n6] = -1;
                }
            }
        }
        float f2 = this.f[n2];
        if (this.j == n2) {
            this.j = this.h[n2];
        }
        this.e[n2] = -1;
        int[] arrn6 = this.g;
        if (arrn6[n2] != -1) {
            int[] arrn7 = this.h;
            arrn7[arrn6[n2]] = arrn7[n2];
        }
        if ((arrn = this.h)[n2] != -1) {
            int[] arrn8 = this.g;
            arrn8[arrn[n2]] = arrn8[n2];
        }
        this.i = -1 + this.i;
        g2.m = -1 + g2.m;
        if (bl) {
            g2.b(this.k);
        }
        return f2;
    }

    @Override
    public void e(g g2, float f2, boolean bl) {
        if (f2 > -0.001f && f2 < 0.001f) {
            return;
        }
        int n2 = this.n(g2);
        if (n2 == -1) {
            this.c(g2, f2);
            return;
        }
        float[] arrf = this.f;
        arrf[n2] = f2 + arrf[n2];
        if (arrf[n2] > -0.001f && arrf[n2] < 0.001f) {
            arrf[n2] = 0.0f;
            this.d(g2, bl);
        }
    }

    @Override
    public g f(int n2) {
        int n3 = this.i;
        if (n3 == 0) {
            return null;
        }
        int n4 = this.j;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (i2 == n2 && n4 != -1) {
                return this.l.d[this.e[n4]];
            }
            if ((n4 = this.h[n4]) != -1) continue;
            return null;
        }
        return null;
    }

    @Override
    public float g(g g2) {
        int n2 = this.n(g2);
        if (n2 != -1) {
            return this.f[n2];
        }
        return 0.0f;
    }

    @Override
    public boolean h(g g2) {
        return this.n(g2) != -1;
    }

    @Override
    public void i(float f2) {
        int n2 = this.i;
        int n3 = this.j;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] arrf = this.f;
            arrf[n3] = arrf[n3] / f2;
            if ((n3 = this.h[n3]) != -1) continue;
            return;
        }
    }

    @Override
    public void j() {
        int n2 = this.i;
        int n3 = this.j;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] arrf = this.f;
            arrf[n3] = -1.0f * arrf[n3];
            if ((n3 = this.h[n3]) != -1) continue;
            return;
        }
    }

    @Override
    public int k() {
        return this.i;
    }

    public final void l(g g2, int n2) {
        int[] arrn = this.c;
        int n3 = g2.c % this.b;
        int n4 = arrn[n3];
        if (n4 == -1) {
            arrn[n3] = n2;
        } else {
            int[] arrn2;
            while ((arrn2 = this.d)[n4] != -1) {
                n4 = arrn2[n4];
            }
            arrn2[n4] = n2;
        }
        this.d[n2] = -1;
    }

    public final void m(int n2, g g2, float f2) {
        this.e[n2] = g2.c;
        this.f[n2] = f2;
        this.g[n2] = -1;
        this.h[n2] = -1;
        g2.a(this.k);
        g2.m = 1 + g2.m;
        this.i = 1 + this.i;
    }

    public int n(g g2) {
        int[] arrn;
        if (this.i == 0) {
            return -1;
        }
        int n2 = g2.c;
        int n3 = n2 % this.b;
        int n4 = this.c[n3];
        if (n4 == -1) {
            return -1;
        }
        if (this.e[n4] == n2) {
            return n4;
        }
        while ((arrn = this.d)[n4] != -1 && this.e[arrn[n4]] != n2) {
            n4 = arrn[n4];
        }
        int[] arrn2 = this.d;
        if (arrn2[n4] == -1) {
            return -1;
        }
        if (this.e[arrn2[n4]] == n2) {
            return arrn2[n4];
        }
        return -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.hashCode());
        stringBuilder.append(" { ");
        String string = stringBuilder.toString();
        int n2 = this.i;
        for (int i2 = 0; i2 < n2; ++i2) {
            StringBuilder stringBuilder2;
            String string2;
            g g2 = this.f(i2);
            if (g2 == null) continue;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string);
            stringBuilder3.append((Object)g2);
            stringBuilder3.append(" = ");
            stringBuilder3.append(this.a(i2));
            stringBuilder3.append(" ");
            String string3 = stringBuilder3.toString();
            int n3 = this.n(g2);
            String string4 = a.j(string3, "[p: ");
            if (this.g[n3] != -1) {
                stringBuilder2 = a.c(string4);
                stringBuilder2.append((Object)this.l.d[this.e[this.g[n3]]]);
            } else {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string4);
                stringBuilder4.append("none");
                stringBuilder2 = stringBuilder4;
            }
            String string5 = a.j(stringBuilder2.toString(), ", n: ");
            if (this.h[n3] != -1) {
                StringBuilder stringBuilder5 = a.c(string5);
                stringBuilder5.append((Object)this.l.d[this.e[this.h[n3]]]);
                string2 = stringBuilder5.toString();
            } else {
                string2 = a.j(string5, "none");
            }
            string = a.j(string2, "]");
        }
        return a.j(string, " }");
    }
}

