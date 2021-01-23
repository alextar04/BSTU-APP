/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j.x$a
 *  java.io.InterruptedIOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 */
package j;

import j.x;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class x {
    public static final x d = new a();
    public boolean a;
    public long b;
    public long c;

    public x a() {
        this.a = false;
        return this;
    }

    public x b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public x d(long l2) {
        this.a = true;
        this.b = l2;
        return this;
    }

    public boolean e() {
        return this.a;
    }

    public void f() {
        if (!Thread.interrupted()) {
            if (this.a) {
                if (this.b - System.nanoTime() > 0L) {
                    return;
                }
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public x g(long l2, TimeUnit timeUnit) {
        if (l2 >= 0L) {
            if (timeUnit != null) {
                this.c = timeUnit.toNanos(l2);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException(c.b.a.a.a.f("timeout < 0: ", l2));
    }
}

