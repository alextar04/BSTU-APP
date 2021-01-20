/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  java.lang.Object
 */
package f.l.d;

import android.animation.Animator;
import android.view.View;
import androidx.fragment.app.Fragment;
import f.h.h.a;

public final class f
implements a.a {
    public final /* synthetic */ Fragment a;

    public f(Fragment fragment) {
        this.a = fragment;
    }

    public void a() {
        if (this.a.m() != null) {
            View view = this.a.m();
            this.a.o0(null);
            view.clearAnimation();
        }
        this.a.p0(null);
    }
}

