/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.TextView
 *  android.widget.ToggleButton
 */
package f.b.p;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import f.b.p.r0;
import f.b.p.x;

public class a0
extends ToggleButton {
    public final x e;

    public a0(Context context, AttributeSet attributeSet) {
        x x2;
        super(context, attributeSet, 16842827);
        r0.a((View)this, this.getContext());
        this.e = x2 = new x((TextView)this);
        x2.e(attributeSet, 16842827);
    }
}

