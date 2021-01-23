/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  c.e.a.a.f0.g
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  java.lang.Float
 *  java.lang.Object
 */
package c.e.a.a.p;

import android.animation.ValueAnimator;
import c.e.a.a.f0.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class a
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomSheetBehavior a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        g g2 = this.a.j;
        if (g2 != null) {
            g2.r(f2);
        }
    }
}

