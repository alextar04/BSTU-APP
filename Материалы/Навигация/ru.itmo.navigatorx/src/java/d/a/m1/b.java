/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package d.a.m1;

import d.a.a.q;
import d.a.m1.c;
import d.a.m1.e;
import d.a.v;
import f.b.k.h;

public final class b
extends c {
    public static final v k;
    public static final b l;

    public static {
        b b2;
        l = b2 = new b();
        int n2 = q.a;
        int n3 = 64 < n2 ? n2 : 64;
        k = new e(b2, h.i.M1("kotlinx.coroutines.io.parallelism", n3, 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public b() {
        super(0, 0, null, 7);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override
    public String toString() {
        return "Dispatchers.Default";
    }
}

