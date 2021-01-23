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

import f.f.b.b;
import f.f.b.c;
import f.f.b.g;
import java.util.Arrays;

public class a
implements b.a {
    public int a = 0;
    public final b b;
    public final c c;
    public int d = 8;
    public g e = null;
    public int[] f = new int[8];
    public int[] g = new int[8];
    public float[] h = new float[8];
    public int i = -1;
    public int j = -1;
    public boolean k = false;

    public a(b b2, c c2) {
        this.b = b2;
        this.c = c2;
    }

    @Override
    public float a(int n2) {
        int n3 = this.i;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            if (i2 == n2) {
                return this.h[n3];
            }
            n3 = this.g[n3];
        }
        return 0.0f;
    }

    @Override
    public float b(b b2, boolean bl) {
        float f2 = this.g(b2.a);
        this.d(b2.a, bl);
        b.a a2 = b2.e;
        int n2 = a2.k();
        for (int i2 = 0; i2 < n2; ++i2) {
            g g2 = a2.f(i2);
            this.e(g2, f2 * a2.g(g2), bl);
        }
        return f2;
    }

    @Override
    public final void c(g g2, float f2) {
        int[] arrn;
        int[] arrn2;
        int n2;
        if (f2 == 0.0f) {
            this.d(g2, true);
            return;
        }
        int n3 = this.i;
        if (n3 == -1) {
            this.i = 0;
            this.h[0] = f2;
            this.f[0] = g2.c;
            this.g[0] = -1;
            g2.m = 1 + g2.m;
            g2.a(this.b);
            this.a = 1 + this.a;
            if (!this.k) {
                int n4;
                this.j = n4 = 1 + this.j;
                int[] arrn3 = this.f;
                if (n4 >= arrn3.length) {
                    this.k = true;
                    this.j = arrn3.length - 1;
                }
            }
            return;
        }
        int n5 = -1;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            int[] arrn4 = this.f;
            int n6 = arrn4[n3];
            int n7 = g2.c;
            if (n6 == n7) {
                this.h[n3] = f2;
                return;
            }
            if (arrn4[n3] < n7) {
                n5 = n3;
            }
            n3 = this.g[n3];
        }
        int n8 = this.j;
        int n9 = n8 + 1;
        if (this.k) {
            int[] arrn5 = this.f;
            if (arrn5[n8] != -1) {
                n8 = arrn5.length;
            }
        } else {
            n8 = n9;
        }
        int[] arrn6 = this.f;
        if (n8 >= arrn6.length && this.a < arrn6.length) {
            int[] arrn7;
            for (int i3 = 0; i3 < (arrn7 = this.f).length; ++i3) {
                if (arrn7[i3] != -1) continue;
                n8 = i3;
                break;
            }
        }
        if (n8 >= (arrn = this.f).length) {
            int n10;
            n8 = arrn.length;
            this.d = n10 = 2 * this.d;
            this.k = false;
            this.j = n8 - 1;
            this.h = Arrays.copyOf((float[])this.h, (int)n10);
            this.f = Arrays.copyOf((int[])this.f, (int)this.d);
            this.g = Arrays.copyOf((int[])this.g, (int)this.d);
        }
        this.f[n8] = g2.c;
        this.h[n8] = f2;
        int[] arrn8 = this.g;
        if (n5 != -1) {
            arrn8[n8] = arrn8[n5];
            arrn8[n5] = n8;
        } else {
            arrn8[n8] = this.i;
            this.i = n8;
        }
        g2.m = 1 + g2.m;
        g2.a(this.b);
        this.a = 1 + this.a;
        if (!this.k) {
            this.j = 1 + this.j;
        }
        if (this.a >= this.f.length) {
            this.k = true;
        }
        if ((n2 = this.j) >= (arrn2 = this.f).length) {
            this.k = true;
            this.j = arrn2.length - 1;
        }
    }

    @Override
    public final void clear() {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            g g2 = this.c.d[this.f[n2]];
            if (g2 != null) {
                g2.b(this.b);
            }
            n2 = this.g[n2];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.a = 0;
    }

    @Override
    public final float d(g g2, boolean bl) {
        int n2;
        if (this.e == g2) {
            this.e = null;
        }
        if ((n2 = this.i) == -1) {
            return 0.0f;
        }
        int n3 = -1;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            if (this.f[n2] == g2.c) {
                if (n2 == this.i) {
                    this.i = this.g[n2];
                } else {
                    int[] arrn = this.g;
                    arrn[n3] = arrn[n2];
                }
                if (bl) {
                    g2.b(this.b);
                }
                g2.m = -1 + g2.m;
                this.a = -1 + this.a;
                this.f[n2] = -1;
                if (this.k) {
                    this.j = n2;
                }
                return this.h[n2];
            }
            int n4 = this.g[n2];
            n3 = n2;
            n2 = n4;
        }
        return 0.0f;
    }

    @Override
    public void e(g g2, float f2, boolean bl) {
        int[] arrn;
        int n2;
        int[] arrn2;
        if (f2 > -0.001f && f2 < 0.001f) {
            return;
        }
        int n3 = this.i;
        if (n3 == -1) {
            this.i = 0;
            this.h[0] = f2;
            this.f[0] = g2.c;
            this.g[0] = -1;
            g2.m = 1 + g2.m;
            g2.a(this.b);
            this.a = 1 + this.a;
            if (!this.k) {
                int n4;
                this.j = n4 = 1 + this.j;
                int[] arrn3 = this.f;
                if (n4 >= arrn3.length) {
                    this.k = true;
                    this.j = arrn3.length - 1;
                }
            }
            return;
        }
        int n5 = -1;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            int[] arrn4 = this.f;
            int n6 = arrn4[n3];
            int n7 = g2.c;
            if (n6 == n7) {
                float f3 = f2 + this.h[n3];
                if (f3 > -0.001f && f3 < 0.001f) {
                    f3 = 0.0f;
                }
                this.h[n3] = f3;
                if (f3 == 0.0f) {
                    if (n3 == this.i) {
                        this.i = this.g[n3];
                    } else {
                        int[] arrn5 = this.g;
                        arrn5[n5] = arrn5[n3];
                    }
                    if (bl) {
                        g2.b(this.b);
                    }
                    if (this.k) {
                        this.j = n3;
                    }
                    --g2.m;
                    --this.a;
                }
                return;
            }
            if (arrn4[n3] < n7) {
                n5 = n3;
            }
            n3 = this.g[n3];
        }
        int n8 = this.j;
        int n9 = n8 + 1;
        if (this.k) {
            int[] arrn6 = this.f;
            if (arrn6[n8] != -1) {
                n8 = arrn6.length;
            }
        } else {
            n8 = n9;
        }
        int[] arrn7 = this.f;
        if (n8 >= arrn7.length && this.a < arrn7.length) {
            int[] arrn8;
            for (int i3 = 0; i3 < (arrn8 = this.f).length; ++i3) {
                if (arrn8[i3] != -1) continue;
                n8 = i3;
                break;
            }
        }
        if (n8 >= (arrn2 = this.f).length) {
            int n10;
            n8 = arrn2.length;
            this.d = n10 = 2 * this.d;
            this.k = false;
            this.j = n8 - 1;
            this.h = Arrays.copyOf((float[])this.h, (int)n10);
            this.f = Arrays.copyOf((int[])this.f, (int)this.d);
            this.g = Arrays.copyOf((int[])this.g, (int)this.d);
        }
        this.f[n8] = g2.c;
        this.h[n8] = f2;
        int[] arrn9 = this.g;
        if (n5 != -1) {
            arrn9[n8] = arrn9[n5];
            arrn9[n5] = n8;
        } else {
            arrn9[n8] = this.i;
            this.i = n8;
        }
        g2.m = 1 + g2.m;
        g2.a(this.b);
        this.a = 1 + this.a;
        if (!this.k) {
            this.j = 1 + this.j;
        }
        if ((n2 = this.j) >= (arrn = this.f).length) {
            this.k = true;
            this.j = arrn.length - 1;
        }
    }

    @Override
    public g f(int n2) {
        int n3 = this.i;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            if (i2 == n2) {
                return this.c.d[this.f[n3]];
            }
            n3 = this.g[n3];
        }
        return null;
    }

    @Override
    public final float g(g g2) {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            if (this.f[n2] == g2.c) {
                return this.h[n2];
            }
            n2 = this.g[n2];
        }
        return 0.0f;
    }

    @Override
    public boolean h(g g2) {
        int n2 = this.i;
        if (n2 == -1) {
            return false;
        }
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            if (this.f[n2] == g2.c) {
                return true;
            }
            n2 = this.g[n2];
        }
        return false;
    }

    @Override
    public void i(float f2) {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            float[] arrf = this.h;
            arrf[n2] = arrf[n2] / f2;
            n2 = this.g[n2];
        }
    }

    @Override
    public void j() {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            float[] arrf = this.h;
            arrf[n2] = -1.0f * arrf[n2];
            n2 = this.g[n2];
        }
    }

    @Override
    public int k() {
        return this.a;
    }

    public String toString() {
        int n2 = this.i;
        String string = "";
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            StringBuilder stringBuilder = c.b.a.a.a.c(c.b.a.a.a.j(string, " -> "));
            stringBuilder.append(this.h[n2]);
            stringBuilder.append(" : ");
            StringBuilder stringBuilder2 = c.b.a.a.a.c(stringBuilder.toString());
            stringBuilder2.append((Object)this.c.d[this.f[n2]]);
            string = stringBuilder2.toString();
            n2 = this.g[n2];
        }
        return string;
    }
}

