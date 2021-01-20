/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.math.BigInteger
 */
package c.e.b;

import c.e.b.c0.r;
import c.e.b.o;
import java.math.BigInteger;

public final class t
extends o {
    public final Object a;

    public t(Boolean bl) {
        if (bl != null) {
            this.a = bl;
            return;
        }
        throw null;
    }

    public t(Number number) {
        if (number != null) {
            this.a = number;
            return;
        }
        throw null;
    }

    public t(String string) {
        if (string != null) {
            this.a = string;
            return;
        }
        throw null;
    }

    public static boolean f(t t2) {
        Number number;
        Object object = t2.a;
        return object instanceof Number && ((number = (Number)object) instanceof BigInteger || number instanceof Long || number instanceof Integer || number instanceof Short || number instanceof Byte);
    }

    public boolean c() {
        Object object = this.a;
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        return Boolean.parseBoolean((String)this.e());
    }

    public Number d() {
        Object object = this.a;
        if (object instanceof String) {
            return new r((String)this.a);
        }
        return (Number)object;
    }

    public String e() {
        Object object = this.a;
        if (object instanceof Number) {
            return this.d().toString();
        }
        if (object instanceof Boolean) {
            return ((Boolean)object).toString();
        }
        return (String)object;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return bl;
        }
        if (object != null) {
            if (t.class != object.getClass()) {
                return false;
            }
            t t2 = (t)object;
            if (this.a == null) {
                if (t2.a == null) {
                    return bl;
                }
                return false;
            }
            if (t.f(this) && t.f(t2)) {
                if (this.d().longValue() == t2.d().longValue()) {
                    return bl;
                }
                return false;
            }
            if (this.a instanceof Number && t2.a instanceof Number) {
                double d2;
                double d3 = this.d().doubleValue();
                if (d3 != (d2 = t2.d().doubleValue())) {
                    if (Double.isNaN((double)d3) && Double.isNaN((double)d2)) {
                        return bl;
                    }
                    bl = false;
                }
                return bl;
            }
            return this.a.equals(t2.a);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        long l2;
        if (this.a == null) {
            return 31;
        }
        if (t.f(this)) {
            l2 = this.d().longValue();
            do {
                return (int)(l2 ^ l2 >>> 32);
                break;
            } while (true);
        }
        Object object = this.a;
        if (!(object instanceof Number)) return object.hashCode();
        l2 = Double.doubleToLongBits((double)this.d().doubleValue());
        return (int)(l2 ^ l2 >>> 32);
    }
}

