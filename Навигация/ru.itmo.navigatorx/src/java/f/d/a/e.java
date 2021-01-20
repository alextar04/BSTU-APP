/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 */
package f.d.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class e
extends Drawable {
    public float a;
    public float b;
    public boolean c;
    public boolean d;
    public ColorStateList e;
    public PorterDuffColorFilter f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = this.getBounds();
        }
        throw null;
    }

    public void draw(Canvas canvas) {
        if (this.f == null) {
            float f2 = this.a;
            canvas.drawRoundRect(null, f2, f2, null);
            return;
        }
        throw null;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(null, this.a);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.g;
        return colorStateList2 != null && colorStateList2.isStateful() || (colorStateList = this.e) != null && colorStateList.isStateful() || super.isStateful();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.b(rect);
        throw null;
    }

    public boolean onStateChange(int[] arrn) {
        ColorStateList colorStateList = this.e;
        colorStateList.getColorForState(arrn, colorStateList.getDefaultColor());
        throw null;
    }

    public void setAlpha(int n2) {
        throw null;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw null;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.g = colorStateList;
        this.f = this.a(colorStateList, this.h);
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.h = mode;
        this.f = this.a(this.g, mode);
        this.invalidateSelf();
    }
}

