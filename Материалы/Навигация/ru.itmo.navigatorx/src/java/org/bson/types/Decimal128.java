/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.math.MathContext
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 */
package org.bson.types;

import c.b.a.a.a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public final class Decimal128
extends Number
implements Comparable<Decimal128> {
    public static final BigInteger g = new BigInteger("10");
    public static final BigInteger h = new BigInteger("1");
    public static final BigInteger i = new BigInteger("0");
    public final long e;
    public final long f;

    public static {
        new HashSet((Collection)Collections.singletonList((Object)"nan"));
        new HashSet((Collection)Collections.singletonList((Object)"-nan"));
        new HashSet((Collection)Arrays.asList((Object[])new String[]{"inf", "+inf", "infinity", "+infinity"}));
        new HashSet((Collection)Arrays.asList((Object[])new String[]{"-inf", "-infinity"}));
        new Decimal128(8646911284551352320L, 0L);
        new Decimal128(-576460752303423488L, 0L);
        new Decimal128(-288230376151711744L, 0L);
        new Decimal128(8935141660703064064L, 0L);
        new Decimal128(3476778912330022912L, 0L);
        new Decimal128(-5746593124524752896L, 0L);
    }

    public Decimal128(long l2, long l3) {
        this.e = l2;
        this.f = l3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public Decimal128(BigDecimal var1_1) {
        block12 : {
            block10 : {
                block11 : {
                    var2_2 = var1_1.signum();
                    var3_3 = 0;
                    var4_4 = var2_2 == -1;
                    super();
                    if (-var1_1.scale() <= 6111) break block10;
                    var24_5 = -var1_1.scale() - 6111;
                    if (!var1_1.unscaledValue().equals((Object)Decimal128.i)) break block11;
                    var5_6 = new BigDecimal(var1_1.unscaledValue(), -6111);
                    break block12;
                }
                if (var24_5 + var1_1.precision() > 34) {
                    var25_11 = new StringBuilder();
                    var25_11.append("Exponent is out of range for Decimal128 encoding of ");
                    var25_11.append((Object)var1_1);
                    throw new NumberFormatException(var25_11.toString());
                }
                var28_7 = Decimal128.g.pow(var24_5);
                var23_8 = new BigDecimal(var1_1.unscaledValue().multiply(var28_7), var24_5 + var1_1.scale());
                ** GOTO lbl24
            }
            if (-var1_1.scale() < -6176) {
                var21_9 = -6176 + var1_1.scale();
                var22_10 = this.b(var1_1, var21_9) == 0 ? Decimal128.h : Decimal128.g.pow(var21_9);
                var23_8 = new BigDecimal(var1_1.unscaledValue().divide(var22_10), var1_1.scale() - var21_9);
lbl24: // 2 sources:
                var5_6 = var23_8;
            } else {
                var5_6 = var1_1.round(MathContext.DECIMAL128);
                var6_12 = var1_1.precision() - var5_6.precision();
                if (var6_12 > 0) {
                    this.b(var1_1, var6_12);
                }
            }
        }
        var7_13 = -var5_6.scale();
        if (var7_13 < -6176L) throw new AssertionError((Object)a.f("Exponent is out of range for Decimal128 encoding: ", var7_13));
        if (var7_13 > 6111L) throw new AssertionError((Object)a.f("Exponent is out of range for Decimal128 encoding: ", var7_13));
        if (var5_6.unscaledValue().bitLength() > 113) {
            var9_20 = a.c("Unscaled roundedValue is out of range for Decimal128 encoding:");
            var9_20.append((Object)var5_6.unscaledValue());
            throw new AssertionError((Object)var9_20.toString());
        }
        var11_14 = var5_6.unscaledValue().abs();
        var12_15 = var11_14.bitLength();
        var15_17 = var13_16 = 0L;
        while (var3_3 < Math.min((int)(var17_18 = 64), (int)var12_15)) {
            if (var11_14.testBit(var3_3)) {
                var15_17 |= 1L << var3_3;
            }
            ++var3_3;
        }
        while (var17_18 < var12_15) {
            if (var11_14.testBit(var17_18)) {
                var13_16 |= 1L << var17_18 - 64;
            }
            ++var17_18;
        }
        var18_19 = var13_16 | var7_13 + 6176L << 49;
        if (var5_6.signum() == -1 || var4_4) {
            var18_19 |= Long.MIN_VALUE;
        }
        this.e = var18_19;
        this.f = var15_17;
    }

    public final BigDecimal a() {
        long l2;
        int n2;
        boolean bl = (0x6000000000000000L & this.e) == 0x6000000000000000L;
        if (bl) {
            l2 = 2305807824841605120L & this.e;
            n2 = 47;
        } else {
            l2 = 9223231299366420480L & this.e;
            n2 = 49;
        }
        int n3 = -(-6176 + (int)(l2 >>> n2));
        boolean bl2 = (0x6000000000000000L & this.e) == 0x6000000000000000L;
        if (bl2) {
            return BigDecimal.valueOf((long)0L, (int)n3);
        }
        int n4 = this.f() ? -1 : 1;
        byte[] arrby = new byte[15];
        long l3 = 255L;
        for (int i2 = 14; i2 >= 7; --i2) {
            arrby[i2] = (byte)((l3 & this.f) >>> (14 - i2 << 3));
            l3 <<= 8;
        }
        long l4 = 255L;
        for (int i3 = 6; i3 >= 1; --i3) {
            arrby[i3] = (byte)((l4 & this.e) >>> (6 - i3 << 3));
            l4 <<= 8;
        }
        arrby[0] = (byte)((0x1000000000000L & this.e) >>> 48);
        return new BigDecimal(new BigInteger(n4, arrby), n3);
    }

    public final int b(BigDecimal bigDecimal, int n2) {
        int n3;
        String string = bigDecimal.unscaledValue().abs().toString();
        for (int i2 = n3 = Math.max((int)0, (int)(string.length() - n2)); i2 < string.length(); ++i2) {
            if (string.charAt(i2) == '0') {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Conversion to Decimal128 would require inexact rounding of ");
            stringBuilder.append((Object)bigDecimal);
            throw new NumberFormatException(stringBuilder.toString());
        }
        return n3;
    }

    public final boolean c(BigDecimal bigDecimal) {
        return this.f() && bigDecimal.signum() == 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int compareTo(Object object) {
        Decimal128 decimal128 = (Decimal128)((Object)object);
        boolean bl = this.e();
        int n2 = 1;
        if (bl) {
            return n2 ^ decimal128.e();
        }
        if (this.d()) {
            if (this.f()) {
                if (!decimal128.d()) return -1;
                if (!decimal128.f()) return -1;
                do {
                    return 0;
                    break;
                } while (true);
            }
            if (decimal128.e()) return -1;
            if (!decimal128.d()) return n2;
            if (decimal128.f()) return n2;
            return 0;
        }
        BigDecimal bigDecimal = this.a();
        BigDecimal bigDecimal2 = decimal128.a();
        if (this.g(bigDecimal) && decimal128.g(bigDecimal2)) {
            if (this.c(bigDecimal)) {
                if (!decimal128.c(bigDecimal2)) return -1;
                return 0;
            }
            if (decimal128.c(bigDecimal2)) {
                return n2;
            }
        }
        if (decimal128.e()) {
            return -1;
        }
        if (!decimal128.d()) return bigDecimal.compareTo(bigDecimal2);
        if (!decimal128.f()) return -1;
        return n2;
    }

    public boolean d() {
        return (8646911284551352320L & this.e) == 8646911284551352320L;
    }

    public double doubleValue() {
        if (this.e()) {
            return Double.NaN;
        }
        if (this.d()) {
            if (this.f()) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        BigDecimal bigDecimal = this.a();
        if (this.c(bigDecimal)) {
            return 0.0;
        }
        return bigDecimal.doubleValue();
    }

    public boolean e() {
        return (8935141660703064064L & this.e) == 8935141660703064064L;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (Decimal128.class != object.getClass()) {
                return false;
            }
            Decimal128 decimal128 = (Decimal128)((Object)object);
            if (this.e != decimal128.e) {
                return false;
            }
            return this.f == decimal128.f;
        }
        return false;
    }

    public boolean f() {
        return (Long.MIN_VALUE & this.e) == Long.MIN_VALUE;
    }

    public float floatValue() {
        return (float)this.doubleValue();
    }

    public final boolean g(BigDecimal bigDecimal) {
        return !this.e() && !this.d() && bigDecimal.compareTo(BigDecimal.ZERO) == 0;
    }

    public int hashCode() {
        long l2 = this.f;
        int n2 = 31 * (int)(l2 ^ l2 >>> 32);
        long l3 = this.e;
        return n2 + (int)(l3 ^ l3 >>> 32);
    }

    public int intValue() {
        return (int)this.doubleValue();
    }

    public long longValue() {
        return (long)this.doubleValue();
    }

    public String toString() {
        if (this.e()) {
            return "NaN";
        }
        if (this.d()) {
            if (this.f()) {
                return "-Infinity";
            }
            return "Infinity";
        }
        StringBuilder stringBuilder = new StringBuilder();
        BigDecimal bigDecimal = this.a();
        String string = bigDecimal.unscaledValue().abs().toString();
        if (this.f()) {
            stringBuilder.append('-');
        }
        int n2 = -bigDecimal.scale();
        int n3 = n2 + (string.length() - 1);
        if (n2 <= 0 && n3 >= -6) {
            if (n2 == 0) {
                stringBuilder.append(string);
            } else {
                int n4 = -n2 - string.length();
                if (n4 >= 0) {
                    stringBuilder.append('0');
                    stringBuilder.append('.');
                    for (int i2 = 0; i2 < n4; ++i2) {
                        stringBuilder.append('0');
                    }
                    stringBuilder.append((CharSequence)string, 0, string.length());
                } else {
                    int n5 = -n4;
                    stringBuilder.append((CharSequence)string, 0, n5);
                    stringBuilder.append('.');
                    stringBuilder.append((CharSequence)string, n5, n5 - n2);
                }
            }
        } else {
            stringBuilder.append(string.charAt(0));
            if (string.length() > 1) {
                stringBuilder.append('.');
                stringBuilder.append((CharSequence)string, 1, string.length());
            }
            stringBuilder.append('E');
            if (n3 > 0) {
                stringBuilder.append('+');
            }
            stringBuilder.append(n3);
        }
        return stringBuilder.toString();
    }
}

