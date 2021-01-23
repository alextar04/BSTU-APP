/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j.e
 *  java.io.Serializable
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 */
package j;

import c.b.a.a.a;
import j.d;
import j.e;
import j.y;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class h
implements Serializable,
Comparable<h> {
    public static final char[] h = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final h i = h.h(new byte[0]);
    public final byte[] e;
    public transient int f;
    public transient String g;

    public h(byte[] arrby) {
        this.e = arrby;
    }

    public static h b(String string) {
        if (string.length() % 2 == 0) {
            int n2 = string.length() / 2;
            byte[] arrby = new byte[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = i2 * 2;
                arrby[i2] = (byte)((h.c(string.charAt(n3)) << 4) + h.c(string.charAt(n3 + 1)));
            }
            return h.h(arrby);
        }
        throw new IllegalArgumentException(a.j("Unexpected hex string: ", string));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int c(char n2) {
        if (n2 >= 48 && n2 <= 57) {
            return n2 - 48;
        }
        int n3 = 97;
        if (n2 >= n3 && n2 <= 102) {
            return 10 + (n2 - n3);
        }
        n3 = 65;
        if (n2 >= n3 && n2 <= 70) {
            return 10 + (n2 - n3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append((char)n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static h e(String string) {
        if (string != null) {
            h h2 = new h(string.getBytes(y.a));
            h2.g = string;
            return h2;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static /* varargs */ h h(byte ... arrby) {
        if (arrby != null) {
            return new h((byte[])arrby.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String a() {
        byte[] arrby = this.e;
        byte[] arrby2 = d.a;
        byte[] arrby3 = new byte[4 * ((2 + arrby.length) / 3)];
        int n2 = arrby.length - arrby.length % 3;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; i2 += 3) {
            int n4 = n3 + 1;
            arrby3[n3] = arrby2[(255 & arrby[i2]) >> 2];
            int n5 = n4 + 1;
            int n6 = (3 & arrby[i2]) << 4;
            int n7 = i2 + 1;
            arrby3[n4] = arrby2[n6 | (255 & arrby[n7]) >> 4];
            int n8 = n5 + 1;
            int n9 = (15 & arrby[n7]) << 2;
            int n10 = i2 + 2;
            arrby3[n5] = arrby2[n9 | (255 & arrby[n10]) >> 6];
            n3 = n8 + 1;
            arrby3[n8] = arrby2[63 & arrby[n10]];
        }
        int n11 = arrby.length % 3;
        if (n11 != 1) {
            if (n11 == 2) {
                int n12 = n3 + 1;
                arrby3[n3] = arrby2[(255 & arrby[n2]) >> 2];
                int n13 = n12 + 1;
                int n14 = (3 & arrby[n2]) << 4;
                int n15 = n2 + 1;
                arrby3[n12] = arrby2[n14 | (255 & arrby[n15]) >> 4];
                int n16 = n13 + 1;
                arrby3[n13] = arrby2[(15 & arrby[n15]) << 2];
                arrby3[n16] = 61;
            }
        } else {
            int n17 = n3 + 1;
            arrby3[n3] = arrby2[(255 & arrby[n2]) >> 2];
            int n18 = n17 + 1;
            arrby3[n17] = arrby2[(3 & arrby[n2]) << 4];
            int n19 = n18 + 1;
            arrby3[n18] = 61;
            arrby3[n19] = 61;
        }
        try {
            String string = new String(arrby3, "US-ASCII");
            return string;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public int compareTo(Object object) {
        h h2 = (h)object;
        int n2 = this.k();
        int n3 = h2.k();
        int n4 = Math.min((int)n2, (int)n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6 = 255 & this.f(i2);
            if (n6 == (n5 = 255 & h2.f(i2))) continue;
            if (n6 >= n5) return 1;
            return -1;
        }
        if (n2 == n3) {
            return 0;
        }
        if (n2 >= n3) return 1;
        return -1;
    }

    public final h d(String string) {
        try {
            h h2 = h.h(MessageDigest.getInstance((String)string).digest(this.e));
            return h2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError((Object)noSuchAlgorithmException);
        }
    }

    public boolean equals(Object object) {
        h h2;
        byte[] arrby;
        int n2;
        if (object == this) {
            return true;
        }
        return object instanceof h && (n2 = (h2 = (h)object).k()) == (arrby = this.e).length && h2.j(0, arrby, 0, arrby.length);
    }

    public byte f(int n2) {
        return this.e[n2];
    }

    public String g() {
        byte[] arrby = this.e;
        char[] arrc = new char[2 * arrby.length];
        int n2 = arrby.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = arrby[i2];
            int n4 = n3 + 1;
            char[] arrc2 = h;
            arrc[n3] = arrc2[15 & by >> 4];
            n3 = n4 + 1;
            arrc[n4] = arrc2[by & 15];
        }
        return new String(arrc);
    }

    public int hashCode() {
        int n2;
        int n3 = this.f;
        if (n3 != 0) {
            return n3;
        }
        this.f = n2 = Arrays.hashCode((byte[])this.e);
        return n2;
    }

    public boolean i(int n2, h h2, int n3, int n4) {
        return h2.j(n3, this.e, n2, n4);
    }

    public boolean j(int n2, byte[] arrby, int n3, int n4) {
        byte[] arrby2;
        return n2 >= 0 && n2 <= (arrby2 = this.e).length - n4 && n3 >= 0 && n3 <= arrby.length - n4 && y.a(arrby2, n2, arrby, n3, n4);
    }

    public int k() {
        return this.e.length;
    }

    public h l(int n2, int n3) {
        if (n2 >= 0) {
            byte[] arrby = this.e;
            if (n3 <= arrby.length) {
                int n4 = n3 - n2;
                if (n4 >= 0) {
                    if (n2 == 0 && n3 == arrby.length) {
                        return this;
                    }
                    byte[] arrby2 = new byte[n4];
                    System.arraycopy((Object)this.e, (int)n2, (Object)arrby2, (int)0, (int)n4);
                    return new h(arrby2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            StringBuilder stringBuilder = a.c("endIndex > length(");
            stringBuilder.append(this.e.length);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public h m() {
        byte[] arrby;
        for (int i2 = 0; i2 < (arrby = this.e).length; ++i2) {
            byte by = arrby[i2];
            if (by < 65 || by > 90) continue;
            byte[] arrby2 = (byte[])arrby.clone();
            arrby2[i2] = (byte)(by + 32);
            for (int i3 = i2 + 1; i3 < arrby2.length; ++i3) {
                byte by2 = arrby2[i3];
                if (by2 < 65 || by2 > 90) continue;
                arrby2[i3] = (byte)(by2 + 32);
            }
            return new h(arrby2);
        }
        return this;
    }

    public byte[] n() {
        return (byte[])this.e.clone();
    }

    public String o() {
        String string;
        String string2 = this.g;
        if (string2 != null) {
            return string2;
        }
        this.g = string = new String(this.e, y.a);
        return string;
    }

    public void p(e e2) {
        byte[] arrby = this.e;
        e2.K(arrby, 0, arrby.length);
    }

    public String toString() {
        String string;
        StringBuilder stringBuilder;
        int n2;
        block8 : {
            int n3;
            if (this.e.length == 0) {
                return "[size=0]";
            }
            string = this.o();
            int n4 = string.length();
            int n5 = 0;
            for (n2 = 0; n2 < n4; n2 += Character.charCount((int)n3)) {
                if (n5 == 64) break block8;
                n3 = string.codePointAt(n2);
                if (Character.isISOControl((int)n3) && n3 != 10 && n3 != 13 || n3 == 65533) {
                    n2 = -1;
                    break block8;
                }
                ++n5;
            }
            n2 = string.length();
        }
        if (n2 == -1) {
            StringBuilder stringBuilder2;
            if (this.e.length <= 64) {
                stringBuilder2 = a.c("[hex=");
                stringBuilder2.append(this.g());
                stringBuilder2.append("]");
            } else {
                stringBuilder2 = a.c("[size=");
                stringBuilder2.append(this.e.length);
                stringBuilder2.append(" hex=");
                stringBuilder2.append(this.l(0, 64).g());
                stringBuilder2.append("\u2026]");
            }
            return stringBuilder2.toString();
        }
        String string2 = string.substring(0, n2).replace((CharSequence)"\\", (CharSequence)"\\\\").replace((CharSequence)"\n", (CharSequence)"\\n").replace((CharSequence)"\r", (CharSequence)"\\r");
        if (n2 < string.length()) {
            stringBuilder = a.c("[size=");
            stringBuilder.append(this.e.length);
            stringBuilder.append(" text=");
            stringBuilder.append(string2);
            stringBuilder.append("\u2026]");
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("[text=");
            stringBuilder.append(string2);
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }
}

