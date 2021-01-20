/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Looper
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Queue
 */
package c.c.a.s;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import c.c.a.m.v.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class j {
    public static final char[] a = "0123456789abcdef".toCharArray();
    public static final char[] b = new char[64];

    public static boolean a(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        if (object instanceof l) {
            return ((l)object).a(object2);
        }
        return object.equals(object2);
    }

    public static boolean b(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static <T> Queue<T> c(int n2) {
        return new ArrayDeque(n2);
    }

    public static int d(int n2, int n3, Bitmap.Config config) {
        int n4 = n2 * n3;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int n5 = a.a[config.ordinal()];
        int n6 = 4;
        if (n5 != 1) {
            if (n5 != 2 && n5 != 3) {
                if (n5 == n6) {
                    n6 = 8;
                }
            } else {
                n6 = 2;
            }
        } else {
            n6 = 1;
        }
        return n4 * n6;
    }

    @TargetApi(value=19)
    public static int e(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                int n2 = bitmap.getAllocationByteCount();
                return n2;
            }
            catch (NullPointerException nullPointerException) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot obtain size for recycled Bitmap: ");
        stringBuilder.append((Object)bitmap);
        stringBuilder.append("[");
        stringBuilder.append(bitmap.getWidth());
        stringBuilder.append("x");
        stringBuilder.append(bitmap.getHeight());
        stringBuilder.append("] ");
        stringBuilder.append((Object)bitmap.getConfig());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public static <T> List<T> f(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object object : collection) {
            if (object == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public static int g(float f2) {
        return 527 + Float.floatToIntBits((float)f2);
    }

    public static int h(Object object, int n2) {
        int n3 = object == null ? 0 : object.hashCode();
        return n3 + n2 * 31;
    }

    public static boolean i() {
        return true ^ j.j();
    }

    public static boolean j() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean k(int n2, int n3) {
        boolean bl = n2 > 0 || n2 == Integer.MIN_VALUE;
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = n3 > 0 || n3 == Integer.MIN_VALUE;
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String l(byte[] arrby) {
        char[] arrc;
        char[] arrc2 = arrc = b;
        synchronized (arrc2) {
            char[] arrc3 = b;
            int n2 = 0;
            while (n2 < arrby.length) {
                int n3 = 255 & arrby[n2];
                int n4 = n2 * 2;
                char[] arrc4 = a;
                arrc3[n4] = arrc4[n3 >>> 4];
                arrc3[n4 + 1] = arrc4[n3 & 15];
                ++n2;
            }
            return new String(arrc3);
        }
    }

}

