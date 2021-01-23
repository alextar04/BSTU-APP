/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package c.c.a.m.w.c;

import c.c.a.m.u.c0.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class s
extends FilterInputStream {
    public volatile byte[] e;
    public int f;
    public int g;
    public int h = -1;
    public int i;
    public final b j;

    public s(InputStream inputStream, b b2) {
        super(inputStream);
        this.j = b2;
        this.e = b2.g(65536, byte[].class);
    }

    public static IOException h() {
        throw new IOException("BufferedInputStream is closed");
    }

    public int available() {
        s s2 = this;
        synchronized (s2) {
            block5 : {
                InputStream inputStream = this.in;
                if (this.e == null || inputStream == null) break block5;
                int n2 = this.f - this.i;
                int n3 = inputStream.available();
                int n4 = n2 + n3;
                return n4;
            }
            s.h();
            throw null;
        }
    }

    public final int c(InputStream inputStream, byte[] arrby) {
        int n2;
        int n3;
        int n4 = this.h;
        if (n4 != -1 && (n2 = this.i - n4) < (n3 = this.g)) {
            int n5;
            if (n4 == 0 && n3 > arrby.length && this.f == arrby.length) {
                int n6 = 2 * arrby.length;
                if (n6 <= n3) {
                    n3 = n6;
                }
                byte[] arrby2 = this.j.g(n3, byte[].class);
                System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)arrby.length);
                this.e = arrby2;
                this.j.f(arrby);
                arrby = arrby2;
            } else {
                int n7 = this.h;
                if (n7 > 0) {
                    System.arraycopy((Object)arrby, (int)n7, (Object)arrby, (int)0, (int)(arrby.length - n7));
                }
            }
            this.i = n5 = this.i - this.h;
            this.h = 0;
            this.f = 0;
            int n8 = inputStream.read(arrby, n5, arrby.length - n5);
            int n9 = this.i;
            if (n8 > 0) {
                n9 += n8;
            }
            this.f = n9;
            return n8;
        }
        int n10 = inputStream.read(arrby);
        if (n10 > 0) {
            this.h = -1;
            this.i = 0;
            this.f = n10;
        }
        return n10;
    }

    public void close() {
        if (this.e != null) {
            this.j.f(this.e);
            this.e = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public void f() {
        s s2 = this;
        synchronized (s2) {
            if (this.e != null) {
                this.j.f(this.e);
                this.e = null;
            }
            return;
        }
    }

    public void mark(int n2) {
        s s2 = this;
        synchronized (s2) {
            this.g = Math.max((int)this.g, (int)n2);
            this.h = this.i;
            return;
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        s s2 = this;
        synchronized (s2) {
            block8 : {
                block11 : {
                    byte[] arrby;
                    block10 : {
                        block9 : {
                            int n2;
                            arrby = this.e;
                            InputStream inputStream = this.in;
                            if (arrby == null || inputStream == null) break block8;
                            if (this.i < this.f || (n2 = this.c(inputStream, arrby)) != -1) break block9;
                            return -1;
                        }
                        if (arrby == this.e || (arrby = this.e) != null) break block10;
                        s.h();
                        throw null;
                    }
                    if (this.f - this.i <= 0) break block11;
                    int n3 = this.i;
                    this.i = n3 + 1;
                    byte by = arrby[n3];
                    int n4 = by & 255;
                    return n4;
                }
                return -1;
            }
            s.h();
            throw null;
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public int read(byte[] arrby, int n2, int n3) {
        s s2 = this;
        synchronized (s2) {
            block13 : {
                block15 : {
                    InputStream inputStream;
                    byte[] arrby2;
                    int n4;
                    block25 : {
                        block16 : {
                            int n5;
                            block17 : {
                                int n6;
                                block14 : {
                                    arrby2 = this.e;
                                    if (arrby2 == null) break block13;
                                    if (n3 != 0) break block14;
                                    return 0;
                                }
                                inputStream = this.in;
                                if (inputStream == null) break block15;
                                if (this.i >= this.f) break block16;
                                n5 = this.f - this.i >= n3 ? n3 : this.f - this.i;
                                System.arraycopy((Object)arrby2, (int)this.i, (Object)arrby, (int)n2, (int)n5);
                                this.i = n5 + this.i;
                                if (n5 == n3 || (n6 = inputStream.available()) == 0) break block17;
                                n2 += n5;
                                n4 = n3 - n5;
                                break block25;
                            }
                            return n5;
                        }
                        n4 = n3;
                    }
                    do {
                        int n7;
                        block24 : {
                            block19 : {
                                block23 : {
                                    block21 : {
                                        int n8;
                                        block22 : {
                                            block18 : {
                                                block20 : {
                                                    int n9 = this.h;
                                                    n8 = -1;
                                                    if (n9 != n8 || n4 < arrby2.length) break block18;
                                                    n7 = inputStream.read(arrby, n2, n4);
                                                    if (n7 != n8) break block19;
                                                    if (n4 == n3) break block20;
                                                    n8 = n3 - n4;
                                                }
                                                return n8;
                                            }
                                            int n10 = this.c(inputStream, arrby2);
                                            if (n10 != n8) break block21;
                                            if (n4 == n3) break block22;
                                            n8 = n3 - n4;
                                        }
                                        return n8;
                                    }
                                    if (arrby2 == this.e || (arrby2 = this.e) != null) break block23;
                                    s.h();
                                    throw null;
                                }
                                n7 = this.f - this.i >= n4 ? n4 : this.f - this.i;
                                System.arraycopy((Object)arrby2, (int)this.i, (Object)arrby, (int)n2, (int)n7);
                                this.i = n7 + this.i;
                            }
                            if ((n4 -= n7) == 0) {
                                return n3;
                            }
                            int n11 = inputStream.available();
                            if (n11 != 0) break block24;
                            int n12 = n3 - n4;
                            return n12;
                        }
                        n2 += n7;
                    } while (true);
                }
                s.h();
                throw null;
            }
            s.h();
            throw null;
        }
    }

    public void reset() {
        s s2 = this;
        synchronized (s2) {
            if (this.e != null) {
                if (-1 != this.h) {
                    this.i = this.h;
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Mark has been invalidated, pos: ");
                stringBuilder.append(this.i);
                stringBuilder.append(" markLimit: ");
                stringBuilder.append(this.g);
                throw new a(stringBuilder.toString());
            }
            throw new IOException("Stream is closed");
        }
    }

    public long skip(long l2) {
        s s2 = this;
        synchronized (s2) {
            block12 : {
                block13 : {
                    InputStream inputStream;
                    long l3;
                    block15 : {
                        block17 : {
                            block16 : {
                                byte[] arrby;
                                block14 : {
                                    if (l2 < 1L) {
                                        return 0L;
                                    }
                                    arrby = this.e;
                                    if (arrby == null) break block12;
                                    inputStream = this.in;
                                    if (inputStream == null) break block13;
                                    if ((long)(this.f - this.i) < l2) break block14;
                                    this.i = (int)(l2 + (long)this.i);
                                    return l2;
                                }
                                l3 = (long)this.f - (long)this.i;
                                this.i = this.f;
                                if (this.h == -1 || l2 > (long)this.g) break block15;
                                int n2 = this.c(inputStream, arrby);
                                if (n2 != -1) break block16;
                                return l3;
                            }
                            if ((long)(this.f - this.i) < l2 - l3) break block17;
                            this.i = (int)(l2 + (long)this.i - l3);
                            return l2;
                        }
                        long l4 = l3 + (long)this.f - (long)this.i;
                        this.i = this.f;
                        return l4;
                    }
                    long l5 = l2 - l3;
                    long l6 = inputStream.skip(l5);
                    long l7 = l3 + l6;
                    return l7;
                }
                s.h();
                throw null;
            }
            s.h();
            throw null;
        }
    }

    public static class a
    extends IOException {
        public a(String string) {
            super(string);
        }
    }

}

