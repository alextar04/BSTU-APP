/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Xml
 *  f.s.a.a.a
 *  f.s.a.a.b$a
 *  f.s.a.a.b$b
 *  f.s.a.a.b$c
 *  f.s.a.a.e
 *  f.s.a.a.f$g
 *  f.s.a.a.f$h
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package f.s.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import f.b.k.h;
import f.s.a.a.b;
import f.s.a.a.e;
import f.s.a.a.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/*
 * Exception performing whole class analysis.
 */
public class b
extends e
implements Animatable {
    public b f;
    public Context g;
    public ArgbEvaluator h;
    public final Drawable.Callback i;

    public b() {
        this(null, null, null);
    }

    public b(Context context, b b2, Resources resources) {
        this.h = null;
        this.i = new a(this);
        this.g = context;
        this.f = new /* Unavailable Anonymous Inner Class!! */;
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f.b.draw(canvas);
        if (this.f.c.isStarted()) {
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f.b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return Drawable.super.getChangingConfigurations() | this.f.a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f.b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.e != null && Build.VERSION.SDK_INT >= 24) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return null;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f.b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void inflate(Resources var1_1, XmlPullParser var2_2, AttributeSet var3_3, Resources.Theme var4_4) {
        var5_5 = this.e;
        if (var5_5 != null) {
            var5_5.inflate(var1_1, var2_2, var3_3, var4_4);
            return;
        }
        var6_6 = var2_2.getEventType();
        var7_7 = var2_2.getDepth();
        var8_8 = 1;
        var9_9 = var7_7 + var8_8;
        while (var6_6 != var8_8 && (var2_2.getDepth() >= var9_9 || var6_6 != 3)) {
            block23 : {
                block20 : {
                    block22 : {
                        block21 : {
                            block25 : {
                                block24 : {
                                    if (var6_6 != 2) break block23;
                                    var11_10 = var2_2.getName();
                                    var12_11 = "animated-vector".equals((Object)var11_10);
                                    var13_12 = null;
                                    if (!var12_11) break block24;
                                    var14_13 = h.i.d1(var1_1, var4_4, var3_3, f.s.a.a.a.e);
                                    var41_25 = var14_13.getResourceId(0, 0);
                                    if (var41_25 != 0) {
                                        var42_26 = f.b(var1_1, var41_25, var4_4);
                                        var42_26.j = false;
                                        var42_26.setCallback(this.i);
                                        var43_27 = this.f.b;
                                        if (var43_27 != null) {
                                            var43_27.setCallback(null);
                                        }
                                        this.f.b = var42_26;
                                    }
                                    break block20;
                                }
                                if (!"target".equals((Object)var11_10)) break block23;
                                var14_13 = var1_1.obtainAttributes(var3_3, f.s.a.a.a.f);
                                var15_14 = var14_13.getString(0);
                                var16_15 = var14_13.getResourceId(var8_8, 0);
                                if (var16_15 == 0) break block20;
                                var17_16 = this.g;
                                if (var17_16 == null) {
                                    var14_13.recycle();
                                    throw new IllegalStateException("Context can't be null when inflating animators");
                                }
                                if (Build.VERSION.SDK_INT < 24) break block25;
                                var37_23 = AnimatorInflater.loadAnimator((Context)var17_16, (int)var16_15);
                                ** GOTO lbl52
                            }
                            var18_17 = var17_16.getResources();
                            var19_18 = var17_16.getTheme();
                            var28_20 = var18_17.getAnimation(var16_15);
                            try {
                                var35_21 = Xml.asAttributeSet((XmlPullParser)var28_20);
                                var36_22 = var28_20;
                                var21_19 = "Can't load animation resource ID #0x";
                                try {
                                    var37_23 = h.i.G(var17_16, var18_17, var19_18, (XmlPullParser)var36_22, var35_21, null, 0, 1.0f);
                                }
                                catch (IOException var29_28) {
                                    break block21;
                                }
                                catch (XmlPullParserException var20_32) {
                                    break block22;
                                }
                                var28_20.close();
lbl52: // 2 sources:
                                var37_23.setTarget(this.f.b.f.b.p.getOrDefault(var15_14, null));
                                var38_24 = this.f;
                                if (var38_24.d == null) {
                                    var38_24.d = new ArrayList();
                                    this.f.e = new f.e.a<K, V>();
                                }
                                this.f.d.add((Object)var37_23);
                                this.f.e.put(var37_23, var15_14);
                                break block20;
                            }
                            catch (Throwable var27_36) {
                                ** GOTO lbl98
                            }
                            catch (IOException var29_29) {
                                var21_19 = "Can't load animation resource ID #0x";
                            }
                        }
                        var13_12 = var28_20;
                        ** GOTO lbl-1000
                        catch (XmlPullParserException var20_33) {
                            var21_19 = "Can't load animation resource ID #0x";
                        }
                    }
                    var13_12 = var28_20;
                    ** GOTO lbl104
                }
                var14_13.recycle();
            }
            var6_6 = var2_2.next();
            var8_8 = 1;
        }
        var10_43 = this.f;
        if (var10_43.c == null) {
            var10_43.c = new AnimatorSet();
        }
        var10_43.c.playTogether((Collection)var10_43.d);
        return;
        catch (Throwable var27_37) {
            ** GOTO lbl97
        }
        catch (IOException var29_31) {
            var21_19 = "Can't load animation resource ID #0x";
        }
lbl-1000: // 2 sources:
        {
            var30_39 = new StringBuilder();
            var30_39.append(var21_19);
            var30_39.append(Integer.toHexString((int)var16_15));
            var33_40 = new Resources.NotFoundException(var30_39.toString());
            var33_40.initCause((Throwable)var29_30);
            throw var33_40;
lbl97: // 1 sources:
            var28_20 = var13_12;
lbl98: // 2 sources:
            if (var28_20 == null) throw var27_38;
            var28_20.close();
            throw var27_38;
            catch (XmlPullParserException var20_35) {
                var21_19 = "Can't load animation resource ID #0x";
                var13_12 = null;
            }
lbl104: // 2 sources:
            var22_41 = new StringBuilder();
            var22_41.append(var21_19);
            var22_41.append(Integer.toHexString((int)var16_15));
            var25_42 = new Resources.NotFoundException(var22_41.toString());
            var25_42.initCause((Throwable)var20_34);
            throw var25_42;
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f.b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return ((AnimatedVectorDrawable)drawable).isRunning();
        }
        return this.f.c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f.b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setBounds(rect);
            return;
        }
        this.f.b.setBounds(rect);
    }

    public boolean onLevelChange(int n2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.setLevel(n2);
        }
        return this.f.b.setLevel(n2);
    }

    public boolean onStateChange(int[] arrn) {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.setState(arrn);
        }
        return this.f.b.setState(arrn);
    }

    public void setAlpha(int n2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setAlpha(n2);
            return;
        }
        this.f.b.setAlpha(n2);
    }

    public void setAutoMirrored(boolean bl) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setAutoMirrored(bl);
            return;
        }
        f f2 = this.f.b;
        Drawable drawable2 = f2.e;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(bl);
            return;
        }
        f2.f.e = bl;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        f f2 = this.f.b;
        Drawable drawable2 = f2.e;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        f2.h = colorFilter;
        f2.invalidateSelf();
    }

    public void setTint(int n2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            h.i.E1(drawable, n2);
            return;
        }
        this.f.b.setTint(n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.e;
        if (drawable != null) {
            h.i.G1(drawable, colorStateList);
            return;
        }
        this.f.b.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.e;
        if (drawable != null) {
            h.i.H1(drawable, mode);
            return;
        }
        this.f.b.setTintMode(mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        Drawable drawable = this.e;
        if (drawable != null) {
            return drawable.setVisible(bl, bl2);
        }
        this.f.b.setVisible(bl, bl2);
        return Drawable.super.setVisible(bl, bl2);
    }

    public void start() {
        Drawable drawable = this.e;
        if (drawable != null) {
            ((AnimatedVectorDrawable)drawable).start();
            return;
        }
        if (this.f.c.isStarted()) {
            return;
        }
        this.f.c.start();
        this.invalidateSelf();
    }

    public void stop() {
        Drawable drawable = this.e;
        if (drawable != null) {
            ((AnimatedVectorDrawable)drawable).stop();
            return;
        }
        this.f.c.end();
    }
}

