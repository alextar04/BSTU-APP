/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.d
 *  d.a.g0
 *  java.lang.Object
 *  java.lang.Thread
 *  java.lang.ThreadLocal
 */
package d.a;

import d.a.d;
import d.a.g0;

public final class g1 {
    public static final ThreadLocal<g0> a = new ThreadLocal();
    public static final g1 b;

    public static final g0 a() {
        g0 g02 = (g0)a.get();
        if (g02 != null) {
            return g02;
        }
        d d2 = new d(Thread.currentThread());
        a.set((Object)d2);
        return d2;
    }
}

