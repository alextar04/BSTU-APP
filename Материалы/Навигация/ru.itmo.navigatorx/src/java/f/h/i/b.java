/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.CancellationSignal
 *  android.os.Handler
 *  c.b.a.a.a
 *  f.b.k.h
 *  f.h.i.b$b
 *  f.h.i.b$c
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Callable
 */
package f.h.i;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import f.b.k.h;
import f.e.h;
import f.h.f.j;
import f.h.i.b;
import f.h.i.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class b {
    public static final f.e.f<String, Typeface> a = new f.e.f(16);
    public static final f.h.i.c b = new f.h.i.c("fonts", 10, 10000);
    public static final Object c = new Object();
    public static final h<String, ArrayList<c.c<g>>> d = new h();
    public static final Comparator<byte[]> e = new Comparator<byte[]>(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int compare(Object object, Object object2) {
            int n2;
            int n3;
            byte[] arrby = (byte[])object;
            byte[] arrby2 = (byte[])object2;
            if (arrby.length != arrby2.length) {
                n3 = arrby.length;
                n2 = arrby2.length;
                return n3 - n2;
            }
            for (int i2 = 0; i2 < arrby.length; ++i2) {
                if (arrby[i2] == arrby2[i2]) continue;
                n3 = arrby[i2];
                n2 = arrby2[i2];
                return n3 - n2;
            }
            return 0;
        }
    };

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static e a(Context var0, CancellationSignal var1_1, f.h.i.a var2_2) {
        var3_3 = var0.getPackageManager();
        var4_4 = var0.getResources();
        var5_5 = var2_2.a;
        var6_6 = var3_3.resolveContentProvider(var5_5, 0);
        if (var6_6 == null) throw new PackageManager.NameNotFoundException(c.b.a.a.a.j((String)"No package found for authority: ", (String)var5_5));
        if (!var6_6.packageName.equals((Object)var2_2.b)) {
            var7_39 = new StringBuilder();
            var7_39.append("Found content provider ");
            var7_39.append(var5_5);
            var7_39.append(", but package was not ");
            var7_39.append(var2_2.b);
            throw new PackageManager.NameNotFoundException(var7_39.toString());
        }
        var12_7 = var3_3.getPackageInfo((String)var6_6.packageName, (int)64).signatures;
        var13_8 = new ArrayList();
        for (var14_9 = 0; var14_9 < var12_7.length; ++var14_9) {
            var13_8.add((Object)var12_7[var14_9].toByteArray());
        }
        Collections.sort((List)var13_8, b.e);
        var15_10 = var2_2.d;
        if (var15_10 == null) {
            var15_10 = h.i.o1(var4_4, var2_2.e);
        }
        var16_11 = 0;
        do {
            block10 : {
                block12 : {
                    block11 : {
                        var17_12 = var15_10.size();
                        var18_13 = null;
                        if (var16_11 >= var17_12) break block11;
                        var19_14 = new ArrayList((Collection)var15_10.get(var16_11));
                        Collections.sort((List)var19_14, b.e);
                        if (var13_8.size() != var19_14.size()) ** GOTO lbl37
                        break block12;
                    }
                    var6_6 = null;
                    break;
                }
                for (var20_15 = 0; var20_15 < var13_8.size(); ++var20_15) {
                    if (Arrays.equals((byte[])((byte[])var13_8.get(var20_15)), (byte[])((byte[])var19_14.get(var20_15)))) continue;
lbl37: // 2 sources:
                    var21_16 = false;
                    break block10;
                }
                var21_16 = true;
            }
            if (var21_16) break;
            ++var16_11;
        } while (true);
        if (var6_6 == null) {
            return new e(1, null);
        }
        var22_17 = var6_6.authority;
        var23_18 = new ArrayList();
        var24_19 = new Uri.Builder().scheme("content").authority(var22_17).build();
        var25_20 = new Uri.Builder().scheme("content").authority(var22_17).appendPath("file").build();
        try {
            var27_21 = var0.getContentResolver();
            var28_22 = new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            var29_23 = new String[]{var2_2.c};
            var18_13 = var27_21.query(var24_19, var28_22, "query = ?", var29_23, null, null);
            if (var18_13 != null && var18_13.getCount() > 0) {
                var30_24 = var18_13.getColumnIndex("result_code");
                var23_18 = new ArrayList();
                var31_25 = var18_13.getColumnIndex("_id");
                var32_26 = var18_13.getColumnIndex("file_id");
                var33_27 = var18_13.getColumnIndex("font_ttc_index");
                var34_28 = var18_13.getColumnIndex("font_weight");
                var35_29 = var18_13.getColumnIndex("font_italic");
                while (var18_13.moveToNext()) {
                    var36_30 = var30_24 != -1 ? var18_13.getInt(var30_24) : 0;
                    var37_31 = var33_27 != -1 ? var18_13.getInt(var33_27) : 0;
                    var38_32 = var32_26 == -1 ? ContentUris.withAppendedId((Uri)var24_19, (long)var18_13.getLong(var31_25)) : ContentUris.withAppendedId((Uri)var25_20, (long)var18_13.getLong(var32_26));
                    var39_33 = var38_32;
                    var40_34 = var34_28 != -1 ? var18_13.getInt(var34_28) : 400;
                    var41_35 = var40_34;
                    var42_36 = var35_29 != -1 && var18_13.getInt(var35_29) == 1;
                    var43_37 = new f(var39_33, var37_31, var41_35, var42_36, var36_30);
                    var23_18.add((Object)var43_37);
                }
            }
            if (var18_13 == null) return new e(0, (f[])var23_18.toArray((Object[])new f[0]));
        }
        catch (Throwable var26_38) {
            if (var18_13 == null) throw var26_38;
            var18_13.close();
            throw var26_38;
        }
        var18_13.close();
        return new e(0, (f[])var23_18.toArray((Object[])new f[0]));
    }

    public static g b(Context context, f.h.i.a a2, int n2) {
        int n3;
        int n4;
        block4 : {
            e e2;
            try {
                e2 = b.a(context, null, a2);
                n4 = e2.a;
                n3 = -3;
                if (n4 != 0) break block4;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                return new g(null, -1);
            }
            f[] arrf = e2.b;
            Typeface typeface = f.h.f.d.a.b(context, null, arrf, n2);
            if (typeface != null) {
                n3 = 0;
            }
            return new g(typeface, n3);
        }
        if (n4 == 1) {
            n3 = -2;
        }
        return new g(null, n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Typeface c(Context context, final f.h.i.a a2, f.h.e.b.g g2, Handler handler, boolean bl, int n2, final int n3) {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a2.f);
        stringBuilder.append("-");
        stringBuilder.append(n3);
        final String string = stringBuilder.toString();
        Typeface typeface = a.a(string);
        if (typeface != null) {
            if (g2 == null) return typeface;
            g2.d(typeface);
            return typeface;
        }
        if (bl && n2 == -1) {
            g g3 = b.b(context, a2, n3);
            if (g2 == null) return g3.a;
            int n4 = g3.b;
            if (n4 == 0) {
                g2.b(g3.a, handler);
                return g3.a;
            }
            g2.a(n4, handler);
            return g3.a;
        }
        Callable<g> callable = new Callable<g>(){

            public Object call() {
                g g2 = b.b(Context.this, a2, n3);
                Typeface typeface = g2.a;
                if (typeface != null) {
                    b.a.b(string, typeface);
                }
                return g2;
            }
        };
        Typeface typeface2 = null;
        if (bl) {
            try {
                return b.b.b(callable, (int)n2).a;
            }
            catch (InterruptedException interruptedException) {}
            return typeface2;
        }
        b b2 = g2 == null ? null : new b(g2, handler);
        Object object2 = object = c;
        synchronized (object2) {
            ArrayList arrayList = d.getOrDefault(string, null);
            if (arrayList != null) {
                if (b2 == null) return null;
                arrayList.add((Object)b2);
                return null;
            }
            if (b2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add((Object)b2);
                d.put(string, (ArrayList<c.c<g>>)arrayList2);
            }
        }
        f.h.i.c c2 = b;
        c c3 = new c(string);
        if (c2 == null) throw null;
        c2.a(new f.h.i.d(c2, (Callable)callable, new Handler(), (c.c)c3));
        return null;
    }

    public static Map<Uri, ByteBuffer> d(Context context, f[] arrf, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f f2 : arrf) {
            Uri uri;
            if (f2.e != 0 || hashMap.containsKey((Object)(uri = f2.a))) continue;
            hashMap.put((Object)uri, (Object)h.i.Z0(context, cancellationSignal, uri));
        }
        return Collections.unmodifiableMap((Map)hashMap);
    }

    public static class e {
        public final int a;
        public final f[] b;

        public e(int n2, f[] arrf) {
            this.a = n2;
            this.b = arrf;
        }
    }

    public static class f {
        public final Uri a;
        public final int b;
        public final int c;
        public final boolean d;
        public final int e;

        public f(Uri uri, int n2, int n3, boolean bl, int n4) {
            if (uri != null) {
                this.a = uri;
                this.b = n2;
                this.c = n3;
                this.d = bl;
                this.e = n4;
                return;
            }
            throw null;
        }
    }

    public static final class g {
        public final Typeface a;
        public final int b;

        public g(Typeface typeface, int n2) {
            this.a = typeface;
            this.b = n2;
        }
    }

}

