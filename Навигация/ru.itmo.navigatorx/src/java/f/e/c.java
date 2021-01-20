/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.e.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Array
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Set
 */
package f.e;

import f.e.b;
import f.e.d;
import f.e.g;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c<E>
implements Collection<E>,
Set<E> {
    public static final int[] i = new int[0];
    public static final Object[] j = new Object[0];
    public static Object[] k;
    public static int l;
    public static Object[] m;
    public static int n;
    public int[] e = i;
    public Object[] f = j;
    public int g = 0;
    public g<E, E> h;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(int[] arrn, Object[] arrobject, int n2) {
        if (arrn.length == 8) {
            Class<c> class_ = c.class;
            synchronized (c.class) {
                if (n < 10) {
                    arrobject[0] = m;
                    arrobject[1] = arrn;
                    for (int i2 = n2 - 1; i2 >= 2; --i2) {
                        arrobject[i2] = null;
                    }
                    m = arrobject;
                    n = 1 + n;
                }
                // ** MonitorExit[var7_3] (shouldn't be in output)
                return;
            }
        }
        if (arrn.length != 4) {
            return;
        }
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (l < 10) {
                arrobject[0] = k;
                arrobject[1] = arrn;
                for (int i3 = n2 - 1; i3 >= 2; --i3) {
                    arrobject[i3] = null;
                }
                k = arrobject;
                l = 1 + l;
            }
            // ** MonitorExit[var7_4] (shouldn't be in output)
            return;
        }
    }

    public boolean add(E e2) {
        int n2;
        int n3;
        int n4;
        if (e2 == null) {
            n4 = this.e();
            n2 = 0;
        } else {
            int n5 = e2.hashCode();
            int n6 = this.d(e2, n5);
            n2 = n5;
            n4 = n6;
        }
        if (n4 >= 0) {
            return false;
        }
        int n7 = n4;
        int n8 = this.g;
        if (n8 >= this.e.length) {
            int n9 = 4;
            if (n8 >= 8) {
                n9 = n8 + (n8 >> 1);
            } else if (n8 >= n9) {
                n9 = 8;
            }
            int[] arrn = this.e;
            Object[] arrobject = this.f;
            this.b(n9);
            int[] arrn2 = this.e;
            if (arrn2.length > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)arrn.length);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.f, (int)0, (int)arrobject.length);
            }
            c.c(arrn, arrobject, this.g);
        }
        if (n7 < (n3 = this.g)) {
            int[] arrn = this.e;
            int n10 = n7 + 1;
            System.arraycopy((Object)arrn, (int)n7, (Object)arrn, (int)n10, (int)(n3 - n7));
            Object[] arrobject = this.f;
            System.arraycopy((Object)arrobject, (int)n7, (Object)arrobject, (int)n10, (int)(this.g - n7));
        }
        this.e[n7] = n2;
        this.f[n7] = e2;
        this.g = 1 + this.g;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int n2 = this.g + collection.size();
        int[] arrn = this.e;
        int n3 = arrn.length;
        boolean bl = false;
        if (n3 < n2) {
            Object[] arrobject = this.f;
            this.b(n2);
            int n4 = this.g;
            if (n4 > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.e, (int)0, (int)n4);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.f, (int)0, (int)this.g);
            }
            c.c(arrn, arrobject, this.g);
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            bl |= this.add(iterator.next());
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void b(int n2) {
        if (n2 == 8) {
            Class<c> class_ = c.class;
            // MONITORENTER : f.e.c.class
            if (m != null) {
                Object[] arrobject = m;
                this.f = arrobject;
                m = (Object[])arrobject[0];
                this.e = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --n;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        } else if (n2 == 4) {
            Class<c> class_ = c.class;
            // MONITORENTER : f.e.c.class
            if (k != null) {
                Object[] arrobject = k;
                this.f = arrobject;
                k = (Object[])arrobject[0];
                this.e = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --l;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        }
        this.e = new int[n2];
        this.f = new Object[n2];
    }

    public void clear() {
        int n2 = this.g;
        if (n2 != 0) {
            c.c(this.e, this.f, n2);
            this.e = i;
            this.f = j;
            this.g = 0;
        }
    }

    public boolean contains(Object object) {
        return this.indexOf(object) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            return false;
        }
        return true;
    }

    public final int d(Object object, int n2) {
        int n3;
        int n4 = this.g;
        if (n4 == 0) {
            return -1;
        }
        int n5 = d.a(this.e, n4, n2);
        if (n5 < 0) {
            return n5;
        }
        if (object.equals(this.f[n5])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && this.e[n3] == n2; ++n3) {
            if (!object.equals(this.f[n3])) continue;
            return n3;
        }
        for (int i2 = n5 - 1; i2 >= 0 && this.e[i2] == n2; --i2) {
            if (!object.equals(this.f[i2])) continue;
            return i2;
        }
        return n3;
    }

    public final int e() {
        int n2;
        int n3 = this.g;
        if (n3 == 0) {
            return -1;
        }
        int n4 = d.a(this.e, n3, 0);
        if (n4 < 0) {
            return n4;
        }
        if (this.f[n4] == null) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.e[n2] == 0; ++n2) {
            if (this.f[n2] != null) continue;
            return n2;
        }
        for (int i2 = n4 - 1; i2 >= 0 && this.e[i2] == 0; --i2) {
            if (this.f[i2] != null) continue;
            return i2;
        }
        return n2;
    }

    /*
     * Exception decompiling
     */
    public boolean equals(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl40.1 : ICONST_0 : trying to set 0 previously set to 1
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

    public E f(int n2) {
        Object[] arrobject = this.f;
        Object object = arrobject[n2];
        int n3 = this.g;
        if (n3 <= 1) {
            c.c(this.e, arrobject, n3);
            this.e = i;
            this.f = j;
            this.g = 0;
            return (E)object;
        }
        int[] arrn = this.e;
        int n4 = arrn.length;
        int n5 = 8;
        if (n4 > n5 && n3 < arrn.length / 3) {
            int n6;
            if (n3 > n5) {
                n5 = n3 + (n3 >> 1);
            }
            int[] arrn2 = this.e;
            Object[] arrobject2 = this.f;
            this.b(n5);
            --this.g;
            if (n2 > 0) {
                System.arraycopy((Object)arrn2, (int)0, (Object)this.e, (int)0, (int)n2);
                System.arraycopy((Object)arrobject2, (int)0, (Object)this.f, (int)0, (int)n2);
            }
            if (n2 < (n6 = this.g)) {
                int n7 = n2 + 1;
                System.arraycopy((Object)arrn2, (int)n7, (Object)this.e, (int)n2, (int)(n6 - n2));
                System.arraycopy((Object)arrobject2, (int)n7, (Object)this.f, (int)n2, (int)(this.g - n2));
                return (E)object;
            }
        } else {
            int n8;
            this.g = n8 = this.g - 1;
            if (n2 < n8) {
                int[] arrn3 = this.e;
                int n9 = n2 + 1;
                System.arraycopy((Object)arrn3, (int)n9, (Object)arrn3, (int)n2, (int)(n8 - n2));
                Object[] arrobject3 = this.f;
                System.arraycopy((Object)arrobject3, (int)n9, (Object)arrobject3, (int)n2, (int)(this.g - n2));
            }
            this.f[this.g] = null;
        }
        return (E)object;
    }

    public int hashCode() {
        int[] arrn = this.e;
        int n2 = this.g;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += arrn[i2];
        }
        return n3;
    }

    public int indexOf(Object object) {
        if (object == null) {
            return this.e();
        }
        return this.d(object, object.hashCode());
    }

    public boolean isEmpty() {
        return this.g <= 0;
    }

    public Iterator<E> iterator() {
        if (this.h == null) {
            this.h = new b(this);
        }
        g<E, E> g2 = this.h;
        if (g2.b == null) {
            g2.b = new g.c(g2);
        }
        return ((g.c)((Object)g2.b)).iterator();
    }

    public boolean remove(Object object) {
        int n2 = this.indexOf(object);
        if (n2 >= 0) {
            this.f(n2);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        Iterator iterator = collection.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            bl |= this.remove(iterator.next());
        }
        return bl;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean bl = false;
        for (int i2 = this.g - 1; i2 >= 0; --i2) {
            if (collection.contains(this.f[i2])) continue;
            this.f(i2);
            bl = true;
        }
        return bl;
    }

    public int size() {
        return this.g;
    }

    public Object[] toArray() {
        int n2 = this.g;
        Object[] arrobject = new Object[n2];
        System.arraycopy((Object)this.f, (int)0, (Object)arrobject, (int)0, (int)n2);
        return arrobject;
    }

    public <T> T[] toArray(T[] arrobject) {
        if (arrobject.length < this.g) {
            arrobject = (Object[])Array.newInstance((Class)arrobject.getClass().getComponentType(), (int)this.g);
        }
        System.arraycopy((Object)this.f, (int)0, arrobject, (int)0, (int)this.g);
        int n2 = arrobject.length;
        int n3 = this.g;
        if (n2 > n3) {
            arrobject[n3] = null;
        }
        return arrobject;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(14 * this.g);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.g; ++i2) {
            Object object;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((object = this.f[i2]) != this) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append("(this Set)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

