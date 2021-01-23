/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.TextView
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import f.b.a;
import f.b.p.e;
import f.b.p.i;
import f.b.p.r0;
import f.b.p.t0;
import f.b.p.x;

public class g
extends CheckBox {
    public final i e;
    public final e f;
    public final x g;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkboxStyle);
    }

    public g(Context context, AttributeSet attributeSet, int n2) {
        e e2;
        i i2;
        x x2;
        t0.a(context);
        super(context, attributeSet, n2);
        r0.a((View)this, this.getContext());
        this.e = i2 = new i((CompoundButton)this);
        i2.b(attributeSet, n2);
        this.f = e2 = new e((View)this);
        e2.d(attributeSet, n2);
        this.g = x2 = new x((TextView)this);
        x2.e(attributeSet, n2);
    }

    public void drawableStateChanged() {
        x x2;
        super.drawableStateChanged();
        e e2 = this.f;
        if (e2 != null) {
            e2.a();
        }
        if ((x2 = this.g) != null) {
            x2.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int n2 = super.getCompoundPaddingLeft();
        return n2;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e e2 = this.f;
        if (e2 != null) {
            return e2.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e e2 = this.f;
        if (e2 != null) {
            return e2.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        i i2 = this.e;
        if (i2 != null) {
            return i2.b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i i2 = this.e;
        if (i2 != null) {
            return i2.c;
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e e2 = this.f;
        if (e2 != null) {
            e2.e();
        }
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        e e2 = this.f;
        if (e2 != null) {
            e2.f(n2);
        }
    }

    public void setButtonDrawable(int n2) {
        this.setButtonDrawable(f.b.l.a.a.b(this.getContext(), n2));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i i2 = this.e;
        if (i2 != null) {
            if (i2.f) {
                i2.f = false;
                return;
            }
            i2.f = true;
            i2.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e e2 = this.f;
        if (e2 != null) {
            e2.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e e2 = this.f;
        if (e2 != null) {
            e2.i(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i i2 = this.e;
        if (i2 != null) {
            i2.b = colorStateList;
            i2.d = true;
            i2.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i i2 = this.e;
        if (i2 != null) {
            i2.c = mode;
            i2.e = true;
            i2.a();
        }
    }
}

