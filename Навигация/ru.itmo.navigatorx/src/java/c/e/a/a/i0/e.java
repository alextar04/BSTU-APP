/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  c.e.a.a.i0.a
 *  com.google.android.material.internal.CheckableImageButton
 *  java.lang.Float
 *  java.lang.Object
 */
package c.e.a.a.i0;

import android.animation.ValueAnimator;
import c.e.a.a.i0.a;
import c.e.a.a.i0.m;
import com.google.android.material.internal.CheckableImageButton;

public class e
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public e(a a2) {
        this.a = a2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.a.c.setScaleX(f2);
        this.a.c.setScaleY(f2);
    }
}

