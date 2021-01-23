/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.u.c0;

import c.c.a.m.u.c0.a;

public final class f
implements a<byte[]> {
    @Override
    public String a() {
        return "ByteArrayPool";
    }

    @Override
    public int b(Object object) {
        return ((byte[])object).length;
    }

    @Override
    public int c() {
        return 1;
    }

    @Override
    public Object newArray(int n2) {
        return new byte[n2];
    }
}

