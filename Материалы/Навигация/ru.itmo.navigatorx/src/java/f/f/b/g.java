/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  f.f.b.b
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package f.f.b;

import f.f.b.b;
import f.f.b.d;
import java.util.Arrays;

public class g {
    public static int n = 1;
    public boolean a;
    public String b;
    public int c = -1;
    public int d = -1;
    public int e = 0;
    public float f;
    public boolean g = false;
    public float[] h = new float[9];
    public float[] i = new float[9];
    public a j;
    public b[] k = new b[16];
    public int l = 0;
    public int m = 0;

    public g(a a2) {
        this.j = a2;
    }

    public final void a(b b2) {
        int n2;
        for (int i2 = 0; i2 < (n2 = this.l); ++i2) {
            if (this.k[i2] != b2) continue;
            return;
        }
        Object[] arrobject = this.k;
        if (n2 >= arrobject.length) {
            this.k = (b[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
        }
        b[] arrb = this.k;
        int n3 = this.l;
        arrb[n3] = b2;
        this.l = n3 + 1;
    }

    public final void b(b b2) {
        int n2 = this.l;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.k[i2] != b2) continue;
            while (i2 < n2 - 1) {
                b[] arrb = this.k;
                int n3 = i2 + 1;
                arrb[i2] = arrb[n3];
                i2 = n3;
            }
            this.l = -1 + this.l;
            return;
        }
    }

    public void c() {
        this.b = null;
        this.j = a.i;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        int n2 = this.l;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.k[i2] = null;
        }
        this.l = 0;
        this.m = 0;
        this.a = false;
        Arrays.fill((float[])this.i, (float)0.0f);
    }

    public void d(d d2, float f2) {
        this.f = f2;
        this.g = true;
        int n2 = this.l;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.k[i2].k(this, false);
        }
        this.l = 0;
    }

    public final void e(b b2) {
        int n2 = this.l;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.k[i2].l(b2, false);
        }
        this.l = 0;
    }

    public String toString() {
        StringBuilder stringBuilder;
        if (this.b != null) {
            stringBuilder = c.b.a.a.a.c((String)"");
            stringBuilder.append(this.b);
        } else {
            stringBuilder = c.b.a.a.a.c((String)"");
            stringBuilder.append(this.c);
        }
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* synthetic */ a[] j;

        public static {
            a a2;
            e = new a();
            f = new a();
            g = new a();
            h = new a();
            i = a2 = new a();
            a[] arra = new a[]{e, f, g, h, a2};
            j = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])j.clone();
        }
    }

}

