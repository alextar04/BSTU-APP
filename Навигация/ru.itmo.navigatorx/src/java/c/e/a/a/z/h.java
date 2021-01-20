/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.AnimatorSet$Builder
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.animation.TimeInterpolator
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$b
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package c.e.a.a.z;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import c.e.a.a.e0.b;
import c.e.a.a.z.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class h
extends e {
    public h(FloatingActionButton floatingActionButton, b b2) {
        super(floatingActionButton, b2);
    }

    @Override
    public float c() {
        return this.t.getElevation();
    }

    @Override
    public void d(Rect rect) {
        if (((FloatingActionButton.b)this.u).a.n) {
            super.d(rect);
            return;
        }
        boolean bl = this.r();
        int n2 = 0;
        if (!bl) {
            n2 = (0 - this.t.getSizeDimension()) / 2;
        }
        rect.set(n2, n2, n2, n2);
    }

    @Override
    public void g() {
    }

    @Override
    public void h() {
        this.t();
    }

    @Override
    public void i(int[] arrn) {
    }

    @Override
    public void j(float f2, float f3, float f4) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(e.B, this.u(f2, f4));
        stateListAnimator.addState(e.C, this.u(f2, f3));
        stateListAnimator.addState(e.D, this.u(f2, f3));
        stateListAnimator.addState(e.E, this.u(f2, f3));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)ObjectAnimator.ofFloat((Object)this.t, (String)"elevation", (float[])new float[]{f2}).setDuration(0L));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.t;
            Property property = View.TRANSLATION_Z;
            float[] arrf = new float[]{floatingActionButton.getTranslationZ()};
            arrayList.add((Object)ObjectAnimator.ofFloat((Object)floatingActionButton, (Property)property, (float[])arrf).setDuration(100L));
        }
        arrayList.add((Object)ObjectAnimator.ofFloat((Object)this.t, (Property)View.TRANSLATION_Z, (float[])new float[]{0.0f}).setDuration(100L));
        animatorSet.playSequentially((Animator[])arrayList.toArray((Object[])new Animator[0]));
        animatorSet.setInterpolator(e.A);
        stateListAnimator.addState(e.F, (Animator)animatorSet);
        stateListAnimator.addState(e.G, this.u(0.0f, 0.0f));
        this.t.setStateListAnimator(stateListAnimator);
        if (this.p()) {
            this.t();
        }
    }

    @Override
    public boolean m() {
        return false;
    }

    @Override
    public void o(ColorStateList colorStateList) {
    }

    @Override
    public boolean p() {
        return ((FloatingActionButton.b)this.u).a.n || !this.r();
        {
        }
    }

    @Override
    public void s() {
    }

    public final Animator u(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play((Animator)ObjectAnimator.ofFloat((Object)this.t, (String)"elevation", (float[])new float[]{f2}).setDuration(0L)).with((Animator)ObjectAnimator.ofFloat((Object)this.t, (Property)View.TRANSLATION_Z, (float[])new float[]{f3}).setDuration(100L));
        animatorSet.setInterpolator(e.A);
        return animatorSet;
    }
}

