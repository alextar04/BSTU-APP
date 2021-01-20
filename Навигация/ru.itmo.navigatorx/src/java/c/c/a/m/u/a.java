/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  c.c.a.m.u.q
 *  f.b.k.h
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ref.ReferenceQueue
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ThreadFactory
 */
package c.c.a.m.u;

import android.os.Process;
import c.c.a.m.m;
import c.c.a.m.u.q;
import c.c.a.m.u.w;
import f.b.k.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class a {
    public final boolean a;
    public final Map<m, b> b;
    public final ReferenceQueue<q<?>> c;
    public q.a d;

    public a(boolean bl) {
        ExecutorService executorService = Executors.newSingleThreadExecutor((ThreadFactory)new ThreadFactory(){

            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable(this){

                    public void run() {
                        Process.setThreadPriority((int)10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }

        });
        this.b = new HashMap();
        this.c = new ReferenceQueue();
        this.a = bl;
        executorService.execute((Runnable)new c.c.a.m.u.b(this));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(m m2, q<?> q2) {
        a a2 = this;
        synchronized (a2) {
            b b2 = new b(m2, q2, this.c, this.a);
            b b3 = (b)((Object)this.b.put((Object)m2, (Object)b2));
            if (b3 != null) {
                b3.c = null;
                b3.clear();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(b b2) {
        a a2 = this;
        synchronized (a2) {
            this.b.remove((Object)b2.a);
            if (b2.b && b2.c != null) {
                // MONITOREXIT [2, 3] lbl5 : w: MONITOREXIT : var5_2
                q q2 = new q(b2.c, true, false, b2.a, this.d);
                this.d.a(b2.a, q2);
                return;
            }
            return;
        }
    }

    public static final class b
    extends WeakReference<q<?>> {
        public final m a;
        public final boolean b;
        public w<?> c;

        public b(m m2, q<?> q2, ReferenceQueue<? super q<?>> referenceQueue, boolean bl) {
            w w2;
            super(q2, referenceQueue);
            h.i.p(m2, "Argument must not be null");
            this.a = m2;
            if (q2.e && bl) {
                w2 = q2.g;
                h.i.p(w2, "Argument must not be null");
            } else {
                w2 = null;
            }
            this.c = w2;
            this.b = q2.e;
        }
    }

}

