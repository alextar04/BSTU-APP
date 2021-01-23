/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityNodeInfo
 *  c.e.a.a.v.g
 *  f.h.l.v.b
 *  java.lang.CharSequence
 *  java.lang.String
 */
package c.e.a.a.v;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import c.e.a.a.v.g;
import f.h.l.a;
import f.h.l.v.b;

public class i
extends a {
    public final /* synthetic */ g d;

    public i(g g2) {
        this.d = g2;
    }

    @Override
    public void d(View view, b b2) {
        g g2;
        int n2;
        this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
        if (this.d.j0.getVisibility() == 0) {
            g2 = this.d;
            n2 = c.e.a.a.i.mtrl_picker_toggle_to_year_selection;
        } else {
            g2 = this.d;
            n2 = c.e.a.a.i.mtrl_picker_toggle_to_day_selection;
        }
        b2.k((CharSequence)g2.z(n2));
    }
}

