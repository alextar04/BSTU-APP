/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.e.a
 *  java.lang.Object
 */
package c.c.a.s;

import f.e.a;
import f.e.h;

public final class b<K, V>
extends a<K, V> {
    public int m;

    public void clear() {
        this.m = 0;
        h.super.clear();
    }

    public int hashCode() {
        if (this.m == 0) {
            this.m = h.super.hashCode();
        }
        return this.m;
    }

    public void i(h<? extends K, ? extends V> h2) {
        this.m = 0;
        h.super.i(h2);
    }

    public V j(int n2) {
        this.m = 0;
        return h.super.j(n2);
    }

    public V k(int n2, V v2) {
        this.m = 0;
        int n3 = 1 + (n2 << 1);
        Object[] arrobject = ((h)this).f;
        Object object = arrobject[n3];
        arrobject[n3] = v2;
        return (V)object;
    }

    public V put(K k2, V v2) {
        this.m = 0;
        return h.super.put(k2, v2);
    }
}

