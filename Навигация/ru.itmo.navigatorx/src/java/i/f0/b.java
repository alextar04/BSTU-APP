/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package i.f0;

import i.f0.c;

public abstract class b
implements Runnable {
    public final String e;

    public /* varargs */ b(String string, Object ... arrobject) {
        this.e = c.n(string, arrobject);
    }

    public abstract void a();

    public final void run() {
        String string = Thread.currentThread().getName();
        Thread.currentThread().setName(this.e);
        try {
            this.a();
            return;
        }
        finally {
            Thread.currentThread().setName(string);
        }
    }
}

