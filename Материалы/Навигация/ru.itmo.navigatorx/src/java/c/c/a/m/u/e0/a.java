/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  android.text.TextUtils
 *  c.c.a.m.u.e0.a$b$a
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.PriorityBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package c.c.a.m.u.e0;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import c.c.a.m.u.e0.a;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
implements ExecutorService {
    public static final long f = TimeUnit.SECONDS.toMillis(10L);
    public static volatile int g;
    public final ExecutorService e;

    public a(ExecutorService executorService) {
        this.e = executorService;
    }

    public static int a() {
        if (g == 0) {
            g = Math.min((int)4, (int)Runtime.getRuntime().availableProcessors());
        }
        return g;
    }

    public static a b() {
        b b2 = b.b;
        if (!TextUtils.isEmpty((CharSequence)"disk-cache")) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new PriorityBlockingQueue(), (ThreadFactory)new a("disk-cache", b2, true));
            return new a((ExecutorService)threadPoolExecutor);
        }
        throw new IllegalArgumentException(c.b.a.a.a.j("Name must be non-null and non-empty, but given: ", "disk-cache"));
    }

    public boolean awaitTermination(long l2, TimeUnit timeUnit) {
        return this.e.awaitTermination(l2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.e.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.e.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit) {
        return this.e.invokeAll(collection, l2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T)this.e.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit) {
        return (T)this.e.invokeAny(collection, l2, timeUnit);
    }

    public boolean isShutdown() {
        return this.e.isShutdown();
    }

    public boolean isTerminated() {
        return this.e.isTerminated();
    }

    public void shutdown() {
        this.e.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.e.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.e.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t2) {
        return this.e.submit(runnable, t2);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.e.submit(callable);
    }

    public String toString() {
        return this.e.toString();
    }

    public static final class c.c.a.m.u.e0.a$a
    implements ThreadFactory {
        public final String a;
        public final b b;
        public final boolean c;
        public int d;

        public c.c.a.m.u.e0.a$a(String string, b b2, boolean bl) {
            this.a = string;
            this.b = b2;
            this.c = bl;
        }

        public Thread newThread(Runnable runnable) {
            c.c.a.m.u.e0.a$a a2 = this;
            synchronized (a2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("glide-");
                stringBuilder.append(this.a);
                stringBuilder.append("-thread-");
                stringBuilder.append(this.d);
                Thread thread = new Thread(runnable, stringBuilder.toString()){

                    public void run() {
                        Process.setThreadPriority((int)9);
                        if (a.this.c) {
                            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                        }
                        try {
                            super.run();
                            return;
                        }
                        catch (Throwable throwable) {
                            a.this.b.a(throwable);
                            return;
                        }
                    }
                };
                this.d = 1 + this.d;
                return thread;
            }
        }

    }

    public static interface b {
        public static final b a;
        public static final b b;

        public static {
            b = a = new a();
        }

        public void a(Throwable var1);
    }

}

