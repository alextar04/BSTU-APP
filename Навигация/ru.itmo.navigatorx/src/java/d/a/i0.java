/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 *  java.util.concurrent.locks.LockSupport
 */
package d.a;

import d.a.a.p;
import d.a.a.r;
import d.a.a0;
import d.a.g0;
import d.a.h0;
import d.a.j0;
import h.m.b.j;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

public abstract class i0
extends g0 {
    public abstract Thread T();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void U(long l2, h0.a a2) {
        int n2;
        a0 a02;
        block21 : {
            block23 : {
                h0.b b2;
                block27 : {
                    long l3;
                    block26 : {
                        h0.a a3;
                        block25 : {
                            block24 : {
                                block22 : {
                                    block20 : {
                                        a02 = a0.l;
                                        if (a02._isCompleted == 0) break block20;
                                        n2 = 1;
                                        break block21;
                                    }
                                    b2 = a02._delayed;
                                    if (b2 == null) {
                                        h0.j.compareAndSet((Object)a02, null, (Object)new r<h0.a>(l2){
                                            public long b;
                                            {
                                                this.b = l2;
                                            }
                                        });
                                        Object object = a02._delayed;
                                        j.c((Object)object);
                                        b2 = object;
                                    }
                                    h0.a a4 = a2;
                                    // MONITORENTER : a4
                                    if (a2.e != j0.a) break block22;
                                    n2 = 2;
                                    break block23;
                                }
                                h0.b b3 = b2;
                                // MONITORENTER : b3
                                a3 = b2.b();
                                int n3 = a02._isCompleted;
                                if (n3 == 0) break block24;
                                // MONITOREXIT : b3
                                n2 = 1;
                                break block23;
                            }
                            if (a3 != null) break block25;
                            l3 = l2;
                            break block26;
                        }
                        l3 = a3.g;
                        if (l3 - l2 >= 0L) {
                            l3 = l2;
                        }
                        if (l3 - b2.b <= 0L) break block27;
                    }
                    b2.b = l3;
                }
                if (a2.g - b2.b < 0L) {
                    a2.g = b2.b;
                }
                b2.a(a2);
                // MONITOREXIT : b3
                n2 = 0;
            }
            // MONITOREXIT : a4
        }
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) throw new IllegalStateException("unexpected result".toString());
                return;
            }
            a02.U(l2, a2);
            return;
        }
        h0.b b4 = a02._delayed;
        h0.a a5 = null;
        if (b4 != null) {
            h0.b b5 = b4;
            // MONITORENTER : b5
            T t2 = b4.b();
            // MONITOREXIT : b5
            a5 = t2;
        }
        boolean bl = false;
        if (a5 == a2) {
            bl = true;
        }
        if (!bl) return;
        Thread thread = ((i0)a02).T();
        if (Thread.currentThread() == thread) return;
        LockSupport.unpark((Thread)thread);
    }
}

