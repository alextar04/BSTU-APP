/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Queue
 */
package c.c.a.m.u.c0;

import c.c.a.m.u.c0.l;
import c.c.a.s.j;
import java.util.Queue;

public abstract class c<T extends l> {
    public final Queue<T> a = j.c(20);

    public abstract T a();

    public T b() {
        l l2 = (l)this.a.poll();
        if (l2 == null) {
            l2 = this.a();
        }
        return (T)l2;
    }

    public void c(T t2) {
        if (this.a.size() < 20) {
            this.a.offer(t2);
        }
    }
}

