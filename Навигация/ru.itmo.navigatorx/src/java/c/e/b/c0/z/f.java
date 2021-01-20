/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package c.e.b.c0.z;

import c.e.b.c0.s;
import c.e.b.c0.z.f;
import c.e.b.e0.c;
import c.e.b.l;
import c.e.b.o;
import c.e.b.q;
import c.e.b.r;
import c.e.b.t;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f
extends c {
    public static final Writer q = new Writer(){

        public void close() {
            throw new java.lang.AssertionError();
        }

        public void flush() {
            throw new java.lang.AssertionError();
        }

        public void write(char[] arrc, int n2, int n3) {
            throw new java.lang.AssertionError();
        }
    };
    public static final t r = new t("closed");
    public final List<o> n = new ArrayList();
    public String o;
    public o p = q.a;

    public f() {
        super(q);
    }

    @Override
    public c K(long l2) {
        this.R(new t(l2));
        return this;
    }

    @Override
    public c L(Boolean bl) {
        if (bl == null) {
            this.R(q.a);
            return this;
        }
        this.R(new t(bl));
        return this;
    }

    @Override
    public c M(Number number) {
        double d2;
        if (number == null) {
            this.R(q.a);
            return this;
        }
        if (!this.i && (Double.isNaN((double)(d2 = number.doubleValue())) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.R(new t(number));
        return this;
    }

    @Override
    public c N(String string) {
        if (string == null) {
            this.R(q.a);
            return this;
        }
        this.R(new t(string));
        return this;
    }

    @Override
    public c O(boolean bl) {
        this.R(new t(bl));
        return this;
    }

    public final o Q() {
        List<o> list = this.n;
        return (o)list.get(-1 + list.size());
    }

    public final void R(o o2) {
        if (this.o != null) {
            if (!(o2 instanceof q) || this.k) {
                r r2 = (r)this.Q();
                String string = this.o;
                r2.a.put(string, o2);
            }
            this.o = null;
            return;
        }
        if (this.n.isEmpty()) {
            this.p = o2;
            return;
        }
        o o3 = this.Q();
        if (o3 instanceof l) {
            ((l)o3).e.add((Object)o2);
            return;
        }
        throw new IllegalStateException();
    }

    @Override
    public void close() {
        if (this.n.isEmpty()) {
            this.n.add((Object)r);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override
    public c f() {
        l l2 = new l();
        this.R(l2);
        this.n.add((Object)l2);
        return this;
    }

    @Override
    public void flush() {
    }

    @Override
    public c h() {
        r r2 = new r();
        this.R(r2);
        this.n.add((Object)r2);
        return this;
    }

    @Override
    public c m() {
        if (!this.n.isEmpty() && this.o == null) {
            if (this.Q() instanceof l) {
                List<o> list = this.n;
                list.remove(-1 + list.size());
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override
    public c p() {
        if (!this.n.isEmpty() && this.o == null) {
            if (this.Q() instanceof r) {
                List<o> list = this.n;
                list.remove(-1 + list.size());
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override
    public c s(String string) {
        if (!this.n.isEmpty() && this.o == null) {
            if (this.Q() instanceof r) {
                this.o = string;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override
    public c u() {
        this.R(q.a);
        return this;
    }
}

