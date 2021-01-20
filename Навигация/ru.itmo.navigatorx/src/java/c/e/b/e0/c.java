/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package c.e.b.e0;

import c.b.a.a.a;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class c
implements Closeable,
Flushable {
    public static final String[] l = new String[128];
    public static final String[] m;
    public final Writer e;
    public int[] f = new int[32];
    public int g = 0;
    public String h;
    public boolean i;
    public String j;
    public boolean k;

    public static {
        for (int i2 = 0; i2 <= 31; ++i2) {
            String[] arrstring = l;
            Object[] arrobject = new Object[]{i2};
            arrstring[i2] = String.format((String)"\\u%04x", (Object[])arrobject);
        }
        String[] arrstring = l;
        arrstring[34] = "\\\"";
        arrstring[92] = "\\\\";
        arrstring[9] = "\\t";
        arrstring[8] = "\\b";
        arrstring[10] = "\\n";
        arrstring[13] = "\\r";
        arrstring[12] = "\\f";
        String[] arrstring2 = (String[])arrstring.clone();
        m = arrstring2;
        arrstring2[60] = "\\u003c";
        arrstring2[62] = "\\u003e";
        arrstring2[38] = "\\u0026";
        arrstring2[61] = "\\u003d";
        arrstring2[39] = "\\u0027";
    }

    public c(Writer writer) {
        this.x(6);
        this.h = ":";
        this.k = true;
        if (writer != null) {
            this.e = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final void B(int n2) {
        this.f[-1 + this.g] = n2;
    }

    public final void J(String string) {
        String[] arrstring = l;
        this.e.write(34);
        int n2 = string.length();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2;
            char c2 = string.charAt(i2);
            if (c2 < '') {
                string2 = arrstring[c2];
                if (string2 == null) {
                    continue;
                }
            } else if (c2 == '\u2028') {
                string2 = "\\u2028";
            } else {
                if (c2 != '\u2029') continue;
                string2 = "\\u2029";
            }
            if (n3 < i2) {
                this.e.write(string, n3, i2 - n3);
            }
            this.e.write(string2);
            n3 = i2 + 1;
        }
        if (n3 < n2) {
            this.e.write(string, n3, n2 - n3);
        }
        this.e.write(34);
    }

    public c K(long l2) {
        this.P();
        this.c();
        this.e.write(Long.toString((long)l2));
        return this;
    }

    public c L(Boolean bl) {
        if (bl == null) {
            return this.u();
        }
        this.P();
        this.c();
        Writer writer = this.e;
        String string = bl != false ? "true" : "false";
        writer.write(string);
        return this;
    }

    public c M(Number number) {
        if (number == null) {
            return this.u();
        }
        this.P();
        String string = number.toString();
        if (!this.i && (string.equals((Object)"-Infinity") || string.equals((Object)"Infinity") || string.equals((Object)"NaN"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.c();
        this.e.append((CharSequence)string);
        return this;
    }

    public c N(String string) {
        if (string == null) {
            return this.u();
        }
        this.P();
        this.c();
        this.J(string);
        return this;
    }

    public c O(boolean bl) {
        this.P();
        this.c();
        Writer writer = this.e;
        String string = bl ? "true" : "false";
        writer.write(string);
        return this;
    }

    public final void P() {
        block2 : {
            block5 : {
                block4 : {
                    int n2;
                    block3 : {
                        if (this.j == null) break block2;
                        n2 = this.v();
                        if (n2 != 5) break block3;
                        this.e.write(44);
                        break block4;
                    }
                    if (n2 != 3) break block5;
                }
                this.B(4);
                this.J(this.j);
                this.j = null;
                return;
            }
            throw new IllegalStateException("Nesting problem.");
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void c() {
        int n2 = this.v();
        int n3 = 2;
        if (n2 != 1) {
            if (n2 == n3) {
                this.e.append(',');
                return;
            }
            if (n2 == 4) {
                this.e.append((CharSequence)this.h);
                this.B(5);
                return;
            }
            n3 = 7;
            if (n2 != 6) {
                if (n2 != n3) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.i) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
        }
        this.B(n3);
    }

    public void close() {
        this.e.close();
        int n2 = this.g;
        if (n2 <= 1 && (n2 != 1 || this.f[n2 - 1] == 7)) {
            this.g = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c f() {
        this.P();
        this.c();
        this.x(1);
        this.e.write(91);
        return this;
    }

    public void flush() {
        if (this.g != 0) {
            this.e.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c h() {
        this.P();
        this.c();
        this.x(3);
        this.e.write(123);
        return this;
    }

    public final c j(int n2, int n3, char c2) {
        int n4 = this.v();
        if (n4 != n3 && n4 != n2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j == null) {
            this.g = -1 + this.g;
            this.e.write((int)c2);
            return this;
        }
        StringBuilder stringBuilder = a.c("Dangling name: ");
        stringBuilder.append(this.j);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public c m() {
        this.j(1, 2, ']');
        return this;
    }

    public c p() {
        this.j(3, 5, '}');
        return this;
    }

    public c s(String string) {
        if (string != null) {
            if (this.j == null) {
                if (this.g != 0) {
                    this.j = string;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public c u() {
        if (this.j != null) {
            if (this.k) {
                this.P();
            } else {
                this.j = null;
                return this;
            }
        }
        this.c();
        this.e.write("null");
        return this;
    }

    public final int v() {
        int n2 = this.g;
        if (n2 != 0) {
            return this.f[n2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void x(int n2) {
        int n3 = this.g;
        int[] arrn = this.f;
        if (n3 == arrn.length) {
            this.f = Arrays.copyOf((int[])arrn, (int)(n3 * 2));
        }
        int[] arrn2 = this.f;
        int n4 = this.g;
        this.g = n4 + 1;
        arrn2[n4] = n2;
    }
}

