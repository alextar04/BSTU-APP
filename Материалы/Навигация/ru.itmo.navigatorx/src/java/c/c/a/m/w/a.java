/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.ImageDecoder
 *  android.graphics.ImageDecoder$OnHeaderDecodedListener
 *  android.graphics.ImageDecoder$Source
 *  android.util.Log
 *  c.c.a.m.o
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.m.w;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import c.c.a.m.b;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.p;
import c.c.a.m.q;
import c.c.a.m.u.w;
import c.c.a.m.w.a;
import c.c.a.m.w.c.d;
import c.c.a.m.w.c.e;
import c.c.a.m.w.c.i;
import c.c.a.m.w.c.j;

public abstract class a<T>
implements q<ImageDecoder.Source, T> {
    public final c.c.a.m.w.c.n a = c.c.a.m.w.c.n.a();

    @Override
    public boolean b(Object object, o o2) {
        (ImageDecoder.Source)object;
        return true;
    }

    public final w<T> c(ImageDecoder.Source source, int n2, int n3, o o2) {
        b b2 = (b)((Object)o2.c(j.f));
        i i2 = (i)o2.c(i.e);
        boolean bl = o2.c(j.i) != null && (Boolean)o2.c(j.i) != false;
        boolean bl2 = bl;
        p p2 = (p)((Object)o2.c(j.g));
        ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener = new ImageDecoder.OnHeaderDecodedListener(this, n2, n3, bl2, b2, i2, p2){
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ b d;
            public final /* synthetic */ i e;
            public final /* synthetic */ p f;
            public final /* synthetic */ a g;
            {
                this.g = a2;
                this.a = n2;
                this.b = n3;
                this.c = bl;
                this.d = b2;
                this.e = i2;
                this.f = p2;
            }

            @android.annotation.SuppressLint(value={"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, android.graphics.ImageDecoder$ImageInfo imageInfo, ImageDecoder.Source source) {
                block15 : {
                    android.graphics.ColorSpace$Named named;
                    block14 : {
                        block13 : {
                            int n2;
                            block12 : {
                                int n3;
                                if (this.g.a.b(this.a, this.b, this.c, false)) {
                                    imageDecoder.setAllocator(3);
                                } else {
                                    imageDecoder.setAllocator(1);
                                }
                                if (this.d == b.f) {
                                    imageDecoder.setMemorySizePolicy(0);
                                }
                                imageDecoder.setOnPartialImageListener(new android.graphics.ImageDecoder$OnPartialImageListener(this){

                                    public boolean onPartialImage(android.graphics.ImageDecoder$DecodeException decodeException) {
                                        return false;
                                    }
                                });
                                android.util.Size size = imageInfo.getSize();
                                int n4 = this.a;
                                if (n4 == Integer.MIN_VALUE) {
                                    n4 = size.getWidth();
                                }
                                if ((n3 = this.b) == Integer.MIN_VALUE) {
                                    n3 = size.getHeight();
                                }
                                float f2 = this.e.b(size.getWidth(), size.getHeight(), n4, n3);
                                int n5 = java.lang.Math.round((float)(f2 * (float)size.getWidth()));
                                int n6 = java.lang.Math.round((float)(f2 * (float)size.getHeight()));
                                if (Log.isLoggable((String)"ImageDecoder", (int)2)) {
                                    StringBuilder stringBuilder = c.b.a.a.a.c("Resizing from [");
                                    stringBuilder.append(size.getWidth());
                                    stringBuilder.append("x");
                                    stringBuilder.append(size.getHeight());
                                    stringBuilder.append("] to [");
                                    stringBuilder.append(n5);
                                    stringBuilder.append("x");
                                    stringBuilder.append(n6);
                                    stringBuilder.append("] scaleFactor: ");
                                    stringBuilder.append(f2);
                                    Log.v((String)"ImageDecoder", (String)stringBuilder.toString());
                                }
                                imageDecoder.setTargetSize(n5, n6);
                                n2 = android.os.Build$VERSION.SDK_INT;
                                if (n2 < 28) break block12;
                                p p2 = this.f;
                                p p3 = p.f;
                                boolean bl = false;
                                if (p2 == p3) {
                                    android.graphics.ColorSpace colorSpace = imageInfo.getColorSpace();
                                    bl = false;
                                    if (colorSpace != null) {
                                        boolean bl2 = imageInfo.getColorSpace().isWideGamut();
                                        bl = false;
                                        if (bl2) {
                                            bl = true;
                                        }
                                    }
                                }
                                if (!bl) break block13;
                                named = android.graphics.ColorSpace$Named.DISPLAY_P3;
                                break block14;
                            }
                            if (n2 < 26) break block15;
                        }
                        named = android.graphics.ColorSpace$Named.SRGB;
                    }
                    imageDecoder.setTargetColorSpace(android.graphics.ColorSpace.get((android.graphics.ColorSpace$Named)named));
                }
            }
        };
        d d2 = (d)this;
        Bitmap bitmap = ImageDecoder.decodeBitmap((ImageDecoder.Source)source, (ImageDecoder.OnHeaderDecodedListener)onHeaderDecodedListener);
        if (Log.isLoggable((String)"BitmapImageDecoder", (int)2)) {
            StringBuilder stringBuilder = c.b.a.a.a.c("Decoded [");
            stringBuilder.append(bitmap.getWidth());
            stringBuilder.append("x");
            stringBuilder.append(bitmap.getHeight());
            stringBuilder.append("] for [");
            stringBuilder.append(n2);
            stringBuilder.append("x");
            stringBuilder.append(n3);
            stringBuilder.append("]");
            Log.v((String)"BitmapImageDecoder", (String)stringBuilder.toString());
        }
        return new e(bitmap, d2.b);
    }
}

