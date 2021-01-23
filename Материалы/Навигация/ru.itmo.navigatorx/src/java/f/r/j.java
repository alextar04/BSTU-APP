/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  java.lang.Object
 *  java.util.ArrayList
 */
package f.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import f.e.a;
import f.r.i;
import java.util.ArrayList;

public class j
extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;
    public final /* synthetic */ i b;

    public j(i i2, a a2) {
        this.b = i2;
        this.a = a2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.remove((Object)animator);
        this.b.A.remove((Object)animator);
    }

    public void onAnimationStart(Animator animator) {
        this.b.A.add((Object)animator);
    }
}

