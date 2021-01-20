/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.b.c0.s$b$a
 *  c.e.b.c0.s$c$a
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.AbstractMap
 *  java.util.AbstractSet
 *  java.util.Comparator
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package c.e.b.c0;

import c.e.b.c0.s;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class s<K, V>
extends AbstractMap<K, V>
implements Serializable {
    public static final Comparator<Comparable> l = new Comparator<Comparable>(){

        public int compare(Object object, Object object2) {
            return ((Comparable)object).compareTo((Object)((Comparable)object2));
        }
    };
    public Comparator<? super K> e;
    public e<K, V> f;
    public int g;
    public int h;
    public final e<K, V> i;
    public s<K, V> j;
    public s<K, V> k;

    public s() {
        Comparator<Comparable> comparator = l;
        this.g = 0;
        this.h = 0;
        this.i = new e();
        this.e = comparator;
    }

    public e<K, V> a(K k2, boolean bl) {
        e<K, V> e2;
        int n2;
        Comparator<? super K> comparator = this.e;
        e<K, V> e3 = this.f;
        if (e3 != null) {
            Comparable comparable = comparator == l ? (Comparable)k2 : null;
            do {
                Object k3 = e3.j;
                n2 = comparable != null ? comparable.compareTo(k3) : comparator.compare(k2, k3);
                if (n2 == 0) {
                    return e3;
                }
                e e4 = n2 < 0 ? e3.f : e3.g;
                if (e4 != null) {
                    e3 = e4;
                    continue;
                }
                break;
            } while (true);
        } else {
            n2 = 0;
        }
        if (!bl) {
            return null;
        }
        e<K, V> e5 = this.i;
        if (e3 == null) {
            if (comparator == l && !(k2 instanceof Comparable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k2.getClass().getName());
                stringBuilder.append(" is not Comparable");
                throw new ClassCastException(stringBuilder.toString());
            }
            e2 = new e<K, V>(e3, k2, e5, e5.i);
            this.f = e2;
        } else {
            e2 = new e<K, V>(e3, k2, e5, e5.i);
            if (n2 < 0) {
                e3.f = e2;
            } else {
                e3.g = e2;
            }
            this.d(e3, true);
        }
        this.g = 1 + this.g;
        this.h = 1 + this.h;
        return e2;
    }

    public e<K, V> b(Map.Entry<?, ?> entry) {
        boolean bl;
        e<K, V> e2;
        block5 : {
            block4 : {
                e2 = this.c(entry.getKey());
                bl = true;
                if (e2 == null) break block4;
                Object v2 = e2.k;
                Object object = entry.getValue();
                boolean bl2 = !(v2 == object || v2 != null && v2.equals(object)) ? false : bl;
                if (bl2) break block5;
            }
            bl = false;
        }
        if (bl) {
            return e2;
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public e<K, V> c(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public void clear() {
        this.f = null;
        this.g = 0;
        this.h = 1 + this.h;
        e<K, V> e2 = this.i;
        e2.i = e2;
        e2.h = e2;
    }

    public boolean containsKey(Object object) {
        return this.c(object) != null;
    }

    public final void d(e<K, V> e2, boolean bl) {
        while (e2 != null) {
            int n2;
            e e3;
            e e4 = e2.f;
            int n3 = e4 != null ? e4.l : 0;
            int n4 = n3 - (n2 = (e3 = e2.g) != null ? e3.l : 0);
            if (n4 == -2) {
                int n5;
                e e5 = e3.f;
                e e6 = e3.g;
                int n6 = e6 != null ? e6.l : 0;
                int n7 = 0;
                if (e5 != null) {
                    n7 = e5.l;
                }
                if ((n5 = n7 - n6) != -1 && (n5 != 0 || bl)) {
                    this.h(e3);
                }
                this.g(e2);
                if (bl) {
                    return;
                }
            } else if (n4 == 2) {
                int n8;
                e e7 = e4.f;
                e e8 = e4.g;
                int n9 = e8 != null ? e8.l : 0;
                int n10 = 0;
                if (e7 != null) {
                    n10 = e7.l;
                }
                if ((n8 = n10 - n9) != 1 && (n8 != 0 || bl)) {
                    this.g(e4);
                }
                this.h(e2);
                if (bl) {
                    return;
                }
            } else if (n4 == 0) {
                e2.l = n3 + 1;
                if (bl) {
                    return;
                }
            } else {
                e2.l = 1 + Math.max((int)n3, (int)n2);
                if (!bl) {
                    return;
                }
            }
            e2 = e2.e;
        }
    }

    public void e(e<K, V> e2, boolean bl) {
        if (bl) {
            e e3 = e2.i;
            e3.h = e2.h;
            e2.h.i = e3;
        }
        e e4 = e2.f;
        e e5 = e2.g;
        e e6 = e2.e;
        if (e4 != null && e5 != null) {
            e e7;
            int n2;
            if (e4.l > e5.l) {
                do {
                    e e8 = e4.g;
                    e7 = e4;
                    e4 = e8;
                    if (e4 != null) {
                        continue;
                    }
                    break;
                } while (true);
            } else {
                e e9;
                e e10;
                do {
                    e10 = e5.f;
                    e9 = e5;
                } while ((e5 = e10) != null);
                e7 = e9;
            }
            this.e(e7, false);
            e e11 = e2.f;
            if (e11 != null) {
                n2 = e11.l;
                e7.f = e11;
                e11.e = e7;
                e2.f = null;
            } else {
                n2 = 0;
            }
            e e12 = e2.g;
            int n3 = 0;
            if (e12 != null) {
                n3 = e12.l;
                e7.g = e12;
                e12.e = e7;
                e2.g = null;
            }
            e7.l = 1 + Math.max((int)n2, (int)n3);
            this.f(e2, e7);
            return;
        }
        if (e4 != null) {
            this.f(e2, e4);
            e2.f = null;
        } else if (e5 != null) {
            this.f(e2, e5);
            e2.g = null;
        } else {
            this.f(e2, null);
        }
        this.d(e6, false);
        this.g = -1 + this.g;
        this.h = 1 + this.h;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        s<K, V> s2 = this.j;
        if (s2 != null) {
            return s2;
        }
        b b2 = new b();
        this.j = b2;
        return b2;
    }

    public final void f(e<K, V> e2, e<K, V> e3) {
        e e4 = e2.e;
        e2.e = null;
        if (e3 != null) {
            e3.e = e4;
        }
        if (e4 != null) {
            if (e4.f == e2) {
                e4.f = e3;
                return;
            }
            e4.g = e3;
            return;
        }
        this.f = e3;
    }

    public final void g(e<K, V> e2) {
        int n2;
        e e3 = e2.f;
        e e4 = e2.g;
        e e5 = e4.f;
        e e6 = e4.g;
        e2.g = e5;
        if (e5 != null) {
            e5.e = e2;
        }
        this.f(e2, e4);
        e4.f = e2;
        e2.e = e4;
        int n3 = e3 != null ? e3.l : 0;
        int n4 = e5 != null ? e5.l : 0;
        e2.l = n2 = 1 + Math.max((int)n3, (int)n4);
        int n5 = 0;
        if (e6 != null) {
            n5 = e6.l;
        }
        e4.l = 1 + Math.max((int)n2, (int)n5);
    }

    public V get(Object object) {
        e<K, V> e2 = this.c(object);
        if (e2 != null) {
            return e2.k;
        }
        return null;
    }

    public final void h(e<K, V> e2) {
        int n2;
        e e3 = e2.f;
        e e4 = e2.g;
        e e5 = e3.f;
        e e6 = e3.g;
        e2.f = e6;
        if (e6 != null) {
            e6.e = e2;
        }
        this.f(e2, e3);
        e3.g = e2;
        e2.e = e3;
        int n3 = e4 != null ? e4.l : 0;
        int n4 = e6 != null ? e6.l : 0;
        e2.l = n2 = 1 + Math.max((int)n3, (int)n4);
        int n5 = 0;
        if (e5 != null) {
            n5 = e5.l;
        }
        e3.l = 1 + Math.max((int)n2, (int)n5);
    }

    public Set<K> keySet() {
        s<K, V> s2 = this.k;
        if (s2 != null) {
            return s2;
        }
        c c2 = new c();
        this.k = c2;
        return c2;
    }

    public V put(K k2, V v2) {
        if (k2 != null) {
            e<K, V> e2 = this.a(k2, true);
            Object v3 = e2.k;
            e2.k = v2;
            return v3;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object object) {
        e<K, V> e2 = this.c(object);
        if (e2 != null) {
            this.e(e2, true);
        }
        if (e2 != null) {
            return e2.k;
        }
        return null;
    }

    public int size() {
        return this.g;
    }

    public class b
    extends AbstractSet<Map.Entry<K, V>> {
        public void clear() {
            s.this.clear();
        }

        public boolean contains(Object object) {
            return object instanceof Map.Entry && s.this.b((Map.Entry)object) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            e e2 = s.this.b((Map.Entry)object);
            if (e2 == null) {
                return false;
            }
            s.this.e(e2, true);
            return true;
        }

        public int size() {
            return s.this.g;
        }
    }

    public final class c
    extends AbstractSet<K> {
        public void clear() {
            s.this.clear();
        }

        public boolean contains(Object object) {
            return s.this.c(object) != null;
        }

        public Iterator<K> iterator() {
            return new a(this);
        }

        public boolean remove(Object object) {
            s s2 = s.this;
            e e2 = s2.c(object);
            if (e2 != null) {
                s2.e(e2, true);
            }
            return e2 != null;
        }

        public int size() {
            return s.this.g;
        }
    }

    public abstract class d<T>
    implements Iterator<T> {
        public e<K, V> e;
        public e<K, V> f;
        public int g;

        public d() {
            s s3 = s.this;
            this.e = s3.i.h;
            this.f = null;
            this.g = s3.h;
        }

        public final e<K, V> a() {
            e<K, V> e2 = this.e;
            s s2 = s.this;
            if (e2 != s2.i) {
                if (s2.h == this.g) {
                    this.e = e2.h;
                    this.f = e2;
                    return e2;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        public final boolean hasNext() {
            return this.e != s.this.i;
        }

        public final void remove() {
            e<K, V> e2 = this.f;
            if (e2 != null) {
                s.this.e(e2, true);
                this.f = null;
                this.g = s.this.h;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public static final class e<K, V>
    implements Map.Entry<K, V> {
        public e<K, V> e;
        public e<K, V> f;
        public e<K, V> g;
        public e<K, V> h;
        public e<K, V> i;
        public final K j;
        public V k;
        public int l;

        public e() {
            this.j = null;
            this.i = this;
            this.h = this;
        }

        public e(e<K, V> e2, K k2, e<K, V> e3, e<K, V> e4) {
            this.e = e2;
            this.j = k2;
            this.l = 1;
            this.h = e3;
            this.i = e4;
            e4.h = this;
            e3.i = this;
        }

        public boolean equals(Object object) {
            boolean bl;
            block2 : {
                block6 : {
                    Object object2;
                    V v2;
                    block5 : {
                        Map.Entry entry;
                        block4 : {
                            K k2;
                            block3 : {
                                boolean bl2 = object instanceof Map.Entry;
                                bl = false;
                                if (!bl2) break block2;
                                entry = (Map.Entry)object;
                                k2 = this.j;
                                if (k2 != null) break block3;
                                Object object3 = entry.getKey();
                                bl = false;
                                if (object3 != null) break block2;
                                break block4;
                            }
                            boolean bl3 = k2.equals(entry.getKey());
                            bl = false;
                            if (!bl3) break block2;
                        }
                        v2 = this.k;
                        object2 = entry.getValue();
                        if (v2 != null) break block5;
                        bl = false;
                        if (object2 != null) break block2;
                        break block6;
                    }
                    boolean bl4 = v2.equals(object2);
                    bl = false;
                    if (!bl4) break block2;
                }
                bl = true;
            }
            return bl;
        }

        public K getKey() {
            return this.j;
        }

        public V getValue() {
            return this.k;
        }

        public int hashCode() {
            K k2 = this.j;
            int n2 = k2 == null ? 0 : k2.hashCode();
            V v2 = this.k;
            int n3 = v2 == null ? 0 : v2.hashCode();
            return n2 ^ n3;
        }

        public V setValue(V v2) {
            V v3 = this.k;
            this.k = v2;
            return v3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.j);
            stringBuilder.append("=");
            stringBuilder.append(this.k);
            return stringBuilder.toString();
        }
    }

}

