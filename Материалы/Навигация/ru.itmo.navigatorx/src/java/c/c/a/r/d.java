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
package c.c.a.r;

import c.b.a.a.a;
import c.c.a.m.m;
import f.b.k.h;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public final class d
implements m {
    public final Object b;

    public d(Object object) {
        h.i.p(object, "Argument must not be null");
        this.b = object;
    }

    @Override
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(m.a));
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof d) {
            d d2 = (d)object;
            return this.b.equals(d2.b);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("ObjectKey{object=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

