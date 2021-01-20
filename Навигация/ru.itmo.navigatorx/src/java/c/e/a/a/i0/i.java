/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  c.e.a.a.i0.h
 *  com.google.android.material.internal.CheckableImageButton
 *  java.lang.Float
 *  java.lang.Object
 */
package c.e.a.a.i0;

import android.animation.ValueAnimator;
import c.e.a.a.i0.h;
import c.e.a.a.i0.m;
import com.google.android.material.internal.CheckableImageButton;

public class i
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ h a;

    public i(h h2) {
        this.a = h2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.a.c.setAlpha(f2);
    }
}

