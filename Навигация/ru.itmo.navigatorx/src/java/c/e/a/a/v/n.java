/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityNodeInfo
 *  com.google.android.material.datepicker.MaterialCalendarGridView
 *  f.h.l.v.b
 *  java.lang.Object
 */
package c.e.a.a.v;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import f.h.l.a;
import f.h.l.v.b;

public class n
extends a {
    public n(MaterialCalendarGridView materialCalendarGridView) {
    }

    @Override
    public void d(View view, b b2) {
        this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
        b2.i(null);
    }
}

