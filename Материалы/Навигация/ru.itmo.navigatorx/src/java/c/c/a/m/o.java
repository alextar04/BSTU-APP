/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 */
package c.c.a.m;

import c.b.a.a.a;
import c.c.a.m.m;
import c.c.a.m.n;
import c.c.a.s.b;
import f.e.h;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public final class o
implements m {
    public final f.e.a<n<?>, Object> b = new b();

    @Override
    public void a(MessageDigest messageDigest) {
        int n2 = 0;
        do {
            f.e.a<n<?>, Object> a2 = this.b;
            if (n2 >= a2.g) break;
            n n3 = (n)a2.h(n2);
            Object v2 = this.b.l(n2);
            n.b b2 = n3.b;
            if (n3.d == null) {
                n3.d = n3.c.getBytes(m.a);
            }
            b2.a(n3.d, v2, messageDigest);
            ++n2;
        } while (true);
    }

    public <T> T c(n<T> n2) {
        boolean bl = this.b.e(n2) >= 0;
        if (bl) {
            return this.b.getOrDefault(n2, null);
        }
        return n2.a;
    }

    public void d(o o2) {
        this.b.i(o2.b);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof o) {
            o o2 = (o)object;
            return this.b.equals(o2.b);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Options{values=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

