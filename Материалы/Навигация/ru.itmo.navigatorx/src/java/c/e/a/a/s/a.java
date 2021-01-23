/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CheckBox
 */
package c.e.a.a.s;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import c.e.a.a.b;
import c.e.a.a.j;
import c.e.a.a.k;
import f.b.k.h;
import f.b.p.g;

public class a
extends g {
    public static final int j = j.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[][] k = new int[][]{{16842910, 16842912}, {16842910, -16842912}, {-16842910, 16842912}, {-16842910, -16842912}};
    public ColorStateList h;
    public boolean i;

    public a(Context context, AttributeSet attributeSet) {
        int n2 = b.checkboxStyle;
        super(c.e.a.a.j0.a.a.a(context, attributeSet, n2, j), attributeSet, n2);
        Context context2 = this.getContext();
        TypedArray typedArray = c.e.a.a.a0.j.d(context2, attributeSet, k.MaterialCheckBox, n2, j, new int[0]);
        if (typedArray.hasValue(k.MaterialCheckBox_buttonTint)) {
            this.setButtonTintList(h.i.d0(context2, typedArray, k.MaterialCheckBox_buttonTint));
        }
        this.i = typedArray.getBoolean(k.MaterialCheckBox_useMaterialThemeColors, false);
        typedArray.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.h == null) {
            int[] arrn = new int[k.length];
            int n2 = h.i.c0((View)this, b.colorControlActivated);
            int n3 = h.i.c0((View)this, b.colorSurface);
            int n4 = h.i.c0((View)this, b.colorOnSurface);
            arrn[0] = h.i.P0(n3, n2, 1.0f);
            arrn[1] = h.i.P0(n3, n4, 0.54f);
            arrn[2] = h.i.P0(n3, n4, 0.38f);
            arrn[3] = h.i.P0(n3, n4, 0.38f);
            this.h = new ColorStateList(k, arrn);
        }
        return this.h;
    }

    public void onAttachedToWindow() {
        CheckBox.super.onAttachedToWindow();
        if (this.i && this.getButtonTintList() == null) {
            this.setUseMaterialThemeColors(true);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setUseMaterialThemeColors(boolean bl) {
        this.i = bl;
        ColorStateList colorStateList = bl ? this.getMaterialThemeColorsTintList() : null;
        this.setButtonTintList(colorStateList);
    }
}

