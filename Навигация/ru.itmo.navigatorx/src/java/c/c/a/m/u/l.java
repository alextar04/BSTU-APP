/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 */
package c.c.a.m.u;

import android.util.Log;
import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.s;
import c.c.a.m.u.a;
import c.c.a.m.u.d0.a;
import c.c.a.m.u.d0.h;
import c.c.a.m.u.d0.i;
import c.c.a.m.u.i;
import c.c.a.m.u.k;
import c.c.a.m.u.l;
import c.c.a.m.u.n;
import c.c.a.m.u.p;
import c.c.a.m.u.q;
import c.c.a.m.u.t;
import c.c.a.m.u.w;
import c.c.a.m.u.z;
import c.c.a.q.g;
import c.c.a.s.f;
import c.c.a.s.k.a;
import f.b.k.h;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class l
implements n,
i.a,
q.a {
    public static final boolean i = Log.isLoggable((String)"Engine", (int)2);
    public final t a;
    public final p b;
    public final i c;
    public final b d;
    public final z e;
    public final c f;
    public final a g;
    public final c.c.a.m.u.a h;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public l(i i2, a.a a2, c.c.a.m.u.e0.a a3, c.c.a.m.u.e0.a a4, c.c.a.m.u.e0.a a5, c.c.a.m.u.e0.a a6, boolean bl) {
        c.c.a.m.u.a a7;
        this.c = i2;
        this.f = new c(a2);
        this.h = a7 = new c.c.a.m.u.a(bl);
        l l2 = this;
        synchronized (l2) {
            c.c.a.m.u.a a8 = a7;
            synchronized (a8) {
                a7.d = this;
            }
        }
        this.b = new p();
        this.a = new t();
        Object object = new Object(a3, a4, a5, a6, this, this){
            public final c.c.a.m.u.e0.a a;
            public final c.c.a.m.u.e0.a b;
            public final c.c.a.m.u.e0.a c;
            public final c.c.a.m.u.e0.a d;
            public final n e;
            public final q.a f;
            public final f.h.k.c<c.c.a.m.u.m<?>> g = c.c.a.s.k.a.a(150, new a.b<c.c.a.m.u.m<?>>(this){
                public final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public Object a() {
                    b b2 = this.a;
                    c.c.a.m.u.m<R> m2 = new c.c.a.m.u.m<R>(b2.a, b2.b, b2.c, b2.d, b2.e, b2.f, b2.g);
                    return m2;
                }
            });
            {
                this.a = a2;
                this.b = a3;
                this.c = a4;
                this.d = a5;
                this.e = n2;
                this.f = a6;
            }
        };
        this.d = object;
        this.g = new Object(this.f){
            public final i.d a;
            public final f.h.k.c<c.c.a.m.u.i<?>> b = c.c.a.s.k.a.a(150, new a.b<c.c.a.m.u.i<?>>(this){
                public final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public Object a() {
                    a a2 = this.a;
                    return new c.c.a.m.u.i<R>(a2.a, a2.b);
                }
            });
            public int c;
            {
                this.a = d2;
            }
        };
        this.e = new z();
        ((h)i2).d = this;
    }

    public static void d(String string, long l2, m m2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" in ");
        stringBuilder.append(f.a(l2));
        stringBuilder.append("ms, key: ");
        stringBuilder.append((Object)m2);
        Log.v((String)"Engine", (String)stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void a(m m2, q<?> q2) {
        c.c.a.m.u.a a2;
        c.c.a.m.u.a a3 = a2 = this.h;
        // MONITORENTER : a3
        a.b b2 = (a.b)((Object)a2.b.remove((Object)m2));
        if (b2 != null) {
            b2.c = null;
            b2.clear();
        }
        // MONITOREXIT : a3
        if (q2.e) {
            ((h)this.c).f(m2, q2);
            return;
        }
        this.e.a(q2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <R> d b(c.c.a.d d2, Object object, m m2, int n2, int n3, Class<?> class_, Class<R> class_2, e e2, k k2, Map<Class<?>, s<?>> map, boolean bl, boolean bl2, o o2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, c.c.a.q.f f2, Executor executor) {
        q<?> q2;
        long l2 = i ? f.b() : 0L;
        long l3 = l2;
        if (this.b == null) {
            throw null;
        }
        c.c.a.m.u.o o3 = new c.c.a.m.u.o(object, m2, n2, n3, map, class_, class_2, o2);
        l l4 = this;
        synchronized (l4) {
            q2 = this.c(o3, bl3, l3);
            if (q2 == null) {
                return this.g(d2, object, m2, n2, n3, class_, class_2, e2, k2, map, bl, bl2, o2, bl3, bl4, bl5, bl6, f2, executor, o3, l3);
            }
        }
        c.c.a.m.a a2 = c.c.a.m.a.i;
        ((g)f2).o(q2, a2);
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final q<?> c(c.c.a.m.u.o o2, boolean bl, long l2) {
        c.c.a.m.u.a a2;
        q q2;
        q q3;
        h h2;
        if (!bl) {
            return null;
        }
        c.c.a.m.u.a a3 = a2 = this.h;
        // MONITORENTER : a3
        a.b b2 = (a.b)((Object)a2.b.get((Object)o2));
        if (b2 == null) {
            // MONITOREXIT : a3
            q2 = null;
        } else {
            q2 = (q)b2.get();
            if (q2 == null) {
                a2.b(b2);
            }
            // MONITOREXIT : a3
        }
        if (q2 != null) {
            q2.a();
        }
        if (q2 != null) {
            if (!i) return q2;
            l.d("Loaded resource from active resources", l2, o2);
            return q2;
        }
        h h3 = h2 = (h)this.c;
        // MONITORENTER : h3
        Object object = h2.a.remove((Object)o2);
        if (object != null) {
            h2.c -= (long)((c.c.a.s.g)h2).b(object);
        }
        // MONITOREXIT : h3
        w w2 = (w)object;
        q q4 = w2 == null ? null : (w2 instanceof q ? (q)w2 : (q3 = new q(w2, true, true, o2, this)));
        if (q4 != null) {
            q4.a();
            this.h.a(o2, q4);
        }
        if (q4 == null) return null;
        if (!i) return q4;
        l.d("Loaded resource from cache", l2, o2);
        return q4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(c.c.a.m.u.m<?> m2, m m3, q<?> q2) {
        l l2 = this;
        synchronized (l2) {
            t t2;
            if (q2 != null && q2.e) {
                this.h.a(m3, q2);
            }
            if ((t2 = this.a) == null) {
                throw null;
            }
            Map<m, c.c.a.m.u.m<?>> map = t2.a(m2.t);
            if (m2.equals(map.get((Object)m3))) {
                map.remove((Object)m3);
            }
            return;
        }
    }

    public void f(w<?> w2) {
        if (w2 instanceof q) {
            ((q)w2).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final <R> d g(c.c.a.d d2, Object object, m m2, int n2, int n3, Class<?> class_, Class<R> class_2, e e2, k k2, Map<Class<?>, s<?>> map, boolean bl, boolean bl2, o o2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, c.c.a.q.f f2, Executor executor, c.c.a.m.u.o o3, long l2) {
        t t2 = this.a;
        Map<m, c.c.a.m.u.m<?>> map2 = bl6 ? t2.b : t2.a;
        c.c.a.m.u.m m3 = (c.c.a.m.u.m)map2.get((Object)o3);
        if (m3 != null) {
            m3.b(f2, executor);
            if (!i) return new Object(f2, m3){
                public final c.c.a.m.u.m<?> a;
                public final c.c.a.q.f b;
                {
                    this.b = f2;
                    this.a = m2;
                }
            };
            l.d("Added to existing load", l2, o3);
            return new /* invalid duplicate definition of identical inner class */;
        }
        c.c.a.m.u.m<?> m4 = this.d.g.b();
        h.i.p(m4, "Argument must not be null");
        c.c.a.m.u.m<?> m5 = m4;
        // MONITORENTER : m5
        m4.p = o3;
        m4.q = bl3;
        m4.r = bl4;
        m4.s = bl5;
        m4.t = bl6;
        // MONITOREXIT : m5
        a a2 = this.g;
        c.c.a.m.u.i<?> i2 = a2.b.b();
        h.i.p(i2, "Argument must not be null");
        int n4 = a2.c;
        a2.c = n4 + 1;
        c.c.a.m.u.h h2 = i2.e;
        i.d d3 = i2.h;
        h2.c = d2;
        h2.d = object;
        h2.n = m2;
        h2.e = n2;
        h2.f = n3;
        h2.p = k2;
        h2.g = class_;
        h2.h = d3;
        h2.k = class_2;
        h2.o = e2;
        h2.i = o2;
        h2.j = map;
        h2.q = bl;
        h2.r = bl2;
        i2.l = d2;
        i2.m = m2;
        i2.n = e2;
        i2.o = o3;
        i2.p = n2;
        i2.q = n3;
        i2.r = k2;
        i2.y = bl6;
        i2.s = o2;
        i2.t = m4;
        i2.u = n4;
        i2.w = i.f.e;
        i2.z = object;
        t t3 = this.a;
        if (t3 == null) throw null;
        t3.a(m4.t).put((Object)o3, m4);
        m4.b(f2, executor);
        m5 = m4;
        // MONITORENTER : m5
        m4.A = i2;
        i.g g2 = i2.i(i.g.e);
        boolean bl7 = g2 == i.g.f || g2 == i.g.g;
        c.c.a.m.u.e0.a a3 = bl7 ? m4.k : (m4.r ? m4.m : (m4.s ? m4.n : m4.l));
        a3.e.execute(i2);
        // MONITOREXIT : m5
        if (!i) return new /* invalid duplicate definition of identical inner class */;
        l.d("Started new load", l2, o3);
        return new /* invalid duplicate definition of identical inner class */;
    }

    public static class c
    implements i.d {
        public final a.a a;
        public volatile c.c.a.m.u.d0.a b;

        public c(a.a a2) {
            this.a = a2;
        }

        /*
         * Exception decompiling
         */
        public c.c.a.m.u.d0.a a() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
            // org.benf.cfr.reader.b.a.a.i.b(Op03SimpleStatement.java:414)
            // org.benf.cfr.reader.b.a.a.b.ad.a(Misc.java:226)
            // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:623)
            // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:52)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:576)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
            // java.lang.Thread.run(Thread.java:764)
            throw new IllegalStateException("Decompilation failed");
        }
    }

}

