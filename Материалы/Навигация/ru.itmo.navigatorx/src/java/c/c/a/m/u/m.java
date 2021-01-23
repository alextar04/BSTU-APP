/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.atomic.AtomicInteger
 */
package c.c.a.m.u;

import c.c.a.m.u.g;
import c.c.a.m.u.i;
import c.c.a.m.u.l;
import c.c.a.m.u.n;
import c.c.a.m.u.q;
import c.c.a.m.u.r;
import c.c.a.m.u.t;
import c.c.a.m.u.w;
import c.c.a.q.f;
import c.c.a.s.k.a;
import c.c.a.s.k.d;
import f.b.k.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class m<R>
implements i.a<R>,
a.d {
    public static final c C = new Object(){};
    public i<R> A;
    public volatile boolean B;
    public final e e;
    public final c.c.a.s.k.d f;
    public final q.a g;
    public final f.h.k.c<m<?>> h;
    public final c i;
    public final n j;
    public final c.c.a.m.u.e0.a k;
    public final c.c.a.m.u.e0.a l;
    public final c.c.a.m.u.e0.a m;
    public final c.c.a.m.u.e0.a n;
    public final AtomicInteger o;
    public c.c.a.m.m p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public w<?> u;
    public c.c.a.m.a v;
    public boolean w;
    public r x;
    public boolean y;
    public q<?> z;

    public m(c.c.a.m.u.e0.a a2, c.c.a.m.u.e0.a a3, c.c.a.m.u.e0.a a4, c.c.a.m.u.e0.a a5, n n2, q.a a6, f.h.k.c<m<?>> c2) {
        c c3 = C;
        this.e = new Iterable<d>(){
            public final List<d> e;
            {
                ArrayList arrayList = new ArrayList(2);
                this.e = arrayList;
            }

            public boolean isEmpty() {
                return this.e.isEmpty();
            }

            public Iterator<d> iterator() {
                return this.e.iterator();
            }
        };
        this.f = new c.c.a.s.k.d(){
            public volatile boolean a;

            public void a() {
                if (!this.a) {
                    return;
                }
                throw new java.lang.IllegalStateException("Already released");
            }
        };
        this.o = new AtomicInteger();
        this.k = a2;
        this.l = a3;
        this.m = a4;
        this.n = a5;
        this.j = n2;
        this.g = a6;
        this.h = c2;
        this.i = c3;
    }

    @Override
    public c.c.a.s.k.d a() {
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b(f f2, Executor executor) {
        boolean bl;
        block8 : {
            void var7_8;
            block7 : {
                block6 : {
                    m m2 = this;
                    // MONITORENTER : m2
                    this.f.a();
                    this.e.e.add(new Object(f2, executor){
                        public final f a;
                        public final Executor b;
                        {
                            this.a = f2;
                            this.b = executor;
                        }

                        public boolean equals(Object object) {
                            if (object instanceof d) {
                                d d2 = object;
                                return this.a.equals((Object)d2.a);
                            }
                            return false;
                        }

                        public int hashCode() {
                            return this.a.hashCode();
                        }
                    });
                    boolean bl2 = this.w;
                    bl = true;
                    if (!bl2) break block6;
                    this.e((int)bl);
                    Runnable runnable = new Runnable(f2){
                        public final f e;
                        {
                            this.e = f2;
                        }

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        public void run() {
                            Object object;
                            c.c.a.q.g g2 = (c.c.a.q.g)this.e;
                            g2.b.a();
                            Object object2 = object = g2.c;
                            synchronized (object2) {
                                m m2;
                                m m3 = m2 = m.this;
                                synchronized (m3) {
                                    e e2 = m.this.e;
                                    f f2 = this.e;
                                    if (e2.e.contains(new /* invalid duplicate definition of identical inner class */)) {
                                        q<?> q2;
                                        c.c.a.m.a a2;
                                        m.this.z.a();
                                        m m4 = m.this;
                                        f f3 = this.e;
                                        if (m4 == null) {
                                            throw null;
                                        }
                                        try {
                                            q2 = m4.z;
                                            a2 = m4.v;
                                        }
                                        catch (Throwable throwable) {
                                            throw new c.c.a.m.u.c(throwable);
                                        }
                                        c.c.a.q.g g3 = (c.c.a.q.g)f3;
                                        g3.o(q2, a2);
                                        m.this.h(this.e);
                                    }
                                    m.this.d();
                                    return;
                                }
                            }
                        }
                    };
                    break block7;
                }
                if (!this.y) break block8;
                this.e((int)bl);
                Runnable runnable = new Runnable(f2){
                    public final f e;
                    {
                        this.e = f2;
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public void run() {
                        Object object;
                        c.c.a.q.g g2 = (c.c.a.q.g)this.e;
                        g2.b.a();
                        Object object2 = object = g2.c;
                        synchronized (object2) {
                            m m2;
                            m m3 = m2 = m.this;
                            synchronized (m3) {
                                e e2 = m.this.e;
                                f f2 = this.e;
                                if (e2.e.contains(new /* invalid duplicate definition of identical inner class */)) {
                                    m m4 = m.this;
                                    f f3 = this.e;
                                    if (m4 == null) {
                                        throw null;
                                    }
                                    try {
                                        r r2 = m4.x;
                                        ((c.c.a.q.g)f3).n(r2, 5);
                                    }
                                    catch (Throwable throwable) {
                                        throw new c.c.a.m.u.c(throwable);
                                    }
                                }
                                m.this.d();
                                return;
                            }
                        }
                    }
                };
            }
            executor.execute((Runnable)var7_8);
            return;
        }
        if (this.B) {
            bl = false;
        }
        h.i.l(bl, "Cannot add callbacks to a cancelled EngineJob");
        // MONITOREXIT : m2
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void c() {
        l l2;
        if (this.f()) {
            return;
        }
        this.B = true;
        i<R> i2 = this.A;
        i2.I = true;
        g g2 = i2.G;
        if (g2 != null) {
            g2.cancel();
        }
        n n2 = this.j;
        c.c.a.m.m m2 = this.p;
        l l3 = l2 = (l)n2;
        synchronized (l3) {
            t t2 = l2.a;
            if (t2 == null) throw null;
            Map<c.c.a.m.m, m<?>> map = t2.a(this.t);
            if (this.equals(map.get((Object)m2))) {
                map.remove((Object)m2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        q<?> q2;
        m m2 = this;
        synchronized (m2) {
            this.f.a();
            h.i.l(this.f(), "Not yet complete!");
            int n2 = this.o.decrementAndGet();
            boolean bl = n2 >= 0;
            h.i.l(bl, "Can't decrement below 0");
            if (n2 != 0) return;
            q2 = this.z;
            this.g();
        }
        if (q2 == null) return;
        q2.f();
    }

    public void e(int n2) {
        m m2 = this;
        synchronized (m2) {
            h.i.l(this.f(), "Not yet complete!");
            if (this.o.getAndAdd(n2) == 0 && this.z != null) {
                this.z.a();
            }
            return;
        }
    }

    public final boolean f() {
        return this.y || this.w || this.B;
        {
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void g() {
        i.e e2;
        m m2 = this;
        // MONITORENTER : m2
        if (this.p == null) throw new IllegalArgumentException();
        this.e.e.clear();
        this.p = null;
        this.z = null;
        this.u = null;
        this.y = false;
        this.B = false;
        this.w = false;
        i<R> i2 = this.A;
        i.e e3 = e2 = i2.k;
        // MONITORENTER : e3
        e2.a = true;
        boolean bl = e2.a(false);
        // MONITOREXIT : e3
        if (bl) {
            i2.l();
        }
        this.A = null;
        this.x = null;
        this.v = null;
        this.h.a(this);
        // MONITOREXIT : m2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(f f2) {
        m m2 = this;
        synchronized (m2) {
            this.f.a();
            this.e.e.remove(new /* invalid duplicate definition of identical inner class */);
            if (!this.e.isEmpty()) return;
            this.c();
            if (!this.w) {
                if (!this.y) return;
            }
            boolean bl = true;
            if (!bl) return;
            if (this.o.get() != 0) return;
            this.g();
            return;
        }
    }

    public void i(i<?> i2) {
        c.c.a.m.u.e0.a a2 = this.r ? this.m : (this.s ? this.n : this.l);
        a2.e.execute(i2);
    }

}

