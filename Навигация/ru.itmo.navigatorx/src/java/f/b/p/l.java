/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ImageButton
 *  android.widget.ImageView
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import f.b.a;
import f.b.p.e;
import f.b.p.m;
import f.b.p.r0;
import f.b.p.t0;
import f.b.p.u0;

public class l
extends ImageButton {
    public final e e;
    public final m f;

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public l(Context context, AttributeSet attributeSet, int n2) {
        m m2;
        e e2;
        t0.a(context);
        super(context, attributeSet, n2);
        r0.a((View)this, this.getContext());
        this.e = e2 = new e((View)this);
        e2.d(attributeSet, n2);
        this.f = m2 = new m((ImageView)this);
        m2.b(attributeSet, n2);
    }

    public void drawableStateChanged() {
        m m2;
        super.drawableStateChanged();
        e e2 = this.e;
        if (e2 != null) {
            e2.a();
        }
        if ((m2 = this.f) != null) {
            m2.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e e2 = this.e;
        if (e2 != null) {
            return e2.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e e2 = this.e;
        if (e2 != null) {
            return e2.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        u0 u02;
        m m2 = this.f;
        if (m2 != null && (u02 = m2.b) != null) {
            return u02.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        u0 u02;
        m m2 = this.f;
        if (m2 != null && (u02 = m2.b) != null) {
            return u02.b;
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return true ^ this.f.a.getBackground() instanceof RippleDrawable && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e e2 = this.e;
        if (e2 != null) {
            e2.e();
        }
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        e e2 = this.e;
        if (e2 != null) {
            e2.f(n2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m m2 = this.f;
        if (m2 != null) {
            m2.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m m2 = this.f;
        if (m2 != null) {
            m2.a();
        }
    }

    public void setImageResource(int n2) {
        this.f.c(n2);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m m2 = this.f;
        if (m2 != null) {
            m2.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e e2 = this.e;
        if (e2 != null) {
            e2.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e e2 = this.e;
        if (e2 != null) {
            e2.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        m m2 = this.f;
        if (m2 != null) {
            m2.d(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        m m2 = this.f;
        if (m2 != null) {
            m2.e(mode);
        }
    }
}

