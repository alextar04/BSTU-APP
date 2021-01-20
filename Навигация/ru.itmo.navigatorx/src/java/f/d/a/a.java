/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.widget.FrameLayout
 *  f.d.a.b
 */
package f.d.a;

import android.content.res.ColorStateList;
import android.widget.FrameLayout;
import f.d.a.b;
import f.d.a.c;
import f.d.a.d;

public class a
extends FrameLayout {
    public static final d g = new b();
    public boolean e;
    public boolean f;

    public ColorStateList getCardBackgroundColor() {
        (b)g;
        throw null;
    }

    public float getCardElevation() {
        throw null;
    }

    public int getContentPaddingBottom() {
        throw null;
    }

    public int getContentPaddingLeft() {
        throw null;
    }

    public int getContentPaddingRight() {
        throw null;
    }

    public int getContentPaddingTop() {
        throw null;
    }

    public float getMaxCardElevation() {
        return ((b)g).b(null);
    }

    public boolean getPreventCornerOverlap() {
        return this.f;
    }

    public float getRadius() {
        return ((b)g).c(null);
    }

    public boolean getUseCompatPadding() {
        return this.e;
    }

    public void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
    }

    public void setCardBackgroundColor(int n2) {
        d d2 = g;
        ColorStateList colorStateList = ColorStateList.valueOf((int)n2);
        ((b)d2).d(null, colorStateList);
        throw null;
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        ((b)g).d(null, colorStateList);
        throw null;
    }

    public void setCardElevation(float f2) {
        throw null;
    }

    public void setMaxCardElevation(float f2) {
        ((b)g).e(null, f2);
    }

    public void setMinimumHeight(int n2) {
        super.setMinimumHeight(n2);
    }

    public void setMinimumWidth(int n2) {
        super.setMinimumWidth(n2);
    }

    public void setPadding(int n2, int n3, int n4, int n5) {
    }

    public void setPaddingRelative(int n2, int n3, int n4, int n5) {
    }

    public void setPreventCornerOverlap(boolean bl) {
        if (bl == this.f) {
            return;
        }
        this.f = bl;
        (b)g;
        throw null;
    }

    public void setRadius(float f2) {
        (b)g;
        throw null;
    }

    public void setUseCompatPadding(boolean bl) {
        if (this.e == bl) {
            return;
        }
        this.e = bl;
        (b)g;
        throw null;
    }
}

