/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.CancellationSignal
 *  f.b.k.h
 *  f.h.e.b.c
 *  f.h.f.j$a
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.ConcurrentHashMap
 */
package f.h.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import f.b.k.h;
import f.h.e.b.c;
import f.h.f.j;
import f.h.i.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

public class j {
    public ConcurrentHashMap<Long, c> a = new ConcurrentHashMap();

    public static <T> T e(T[] arrT, int n2, b<T> b2) {
        int n3 = (n2 & 1) == 0 ? 400 : 700;
        boolean bl = (n2 & 2) != 0;
        T t2 = null;
        int n4 = Integer.MAX_VALUE;
        for (T t3 : arrT) {
            int n5 = 2 * Math.abs((int)(b2.a(t3) - n3));
            int n6 = b2.b(t3) == bl ? 0 : 1;
            int n7 = n5 + n6;
            if (t2 != null && n4 <= n7) continue;
            t2 = t3;
            n4 = n7;
        }
        return t2;
    }

    public abstract Typeface a(Context var1, c var2, Resources var3, int var4);

    public abstract Typeface b(Context var1, CancellationSignal var2, b.f[] var3, int var4);

    public Typeface c(Context context, InputStream inputStream) {
        File file;
        block6 : {
            file = h.i.u0(context);
            if (file == null) {
                return null;
            }
            boolean bl = h.i.F(file, inputStream);
            if (bl) break block6;
            file.delete();
            return null;
        }
        try {
            Typeface typeface = Typeface.createFromFile((String)file.getPath());
            return typeface;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            file.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int n2, String string, int n3) {
        File file;
        block6 : {
            file = h.i.u0(context);
            if (file == null) {
                return null;
            }
            boolean bl = h.i.E(file, resources, n2);
            if (bl) break block6;
            file.delete();
            return null;
        }
        try {
            Typeface typeface = Typeface.createFromFile((String)file.getPath());
            return typeface;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            file.delete();
        }
    }

    public b.f f(b.f[] arrf, int n2) {
        return j.e(arrf, n2, new a(this));
    }

    public static interface b<T> {
        public int a(T var1);

        public boolean b(T var1);
    }

}

