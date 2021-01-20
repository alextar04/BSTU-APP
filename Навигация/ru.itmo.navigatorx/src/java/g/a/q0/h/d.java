/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package g.a.q0.h;

import c.b.a.a.a;

public class d {
    public final long a;
    public final long b;

    public d(long l2, long l3) {
        this.a = l2;
        this.b = l3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (d.class != object.getClass()) {
                return false;
            }
            d d2 = (d)object;
            if (this.a != d2.a) {
                return false;
            }
            return this.b == d2.b;
        }
        return false;
    }

    public int hashCode() {
        long l2 = this.a;
        int n2 = 31 * (int)(l2 ^ l2 >>> 32);
        long l3 = this.b;
        return n2 + (int)(l3 ^ l3 >>> 32);
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Progress{transferredBytes=");
        stringBuilder.append(this.a);
        stringBuilder.append(", transferableBytes=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

