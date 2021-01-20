/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  c.c.a.m.o
 *  java.io.InputStream
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.w;
import c.c.a.m.w.c.j;
import c.c.a.s.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class f
implements q<ByteBuffer, Bitmap> {
    public final j a;

    public f(j j2) {
        this.a = j2;
    }

    @Override
    public w a(Object object, int n2, int n3, o o2) {
        InputStream inputStream = a.e((ByteBuffer)object);
        return this.a.b(inputStream, n2, n3, o2, j.k);
    }

    @Override
    public boolean b(Object object, o o2) {
        (ByteBuffer)object;
        if (this.a != null) {
            return true;
        }
        throw null;
    }
}

