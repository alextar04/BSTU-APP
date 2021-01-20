/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  d.a.m1.d
 *  d.a.m1.f
 *  d.a.m1.g
 *  d.a.m1.j
 *  f.b.k.h
 *  h.m.b.j
 *  h.n.c
 *  java.io.Closeable
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.concurrent.Executor
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 *  java.util.concurrent.locks.LockSupport
 */
package d.a.m1;

import d.a.a.p;
import d.a.m1.d;
import d.a.m1.f;
import d.a.m1.g;
import d.a.m1.h;
import d.a.m1.i;
import d.a.m1.j;
import d.a.m1.k;
import d.a.m1.l;
import d.a.m1.m;
import f.b.k.h;
import h.n.c;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

public final class a
implements Executor,
Closeable {
    public static final AtomicLongFieldUpdater l;
    public static final AtomicLongFieldUpdater m;
    public static final AtomicIntegerFieldUpdater n;
    public static final p o;
    public volatile int _isTerminated;
    public volatile long controlState;
    public final d e;
    public final d f;
    public final AtomicReferenceArray<a> g;
    public final int h;
    public final int i;
    public final long j;
    public final String k;
    public volatile long parkedWorkersStack;

    public static {
        o = new p("NOT_IN_STACK");
        l = AtomicLongFieldUpdater.newUpdater(a.class, (String)"parkedWorkersStack");
        m = AtomicLongFieldUpdater.newUpdater(a.class, (String)"controlState");
        n = AtomicIntegerFieldUpdater.newUpdater(a.class, (String)"_isTerminated");
    }

    public a(int n2, int n3, long l2, String string) {
        this.h = n2;
        this.i = n3;
        this.j = l2;
        this.k = string;
        boolean bl = n2 >= 1;
        if (bl) {
            boolean bl2 = this.i >= this.h;
            if (bl2) {
                boolean bl3 = this.i <= 2097150;
                if (bl3) {
                    boolean bl4 = this.j > 0L;
                    if (bl4) {
                        this.e = new d();
                        this.f = new d();
                        this.parkedWorkersStack = 0L;
                        this.g = new AtomicReferenceArray(1 + this.i);
                        this.controlState = (long)this.h << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    StringBuilder stringBuilder = c.b.a.a.a.c((String)"Idle worker keep alive time ");
                    stringBuilder.append(this.j);
                    stringBuilder.append(" must be positive");
                    throw new IllegalArgumentException(stringBuilder.toString().toString());
                }
                StringBuilder stringBuilder = c.b.a.a.a.c((String)"Max pool size ");
                stringBuilder.append(this.i);
                stringBuilder.append(" should not exceed maximal supported number of threads 2097150");
                throw new IllegalArgumentException(stringBuilder.toString().toString());
            }
            StringBuilder stringBuilder = c.b.a.a.a.c((String)"Max pool size ");
            stringBuilder.append(this.i);
            stringBuilder.append(" should be greater than or equals to core pool size ");
            stringBuilder.append(this.h);
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
        StringBuilder stringBuilder = c.b.a.a.a.c((String)"Core pool size ");
        stringBuilder.append(this.h);
        stringBuilder.append(" should be at least 1");
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public static /* synthetic */ void m(a a2, Runnable runnable, i i2, boolean bl, int n2) {
        Object object = (n2 & 2) != 0 ? g.e : null;
        if ((n2 & 4) != 0) {
            bl = false;
        }
        a2.j(runnable, (i)object, bl);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean B() {
        do lbl-1000: // 3 sources:
        {
            block2 : {
                block1 : {
                    if ((var4_3 = (a)this.g.get(var3_2 = (int)(0x1FFFFFL & (var1_1 = this.parkedWorkersStack)))) == null) break block1;
                    var6_5 = -2097152L & 0x200000L + var1_1;
                    var8_6 = this.p(var4_3);
                    if (var8_6 < 0 || !a.l.compareAndSet((Object)this, var1_1, var6_5 | (long)var8_6)) ** GOTO lbl-1000
                    var4_3.nextParkedWorker = a.o;
                    break block2;
                }
                var4_3 = null;
            }
            var5_4 = false;
            if (var4_3 == null) return var5_4;
        } while (!a.l.compareAndSet((Object)var4_3, -1, 0));
        LockSupport.unpark((Thread)var4_3);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int c() {
        AtomicReferenceArray<a> atomicReferenceArray;
        AtomicReferenceArray<a> atomicReferenceArray2 = atomicReferenceArray = this.g;
        synchronized (atomicReferenceArray2) {
            int n2;
            int n3 = this._isTerminated;
            if (n3 != 0) {
                return -1;
            }
            long l2 = this.controlState;
            int n4 = (int)(l2 & 0x1FFFFFL);
            int n5 = n4 - (int)((l2 & 4398044413952L) >> 21);
            if (n5 < 0) {
                n5 = 0;
            }
            if (n5 >= (n2 = this.h)) {
                return 0;
            }
            int n6 = this.i;
            if (n4 >= n6) {
                return 0;
            }
            int n7 = 1 + (int)(0x1FFFFFL & this.controlState);
            boolean bl = n7 > 0 && this.g.get(n7) == null;
            if (!bl) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            a a2 = new a(n7);
            this.g.set(n7, (Object)a2);
            int n8 = (int)(0x1FFFFFL & m.incrementAndGet((Object)this));
            boolean bl2 = false;
            if (n7 == n8) {
                bl2 = true;
            }
            if (!bl2) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            a2.start();
            return n5 + 1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void close() {
        AtomicReferenceArray<a> atomicReferenceArray;
        if (!n.compareAndSet((Object)this, 0, 1)) {
            return;
        }
        a a2 = this.h();
        AtomicReferenceArray<a> atomicReferenceArray2 = atomicReferenceArray = this.g;
        // MONITORENTER : atomicReferenceArray2
        long l2 = this.controlState;
        int n2 = (int)(l2 & 0x1FFFFFL);
        // MONITOREXIT : atomicReferenceArray2
        if (1 <= n2) {
            int n3 = 1;
            do {
                Object object = this.g.get(n3);
                h.m.b.j.c((Object)object);
                a a3 = (a)((Object)object);
                if (a3 != a2) {
                    boolean bl;
                    while (a3.isAlive()) {
                        LockSupport.unpark((Thread)a3);
                        a3.join(10000L);
                    }
                    m m2 = a3.e;
                    d d2 = this.f;
                    if (m2 == null) throw null;
                    h h2 = (h)m.b.getAndSet((Object)m2, null);
                    if (h2 != null) {
                        d2.a(h2);
                    }
                    do {
                        h h3;
                        if ((h3 = m2.f()) != null) {
                            d2.a(h3);
                            bl = true;
                            continue;
                        }
                        bl = false;
                    } while (bl);
                }
                if (n3 == n2) break;
                ++n3;
            } while (true);
        }
        this.f.b();
        this.e.b();
        do {
            h h4;
            if (a2 == null || (h4 = a2.a(true)) == null) {
                h4 = (h)this.e.d();
            }
            if (h4 == null) {
                h4 = (h)this.f.d();
            }
            if (h4 == null) break;
            this.u(h4);
        } while (true);
        if (a2 != null) {
            a2.e(b.i);
        }
        this.parkedWorkersStack = 0L;
        this.controlState = 0L;
    }

    public void execute(Runnable runnable) {
        this.j(runnable, (i)g.e, false);
    }

    public final h f(Runnable runnable, i i2) {
        if ((f)k.e != null) {
            long l2 = System.nanoTime();
            if (runnable instanceof h) {
                h h2 = (h)runnable;
                h2.e = l2;
                h2.f = i2;
                return h2;
            }
            return new j(runnable, l2, i2);
        }
        throw null;
    }

    public final a h() {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof a)) {
            thread = null;
        }
        a a2 = (a)thread;
        a a3 = null;
        if (a2 != null) {
            boolean bl = h.m.b.j.a((Object)a2.a.this, (Object)this);
            a3 = null;
            if (bl) {
                a3 = a2;
            }
        }
        return a3;
    }

    public final void j(Runnable runnable, i i2, boolean bl) {
        d d2;
        int n2;
        h h2;
        h h3 = this.f(runnable, i2);
        a a2 = this.h();
        int n3 = 1;
        if (a2 == null || a2.f == b.i || h3.f.s() == 0 && a2.f == b.f) {
            h2 = h3;
        } else {
            a2.j = n3;
            h2 = a2.e.a(h3, bl);
        }
        if (h2 != null && !(d2 = (n2 = h2.f.s() == n3 ? n3 : 0) != 0 ? this.f : this.e).a(h2)) {
            throw new RejectedExecutionException(c.b.a.a.a.l((StringBuilder)new StringBuilder(), (String)this.k, (String)" was terminated"));
        }
        if (!bl || a2 == null) {
            n3 = 0;
        }
        if (h3.f.s() == 0) {
            if (n3 != 0) {
                return;
            }
            this.v();
            return;
        }
        long l2 = m.addAndGet((Object)this, 0x200000L);
        if (n3 != 0) {
            return;
        }
        if (this.B()) {
            return;
        }
        if (this.x(l2)) {
            return;
        }
        this.B();
    }

    public final int p(a a2) {
        int n2;
        do {
            Object object;
            if ((object = a2.nextParkedWorker) == o) {
                return -1;
            }
            if (object == null) {
                return 0;
            }
            a2 = (a)((Object)object);
        } while ((n2 = a2.indexInArray) == 0);
        return n2;
    }

    public final void s(a a2, int n2, int n3) {
        long l2;
        long l3;
        int n4;
        do {
            l2 = this.parkedWorkersStack;
            n4 = (int)(0x1FFFFFL & l2);
            l3 = -2097152L & 0x200000L + l2;
            if (n4 != n2) continue;
            n4 = n3 == 0 ? this.p(a2) : n3;
        } while (n4 < 0 || !l.compareAndSet((Object)this, l2, l3 | (long)n4));
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int n2 = this.g.length();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 1;
        do {
            block3 : {
                StringBuilder stringBuilder;
                String string;
                block8 : {
                    int n9;
                    block4 : {
                        block5 : {
                            block6 : {
                                block7 : {
                                    if (n8 >= n2) {
                                        long l2 = this.controlState;
                                        StringBuilder stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append(this.k);
                                        stringBuilder2.append('@');
                                        stringBuilder2.append(h.i.g0(this));
                                        stringBuilder2.append('[');
                                        stringBuilder2.append("Pool Size {");
                                        stringBuilder2.append("core = ");
                                        stringBuilder2.append(this.h);
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("max = ");
                                        stringBuilder2.append(this.i);
                                        stringBuilder2.append("}, ");
                                        stringBuilder2.append("Worker States {");
                                        stringBuilder2.append("CPU = ");
                                        stringBuilder2.append(n3);
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("blocking = ");
                                        stringBuilder2.append(n4);
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("parked = ");
                                        stringBuilder2.append(n5);
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("dormant = ");
                                        stringBuilder2.append(n6);
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("terminated = ");
                                        stringBuilder2.append(n7);
                                        stringBuilder2.append("}, ");
                                        stringBuilder2.append("running workers queues = ");
                                        stringBuilder2.append((Object)arrayList);
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("global CPU queue size = ");
                                        stringBuilder2.append(this.e.c());
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("global blocking queue size = ");
                                        stringBuilder2.append(this.f.c());
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("Control State {");
                                        stringBuilder2.append("created workers= ");
                                        stringBuilder2.append((int)(0x1FFFFFL & l2));
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("blocking tasks = ");
                                        stringBuilder2.append((int)((4398044413952L & l2) >> 21));
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append("CPUs acquired = ");
                                        stringBuilder2.append(this.h - (int)((9223367638808264704L & l2) >> 42));
                                        stringBuilder2.append("}]");
                                        return stringBuilder2.toString();
                                    }
                                    a a2 = (a)((Object)this.g.get(n8));
                                    if (a2 == null) break block3;
                                    n9 = a2.e.d();
                                    int n10 = a2.f.ordinal();
                                    if (n10 == 0) break block4;
                                    if (n10 == 1) break block5;
                                    if (n10 == 2) break block6;
                                    if (n10 == 3) break block7;
                                    if (n10 == 4) {
                                        ++n7;
                                    }
                                    break block3;
                                }
                                ++n6;
                                if (n9 <= 0) break block3;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(String.valueOf((int)n9));
                                string = "d";
                                break block8;
                            }
                            ++n5;
                            break block3;
                        }
                        ++n4;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(String.valueOf((int)n9));
                        string = "b";
                        break block8;
                    }
                    ++n3;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(String.valueOf((int)n9));
                    string = "c";
                }
                stringBuilder.append(string);
                arrayList.add((Object)stringBuilder.toString());
            }
            ++n8;
        } while (true);
    }

    public final void u(h h2) {
        try {
            h2.run();
            return;
        }
        catch (Throwable throwable) {
            Thread thread = Thread.currentThread();
            thread.getUncaughtExceptionHandler().uncaughtException(thread, throwable);
            return;
        }
    }

    public final void v() {
        if (this.B()) {
            return;
        }
        if (this.x(this.controlState)) {
            return;
        }
        this.B();
    }

    public final boolean x(long l2) {
        int n2 = (int)(0x1FFFFFL & l2) - (int)((l2 & 4398044413952L) >> 21);
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 < this.h) {
            int n3 = this.c();
            if (n3 == 1 && this.h > 1) {
                this.c();
            }
            if (n3 > 0) {
                return true;
            }
        }
        return false;
    }

    public final class a
    extends Thread {
        public static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(a.class, (String)"workerCtl");
        public final m e;
        public b f;
        public long g;
        public long h;
        public int i;
        public volatile int indexInArray;
        public boolean j;
        public volatile Object nextParkedWorker;
        public volatile int workerCtl;

        public a(int n2) {
            this.setDaemon(true);
            this.e = new m();
            this.f = b.h;
            this.workerCtl = 0;
            this.nextParkedWorker = a.o;
            this.i = c.a.a();
            this.d(n2);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public final h a(boolean var1_1) {
            block9 : {
                var2_2 = b.e;
                var3_3 = this.f;
                var4_4 = true;
                if (var3_3 == var2_2) ** GOTO lbl15
                var5_5 = a.this;
                do {
                    if ((int)((9223367638808264704L & (var6_6 = var5_5.controlState)) >> 42) != 0) continue;
                    var8_8 = false;
                    break block9;
                } while (!a.m.compareAndSet((Object)var5_5, var6_6, var15_7 = var6_6 - 0x40000000000L));
                var8_8 = var4_4;
            }
            if (var8_8) {
                this.f = var2_2;
lbl15: // 2 sources:
                var9_9 = var4_4;
            } else {
                var9_9 = false;
            }
            if (var9_9) {
                if (!var1_1) {
                    var11_13 = this.c();
                    if (var11_13 == null) return this.f(false);
                    return var11_13;
                }
                if (this.b(2 * a.this.h) != 0) {
                    var4_4 = false;
                }
                if (var4_4 && (var14_10 = this.c()) != null) {
                    return var14_10;
                }
                var12_11 = this.e.e();
                if (var12_11 != null) {
                    return var12_11;
                }
                if (var4_4 != false) return this.f(false);
                var13_12 = this.c();
                if (var13_12 == null) return this.f(false);
                return var13_12;
            }
            if (!var1_1 || (var10_14 = this.e.e()) == null) {
                var10_14 = (h)a.this.f.d();
            }
            if (var10_14 == null) return this.f(var4_4);
            return var10_14;
        }

        public final int b(int n2) {
            int n3;
            int n4 = this.i;
            int n5 = n4 ^ n4 << 13;
            int n6 = n5 ^ n5 >> 17;
            this.i = n3 = n6 ^ n6 << 5;
            int n7 = n2 - 1;
            if ((n7 & n2) == 0) {
                return n3 & n7;
            }
            return (n3 & Integer.MAX_VALUE) % n2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final h c() {
            d d2;
            if (this.b(2) == 0) {
                h h2 = (h)a.this.e.d();
                if (h2 != null) {
                    return h2;
                }
                d2 = a.this.f;
                do {
                    return (h)d2.d();
                    break;
                } while (true);
            }
            h h3 = (h)a.this.f.d();
            if (h3 != null) {
                return h3;
            }
            d2 = a.this.e;
            return (h)d2.d();
        }

        public final void d(int n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.this.k);
            stringBuilder.append("-worker-");
            String string = n2 == 0 ? "TERMINATED" : String.valueOf((int)n2);
            stringBuilder.append(string);
            this.setName(stringBuilder.toString());
            this.indexInArray = n2;
        }

        public final boolean e(b b2) {
            b b3 = this.f;
            boolean bl = b3 == b.e;
            if (bl) {
                a a2 = a.this;
                a.m.addAndGet((Object)a2, 0x40000000000L);
            }
            if (b3 != b2) {
                this.f = b2;
            }
            return bl;
        }

        public final h f(boolean bl) {
            int n2 = (int)(0x1FFFFFL & a.this.controlState);
            if (n2 < 2) {
                return null;
            }
            int n3 = this.b(n2);
            long l2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < n2; ++i2) {
                block15 : {
                    long l3;
                    block14 : {
                        m m2;
                        m m3;
                        block12 : {
                            block13 : {
                                long l4;
                                block11 : {
                                    a a2;
                                    if (++n3 > n2) {
                                        n3 = 1;
                                    }
                                    if ((a2 = (a)((Object)a.this.g.get(n3))) == null || a2 == this) continue;
                                    m3 = this.e;
                                    m2 = a2.e;
                                    if (!bl) break block12;
                                    if (m3 == null) break block13;
                                    int n4 = m2.producerIndex;
                                    AtomicReferenceArray<h> atomicReferenceArray = m2.a;
                                    for (int i3 = m2.consumerIndex; i3 != n4; ++i3) {
                                        boolean bl2;
                                        int n5 = i3 & 127;
                                        if (m2.blockingTasksInBuffer == 0) break;
                                        h h2 = (h)atomicReferenceArray.get(n5);
                                        if (h2 == null || !(bl2 = h2.f.s() == 1) || !atomicReferenceArray.compareAndSet(n5, (Object)h2, null)) continue;
                                        m.e.decrementAndGet((Object)m2);
                                        m3.a(h2, false);
                                        l4 = -1L;
                                        break block11;
                                    }
                                    l4 = m3.g(m2, true);
                                }
                                l3 = l4;
                                break block14;
                            }
                            throw null;
                        }
                        if (m3 == null) break block15;
                        h h3 = m2.f();
                        if (h3 != null) {
                            m3.a(h3, false);
                            l3 = -1L;
                        } else {
                            l3 = m3.g(m2, false);
                        }
                    }
                    if (l3 == -1L) {
                        return this.e.e();
                    }
                    if (l3 <= 0L) continue;
                    l2 = Math.min((long)l2, (long)l3);
                    continue;
                }
                throw null;
            }
            if (l2 == Long.MAX_VALUE) {
                l2 = 0L;
            }
            this.h = l2;
            return null;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            b b2 = b.g;
            b b3 = b.i;
            block3 : do {
                boolean bl = false;
                block4 : while (a.this._isTerminated == 0 && this.f != b3) {
                    boolean bl2;
                    block19 : {
                        long l2;
                        a a2;
                        block18 : {
                            block17 : {
                                h h2 = this.a(this.j);
                                l2 = -2097152L;
                                if (h2 != null) {
                                    this.h = 0L;
                                    b b4 = b.f;
                                    int n2 = h2.f.s();
                                    this.g = 0L;
                                    if (this.f == b2) {
                                        this.f = b4;
                                    }
                                    if (n2 != 0 && this.e(b4)) {
                                        a.this.v();
                                    }
                                    a.this.u(h2);
                                    if (n2 == 0) continue block3;
                                    a a3 = a.this;
                                    a.m.addAndGet((Object)a3, l2);
                                    if (this.f == b3) continue block3;
                                    this.f = b.h;
                                    continue block3;
                                }
                                this.j = false;
                                if (this.h != 0L) {
                                    if (!bl) {
                                        bl = true;
                                        continue;
                                    }
                                    this.e(b2);
                                    Thread.interrupted();
                                    LockSupport.parkNanos((long)this.h);
                                    this.h = 0L;
                                    continue block3;
                                }
                                boolean bl3 = this.nextParkedWorker != a.o;
                                if (bl3) break block17;
                                a2 = a.this;
                                if (a2 == null) {
                                    throw null;
                                }
                                if (this.nextParkedWorker != a.o) {
                                    continue;
                                }
                                break block18;
                            }
                            this.workerCtl = -1;
                            break block19;
                        }
                        do {
                            long l3 = a2.parkedWorkersStack;
                            int n3 = (int)(l3 & 0x1FFFFFL);
                            long l4 = l2 & 0x200000L + l3;
                            int n4 = this.indexInArray;
                            this.nextParkedWorker = a2.g.get(n3);
                            if (a.l.compareAndSet((Object)a2, l3, l4 | (long)n4)) continue block4;
                            l2 = -2097152L;
                        } while (true);
                    }
                    while ((bl2 = this.nextParkedWorker != a.o) && a.this._isTerminated == 0 && this.f != b3) {
                        AtomicReferenceArray<a> atomicReferenceArray;
                        this.e(b2);
                        Thread.interrupted();
                        if (this.g == 0L) {
                            this.g = System.nanoTime() + a.this.j;
                        }
                        LockSupport.parkNanos((long)a.this.j);
                        if (System.nanoTime() - this.g < 0L) continue;
                        this.g = 0L;
                        AtomicReferenceArray<a> atomicReferenceArray2 = atomicReferenceArray = a.this.g;
                        synchronized (atomicReferenceArray2) {
                            boolean bl4;
                            if (a.this._isTerminated != 0 || (int)(0x1FFFFFL & a.this.controlState) <= a.this.h || !(bl4 = l.compareAndSet((Object)this, -1, 1))) {
                                continue;
                            }
                            int n5 = this.indexInArray;
                            this.d(0);
                            a.this.s(this, n5, 0);
                            a a4 = a.this;
                            int n6 = (int)(0x1FFFFFL & a.m.getAndDecrement((Object)a4));
                            if (n6 != n5) {
                                Object object = a.this.g.get(n6);
                                h.m.b.j.c((Object)object);
                                a a5 = (a)((Object)object);
                                a.this.g.set(n5, (Object)a5);
                                a5.d(n5);
                                a.this.s(a5, n6, n5);
                            }
                            a.this.g.set(n6, null);
                        }
                        this.f = b3;
                    }
                }
                break;
            } while (true);
            this.e(b3);
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b e;
        public static final /* enum */ b f;
        public static final /* enum */ b g;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        public static final /* synthetic */ b[] j;

        public static {
            b b2;
            b b3;
            b b4;
            b b5;
            b b6;
            b[] arrb = new b[5];
            e = b4 = new b();
            arrb[0] = b4;
            f = b5 = new b();
            arrb[1] = b5;
            g = b2 = new b();
            arrb[2] = b2;
            h = b3 = new b();
            arrb[3] = b3;
            i = b6 = new b();
            arrb[4] = b6;
            j = arrb;
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])j.clone();
        }
    }

}

