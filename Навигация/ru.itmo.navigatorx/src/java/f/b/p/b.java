/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.widget.ActionBarContainer
 */
package f.b.p;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

public class b
extends Drawable {
    public final ActionBarContainer a;

    public b(ActionBarContainer actionBarContainer) {
        this.a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.a;
        if (actionBarContainer.l) {
            Drawable drawable = actionBarContainer.k;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
        } else {
            Drawable drawable = actionBarContainer.i;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            ActionBarContainer actionBarContainer2 = this.a;
            Drawable drawable2 = actionBarContainer2.j;
            if (drawable2 != null && actionBarContainer2.m) {
                drawable2.draw(canvas);
            }
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.a;
        if (actionBarContainer.l ? (drawable = actionBarContainer.k) != null : (drawable = actionBarContainer.i) != null) {
            drawable.getOutline(outline);
        }
    }

    public void setAlpha(int n2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

