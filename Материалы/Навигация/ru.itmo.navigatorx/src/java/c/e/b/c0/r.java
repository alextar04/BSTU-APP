/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigDecimal
 */
package c.e.b.c0;

import java.math.BigDecimal;

public final class r
extends Number {
    public final String e;

    public r(String string) {
        this.e = string;
    }

    public double doubleValue() {
        return Double.parseDouble((String)this.e);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return bl;
        }
        if (object instanceof r) {
            r r2 = (r)((Object)object);
            String string = this.e;
            String string2 = r2.e;
            if (string != string2) {
                if (string.equals((Object)string2)) {
                    return bl;
                }
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public float floatValue() {
        return Float.parseFloat((String)this.e);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public int intValue() {
        try {
            int n2 = Integer.parseInt((String)this.e);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            long l2;
            try {
                l2 = Long.parseLong((String)this.e);
            }
            catch (NumberFormatException numberFormatException2) {
                return new BigDecimal(this.e).intValue();
            }
            return (int)l2;
        }
    }

    public long longValue() {
        try {
            long l2 = Long.parseLong((String)this.e);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return new BigDecimal(this.e).longValue();
        }
    }

    public String toString() {
        return this.e;
    }
}

