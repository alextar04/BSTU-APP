/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.util.Xml
 *  f.b.p.j$a
 *  f.b.p.m0$a
 *  f.b.p.m0$b
 *  f.b.p.m0$c
 *  f.b.p.m0$f
 *  f.s.a.a.f
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.WeakHashMap
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import f.b.p.d0;
import f.b.p.j;
import f.b.p.m0;
import f.b.p.r0;
import f.b.p.u0;
import f.e.h;
import f.e.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/*
 * Exception performing whole class analysis.
 */
public final class m0 {
    public static final PorterDuff.Mode h;
    public static m0 i;
    public static final c j;
    public WeakHashMap<Context, i<ColorStateList>> a;
    public h<String, d> b;
    public i<String> c;
    public final WeakHashMap<Context, f.e.e<WeakReference<Drawable.ConstantState>>> d;
    public TypedValue e;
    public boolean f;
    public e g;

    public static {
        h = PorterDuff.Mode.SRC_IN;
        j = new /* Unavailable Anonymous Inner Class!! */;
    }

    public m0() {
        this.d = new WeakHashMap(0);
    }

    public static m0 d() {
        Class<m0> class_ = m0.class;
        synchronized (m0.class) {
            if (i == null) {
                m0 m02;
                i = m02 = new m0();
                if (Build.VERSION.SDK_INT < 24) {
                    m02.a("vector", (d)new /* Unavailable Anonymous Inner Class!! */);
                    m02.a("animated-vector", (d)new /* Unavailable Anonymous Inner Class!! */);
                    m02.a("animated-selector", (d)new /* Unavailable Anonymous Inner Class!! */);
                }
            }
            m0 m03 = i;
            // ** MonitorExit[var3] (shouldn't be in output)
            return m03;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PorterDuffColorFilter h(int n2, PorterDuff.Mode mode) {
        Class<m0> class_ = m0.class;
        synchronized (m0.class) {
            c c2 = j;
            if (c2 == null) {
                throw null;
            }
            int n3 = 31 * (n2 + 31);
            PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter)c2.a(n3 + mode.hashCode());
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(n2, mode);
                c c3 = j;
                if (c3 == null) {
                    throw null;
                }
                c3.b(n3 + mode.hashCode(), porterDuffColorFilter);
            }
            // ** MonitorExit[var8_2] (shouldn't be in output)
            return porterDuffColorFilter;
        }
    }

