/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.util.Queue
 */
package c.c.a.s;

import c.c.a.s.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class d
extends InputStream {
    public static final Queue<d> g = j.c(0);
    public InputStream e;
    public IOException f;

    public int available() {
        return this.e.available();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Queue<d> queue;
        this.f = null;
        this.e = null;
        Queue<d> queue2 = queue = g;
        synchronized (queue2) {
            g.offer((Object)this);
            return;
        }
    }

    public void close() {
        this.e.close();
    }

    public void mark(int n2) {
        this.e.mark(n2);
    }

    public boolean markSupported() {
        return this.e.markSupported();
    }

    public int read() {
        try {
            int n2 = this.e.read();
            return n2;
        }
        catch (IOException iOException) {
            this.f = iOException;
            return -1;
        }
    }

    public int read(byte[] arrby) {
        try {
            int n2 = this.e.read(arrby);
            return n2;
        }
        catch (IOException iOException) {
            this.f = iOException;
            return -1;
        }
    }

    public int read(byte[] arrby, int n2, int n3) {
        try {
            int n4 = this.e.read(arrby, n2, n3);
            return n4;
        }
        catch (IOException iOException) {
            this.f = iOException;
            return -1;
        }
    }

    public void reset() {
        d d2 = this;
        synchronized (d2) {
            this.e.reset();
            return;
        }
    }

    public long skip(long l2) {
        try {
            long l3 = this.e.skip(l2);
            return l3;
        }
        catch (IOException iOException) {
            this.f = iOException;
            return 0L;
        }
    }
}

