/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.f
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.RejectedExecutionException
 */
package d.a.m1;

import d.a.a0;
import d.a.l0;
import d.a.m1.a;
import d.a.m1.k;
import h.k.f;
import java.util.concurrent.RejectedExecutionException;

public class c
extends l0 {
    public a f;
    public final int g;
    public final int h;
    public final long i;
    public final String j;

    public c(int n2, int n3, String string, int n4) {
        a a2;
        if ((n4 & 1) != 0) {
            n2 = k.b;
        }
        if ((n4 & 2) != 0) {
            n3 = k.c;
        }
        String string2 = (n4 & 4) != 0 ? "DefaultDispatcher" : null;
        long l2 = k.d;
        this.g = n2;
        this.h = n3;
        this.i = l2;
        this.j = string2;
        this.f = a2 = new a(this.g, this.h, this.i, this.j);
    }

    @Override
    public void L(f f2, Runnable runnable) {
        try {
            a.m(this.f, runnable, null, false, 6);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            a0.l.V(runnable);
            return;
        }
    }
}

