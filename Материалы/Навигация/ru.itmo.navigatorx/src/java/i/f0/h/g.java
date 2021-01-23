/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.f0.h.g$a
 *  i.f0.h.g$b
 *  i.f0.h.g$d$a
 *  i.f0.h.g$e
 *  i.f0.h.g$f
 *  j.e
 *  j.f
 *  j.g
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.net.Socket
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package i.f0.h;

import i.f0.c;
import i.f0.h.g;
import i.f0.h.o;
import i.f0.h.p;
import i.f0.h.q;
import i.f0.h.s;
import i.f0.h.t;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public final class g
implements Closeable {
    public static final ExecutorService y;
    public final boolean e;
    public final d f;
    public final Map<Integer, p> g;
    public final String h;
    public int i;
    public int j;
    public boolean k;
    public final ScheduledExecutorService l;
    public final ExecutorService m;
    public final s n;
    public boolean o;
    public long p;
    public long q;
    public t r;
    public final t s;
    public boolean t;
    public final Socket u;
    public final q v;
    public final f w;
    public final Set<Integer> x;

    public static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), i.f0.c.A("OkHttp Http2Connection", true));
        y = threadPoolExecutor;
    }

    public g(c c2) {
        boolean bl;
        this.g = new LinkedHashMap();
        this.p = 0L;
        this.r = new t();
        this.s = new t();
        this.t = false;
        this.x = new LinkedHashSet();
        this.n = c2.f;
        this.e = bl = c2.g;
        this.f = c2.e;
        int n2 = bl ? 1 : 2;
        this.j = n2;
        if (c2.g) {
            this.j = n2 + 2;
        }
        if (c2.g) {
            this.r.b(7, 16777216);
        }
        this.h = c2.b;
        Object[] arrobject = new Object[]{this.h};
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactory(i.f0.c.n("OkHttp %s Writer", arrobject), false){

            public java.lang.Thread newThread(Runnable runnable) {
                java.lang.Thread thread = new java.lang.Thread(runnable, String.this);
                thread.setDaemon(bl);
                return thread;
            }
        });
        this.l = scheduledThreadPoolExecutor;
        if (c2.h != 0) {
            e e2 = new /* Unavailable Anonymous Inner Class!! */;
            long l2 = c2.h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate((Runnable)e2, l2, l2, TimeUnit.MILLISECONDS);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Object[] arrobject2 = new Object[]{this.h};
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, timeUnit, (BlockingQueue)linkedBlockingQueue, new /* invalid duplicate definition of identical inner class */);
        this.m = threadPoolExecutor;
        this.s.b(7, 65535);
        this.s.b(5, 16384);
        this.q = this.s.a();
        this.u = c2.a;
        this.v = new q(c2.d, this.e);
        this.w = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static void c(g g2) {
        if (g2 != null) {
            i.f0.h.b b2 = i.f0.h.b.g;
            try {
                g2.f(b2, b2);
            }
            catch (IOException iOException) {}
            return;
        }
        throw null;
    }

    public void B(int n2, i.f0.h.b b2) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.l;
            Object[] arrobject = new Object[]{this.h, n2};
            a a2 = new a(this, "OkHttp %s stream %d", arrobject, n2, b2);
            scheduledExecutorService.execute((Runnable)a2);
        }
        catch (RejectedExecutionException rejectedExecutionException) {}
    }

    public void J(int n2, long l2) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.l;
            Object[] arrobject = new Object[]{this.h, n2};
            b b2 = new b(this, "OkHttp Window Update %s stream %d", arrobject, n2, l2);
            scheduledExecutorService.execute((Runnable)b2);
        }
        catch (RejectedExecutionException rejectedExecutionException) {}
    }

    public void close() {
        this.f(i.f0.h.b.f, i.f0.h.b.k);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void f(i.f0.h.b b2, i.f0.h.b b3) {
        IOException iOException;
        block14 : {
            try {
                this.u(b2);
                iOException = null;
            }
            catch (IOException iOException2) {
                // empty catch block
            }
            g g2 = this;
            // MONITORENTER : g2
            boolean bl = this.g.isEmpty();
            p[] arrp = null;
            if (!bl) {
                arrp = (p[])this.g.values().toArray((Object[])new p[this.g.size()]);
                this.g.clear();
            }
            // MONITOREXIT : g2
            if (arrp != null) {
                for (p p2 : arrp) {
                    try {
                        p2.c(b3);
                    }
                    catch (IOException iOException3) {
                        if (iOException == null) continue;
                        iOException = iOException3;
                    }
                }
            }
            try {
                this.v.close();
            }
            catch (IOException iOException4) {
                if (iOException != null) break block14;
                iOException = iOException4;
            }
        }
        try {
            this.u.close();
        }
        catch (IOException iOException5) {
            // empty catch block
        }
        this.l.shutdown();
        this.m.shutdown();
        if (iOException != null) throw iOException;
    }

    public void flush() {
        this.v.flush();
    }

    public p h(int n2) {
        g g2 = this;
        synchronized (g2) {
            p p2 = (p)this.g.get((Object)n2);
            return p2;
        }
    }

    public int j() {
        g g2 = this;
        synchronized (g2) {
            t t2 = this.s;
            int n2 = Integer.MAX_VALUE;
            if ((16 & t2.a) != 0) {
                n2 = t2.b[4];
            }
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void m(i.f0.b b2) {
        g g2 = this;
        // MONITORENTER : g2
        g2 = this;
        // MONITORENTER : g2
        boolean bl = this.k;
        // MONITOREXIT : g2
        if (!bl) {
            this.m.execute((Runnable)b2);
        }
        // MONITOREXIT : g2
    }

    public boolean p(int n2) {
        return n2 != 0 && (n2 & 1) == 0;
    }

    public p s(int n2) {
        g g2 = this;
        synchronized (g2) {
            p p2 = (p)this.g.remove((Object)n2);
            this.notifyAll();
            return p2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void u(i.f0.h.b b2) {
        q q2;
        q q3 = q2 = this.v;
        synchronized (q3) {
            int n2;
            g g2 = this;
            synchronized (g2) {
                if (this.k) {
                    return;
                }
                this.k = true;
                n2 = this.i;
            }
            this.v.j(n2, b2, i.f0.c.a);
            return;
        }
    }

    public void v(long l2) {
        g g2 = this;
        synchronized (g2) {
            long l3;
            this.p = l3 = l2 + this.p;
            if (l3 >= (long)(this.r.a() / 2)) {
                this.J(0, this.p);
                this.p = 0L;
            }
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public void x(int var1_1, boolean var2_2, j.e var3_3, long var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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

    public static class c {
        public Socket a;
        public String b;
        public j.g c;
        public j.f d;
        public d e = d.a;
        public s f = s.a;
        public boolean g;
        public int h;

        public c(boolean bl) {
            this.g = bl;
        }
    }

    public static abstract class d {
        public static final d a = new a();

        public void a(g g2) {
        }

        public abstract void b(p var1);
    }

}

