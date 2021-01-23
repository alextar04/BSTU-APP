/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NavigableMap
 *  java.util.Set
 *  java.util.TreeMap
 */
package c.c.a.m.u.c0;

import android.graphics.Bitmap;
import android.os.Build;
import c.c.a.m.u.c0.g;
import c.c.a.m.u.c0.k;
import c.c.a.m.u.c0.l;
import c.c.a.m.u.c0.m;
import c.c.a.s.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class m
implements k {
    public static final Bitmap.Config[] d;
    public static final Bitmap.Config[] e;
    public static final Bitmap.Config[] f;
    public static final Bitmap.Config[] g;
    public static final Bitmap.Config[] h;
    public final c a = new c();
    public final g<b, Bitmap> b = new g();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();

    public static {
        Object[] arrobject = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            arrobject = (Bitmap.Config[])Arrays.copyOf((Object[])arrobject, (int)3);
            arrobject[arrobject.length - 1] = Bitmap.Config.RGBA_F16;
        }
        d = arrobject;
        e = arrobject;
        Bitmap.Config[] arrconfig = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f = arrconfig;
        Bitmap.Config[] arrconfig2 = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        g = arrconfig2;
        Bitmap.Config[] arrconfig3 = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
        h = arrconfig3;
    }

    public static String h(int n2, Bitmap.Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(n2);
        stringBuilder.append("](");
        stringBuilder.append((Object)config);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public int a(Bitmap bitmap) {
        return j.e(bitmap);
    }

    @Override
    public Bitmap b(int n2, int n3, Bitmap.Config config) {
        Bitmap bitmap;
        int n4;
        int n5 = j.d(n2, n3, config);
        b b2 = (b)this.a.b();
        b2.b = n5;
        b2.c = config;
        int n6 = Build.VERSION.SDK_INT;
        int n7 = 0;
        Bitmap.Config[] arrconfig = n6 >= 26 && Bitmap.Config.RGBA_F16.equals((Object)config) ? e : ((n4 = a.a[config.ordinal()]) != 1 ? (n4 != 2 ? (n4 != 3 ? (n4 != 4 ? new Bitmap.Config[]{config} : h) : g) : f) : d);
        int n8 = arrconfig.length;
        while (n7 < n8) {
            Bitmap.Config config2 = arrconfig[n7];
            Integer n9 = (Integer)this.i(config2).ceilingKey((Object)n5);
            if (n9 != null && n9 <= n5 * 8) {
                if (n9 == n5 && !(config2 == null ? config != null : !config2.equals((Object)config))) break;
                this.a.c(b2);
                b2 = this.a.d(n9, config2);
                break;
            }
            ++n7;
        }
        if ((bitmap = this.b.a(b2)) != null) {
            this.g(b2.b, bitmap);
            bitmap.reconfigure(n2, n3, config);
        }
        return bitmap;
    }

    @Override
    public void c(Bitmap bitmap) {
        int n2 = j.e(bitmap);
        b b2 = this.a.d(n2, bitmap.getConfig());
        this.b.b(b2, bitmap);
        NavigableMap<Integer, Integer> navigableMap = this.i(bitmap.getConfig());
        Integer n3 = (Integer)navigableMap.get((Object)b2.b);
        Integer n4 = b2.b;
        int n5 = 1;
        if (n3 != null) {
            n5 += n3.intValue();
        }
        navigableMap.put((Object)n4, (Object)n5);
    }

    @Override
    public Bitmap d() {
        Bitmap bitmap = this.b.c();
        if (bitmap != null) {
            this.g(j.e(bitmap), bitmap);
        }
        return bitmap;
    }

    @Override
    public String e(int n2, int n3, Bitmap.Config config) {
        return m.h(j.d(n2, n3, config), config);
    }

    @Override
    public String f(Bitmap bitmap) {
        return m.h(j.e(bitmap), bitmap.getConfig());
    }

    public final void g(Integer n2, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMap = this.i(bitmap.getConfig());
        Integer n3 = (Integer)navigableMap.get((Object)n2);
        if (n3 != null) {
            if (n3 == 1) {
                navigableMap.remove((Object)n2);
                return;
            }
            navigableMap.put((Object)n2, (Object)(n3 - 1));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tried to decrement empty size, size: ");
        stringBuilder.append((Object)n2);
        stringBuilder.append(", removed: ");
        stringBuilder.append(this.f(bitmap));
        stringBuilder.append(", this: ");
        stringBuilder.append((Object)this);
        throw new NullPointerException(stringBuilder.toString());
    }

    public final NavigableMap<Integer, Integer> i(Bitmap.Config config) {
        NavigableMap navigableMap = (NavigableMap)this.c.get((Object)config);
        if (navigableMap == null) {
            navigableMap = new TreeMap();
            this.c.put((Object)config, (Object)navigableMap);
        }
        return navigableMap;
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("SizeConfigStrategy{groupedMap=");
        stringBuilder.append(this.b);
        stringBuilder.append(", sortedSizes=(");
        for (Map.Entry entry : this.c.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append('[');
            stringBuilder.append(entry.getValue());
            stringBuilder.append("], ");
        }
        if (!this.c.isEmpty()) {
            stringBuilder.replace(-2 + stringBuilder.length(), stringBuilder.length(), "");
        }
        stringBuilder.append(")}");
        return stringBuilder.toString();
    }

    public static final class b
    implements l {
        public final c a;
        public int b;
        public Bitmap.Config c;

        public b(c c2) {
            this.a = c2;
        }

        @Override
        public void a() {
            this.a.c(this);
        }

        public boolean equals(Object object) {
            boolean bl = object instanceof b;
            boolean bl2 = false;
            if (bl) {
                b b2 = (b)object;
                int n2 = this.b;
                int n3 = b2.b;
                bl2 = false;
                if (n2 == n3) {
                    boolean bl3 = j.b((Object)this.c, (Object)b2.c);
                    bl2 = false;
                    if (bl3) {
                        bl2 = true;
                    }
                }
            }
            return bl2;
        }

        public int hashCode() {
            int n2 = 31 * this.b;
            Bitmap.Config config = this.c;
            int n3 = config != null ? config.hashCode() : 0;
            return n2 + n3;
        }

        public String toString() {
            return m.h(this.b, this.c);
        }
    }

    public static class c
    extends c.c.a.m.u.c0.c<b> {
        @Override
        public l a() {
            return new b(this);
        }

        public b d(int n2, Bitmap.Config config) {
            b b2 = (b)this.b();
            b2.b = n2;
            b2.c = config;
            return b2;
        }
    }

}

