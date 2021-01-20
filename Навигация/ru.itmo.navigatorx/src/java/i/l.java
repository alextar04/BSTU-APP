/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.w
 *  i.w$b
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package i;

import i.f0.c;
import i.w;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l {
    public int a = 64;
    public int b = 5;
    public ExecutorService c;
    public final Deque<w.b> d = new ArrayDeque();
    public final Deque<w.b> e = new ArrayDeque();
    public final Deque<w> f = new ArrayDeque();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final <T> void a(Deque<T> deque, T t2) {
        l l2 = this;
        // MONITORENTER : l2
        if (!deque.remove(t2)) throw new AssertionError((Object)"Call wasn't in-flight!");
        // MONITOREXIT : l2
        ArrayList arrayList = new ArrayList();
        l2 = this;
        // MONITORENTER : l2
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            w.b b2 = (w.b)iterator.next();
            if (this.e.size() >= this.a) break;
            Iterator iterator2 = this.e.iterator();
            if (iterator2.hasNext()) {
                if ((w.b)iterator2.next() == null) throw null;
                throw null;
            }
            if (this.b <= 0) continue;
            iterator.remove();
            arrayList.add((Object)b2);
            this.e.add((Object)b2);
        }
        l2 = this;
        // MONITORENTER : l2
        int n2 = this.e.size();
        int n3 = this.f.size();
        int n4 = n2 + n3;
        // MONITOREXIT : l2
        if (n4 > 0) {
            // empty if block
        }
        // MONITOREXIT : l2
        int n5 = arrayList.size();
        int n6 = 0;
        while (n6 < n5) {
            w.b b3 = (w.b)arrayList.get(n6);
            l2 = this;
            // MONITORENTER : l2
            if (this.c == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), c.A("OkHttp Dispatcher", false));
                this.c = threadPoolExecutor;
            }
            ExecutorService executorService = this.c;
            // MONITOREXIT : l2
            if (b3 == null) throw null;
            try {
                executorService.execute((Runnable)b3);
                ++n6;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                try {
                    new InterruptedIOException("executor rejected").initCause((Throwable)rejectedExecutionException);
                    throw null;
                }
                catch (Throwable throwable) {
                    throw null;
                }
            }
        }
    }
}

