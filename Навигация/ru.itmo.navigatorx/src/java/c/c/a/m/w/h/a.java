/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  c.c.a.m.o
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.Object
 */
package c.c.a.m.w.h;

import android.graphics.Bitmap;
import c.c.a.m.o;
import c.c.a.m.u.w;
import c.c.a.m.w.d.b;
import c.c.a.m.w.h.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class a
implements e<Bitmap, byte[]> {
    public final Bitmap.CompressFormat a;
    public final int b;

    public a() {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        this.a = compressFormat;
        this.b = 100;
    }

    @Override
    public w<byte[]> a(w<Bitmap> w2, o o2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        w2.b().compress(this.a, this.b, (OutputStream)byteArrayOutputStream);
        w2.e();
        return new b(byteArrayOutputStream.toByteArray());
    }
}

