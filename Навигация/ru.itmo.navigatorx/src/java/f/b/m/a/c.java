/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  java.lang.Runnable
 */
package f.b.m.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class c
extends Drawable
implements Drawable.Callback {
    public Drawable e;

    public c(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
    }

    public void draw(Canvas canvas) {
        this.e.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.e.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.e.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.e.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.e.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.e.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.e.getMinimumWidth();
    }

    public int getOpacity() {
        return this.e.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.e.getPadding(rect);
    }

    public int[] getState() {
        return this.e.getState();
    }

    public Region getTransparentRegion() {
        return this.e.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.e.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.e.isStateful();
    }

    public void jumpToCurrentState() {
        this.e.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.e.setBounds(rect);
    }

    public boolean onLevelChange(int n2) {
        return this.e.setLevel(n2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        this.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        this.e.setAlpha(n2);
    }

    public void setAutoMirrored(boolean bl) {
        this.e.setAutoMirrored(bl);
    }

    public void setChangingConfigurations(int n2) {
        this.e.setChangingConfigurations(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl) {
        this.e.setDither(bl);
    }

    public void setFilterBitmap(boolean bl) {
        this.e.setFilterBitmap(bl);
    }

    public void setHotspot(float f2, float f3) {
        this.e.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        this.e.setHotspotBounds(n2, n3, n4, n5);
    }

    public boolean setState(int[] arrn) {
        return this.e.setState(arrn);
    }

    public void setTint(int n2) {
        this.e.setTint(n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.e.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.e.setTintMode(mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        return super.setVisible(bl, bl2) || this.e.setVisible(bl, bl2);
        {
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}

