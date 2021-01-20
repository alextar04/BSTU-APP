/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 */
package c.c.a.m.t;

import c.c.a.m.u.c0.b;
import java.io.OutputStream;

public final class c
extends OutputStream {
    public final OutputStream e;
    public byte[] f;
    public b g;
    public int h;

    public c(OutputStream outputStream, b b2) {
        this.e = outputStream;
        this.g = b2;
        this.f = b2.g(65536, byte[].class);
    }

    public void close() {
        block3 : {
            this.flush();
            byte[] arrby = this.f;
            if (arrby == null) break block3;
            this.g.f(arrby);
            this.f = null;
        }
        return;
        finally {
            this.e.close();
        }
    }

    public void flush() {
        int n2 = this.h;
        if (n2 > 0) {
            this.e.write(this.f, 0, n2);
            this.h = 0;
        }
        this.e.flush();
    }

    public void write(int n2) {
        int n3;
        byte[] arrby = this.f;
        int n4 = this.h;
        this.h = n3 = n4 + 1;
        arrby[n4] = (byte)n2;
        if (n3 == arrby.length && n3 > 0) {
            this.e.write(arrby, 0, n3);
            this.h = 0;
        }
    }

    public void write(byte[] arrby) {
        this.write(arrby, 0, arrby.length);
    }

    public void write(byte[] arrby, int n2, int n3) {
        int n4 = 0;
        do {
            int n5;
            int n6 = n3 - n4;
            int n7 = n2 + n4;
            if (this.h == 0 && n6 >= this.f.length) {
                this.e.write(arrby, n7, n6);
                return;
            }
            int n8 = Math.min((int)n6, (int)(this.f.length - this.h));
            System.arraycopy((Object)arrby, (int)n7, (Object)this.f, (int)this.h, (int)n8);
            this.h = n5 = n8 + this.h;
            n4 += n8;
            byte[] arrby2 = this.f;
            if (n5 != arrby2.length || n5 <= 0) continue;
            this.e.write(arrby2, 0, n5);
            this.h = 0;
        } while (n4 < n3);
    }
}

