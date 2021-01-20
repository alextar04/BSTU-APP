/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package f.e;

import f.e.g;
import f.e.h;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V>
extends h<K, V>
implements Map<K, V> {
    public g<K, V> l;

    public a() {
    }

    public a(int n2) {
        super(n2);
    }

    public a(h h2) {
        if (h2 != null) {
            this.i(h2);
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V> g2 = this.m();
        if (g2.a == null) {
            g2.a = new g.b(g2);
        }
        return g2.a;
    }

    public Set<K> keySet() {
        g<K, V> g2 = this.m();
        if (g2.b == null) {
            g2.b = new g.c(g2);
        }
        return g2.b;
    }

    public final g<K, V> m() {
        if (this.l == null) {
            this.l = new g<K, V>(){

                @Override
                public void a() {
                    a.this.clear();
                }

                @Override
                public Object b(int n2, int n3) {
                    return a.this.f[n3 + (n2 << 1)];
                }

                @Override
                public Map<K, V> c() {
                    return a.this;
                }

                @Override
                public int d() {
                    return a.this.g;
                }

                @Override
                public int e(Object object) {
                    return a.this.e(object);
                }

                @Override
                public int f(Object object) {
                    return a.this.g(object);
                }

                @Override
                public void g(K k2, V v2) {
                    a.this.put(k2, v2);
                }

                @Override
                public void h(int n2) {
                    a.this.j(n2);
                }

                @Override
                public V i(int n2, V v2) {
                    return a.this.k(n2, v2);
                }
            };
        }
        return this.l;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        this.b(this.g + map.size());
        for (Map.Entry entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        g<K, V> g2 = this.m();
        if (g2.c == null) {
            g2.c = new g.e(g2);
        }
        return g2.c;
    }

}

