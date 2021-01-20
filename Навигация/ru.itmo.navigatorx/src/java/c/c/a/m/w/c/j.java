/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.ColorSpace
 *  android.graphics.ColorSpace$Named
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  c.c.a.m.o
 *  c.c.a.m.w.c.e
 *  c.c.a.m.w.c.j$a
 *  c.c.a.m.w.c.o$a
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  f.b.k.h
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.EnumSet
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Queue
 *  java.util.Set
 *  java.util.concurrent.locks.Lock
 */
package c.c.a.m.w.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.p;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.w;
import c.c.a.m.w.c.e;
import c.c.a.m.w.c.i;
import c.c.a.m.w.c.j;
import c.c.a.m.w.c.o;
import c.c.a.m.w.c.v;
import c.c.a.s.f;
import com.bumptech.glide.load.ImageHeaderParser;
import f.b.k.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/*
 * Exception performing whole class analysis.
 */
public final class j {
    public static final n<c.c.a.m.b> f;
    public static final n<p> g;
    public static final n<Boolean> h;
    public static final n<Boolean> i;
    public static final Set<String> j;
    public static final b k;
    public static final Set<ImageHeaderParser.ImageType> l;
    public static final Queue<BitmapFactory.Options> m;
    public final d a;
    public final DisplayMetrics b;
    public final c.c.a.m.u.c0.b c;
    public final List<ImageHeaderParser> d;
    public final c.c.a.m.w.c.n e;

