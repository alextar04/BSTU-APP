/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.w.d;

import c.c.a.m.u.w;
import f.b.k.h;

public class b
implements w<byte[]> {
    public final byte[] e;

    public b(byte[] arrby) {
        h.i.p(arrby, "Argument must not be null");
        this.e = arrby;
    }

    @Override
    public Object b() {
        return this.e;
    }

    @Override
    public int c() {
        return this.e.length;
    }

    @Override
    public Class<byte[]> d() {
        return byte[].class;
    }

    @Override
    public void e() {
    }
}

