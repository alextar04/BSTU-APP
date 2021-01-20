/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.m1.f
 *  f.b.k.h
 *  java.lang.Object
 *  java.util.concurrent.TimeUnit
 */
package d.a.m1;

import d.a.a.q;
import d.a.m1.f;
import d.a.m1.l;
import f.b.k.h;
import java.util.concurrent.TimeUnit;

public final class k {
    public static final long a = h.i.N1("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
    public static final int b;
    public static final int c;
    public static final long d;
    public static l e;

    public static {
        h.i.M1("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        int n2 = q.a;
        int n3 = n2 < 2 ? 2 : n2;
        b = h.i.M1("kotlinx.coroutines.scheduler.core.pool.size", n3, 1, 0, 8, null);
        c = h.i.M1("kotlinx.coroutines.scheduler.max.pool.size", h.i.w(128 * q.a, b, 2097150), 0, 2097150, 4, null);
        d = TimeUnit.SECONDS.toNanos(h.i.N1("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        e = f.a;
    }
}

