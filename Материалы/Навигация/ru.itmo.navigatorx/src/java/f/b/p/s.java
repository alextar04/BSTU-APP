/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.SeekBar
 *  f.b.p.t
 */
package f.b.p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import f.b.a;
import f.b.p.r0;
import f.b.p.t;

public class s
extends SeekBar {
    public final t e;

    public s(Context context, AttributeSet attributeSet) {
        t t2;
        int n2 = a.seekBarStyle;
        super(context, attributeSet, n2);
        r0.a((View)this, this.getContext());
        this.e = t2 = new t((SeekBar)this);
        t2.a(attributeSet, n2);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        t t2 = this.e;
        Drawable drawable = t2.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(t2.d.getDrawableState())) {
            t2.d.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.e.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onDraw(Canvas canvas) {
        s s2 = this;
        synchronized (s2) {
            super.onDraw(canvas);
            this.e.d(canvas);
            return;
        }
    }
}

