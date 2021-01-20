/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.view.View
 *  c.a.a.a$a
 *  c.a.a.a$b
 *  c.a.a.a$d
 *  c.a.a.a$e
 *  c.a.a.o.e.b
 *  c.a.a.o.e.c
 *  h.h
 *  h.m.a.a
 *  h.m.a.l
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import c.a.a.a;
import c.a.a.k;
import c.a.a.o.a;
import c.a.a.o.d.a;
import c.a.a.o.d.b;
import h.h;
import h.m.a.l;
import h.m.b.f;
import h.m.b.j;

/*
 * Exception performing whole class analysis.
 */
public class a {
    public static final String l = "a";
    public static final k m;
    public int a;
    public int b;
    public View c;
    public final b d;
    public final c.a.a.o.b e;
    public final c.a.a.o.a f;
    public final c.a.a.o.e.b g;
    public final c.a.a.o.e.c h;
    public final c.a.a.o.d.a i;
    public final c.a.a.o.c.e j;
    public final c.a.a.o.c.c k;

    public static {
        String string = l;
        j.d((Object)string, (String)"TAG");
        j.e((Object)string, (String)"tag");
        m = new k(string, null);
    }

    public a(Context context) {
        c.a.a.o.c.c c2;
        j.e((Object)context, (String)"context");
        this.d = new /* Unavailable Anonymous Inner Class!! */;
        this.e = new c.a.a.o.b(this);
        this.f = new c.a.a.o.a((a.a)this.d);
        this.g = new c.a.a.o.e.b(this, (h.m.a.a)new a(0, (Object)this));
        this.h = new c.a.a.o.e.c(this, (h.m.a.a)new a(1, (Object)this));
        this.i = new c.a.a.o.d.a(this.h, this.g, this.f, (a.a)this.d);
        this.j = new c.a.a.o.c.e(context, this.g, this.f, this.i);
        this.k = c2 = new c.a.a.o.c.c(context, this.h, this.g, this.f, this.i);
    }

    public static final float a(a a2) {
        int n2 = a2.a;
        if (n2 != 0) {
            if (n2 != 1) {
                return 1.0f;
            }
            float f2 = a2.i.f / a2.e();
            float f3 = a2.i.g / a2.d();
            k k2 = m;
            Object[] arrobject = new Object[]{"computeTransformationZoom", "centerCrop", "scaleX:", Float.valueOf((float)f2), "scaleY:", Float.valueOf((float)f3)};
            k2.d(arrobject);
            return Math.max((float)f2, (float)f3);
        }
        float f4 = a2.i.f / a2.e();
        float f5 = a2.i.g / a2.d();
        k k3 = m;
        Object[] arrobject = new Object[]{"computeTransformationZoom", "centerInside", "scaleX:", Float.valueOf((float)f4), "scaleY:", Float.valueOf((float)f5)};
        k3.d(arrobject);
        return Math.min((float)f4, (float)f5);
    }

    public static final /* synthetic */ View b(a a2) {
        View view = a2.c;
        if (view != null) {
            return view;
        }
        j.j((String)"container");
        throw null;
    }

    public static void j(a a2, float f2, float f3, boolean bl, int n2, Object object) {
        c.a.a.o.d.a a3;
        if ((n2 & 4) != 0) {
            bl = false;
        }
        if ((a3 = a2.i) != null) {
            float f4 = (float)false;
            if (!(f2 <= f4)) {
                if (f3 <= f4) {
                    return;
                }
                if (a3.h() != f2 || a3.e() != f3 || bl) {
                    float f5 = a3.m();
                    a3.b.set(0.0f, 0.0f, f2, f3);
                    a3.n(f5, bl);
                }
            }
            return;
        }
        throw null;
    }

    public boolean c() {
        boolean bl = this.f.a == 4;
        if (bl) {
            this.j.a();
            return true;
        }
        boolean bl2 = this.f.a == 3;
        if (bl2) {
            this.f.a();
            return true;
        }
        return false;
    }

    public final float d() {
        return this.i.e();
    }

    public final float e() {
        return this.i.h();
    }

    public float f() {
        return this.i.m();
    }

    public float g() {
        c.a.a.o.e.c c2 = this.h;
        return this.f() / c2.b;
    }

    public void h(float f2, float f3, float f4, boolean bl) {
        float f5 = f2 * this.h.b;
        c.a.a.o.d.b b2 = c.a.a.o.d.b.m.a((l<? super b.a, h>)new d(f5, f3, f4));
        if (bl) {
            this.i.a(b2);
            return;
        }
        this.c();
        this.i.c(b2);
    }

    public void i(float f2, boolean bl) {
        c.a.a.o.d.b b2 = c.a.a.o.d.b.m.a((l<? super b.a, h>)new e(f2));
        if (bl) {
            this.i.a(b2);
            return;
        }
        this.c();
        this.i.c(b2);
    }

    public void k(float f2, int n2) {
        c.a.a.o.e.c c2 = this.h;
        if (c2 != null) {
            if (!(f2 < (float)false)) {
                c2.e = f2;
                c2.f = n2;
                if (this.g() > this.h.c()) {
                    this.i(this.h.c(), true);
                }
                return;
            }
            throw new IllegalArgumentException("Max zoom should be >= 0.");
        }
        throw null;
    }

    public void l(float f2, int n2) {
        c.a.a.o.e.c c2 = this.h;
        if (c2 != null) {
            if (!(f2 < (float)false)) {
                c2.c = f2;
                c2.d = n2;
                if (this.f() <= this.h.d()) {
                    this.i(this.h.d(), true);
                }
                return;
            }
            throw new IllegalArgumentException("Min zoom should be >= 0");
        }
        throw null;
    }

    public void m(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public static interface c {
        public void a(a var1);

        public void b(a var1, Matrix var2);
    }

}

