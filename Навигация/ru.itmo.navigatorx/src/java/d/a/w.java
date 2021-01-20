/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a
 *  f.b.k.h
 *  h.k.f
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.util.List
 *  kotlinx.coroutines.CoroutineExceptionHandler
 */
package d.a;

import f.b.k.h;
import h.k.f;
import java.util.List;
import kotlinx.coroutines.CoroutineExceptionHandler;

public final class w {
    public static final List<CoroutineExceptionHandler> a = h.i.R1(h.i.e(a.a()));

    public static final void a(f f2, Throwable throwable) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : a) {
            try {
                coroutineExceptionHandler.handleException(f2, throwable);
            }
            catch (Throwable throwable2) {
                Throwable throwable3;
                Thread thread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
                if (throwable == throwable2) {
                    throwable3 = throwable;
                } else {
                    throwable3 = new RuntimeException("Exception while trying to handle coroutine exception", throwable2);
                    h.i.a(throwable3, throwable);
                }
                uncaughtExceptionHandler.uncaughtException(thread, throwable3);
            }
        }
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, throwable);
    }
}

