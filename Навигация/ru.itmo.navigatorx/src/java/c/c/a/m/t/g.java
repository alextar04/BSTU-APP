/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.InputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 */
package c.c.a.m.t;

import c.b.a.a.a;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class g
extends FilterInputStream {
    public static final byte[] g;
    public static final int h;
    public static final int i;
    public final byte e;
    public int f;

    public static {
        int n2;
        byte[] arrby = new byte[]{-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        g = arrby;
        h = n2 = arrby.length;
        i = n2 + 2;
    }

    public g(InputStream inputStream, int n2) {
        super(inputStream);
        if (n2 >= -1 && n2 <= 8) {
            this.e = (byte)n2;
            return;
        }
        throw new IllegalArgumentException(a.b("Cannot add invalid orientation: ", n2));
    }

    public void mark(int n2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int n2;
        int n3 = this.f;
        int n4 = n3 >= 2 && n3 <= (n2 = i) ? (n3 == n2 ? (int)this.e : 255 & g[n3 - 2]) : super.read();
        if (n4 != -1) {
            this.f = 1 + this.f;
        }
        return n4;
    }

    public int read(byte[] arrby, int n2, int n3) {
        int n4;
        int n5 = this.f;
        int n6 = i;
        if (n5 > n6) {
            n4 = super.read(arrby, n2, n3);
        } else if (n5 == n6) {
            arrby[n2] = this.e;
            n4 = 1;
        } else if (n5 < 2) {
            n4 = super.read(arrby, n2, 2 - n5);
        } else {
            int n7 = Math.min((int)(n6 - n5), (int)n3);
            System.arraycopy((Object)g, (int)(this.f - 2), (Object)arrby, (int)n2, (int)n7);
            n4 = n7;
        }
        if (n4 > 0) {
            this.f = n4 + this.f;
        }
        return n4;
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long l2) {
        long l3 = super.skip(l2);
        if (l3 > 0L) {
            this.f = (int)(l3 + (long)this.f);
        }
        return l3;
    }
}

