/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Thread
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ThreadFactory
 */
package f.c.a.a;

import android.os.Looper;
import f.c.a.a.b;
import f.c.a.a.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class b
extends c {
    public final Object a = new Object();
    public final ExecutorService b = Executors.newFixedThreadPool((int)4, (ThreadFactory)new ThreadFactory(this){
        public final java.util.concurrent.atomic.AtomicInteger a;
        {
            this.a = new java.util.concurrent.atomic.AtomicInteger(0);
        }

        public Thread newThread(java.lang.Runnable runnable) {
            Thread thread = new Thread(runnable);
            Object[] arrobject = new Object[]{this.a.getAndIncrement()};
            thread.setName(java.lang.String.format((java.lang.String)"arch_disk_io_%d", (Object[])arrobject));
            return thread;
        }
    });

    @Override
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}

