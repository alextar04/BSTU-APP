/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package f.e;

import f.e.d;

public class e<E>
implements Cloneable {
    public static final Object i = new Object();
    public boolean e = false;
    public long[] f;
    public Object[] g;
    public int h;

    public e() {
        int n2 = d.f(10);
        this.f = new long[n2];
        this.g = new Object[n2];
    }

    public void a(long l2, E e2) {
        int n2;
        int n3 = this.h;
        if (n3 != 0 && l2 <= this.f[n3 - 1]) {
            this.g(l2, e2);
            return;
        }
        if (this.e && this.h >= this.f.length) {
            this.d();
        }
        if ((n2 = this.h) >= this.f.length) {
            int n4 = d.f(n2 + 1);
            long[] arrl = new long[n4];
            Object[] arrobject = new Object[n4];
            long[] arrl2 = this.f;
            System.arraycopy((Object)arrl2, (int)0, (Object)arrl, (int)0, (int)arrl2.length);
            Object[] arrobject2 = this.g;
            System.arraycopy((Object)arrobject2, (int)0, (Object)arrobject, (int)0, (int)arrobject2.length);
            this.f = arrl;
            this.g = arrobject;
        }
        this.f[n2] = l2;
        this.g[n2] = e2;
        this.h = n2 + 1;
    }

    public void b() {
        int n2 = this.h;
        Object[] arrobject = this.g;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrobject[i2] = null;
        }
        this.h = 0;
        this.e = false;
    }

    public e<E> c() {
        try {
            e e2 = (e)super.clone();
            e2.f = (long[])this.f.clone();
            e2.g = (Object[])this.g.clone();
            return e2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public final void d() {
        int n2 = this.h;
        long[] arrl = this.f;
        Object[] arrobject = this.g;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            if (object == i) continue;
            if (i2 != n3) {
                arrl[n3] = arrl[i2];
                arrobject[n3] = object;
                arrobject[i2] = null;
            }
            ++n3;
        }
        this.e = false;
        this.h = n3;
    }

    public E e(long l2) {
        return this.f(l2, null);
    }

    public E f(long l2, E e2) {
        int n2 = d.b(this.f, this.h, l2);
        if (n2 >= 0) {
            Object[] arrobject = this.g;
            if (arrobject[n2] == i) {
                return e2;
            }
            return (E)arrobject[n2];
        }
        return e2;
    }

    public void g(long l2, E e2) {
        int n2;
        int n3;
        Object[] arrobject;
        int n4 = d.b(this.f, this.h, l2);
        if (n4 >= 0) {
            this.g[n4] = e2;
            return;
        }
        int n5 = n4;
        if (n5 < this.h && (arrobject = this.g)[n5] == i) {
            this.f[n5] = l2;
            arrobject[n5] = e2;
            return;
        }
        if (this.e && this.h >= this.f.length) {
            this.d();
            n5 = d.b(this.f, this.h, l2);
        }
        if ((n2 = this.h) >= this.f.length) {
            int n6 = d.f(n2 + 1);
            long[] arrl = new long[n6];
            Object[] arrobject2 = new Object[n6];
            long[] arrl2 = this.f;
            System.arraycopy((Object)arrl2, (int)0, (Object)arrl, (int)0, (int)arrl2.length);
            Object[] arrobject3 = this.g;
            System.arraycopy((Object)arrobject3, (int)0, (Object)arrobject2, (int)0, (int)arrobject3.length);
            this.f = arrl;
            this.g = arrobject2;
        }
        if ((n3 = this.h) - n5 != 0) {
            long[] arrl = this.f;
            int n7 = n5 + 1;
            System.arraycopy((Object)arrl, (int)n5, (Object)arrl, (int)n7, (int)(n3 - n5));
            Object[] arrobject4 = this.g;
            System.arraycopy((Object)arrobject4, (int)n5, (Object)arrobject4, (int)n7, (int)(this.h - n5));
        }
        this.f[n5] = l2;
        this.g[n5] = e2;
        this.h = 1 + this.h;
    }

    public int h() {
        if (this.e) {
            this.d();
        }
        return this.h;
    }

    public E i(int n2) {
        if (this.e) {
            this.d();
        }
        return (E)this.g[n2];
    }

    public String toString() {
        if (this.h() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.h);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.h; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if (this.e) {
                this.d();
            }
            stringBuilder.append(this.f[i2]);
            stringBuilder.append('=');
            E e2 = this.i(i2);
            if (e2 != this) {
                stringBuilder.append(e2);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

