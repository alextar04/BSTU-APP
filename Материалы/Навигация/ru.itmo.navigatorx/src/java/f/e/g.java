/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package f.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class g<K, V> {
    public g<K, V> a;
    public g<K, V> b;
    public g<K, V> c;

    /*
     * Exception decompiling
     */
    public static <T> boolean j(Set<T> var0, Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27.1 : ICONST_0 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public static <K, V> boolean k(Map<K, V> map, Collection<?> collection) {
        int n2 = map.size();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
        }
        return n2 != map.size();
    }

    public abstract void a();

    public abstract Object b(int var1, int var2);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object var1);

    public abstract int f(Object var1);

    public abstract void g(K var1, V var2);

    public abstract void h(int var1);

    public abstract V i(int var1, V var2);

    public Object[] l(int n2) {
        int n3 = this.d();
        Object[] arrobject = new Object[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            arrobject[i2] = this.b(i2, n2);
        }
        return arrobject;
    }

    public <T> T[] m(T[] arrobject, int n2) {
        int n3 = this.d();
        if (arrobject.length < n3) {
            arrobject = (Object[])Array.newInstance((Class)arrobject.getClass().getComponentType(), (int)n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            arrobject[i2] = this.b(i2, n2);
        }
        if (arrobject.length > n3) {
            arrobject[n3] = null;
        }
        return arrobject;
    }

    public final class a<T>
    implements Iterator<T> {
        public final int e;
        public int f;
        public int g;
        public boolean h = false;

        public a(int n2) {
            this.e = n2;
            this.f = g.this.d();
        }

        public boolean hasNext() {
            return this.g < this.f;
        }

        public T next() {
            if (this.hasNext()) {
                Object object = g.this.b(this.g, this.e);
                this.g = 1 + this.g;
                this.h = true;
                return (T)object;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.h) {
                int n2;
                this.g = n2 = -1 + this.g;
                this.f = -1 + this.f;
                this.h = false;
                g.this.h(n2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final class b
    implements Set<Map.Entry<K, V>> {
        public boolean add(Object object) {
            (Map.Entry)object;
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int n2 = g.this.d();
            for (Map.Entry entry : collection) {
                g.this.g(entry.getKey(), entry.getValue());
            }
            return n2 != g.this.d();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            int n2 = g.this.e(entry.getKey());
            if (n2 < 0) {
                return false;
            }
            return f.e.d.c(g.this.b(n2, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (this.contains(iterator.next())) continue;
                return false;
            }
            return true;
        }

        public boolean equals(Object object) {
            return g.j(this, object);
        }

        public int hashCode() {
            int n2 = 0;
            for (int i2 = g.this.d() - 1; i2 >= 0; --i2) {
                Object object = g.this.b(i2, 0);
                Object object2 = g.this.b(i2, 1);
                int n3 = object == null ? 0 : object.hashCode();
                int n4 = object2 == null ? 0 : object2.hashCode();
                n2 += n3 ^ n4;
            }
            return n2;
        }

        public boolean isEmpty() {
            return g.this.d() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return g.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] arrT) {
            throw new UnsupportedOperationException();
        }
    }

    public final class c
    implements Set<K> {
        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object object) {
            return g.this.e(object) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            Map map = g.this.c();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (map.containsKey(iterator.next())) continue;
                return false;
            }
            return true;
        }

        public boolean equals(Object object) {
            return g.j(this, object);
        }

        public int hashCode() {
            int n2 = 0;
            for (int i2 = -1 + g.this.d(); i2 >= 0; --i2) {
                Object object = g.this.b(i2, 0);
                int n3 = object == null ? 0 : object.hashCode();
                n2 += n3;
            }
            return n2;
        }

        public boolean isEmpty() {
            return g.this.d() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object object) {
            int n2 = g.this.e(object);
            if (n2 >= 0) {
                g.this.h(n2);
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            Map map = g.this.c();
            int n2 = map.size();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                map.remove(iterator.next());
            }
            return n2 != map.size();
        }

        public boolean retainAll(Collection<?> collection) {
            return g.k(g.this.c(), collection);
        }

        public int size() {
            return g.this.d();
        }

        public Object[] toArray() {
            return g.this.l(0);
        }

        public <T> T[] toArray(T[] arrT) {
            return g.this.m(arrT, 0);
        }
    }

    public final class d
    implements Iterator<Map.Entry<K, V>>,
    Map.Entry<K, V> {
        public int e;
        public int f;
        public boolean g = false;

        public d() {
            this.e = -1 + g.this.d();
            this.f = -1;
        }

        public boolean equals(Object object) {
            if (this.g) {
                if (!(object instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry)object;
                boolean bl = f.e.d.c(entry.getKey(), g.this.b(this.f, 0));
                boolean bl2 = false;
                if (bl) {
                    boolean bl3 = f.e.d.c(entry.getValue(), g.this.b(this.f, 1));
                    bl2 = false;
                    if (bl3) {
                        bl2 = true;
                    }
                }
                return bl2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public K getKey() {
            if (this.g) {
                return (K)g.this.b(this.f, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.g) {
                return (V)g.this.b(this.f, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f < this.e;
        }

        public int hashCode() {
            if (this.g) {
                Object object = g.this.b(this.f, 0);
                Object object2 = g.this.b(this.f, 1);
                int n2 = object == null ? 0 : object.hashCode();
                int n3 = object2 == null ? 0 : object2.hashCode();
                return n2 ^ n3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object next() {
            if (this.hasNext()) {
                this.f = 1 + this.f;
                this.g = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.g) {
                g.this.h(this.f);
                this.f = -1 + this.f;
                this.e = -1 + this.e;
                this.g = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v2) {
            if (this.g) {
                return g.this.i(this.f, v2);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getKey());
            stringBuilder.append("=");
            stringBuilder.append(this.getValue());
            return stringBuilder.toString();
        }
    }

    public final class e
    implements Collection<V> {
        public boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object object) {
            return g.this.f(object) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (this.contains(iterator.next())) continue;
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            return g.this.d() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object object) {
            int n2 = g.this.f(object);
            if (n2 >= 0) {
                g.this.h(n2);
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            int n2 = g.this.d();
            boolean bl = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!collection.contains(g.this.b(i2, 1))) continue;
                g.this.h(i2);
                --i2;
                --n2;
                bl = true;
            }
            return bl;
        }

        public boolean retainAll(Collection<?> collection) {
            int n2 = g.this.d();
            boolean bl = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (collection.contains(g.this.b(i2, 1))) continue;
                g.this.h(i2);
                --i2;
                --n2;
                bl = true;
            }
            return bl;
        }

        public int size() {
            return g.this.d();
        }

        public Object[] toArray() {
            return g.this.l(1);
        }

        public <T> T[] toArray(T[] arrT) {
            return g.this.m(arrT, 1);
        }
    }

}

