/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior
 *  f.h.l.v.d
 *  f.h.l.v.d$a
 *  java.lang.Object
 */
package c.e.a.a.m;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import f.h.l.v.d;

public class d
implements f.h.l.v.d {
    public final /* synthetic */ AppBarLayout a;
    public final /* synthetic */ boolean b;

    public d(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean bl) {
        this.a = appBarLayout;
        this.b = bl;
    }

    public boolean a(View view, d.a a2) {
        this.a.setExpanded(this.b);
        return true;
    }
}

