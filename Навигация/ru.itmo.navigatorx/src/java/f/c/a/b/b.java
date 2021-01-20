/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  f.c.a.b.b$a
 *  f.c.a.b.b$d
 *  f.c.a.b.b$e
 *  java.lang.Boolean
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.WeakHashMap
 */
package f.c.a.b;

import f.c.a.b.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/*
 * Exception performing whole class analysis.
 */
public class b<K, V>
implements Iterable<Map.Entry<K, V>> {
    public c<K, V> e;
    public c<K, V> f;
    public WeakHashMap<f<K, V>, Boolean> g;
    public int h;

    public b() {
        this.g = new WeakHashMap();
        this.h = 0;
    }

    public c<K, V> b(K k2) {
        c<K, V> c2 = this.e;
        while (c2 != null) {
            if (c2.e.equals(k2)) {
                return c2;
            }
            c2 = c2.g;
        }
        return c2;
    }

    public b<K, V> c() {
        d d2 = new /* Unavailable Anonymous Inner Class!! */;
        this.g.put((Object)d2, (Object)Boolean.FALSE);
        return d2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public c<K, V> d(K k2, V v2) {
        c<K, V> c2 = new c<K, V>(k2, v2);
        this.h = 1 + this.h;
        c<K, V> c3 = this.f;
        if (c3 == null) {
            this.e = c2;
        } else {
            c3.g = c2;
            c2.h = c3;
        }
        this.f = c2;
        return c2;
    }

    public V e(K k2, V v2) {
        c<K, V> c2 = this.b(k2);
        if (c2 != null) {
            return c2.f;
        }
        this.d(k2, v2);
        return null;
    }

    public boolean equals(Object object) {
        e e2;
        e e3;
        if (object == this) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        if (this.h != b2.h) {
            return false;
        }
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        Iterator<Map.Entry<K, V>> iterator2 = b2.iterator();
        while ((e2 = iterator).hasNext() && (e3 = iterator2).hasNext()) {
            Map.Entry entry = (Map.Entry)e2.next();
            Object object2 = e3.next();
            if ((entry != null || object2 == null) && (entry == null || entry.equals(object2))) continue;
            return false;
        }
        return !e2.hasNext() && !(iterator2).hasNext();
    }

    public V f(K k2) {
        c c2;
        c<K, V> c3 = this.b(k2);
        if (c3 == null) {
            return null;
        }
        this.h = -1 + this.h;
        if (!this.g.isEmpty()) {
            Iterator iterator = this.g.keySet().iterator();
            while (iterator.hasNext()) {
                ((f)iterator.next()).a(c3);
            }
        }
        if ((c2 = c3.h) != null) {
            c2.g = c3.g;
        } else {
            this.e = c3.g;
        }
        c c4 = c3.g;
        if (c4 != null) {
            c4.h = c3.h;
        } else {
            this.f = c3.h;
        }
        c3.g = null;
        c3.h = null;
        return c3.f;
    }

    public int hashCode() {
        e e2;
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        int n2 = 0;
        while ((e2 = iterator).hasNext()) {
            n2 += ((Map.Entry)e2.next()).hashCode();
        }
        return n2;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        this.g.put((Object)a2, (Object)Boolean.FALSE);
        return a2;
    }

    public String toString() {
        e e2;
        StringBuilder stringBuilder = c.b.a.a.a.c((String)"[");
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        while ((e2 = iterator).hasNext()) {
            stringBuilder.append(((Map.Entry)e2.next()).toString());
            if (!e2.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class c<K, V>
    implements Map.Entry<K, V> {
        public final K e;
        public final V f;
        public c<K, V> g;
        public c<K, V> h;

        public c(K k2, V v2) {
            this.e = k2;
            this.f = v2;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof c)) {
                return false;
            }
            c c2 = (c)object;
            return this.e.equals(c2.e) && this.f.equals(c2.f);
        }

        public K getKey() {
            return this.e;
        }

        public V getValue() {
            return this.f;
        }

        public int hashCode() {
            return this.e.hashCode() ^ this.f.hashCode();
        }

        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e);
            stringBuilder.append("=");
            stringBuilder.append(this.f);
            return stringBuilder.toString();
        }
    }

    public static interface f<K, V> {
        public void a(c<K, V> var1);
    }

}

