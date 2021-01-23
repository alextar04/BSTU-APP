/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.ImageDecoder
 *  android.graphics.ImageDecoder$Source
 *  c.c.a.m.o
 *  java.io.InputStream
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.w;
import c.c.a.m.w.c.d;
import c.c.a.s.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class p
implements q<InputStream, Bitmap> {
    public final d a = new d();

    @Override
    public w a(Object object, int n2, int n3, o o2) {
        ImageDecoder.Source source = ImageDecoder.createSource((ByteBuffer)a.b((InputStream)object));
        return this.a.c(source, n2, n3, o2);
    }

    @Override
    public boolean b(Object object, o o2) {
        (InputStream)object;
        return true;
    }
}

