/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  c.c.a.m.w.c.e
 *  c.c.a.m.w.c.k$a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.locks.Lock
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.w;
import c.c.a.m.w.c.e;
import c.c.a.m.w.c.k;
import c.c.a.m.w.c.v;
import java.util.concurrent.locks.Lock;

public final class k {
    public static final d a = new a();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static w<Bitmap> a(d d2, Drawable drawable, int n2, int n3) {
        boolean bl;
        Bitmap bitmap;
        block9 : {
            Lock lock;
            block11 : {
                Drawable drawable2;
                block13 : {
                    String string;
                    StringBuilder stringBuilder;
                    block12 : {
                        block10 : {
                            block8 : {
                                drawable2 = drawable.getCurrent();
                                if (!(drawable2 instanceof BitmapDrawable)) break block8;
                                bitmap = ((BitmapDrawable)drawable2).getBitmap();
                                bl = false;
                                break block9;
                            }
                            boolean bl2 = drawable2 instanceof Animatable;
                            bl = false;
                            bitmap = null;
                            if (bl2) break block9;
                            if (n2 != Integer.MIN_VALUE || drawable2.getIntrinsicWidth() > 0) break block10;
                            boolean bl3 = Log.isLoggable((String)"DrawableToBitmap", (int)5);
                            bitmap = null;
                            if (!bl3) break block11;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Unable to draw ");
                            stringBuilder.append((Object)drawable2);
                            string = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
                            break block12;
                        }
                        if (n3 != Integer.MIN_VALUE || drawable2.getIntrinsicHeight() > 0) break block13;
                        boolean bl4 = Log.isLoggable((String)"DrawableToBitmap", (int)5);
                        bitmap = null;
                        if (!bl4) break block11;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Unable to draw ");
                        stringBuilder.append((Object)drawable2);
                        string = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
                    }
                    stringBuilder.append(string);
                    Log.w((String)"DrawableToBitmap", (String)stringBuilder.toString());
                    bitmap = null;
                    break block11;
                }
                if (drawable2.getIntrinsicWidth() > 0) {
                    n2 = drawable2.getIntrinsicWidth();
                }
                if (drawable2.getIntrinsicHeight() > 0) {
                    n3 = drawable2.getIntrinsicHeight();
                }
                lock = v.d;
                lock.lock();
                Bitmap bitmap2 = d2.b(n2, n3, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap2);
                drawable2.setBounds(0, 0, n2, n3);
                drawable2.draw(canvas);
                canvas.setBitmap(null);
                bitmap = bitmap2;
            }
            bl = true;
            break block9;
            finally {
                lock.unlock();
            }
        }
        if (bl) {
            return e.f((Bitmap)bitmap, (d)d2);
        }
        d2 = a;
        return e.f((Bitmap)bitmap, (d)d2);
    }
}

