/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.g
 *  h.k.h
 *  java.lang.Object
 */
package h.k;

import h.k.g;
import h.k.h;
import h.m.a.p;
import h.m.b.j;

public interface f {
    public <R> R fold(R var1, p<? super R, ? super a, ? extends R> var2);

    public <E extends a> E get(b<E> var1);

    public f minusKey(b<?> var1);

    public f plus(f var1);

    public static interface b<E extends a> {
    }

}

