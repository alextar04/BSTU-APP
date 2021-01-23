/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicReference
 *  java.util.concurrent.locks.Condition
 *  java.util.concurrent.locks.ReentrantLock
 */
package f.h.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c {
    public final Object a = new Object();
    public HandlerThread b;
    public Handler c;
    public int d;
    public Handler.Callback e = new Handler.Callback(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean handleMessage(Message message) {
            Object object;
            int n2 = message.what;
            if (n2 != 0) {
                if (n2 != 1) {
                    return true;
                }
                c c2 = c.this;
                Runnable runnable = (Runnable)message.obj;
                if (c2 != null) {
                    Object object2;
                    runnable.run();
                    Object object3 = object2 = c2.a;
                    synchronized (object3) {
                        c2.c.removeMessages(0);
                        c2.c.sendMessageDelayed(c2.c.obtainMessage(0), (long)c2.f);
                        return true;
                    }
                }
                throw null;
            }
            c c3 = c.this;
            Object object4 = object = c3.a;
            synchronized (object4) {
                if (!c3.c.hasMessages(1)) {
                    c3.b.quit();
                    c3.b = null;
                    c3.c = null;
                }
                return true;
            }
        }
    };
    public final int f;
    public final int g;
    public final String h;

    public c(String string, int n2, int n3) {
        this.h = string;
        this.g = n2;
        this.f = n3;
        this.d = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Runnable runnable) {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            if (this.b == null) {
                HandlerThread handlerThread;
                this.b = handlerThread = new HandlerThread(this.h, this.g);
                handlerThread.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                this.d = 1 + this.d;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, (Object)runnable));
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public <T> T b(final Callable<T> var1_1, int var2_2) {
        block7 : {
            var3_3 = new ReentrantLock();
            var4_4 = var3_3.newCondition();
            var5_5 = new AtomicReference();
            var6_6 = new AtomicBoolean(true);
            var7_7 = new Runnable(this){

                public void run() {
                    try {
                        var5_5.set(var1_1.call());
                    }
                    catch (Exception exception) {}
                    var3_3.lock();
                    try {
                        var6_6.set(false);
                        var4_4.signal();
                        return;
                    }
                    finally {
                        var3_3.unlock();
                    }
                }
            };
            this.a(var7_7);
            var3_3.lock();
            if (var6_6.get()) break block7;
            var13_8 = var5_5.get();
            var3_3.unlock();
            return (T)var13_8;
        }
        try {
            var9_9 = TimeUnit.MILLISECONDS.toNanos((long)var2_2);
            do lbl-1000: // 2 sources:
            {
                try {
                    var9_9 = var4_4.awaitNanos(var9_9);
                }
                catch (InterruptedException v0) {}
                if (var6_6.get()) continue;
                var12_10 = var5_5.get();
                break;
            } while (true);
        }
        catch (Throwable var8_11) {
            var3_3.unlock();
            throw var8_11;
        }
        {
            var3_3.unlock();
            return (T)var12_10;
            ** while (var9_9 > 0L)
        }
lbl31: // 2 sources:
        throw new InterruptedException("timeout");
    }

    public static interface c<T> {
        public void a(T var1);
    }

}

