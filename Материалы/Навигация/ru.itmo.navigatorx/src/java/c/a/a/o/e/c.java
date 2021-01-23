/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.a.a.o.e;

import c.a.a.g;
import c.a.a.k;
import c.a.a.o.e.a;
import f.b.k.h;
import h.m.b.f;
import h.m.b.j;

public final class c
extends a {
    public static final String k = "c";
    public static final k l;
    public float b;
    public float c;
    public int d;
    public float e;
    public int f;
    public g g;
    public boolean h;
    public boolean i;
    public final c.a.a.a j;

    public static {
        String string = k;
        j.d(string, "TAG");
        j.e(string, "tag");
        l = new k(string, null);
    }

    public c(c.a.a.a a2, h.m.a.a<c.a.a.o.d.a> a3) {
        j.e(a2, "engine");
        j.e(a3, "provider");
        super(a3);
        this.j = a2;
        this.c = 0.8f;
        this.e = 2.5f;
        this.g = g.a;
        this.h = true;
        this.i = true;
    }

    public final float b(float f2, boolean bl) {
        float f3 = this.d();
        float f4 = this.c();
        if (bl && this.i) {
            float f5 = this.g.a(this.j, false);
            if (f5 < 0.0f) {
                l.e("Received negative maxOverZoomOut value, coercing to 0");
                f5 = h.i.u(f5, 0.0f);
            }
            f3 -= f5;
            float f6 = this.g.a(this.j, true);
            if (f6 < 0.0f) {
                l.e("Received negative maxOverZoomIn value, coercing to 0");
                f6 = h.i.u(f6, 0.0f);
            }
            f4 += f6;
        }
        if (f4 < f3) {
            int n2 = this.f;
            if (n2 != this.d) {
                if (n2 == 0) {
                    f3 = f4;
                } else {
                    f4 = f3;
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("maxZoom is less than minZoom: ");
                stringBuilder.append(f4);
                stringBuilder.append(" < ");
                stringBuilder.append(f3);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return h.i.v(f2, f3, f4);
    }

    public final float c() {
        int n2 = this.f;
        if (n2 != 0) {
            if (n2 == 1) {
                return this.e;
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("Unknown ZoomType ");
            stringBuilder.append(this.f);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return this.e * this.b;
    }

    public final float d() {
        int n2 = this.d;
        if (n2 != 0) {
            if (n2 == 1) {
                return this.c;
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("Unknown ZoomType ");
            stringBuilder.append(this.d);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return this.c * this.b;
    }
}

