/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.SystemClock
 *  android.util.DisplayMetrics
 *  android.util.SparseArray
 *  f.b.k.h
 *  f.b.m.a.d
 *  f.b.m.a.d$a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 *  java.lang.Throwable
 */
package f.b.m.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import f.b.k.h;
import f.b.m.a.d;

public class b
extends Drawable
implements Drawable.Callback {
    public c e;
    public Rect f;
    public Drawable g;
    public Drawable h;
    public int i = 255;
    public boolean j;
    public int k = -1;
    public boolean l;
    public Runnable m;
    public long n;
    public long o;
    public b p;

    public static int d(Resources resources, int n2) {
        if (resources != null) {
            n2 = resources.getDisplayMetrics().densityDpi;
        }
        if (n2 == 0) {
            n2 = 160;
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a(boolean var1_1) {
        this.j = var2_2 = true;
        var3_3 = SystemClock.uptimeMillis();
        var5_4 = this.g;
        if (var5_4 == null) ** GOTO lbl-1000
        var11_5 = this.n;
        if (var11_5 != 0L) {
            if (var11_5 > var3_3) {
                var5_4.setAlpha((255 - (int)(255L * (var11_5 - var3_3)) / this.e.A) * this.i / 255);
                var6_6 = var2_2;
            } else {
                var5_4.setAlpha(this.i);
            }
        }
        ** GOTO lbl14
lbl-1000: // 2 sources:
        {
            this.n = 0L;
lbl14: // 2 sources:
            var6_6 = false;
        }
        var7_7 = this.h;
        if (var7_7 == null) ** GOTO lbl-1000
        var8_8 = this.o;
        if (var8_8 != 0L) {
            if (var8_8 > var3_3) {
                var7_7.setAlpha((int)(255L * (var8_8 - var3_3)) / this.e.B * this.i / 255);
            } else {
                var7_7.setVisible(false, false);
                this.h = null;
            }
        }
        ** GOTO lbl26
lbl-1000: // 2 sources:
        {
            this.o = 0L;
lbl26: // 2 sources:
            var2_2 = var6_6;
        }
        if (var1_1 == false) return;
        if (var2_2 == false) return;
        this.scheduleSelf(this.m, var3_3 + 16L);
    }

    public void applyTheme(Resources.Theme theme) {
        c c2 = this.e;
        if (c2 != null) {
            if (theme != null) {
                c2.c();
                int n2 = c2.h;
                Drawable[] arrdrawable = c2.g;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (arrdrawable[i2] == null || !arrdrawable[i2].canApplyTheme()) continue;
                    arrdrawable[i2].applyTheme(theme);
                    c2.e |= arrdrawable[i2].getChangingConfigurations();
                }
                c2.f(theme.getResources());
            }
            return;
        }
        throw null;
    }

    public abstract c b();

    public final void c(Drawable drawable) {
        block9 : {
            Rect rect;
            if (this.p == null) {
                this.p = new b();
            }
            b b2 = this.p;
            b2.e = drawable.getCallback();
            drawable.setCallback((Drawable.Callback)b2);
            try {
                if (this.e.A <= 0 && this.j) {
                    drawable.setAlpha(this.i);
                }
                if (this.e.E) {
                    drawable.setColorFilter(this.e.D);
                } else {
                    if (this.e.H) {
                        drawable.setTintList(this.e.F);
                    }
                    if (this.e.I) {
                        drawable.setTintMode(this.e.G);
                    }
                }
                drawable.setVisible(this.isVisible(), true);
                drawable.setDither(this.e.x);
                drawable.setState(this.getState());
                drawable.setLevel(this.getLevel());
                drawable.setBounds(this.getBounds());
                drawable.setLayoutDirection(this.getLayoutDirection());
                drawable.setAutoMirrored(this.e.C);
                rect = this.f;
                if (rect == null) break block9;
            }
            catch (Throwable throwable) {
                b b3 = this.p;
                Drawable.Callback callback = b3.e;
                b3.e = null;
                drawable.setCallback(callback);
                throw throwable;
            }
            drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
        }
        b b4 = this.p;
        Drawable.Callback callback = b4.e;
        b4.e = null;
        drawable.setCallback(callback);
    }

    public boolean canApplyTheme() {
        return this.e.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if ((drawable = this.h) != null) {
            drawable.draw(canvas);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean e(int var1_1) {
        if (var1_1 == this.k) {
            return false;
        }
        var2_2 = SystemClock.uptimeMillis();
        if (this.e.B > 0) {
            var10_3 = this.h;
            if (var10_3 != null) {
                var10_3.setVisible(false, false);
            }
            if ((var11_4 = this.g) != null) {
                this.h = var11_4;
                this.o = var2_2 + (long)this.e.B;
            } else {
                this.h = null;
                this.o = 0L;
            }
        } else {
            var4_5 = this.g;
            if (var4_5 != null) {
                var4_5.setVisible(false, false);
            }
        }
        if (var1_1 < 0) ** GOTO lbl-1000
        var6_6 = this.e;
        if (var1_1 < var6_6.h) {
            this.g = var7_7 = var6_6.d(var1_1);
            this.k = var1_1;
            if (var7_7 != null) {
                var8_8 = this.e.A;
                if (var8_8 > 0) {
                    this.n = var2_2 + (long)var8_8;
                }
                this.c(var7_7);
            }
        } else lbl-1000: // 2 sources:
        {
            this.g = null;
            this.k = -1;
        }
        if (this.n != 0L || this.o != 0L) {
            var5_9 = this.m;
            if (var5_9 == null) {
                this.m = new Runnable(){

                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                this.unscheduleSelf(var5_9);
            }
            this.a(true);
        }
        this.invalidateSelf();
        return true;
    }

    public void f(c c2) {
        this.e = c2;
        int n2 = this.k;
        if (n2 >= 0) {
            Drawable drawable;
            this.g = drawable = c2.d(n2);
            if (drawable != null) {
                this.c(drawable);
            }
        }
        this.h = null;
    }

    public int getAlpha() {
        return this.i;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.e.getChangingConfigurations();
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public final Drawable.ConstantState getConstantState() {
        c c2;
        c c3 = c2 = this.e;
        synchronized (c3) {
            boolean bl = c2.v;
            boolean bl2 = true;
            if (bl) {
                bl2 = c2.w;
            }
            c2.c();
            c2.v = bl2;
            int n2 = c2.h;
            Drawable[] arrdrawable = c2.g;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (arrdrawable[i2].getConstantState() != null) continue;
                c2.w = false;
                // MONITOREXIT [0, 2, 5] lbl16 : w: MONITOREXIT : var8_2
                bl2 = false;
            }
            c2.w = bl2;
            if (bl2) {
                this.e.d = this.getChangingConfigurations();
                return this.e;
            }
            return null;
            finally {
            }
        }
    }

    public Drawable getCurrent() {
        return this.g;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f;
        if (rect2 != null) {
            rect.set(rect2);
            return;
        }
        super.getHotspotBounds(rect);
    }

    public int getIntrinsicHeight() {
        c c2 = this.e;
        if (c2.l) {
            if (!c2.m) {
                c2.b();
            }
            return c2.o;
        }
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        c c2 = this.e;
        if (c2.l) {
            if (!c2.m) {
                c2.b();
            }
            return c2.n;
        }
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        c c2 = this.e;
        if (c2.l) {
            if (!c2.m) {
                c2.b();
            }
            return c2.q;
        }
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        c c2 = this.e;
        if (c2.l) {
            if (!c2.m) {
                c2.b();
            }
            return c2.p;
        }
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.g;
        int n2 = -2;
        if (drawable != null) {
            if (!drawable.isVisible()) {
                return n2;
            }
            c c2 = this.e;
            if (c2.r) {
                return c2.s;
            }
            c2.c();
            int n3 = c2.h;
            Drawable[] arrdrawable = c2.g;
            if (n3 > 0) {
                n2 = arrdrawable[0].getOpacity();
            }
            for (int i2 = 1; i2 < n3; ++i2) {
                n2 = Drawable.resolveOpacity((int)n2, (int)arrdrawable[i2].getOpacity());
            }
            c2.s = n2;
            c2.r = true;
        }
        return n2;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean bl;
        c c2 = this.e;
        boolean bl2 = c2.i;
        Rect rect2 = null;
        if (bl2) {
            rect2 = null;
        } else if (c2.k == null && !c2.j) {
            c2.c();
            Rect rect3 = new Rect();
            int n2 = c2.h;
            Drawable[] arrdrawable = c2.g;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3;
                int n4;
                int n5;
                int n6;
                if (!arrdrawable[i2].getPadding(rect3)) continue;
                if (rect2 == null) {
                    rect2 = new Rect(0, 0, 0, 0);
                }
                if ((n4 = rect3.left) > rect2.left) {
                    rect2.left = n4;
                }
                if ((n5 = rect3.top) > rect2.top) {
                    rect2.top = n5;
                }
                if ((n6 = rect3.right) > rect2.right) {
                    rect2.right = n6;
                }
                if ((n3 = rect3.bottom) <= rect2.bottom) continue;
                rect2.bottom = n3;
            }
            c2.j = true;
            c2.k = rect2;
        } else {
            rect2 = c2.k;
        }
        if (rect2 != null) {
            rect.set(rect2);
            bl = (rect2.left | rect2.top | rect2.bottom | rect2.right) != 0;
        } else {
            Drawable drawable = this.g;
            bl = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        boolean bl3 = this.e.C;
        boolean bl4 = false;
        if (bl3) {
            int n7 = this.getLayoutDirection();
            bl4 = false;
            if (n7 == 1) {
                bl4 = true;
            }
        }
        if (bl4) {
            int n8 = rect.left;
            rect.left = rect.right;
            rect.right = n8;
        }
        return bl;
    }

    public void invalidateDrawable(Drawable drawable) {
        c c2 = this.e;
        if (c2 != null) {
            c2.r = false;
            c2.t = false;
        }
        if (drawable == this.g && this.getCallback() != null) {
            this.getCallback().invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAutoMirrored() {
        return this.e.C;
    }

    public void jumpToCurrentState() {
        boolean bl;
        Drawable drawable = this.h;
        boolean bl2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.h = null;
            bl = bl2;
        } else {
            bl = false;
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.j) {
                this.g.setAlpha(this.i);
            }
        }
        if (this.o != 0L) {
            this.o = 0L;
            bl = bl2;
        }
        if (this.n != 0L) {
            this.n = 0L;
        } else {
            bl2 = bl;
        }
        if (bl2) {
            this.invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.l && super.mutate() == this) {
            c c2 = this.b();
            c2.e();
            this.f(c2);
            this.l = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable;
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
        if ((drawable = this.g) != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int n2) {
        c c2 = this.e;
        int n3 = this.k;
        int n4 = c2.h;
        Drawable[] arrdrawable = c2.g;
        boolean bl = false;
        for (int i2 = 0; i2 < n4; ++i2) {
            if (arrdrawable[i2] == null) continue;
            boolean bl2 = arrdrawable[i2].setLayoutDirection(n2);
            if (i2 != n3) continue;
            bl = bl2;
        }
        c2.z = n2;
        return bl;
    }

    public boolean onLevelChange(int n2) {
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.setLevel(n2);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            return drawable2.setLevel(n2);
        }
        return false;
    }

    public boolean onStateChange(int[] arrn) {
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.setState(arrn);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            return drawable2.setState(arrn);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        if (drawable == this.g && this.getCallback() != null) {
            this.getCallback().scheduleDrawable((Drawable)this, runnable, l2);
        }
    }

    public void setAlpha(int n2) {
        if (!this.j || this.i != n2) {
            this.j = true;
            this.i = n2;
            Drawable drawable = this.g;
            if (drawable != null) {
                if (this.n == 0L) {
                    drawable.setAlpha(n2);
                    return;
                }
                this.a(false);
            }
        }
    }

    public void setAutoMirrored(boolean bl) {
        c c2 = this.e;
        if (c2.C != bl) {
            c2.C = bl;
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.setAutoMirrored(bl);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c c2 = this.e;
        c2.E = true;
        if (c2.D != colorFilter) {
            c2.D = colorFilter;
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean bl) {
        c c2 = this.e;
        if (c2.x != bl) {
            c2.x = bl;
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.setDither(bl);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        Rect rect = this.f;
        if (rect == null) {
            this.f = new Rect(n2, n3, n4, n5);
        } else {
            rect.set(n2, n3, n4, n5);
        }
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setHotspotBounds(n2, n3, n4, n5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c c2 = this.e;
        c2.H = true;
        if (c2.F != colorStateList) {
            c2.F = colorStateList;
            h.i.G1(this.g, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c c2 = this.e;
        c2.I = true;
        if (c2.G != mode) {
            c2.G = mode;
            h.i.H1(this.g, mode);
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        Drawable drawable;
        boolean bl3 = super.setVisible(bl, bl2);
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setVisible(bl, bl2);
        }
        if ((drawable = this.g) != null) {
            drawable.setVisible(bl, bl2);
        }
        return bl3;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.g && this.getCallback() != null) {
            this.getCallback().unscheduleDrawable((Drawable)this, runnable);
        }
    }

    public static class b
    implements Drawable.Callback {
        public Drawable.Callback e;

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
            Drawable.Callback callback = this.e;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, l2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.e;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    public static abstract class c
    extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;
        public final b a;
        public Resources b;
        public int c = 160;
        public int d;
        public int e;
        public SparseArray<Drawable.ConstantState> f;
        public Drawable[] g;
        public int h;
        public boolean i;
        public boolean j;
        public Rect k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public int z;

        public c(c c2, b b2, Resources resources) {
            int n2;
            int n3 = 0;
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.a = b2;
            Object object = resources != null ? resources : (c2 != null ? c2.b : null);
            this.b = object;
            int n4 = c2 != null ? c2.c : 0;
            this.c = n2 = b.d(resources, n4);
            if (c2 != null) {
                this.d = c2.d;
                this.e = c2.e;
                this.v = true;
                this.w = true;
                this.i = c2.i;
                this.l = c2.l;
                this.x = c2.x;
                this.y = c2.y;
                this.z = c2.z;
                this.A = c2.A;
                this.B = c2.B;
                this.C = c2.C;
                this.D = c2.D;
                this.E = c2.E;
                this.F = c2.F;
                this.G = c2.G;
                this.H = c2.H;
                this.I = c2.I;
                if (c2.c == n2) {
                    if (c2.j) {
                        this.k = new Rect(c2.k);
                        this.j = true;
                    }
                    if (c2.m) {
                        this.n = c2.n;
                        this.o = c2.o;
                        this.p = c2.p;
                        this.q = c2.q;
                        this.m = true;
                    }
                }
                if (c2.r) {
                    this.s = c2.s;
                    this.r = true;
                }
                if (c2.t) {
                    this.u = c2.u;
                    this.t = true;
                }
                Drawable[] arrdrawable = c2.g;
                this.g = new Drawable[arrdrawable.length];
                this.h = c2.h;
                SparseArray<Drawable.ConstantState> sparseArray = c2.f;
                SparseArray sparseArray2 = sparseArray != null ? sparseArray.clone() : new SparseArray(this.h);
                this.f = sparseArray2;
                int n5 = this.h;
                while (n3 < n5) {
                    if (arrdrawable[n3] != null) {
                        Drawable.ConstantState constantState = arrdrawable[n3].getConstantState();
                        if (constantState != null) {
                            this.f.put(n3, (Object)constantState);
                        } else {
                            this.g[n3] = arrdrawable[n3];
                        }
                    }
                    ++n3;
                }
            } else {
                this.g = new Drawable[10];
                this.h = 0;
            }
        }

        public final int a(Drawable drawable) {
            int n2 = this.h;
            if (n2 >= this.g.length) {
                int n3 = n2 + 10;
                d.a a2 = (d.a)this;
                Drawable[] arrdrawable = new Drawable[n3];
                System.arraycopy((Object)a2.g, (int)0, (Object)arrdrawable, (int)0, (int)n2);
                a2.g = arrdrawable;
                int[][] arrarrn = new int[n3][];
                System.arraycopy((Object)a2.J, (int)0, (Object)arrarrn, (int)0, (int)n2);
                a2.J = arrarrn;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback((Drawable.Callback)this.a);
            this.g[n2] = drawable;
            this.h = 1 + this.h;
            this.e |= drawable.getChangingConfigurations();
            this.r = false;
            this.t = false;
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return n2;
        }

        public void b() {
            this.m = true;
            this.c();
            int n2 = this.h;
            Drawable[] arrdrawable = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3;
                int n4;
                int n5;
                Drawable drawable = arrdrawable[i2];
                int n6 = drawable.getIntrinsicWidth();
                if (n6 > this.n) {
                    this.n = n6;
                }
                if ((n3 = drawable.getIntrinsicHeight()) > this.o) {
                    this.o = n3;
                }
                if ((n4 = drawable.getMinimumWidth()) > this.p) {
                    this.p = n4;
                }
                if ((n5 = drawable.getMinimumHeight()) <= this.q) continue;
                this.q = n5;
            }
        }

        public final void c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null) {
                int n2 = sparseArray.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n3 = this.f.keyAt(i2);
                    Drawable.ConstantState constantState = (Drawable.ConstantState)this.f.valueAt(i2);
                    Drawable[] arrdrawable = this.g;
                    Drawable drawable = constantState.newDrawable(this.b);
                    drawable.setLayoutDirection(this.z);
                    Drawable drawable2 = drawable.mutate();
                    drawable2.setCallback((Drawable.Callback)this.a);
                    arrdrawable[n3] = drawable2;
                }
                this.f = null;
            }
        }

        public boolean canApplyTheme() {
            int n2 = this.h;
            Drawable[] arrdrawable = this.g;
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable.ConstantState constantState;
                Drawable drawable = arrdrawable[i2];
                if (!(drawable != null ? drawable.canApplyTheme() : (constantState = (Drawable.ConstantState)this.f.get(i2)) != null && constantState.canApplyTheme())) continue;
                return true;
            }
            return false;
        }

        public final Drawable d(int n2) {
            int n3;
            Drawable drawable = this.g[n2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null && (n3 = sparseArray.indexOfKey(n2)) >= 0) {
                Drawable drawable2 = ((Drawable.ConstantState)this.f.valueAt(n3)).newDrawable(this.b);
                drawable2.setLayoutDirection(this.z);
                Drawable drawable3 = drawable2.mutate();
                drawable3.setCallback((Drawable.Callback)this.a);
                this.g[n2] = drawable3;
                this.f.removeAt(n3);
                if (this.f.size() == 0) {
                    this.f = null;
                }
                return drawable3;
            }
            return null;
        }

        public abstract void e();

        public final void f(Resources resources) {
            if (resources != null) {
                this.b = resources;
                int n2 = b.d(resources, this.c);
                int n3 = this.c;
                this.c = n2;
                if (n3 != n2) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public int getChangingConfigurations() {
            return this.d | this.e;
        }
    }

}

