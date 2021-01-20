/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.BufferUnderflowException
 *  java.nio.ByteBuffer
 *  java.util.List
 */
package c.c.a.l;

import android.util.Log;
import c.c.a.l.b;
import c.c.a.l.c;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.List;

public class d {
    public final byte[] a = new byte[256];
    public ByteBuffer b;
    public c c;
    public int d = 0;

    public final boolean a() {
        return this.c.b != 0;
    }

    public c b() {
        if (this.b != null) {
            if (this.a()) {
                return this.c;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < 6; ++i2) {
                stringBuilder.append((char)this.c());
            }
            if (!stringBuilder.toString().startsWith("GIF")) {
                this.c.b = 1;
            } else {
                this.c.f = this.f();
                this.c.g = this.f();
                int n2 = this.c();
                c c2 = this.c;
                boolean bl = (n2 & 128) != 0;
                c2.h = bl;
                this.c.i = (int)Math.pow((double)2.0, (double)(1 + (n2 & 7)));
                this.c.j = this.c();
                this.c.k = this.c();
                if (this.c.h && !this.a()) {
                    c c3 = this.c;
                    c3.a = this.e(c3.i);
                    c c4 = this.c;
                    c4.l = c4.a[c4.j];
                }
            }
            if (!this.a()) {
                boolean bl = false;
                while (!bl && !this.a() && this.c.c <= Integer.MAX_VALUE) {
                    int n3 = this.c();
                    if (n3 != 33) {
                        if (n3 != 44) {
                            if (n3 != 59) {
                                this.c.b = 1;
                                continue;
                            }
                            bl = true;
                            continue;
                        }
                        c c5 = this.c;
                        if (c5.d == null) {
                            c5.d = new b();
                        }
                        this.c.d.a = this.f();
                        this.c.d.b = this.f();
                        this.c.d.c = this.f();
                        this.c.d.d = this.f();
                        int n4 = this.c();
                        boolean bl2 = (n4 & 128) != 0;
                        int n5 = (int)Math.pow((double)2.0, (double)(1 + (n4 & 7)));
                        b b2 = this.c.d;
                        boolean bl3 = (n4 & 64) != 0;
                        b2.e = bl3;
                        b b3 = this.c.d;
                        b3.k = bl2 ? this.e(n5) : null;
                        this.c.d.j = this.b.position();
                        this.c();
                        this.g();
                        if (this.a()) continue;
                        c c6 = this.c;
                        c6.c = 1 + c6.c;
                        c6.e.add((Object)c6.d);
                        continue;
                    }
                    int n6 = this.c();
                    if (n6 != 1) {
                        if (n6 != 249) {
                            if (n6 != 254 && n6 == 255) {
                                this.d();
                                StringBuilder stringBuilder2 = new StringBuilder();
                                for (int i3 = 0; i3 < 11; ++i3) {
                                    stringBuilder2.append((char)this.a[i3]);
                                }
                                if (stringBuilder2.toString().equals((Object)"NETSCAPE2.0")) {
                                    do {
                                        this.d();
                                        byte[] arrby = this.a;
                                        if (arrby[0] != 1) continue;
                                        int n7 = 255 & arrby[1];
                                        int n8 = 255 & arrby[2];
                                        this.c.m = n7 | n8 << 8;
                                    } while (this.d > 0 && !this.a());
                                    continue;
                                }
                            }
                        } else {
                            int n9;
                            this.c.d = new b();
                            this.c();
                            int n10 = this.c();
                            b b4 = this.c.d;
                            b4.g = n9 = (n10 & 28) >> 2;
                            if (n9 == 0) {
                                b4.g = 1;
                            }
                            b b5 = this.c.d;
                            boolean bl4 = (n10 & 1) != 0;
                            b5.f = bl4;
                            int n11 = this.f();
                            if (n11 < 2) {
                                n11 = 10;
                            }
                            b b6 = this.c.d;
                            b6.i = n11 * 10;
                            b6.h = this.c();
                            this.c();
                            continue;
                        }
                    }
                    this.g();
                }
                c c7 = this.c;
                if (c7.c < 0) {
                    c7.b = 1;
                }
            }
            return this.c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final int c() {
        byte by;
        try {
            by = this.b.get();
        }
        catch (Exception exception) {
            this.c.b = 1;
            return 0;
        }
        return by & 255;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void d() {
        int n2;
        this.d = n2 = this.c();
        if (n2 <= 0) return;
        {
            int n3;
            int n4 = 0;
            try {
                for (n3 = 0; n3 < this.d; n3 += n4) {
                    n4 = this.d - n3;
                    this.b.get(this.a, n3, n4);
                }
                return;
            }
            catch (Exception exception) {
                if (Log.isLoggable((String)"GifHeaderParser", (int)3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error Reading Block n: ");
                    stringBuilder.append(n3);
                    stringBuilder.append(" count: ");
                    stringBuilder.append(n4);
                    stringBuilder.append(" blockSize: ");
                    stringBuilder.append(this.d);
                    Log.d((String)"GifHeaderParser", (String)stringBuilder.toString(), (Throwable)exception);
                }
                this.c.b = 1;
            }
        }
    }

    public final int[] e(int n2) {
        byte[] arrby = new byte[n2 * 3];
        int[] arrn = null;
        this.b.get(arrby);
        arrn = new int[256];
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            int n5 = n4 + 1;
            int n6 = 255 & arrby[n4];
            int n7 = n5 + 1;
            int n8 = 255 & arrby[n5];
            int n9 = n7 + 1;
            int n10 = 255 & arrby[n7];
            int n11 = n3 + 1;
            try {
                arrn[n3] = n10 | (-16777216 | n6 << 16 | n8 << 8);
                n4 = n9;
                n3 = n11;
            }
            catch (BufferUnderflowException bufferUnderflowException) {
                if (Log.isLoggable((String)"GifHeaderParser", (int)3)) {
                    Log.d((String)"GifHeaderParser", (String)"Format Error Reading Color Table", (Throwable)bufferUnderflowException);
                }
                this.c.b = 1;
                break;
            }
        }
        return arrn;
    }

    public final int f() {
        return this.b.getShort();
    }

    public final void g() {
        int n2;
        do {
            n2 = this.c();
            int n3 = Math.min((int)(n2 + this.b.position()), (int)this.b.limit());
            this.b.position(n3);
        } while (n2 > 0);
    }
}

