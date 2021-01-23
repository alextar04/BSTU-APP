/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.SeekBar
 *  f.h.l.l
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import f.b.j;
import f.b.p.d0;
import f.b.p.p;
import f.b.p.w0;
import f.h.l.l;

public class t
extends p {
    public final SeekBar d;
    public Drawable e;
    public ColorStateList f = null;
    public PorterDuff.Mode g = null;
    public boolean h = false;
    public boolean i = false;

    public t(SeekBar seekBar) {
        super((ProgressBar)seekBar);
        this.d = seekBar;
    }

    @Override
    public void a(AttributeSet attributeSet, int n2) {
        super.a(attributeSet, n2);
        w0 w02 = w0.q(this.d.getContext(), attributeSet, j.AppCompatSeekBar, n2, 0);
        SeekBar seekBar = this.d;
        l.R((View)seekBar, (Context)seekBar.getContext(), (int[])j.AppCompatSeekBar, (AttributeSet)attributeSet, (TypedArray)w02.b, (int)n2, (int)0);
        Drawable drawable = w02.h(j.AppCompatSeekBar_android_thumb);
        if (drawable != null) {
            this.d.setThumb(drawable);
        }
        Drawable drawable2 = w02.g(j.AppCompatSeekBar_tickMark);
        Drawable drawable3 = this.e;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        this.e = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this.d);
            drawable2.setLayoutDirection(l.n((View)this.d));
            if (drawable2.isStateful()) {
                drawable2.setState(this.d.getDrawableState());
            }
            this.c();
        }
        this.d.invalidate();
        if (w02.o(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = d0.c(w02.j(j.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (w02.o(j.AppCompatSeekBar_tickMarkTint)) {
            this.f = w02.c(j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        w02.b.recycle();
        this.c();
    }

    public final void c() {
        if (this.e != null && (this.h || this.i)) {
            Drawable drawable;
            this.e = drawable = this.e.mutate();
            if (this.h) {
                drawable.setTintList(this.f);
            }
            if (this.i) {
                this.e.setTintMode(this.g);
            }
            if (this.e.isStateful()) {
                this.e.setState(this.d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        int n2;
        int n3;
        if (this.e != null && (n2 = this.d.getMax()) > (n3 = 1)) {
            int n4 = this.e.getIntrinsicWidth();
            int n5 = this.e.getIntrinsicHeight();
            int n6 = n4 >= 0 ? n4 / 2 : n3;
            if (n5 >= 0) {
                n3 = n5 / 2;
            }
            this.e.setBounds(-n6, -n3, n6, n3);
            float f2 = (float)(this.d.getWidth() - this.d.getPaddingLeft() - this.d.getPaddingRight()) / (float)n2;
            int n7 = canvas.save();
            canvas.translate((float)this.d.getPaddingLeft(), (float)(this.d.getHeight() / 2));
            for (int i2 = 0; i2 <= n2; ++i2) {
                this.e.draw(canvas);
                canvas.translate(f2, 0.0f);
            }
            canvas.restoreToCount(n7);
        }
    }
}

