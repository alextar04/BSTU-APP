/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.f
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package d.a.m1;

import d.a.a0;
import d.a.l0;
import d.a.m1.a;
import d.a.m1.c;
import d.a.m1.h;
import d.a.m1.i;
import d.a.v;
import h.k.f;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class e
extends l0
implements i,
Executor {
    public static final AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(e.class, (String)"inFlightTasks");
    public final ConcurrentLinkedQueue<Runnable> f;
    public final c g;
    public final int h;
    public final String i;
    public volatile int inFlightTasks;
    public final int j;

    public e(c c2, int n2, String string, int n3) {
        this.g = c2;
        this.h = n2;
        this.i = string;
        this.j = n3;
        this.f = new ConcurrentLinkedQueue();
        this.inFlightTasks = 0;
    }

    @Override
    public void K() {
        Runnable runnable = (Runnable)this.f.poll();
        if (runnable != null) {
            c c2 = this.g;
            if (c2 != null) {
                try {
                    c2.f.j(runnable, this, true);
                    return;
                }
                catch (RejectedExecutionException rejectedExecutionException) {
                    a0.l.V(c2.f.f(runnable, this));
                    return;
                }
            }
            throw null;
        }
        k.decrementAndGet((Object)this);
        Runnable runnable2 = (Runnable)this.f.poll();
        if (runnable2 != null) {
            this.N(runnable2, true);
        }
    }

    @Override
    public void L(f f2, Runnable runnable) {
        this.N(runnable, false);
    }

    public final void N(Runnable runnable, boolean bl) {
        do {
            if (k.incrementAndGet((Object)this) <= this.h) {
                c c2 = this.g;
                if (c2 != null) {
                    try {
                        c2.f.j(runnable, this, bl);
                        return;
                    }
                    catch (RejectedExecutionException rejectedExecutionException) {
                        a0.l.V(c2.f.f(runnable, this));
                        return;
                    }
                }
                throw null;
            }
            this.f.add((Object)runnable);
            if (k.decrementAndGet((Object)this) < this.h) continue;
            return;
        } while ((runnable = (Runnable)this.f.poll()) != null);
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public void execute(Runnable runnable) {
        this.N(runnable, false);
    }

    @Override
    public int s() {
        return this.j;
    }

    @Override
    public String toString() {
        String string = this.i;
        if (string != null) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.super.toString());
        stringBuilder.append("[dispatcher = ");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

