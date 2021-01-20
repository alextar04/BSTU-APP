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
 *  android.widget.ImageView
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
import android.widget.ImageView;
import f.b.l.a.a;
import f.b.p.d0;
import f.b.p.j;
import f.b.p.u0;
import f.b.p.w0;
import f.h.l.l;

public class m {
    public final ImageView a;
    public u0 b;

    public m(ImageView imageView) {
        this.a = imageView;
    }

    public void a() {
        u0 u02;
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            d0.b(drawable);
        }
        if (drawable != null && (u02 = this.b) != null) {
            j.f(drawable, u02, this.a.getDrawableState());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(AttributeSet attributeSet, int n2) {
        Throwable throwable2;
        w0 w02;
        block5 : {
            w02 = w0.q(this.a.getContext(), attributeSet, f.b.j.AppCompatImageView, n2, 0);
            ImageView imageView = this.a;
            l.R((View)imageView, (Context)imageView.getContext(), (int[])f.b.j.AppCompatImageView, (AttributeSet)attributeSet, (TypedArray)w02.b, (int)n2, (int)0);
            try {
                int n3;
                Drawable drawable = this.a.getDrawable();
                if (drawable == null && (n3 = w02.l(f.b.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = a.b(this.a.getContext(), n3)) != null) {
                    this.a.setImageDrawable(drawable);
                }
                if (drawable != null) {
                    d0.b(drawable);
                }
                if (w02.o(f.b.j.AppCompatImageView_tint)) {
                    this.a.setImageTintList(w02.c(f.b.j.AppCompatImageView_tint));
                }
                if (!w02.o(f.b.j.AppCompatImageView_tintMode)) break block5;
                this.a.setImageTintMode(d0.c(w02.j(f.b.j.AppCompatImageView_tintMode, -1), null));
            }
            catch (Throwable throwable2) {}
        }
        w02.b.recycle();
        return;
        w02.b.recycle();
        throw throwable2;
    }

    public void c(int n2) {
        if (n2 != 0) {
            Drawable drawable = a.b(this.a.getContext(), n2);
            if (drawable != null) {
                d0.b(drawable);
            }
            this.a.setImageDrawable(drawable);
        } else {
            this.a.setImageDrawable(null);
        }
        this.a();
    }

    public void d(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new u0();
        }
        u0 u02 = this.b;
        u02.a = colorStateList;
        u02.d = true;
        this.a();
    }

    public void e(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new u0();
        }
        u0 u02 = this.b;
        u02.b = mode;
        u02.c = true;
        this.a();
    }
}

