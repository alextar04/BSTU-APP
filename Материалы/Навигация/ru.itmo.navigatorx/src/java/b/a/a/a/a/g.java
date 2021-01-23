/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.view.View
 *  android.widget.TextView
 *  b.a.a.a.a.a
 *  h.m.b.j
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.widget.TextView;
import b.a.a.a.a.a;
import b.a.a.c;
import h.m.b.j;

public final class g
implements Animator.AnimatorListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AnimatorSet c;

    public g(a a2, int n2, AnimatorSet animatorSet) {
        this.a = a2;
        this.b = n2;
        this.c = animatorSet;
    }

    public void onAnimationCancel(Animator animator) {
        j.f((Object)animator, (String)"animator");
    }

    public void onAnimationEnd(Animator animator) {
        j.f((Object)animator, (String)"animator");
        TextView textView = (TextView)this.a.w0(c.floor_number);
        j.d((Object)textView, (String)"floor_number");
        textView.setText((CharSequence)String.valueOf((int)this.b));
        this.c.start();
    }

    public void onAnimationRepeat(Animator animator) {
        j.f((Object)animator, (String)"animator");
    }

    public void onAnimationStart(Animator animator) {
        j.f((Object)animator, (String)"animator");
    }
}

