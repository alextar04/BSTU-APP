/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.view.View
 *  c.e.a.a.f0.g
 *  com.google.android.material.button.MaterialButton
 *  f.b.k.h
 *  java.lang.Object
 */
package c.e.a.a.q;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import c.e.a.a.b;
import c.e.a.a.f0.g;
import c.e.a.a.f0.j;
import c.e.a.a.f0.n;
import com.google.android.material.button.MaterialButton;
import f.b.k.h;

public class a {
    public final MaterialButton a;
    public j b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;

    public a(MaterialButton materialButton, j j2) {
        this.a = materialButton;
        this.b = j2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public n a() {
        Drawable drawable;
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) return null;
        if (this.r.getNumberOfLayers() > 2) {
            drawable = this.r.getDrawable(2);
            do {
                return (n)drawable;
                break;
            } while (true);
        }
        drawable = this.r.getDrawable(1);
        return (n)drawable;
    }

    public g b() {
        return this.c(false);
    }

    public final g c(boolean bl) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            return (g)((LayerDrawable)((InsetDrawable)this.r.getDrawable(0)).getDrawable()).getDrawable(bl ^ true);
        }
        return null;
    }

    public final g d() {
        return this.c(true);
    }

    public void e(j j2) {
        this.b = j2;
        if (this.b() != null) {
            g g2 = this.b();
            g2.e.a = j2;
            g2.invalidateSelf();
        }
        if (this.d() != null) {
            g g3 = this.d();
            g3.e.a = j2;
            g3.invalidateSelf();
        }
        if (this.a() != null) {
            this.a().setShapeAppearanceModel(j2);
        }
    }

    public final void f() {
        g g2 = this.b();
        g g3 = this.d();
        if (g2 != null) {
            g2.t((float)this.h, this.k);
            if (g3 != null) {
                float f2 = this.h;
                int n2 = this.n ? h.i.c0((View)this.a, b.colorSurface) : 0;
                g3.s(f2, n2);
            }
        }
    }
}

