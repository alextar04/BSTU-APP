/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package c.c.a.s;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class e {
    public static final Executor a = new Executor(){
        public final Handler e = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.e.post(runnable);
        }
    };
    public static final Executor b = new Executor(){

        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

}

