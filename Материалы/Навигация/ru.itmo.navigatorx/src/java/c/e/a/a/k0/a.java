/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  com.google.android.material.transformation.FabTransformationBehavior
 *  java.lang.Object
 */
package c.e.a.a.k0;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

public class a
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public a(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.invalidate();
    }
}

