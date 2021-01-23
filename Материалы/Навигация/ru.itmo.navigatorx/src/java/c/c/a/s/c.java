/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.s;

import c.b.a.a.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c
extends FilterInputStream {
    public final long e;
    public int f;

    public c(InputStream inputStream, long l2) {
        super(inputStream);
        this.e = l2;
    }

    public int available() {
        c c2 = this;
        synchronized (c2) {
            long l2 = Math.max((long)(this.e - (long)this.f), (long)this.in.available());
            int n2 = (int)l2;
            return n2;
        }
    }

    public final int c(int n2) {
        if (n2 >= 0) {
            this.f = n2 + this.f;
            return n2;
        }
        if (this.e - (long)this.f <= 0L) {
            return n2;
        }
        StringBuilder stringBuilder = a.c("Failed to read all expected data, expected: ");
        stringBuilder.append(this.e);
        stringBuilder.append(", but read: ");
        stringBuilder.append(this.f);
        throw new IOException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read() {
        c c2 = this;
        synchronized (c2) {
            int n2 = super.read();
            int n3 = n2 >= 0 ? 1 : -1;
            this.c(n3);
            return n2;
        }
    }

    public int read(byte[] arrby) {
        return this.read(arrby, 0, arrby.length);
    }

    public int read(byte[] arrby, int n2, int n3) {
        c c2 = this;
        synchronized (c2) {
            int n4 = super.read(arrby, n2, n3);
            this.c(n4);
            return n4;
        }
    }
}

