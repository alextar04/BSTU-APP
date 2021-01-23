/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.graphics.Bitmap
 *  android.media.MediaDataSource
 *  android.media.MediaMetadataRetriever
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  c.c.a.m.o
 *  java.io.FileDescriptor
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.security.MessageDigest
 */
package c.c.a.m.w.c;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.w;
import c.c.a.m.w.c.i;
import c.c.a.m.w.c.y;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class x<T>
implements q<T, Bitmap> {
    public static final n<Long> d = new n<Long>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new n.b<Long>(){
        public final ByteBuffer a = ByteBuffer.allocate((int)8);

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(byte[] arrby, Object object, MessageDigest messageDigest) {
            ByteBuffer byteBuffer;
            Long l2 = (Long)object;
            messageDigest.update(arrby);
            ByteBuffer byteBuffer2 = byteBuffer = this.a;
            synchronized (byteBuffer2) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l2.longValue()).array());
                return;
            }
        }
    });
    public static final n<Integer> e = new n<Integer>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new n.b<Integer>(){
        public final ByteBuffer a = ByteBuffer.allocate((int)4);

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(byte[] arrby, Object object, MessageDigest messageDigest) {
            ByteBuffer byteBuffer;
            Integer n2 = (Integer)object;
            if (n2 == null) {
                return;
            }
            messageDigest.update(arrby);
            ByteBuffer byteBuffer2 = byteBuffer = this.a;
            synchronized (byteBuffer2) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(n2.intValue()).array());
                return;
            }
        }
    });
    public static final e f = new Object(){};
    public final f<T> a;
    public final c.c.a.m.u.c0.d b;
    public final e c;

    public x(c.c.a.m.u.c0.d d2, f<T> f2) {
        e e2 = f;
        this.b = d2;
        this.a = f2;
        this.c = e2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap c(MediaMetadataRetriever mediaMetadataRetriever, long l2, int n2, int n3, int n4, i i2) {
        Bitmap bitmap;
        block6 : {
            int n5;
            int n6;
            block3 : {
                block4 : {
                    block5 : {
                        if (Build.VERSION.SDK_INT >= 27 && n3 != Integer.MIN_VALUE && n4 != Integer.MIN_VALUE && i2 != i.c) {
                            try {
                                n6 = Integer.parseInt((String)mediaMetadataRetriever.extractMetadata(18));
                                n5 = Integer.parseInt((String)mediaMetadataRetriever.extractMetadata(19));
                                int n7 = Integer.parseInt((String)mediaMetadataRetriever.extractMetadata(24));
                                if (n7 != 90 && n7 != 270) break block3;
                                break block4;
                            }
                            catch (Throwable throwable) {
                                if (!Log.isLoggable((String)"VideoDecoder", (int)3)) break block5;
                                Log.d((String)"VideoDecoder", (String)"Exception trying to decode frame on oreo+", (Throwable)throwable);
                            }
                        }
                    }
                    bitmap = null;
                    break block6;
                }
                int n8 = n5;
                n5 = n6;
                n6 = n8;
            }
            float f2 = i2.b(n6, n5, n3, n4);
            bitmap = mediaMetadataRetriever.getScaledFrameAtTime(l2, n2, Math.round((float)(f2 * (float)n6)), Math.round((float)(f2 * (float)n5)));
        }
        if (bitmap != null) return bitmap;
        return mediaMetadataRetriever.getFrameAtTime(l2, n2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public w<Bitmap> a(T t2, int n2, int n3, o o2) {
        Integer n4;
        i i2;
        Throwable throwable2222;
        long l2 = (Long)o2.c(d);
        if (l2 < 0L) {
            if (l2 != -1L) throw new IllegalArgumentException(c.b.a.a.a.f("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", l2));
        }
        if ((n4 = (Integer)o2.c(e)) == null) {
            n4 = 2;
        }
        if ((i2 = (i)o2.c(i.e)) == null) {
            i2 = i.d;
        }
        i i3 = i2;
        if (this.c == null) throw null;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        this.a.a(mediaMetadataRetriever, t2);
        Bitmap bitmap = x.c(mediaMetadataRetriever, l2, n4, n2, n3, i3);
        mediaMetadataRetriever.release();
        return c.c.a.m.w.c.e.f(bitmap, this.b);
        {
            catch (Throwable throwable2222) {
            }
            catch (RuntimeException runtimeException) {}
            {
                throw new IOException((Throwable)runtimeException);
            }
        }
        mediaMetadataRetriever.release();
        throw throwable2222;
    }

    @Override
    public boolean b(T t2, o o2) {
        return true;
    }

    public static final class c
    implements f<AssetFileDescriptor> {
        public c(a a2) {
        }

        @Override
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object object) {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor)object;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    public static final class d
    implements f<ByteBuffer> {
        @Override
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object object) {
            mediaMetadataRetriever.setDataSource((MediaDataSource)new y(this, (ByteBuffer)object));
        }
    }

    public static final class g
    implements f<ParcelFileDescriptor> {
        @Override
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object object) {
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor)object).getFileDescriptor());
        }
    }

}

