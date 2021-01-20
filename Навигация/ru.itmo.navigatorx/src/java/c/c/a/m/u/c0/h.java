/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.u.c0;

import c.c.a.m.u.c0.a;

public final class h
implements a<int[]> {
    @Override
    public String a() {
        return "IntegerArrayPool";
    }

    @Override
    public int b(Object object) {
        return ((int[])object).length;
    }

    @Override
    public int c() {
        return 4;
    }

    @Override
    public Object newArray(int n2) {
        return new int[n2];
    }
}

