/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.widget.FrameLayout
 *  f.b.k.h
 *  f.h.l.l
 *  java.lang.Object
 */
package c.e.a.a.g0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import c.e.a.a.g0.b;
import c.e.a.a.g0.c;
import c.e.a.a.k;
import f.b.k.h;
import f.h.l.l;

public class d
extends FrameLayout {
    public static final View.OnTouchListener l = new View.OnTouchListener(){

        @SuppressLint(value={"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    public c e;
    public b f;
    public int g;
    public final float h;
    public final float i;
    public ColorStateList j;
    public PorterDuff.Mode k;

    public d(Context context, AttributeSet attributeSet) {
        super(c.e.a.a.j0.a.a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = this.getContext();
        TypedArray typedArray = context2.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        if (typedArray.hasValue(k.SnackbarLayout_elevation)) {
            l.X((View)this, (float)typedArray.getDimensionPixelSize(k.SnackbarLayout_elevation, 0));
        }
        this.g = typedArray.getInt(k.SnackbarLayout_animationMode, 0);
        this.h = typedArray.getFloat(k.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        this.setBackgroundTintList(h.i.d0(context2, typedArray, k.SnackbarLayout_backgroundTint));
        this.setBackgroundTintMode(h.i.l1(typedArray.getInt(k.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.i = typedArray.getFloat(k.SnackbarLayout_actionTextColorAlpha, 1.0f);
        typedArray.recycle();
        this.setOnTouchListener(l);
        this.setFocusable(true);
        if (this.getBackground() == null) {
            float f2 = this.getResources().getDimension(c.e.a.a.d.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f2);
            int n2 = c.e.a.a.b.colorSurface;
            int n3 = c.e.a.a.b.colorOnSurface;
            float f3 = this.getBackgroundOverlayColorAlpha();
            gradientDrawable.setColor(h.i.P0(h.i.c0((View)this, n2), h.i.c0((View)this, n3), f3));
            ColorStateList colorStateList = this.j;
            if (colorStateList != null) {
                gradientDrawable.setTintList(colorStateList);
            }
            l.V((View)this, (Drawable)gradientDrawable);
        }
    }

    public float getActionTextColorAlpha() {
        return this.i;
    }

    public int getAnimationMode() {
        return this.g;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.h;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b b2 = this.f;
        if (b2 != null) {
            b2.onViewAttachedToWindow((View)this);
        }
        l.Q((View)this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b b2 = this.f;
        if (b2 != null) {
            b2.onViewDetachedFromWindow((View)this);
        }
    }

    public void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        c c2 = this.e;
        if (c2 != null) {
            c2.a((View)this, n2, n3, n4, n5);
        }
    }

    public void setAnimationMode(int n2) {
        this.g = n2;
    }

    public void setBackground(Drawable drawable) {
        this.setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.j != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.j);
            drawable.setTintMode(this.k);
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        if (this.getBackground() != null) {
            Drawable drawable = this.getBackground().mutate();
            drawable.setTintList(colorStateList);
            drawable.setTintMode(this.k);
            if (drawable != this.getBackground()) {
                super.setBackgroundDrawable(drawable);
            }
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        if (this.getBackground() != null) {
            Drawable drawable = this.getBackground().mutate();
            drawable.setTintMode(mode);
            if (drawable != this.getBackground()) {
                super.setBackgroundDrawable(drawable);
            }
        }
    }

    public void setOnAttachStateChangeListener(b b2) {
        this.f = b2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        View.OnTouchListener onTouchListener = onClickListener != null ? null : l;
        this.setOnTouchListener(onTouchListener);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(c c2) {
        this.e = c2;
    }

}

