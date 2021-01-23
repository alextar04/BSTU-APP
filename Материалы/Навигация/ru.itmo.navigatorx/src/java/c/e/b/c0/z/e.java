/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package c.e.b.c0.z;

import c.e.b.c0.s;
import c.e.b.c0.z.e;
import c.e.b.e0.b;
import c.e.b.l;
import c.e.b.o;
import c.e.b.q;
import c.e.b.r;
import c.e.b.t;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
extends c.e.b.e0.a {
    public static final Object y;
    public Object[] u;
    public int v;
    public String[] w;
    public int[] x;

    public static {
        new Reader(){

            public void close() {
                throw new AssertionError();
            }

            public int read(char[] arrc, int n2, int n3) {
                throw new AssertionError();
            }
        };
        y = new Object();
    }

    @Override
    private String B() {
        StringBuilder stringBuilder = c.b.a.a.a.c(" at path ");
        stringBuilder.append(this.u());
        return stringBuilder.toString();
    }

    @Override
    public boolean J() {
        this.a0(b.l);
        boolean bl = ((t)this.c0()).c();
        int n2 = this.v;
        if (n2 > 0) {
            int[] arrn = this.x;
            int n3 = n2 - 1;
            arrn[n3] = 1 + arrn[n3];
        }
        return bl;
    }

    @Override
    public double K() {
        b b2 = b.k;
        b b3 = this.T();
        if (b3 != b2 && b3 != b.j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b3);
            stringBuilder.append(this.B());
            throw new IllegalStateException(stringBuilder.toString());
        }
        t t2 = (t)this.b0();
        double d2 = t2.a instanceof Number ? t2.d().doubleValue() : Double.parseDouble((String)t2.e());
        if (!this.f && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d2);
            throw new NumberFormatException(stringBuilder.toString());
        }
        this.c0();
        int n2 = this.v;
        if (n2 > 0) {
            int[] arrn = this.x;
            int n3 = n2 - 1;
            arrn[n3] = 1 + arrn[n3];
        }
        return d2;
    }

    @Override
    public int L() {
        b b2 = b.k;
        b b3 = this.T();
        if (b3 != b2 && b3 != b.j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b3);
            stringBuilder.append(this.B());
            throw new IllegalStateException(stringBuilder.toString());
        }
        t t2 = (t)this.b0();
        int n2 = t2.a instanceof Number ? t2.d().intValue() : Integer.parseInt((String)t2.e());
        this.c0();
        int n3 = this.v;
        if (n3 > 0) {
            int[] arrn = this.x;
            int n4 = n3 - 1;
            arrn[n4] = 1 + arrn[n4];
        }
        return n2;
    }

    @Override
    public long M() {
        b b2 = b.k;
        b b3 = this.T();
        if (b3 != b2 && b3 != b.j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b3);
            stringBuilder.append(this.B());
            throw new IllegalStateException(stringBuilder.toString());
        }
        t t2 = (t)this.b0();
        long l2 = t2.a instanceof Number ? t2.d().longValue() : Long.parseLong((String)t2.e());
        this.c0();
        int n2 = this.v;
        if (n2 > 0) {
            int[] arrn = this.x;
            int n3 = n2 - 1;
            arrn[n3] = 1 + arrn[n3];
        }
        return l2;
    }

    @Override
    public String N() {
        String string;
        this.a0(b.i);
        Map.Entry entry = (Map.Entry)((Iterator)this.b0()).next();
        this.w[-1 + this.v] = string = (String)entry.getKey();
        this.d0(entry.getValue());
        return string;
    }

    @Override
    public void P() {
        this.a0(b.m);
        this.c0();
        int n2 = this.v;
        if (n2 > 0) {
            int[] arrn = this.x;
            int n3 = n2 - 1;
            arrn[n3] = 1 + arrn[n3];
        }
    }

    @Override
    public String R() {
        b b2 = b.j;
        b b3 = this.T();
        if (b3 != b2 && b3 != b.k) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)b2);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)b3);
            stringBuilder.append(this.B());
            throw new IllegalStateException(stringBuilder.toString());
        }
        String string = ((t)this.c0()).e();
        int n2 = this.v;
        if (n2 > 0) {
            int[] arrn = this.x;
            int n3 = n2 - 1;
            arrn[n3] = 1 + arrn[n3];
        }
        return string;
    }

    @Override
    public b T() {
        if (this.v == 0) {
            return b.n;
        }
        Object object = this.b0();
        if (object instanceof Iterator) {
            boolean bl = this.u[-2 + this.v] instanceof r;
            Iterator iterator = (Iterator)object;
            if (iterator.hasNext()) {
                if (bl) {
                    return b.i;
                }
                this.d0(iterator.next());
                return this.T();
            }
            if (bl) {
                return b.h;
            }
            return b.f;
        }
        if (object instanceof r) {
            return b.g;
        }
        if (object instanceof l) {
            return b.e;
        }
        if (object instanceof t) {
            Object object2 = ((t)object).a;
            if (object2 instanceof String) {
                return b.j;
            }
            if (object2 instanceof Boolean) {
                return b.l;
            }
            if (object2 instanceof Number) {
                return b.k;
            }
            throw new AssertionError();
        }
        if (object instanceof q) {
            return b.m;
        }
        if (object == y) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    @Override
    public void Y() {
        if (this.T() == b.i) {
            this.N();
            this.w[-2 + this.v] = "null";
        } else {
            this.c0();
            int n2 = this.v;
            if (n2 > 0) {
                this.w[n2 - 1] = "null";
            }
        }
        int n3 = this.v;
        if (n3 > 0) {
            int[] arrn = this.x;
            int n4 = n3 - 1;
            arrn[n4] = 1 + arrn[n4];
        }
    }

    public final void a0(b b2) {
        if (this.T() == b2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ");
        stringBuilder.append((Object)b2);
        stringBuilder.append(" but was ");
        stringBuilder.append((Object)this.T());
        stringBuilder.append(this.B());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final Object b0() {
        return this.u[-1 + this.v];
    }

    @Override
    public void c() {
        this.a0(b.e);
        this.d0(((l)this.b0()).iterator());
        this.x[-1 + this.v] = 0;
    }

    public final Object c0() {
        int n2;
        Object[] arrobject = this.u;
        this.v = n2 = -1 + this.v;
        Object object = arrobject[n2];
        arrobject[n2] = null;
        return object;
    }

    @Override
    public void close() {
        Object[] arrobject = new Object[]{y};
        this.u = arrobject;
        this.v = 1;
    }

    public final void d0(Object object) {
        int n2 = this.v;
        Object[] arrobject = this.u;
        if (n2 == arrobject.length) {
            int n3 = n2 * 2;
            this.u = Arrays.copyOf((Object[])arrobject, (int)n3);
            this.x = Arrays.copyOf((int[])this.x, (int)n3);
            this.w = (String[])Arrays.copyOf((Object[])this.w, (int)n3);
        }
        Object[] arrobject2 = this.u;
        int n4 = this.v;
        this.v = n4 + 1;
        arrobject2[n4] = object;
    }

    @Override
    public void f() {
        this.a0(b.g);
        this.d0((Object)((r)this.b0()).a.entrySet().iterator());
    }

    @Override
    public void m() {
        this.a0(b.f);
        this.c0();
        this.c0();
        int n2 = this.v;
        if (n2 > 0) {
            int[] arrn = this.x;
            int n3 = n2 - 1;
            arrn[n3] = 1 + arrn[n3];
        }
    }

    @Override
    public void p() {
        this.a0(b.h);
        this.c0();
        this.c0();
        int n2 = this.v;
        if (n2 > 0) {
            int[] arrn = this.x;
            int n3 = n2 - 1;
            arrn[n3] = 1 + arrn[n3];
        }
    }

    @Override
    public String toString() {
        return e.class.getSimpleName();
    }

    @Override
    public String u() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        for (int i2 = 0; i2 < this.v; ++i2) {
            Object[] arrobject = this.u;
            if (arrobject[i2] instanceof l) {
                if (!(arrobject[++i2] instanceof Iterator)) continue;
                stringBuilder.append('[');
                stringBuilder.append(this.x[i2]);
                stringBuilder.append(']');
                continue;
            }
            if (!(arrobject[i2] instanceof r) || !(arrobject[++i2] instanceof Iterator)) continue;
            stringBuilder.append('.');
            String[] arrstring = this.w;
            if (arrstring[i2] == null) continue;
            stringBuilder.append(arrstring[i2]);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean v() {
        b b2 = this.T();
        return b2 != b.h && b2 != b.f;
    }
}

