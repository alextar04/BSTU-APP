/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  androidx.appcompat.widget.ActionMenuView
 *  com.google.android.material.bottomappbar.BottomAppBar
 */
package c.e.a.a.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

public class d
extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ ActionMenuView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ BottomAppBar e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int n2, boolean bl) {
        this.e = bottomAppBar;
        this.b = actionMenuView;
        this.c = n2;
        this.d = bl;
    }

    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            BottomAppBar.x((BottomAppBar)this.e, (ActionMenuView)this.b, (int)this.c, (boolean)this.d);
        }
    }
}

