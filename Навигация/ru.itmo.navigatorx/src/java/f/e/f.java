/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package f.e;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class f<K, V> {
    public final LinkedHashMap<K, V> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public f(int n2) {
        if (n2 > 0) {
            this.c = n2;
            this.a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final V a(K k2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        f f2 = this;
        synchronized (f2) {
            Object object = this.a.get(k2);
            if (object != null) {
                this.f = 1 + this.f;
                return (V)object;
            }
            this.g = 1 + this.g;
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final V b(K k2, V v2) {
        if (k2 != null && v2 != null) {
            Object object;
            f f2 = this;
            synchronized (f2) {
                this.d = 1 + this.d;
                this.b = 1 + this.b;
                object = this.a.put(k2, v2);
                if (object != null) {
                    this.b = -1 + this.b;
                }
            }
            this.c(this.c);
            return (V)object;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(int n2) {
        do {
            f f2 = this;
            synchronized (f2) {
                if (this.b < 0 || this.a.isEmpty() && this.b != 0) break block3;
                if (this.b <= n2 || this.a.isEmpty()) break;
                Map.Entry entry = (Map.Entry)this.a.entrySet().iterator().next();
                Object object = entry.getKey();
                entry.getValue();
                this.a.remove(object);
                this.b = -1 + this.b;
                this.e = 1 + this.e;
            }
        } while (true);
        {
            block3 : {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getName());
            stringBuilder.append(".sizeOf() is reporting inconsistent results!");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String toString() {
        f f2 = this;
        synchronized (f2) {
            int n2 = this.f + this.g;
            int n3 = n2 != 0 ? 100 * this.f / n2 : 0;
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.c, this.f, this.g, n3};
            return String.format((Locale)locale, (String)"LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", (Object[])arrobject);
        }
    }
}

