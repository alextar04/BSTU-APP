/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Set
 */
package c.c.a.m.u.c0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.c0.k;
import c.c.a.m.u.c0.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class j
implements d {
    public static final Bitmap.Config j = Bitmap.Config.ARGB_8888;
    public final k a;
    public final Set<Bitmap.Config> b;
    public final a c;
    public long d;
    public long e;
    public int f;
    public int g;
    public int h;
    public int i;

    public j(long l2) {
        m m2 = new m();
        HashSet hashSet = new HashSet((Collection)Arrays.asList((Object[])Bitmap.Config.values()));
        hashSet.add(null);
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove((Object)Bitmap.Config.HARDWARE);
        }
        Set set = Collections.unmodifiableSet((Set)hashSet);
        this.d = l2;
        this.a = m2;
        this.b = set;
        this.c = new b();
    }

    @SuppressLint(value={"InlinedApi"})
    @Override
    public void a(int n2) {
        if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trimMemory, level=");
            stringBuilder.append(n2);
            Log.d((String)"LruBitmapPool", (String)stringBuilder.toString());
        }
        if (n2 < 40 && n2 < 20) {
            if (n2 >= 20 || n2 == 15) {
                this.i(this.d / 2L);
                return;
            }
        } else {
            if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
                Log.d((String)"LruBitmapPool", (String)"clearMemory");
            }
            this.i(0L);
        }
    }

    @Override
    public Bitmap b(int n2, int n3, Bitmap.Config config) {
        Bitmap bitmap = this.h(n2, n3, config);
        if (bitmap != null) {
            bitmap.eraseColor(0);
            return bitmap;
        }
        if (config == null) {
            config = j;
        }
        return Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)config);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void c(Bitmap bitmap) {
        j j2 = this;
        // MONITORENTER : j2
        if (bitmap == null) throw new NullPointerException("Bitmap must not be null");
        if (bitmap.isRecycled()) throw new IllegalStateException("Cannot pool recycled bitmap");
        if (bitmap.isMutable() && (long)this.a.a(bitmap) <= this.d && this.b.contains((Object)bitmap.getConfig())) {
            int n2 = this.a.a(bitmap);
            this.a.c(bitmap);
            if ((b)this.c == null) throw null;
            this.h = 1 + this.h;
            this.e += (long)n2;
            if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Put bitmap in pool=");
                stringBuilder.append(this.a.f(bitmap));
                Log.v((String)"LruBitmapPool", (String)stringBuilder.toString());
            }
            this.f();
            this.i(this.d);
            // MONITOREXIT : j2
            return;
        }
        if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reject bitmap from pool, bitmap: ");
            stringBuilder.append(this.a.f(bitmap));
            stringBuilder.append(", is mutable: ");
            stringBuilder.append(bitmap.isMutable());
            stringBuilder.append(", is allowed config: ");
            stringBuilder.append(this.b.contains((Object)bitmap.getConfig()));
            Log.v((String)"LruBitmapPool", (String)stringBuilder.toString());
        }
        bitmap.recycle();
        // MONITOREXIT : j2
        return;
    }

    @Override
    public void d() {
        if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
            Log.d((String)"LruBitmapPool", (String)"clearMemory");
        }
        this.i(0L);
    }

    @Override
    public Bitmap e(int n2, int n3, Bitmap.Config config) {
        Bitmap bitmap = this.h(n2, n3, config);
        if (bitmap == null) {
            if (config == null) {
                config = j;
            }
            bitmap = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)config);
        }
        return bitmap;
    }

    public final void f() {
        if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
            this.g();
        }
    }

    public final void g() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Hits=");
        stringBuilder.append(this.f);
        stringBuilder.append(", misses=");
        stringBuilder.append(this.g);
        stringBuilder.append(", puts=");
        stringBuilder.append(this.h);
        stringBuilder.append(", evictions=");
        stringBuilder.append(this.i);
        stringBuilder.append(", currentSize=");
        stringBuilder.append(this.e);
        stringBuilder.append(", maxSize=");
        stringBuilder.append(this.d);
        stringBuilder.append("\nStrategy=");
        stringBuilder.append((Object)this.a);
        Log.v((String)"LruBitmapPool", (String)stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Bitmap h(int n2, int n3, Bitmap.Config config) {
        j j2 = this;
        synchronized (j2) {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot create a mutable Bitmap with config: ");
                stringBuilder.append((Object)config);
                stringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            k k2 = this.a;
            Bitmap.Config config2 = config != null ? config : j;
            Bitmap bitmap = k2.b(n2, n3, config2);
            if (bitmap == null) {
                if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Missing bitmap=");
                    stringBuilder.append(this.a.e(n2, n3, config));
                    Log.d((String)"LruBitmapPool", (String)stringBuilder.toString());
                }
                this.g = 1 + this.g;
            } else {
                this.f = 1 + this.f;
                this.e -= (long)this.a.a(bitmap);
                if ((b)this.c == null) {
                    throw null;
                }
                bitmap.setHasAlpha(true);
                bitmap.setPremultiplied(true);
            }
            if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Get bitmap=");
                stringBuilder.append(this.a.e(n2, n3, config));
                Log.v((String)"LruBitmapPool", (String)stringBuilder.toString());
            }
            this.f();
            return bitmap;
        }
    }

    public final void i(long l2) {
        j j2 = this;
        synchronized (j2) {
            while (this.e > l2) {
                Bitmap bitmap = this.a.d();
                if (bitmap == null) {
                    if (Log.isLoggable((String)"LruBitmapPool", (int)5)) {
                        Log.w((String)"LruBitmapPool", (String)"Size mismatch, resetting");
                        this.g();
                    }
                    this.e = 0L;
                    return;
                }
                if ((b)this.c != null) {
                    this.e -= (long)this.a.a(bitmap);
                    this.i = 1 + this.i;
                    if (Log.isLoggable((String)"LruBitmapPool", (int)3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Evicting bitmap=");
                        stringBuilder.append(this.a.f(bitmap));
                        Log.d((String)"LruBitmapPool", (String)stringBuilder.toString());
                    }
                    this.f();
                    bitmap.recycle();
                    continue;
                }
                throw null;
            }
            return;
        }
    }

    public static final class b
    implements a {
    }

}

