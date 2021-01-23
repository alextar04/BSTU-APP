/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ConcurrentModificationException
 */
package f.e;

import f.e.d;
import java.util.ConcurrentModificationException;

public class h<K, V> {
    public static Object[] h;
    public static int i;
    public static Object[] j;
    public static int k;
    public int[] e;
    public Object[] f;
    public int g;

    public h() {
        this.e = d.a;
        this.f = d.c;
        this.g = 0;
    }

    public h(int n2) {
        if (n2 == 0) {
            this.e = d.a;
            this.f = d.c;
        } else {
            this.a(n2);
        }
        this.g = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(int[] arrn, Object[] arrobject, int n2) {
        if (arrn.length == 8) {
            Class<h> class_ = h.class;
            synchronized (h.class) {
                if (k < 10) {
                    arrobject[0] = j;
                    arrobject[1] = arrn;
                    for (int i2 = (n2 << 1) - 1; i2 >= 2; --i2) {
                        arrobject[i2] = null;
                    }
                    j = arrobject;
                    k = 1 + k;
                }
                // ** MonitorExit[var7_3] (shouldn't be in output)
                return;
            }
        }
        if (arrn.length != 4) {
            return;
        }
        Class<h> class_ = h.class;
        synchronized (h.class) {
            if (i < 10) {
                arrobject[0] = h;
                arrobject[1] = arrn;
                for (int i3 = (n2 << 1) - 1; i3 >= 2; --i3) {
                    arrobject[i3] = null;
                }
                h = arrobject;
                i = 1 + i;
            }
            // ** MonitorExit[var7_4] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a(int n2) {
        if (n2 == 8) {
            Class<h> class_ = h.class;
            // MONITORENTER : f.e.h.class
            if (j != null) {
                Object[] arrobject = j;
                this.f = arrobject;
                j = (Object[])arrobject[0];
                this.e = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --k;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        } else if (n2 == 4) {
            Class<h> class_ = h.class;
            // MONITORENTER : f.e.h.class
            if (h != null) {
                Object[] arrobject = h;
                this.f = arrobject;
                h = (Object[])arrobject[0];
                this.e = (int[])arrobject[1];
                arrobject[1] = null;
                arrobject[0] = null;
                --i;
                // MONITOREXIT : class_
                return;
            }
            // MONITOREXIT : class_
        }
        this.e = new int[n2];
        this.f = new Object[n2 << 1];
    }

    public void b(int n2) {
        int n3 = this.g;
        int[] arrn = this.e;
        if (arrn.length < n2) {
            Object[] arrobject = this.f;
            this.a(n2);
            if (this.g > 0) {
                System.arraycopy((Object)arrn, (int)0, (Object)this.e, (int)0, (int)n3);
                System.arraycopy((Object)arrobject, (int)0, (Object)this.f, (int)0, (int)(n3 << 1));
            }
            h.c(arrn, arrobject, n3);
        }
        if (this.g == n3) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        int n2 = this.g;
        if (n2 > 0) {
            int[] arrn = this.e;
            Object[] arrobject = this.f;
            this.e = d.a;
            this.f = d.c;
            this.g = 0;
            h.c(arrn, arrobject, n2);
        }
        if (this.g <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object object) {
        return this.e(object) >= 0;
    }

    public boolean containsValue(Object object) {
        return this.g(object) >= 0;
    }

    public int d(Object object, int n2) {
        int n3;
        int n4;
        int n5;
        block6 : {
            n5 = this.g;
            if (n5 == 0) {
                return -1;
            }
            int[] arrn = this.e;
            try {
                n3 = d.a(arrn, n5, n2);
                if (n3 >= 0) break block6;
                return n3;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw new ConcurrentModificationException();
            }
        }
        if (object.equals(this.f[n3 << 1])) {
            return n3;
        }
        for (n4 = n3 + 1; n4 < n5 && this.e[n4] == n2; ++n4) {
            if (!object.equals(this.f[n4 << 1])) continue;
            return n4;
        }
        for (int i2 = n3 - 1; i2 >= 0 && this.e[i2] == n2; --i2) {
            if (!object.equals(this.f[i2 << 1])) continue;
            return i2;
        }
        return n4;
    }

    public int e(Object object) {
        if (object == null) {
            return this.f();
        }
        return this.d(object, object.hashCode());
    }

    /*
     * Exception decompiling
     */
    public boolean equals(Object var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl114.1 : ICONST_0 : trying to set 0 previously set to 1
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

    public int f() {
        int n2;
        int n3;
        int n4;
        block6 : {
            n2 = this.g;
            if (n2 == 0) {
                return -1;
            }
            int[] arrn = this.e;
            try {
                n4 = d.a(arrn, n2, 0);
                if (n4 >= 0) break block6;
                return n4;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw new ConcurrentModificationException();
            }
        }
        if (this.f[n4 << 1] == null) {
            return n4;
        }
        for (n3 = n4 + 1; n3 < n2 && this.e[n3] == 0; ++n3) {
            if (this.f[n3 << 1] != null) continue;
            return n3;
        }
        for (int i2 = n4 - 1; i2 >= 0 && this.e[i2] == 0; --i2) {
            if (this.f[i2 << 1] != null) continue;
            return i2;
        }
        return n3;
    }

    public int g(Object object) {
        int n2 = 2 * this.g;
        Object[] arrobject = this.f;
        if (object == null) {
            for (int i2 = 1; i2 < n2; i2 += 2) {
                if (arrobject[i2] != null) continue;
                return i2 >> 1;
            }
        } else {
            for (int i3 = 1; i3 < n2; i3 += 2) {
                if (!object.equals(arrobject[i3])) continue;
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V get(Object object) {
        return this.getOrDefault(object, null);
    }

    public V getOrDefault(Object object, V object2) {
        int n2 = this.e(object);
        if (n2 >= 0) {
            object2 = this.f[1 + (n2 << 1)];
        }
        return object2;
    }

    public K h(int n2) {
        return (K)this.f[n2 << 1];
    }

    public int hashCode() {
        int[] arrn = this.e;
        Object[] arrobject = this.f;
        int n2 = this.g;
        int n3 = 1;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            Object object = arrobject[n3];
            int n6 = arrn[n4];
            int n7 = object == null ? 0 : object.hashCode();
            n5 += n7 ^ n6;
            ++n4;
            n3 += 2;
        }
        return n5;
    }

    public void i(h<? extends K, ? extends V> h2) {
        int n2 = h2.g;
        this.b(n2 + this.g);
        int n3 = this.g;
        if (n3 == 0) {
            if (n2 > 0) {
                System.arraycopy((Object)h2.e, (int)0, (Object)this.e, (int)0, (int)n2);
                System.arraycopy((Object)h2.f, (int)0, (Object)this.f, (int)0, (int)(n2 << 1));
                this.g = n2;
                return;
            }
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.put(h2.h(i2), h2.l(i2));
            }
        }
    }

    public boolean isEmpty() {
        return this.g <= 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public V j(int n2) {
        int n3;
        Object[] arrobject = this.f;
        int n4 = n2 << 1;
        Object object = arrobject[n4 + 1];
        int n5 = this.g;
        if (n5 <= 1) {
            h.c(this.e, arrobject, n5);
            this.e = d.a;
            this.f = d.c;
            n3 = 0;
        } else {
            int n6 = n5 - 1;
            int[] arrn = this.e;
            int n7 = arrn.length;
            int n8 = 8;
            if (n7 > n8 && n5 < arrn.length / 3) {
                if (n5 > n8) {
                    n8 = n5 + (n5 >> 1);
                }
                int[] arrn2 = this.e;
                Object[] arrobject2 = this.f;
                this.a(n8);
                if (n5 != this.g) throw new ConcurrentModificationException();
                if (n2 > 0) {
                    System.arraycopy((Object)arrn2, (int)0, (Object)this.e, (int)0, (int)n2);
                    System.arraycopy((Object)arrobject2, (int)0, (Object)this.f, (int)0, (int)n4);
                }
                if (n2 < n6) {
                    int n9 = n2 + 1;
                    int[] arrn3 = this.e;
                    int n10 = n6 - n2;
                    System.arraycopy((Object)arrn2, (int)n9, (Object)arrn3, (int)n2, (int)n10);
                    System.arraycopy((Object)arrobject2, (int)(n9 << 1), (Object)this.f, (int)n4, (int)(n10 << 1));
                }
            } else {
                if (n2 < n6) {
                    int[] arrn4 = this.e;
                    int n11 = n2 + 1;
                    int n12 = n6 - n2;
                    System.arraycopy((Object)arrn4, (int)n11, (Object)arrn4, (int)n2, (int)n12);
                    Object[] arrobject3 = this.f;
                    System.arraycopy((Object)arrobject3, (int)(n11 << 1), (Object)arrobject3, (int)n4, (int)(n12 << 1));
                }
                Object[] arrobject4 = this.f;
                int n13 = n6 << 1;
                arrobject4[n13] = null;
                arrobject4[n13 + 1] = null;
            }
            n3 = n6;
        }
        if (n5 != this.g) throw new ConcurrentModificationException();
        this.g = n3;
        return (V)object;
    }

    public V k(int n2, V v2) {
        int n3 = 1 + (n2 << 1);
        Object[] arrobject = this.f;
        Object object = arrobject[n3];
        arrobject[n3] = v2;
        return (V)object;
    }

    public V l(int n2) {
        return (V)this.f[1 + (n2 << 1)];
    }

    public V put(K k2, V v2) {
        int n2;
        int n3;
        int n4;
        int[] arrn;
        int n5 = this.g;
        if (k2 == null) {
            n4 = this.f();
            n2 = 0;
        } else {
            int n6 = k2.hashCode();
            int n7 = this.d(k2, n6);
            n2 = n6;
            n4 = n7;
        }
        if (n4 >= 0) {
            int n8 = 1 + (n4 << 1);
            Object[] arrobject = this.f;
            Object object = arrobject[n8];
            arrobject[n8] = v2;
            return (V)object;
        }
        int n9 = n4;
        if (n5 >= this.e.length) {
            int n10 = 4;
            if (n5 >= 8) {
                n10 = n5 + (n5 >> 1);
            } else if (n5 >= n10) {
                n10 = 8;
            }
            int[] arrn2 = this.e;
            Object[] arrobject = this.f;
            this.a(n10);
            if (n5 == this.g) {
                int[] arrn3 = this.e;
                if (arrn3.length > 0) {
                    System.arraycopy((Object)arrn2, (int)0, (Object)arrn3, (int)0, (int)arrn2.length);
                    System.arraycopy((Object)arrobject, (int)0, (Object)this.f, (int)0, (int)arrobject.length);
                }
                h.c(arrn2, arrobject, n5);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (n9 < n5) {
            int[] arrn4 = this.e;
            int n11 = n9 + 1;
            System.arraycopy((Object)arrn4, (int)n9, (Object)arrn4, (int)n11, (int)(n5 - n9));
            Object[] arrobject = this.f;
            System.arraycopy((Object)arrobject, (int)(n9 << 1), (Object)arrobject, (int)(n11 << 1), (int)(this.g - n9 << 1));
        }
        if (n5 == (n3 = this.g) && n9 < (arrn = this.e).length) {
            arrn[n9] = n2;
            Object[] arrobject = this.f;
            int n12 = n9 << 1;
            arrobject[n12] = k2;
            arrobject[n12 + 1] = v2;
            this.g = n3 + 1;
            return null;
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v2) {
        V v3 = this.getOrDefault(k2, null);
        if (v3 == null) {
            v3 = this.put(k2, v2);
        }
        return v3;
    }

    public V remove(Object object) {
        int n2 = this.e(object);
        if (n2 >= 0) {
            return this.j(n2);
        }
        return null;
    }

    public boolean remove(Object object, Object object2) {
        V v2;
        int n2 = this.e(object);
        if (n2 >= 0 && (object2 == (v2 = this.l(n2)) || object2 != null && object2.equals(v2))) {
            this.j(n2);
            return true;
        }
        return false;
    }

    public V replace(K k2, V v2) {
        int n2 = this.e(k2);
        if (n2 >= 0) {
            return this.k(n2, v2);
        }
        return null;
    }

    public boolean replace(K k2, V v2, V v3) {
        V v4;
        int n2 = this.e(k2);
        if (n2 >= 0 && ((v4 = this.l(n2)) == v2 || v2 != null && v2.equals(v4))) {
            this.k(n2, v3);
            return true;
        }
        return false;
    }

    public int size() {
        return this.g;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.g);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.g; ++i2) {
            K k2;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((k2 = this.h(i2)) != this) {
                stringBuilder.append(k2);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            V v2 = this.l(i2);
            if (v2 != this) {
                stringBuilder.append(v2);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

