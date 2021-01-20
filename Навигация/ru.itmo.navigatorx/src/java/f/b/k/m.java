/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  androidx.appcompat.widget.ActionBarContextView
 *  f.b.k.h
 *  f.h.l.l
 *  f.h.l.q
 *  f.h.l.r
 *  f.h.l.s
 */
package f.b.k;

import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.ActionBarContextView;
import f.b.k.h;
import f.h.l.l;
import f.h.l.q;
import f.h.l.r;
import f.h.l.s;

public class m
extends s {
    public final /* synthetic */ h a;

    public m(h h2) {
        this.a = h2;
    }

    public void a(View view) {
        this.a.s.setAlpha(1.0f);
        this.a.v.d(null);
        this.a.v = null;
    }

    public void b(View view) {
        this.a.s.setVisibility(0);
        this.a.s.sendAccessibilityEvent(32);
        if (this.a.s.getParent() instanceof View) {
            l.Q((View)((View)this.a.s.getParent()));
        }
    }
}

