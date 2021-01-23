/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.i.f
 *  f.f.b.i.l.f
 *  f.f.b.i.l.m
 *  java.lang.Object
 *  java.util.List
 */
package f.f.b.i.l;

import f.f.b.i.d;
import f.f.b.i.f;
import f.f.b.i.l.j;
import f.f.b.i.l.l;
import f.f.b.i.l.m;
import java.util.List;

public class h
extends m {
    public h(d d2) {
        super(d2);
        d2.d.f();
        d2.e.f();
        this.f = ((f)d2).j0;
    }

    public void a(f.f.b.i.l.d d2) {
        f.f.b.i.l.f f2 = this.h;
        if (!f2.c) {
            return;
        }
        if (f2.j) {
            return;
        }
        f.f.b.i.l.f f3 = (f.f.b.i.l.f)f2.l.get(0);
        f f4 = (f)this.b;
        int n2 = (int)(0.5f + (float)f3.g * f4.f0);
        this.h.c(n2);
    }

    public void d() {
        m m2;
        d d2 = this.b;
        f f2 = (f)d2;
        int n2 = f2.g0;
        int n3 = f2.h0;
        if (f2.j0 == 1) {
            f.f.b.i.l.f f3 = this.h;
            if (n2 != -1) {
                f3.l.add((Object)d2.K.d.h);
                this.b.K.d.h.k.add((Object)this.h);
                this.h.f = n2;
            } else if (n3 != -1) {
                f3.l.add((Object)d2.K.d.i);
                this.b.K.d.i.k.add((Object)this.h);
                this.h.f = -n3;
            } else {
                f3.b = true;
                f3.l.add((Object)d2.K.d.i);
                this.b.K.d.i.k.add((Object)this.h);
            }
            this.m(this.b.d.h);
            m2 = this.b.d;
        } else {
            f.f.b.i.l.f f4 = this.h;
            if (n2 != -1) {
                f4.l.add((Object)d2.K.e.h);
                this.b.K.e.h.k.add((Object)this.h);
                this.h.f = n2;
            } else if (n3 != -1) {
                f4.l.add((Object)d2.K.e.i);
                this.b.K.e.i.k.add((Object)this.h);
                this.h.f = -n3;
            } else {
                f4.b = true;
                f4.l.add((Object)d2.K.e.i);
                this.b.K.e.i.k.add((Object)this.h);
            }
            this.m(this.b.e.h);
            m2 = this.b.e;
        }
        this.m(m2.i);
    }

    public void e() {
        d d2 = this.b;
        if (((f)d2).j0 == 1) {
            d2.P = this.h.g;
            return;
        }
        d2.Q = this.h.g;
    }

    public void f() {
        this.h.b();
    }

    public boolean k() {
        return false;
    }

    public final void m(f.f.b.i.l.f f2) {
        this.h.k.add((Object)f2);
        f2.l.add((Object)this.h);
    }
}

