/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.util.Xml
 *  f.s.a.a.a
 *  f.s.a.a.e
 *  f.s.a.a.f$a
 *  f.s.a.a.f$b
 *  f.s.a.a.f$c
 *  f.s.a.a.f$e
 *  f.s.a.a.f$g
 *  f.s.a.a.f$h
 *  f.s.a.a.f$i
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package f.s.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import f.b.k.h;
import f.s.a.a.f;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/*
 * Exception performing whole class analysis.
 */
public class f
extends f.s.a.a.e {
    public static final PorterDuff.Mode n;
    public h f;
    public PorterDuffColorFilter g;
    public ColorFilter h;
    public boolean i;
    public boolean j;
    public final float[] k;
    public final Matrix l;
    public final Rect m;

    public static {
        n = PorterDuff.Mode.SRC_IN;
    }

    public f() {
        this.j = true;
        this.k = new float[9];
        this.l = new Matrix();
        this.m = new Rect();
        this.f = new /* Unavailable Anonymous Inner Class!! */;
    }

    public f(h h2) {
        this.j = true;
        this.k = new float[9];
        this.l = new Matrix();
        this.m = new Rect();
        this.f = h2;
        this.g = this.d(h2.c, h2.d);
    }

    public static int a(int n2, float f2) {
        int n3 = Color.alpha((int)n2);
        return n2 & 16777215 | (int)(f2 * (float)n3) << 24;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static f b(Resources resources, int n2, Resources.Theme theme) {
        void var5_9;
        int n3;
        if (Build.VERSION.SDK_INT >= 24) {
            f f2 = new f();
            f2.e = resources.getDrawable(n2, theme);
            new /* Unavailable Anonymous Inner Class!! */;
            return f2;
        }
        XmlResourceParser xmlResourceParser = resources.getXml(n2);
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
        while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
        }
        if (n3 != 2) throw new XmlPullParserException("No start tag found");
        try {
            return f.c(resources, (XmlPullParser)xmlResourceParser, attributeSet, theme);
        }
        catch (IOException iOException) {
        }
        catch (XmlPullParserException xmlPullParserException) {
            // empty catch block
        }
        Log.e((String)"VectorDrawableCompat", (String)"parser error", (Throwable)var5_9);
        return null;
    }

    public static f c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        f f2 = new f();
        f2.inflate(resources, xmlPullParser, attributeSet, theme);
        return f2;
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.canApplyTheme();
        }
        return false;
    }

    public PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.copyBounds(this.m);
        if (this.m.width() > 0) {
            if (this.m.height() <= 0) {
                return;
            }
            ColorFilter colorFilter = this.h;
            if (colorFilter == null) {
                colorFilter = this.g;
            }
            canvas.getMatrix(this.l);
            this.l.getValues(this.k);
            float f2 = Math.abs((float)this.k[0]);
            float f3 = Math.abs((float)this.k[4]);
            float f4 = Math.abs((float)this.k[1]);
            float f5 = Math.abs((float)this.k[3]);
            if (f4 != 0.0f || f5 != 0.0f) {
                f3 = f2 = 1.0f;
            }
            int n2 = (int)(f2 * (float)this.m.width());
            int n3 = (int)(f3 * (float)this.m.height());
            int n4 = Math.min((int)2048, (int)n2);
            int n5 = Math.min((int)2048, (int)n3);
            if (n4 > 0) {
                boolean bl;
                Paint paint;
                if (n5 <= 0) {
                    return;
                }
                int n6 = canvas.save();
                Rect rect = this.m;
                canvas.translate((float)rect.left, (float)rect.top);
                boolean bl2 = this.isAutoMirrored() && this.getLayoutDirection() == 1;
                if (bl2) {
                    canvas.translate((float)this.m.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.m.offsetTo(0, 0);
                h h2 = this.f;
                Bitmap bitmap = h2.f;
                if (bitmap == null || !(bl = n4 == bitmap.getWidth() && n5 == h2.f.getHeight())) {
                    h2.f = Bitmap.createBitmap((int)n4, (int)n5, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    h2.k = true;
                }
                if (!this.j) {
                    this.f.b(n4, n5);
                } else {
                    h h3 = this.f;
                    boolean bl3 = !h3.k && h3.g == h3.c && h3.h == h3.d && h3.j == h3.e && h3.i == h3.b.getRootAlpha();
                    if (!bl3) {
                        this.f.b(n4, n5);
                        h h4 = this.f;
                        h4.g = h4.c;
                        h4.h = h4.d;
                        h4.i = h4.b.getRootAlpha();
                        h4.j = h4.e;
                        h4.k = false;
                    }
                }
                h h5 = this.f;
                Rect rect2 = this.m;
                int n7 = h5.b.getRootAlpha();
                boolean bl4 = false;
                if (n7 < 255) {
                    bl4 = true;
                }
                if (!bl4 && colorFilter == null) {
                    paint = null;
                } else {
                    if (h5.l == null) {
                        Paint paint2;
                        h5.l = paint2 = new Paint();
                        paint2.setFilterBitmap(true);
                    }
                    h5.l.setAlpha(h5.b.getRootAlpha());
                    h5.l.setColorFilter(colorFilter);
                    paint = h5.l;
                }
                canvas.drawBitmap(h5.f, null, rect2, paint);
                canvas.restoreToCount(n6);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return Drawable.super.getChangingConfigurations() | this.f.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.h;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.e != null && Build.VERSION.SDK_INT >= 24) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        this.f.a = this.getChangingConfigurations();
        return this.f;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int)this.f.b.j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int)this.f.b.i;
    }

    public int getOpacity() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
            return;
        }
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void inflate(Resources var1_1, XmlPullParser var2_2, AttributeSet var3_3, Resources.Theme var4_4) {
        block49 : {
            var5_5 = this.e;
            if (var5_5 != null) {
                var5_5.inflate(var1_1, var2_2, var3_3, var4_4);
                return;
            }
            var6_6 = this.f;
            var6_6.b = new /* Unavailable Anonymous Inner Class!! */;
            var7_7 = h.i.d1(var1_1, var4_4, var3_3, f.s.a.a.a.a);
            var8_8 = this.f;
            var9_9 = var8_8.b;
            var10_10 = h.i.m0(var7_7, var2_2, "tintMode", 6, -1);
            var11_11 = PorterDuff.Mode.SRC_IN;
            var12_12 = 3;
            if (var10_10 != var12_12) {
                if (var10_10 != 5) {
                    if (var10_10 != 9) {
                        switch (var10_10) {
                            default: {
                                ** break;
                            }
                            case 16: {
                                var11_11 = PorterDuff.Mode.ADD;
                                ** break;
                            }
                            case 15: {
                                var11_11 = PorterDuff.Mode.SCREEN;
                                ** break;
                            }
                            case 14: 
                        }
                        var11_11 = PorterDuff.Mode.MULTIPLY;
                        ** break;
lbl28: // 4 sources:
                    } else {
                        var11_11 = PorterDuff.Mode.SRC_ATOP;
                    }
                }
            } else {
                var11_11 = PorterDuff.Mode.SRC_OVER;
            }
            var8_8.d = var11_11;
            var13_13 = h.i.z0(var2_2, "tint");
            var14_14 = 1;
            if (!var13_13) ** GOTO lbl56
            var15_15 = new TypedValue();
            var7_7.getValue(var14_14, var15_15);
            var17_16 = var15_15.type;
            if (var17_16 == 2) {
                var18_21 = new StringBuilder();
                var18_21.append("Failed to resolve attribute at index ");
                var18_21.append(var14_14);
                var18_21.append(": ");
                var18_21.append((Object)var15_15);
                throw new UnsupportedOperationException(var18_21.toString());
            }
            if (var17_16 >= 28 && var17_16 <= 31) {
                var27_17 = ColorStateList.valueOf((int)var15_15.data);
            } else {
                var23_18 = var7_7.getResources();
                var24_19 = var7_7.getResourceId(var14_14, 0);
                try {
                    var27_17 = h.i.L(var23_18, (XmlPullParser)var23_18.getXml(var24_19), var4_4);
                    break block49;
                }
                catch (Exception var25_20) {
                    Log.e((String)"CSLCompat", (String)"Failed to inflate ColorStateList.", (Throwable)var25_20);
                }
lbl56: // 2 sources:
                var27_17 = null;
            }
        }
        if (var27_17 != null) {
            var8_8.c = var27_17;
        }
        var28_22 = var8_8.e;
        if (h.i.z0(var2_2, "autoMirrored")) {
            var28_22 = var7_7.getBoolean(5, var28_22);
        }
        var8_8.e = var28_22;
        var9_9.k = h.i.l0(var7_7, var2_2, "viewportWidth", 7, var9_9.k);
        var9_9.l = var29_23 = h.i.l0(var7_7, var2_2, "viewportHeight", 8, var9_9.l);
        if (var9_9.k <= 0.0f) {
            var30_62 = new StringBuilder();
            var30_62.append(var7_7.getPositionDescription());
            var30_62.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(var30_62.toString());
        }
        if (var29_23 <= 0.0f) {
            var33_61 = new StringBuilder();
            var33_61.append(var7_7.getPositionDescription());
            var33_61.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(var33_61.toString());
        }
        var9_9.i = var7_7.getDimension(var12_12, var9_9.i);
        var9_9.j = var36_24 = var7_7.getDimension(2, var9_9.j);
        if (var9_9.i <= 0.0f) {
            var37_60 = new StringBuilder();
            var37_60.append(var7_7.getPositionDescription());
            var37_60.append("<vector> tag requires width > 0");
            throw new XmlPullParserException(var37_60.toString());
        }
        if (var36_24 <= 0.0f) {
            var40_59 = new StringBuilder();
            var40_59.append(var7_7.getPositionDescription());
            var40_59.append("<vector> tag requires height > 0");
            throw new XmlPullParserException(var40_59.toString());
        }
        var9_9.setAlpha(h.i.l0(var7_7, var2_2, "alpha", 4, var9_9.getAlpha()));
        var43_25 = var7_7.getString(0);
        if (var43_25 != null) {
            var9_9.n = var43_25;
            var9_9.p.put(var43_25, var9_9);
        }
        var7_7.recycle();
        var6_6.a = this.getChangingConfigurations();
        var6_6.k = var14_14;
        var44_26 = this.f;
        var45_27 = var44_26.b;
        var46_28 = new ArrayDeque();
        var46_28.push((Object)var45_27.h);
        var47_29 = var2_2.getEventType();
        var48_30 = 1 + var2_2.getDepth();
        var49_31 = var14_14;
        while (var47_29 != var14_14 && (var2_2.getDepth() >= var48_30 || var47_29 != var12_12)) {
            block52 : {
                block50 : {
                    block53 : {
                        block51 : {
                            if (var47_29 != 2) break block50;
                            var56_36 = var2_2.getName();
                            var57_37 = (d)var46_28.peek();
                            if (!"path".equals((Object)var56_36)) break block51;
                            var58_38 = new /* Unavailable Anonymous Inner Class!! */;
                            var59_39 = h.i.d1(var1_1, var4_4, var3_3, f.s.a.a.a.c);
                            var58_38.e = null;
                            if (!h.i.z0(var2_2, "pathData")) {
                                var62_42 = var46_28;
                                var63_43 = var45_27;
                                var70_50 = var59_39;
                                var65_45 = var58_38;
                                var51_33 = var48_30;
                                var53_35 = 8;
                                var64_44 = var57_37;
                            } else {
                                var60_40 = var59_39.getString(0);
                                if (var60_40 != null) {
                                    var58_38.b = var60_40;
                                }
                                if ((var61_41 = var59_39.getString(2)) != null) {
                                    var58_38.a = h.i.O(var61_41);
                                }
                                var62_42 = var46_28;
                                var63_43 = var45_27;
                                var51_33 = var48_30;
                                var64_44 = var57_37;
                                var65_45 = var58_38;
                                var65_45.h = h.i.k0(var59_39, var2_2, var4_4, "fillColor", 1, 0);
                                var65_45.j = h.i.l0(var59_39, var2_2, "fillAlpha", 12, var65_45.j);
                                var66_46 = h.i.m0(var59_39, var2_2, "strokeLineCap", 8, -1);
                                var67_47 = var65_45.n;
                                if (var66_46 != 0) {
                                    if (var66_46 != 1) {
                                        if (var66_46 == 2) {
                                            var67_47 = Paint.Cap.SQUARE;
                                        }
                                    } else {
                                        var67_47 = Paint.Cap.ROUND;
                                    }
                                } else {
                                    var67_47 = Paint.Cap.BUTT;
                                }
                                var65_45.n = var67_47;
                                var68_48 = h.i.m0(var59_39, var2_2, "strokeLineJoin", 9, -1);
                                var69_49 = var65_45.o;
                                if (var68_48 != 0) {
                                    if (var68_48 != 1) {
                                        if (var68_48 == 2) {
                                            var69_49 = Paint.Join.BEVEL;
                                        }
                                    } else {
                                        var69_49 = Paint.Join.ROUND;
                                    }
                                } else {
                                    var69_49 = Paint.Join.MITER;
                                }
                                var65_45.o = var69_49;
                                var65_45.p = h.i.l0(var59_39, var2_2, "strokeMiterLimit", 10, var65_45.p);
                                var53_35 = 8;
                                var70_50 = var59_39;
                                var65_45.f = h.i.k0(var59_39, var2_2, var4_4, "strokeColor", 3, 0);
                                var65_45.i = h.i.l0(var70_50, var2_2, "strokeAlpha", 11, var65_45.i);
                                var65_45.g = h.i.l0(var70_50, var2_2, "strokeWidth", 4, var65_45.g);
                                var65_45.l = h.i.l0(var70_50, var2_2, "trimPathEnd", 6, var65_45.l);
                                var65_45.m = h.i.l0(var70_50, var2_2, "trimPathOffset", 7, var65_45.m);
                                var65_45.k = h.i.l0(var70_50, var2_2, "trimPathStart", 5, var65_45.k);
                                var65_45.c = h.i.m0(var70_50, var2_2, "fillType", 13, var65_45.c);
                            }
                            var70_50.recycle();
                            var64_44.b.add((Object)var65_45);
                            if (var65_45.getPathName() != null) {
                                var50_32 = var63_43;
                                var50_32.p.put(var65_45.getPathName(), var65_45);
                            } else {
                                var50_32 = var63_43;
                            }
                            var44_26.a |= var65_45.d;
                            var46_28 = var62_42;
                            var52_34 = 3;
                            var49_31 = 0;
                            break block52;
                        }
                        var73_51 = var46_28;
                        var50_32 = var45_27;
                        var51_33 = var48_30;
                        var53_35 = 8;
                        if (!"clip-path".equals((Object)var56_36)) break block53;
                        var74_52 = new /* Unavailable Anonymous Inner Class!! */;
                        if (h.i.z0(var2_2, "pathData")) {
                            var75_53 = h.i.d1(var1_1, var4_4, var3_3, f.s.a.a.a.d);
                            var76_54 = var75_53.getString(0);
                            if (var76_54 != null) {
                                var74_52.b = var76_54;
                            }
                            if ((var77_55 = var75_53.getString(1)) != null) {
                                var74_52.a = h.i.O(var77_55);
                            }
                            var74_52.c = h.i.m0(var75_53, var2_2, "fillType", 2, 0);
                            var75_53.recycle();
                        }
                        var57_37.b.add((Object)var74_52);
                        if (var74_52.getPathName() != null) {
                            var50_32.p.put(var74_52.getPathName(), var74_52);
                        }
                        var44_26.a |= var74_52.d;
                        ** GOTO lbl-1000
                    }
                    if ("group".equals((Object)var56_36)) {
                        var80_56 = new d();
                        var81_57 = h.i.d1(var1_1, var4_4, var3_3, f.s.a.a.a.b);
                        var80_56.l = null;
                        var80_56.c = h.i.l0(var81_57, var2_2, "rotation", 5, var80_56.c);
                        var80_56.d = var81_57.getFloat(1, var80_56.d);
                        var80_56.e = var81_57.getFloat(2, var80_56.e);
                        var80_56.f = h.i.l0(var81_57, var2_2, "scaleX", 3, var80_56.f);
                        var80_56.g = h.i.l0(var81_57, var2_2, "scaleY", 4, var80_56.g);
                        var80_56.h = h.i.l0(var81_57, var2_2, "translateX", 6, var80_56.h);
                        var80_56.i = h.i.l0(var81_57, var2_2, "translateY", 7, var80_56.i);
                        var82_58 = var81_57.getString(0);
                        if (var82_58 != null) {
                            var80_56.m = var82_58;
                        }
                        var80_56.c();
                        var81_57.recycle();
                        var57_37.b.add((Object)var80_56);
                        var46_28 = var73_51;
                        var46_28.push((Object)var80_56);
                        if (var80_56.getGroupName() != null) {
                            var50_32.p.put(var80_56.getGroupName(), var80_56);
                        }
                        var44_26.a |= var80_56.k;
                    } else lbl-1000: // 2 sources:
                    {
                        var46_28 = var73_51;
                    }
                    var52_34 = 3;
                    break block52;
                }
                var50_32 = var45_27;
                var51_33 = var48_30;
                var52_34 = 3;
                var53_35 = 8;
                if (var47_29 == var52_34 && "group".equals((Object)var2_2.getName())) {
                    var46_28.pop();
                }
            }
            var47_29 = var2_2.next();
            var12_12 = var52_34;
            var48_30 = var51_33;
            var14_14 = 1;
            var45_27 = var50_32;
        }
        if (var49_31 != 0) throw new XmlPullParserException("no path defined");
        this.g = this.d(var6_6.c, var6_6.d);
    }

    public void invalidateSelf() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.invalidateSelf();
            return;
        }
        Drawable.super.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f.e;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        h h2;
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return Drawable.super.isStateful() || (h2 = this.f) != null && (h2.a() || (colorStateList = this.f.c) != null && colorStateList.isStateful());
        {
        }
    }

    public Drawable mutate() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.i && Drawable.super.mutate() == this) {
            this.f = new /* Unavailable Anonymous Inner Class!! */;
            this.i = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] arrn) {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.setState(arrn);
        }
        h h2 = this.f;
        ColorStateList colorStateList = h2.c;
        boolean bl = false;
        if (colorStateList != null) {
            PorterDuff.Mode mode = h2.d;
            bl = false;
            if (mode != null) {
                this.g = this.d(colorStateList, mode);
                this.invalidateSelf();
                bl = true;
            }
        }
        if (h2.a()) {
            boolean bl2 = h2.b.h.b(arrn);
            h2.k = bl2 | h2.k;
            if (bl2) {
                this.invalidateSelf();
                return true;
            }
        }
        return bl;
    }

    public void scheduleSelf(Runnable runnable, long l2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, l2);
            return;
        }
        Drawable.super.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setAlpha(n2);
            return;
        }
        if (this.f.b.getRootAlpha() != n2) {
            this.f.b.setRootAlpha(n2);
            this.invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean bl) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setAutoMirrored(bl);
            return;
        }
        this.f.e = bl;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.h = colorFilter;
        this.invalidateSelf();
    }

    public void setTint(int n2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            h.i.E1(drawable, n2);
            return;
        }
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.e;
        if (drawable != null) {
            h.i.G1(drawable, colorStateList);
            return;
        }
        h h2 = this.f;
        if (h2.c != colorStateList) {
            h2.c = colorStateList;
            this.g = this.d(colorStateList, h2.d);
            this.invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.e;
        if (drawable != null) {
            h.i.H1(drawable, mode);
            return;
        }
        h h2 = this.f;
        if (h2.d != mode) {
            h2.d = mode;
            this.g = this.d(h2.c, mode);
            this.invalidateSelf();
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.setVisible(bl, bl2);
        }
        return Drawable.super.setVisible(bl, bl2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
            return;
        }
        Drawable.super.unscheduleSelf(runnable);
    }

    /*
     * Exception performing whole class analysis.
     */
    public static class d
    extends e {
        public final Matrix a;
        public final ArrayList<e> b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public d() {
            super(null);
            this.a = new Matrix();
            this.b = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public d(d d2, f.e.a<String, Object> a2) {
            String string;
            super(null);
            this.a = new Matrix();
            this.b = new ArrayList();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.c = d2.c;
            this.d = d2.d;
            this.e = d2.e;
            this.f = d2.f;
            this.g = d2.g;
            this.h = d2.h;
            this.i = d2.i;
            this.l = d2.l;
            this.m = string = d2.m;
            this.k = d2.k;
            if (string != null) {
                a2.put(string, (Object)this);
            }
            this.j.set(d2.j);
            ArrayList<e> arrayList = d2.b;
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                block8 : {
                    c c2;
                    block7 : {
                        Object object;
                        block6 : {
                            object = arrayList.get(i2);
                            if (object instanceof d) {
                                d d3 = (d)((Object)object);
                                this.b.add((Object)new d(d3, a2));
                                continue;
                            }
                            if (!(object instanceof c)) break block6;
                            c2 = new /* Unavailable Anonymous Inner Class!! */;
                            break block7;
                        }
                        if (!(object instanceof b)) break block8;
                        c2 = new /* Unavailable Anonymous Inner Class!! */;
                    }
                    this.b.add((Object)c2);
                    String string2 = c2.b;
                    if (string2 == null) continue;
                    a2.put(string2, (Object)c2);
                    continue;
                }
                throw new IllegalStateException("Unknown object in the tree!");
            }
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                if (!(this.b.get(i2)).a()) continue;
                return true;
            }
            return false;
        }

        public boolean b(int[] arrn) {
            boolean bl = false;
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                bl |= (this.b.get(i2)).b(arrn);
            }
            return bl;
        }

        public final void c() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.d) {
                this.d = f2;
                this.c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.e) {
                this.e = f2;
                this.c();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                this.c();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                this.c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                this.c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                this.c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                this.c();
            }
        }
    }

    public static abstract class f
    extends e {
        public f.h.f.c[] a = null;
        public String b;
        public int c = 0;
        public int d;

        public f() {
            super(null);
        }

        public f(f f2) {
            super(null);
            this.b = f2.b;
            this.d = f2.d;
            this.a = h.i.U(f2.a);
        }

        public boolean c() {
            return false;
        }

        public f.h.f.c[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(f.h.f.c[] arrc) {
            if (!h.i.i(this.a, arrc)) {
                this.a = h.i.U(arrc);
                return;
            }
            f.h.f.c[] arrc2 = this.a;
            for (int i2 = 0; i2 < arrc.length; ++i2) {
                arrc2[i2].a = arrc[i2].a;
                for (int i3 = 0; i3 < arrc[i2].b.length; ++i3) {
                    arrc2[i2].b[i3] = arrc[i2].b[i3];
                }
            }
        }
    }

}

