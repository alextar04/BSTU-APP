/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  f.h.l.l
 *  java.lang.Object
 *  java.lang.Throwable
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import f.b.p.d0;
import f.b.p.j;
import f.b.p.u0;
import f.b.p.w0;
import f.h.l.l;

public class e {
    public final View a;
    public final j b;
    public int c = -1;
    public u0 d;
    public u0 e;
    public u0 f;

    public e(View view) {
        this.a = view;
        this.b = j.a();
    }

    public void a() {
        Drawable drawable = this.a.getBackground();
        if (drawable != null) {
            u0 u02;
            u0 u03 = this.d;
            boolean bl = true;
            boolean bl2 = u03 != null ? bl : false;
            if (bl2) {
                PorterDuff.Mode mode;
                if (this.f == null) {
                    this.f = new u0();
                }
                u0 u04 = this.f;
                u04.a = null;
                u04.d = false;
                u04.b = null;
                u04.c = false;
                ColorStateList colorStateList = l.g((View)this.a);
                if (colorStateList != null) {
                    u04.d = bl;
                    u04.a = colorStateList;
                }
                if ((mode = this.a.getBackgroundTintMode()) != null) {
                    u04.c = bl;
                    u04.b = mode;
                }
                if (!u04.d && !u04.c) {
                    bl = false;
                } else {
                    j.f(drawable, u04, this.a.getDrawableState());
                }
                if (bl) {
                    return;
                }
            }
            if ((u02 = this.e) != null) {
                j.f(drawable, u02, this.a.getDrawableState());
                return;
            }
            u0 u05 = this.d;
            if (u05 != null) {
                j.f(drawable, u05, this.a.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        u0 u02 = this.e;
        if (u02 != null) {
            return u02.a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        u0 u02 = this.e;
        if (u02 != null) {
            return u02.b;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(AttributeSet attributeSet, int n2) {
        Throwable throwable2;
        w0 w02;
        block5 : {
            w02 = w0.q(this.a.getContext(), attributeSet, f.b.j.ViewBackgroundHelper, n2, 0);
            View view = this.a;
            l.R((View)view, (Context)view.getContext(), (int[])f.b.j.ViewBackgroundHelper, (AttributeSet)attributeSet, (TypedArray)w02.b, (int)n2, (int)0);
            try {
                if (w02.o(f.b.j.ViewBackgroundHelper_android_background)) {
                    this.c = w02.l(f.b.j.ViewBackgroundHelper_android_background, -1);
                    ColorStateList colorStateList = this.b.d(this.a.getContext(), this.c);
                    if (colorStateList != null) {
                        this.g(colorStateList);
                    }
                }
                if (w02.o(f.b.j.ViewBackgroundHelper_backgroundTint)) {
                    this.a.setBackgroundTintList(w02.c(f.b.j.ViewBackgroundHelper_backgroundTint));
                }
                if (!w02.o(f.b.j.ViewBackgroundHelper_backgroundTintMode)) break block5;
                this.a.setBackgroundTintMode(d0.c(w02.j(f.b.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            catch (Throwable throwable2) {}
        }
        w02.b.recycle();
        return;
        w02.b.recycle();
        throw throwable2;
    }

    public void e() {
        this.c = -1;
        this.g(null);
        this.a();
    }

    public void f(int n2) {
        this.c = n2;
        j j2 = this.b;
        ColorStateList colorStateList = j2 != null ? j2.d(this.a.getContext(), n2) : null;
        this.g(colorStateList);
        this.a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new u0();
            }
            u0 u02 = this.d;
            u02.a = colorStateList;
            u02.d = true;
        } else {
            this.d = null;
        }
        this.a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new u0();
        }
        u0 u02 = this.e;
        u02.a = colorStateList;
        u02.d = true;
        this.a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new u0();
        }
        u0 u02 = this.e;
        u02.b = mode;
        u02.c = true;
        this.a();
    }
}

