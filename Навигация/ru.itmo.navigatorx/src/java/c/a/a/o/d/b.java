/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.m.a.l
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a.o.d;

import c.a.a.i;
import h.h;
import h.m.a.l;
import h.m.b.f;
import h.m.b.j;

public final class b {
    public static final String l = "b";
    public static final b m = new b(null);
    public final boolean a;
    public final float b;
    public final boolean c;
    public final boolean d;
    public final c.a.a.b e;
    public final i f;
    public final boolean g;
    public final boolean h;
    public final Float i;
    public final Float j;
    public final boolean k;

    public static {
        String string = l;
        j.d((Object)string, (String)"TAG");
        j.e((Object)string, (String)"tag");
    }

    public b(float f2, boolean bl, boolean bl2, c.a.a.b b2, i i2, boolean bl3, boolean bl4, Float f3, Float f4, boolean bl5, f f5) {
        this.b = f2;
        this.c = bl;
        this.d = bl2;
        this.e = b2;
        this.f = i2;
        this.g = bl3;
        this.h = bl4;
        this.i = f3;
        this.j = f4;
        this.k = bl5;
        if (b2 != null && i2 != null) {
            throw new IllegalStateException("Can only use either pan or scaledPan");
        }
        boolean bl6 = this.e != null || this.f != null;
        this.a = bl6;
    }

    public final boolean a() {
        return true ^ Float.isNaN((float)this.b);
    }

    public static final class a {
        public float a = Float.NaN;
        public boolean b;
        public boolean c;
        public c.a.a.b d;
        public i e;
        public boolean f;
        public boolean g;
        public Float h;
        public Float i;
        public boolean j = true;

        public final void a(c.a.a.b b2, boolean bl) {
            this.e = null;
            this.d = b2;
            this.f = false;
            this.g = bl;
        }

        public final void b(i i2, boolean bl) {
            this.e = i2;
            this.d = null;
            this.f = false;
            this.g = bl;
        }

        public final void c(float f2, boolean bl) {
            this.a = f2;
            this.b = false;
            this.c = bl;
        }
    }

    public static final class b {
        public b(f f2) {
        }

        public final b a(l<? super a, h> l2) {
            j.e(l2, (String)"builder");
            a a2 = new a();
            l2.f((Object)a2);
            b b2 = new b(a2.a, a2.b, a2.c, a2.d, a2.e, a2.f, a2.g, a2.h, a2.i, a2.j, null);
            return b2;
        }
    }

}

