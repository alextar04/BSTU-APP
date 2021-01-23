/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.HashMap
 */
package f.c.a.b;

import f.c.a.b.b;
import java.util.HashMap;

public class a<K, V>
extends b<K, V> {
    public HashMap<K, b.c<K, V>> i = new HashMap();

    @Override
    public b.c<K, V> b(K k2) {
        return (b.c)this.i.get(k2);
    }

    public boolean contains(K k2) {
        return this.i.containsKey(k2);
    }

    @Override
    public V e(K k2, V v2) {
        b.c c2 = (b.c)this.i.get(k2);
        if (c2 != null) {
            return c2.f;
        }
        this.i.put(k2, this.d(k2, v2));
        return null;
    }

    @Override
    public V f(K k2) {
        Object v2 = super.f(k2);
        this.i.remove(k2);
        return v2;
    }
}

