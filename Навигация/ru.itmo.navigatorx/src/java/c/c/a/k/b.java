/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package c.c.a.k;

import c.c.a.k.c;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class b
implements Closeable {
    public final InputStream e;
    public final Charset f;
    public byte[] g;
    public int h;
    public int i;

    public b(InputStream inputStream, Charset charset) {
        if (charset != null) {
            if (charset.equals((Object)c.a)) {
                this.e = inputStream;
                this.f = charset;
                this.g = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }

    public final void c() {
        InputStream inputStream = this.e;
        byte[] arrby = this.g;
        int n2 = inputStream.read(arrby, 0, arrby.length);
        if (n2 != -1) {
            this.h = 0;
            this.i = n2;
            return;
        }
        throw new EOFException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        InputStream inputStream;
        InputStream inputStream2 = inputStream = this.e;
        synchronized (inputStream2) {
            if (this.g != null) {
                this.g = null;
                this.e.close();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String f() {
        InputStream inputStream;
        InputStream inputStream2 = inputStream = this.e;
        synchronized (inputStream2) {
            if (this.g == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.h >= this.i) {
                this.c();
            }
            int n2 = this.h;
            do {
                if (n2 == this.i) break;
                if (this.g[n2] == 10) {
                    byte[] arrby;
                    int n3;
                    if (n2 != this.h && (arrby = this.g)[n3 = n2 - 1] == 13) {
                    } else {
                        n3 = n2;
                    }
                    String string = new String(this.g, this.h, n3 - this.h, this.f.name());
                    this.h = n2 + 1;
                    return string;
                }
                ++n2;
            } while (true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(80 + (this.i - this.h)){

                public String toString() {
                    int n2 = this.count;
                    int n3 = n2 > 0 && this.buf[n2 - 1] == 13 ? n2 - 1 : this.count;
                    try {
                        String string = new String(this.buf, 0, n3, b.this.f.name());
                        return string;
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {
                        throw new AssertionError((Object)unsupportedEncodingException);
                    }
                }
            };
            block4 : do {
                byteArrayOutputStream.write(this.g, this.h, this.i - this.h);
                this.i = -1;
                this.c();
                int n4 = this.h;
                do {
                    if (n4 == this.i) continue block4;
                    if (this.g[n4] == 10) {
                        if (n4 != this.h) {
                            byteArrayOutputStream.write(this.g, this.h, n4 - this.h);
                        }
                        this.h = n4 + 1;
                        return byteArrayOutputStream.toString();
                    }
                    ++n4;
                } while (true);
                break;
            } while (true);
        }
    }

}

