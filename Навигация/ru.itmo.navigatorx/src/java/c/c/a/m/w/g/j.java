/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  c.c.a.m.o
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.util.List
 */
package c.c.a.m.w.g;

import android.util.Log;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.c0.b;
import c.c.a.m.u.w;
import c.c.a.m.w.g.c;
import c.c.a.m.w.g.i;
import com.bumptech.glide.load.ImageHeaderParser;
import f.b.k.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j
implements q<InputStream, c> {
    public final List<ImageHeaderParser> a;
    public final q<ByteBuffer, c> b;
    public final b c;

    public j(List<ImageHeaderParser> list, q<ByteBuffer, c> q2, b b2) {
        this.a = list;
        this.b = q2;
        this.c = b2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public w a(Object object, int n2, int n3, o o2) {
        InputStream inputStream = (InputStream)object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            int n4;
            byte[] arrby = new byte[16384];
            while ((n4 = inputStream.read(arrby)) != -1) {
                byteArrayOutputStream.write(arrby, 0, n4);
            }
        }
        catch (IOException iOException) {
            if (!Log.isLoggable((String)"StreamGifDecoder", (int)5)) return null;
            Log.w((String)"StreamGifDecoder", (String)"Error reading data from stream", (Throwable)iOException);
            return null;
        }
        byteArrayOutputStream.flush();
        byte[] arrby = byteArrayOutputStream.toByteArray();
        if (arrby == null) {
            return null;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(arrby);
        return this.b.a(byteBuffer, n2, n3, o2);
    }

    @Override
    public boolean b(Object object, o o2) {
        InputStream inputStream = (InputStream)object;
        return (Boolean)o2.c(i.b) == false && h.i.w0(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}

