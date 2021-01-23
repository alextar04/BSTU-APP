/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d.a.m1;

import c.b.a.a.a;
import d.a.m1.h;
import d.a.m1.i;
import f.b.k.h;

public final class j
extends h {
    public final Runnable g;

    public j(Runnable runnable, long l2, i i2) {
        super(l2, i2);
        this.g = runnable;
    }

    public void run() {
        try {
            this.g.run();
            return;
        }
        finally {
            this.f.K();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Task[");
        stringBuilder.append(h.i.a0((Object)this.g));
        stringBuilder.append('@');
        stringBuilder.append(h.i.g0((Object)this.g));
        stringBuilder.append(", ");
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.f);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

