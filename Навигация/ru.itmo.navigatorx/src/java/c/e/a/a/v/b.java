/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.view.View
 *  android.widget.TextView
 *  c.e.a.a.f0.a
 *  c.e.a.a.f0.g
 *  f.b.k.h
 *  f.h.l.l
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.v;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import c.e.a.a.f0.a;
import c.e.a.a.f0.c;
import c.e.a.a.f0.g;
import c.e.a.a.f0.j;
import c.e.a.a.k;
import f.b.k.h;
import f.h.l.l;

public final class b {
    public final Rect a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;
    public final j f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int n2, j j2, Rect rect) {
        h.i.m(rect.left);
        h.i.m(rect.top);
        h.i.m(rect.right);
        h.i.m(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.d = colorStateList3;
        this.e = n2;
        this.f = j2;
    }

    public static b a(Context context, int n2) {
        boolean bl = n2 != 0;
        if (bl) {
            TypedArray typedArray = context.obtainStyledAttributes(n2, k.MaterialCalendarItem);
            Rect rect = new Rect(typedArray.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetLeft, 0), typedArray.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetTop, 0), typedArray.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetRight, 0), typedArray.getDimensionPixelOffset(k.MaterialCalendarItem_android_insetBottom, 0));
            ColorStateList colorStateList = h.i.d0(context, typedArray, k.MaterialCalendarItem_itemFillColor);
            ColorStateList colorStateList2 = h.i.d0(context, typedArray, k.MaterialCalendarItem_itemTextColor);
            ColorStateList colorStateList3 = h.i.d0(context, typedArray, k.MaterialCalendarItem_itemStrokeColor);
            int n3 = typedArray.getDimensionPixelSize(k.MaterialCalendarItem_itemStrokeWidth, 0);
            j j2 = j.a(context, typedArray.getResourceId(k.MaterialCalendarItem_itemShapeAppearance, 0), typedArray.getResourceId(k.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), (c)new a((float)false)).a();
            typedArray.recycle();
            b b2 = new b(colorStateList, colorStateList2, colorStateList3, n3, j2, rect);
            return b2;
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    public void b(TextView textView) {
        g g2 = new g();
        g g3 = new g();
        g2.setShapeAppearanceModel(this.f);
        g3.setShapeAppearanceModel(this.f);
        g2.q(this.c);
        g2.t((float)this.e, this.d);
        textView.setTextColor(this.b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.b.withAlpha(30), (Drawable)g2, (Drawable)g3);
        Rect rect = this.a;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable)rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        l.V((View)textView, (Drawable)insetDrawable);
    }
}

