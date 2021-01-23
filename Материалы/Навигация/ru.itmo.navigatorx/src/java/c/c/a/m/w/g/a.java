/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 *  c.c.a.l.e
 *  c.c.a.m.g
 *  c.c.a.m.o
 *  c.c.a.m.s
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.Arrays
 *  java.util.List
 *  java.util.Queue
 */
package c.c.a.m.w.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import c.c.a.l.a;
import c.c.a.m.g;
import c.c.a.m.l;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.s;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.w;
import c.c.a.m.w.g.c;
import c.c.a.m.w.g.e;
import c.c.a.m.w.g.i;
import c.c.a.s.f;
import c.c.a.s.j;
import com.bumptech.glide.load.ImageHeaderParser;
import f.b.k.h;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class a
implements q<ByteBuffer, c> {
    public static final a f = new Object(){};
    public static final b g = new Object(){
        public final Queue<c.c.a.l.d> a = j.c(0);

        public void a(c.c.a.l.d d2) {
            b b2 = this;
            synchronized (b2) {
                d2.b = null;
                d2.c = null;
                this.a.offer((Object)d2);
                return;
            }
        }
    };
    public final Context a;
    public final List<ImageHeaderParser> b;
    public final b c;
    public final a d;
    public final c.c.a.m.w.g.b e;

    public a(Context context, List<ImageHeaderParser> list, d d2, c.c.a.m.u.c0.b b2) {
        b b3 = g;
        a a2 = f;
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = a2;
        this.e = new c.c.a.m.w.g.b(d2, b2);
        this.c = b3;
    }

    public static int d(c.c.a.l.c c2, int n2, int n3) {
        int n4 = Math.min((int)(c2.g / n3), (int)(c2.f / n2));
        int n5 = n4 == 0 ? 0 : Integer.highestOneBit((int)n4);
        int n6 = Math.max((int)1, (int)n5);
        if (Log.isLoggable((String)"BufferGifDecoder", (int)2) && n6 > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Downsampling GIF, sampleSize: ");
            stringBuilder.append(n6);
            stringBuilder.append(", target dimens: [");
            stringBuilder.append(n2);
            stringBuilder.append("x");
            stringBuilder.append(n3);
            stringBuilder.append("], actual dimens: [");
            stringBuilder.append(c2.f);
            stringBuilder.append("x");
            stringBuilder.append(c2.g);
            stringBuilder.append("]");
            Log.v((String)"BufferGifDecoder", (String)stringBuilder.toString());
        }
        return n6;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public w a(Object object, int n2, int n3, o o2) {
        c.c.a.l.d d2;
        b b2;
        ByteBuffer byteBuffer = (ByteBuffer)object;
        b b3 = b2 = this.c;
        synchronized (b3) {
            ByteBuffer byteBuffer2;
            c.c.a.l.d d3 = (c.c.a.l.d)b2.a.poll();
            if (d3 == null) {
                d3 = new c.c.a.l.d();
            }
            d2 = d3;
            d2.b = null;
            Arrays.fill((byte[])d2.a, (byte)0);
            d2.c = new c.c.a.l.c();
            d2.d = 0;
            d2.b = byteBuffer2 = byteBuffer.asReadOnlyBuffer();
            byteBuffer2.position(0);
            d2.b.order(ByteOrder.LITTLE_ENDIAN);
        }
        try {
            e e2 = this.c(byteBuffer, n2, n3, d2, o2);
            return e2;
        }
        finally {
            this.c.a(d2);
        }
    }

    @Override
    public boolean b(Object object, o o2) {
        ByteBuffer byteBuffer = (ByteBuffer)object;
        if (!((Boolean)o2.c(i.b)).booleanValue()) {
            List<ImageHeaderParser> list = this.b;
            ImageHeaderParser.ImageType imageType = byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h.i.x0(list, (l)new g(byteBuffer));
            if (imageType == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    public final e c(ByteBuffer byteBuffer, int n2, int n3, c.c.a.l.d d2, o o2) {
        long l2;
        block9 : {
            block10 : {
                Bitmap bitmap;
                c.c.a.l.e e2;
                block11 : {
                    l2 = f.b();
                    c.c.a.l.c c2 = d2.b();
                    if (c2.c <= 0 || c2.b != 0) break block9;
                    Bitmap.Config config = o2.c(i.a) == c.c.a.m.b.f ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    int n4 = a.d(c2, n2, n3);
                    a a2 = this.d;
                    c.c.a.m.w.g.b b2 = this.e;
                    if (a2 == null) break block10;
                    e2 = new c.c.a.l.e((a.a)b2, c2, byteBuffer, n4);
                    e2.j(config);
                    e2.k = (1 + e2.k) % e2.l.c;
                    bitmap = e2.c();
                    if (bitmap != null) break block11;
                    if (Log.isLoggable((String)"BufferGifDecoder", (int)2)) {
                        StringBuilder stringBuilder = c.b.a.a.a.c("Decoded GIF from stream in ");
                        stringBuilder.append(f.a(l2));
                        Log.v((String)"BufferGifDecoder", (String)stringBuilder.toString());
                    }
                    return null;
                }
                c.c.a.m.w.b b3 = (c.c.a.m.w.b)c.c.a.m.w.b.b;
                c c3 = new c(this.a, (c.c.a.l.a)e2, b3, n2, n3, bitmap);
                e e3 = new e(c3);
                return e3;
            }
            throw null;
        }
        if (Log.isLoggable((String)"BufferGifDecoder", (int)2)) {
            StringBuilder stringBuilder = c.b.a.a.a.c("Decoded GIF from stream in ");
            stringBuilder.append(f.a(l2));
            Log.v((String)"BufferGifDecoder", (String)stringBuilder.toString());
        }
        return null;
        finally {
            if (Log.isLoggable((String)"BufferGifDecoder", (int)2)) {
                StringBuilder stringBuilder = c.b.a.a.a.c("Decoded GIF from stream in ");
                stringBuilder.append(f.a(l2));
                Log.v((String)"BufferGifDecoder", (String)stringBuilder.toString());
            }
        }
    }

}

