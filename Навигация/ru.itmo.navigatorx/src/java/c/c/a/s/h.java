/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.InputStream
 *  java.lang.Math
 */
package c.c.a.s;

import java.io.FilterInputStream;
import java.io.InputStream;

public class h
extends FilterInputStream {
    public int e = Integer.MIN_VALUE;

    public h(InputStream inputStream) {
        super(inputStream);
    }

    public int available() {
        int n2 = this.e;
        if (n2 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min((int)n2, (int)super.available());
    }

    public final long c(long l2) {
        int n2 = this.e;
        if (n2 == 0) {
            return -1L;
        }
        if (n2 != Integer.MIN_VALUE && l2 > (long)n2) {
            l2 = n2;
        }
        return l2;
    }

    public final void f(long l2) {
        int n2 = this.e;
        if (n2 != Integer.MIN_VALUE && l2 != -1L) {
            this.e = (int)((long)n2 - l2);
        }
    }

    public void mark(int n2) {
        h h2 = this;
        synchronized (h2) {
            super.mark(n2);
            this.e = n2;
            return;
        }
    }

    public int read() {
        if (this.c(1L) == -1L) {
            return -1;
        }
        int n2 = super.read();
        this.f(1L);
        return n2;
    }

    public int read(byte[] arrby, int n2, int n3) {
        int n4 = (int)this.c(n3);
        if (n4 == -1) {
            return -1;
        }
        int n5 = super.read(arrby, n2, n4);
        this.f(n5);
        return n5;
    }

    public void reset() {
        h h2 = this;
        synchronized (h2) {
            super.reset();
            this.e = Integer.MIN_VALUE;
            return;
        }
    }

    public long skip(long l2) {
        long l3 = this.c(l2);
        if (l3 == -1L) {
            return 0L;
        }
        long l4 = super.skip(l3);
        this.f(l4);
        return l4;
    }
}

