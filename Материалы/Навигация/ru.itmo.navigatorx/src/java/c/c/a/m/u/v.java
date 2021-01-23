/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.u;

import c.c.a.m.u.w;
import c.c.a.s.k.a;
import c.c.a.s.k.d;
import f.b.k.h;
import f.h.k.c;

public final class v<Z>
implements w<Z>,
a.d {
    public static final c<v<?>> i = c.c.a.s.k.a.a(20, new a.b<v<?>>(){

        @Override
        public Object a() {
            return new v();
        }
    });
    public final d e = new d(){
        public volatile boolean a;

        public void a() {
            if (!this.a) {
                return;
            }
            throw new IllegalStateException("Already released");
        }
    };
    public w<Z> f;
    public boolean g;
    public boolean h;

    public static <Z> v<Z> f(w<Z> w2) {
        v<?> v2 = i.b();
        h.i.p(v2, "Argument must not be null");
        v2.h = false;
        v2.g = true;
        v2.f = w2;
        return v2;
    }

    @Override
    public d a() {
        return this.e;
    }

    @Override
    public Z b() {
        return this.f.b();
    }

    @Override
    public int c() {
        return this.f.c();
    }

    @Override
    public Class<Z> d() {
        return this.f.d();
    }

    @Override
    public void e() {
        v v2 = this;
        synchronized (v2) {
            this.e.a();
            this.h = true;
            if (!this.g) {
                this.f.e();
                this.f = null;
                i.a(this);
            }
            return;
        }
    }

    public void g() {
        v v2 = this;
        synchronized (v2) {
            this.e.a();
            if (this.g) {
                this.g = false;
                if (this.h) {
                    this.e();
                }
                return;
            }
            throw new IllegalStateException("Already unlocked");
        }
    }

}