    public static {
        f = n.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", c.c.a.m.b.g);
        g = n.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", p.e);
        h = n.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
        i = n.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);
        j = Collections.unmodifiableSet((Set)new HashSet((Collection)Arrays.asList((Object[])new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
        k = new a();
        l = Collections.unmodifiableSet((Set)EnumSet.of((Enum)ImageHeaderParser.ImageType.JPEG, (Enum)ImageHeaderParser.ImageType.PNG_A, (Enum)ImageHeaderParser.ImageType.PNG));
        m = c.c.a.s.j.c(0);
    }

    public j(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, d d2, c.c.a.m.u.c0.b b2) {
        this.e = c.c.a.m.w.c.n.a();
        this.d = list;
        h.i.p(displayMetrics, "Argument must not be null");
        this.b = displayMetrics;
        h.i.p(d2, "Argument must not be null");
        this.a = d2;
        h.i.p(b2, "Argument must not be null");
        this.c = b2;
    }

    /*
     * Exception decompiling
     */
    public static Bitmap d(c.c.a.m.w.c.o var0, BitmapFactory.Options var1_1, b var2_2, d var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Nonsensical loop would be emitted - failure
        // org.benf.cfr.reader.b.a.a.b.ab.a(LoopIdentifier.java:401)
        // org.benf.cfr.reader.b.a.a.b.ab.a(LoopIdentifier.java:62)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:537)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    @TargetApi(value=19)
    public static String e(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c(" (");
        stringBuilder.append(bitmap.getAllocationByteCount());
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        StringBuilder stringBuilder2 = c.b.a.a.a.c("[");
        stringBuilder2.append(bitmap.getWidth());
        stringBuilder2.append("x");
        stringBuilder2.append(bitmap.getHeight());
        stringBuilder2.append("] ");
        stringBuilder2.append((Object)bitmap.getConfig());
        stringBuilder2.append(string);
        return stringBuilder2.toString();
    }

    public static int f(double d2) {
        if (!(d2 <= 1.0)) {
            d2 = 1.0 / d2;
        }
        return (int)Math.round((double)(d2 * 2.147483647E9));
    }

    public static int[] g(c.c.a.m.w.c.o o2, BitmapFactory.Options options, b b2, d d2) {
        options.inJustDecodeBounds = true;
        j.d(o2, options, b2, d2);
        options.inJustDecodeBounds = false;
        int[] arrn = new int[]{options.outWidth, options.outHeight};
        return arrn;
    }

    public static boolean h(int n2) {
        return n2 == 90 || n2 == 270;
        {
        }
    }

    public static IOException i(IllegalArgumentException illegalArgumentException, int n2, int n3, String string, BitmapFactory.Options options) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception decoding bitmap, outWidth: ");
        stringBuilder.append(n2);
        stringBuilder.append(", outHeight: ");
        stringBuilder.append(n3);
        stringBuilder.append(", outMimeType: ");
        stringBuilder.append(string);
        stringBuilder.append(", inBitmap: ");
        stringBuilder.append(j.e(options.inBitmap));
        return new IOException(stringBuilder.toString(), (Throwable)illegalArgumentException);
    }

    public static void j(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int k(double d2) {
        return (int)(d2 + 0.5);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final w<Bitmap> a(c.c.a.m.w.c.o o2, int n2, int n3, o o3, b b2) {
        Queue<BitmapFactory.Options> queue;
        byte[] arrby = this.c.g(65536, byte[].class);
        Class<j> class_ = j.class;
        // MONITORENTER : c.c.a.m.w.c.j.class
        Queue<BitmapFactory.Options> queue2 = queue = m;
        // MONITORENTER : queue2
        BitmapFactory.Options options = (BitmapFactory.Options)m.poll();
        // MONITOREXIT : queue2
        if (options == null) {
            options = new BitmapFactory.Options();
            j.j(options);
        }
        BitmapFactory.Options options2 = options;
        // MONITOREXIT : class_
        options2.inTempStorage = arrby;
        c.c.a.m.b b3 = (c.c.a.m.b)((Object)o3.c(f));
        p p2 = (p)((Object)o3.c(g));
        i i2 = (i)o3.c(i.e);
        boolean bl = (Boolean)o3.c(h);
        boolean bl2 = o3.c(i) != null && (Boolean)o3.c(i) != false;
        boolean bl3 = bl2;
        try {
            e e2 = e.f((Bitmap)this.c(o2, options2, i2, b3, p2, bl3, n2, n3, bl, b2), (d)this.a);
            return e2;
        }
        finally {
            Queue<BitmapFactory.Options> queue3;
            j.j(options2);
            Queue<BitmapFactory.Options> queue4 = queue3 = m;
            // MONITORENTER : queue4
            m.offer((Object)options2);
            // MONITOREXIT : queue4
            this.c.f(arrby);
        }
    }

    public w<Bitmap> b(InputStream inputStream, int n2, int n3, o o2, b b2) {
        return this.a((c.c.a.m.w.c.o)new /* Unavailable Anonymous Inner Class!! */, n2, n3, o2, b2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final Bitmap c(c.c.a.m.w.c.o var1_1, BitmapFactory.Options var2_2, i var3_3, c.c.a.m.b var4_4, p var5_5, boolean var6_6, int var7_7, int var8_8, boolean var9_9, b var10_10) {
        block80 : {
            block81 : {
                block79 : {
                    block78 : {
                        block77 : {
                            block76 : {
                                block75 : {
                                    block72 : {
                                        block74 : {
                                            block73 : {
                                                block71 : {
                                                    block70 : {
                                                        block69 : {
                                                            block68 : {
                                                                block65 : {
                                                                    block63 : {
                                                                        block67 : {
                                                                            block66 : {
                                                                                block64 : {
                                                                                    var11_11 = f.b();
                                                                                    var13_12 = j.g(var1_1, var2_2, var10_10, this.a);
                                                                                    var14_13 = var13_12[0];
                                                                                    var15_14 = var13_12[1];
                                                                                    var16_15 = var2_2.outMimeType;
                                                                                    var17_16 = var14_13 != -1 && var15_14 != -1 ? var6_6 : false;
                                                                                    var18_17 = var1_1.d();
                                                                                    switch (var18_17) {
                                                                                        default: {
                                                                                            var20_18 = 0;
                                                                                            break;
                                                                                        }
                                                                                        case 7: 
                                                                                        case 8: {
                                                                                            var19_19 = 270;
                                                                                            ** break;
                                                                                        }
                                                                                        case 5: 
                                                                                        case 6: {
                                                                                            var19_19 = 90;
                                                                                            ** break;
                                                                                        }
                                                                                        case 3: 
                                                                                        case 4: {
                                                                                            var19_19 = 180;
lbl20: // 3 sources:
                                                                                            var20_18 = var19_19;
                                                                                        }
                                                                                    }
                                                                                    switch (var18_17) {
                                                                                        default: {
                                                                                            var21_20 = false;
                                                                                            ** break;
                                                                                        }
                                                                                        case 2: 
                                                                                        case 3: 
                                                                                        case 4: 
                                                                                        case 5: 
                                                                                        case 6: 
                                                                                        case 7: 
                                                                                        case 8: 
                                                                                    }
                                                                                    var21_20 = true;
lbl27: // 2 sources:
                                                                                    if (var7_7 == Integer.MIN_VALUE) {
                                                                                        if (j.h(var20_18)) {
                                                                                            var22_21 = var11_11;
                                                                                            var24_22 = var15_14;
                                                                                        } else {
                                                                                            var22_21 = var11_11;
                                                                                            var24_22 = var14_13;
                                                                                        }
                                                                                    } else {
                                                                                        var22_21 = var11_11;
                                                                                        var24_22 = var7_7;
                                                                                    }
                                                                                    var25_23 = var8_8 == Integer.MIN_VALUE ? (j.h(var20_18) ? var14_13 : var15_14) : var8_8;
                                                                                    var26_24 = var1_1.b();
                                                                                    var27_25 = this.a;
                                                                                    var28_26 = i.d.e;
                                                                                    var29_27 = var21_20;
                                                                                    var30_28 = var17_16;
                                                                                    if (var14_13 <= 0) break block63;
                                                                                    if (var15_14 > 0) break block64;
                                                                                    var40_29 = 3;
                                                                                    var31_30 = "Downsampler";
                                                                                    var32_31 = ", target density: ";
                                                                                    var33_32 = ", density: ";
                                                                                    var34_33 = var14_13;
                                                                                    var35_34 = "]";
                                                                                    var36_35 = "x";
                                                                                    var37_36 = var24_22;
                                                                                    var38_37 = var15_14;
                                                                                    var39_38 = var25_23;
                                                                                    break block65;
                                                                                }
                                                                                if (j.h(var20_18)) {
                                                                                    var139_39 = var14_13;
                                                                                    var138_40 = "]";
                                                                                    var140_41 = var15_14;
                                                                                } else {
                                                                                    var138_40 = "]";
                                                                                    var139_39 = var15_14;
                                                                                    var140_41 = var14_13;
                                                                                }
                                                                                var141_42 = var3_3.b(var140_41, var139_39, var24_22, var25_23);
                                                                                if (var141_42 <= 0.0f) {
                                                                                    var142_70 = var24_22;
                                                                                    var143_71 = var25_23;
                                                                                    var144_72 = new StringBuilder();
                                                                                    var144_72.append("Cannot scale with factor: ");
                                                                                    var144_72.append(var141_42);
                                                                                    var144_72.append(" from: ");
                                                                                    var144_72.append((Object)var3_3);
                                                                                    var144_72.append(", source: [");
                                                                                    var144_72.append(var14_13);
                                                                                    var144_72.append("x");
                                                                                    var144_72.append(var15_14);
                                                                                    var144_72.append("], target: [");
                                                                                    var144_72.append(var142_70);
                                                                                    var144_72.append("x");
                                                                                    var144_72.append(var143_71);
                                                                                    var144_72.append(var138_40);
                                                                                    throw new IllegalArgumentException(var144_72.toString());
                                                                                }
                                                                                var158_43 = var3_3.a(var140_41, var139_39, var24_22, var25_23);
                                                                                if (var158_43 == null) throw new IllegalArgumentException("Cannot round with null rounding");
                                                                                var159_44 = var140_41;
                                                                                var160_45 = j.k(var141_42 * var159_44);
                                                                                var161_46 = var139_39;
                                                                                var162_47 = var141_42 * var161_46;
                                                                                var163_48 = var24_22;
                                                                                var164_49 = var25_23;
                                                                                var165_50 = j.k(var162_47);
                                                                                var166_51 = var140_41 / var160_45;
                                                                                var167_52 = var139_39 / var165_50;
                                                                                var168_53 = var158_43 == var28_26 ? Math.max((int)var166_51, (int)var167_52) : Math.min((int)var166_51, (int)var167_52);
                                                                                if (Build.VERSION.SDK_INT <= 23 && j.j.contains((Object)var2_2.outMimeType)) {
                                                                                    var169_54 = 1;
                                                                                } else {
                                                                                    var169_54 = Math.max((int)1, (int)Integer.highestOneBit((int)var168_53));
                                                                                    if (var158_43 == var28_26 && (float)var169_54 < 1.0f / var141_42) {
                                                                                        var169_54 <<= 1;
                                                                                    }
                                                                                }
                                                                                var2_2.inSampleSize = var169_54;
                                                                                if (var26_24 != ImageHeaderParser.ImageType.JPEG) break block66;
                                                                                var208_55 = Math.min((int)var169_54, (int)8);
                                                                                var171_56 = (int)Math.ceil((double)(var159_44 / var208_55));
                                                                                var172_57 = (int)Math.ceil((double)(var161_46 / var208_55));
                                                                                var209_58 = var169_54 / 8;
                                                                                if (var209_58 > 0) {
                                                                                    var171_56 /= var209_58;
                                                                                    var172_57 /= var209_58;
                                                                                }
                                                                                break block67;
                                                                            }
                                                                            if (var26_24 == ImageHeaderParser.ImageType.PNG || var26_24 == ImageHeaderParser.ImageType.PNG_A) ** GOTO lbl-1000
                                                                            if (var26_24 != ImageHeaderParser.ImageType.WEBP && var26_24 != ImageHeaderParser.ImageType.WEBP_A) {
                                                                                if (var140_41 % var169_54 == 0 && var139_39 % var169_54 == 0) {
                                                                                    var171_56 = var140_41 / var169_54;
                                                                                    var172_57 = var139_39 / var169_54;
                                                                                } else {
                                                                                    var207_59 = j.g(var1_1, var2_2, var10_10, var27_25);
                                                                                    var171_56 = var207_59[0];
                                                                                    var172_57 = var207_59[1];
                                                                                }
                                                                            } else if (Build.VERSION.SDK_INT >= 24) {
                                                                                var206_60 = var169_54;
                                                                                var171_56 = Math.round((float)(var159_44 / var206_60));
                                                                                var172_57 = Math.round((float)(var161_46 / var206_60));
                                                                            } else lbl-1000: // 2 sources:
                                                                            {
                                                                                var170_61 = var169_54;
                                                                                var171_56 = (int)Math.floor((double)(var159_44 / var170_61));
                                                                                var172_57 = (int)Math.floor((double)(var161_46 / var170_61));
                                                                            }
                                                                        }
                                                                        var37_36 = var163_48;
                                                                        var39_38 = var164_49;
                                                                        var173_62 = var3_3.b(var171_56, var172_57, var37_36, var39_38);
                                                                        var175_63 = j.f(var173_62);
                                                                        var176_64 = j.k(var173_62 * (double)var175_63);
                                                                        var2_2.inTargetDensity = j.k(var173_62 / (double)((float)var176_64 / (float)var175_63) * (double)var176_64);
                                                                        var2_2.inDensity = var177_65 = j.f(var173_62);
                                                                        var178_66 = var2_2.inTargetDensity;
                                                                        var179_67 = var178_66 > 0 && var177_65 > 0 && var178_66 != var177_65;
                                                                        if (var179_67) {
                                                                            var2_2.inScaled = true;
                                                                        } else {
                                                                            var2_2.inTargetDensity = 0;
                                                                            var2_2.inDensity = 0;
                                                                        }
                                                                        var31_30 = "Downsampler";
                                                                        if (Log.isLoggable((String)var31_30, (int)2)) {
                                                                            var180_68 = new StringBuilder();
                                                                            var180_68.append("Calculate scaling, source: [");
                                                                            var34_33 = var14_13;
                                                                            var180_68.append(var34_33);
                                                                            var36_35 = "x";
                                                                            var180_68.append(var36_35);
                                                                            var180_68.append(var15_14);
                                                                            var180_68.append("], degreesToRotate: ");
                                                                            var180_68.append(var20_18);
                                                                            var180_68.append(", target: [");
                                                                            var180_68.append(var37_36);
                                                                            var180_68.append(var36_35);
                                                                            var180_68.append(var39_38);
                                                                            var180_68.append("], power of two scaled: [");
                                                                            var180_68.append(var171_56);
                                                                            var180_68.append(var36_35);
                                                                            var180_68.append(var172_57);
                                                                            var180_68.append("], exact scale factor: ");
                                                                            var180_68.append(var141_42);
                                                                            var180_68.append(", power of 2 sample size: ");
                                                                            var180_68.append(var169_54);
                                                                            var180_68.append(", adjusted scale factor: ");
                                                                            var180_68.append(var173_62);
                                                                            var32_31 = ", target density: ";
                                                                            var180_68.append(var32_31);
                                                                            var180_68.append(var2_2.inTargetDensity);
                                                                            var33_32 = ", density: ";
                                                                            var180_68.append(var33_32);
                                                                            var180_68.append(var2_2.inDensity);
                                                                            Log.v((String)var31_30, (String)var180_68.toString());
                                                                            var50_69 = this;
                                                                            var38_37 = var15_14;
                                                                        } else {
                                                                            var33_32 = ", density: ";
                                                                            var32_31 = ", target density: ";
                                                                            var36_35 = "x";
                                                                            var34_33 = var14_13;
                                                                            var50_69 = this;
                                                                            var38_37 = var15_14;
                                                                        }
                                                                        break block68;
                                                                    }
                                                                    var31_30 = "Downsampler";
                                                                    var32_31 = ", target density: ";
                                                                    var33_32 = ", density: ";
                                                                    var34_33 = var14_13;
                                                                    var35_34 = "]";
                                                                    var36_35 = "x";
                                                                    var37_36 = var24_22;
                                                                    var38_37 = var15_14;
                                                                    var39_38 = var25_23;
                                                                    var40_29 = 3;
                                                                }
                                                                if (Log.isLoggable((String)var31_30, (int)var40_29)) {
                                                                    var41_73 = new StringBuilder();
                                                                    var41_73.append("Unable to determine dimensions for: ");
                                                                    var41_73.append((Object)var26_24);
                                                                    var41_73.append(" with target [");
                                                                    var41_73.append(var37_36);
                                                                    var41_73.append(var36_35);
                                                                    var41_73.append(var39_38);
                                                                    var41_73.append(var35_34);
                                                                    Log.d((String)var31_30, (String)var41_73.toString());
                                                                }
                                                                var50_69 = this;
                                                            }
                                                            var51_74 = var50_69.e.b(var37_36, var39_38, var30_28, var29_27);
                                                            if (var51_74) {
                                                                var2_2.inPreferredConfig = Bitmap.Config.HARDWARE;
                                                                var2_2.inMutable = false;
                                                            }
                                                            if (!var51_74) break block69;
                                                            var53_75 = var32_31;
                                                            ** GOTO lbl-1000
                                                        }
                                                        var52_76 = c.c.a.m.b.e;
                                                        var53_75 = var32_31;
                                                        if (var4_4 != var52_76) {
                                                            try {
                                                                var136_77 = var1_1.b().hasAlpha();
                                                            }
                                                            catch (IOException var131_78) {
                                                                if (Log.isLoggable((String)var31_30, (int)3)) {
                                                                    var132_79 = new StringBuilder();
                                                                    var132_79.append("Cannot determine whether the image has alpha or not from header, format ");
                                                                    var132_79.append((Object)var4_4);
                                                                    Log.d((String)var31_30, (String)var132_79.toString(), (Throwable)var131_78);
                                                                }
                                                                var136_77 = false;
                                                            }
                                                            var137_80 = var136_77 != false ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                                                            var2_2.inPreferredConfig = var137_80;
                                                            ** if (var137_80 != Bitmap.Config.RGB_565) goto lbl-1000
lbl-1000: // 1 sources:
                                                            {
                                                                var2_2.inDither = var54_81 = true;
                                                                ** GOTO lbl244
                                                            }
                                                        }
                                                        break block70;
lbl-1000: // 2 sources:
                                                        {
                                                            var54_81 = true;
                                                        }
                                                        break block71;
                                                    }
                                                    var54_81 = true;
                                                    var2_2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                                                }
                                                if (var34_33 >= 0 && var38_37 >= 0 && var9_9) {
                                                    var65_82 = var37_36;
                                                    var62_83 = var53_75;
                                                } else {
                                                    var55_84 = var2_2.inTargetDensity;
                                                    var56_86 = var55_84 > 0 && (var130_85 = var2_2.inDensity) > 0 && var55_84 != var130_85 ? var54_81 : false;
                                                    var57_87 = var56_86 != false ? (float)var2_2.inTargetDensity / (float)var2_2.inDensity : 1.0f;
                                                    var58_88 = var2_2.inSampleSize;
                                                    var59_89 = var34_33;
                                                    var60_90 = var58_88;
                                                    var61_91 = var59_89 / var60_90;
                                                    var62_83 = var53_75;
                                                    var63_92 = (int)Math.ceil((double)var61_91);
                                                    var64_93 = (int)Math.ceil((double)((float)var38_37 / var60_90));
                                                    var65_82 = Math.round((float)(var57_87 * (float)var63_92));
                                                    var39_38 = Math.round((float)(var57_87 * (float)var64_93));
                                                    if (Log.isLoggable((String)var31_30, (int)2)) {
                                                        var66_94 = new StringBuilder();
                                                        var66_94.append("Calculated target [");
                                                        var66_94.append(var65_82);
                                                        var66_94.append(var36_35);
                                                        var66_94.append(var39_38);
                                                        var66_94.append("] for source [");
                                                        var66_94.append(var34_33);
                                                        var66_94.append(var36_35);
                                                        var66_94.append(var38_37);
                                                        var66_94.append("], sampleSize: ");
                                                        var66_94.append(var58_88);
                                                        var66_94.append(", targetDensity: ");
                                                        var66_94.append(var2_2.inTargetDensity);
                                                        var66_94.append(var33_32);
                                                        var66_94.append(var2_2.inDensity);
                                                        var66_94.append(", density multiplier: ");
                                                        var66_94.append(var57_87);
                                                        Log.v((String)var31_30, (String)var66_94.toString());
                                                    }
                                                }
                                                if (var65_82 <= 0 || var39_38 <= 0) break block72;
                                                var128_95 = var50_69.a;
                                                if (Build.VERSION.SDK_INT < 26) break block73;
                                                if (var2_2.inPreferredConfig == Bitmap.Config.HARDWARE) break block72;
                                                var129_96 = var2_2.outConfig;
                                                break block74;
                                            }
                                            var129_96 = null;
                                        }
                                        if (var129_96 == null) {
                                            var129_96 = var2_2.inPreferredConfig;
                                        }
                                        var2_2.inBitmap = var128_95.e(var65_82, var39_38, var129_96);
                                    }
                                    if ((var84_97 = Build.VERSION.SDK_INT) < 28) break block75;
                                    var126_99 = var5_5 == p.f && (var127_98 = var2_2.outColorSpace) != null && var127_98.isWideGamut() != false;
                                    if (!var126_99) break block76;
                                    var125_100 = ColorSpace.Named.DISPLAY_P3;
                                    break block77;
                                }
                                if (var84_97 < 26) break block78;
                            }
                            var125_100 = ColorSpace.Named.SRGB;
                        }
                        var2_2.inPreferredColorSpace = ColorSpace.get((ColorSpace.Named)var125_100);
                    }
                    var85_101 = j.d(var1_1, var2_2, var10_10, var50_69.a);
                    var10_10.a(var50_69.a, var85_101);
                    if (Log.isLoggable((String)var31_30, (int)2)) {
                        var100_102 = c.b.a.a.a.c("Decoded ");
                        var100_102.append(j.e(var85_101));
                        var100_102.append(" from [");
                        var100_102.append(var34_33);
                        var100_102.append(var36_35);
                        var100_102.append(var38_37);
                        var100_102.append("] ");
                        var100_102.append(var16_15);
                        var100_102.append(" with inBitmap ");
                        var100_102.append(j.e(var2_2.inBitmap));
                        var100_102.append(" for [");
                        var100_102.append(var7_7);
                        var100_102.append(var36_35);
                        var100_102.append(var8_8);
                        var100_102.append("], sample size: ");
                        var100_102.append(var2_2.inSampleSize);
                        var100_102.append(var33_32);
                        var100_102.append(var2_2.inDensity);
                        var100_102.append(var62_83);
                        var100_102.append(var2_2.inTargetDensity);
                        var100_102.append(", thread: ");
                        var100_102.append(Thread.currentThread().getName());
                        var100_102.append(", duration: ");
                        var100_102.append(f.a(var22_21));
                        Log.v((String)var31_30, (String)var100_102.toString());
                    }
                    var86_103 = null;
                    if (var85_101 == null) return var86_103;
                    var85_101.setDensity(var50_69.b.densityDpi);
                    var87_104 = var50_69.a;
                    switch (var18_17) {
                        default: {
                            var88_105 = false;
                            ** break;
                        }
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                        case 8: 
                    }
                    var88_105 = true;
lbl343: // 2 sources:
                    if (var88_105) break block79;
                    var86_103 = var85_101;
                    break block80;
                }
                var89_106 = new Matrix();
                switch (var18_17) {
                    default: {
                        break block81;
                    }
                    case 8: {
                        var89_106.setRotate(-90.0f);
                        break block81;
                    }
                    case 7: {
                        var89_106.setRotate(-90.0f);
                        ** GOTO lbl365
                    }
                    case 6: {
                        var89_106.setRotate(90.0f);
                        break block81;
                    }
                    case 5: {
                        var89_106.setRotate(90.0f);
                        ** GOTO lbl365
                    }
                    case 4: {
                        var89_106.setRotate(180.0f);
lbl365: // 3 sources:
                        var89_106.postScale(-1.0f, 1.0f);
                        break block81;
                    }
                    case 3: {
                        var89_106.setRotate(180.0f);
                        break block81;
                    }
                    case 2: 
                }
                var89_106.setScale(-1.0f, 1.0f);
            }
            var90_107 = new RectF(0.0f, 0.0f, (float)var85_101.getWidth(), (float)var85_101.getHeight());
            var89_106.mapRect(var90_107);
            var92_108 = Math.round((float)var90_107.width());
            var93_109 = Math.round((float)var90_107.height());
            var94_110 = var85_101.getConfig() != null ? var85_101.getConfig() : Bitmap.Config.ARGB_8888;
            var95_111 = var87_104.b(var92_108, var93_109, var94_110);
            var89_106.postTranslate(-var90_107.left, -var90_107.top);
            var95_111.setHasAlpha(var85_101.hasAlpha());
            v.d.lock();
            var97_112 = new Canvas(var95_111);
            var97_112.drawBitmap(var85_101, var89_106, v.a);
            var97_112.setBitmap(null);
            var86_103 = var95_111;
        }
        if (var85_101.equals((Object)var86_103) != false) return var86_103;
        var50_69.a.c(var85_101);
        return var86_103;
        finally {
            v.d.unlock();
        }
    }

    public static interface b {
        public void a(d var1, Bitmap var2);

        public void b();
    }

}

