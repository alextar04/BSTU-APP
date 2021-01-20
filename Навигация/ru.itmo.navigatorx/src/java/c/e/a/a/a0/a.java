/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  com.google.android.material.internal.CheckableImageButton
 *  f.h.l.v.b
 */
package c.e.a.a.a0;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.CheckableImageButton;
import f.h.l.v.b;

public class a
extends f.h.l.a {
    public final /* synthetic */ CheckableImageButton d;

    public a(CheckableImageButton checkableImageButton) {
        this.d = checkableImageButton;
    }

    @Override
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.d.isChecked());
    }

    @Override
    public void d(View view, b b2) {
        this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
        boolean bl = this.d.h;
        b2.a.setCheckable(bl);
        boolean bl2 = this.d.isChecked();
        b2.a.setChecked(bl2);
    }
}

