/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package c.c.a.s;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class g<T, Y> {
    public final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);
    public long b;
    public long c;

    public g(long l2) {
        this.b = l2;
    }

    public Y a(T t2) {
        g g2 = this;
        synchronized (g2) {
            Object object = this.a.get(t2);
            return (Y)object;
        }
    }

    public int b(Y y2) {
        return 1;
    }

    public void c(T t2, Y y2) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Y d(T t2, Y y2) {
        g g2 = this;
        synchronized (g2) {
            Object object;
            long l2 = this.b(y2);
            if (l2 >= this.b) {
                this.c(t2, y2);
                return null;
            }
            if (y2 != null) {
                this.c = l2 + this.c;
            }
            if ((object = this.a.put(t2, y2)) != null) {
                this.c -= (long)this.b(object);
                if (!object.equals(y2)) {
                    this.c(t2, object);
                }
            }
            this.e(this.b);
            return (Y)object;
        }
    }

    public void e(long l2) {
        g g2 = this;
        synchronized (g2) {
            while (this.c > l2) {
                Iterator iterator = this.a.entrySet().iterator();
                Map.Entry entry = (Map.Entry)iterator.next();
                Object object = entry.getValue();
                this.c -= (long)this.b(object);
                Object object2 = entry.getKey();
                iterator.remove();
                this.c(object2, object);
            }
            return;
        }
    }
}

