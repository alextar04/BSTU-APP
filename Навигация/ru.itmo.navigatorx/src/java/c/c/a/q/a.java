/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  c.c.a.m.o
 *  c.c.a.m.s
 *  c.c.a.m.w.c.l
 *  c.c.a.m.w.g.c
 *  c.c.a.m.w.g.f
 *  c.c.a.r.c
 *  c.c.a.s.b
 *  f.b.k.h
 *  f.e.a
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 */
package c.c.a.q;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.s;
import c.c.a.m.u.k;
import c.c.a.m.w.c.l;
import c.c.a.m.w.g.f;
import c.c.a.r.c;
import c.c.a.s.b;
import c.c.a.s.j;
import f.b.k.h;
import java.util.Map;

public abstract class a<T extends a<T>>
implements Cloneable {
    public boolean A;
    public boolean B;
    public boolean C = true;
    public boolean D;
    public int e;
    public float f = 1.0f;
    public k g = k.c;
    public e h = e.g;
    public Drawable i;
    public int j;
    public Drawable k;
    public int l;
    public boolean m = true;
    public int n = -1;
    public int o = -1;
    public m p = c.b;
    public boolean q;
    public boolean r = true;
    public Drawable s;
    public int t;
    public o u = new o();
    public Map<Class<?>, s<?>> v = new b();
    public Class<?> w = Object.class;
    public boolean x;
    public Resources.Theme y;
    public boolean z;

    public static boolean e(int n2, int n3) {
        return (n2 & n3) != 0;
    }

    public T a(a<?> a2) {
        if (this.z) {
            return ((a)this.b()).a(a2);
        }
        if (a.e(a2.e, 2)) {
            this.f = a2.f;
        }
        if (a.e(a2.e, 262144)) {
            this.A = a2.A;
        }
        if (a.e(a2.e, 1048576)) {
            this.D = a2.D;
        }
        if (a.e(a2.e, 4)) {
            this.g = a2.g;
        }
        if (a.e(a2.e, 8)) {
            this.h = a2.h;
        }
        if (a.e(a2.e, 16)) {
            this.i = a2.i;
            this.j = 0;
            this.e = -33 & this.e;
        }
        if (a.e(a2.e, 32)) {
            this.j = a2.j;
            this.i = null;
            this.e = -17 & this.e;
        }
        if (a.e(a2.e, 64)) {
            this.k = a2.k;
            this.l = 0;
            this.e = -129 & this.e;
        }
        if (a.e(a2.e, 128)) {
            this.l = a2.l;
            this.k = null;
            this.e = -65 & this.e;
        }
        if (a.e(a2.e, 256)) {
            this.m = a2.m;
        }
        if (a.e(a2.e, 512)) {
            this.o = a2.o;
            this.n = a2.n;
        }
        if (a.e(a2.e, 1024)) {
            this.p = a2.p;
        }
        if (a.e(a2.e, 4096)) {
            this.w = a2.w;
        }
        if (a.e(a2.e, 8192)) {
            this.s = a2.s;
            this.t = 0;
            this.e = -16385 & this.e;
        }
        if (a.e(a2.e, 16384)) {
            this.t = a2.t;
            this.s = null;
            this.e = -8193 & this.e;
        }
        if (a.e(a2.e, 32768)) {
            this.y = a2.y;
        }
        if (a.e(a2.e, 65536)) {
            this.r = a2.r;
        }
        if (a.e(a2.e, 131072)) {
            this.q = a2.q;
        }
        if (a.e(a2.e, 2048)) {
            this.v.putAll(a2.v);
            this.C = a2.C;
        }
        if (a.e(a2.e, 524288)) {
            this.B = a2.B;
        }
        if (!this.r) {
            int n2;
            this.v.clear();
            this.e = n2 = -2049 & this.e;
            this.q = false;
            this.e = n2 & -131073;
            this.C = true;
        }
        this.e |= a2.e;
        this.u.d(a2.u);
        this.h();
        return (T)this;
    }

    public T b() {
        a a2;
        try {
            b b2;
            o o2;
            a2 = (a)super.clone();
            a2.u = o2 = new o();
            o2.d(this.u);
            a2.v = b2 = new b();
            b2.putAll(this.v);
            a2.x = false;
            a2.z = false;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
        return (T)a2;
    }

    public T c(Class<?> class_) {
        if (this.z) {
            return ((a)this.b()).c(class_);
        }
        h.i.p(class_, "Argument must not be null");
        this.w = class_;
        this.e = 4096 | this.e;
        this.h();
        return (T)this;
    }

    public T d(k k2) {
        if (this.z) {
            return ((a)this.b()).d(k2);
        }
        h.i.p(k2, "Argument must not be null");
        this.g = k2;
        this.e = 4 | this.e;
        this.h();
        return (T)this;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof a;
        boolean bl2 = false;
        if (bl) {
            a a2 = (a)object;
            int n2 = Float.compare((float)a2.f, (float)this.f);
            bl2 = false;
            if (n2 == 0) {
                int n3 = this.j;
                int n4 = a2.j;
                bl2 = false;
                if (n3 == n4) {
                    boolean bl3 = j.b((Object)this.i, (Object)a2.i);
                    bl2 = false;
                    if (bl3) {
                        int n5 = this.l;
                        int n6 = a2.l;
                        bl2 = false;
                        if (n5 == n6) {
                            boolean bl4 = j.b((Object)this.k, (Object)a2.k);
                            bl2 = false;
                            if (bl4) {
                                int n7 = this.t;
                                int n8 = a2.t;
                                bl2 = false;
                                if (n7 == n8) {
                                    boolean bl5 = j.b((Object)this.s, (Object)a2.s);
                                    bl2 = false;
                                    if (bl5) {
                                        boolean bl6 = this.m;
                                        boolean bl7 = a2.m;
                                        bl2 = false;
                                        if (bl6 == bl7) {
                                            int n9 = this.n;
                                            int n10 = a2.n;
                                            bl2 = false;
                                            if (n9 == n10) {
                                                int n11 = this.o;
                                                int n12 = a2.o;
                                                bl2 = false;
                                                if (n11 == n12) {
                                                    boolean bl8 = this.q;
                                                    boolean bl9 = a2.q;
                                                    bl2 = false;
                                                    if (bl8 == bl9) {
                                                        boolean bl10 = this.r;
                                                        boolean bl11 = a2.r;
                                                        bl2 = false;
                                                        if (bl10 == bl11) {
                                                            boolean bl12 = this.A;
                                                            boolean bl13 = a2.A;
                                                            bl2 = false;
                                                            if (bl12 == bl13) {
                                                                boolean bl14 = this.B;
                                                                boolean bl15 = a2.B;
                                                                bl2 = false;
                                                                if (bl14 == bl15) {
                                                                    boolean bl16 = this.g.equals((Object)a2.g);
                                                                    bl2 = false;
                                                                    if (bl16) {
                                                                        e e2 = this.h;
                                                                        e e3 = a2.h;
                                                                        bl2 = false;
                                                                        if (e2 == e3) {
                                                                            boolean bl17 = this.u.equals((Object)a2.u);
                                                                            bl2 = false;
                                                                            if (bl17) {
                                                                                boolean bl18 = this.v.equals(a2.v);
                                                                                bl2 = false;
                                                                                if (bl18) {
                                                                                    boolean bl19 = this.w.equals(a2.w);
                                                                                    bl2 = false;
                                                                                    if (bl19) {
                                                                                        boolean bl20 = j.b(this.p, a2.p);
                                                                                        bl2 = false;
                                                                                        if (bl20) {
                                                                                            boolean bl21 = j.b((Object)this.y, (Object)a2.y);
                                                                                            bl2 = false;
                                                                                            if (bl21) {
                                                                                                bl2 = true;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public T f(int n2, int n3) {
        if (this.z) {
            return ((a)this.b()).f(n2, n3);
        }
        this.o = n2;
        this.n = n3;
        this.e = 512 | this.e;
        this.h();
        return (T)this;
    }

    public T g(e e2) {
        if (this.z) {
            return ((a)this.b()).g(e2);
        }
        h.i.p(e2, "Argument must not be null");
        this.h = e2;
        this.e = 8 | this.e;
        this.h();
        return (T)this;
    }

    public final T h() {
        if (!this.x) {
            return (T)this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public int hashCode() {
        int n2 = j.g(this.f);
        int n3 = this.j + n2 * 31;
        int n4 = j.h((Object)this.i, n3);
        int n5 = this.l + n4 * 31;
        int n6 = j.h((Object)this.k, n5);
        int n7 = this.t + n6 * 31;
        int n8 = j.h((Object)this.s, n7);
        int n9 = this.m + n8 * 31;
        int n10 = this.n + n9 * 31;
        int n11 = this.o + n10 * 31;
        int n12 = this.q + n11 * 31;
        int n13 = this.r + n12 * 31;
        int n14 = this.A + n13 * 31;
        int n15 = this.B + n14 * 31;
        int n16 = j.h(this.g, n15);
        int n17 = j.h((Object)this.h, n16);
        int n18 = j.h((Object)this.u, n17);
        int n19 = j.h(this.v, n18);
        int n20 = j.h(this.w, n19);
        int n21 = j.h(this.p, n20);
        return j.h((Object)this.y, n21);
    }

    public <Y> T i(n<Y> n2, Y y2) {
        if (this.z) {
            return ((a)this.b()).i(n2, y2);
        }
        h.i.p(n2, "Argument must not be null");
        h.i.p(y2, "Argument must not be null");
        this.u.b.put(n2, y2);
        this.h();
        return (T)this;
    }

    public T j(m m2) {
        if (this.z) {
            return ((a)this.b()).j(m2);
        }
        h.i.p(m2, "Argument must not be null");
        this.p = m2;
        this.e = 1024 | this.e;
        this.h();
        return (T)this;
    }

    public T k(boolean bl) {
        if (this.z) {
            return ((a)this.b()).k(true);
        }
        this.m = bl ^ true;
        this.e = 256 | this.e;
        this.h();
        return (T)this;
    }

    public T l(s<Bitmap> s2, boolean bl) {
        if (this.z) {
            return ((a)this.b()).l(s2, bl);
        }
        l l2 = new l(s2, bl);
        this.m(Bitmap.class, s2, bl);
        this.m((Class<Y>)Drawable.class, (s<Y>)l2, bl);
        this.m((Class<Y>)BitmapDrawable.class, (s<Y>)l2, bl);
        this.m((Class<Y>)c.c.a.m.w.g.c.class, (s<Y>)new f(s2), bl);
        this.h();
        return (T)this;
    }

    public <Y> T m(Class<Y> class_, s<Y> s2, boolean bl) {
        int n2;
        int n3;
        if (this.z) {
            return ((a)this.b()).m(class_, s2, bl);
        }
        h.i.p(class_, "Argument must not be null");
        h.i.p(s2, "Argument must not be null");
        this.v.put(class_, s2);
        this.e = n3 = 2048 | this.e;
        this.r = true;
        this.e = n2 = n3 | 65536;
        this.C = false;
        if (bl) {
            this.e = n2 | 131072;
            this.q = true;
        }
        this.h();
        return (T)this;
    }

    public T n(boolean bl) {
        if (this.z) {
            return ((a)this.b()).n(bl);
        }
        this.D = bl;
        this.e = 1048576 | this.e;
        this.h();
        return (T)this;
    }
}

