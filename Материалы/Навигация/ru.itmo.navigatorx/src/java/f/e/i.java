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

public class i<E>
implements Cloneable {
    public static final Object i = new Object();
    public boolean e = false;
    public int[] f;
    public Object[] g;
    public int h;

    public i() {
        this(10);
    }

    public i(int n2) {
        if (n2 == 0) {
            this.f = d.a;
            this.g = d.c;
            return;
        }
        int n3 = d.e(n2);
        this.f = new int[n3];
        this.g = new Object[n3];
    }

    public void a(int n2, E e2) {
        int n3;
        int n4 = this.h;
        if (n4 != 0 && n2 <= this.f[n4 - 1]) {
            this.g(n2, e2);
            return;
        }
        if (this.e && this.h >= this.f.length) {
            this.c();
        }
        if ((n3 = this.h) >= this.f.length) {
            int n5 = d.e(n3 + 1);
            int[] arrn = new int[n5];
            Object[] arrobject = new Object[n5];
            int[] arrn2 = this.f;
            System.arraycopy((Object)arrn2, (int)0, (Object)arrn, (int)0, (int)arrn2.length);
            Object[] arrobject2 = this.g;
            System.arraycopy((Object)arrobject2, (int)0, (Object)arrobject, (int)0, (int)arrobject2.length);
            this.f = arrn;
            this.g = arrobject;
        }
        this.f[n3] = n2;
        this.g[n3] = e2;
        this.h = n3 + 1;
    }

    public i<E> b() {
        try {
            i i2 = (i)super.clone();
            i2.f = (int[])this.f.clone();
            i2.g = (Object[])this.g.clone();
            return i2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public final void c() {
        int n2 = this.h;
        int[] arrn = this.f;
        Object[] arrobject = this.g;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            if (object == i) continue;
            if (i2 != n3) {
                arrn[n3] = arrn[i2];
                arrobject[n3] = object;
                arrobject[i2] = null;
            }
            ++n3;
        }
        this.e = false;
        this.h = n3;
    }

    public E d(int n2) {
        return this.e(n2, null);
    }

    public E e(int n2, E e2) {
        int n3 = d.a(this.f, this.h, n2);
        if (n3 >= 0) {
            Object[] arrobject = this.g;
            if (arrobject[n3] == i) {
                return e2;
            }
            return (E)arrobject[n3];
        }
        return e2;
    }

    public int f(int n2) {
        if (this.e) {
            this.c();
        }
        return this.f[n2];
    }

    public void g(int n2, E e2) {
        int n3;
        Object[] arrobject;
        int n4;
        int n5 = d.a(this.f, this.h, n2);
        if (n5 >= 0) {
            this.g[n5] = e2;
            return;
        }
        int n6 = n5;
        if (n6 < this.h && (arrobject = this.g)[n6] == i) {
            this.f[n6] = n2;
            arrobject[n6] = e2;
            return;
        }
        if (this.e && this.h >= this.f.length) {
            this.c();
            n6 = d.a(this.f, this.h, n2);
        }
        if ((n4 = this.h) >= this.f.length) {
            int n7 = d.e(n4 + 1);
            int[] arrn = new int[n7];
            Object[] arrobject2 = new Object[n7];
            int[] arrn2 = this.f;
            System.arraycopy((Object)arrn2, (int)0, (Object)arrn, (int)0, (int)arrn2.length);
            Object[] arrobject3 = this.g;
            System.arraycopy((Object)arrobject3, (int)0, (Object)arrobject2, (int)0, (int)arrobject3.length);
            this.f = arrn;
            this.g = arrobject2;
        }
        if ((n3 = this.h) - n6 != 0) {
            int[] arrn = this.f;
            int n8 = n6 + 1;
            System.arraycopy((Object)arrn, (int)n6, (Object)arrn, (int)n8, (int)(n3 - n6));
            Object[] arrobject4 = this.g;
            System.arraycopy((Object)arrobject4, (int)n6, (Object)arrobject4, (int)n8, (int)(this.h - n6));
        }
        this.f[n6] = n2;
        this.g[n6] = e2;
        this.h = 1 + this.h;
    }

    public void h(int n2) {
        Object object;
        Object object2;
        Object[] arrobject;
        int n3 = d.a(this.f, this.h, n2);
        if (n3 >= 0 && (object = (arrobject = this.g)[n3]) != (object2 = i)) {
            arrobject[n3] = object2;
            this.e = true;
        }
    }

    public int i() {
        if (this.e) {
            this.c();
        }
        return this.h;
    }

    public E j(int n2) {
        if (this.e) {
            this.c();
        }
        return (E)this.g[n2];
    }

    public String toString() {
        if (this.i() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.h);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.h; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.f(i2));
            stringBuilder.append('=');
            E e2 = this.j(i2);
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

