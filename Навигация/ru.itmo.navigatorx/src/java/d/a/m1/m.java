/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.m1.f
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.m1;

import d.a.m1.f;
import d.a.m1.h;
import d.a.m1.i;
import d.a.m1.k;
import d.a.m1.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class m {
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, (String)"lastScheduledTask");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(m.class, (String)"producerIndex");
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(m.class, (String)"consumerIndex");
    public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(m.class, (String)"blockingTasksInBuffer");
    public final AtomicReferenceArray<h> a = new AtomicReferenceArray(128);
    public volatile int blockingTasksInBuffer = 0;
    public volatile int consumerIndex = 0;
    public volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;

    public final h a(h h2, boolean bl) {
        if (bl) {
            return this.b(h2);
        }
        h h3 = (h)b.getAndSet((Object)this, (Object)h2);
        if (h3 != null) {
            return this.b(h3);
        }
        return null;
    }

    public final h b(h h2) {
        int n2;
        int n3 = h2.f.s();
        if (n3 != (n2 = 1)) {
            n2 = 0;
        }
        if (n2 != 0) {
            e.incrementAndGet((Object)this);
        }
        if (this.c() == 127) {
            return h2;
        }
        int n4 = 127 & this.producerIndex;
        while (this.a.get(n4) != null) {
            Thread.yield();
        }
        this.a.lazySet(n4, (Object)h2);
        c.incrementAndGet((Object)this);
        return null;
    }

    public final int c() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int d() {
        if (this.lastScheduledTask != null) {
            return 1 + this.c();
        }
        return this.c();
    }

    public final h e() {
        h h2 = (h)b.getAndSet((Object)this, null);
        if (h2 != null) {
            return h2;
        }
        return this.f();
    }

    public final h f() {
        int n2;
        int n3;
        int n4;
        h h2;
        do {
            if ((n4 = this.consumerIndex) - this.producerIndex == 0) {
                return null;
            }
            n3 = n4 & 127;
        } while (!d.compareAndSet((Object)this, n4, n4 + 1) || (h2 = (h)this.a.getAndSet(n3, null)) == null);
        int n5 = h2.f.s();
        if (n5 != (n2 = 1)) {
            n2 = 0;
        }
        if (n2 != 0) {
            e.decrementAndGet((Object)this);
        }
        return h2;
    }

    public final long g(m m2, boolean bl) {
        h h2;
        while ((h2 = (h)m2.lastScheduledTask) != null) {
            if (bl) {
                int n2;
                int n3 = h2.f.s();
                if (n3 != (n2 = 1)) {
                    n2 = 0;
                }
                if (n2 == 0) {
                    return -2L;
                }
            }
            if ((f)k.e != null) {
                long l2;
                long l3 = System.nanoTime() - h2.e;
                if (l3 < (l2 = k.a)) {
                    return l2 - l3;
                }
                if (!b.compareAndSet((Object)m2, (Object)h2, null)) continue;
                this.a(h2, false);
                return -1L;
            }
            throw null;
        }
        return -2L;
    }
}

