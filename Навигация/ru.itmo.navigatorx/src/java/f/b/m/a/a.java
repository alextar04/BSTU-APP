/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  f.b.k.h
 *  f.b.m.a.a$b
 *  f.b.m.a.a$d
 *  f.b.m.a.a$e
 *  f.b.m.a.d
 *  f.b.m.a.d$a
 *  f.s.a.a.b
 *  f.s.a.a.b$b
 *  f.s.a.a.f
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package f.b.m.a;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import f.b.k.h;
import f.b.m.a.a;
import f.b.m.a.b;
import f.b.m.a.d;
import f.b.p.m0;
import f.e.i;
import f.s.a.a.b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/*
 * Exception performing whole class analysis.
 */
@SuppressLint(value={"RestrictedAPI"})
public class a
extends f.b.m.a.d {
    public c s;
    public g t;
    public int u;
    public int v;
    public boolean w;

    public a() {
        this(null, null);
    }

    public a(c c2, Resources resources) {
        super(null);
        this.u = -1;
        this.v = -1;
        c c3 = new c(c2, this, resources);
        super.f((b.c)((Object)c3));
        this.s = c3;
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static a h(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String string = xmlPullParser.getName();
        if (string.equals((Object)"animated-selector")) {
            int n2;
            int n3;
            a a2 = new a(null, null);
            TypedArray typedArray = h.i.d1(resources, theme, attributeSet, f.b.n.b.AnimatedStateListDrawableCompat);
            int n4 = f.b.n.b.AnimatedStateListDrawableCompat_android_visible;
            int n5 = 1;
            a2.setVisible(typedArray.getBoolean(n4, (boolean)n5), (boolean)n5);
            c c2 = a2.s;
            ((b.c)c2).d |= typedArray.getChangingConfigurations();
            ((b.c)c2).i = typedArray.getBoolean(f.b.n.b.AnimatedStateListDrawableCompat_android_variablePadding, ((b.c)c2).i);
            ((b.c)c2).l = typedArray.getBoolean(f.b.n.b.AnimatedStateListDrawableCompat_android_constantSize, ((b.c)c2).l);
            ((b.c)c2).A = typedArray.getInt(f.b.n.b.AnimatedStateListDrawableCompat_android_enterFadeDuration, ((b.c)c2).A);
            ((b.c)c2).B = typedArray.getInt(f.b.n.b.AnimatedStateListDrawableCompat_android_exitFadeDuration, ((b.c)c2).B);
            ((f.b.m.a.b)((Object)a2)).setDither(typedArray.getBoolean(f.b.n.b.AnimatedStateListDrawableCompat_android_dither, ((b.c)c2).x));
            ((f.b.m.a.b)a2).e.f(resources);
            typedArray.recycle();
            int n6 = n5 + xmlPullParser.getDepth();
            while ((n2 = xmlPullParser.next()) != n5 && ((n3 = xmlPullParser.getDepth()) >= n6 || n2 != 3)) {
                if (n2 != 2 || n3 > n6) continue;
                if (xmlPullParser.getName().equals((Object)"item")) {
                    void var27_24;
                    void var27_27;
                    TypedArray typedArray2 = h.i.d1(resources, theme, attributeSet, f.b.n.b.AnimatedStateListDrawableItem);
                    int n7 = typedArray2.getResourceId(f.b.n.b.AnimatedStateListDrawableItem_android_id, 0);
                    int n8 = typedArray2.getResourceId(f.b.n.b.AnimatedStateListDrawableItem_android_drawable, -1);
                    Object var27_25 = null;
                    if (n8 > 0) {
                        Drawable drawable = m0.d().f(context, n8);
                    }
                    typedArray2.recycle();
                    int n9 = attributeSet.getAttributeCount();
                    int[] arrn = new int[n9];
                    int n10 = 0;
                    for (int i2 = 0; i2 < n9; ++i2) {
                        int n11 = attributeSet.getAttributeNameResource(i2);
                        if (n11 == 0 || n11 == 16842960 || n11 == 16843161) continue;
                        int n12 = n10 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                            n11 = -n11;
                        }
                        arrn[n10] = n11;
                        n10 = n12;
                    }
                    int[] arrn2 = StateSet.trimStateSet((int[])arrn, (int)n10);
                    if (var27_27 == null) {
                        int n13;
                        while ((n13 = xmlPullParser.next()) == 4) {
                        }
                        if (n13 != 2) throw new XmlPullParserException(c.b.a.a.a.m(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                        if (xmlPullParser.getName().equals((Object)"vector")) {
                            f.s.a.a.f f2 = f.s.a.a.f.c((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
                        } else {
                            Drawable drawable = Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
                        }
                    }
                    if (var27_24 == null) throw new XmlPullParserException(c.b.a.a.a.m(xmlPullParser, new StringBuilder(), ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"));
                    c c3 = a2.s;
                    int n14 = ((b.c)((Object)c3)).a((Drawable)var27_24);
                    c3.J[n14] = arrn2;
                    c3.L.g(n14, n7);
                } else if (xmlPullParser.getName().equals((Object)"transition")) {
                    TypedArray typedArray3 = h.i.d1(resources, theme, attributeSet, f.b.n.b.AnimatedStateListDrawableTransition);
                    int n15 = typedArray3.getResourceId(f.b.n.b.AnimatedStateListDrawableTransition_android_fromId, -1);
                    int n16 = typedArray3.getResourceId(f.b.n.b.AnimatedStateListDrawableTransition_android_toId, -1);
                    int n17 = typedArray3.getResourceId(f.b.n.b.AnimatedStateListDrawableTransition_android_drawable, -1);
                    Drawable drawable = n17 > 0 ? m0.d().f(context, n17) : null;
                    boolean bl = typedArray3.getBoolean(f.b.n.b.AnimatedStateListDrawableTransition_android_reversible, false);
                    typedArray3.recycle();
                    if (drawable == null) {
                        int n18;
                        while ((n18 = xmlPullParser.next()) == 4) {
                        }
                        if (n18 != 2) throw new XmlPullParserException(c.b.a.a.a.m(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                        if (xmlPullParser.getName().equals((Object)"animated-vector")) {
                            drawable = new f.s.a.a.b(context, null, null);
                            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            drawable = Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
                        }
                    }
                    if (drawable == null) throw new XmlPullParserException(c.b.a.a.a.m(xmlPullParser, new StringBuilder(), ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"));
                    if (n15 == -1 || n16 == -1) throw new XmlPullParserException(c.b.a.a.a.m(xmlPullParser, new StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
                    a2.s.h(n15, n16, drawable, bl);
                }
                n5 = 1;
            }
            a2.onStateChange(a2.getState());
            return a2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid animated-selector tag ");
        stringBuilder.append(string);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    public b.c b() {
        return new c(this.s, this, null);
    }

    public void f(b.c c2) {
        super.f(c2);
        if (c2 instanceof c) {
            this.s = (c)((Object)c2);
        }
    }

    public d.a g() {
        return new c(this.s, this, null);
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        f.b.m.a.b.super.jumpToCurrentState();
        g g2 = this.t;
        if (g2 != null) {
            g2.d();
            this.t = null;
            ((f.b.m.a.b)((Object)this)).e(this.u);
            this.u = -1;
            this.v = -1;
        }
    }

    public Drawable mutate() {
        if (!this.w) {
            super.mutate();
            if (this == this) {
                this.s.e();
                this.w = true;
            }
        }
        return this;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onStateChange(int[] var1_1) {
        block10 : {
            block5 : {
                block9 : {
                    block8 : {
                        block6 : {
                            block7 : {
                                var2_2 = this.s.k(var1_1);
                                var3_3 = this.k;
                                var4_4 = true;
                                if (var2_2 == var3_3) break block5;
                                var6_5 = this.t;
                                if (var6_5 == null) break block6;
                                if (var2_2 == this.u) ** GOTO lbl44
                                if (var2_2 != this.v || !var6_5.a()) break block7;
                                var6_5.b();
                                this.u = this.v;
                                this.v = var2_2;
                                ** GOTO lbl44
                            }
                            var3_3 = this.u;
                            var6_5.d();
                        }
                        this.t = null;
                        this.v = -1;
                        this.u = -1;
                        var7_7 = this.s;
                        var8_8 = var7_7.j(var3_3);
                        var9_9 = var7_7.j(var2_2);
                        if (var9_9 == 0 || var8_8 == 0 || (var13_11 = (int)var7_7.K.f(var11_10 = c.i(var8_8, var9_9), -1L).longValue()) < 0) ** GOTO lbl-1000
                        var14_12 = c.i(var8_8, var9_9);
                        var16_13 = (0x200000000L & var7_7.K.f(var14_12, -1L)) != 0L ? var4_4 : false;
                        this.e(var13_11);
                        var18_14 = this.g;
                        if (!(var18_14 instanceof AnimationDrawable)) break block8;
                        var20_15 = c.i(var8_8, var9_9);
                        var22_16 = (0x100000000L & var7_7.K.f(var20_15, -1L)) != 0L ? var4_4 : false;
                        var19_17 = new /* Unavailable Anonymous Inner Class!! */;
                        ** GOTO lbl40
                    }
                    if (!(var18_14 instanceof f.s.a.a.b)) break block9;
                    var19_17 = new /* Unavailable Anonymous Inner Class!! */;
                    ** GOTO lbl40
                }
                if (var18_14 instanceof Animatable) {
                    var19_17 = new /* Unavailable Anonymous Inner Class!! */;
lbl40: // 3 sources:
                    var19_17.c();
                    this.t = var19_17;
                    this.v = var3_3;
                    this.u = var2_2;
lbl44: // 3 sources:
                    var10_6 = var4_4;
                } else lbl-1000: // 2 sources:
                {
                    var10_6 = false;
                }
                if (var10_6 || this.e(var2_2)) break block10;
            }
            var4_4 = false;
        }
        if ((var5_18 = this.g) == null) return var4_4;
        var4_4 |= var5_18.setState(var1_1);
        return var4_4;
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = f.b.m.a.b.super.setVisible(bl, bl2);
        if (this.t != null && (bl3 || bl2)) {
            if (bl) {
                this.t.c();
                return bl3;
            }
            this.jumpToCurrentState();
        }
        return bl3;
    }

    public static class c
    extends d.a {
        public f.e.e<Long> K;
        public i<Integer> L;

        public c(c c2, a a2, Resources resources) {
            i<Object> i2;
            super((d.a)c2, (f.b.m.a.d)a2, resources);
            if (c2 != null) {
                this.K = c2.K;
                i2 = c2.L;
            } else {
                this.K = new f.e.e();
                i2 = new i(10);
            }
            this.L = i2;
        }

        public static long i(int n2, int n3) {
            return (long)n2 << 32 | (long)n3;
        }

        public void e() {
            this.K = this.K.c();
            this.L = this.L.b();
        }

        public int h(int n2, int n3, Drawable drawable, boolean bl) {
            int n4 = b.c.super.a(drawable);
            long l2 = c.i(n2, n3);
            long l3 = bl ? 0x200000000L : 0L;
            f.e.e<Long> e2 = this.K;
            long l4 = n4;
            e2.a(l2, l4 | l3);
            if (bl) {
                long l5 = c.i(n3, n2);
                this.K.a(l5, l3 | (0x100000000L | l4));
            }
            return n4;
        }

        public int j(int n2) {
            if (n2 < 0) {
                return 0;
            }
            return this.L.e(n2, 0);
        }

        public int k(int[] arrn) {
            int n2 = super.g(arrn);
            if (n2 >= 0) {
                return n2;
            }
            return super.g(StateSet.WILD_CARD);
        }

        public Drawable newDrawable() {
            return new a(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

}