    public static void l(Drawable drawable, u0 u02, int[] arrn) {
        if (d0.a(drawable) && drawable.mutate() != drawable) {
            Log.d((String)"ResourceManagerInternal", (String)"Mutated drawable is not the same instance as the input.");
            return;
        }
        if (!u02.d && !u02.c) {
            drawable.clearColorFilter();
        } else {
            ColorStateList colorStateList = u02.d ? u02.a : null;
            PorterDuff.Mode mode = u02.c ? u02.b : h;
            PorterDuffColorFilter porterDuffColorFilter = null;
            if (colorStateList != null) {
                porterDuffColorFilter = mode == null ? null : m0.h(colorStateList.getColorForState(arrn, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final void a(String string, d d2) {
        if (this.b == null) {
            this.b = new h();
        }
        this.b.put(string, d2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean b(Context context, long l2, Drawable drawable) {
        m0 m02 = this;
        synchronized (m02) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) return false;
            f.e.e<WeakReference> e2 = (f.e.e<WeakReference>)this.d.get((Object)context);
            if (e2 == null) {
                e2 = new f.e.e<WeakReference>();
                this.d.put((Object)context, e2);
            }
            e2.g(l2, new WeakReference((Object)constantState));
            return true;
        }
    }

    public final Drawable c(Context context, int n2) {
        LayerDrawable layerDrawable;
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(n2, typedValue, true);
        long l2 = (long)typedValue.assetCookie << 32 | (long)typedValue.data;
        Drawable drawable = this.e(context, l2);
        if (drawable != null) {
            return drawable;
        }
        e e2 = this.g;
        if (e2 == null) {
            layerDrawable = null;
        } else {
            (j.a)e2;
            int n3 = f.b.e.abc_cab_background_top_material;
            layerDrawable = null;
            if (n2 == n3) {
                Drawable[] arrdrawable = new Drawable[]{this.f(context, f.b.e.abc_cab_background_internal_bg), this.f(context, f.b.e.abc_cab_background_top_mtrl_alpha)};
                layerDrawable = new LayerDrawable(arrdrawable);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            this.b(context, l2, (Drawable)layerDrawable);
        }
        return layerDrawable;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Drawable e(Context context, long l2) {
        m0 m02 = this;
        synchronized (m02) {
            f.e.e e2;
            block10 : {
                block9 : {
                    e2 = (f.e.e)this.d.get((Object)context);
                    if (e2 != null) break block9;
                    return null;
                }
                WeakReference weakReference = e2.f(l2, null);
                if (weakReference == null) return null;
                Drawable.ConstantState constantState = (Drawable.ConstantState)weakReference.get();
                if (constantState == null) break block10;
                return constantState.newDrawable(context.getResources());
            }
            int n2 = f.e.d.b(e2.f, e2.h, l2);
            if (n2 < 0) return null;
            Object[] arrobject = e2.g;
            Object object = arrobject[n2];
            Object object2 = f.e.e.i;
            if (object == object2) return null;
            arrobject[n2] = object2;
            e2.e = true;
            return null;
        }
    }

    public Drawable f(Context context, int n2) {
        m0 m02 = this;
        synchronized (m02) {
            Drawable drawable = this.g(context, n2, false);
            return drawable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Drawable g(Context context, int n2, boolean bl) {
        m0 m02 = this;
        synchronized (m02) {
            Drawable drawable;
            block10 : {
                block11 : {
                    boolean bl2;
                    block13 : {
                        block12 : {
                            try {
                                if (this.f) break block10;
                                this.f = bl2 = true;
                                Drawable drawable2 = this.f(context, f.b.n.a.abc_vector_test);
                                if (drawable2 == null) break block11;
                                if (!(drawable2 instanceof f.s.a.a.f) && !"android.graphics.drawable.VectorDrawable".equals((Object)drawable2.getClass().getName())) break block12;
                                break block13;
                            }
                            catch (Throwable throwable) {}
                            throw throwable;
                        }
                        bl2 = false;
                    }
                    if (bl2) break block10;
                }
                this.f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
            if ((drawable = this.j(context, n2)) == null) {
                drawable = this.c(context, n2);
            }
            if (drawable == null) {
                drawable = f.h.e.a.c(context, n2);
            }
            if (drawable != null) {
                drawable = this.k(context, n2, bl, drawable);
            }
            if (drawable != null) {
                d0.b(drawable);
            }
            return drawable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ColorStateList i(Context context, int n2) {
        m0 m02 = this;
        synchronized (m02) {
            i<ColorStateList> i2;
            e e2;
            try {
                i i3;
                WeakHashMap<Context, i<ColorStateList>> weakHashMap = this.a;
                ColorStateList colorStateList = weakHashMap != null && (i3 = (i)weakHashMap.get((Object)context)) != null ? (ColorStateList)i3.e(n2, null) : null;
                if (colorStateList != null) return colorStateList;
                if (this.g == null) {
                    return null;
                }
                e2 = this.g;
            }
            catch (Throwable throwable) {}
            j.a a2 = (j.a)e2;
            ColorStateList colorStateList = a2.c(context, n2);
            if (colorStateList == null) return colorStateList;
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            if ((i2 = (i<ColorStateList>)this.a.get((Object)context)) == null) {
                i2 = new i<ColorStateList>(10);
                this.a.put((Object)context, i2);
            }
            i2.a(n2, colorStateList);
            return colorStateList;
            throw throwable;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Drawable j(Context context, int n2) {
        Drawable drawable;
        h<String, d> h2 = this.b;
        if (h2 == null || h2.isEmpty()) return null;
        i<String> i2 = this.c;
        if (i2 != null) {
            String string = i2.e(n2, null);
            if ("appcompat_skip_skip".equals((Object)string) || string != null && this.b.getOrDefault(string, null) == null) {
                return null;
            }
        } else {
            this.c = new i(10);
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(n2, typedValue, true);
        long l2 = (long)typedValue.assetCookie << 32 | (long)typedValue.data;
        drawable = this.e(context, l2);
        if (drawable != null) {
            return drawable;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            block13 : {
                int n3;
                XmlResourceParser xmlResourceParser = resources.getXml(n2);
                AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
                }
                if (n3 != 2) throw new XmlPullParserException("No start tag found");
                String string = xmlResourceParser.getName();
                this.c.a(n2, string);
                d d2 = this.b.get(string);
                if (d2 == null) break block13;
                try {
                    drawable = d2.a(context, (XmlPullParser)xmlResourceParser, attributeSet, context.getTheme());
                }
                catch (Exception exception) {
                    Log.e((String)"ResourceManagerInternal", (String)"Exception while inflating drawable", (Throwable)exception);
                }
            }
            if (drawable != null) {
                drawable.setChangingConfigurations(typedValue.changingConfigurations);
                this.b(context, l2, drawable);
            }
        }
        if (drawable != null) return drawable;
        this.c.a(n2, "appcompat_skip_skip");
        return drawable;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final Drawable k(Context var1_1, int var2_2, boolean var3_3, Drawable var4_4) {
        block8 : {
            block9 : {
                var5_5 = this.i(var1_1, var2_2);
                if (var5_5 != null) {
                    if (d0.a(var4_4)) {
                        var4_4 = var4_4.mutate();
                    }
                    var4_4.setTintList(var5_5);
                    var13_6 = this.g;
                    if (var13_6 == null) {
                        var14_7 = null;
                    } else {
                        (j.a)var13_6;
                        var16_8 = f.b.e.abc_switch_thumb_material;
                        var14_7 = null;
                        if (var2_2 == var16_8) {
                            var14_7 = PorterDuff.Mode.MULTIPLY;
                        }
                    }
                    if (var14_7 == null) return var4_4;
                    var4_4.setTintMode(var14_7);
                    return var4_4;
                }
                var6_9 = this.g;
                if (var6_9 == null) break block8;
                var7_10 = (j.a)var6_9;
                if (var7_10 == null) throw null;
                var8_11 = f.b.e.abc_seekbar_track_material;
                var9_12 = true;
                if (var2_2 != var8_11) break block9;
                var10_13 = (LayerDrawable)var4_4;
                var7_10.d(var10_13.findDrawableByLayerId(16908288), r0.c(var1_1, f.b.a.colorControlNormal), j.b);
                var11_14 = var10_13.findDrawableByLayerId(16908303);
                var12_15 = f.b.a.colorControlNormal;
                ** GOTO lbl38
            }
            if (var2_2 != f.b.e.abc_ratingbar_material && var2_2 != f.b.e.abc_ratingbar_indicator_material && var2_2 != f.b.e.abc_ratingbar_small_material) {
                var9_12 = false;
            } else {
                var10_13 = (LayerDrawable)var4_4;
                var7_10.d(var10_13.findDrawableByLayerId(16908288), r0.b(var1_1, f.b.a.colorControlNormal), j.b);
                var11_14 = var10_13.findDrawableByLayerId(16908303);
                var12_15 = f.b.a.colorControlActivated;
lbl38: // 2 sources:
                var7_10.d(var11_14, r0.c(var1_1, var12_15), j.b);
                var7_10.d(var10_13.findDrawableByLayerId(16908301), r0.c(var1_1, f.b.a.colorControlActivated), j.b);
            }
            if (var9_12) {
                return var4_4;
            }
        }
        if (this.m(var1_1, var2_2, var4_4) != false) return var4_4;
        if (var3_3 == false) return var4_4;
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean m(Context var1_1, int var2_2, Drawable var3_3) {
        block9 : {
            block8 : {
                block7 : {
                    block6 : {
                        var4_4 = this.g;
                        if (var4_4 == null) return false;
                        var5_5 = (j.a)var4_4;
                        if (var5_5 == null) throw null;
                        var6_6 = j.b;
                        var7_7 = var5_5.a(var5_5.a, var2_2);
                        var8_8 = 16842801;
                        if (!var7_7) break block6;
                        var8_8 = f.b.a.colorControlNormal;
                        ** GOTO lbl-1000
                    }
                    if (!var5_5.a(var5_5.c, var2_2)) break block7;
                    var8_8 = f.b.a.colorControlActivated;
                    ** GOTO lbl-1000
                }
                if (!var5_5.a(var5_5.d, var2_2)) break block8;
                var6_6 = PorterDuff.Mode.MULTIPLY;
                ** GOTO lbl-1000
            }
            if (var2_2 != f.b.e.abc_list_divider_mtrl_alpha) break block9;
            var9_9 = 16842800;
            var11_10 = Math.round((float)40.8f);
            ** GOTO lbl28
        }
        if (var2_2 == f.b.e.abc_dialog_material_background) lbl-1000: // 4 sources:
        {
            var9_9 = var8_8;
            var11_10 = -1;
lbl28: // 2 sources:
            var10_11 = true;
        } else {
            var9_9 = 0;
            var10_11 = false;
            var11_10 = -1;
        }
        if (var10_11) {
            if (d0.a(var3_3)) {
                var3_3 = var3_3.mutate();
            }
            var3_3.setColorFilter((ColorFilter)j.c(r0.c(var1_1, var9_9), var6_6));
            if (var11_10 != -1) {
                var3_3.setAlpha(var11_10);
            }
            var12_12 = true;
        } else {
            var12_12 = false;
        }
        if (var12_12 == false) return false;
        return true;
    }

    public static interface d {
        public Drawable a(Context var1, XmlPullParser var2, AttributeSet var3, Resources.Theme var4);
    }

    public static interface e {
    }

}

