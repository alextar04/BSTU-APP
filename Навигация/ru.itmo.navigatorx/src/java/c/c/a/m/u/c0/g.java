/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package c.c.a.m.u.c0;

import c.c.a.m.u.c0.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class g<K extends l, V> {
    public final a<K, V> a = new a(null);
    public final Map<K, a<K, V>> b = new HashMap();

    public V a(K k2) {
        a a2;
        a a3 = (a)this.b.get(k2);
        if (a3 == null) {
            a3 = new a(k2);
            this.b.put(k2, a3);
        } else {
            k2.a();
        }
        a a4 = a3.d;
        a4.c = a3.c;
        a3.c.d = a4;
        a<K, V> a5 = this.a;
        a3.d = a5;
        a3.c = a2 = a5.c;
        a2.d = a3;
        a3.d.c = a3;
        return a3.a();
    }

    public void b(K k2, V v2) {
        a a2 = (a)this.b.get(k2);
        if (a2 == null) {
            a2 = new a(k2);
            a a3 = a2.d;
            a3.c = a2.c;
            a2.c.d = a3;
            a<K, V> a4 = this.a;
            a2.d = a4.d;
            a2.c = a4;
            a4.d = a2;
            a2.d.c = a2;
            this.b.put(k2, a2);
        } else {
            k2.a();
        }
        if (a2.b == null) {
            a2.b = new ArrayList();
        }
        a2.b.add(v2);
    }

    public V c() {
        a<K, V> a2 = this.a;
        while (!(a2 = a2.d).equals(this.a)) {
            V v2 = a2.a();
            if (v2 != null) {
                return v2;
            }
            a a3 = a2.d;
            a3.c = a2.c;
            a2.c.d = a3;
            this.b.remove(a2.a);
            ((l)a2.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        a a2 = this.a.c;
        boolean bl = false;
        while (!a2.equals(this.a)) {
            bl = true;
            stringBuilder.append('{');
            stringBuilder.append(a2.a);
            stringBuilder.append(':');
            List list = a2.b;
            int n2 = list != null ? list.size() : 0;
            stringBuilder.append(n2);
            stringBuilder.append("}, ");
            a2 = a2.c;
        }
        if (bl) {
            stringBuilder.delete(-2 + stringBuilder.length(), stringBuilder.length());
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }

    public static class a<K, V> {
        public final K a;
        public List<V> b;
        public a<K, V> c = this;
        public a<K, V> d = this;

        public a() {
            this(null);
        }

        public a(K k2) {
            this.a = k2;
        }

        public V a() {
            List<V> list = this.b;
            int n2 = list != null ? list.size() : 0;
            if (n2 > 0) {
                return (V)this.b.remove(n2 - 1);
            }
            return null;
        }
    }

}

