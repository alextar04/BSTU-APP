/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.w.g;

import c.c.a.l.a;
import c.c.a.m.u.c0.d;

public final class b
implements a.a {
    public final d a;
    public final c.c.a.m.u.c0.b b;

    public b(d d2, c.c.a.m.u.c0.b b2) {
        this.a = d2;
        this.b = b2;
    }

    public byte[] a(int n2) {
        c.c.a.m.u.c0.b b2 = this.b;
        if (b2 == null) {
            return new byte[n2];
        }
        return b2.g(n2, byte[].class);
    }
}

