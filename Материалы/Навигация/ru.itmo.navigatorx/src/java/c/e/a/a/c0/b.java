/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.os.Handler
 *  android.text.TextPaint
 *  android.util.Log
 *  android.util.TypedValue
 *  c.e.a.a.c0.b$a
 *  c.e.a.a.c0.c
 *  f.b.k.h
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package c.e.a.a.c0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import c.e.a.a.c0.b;
import c.e.a.a.c0.c;
import c.e.a.a.c0.d;
import c.e.a.a.k;
import f.b.k.h;
import f.h.e.b.g;

public class b {
    public final float a;
    public final ColorStateList b;
    public final int c;
    public final int d;
    public final String e;
    public final ColorStateList f;
    public final float g;
    public final float h;
    public final float i;
    public final int j;
    public boolean k = false;
    public Typeface l;

    public b(Context context, int n2) {
        TypedArray typedArray = context.obtainStyledAttributes(n2, k.TextAppearance);
        this.a = typedArray.getDimension(k.TextAppearance_android_textSize, 0.0f);
        this.b = h.i.d0(context, typedArray, k.TextAppearance_android_textColor);
        h.i.d0(context, typedArray, k.TextAppearance_android_textColorHint);
        h.i.d0(context, typedArray, k.TextAppearance_android_textColorLink);
        this.c = typedArray.getInt(k.TextAppearance_android_textStyle, 0);
        this.d = typedArray.getInt(k.TextAppearance_android_typeface, 1);
        int n3 = k.TextAppearance_fontFamily;
        int n4 = k.TextAppearance_android_fontFamily;
        if (!typedArray.hasValue(n3)) {
            n3 = n4;
        }
        this.j = typedArray.getResourceId(n3, 0);
        this.e = typedArray.getString(n3);
        typedArray.getBoolean(k.TextAppearance_textAllCaps, false);
        this.f = h.i.d0(context, typedArray, k.TextAppearance_android_shadowColor);
        this.g = typedArray.getFloat(k.TextAppearance_android_shadowDx, 0.0f);
        this.h = typedArray.getFloat(k.TextAppearance_android_shadowDy, 0.0f);
        this.i = typedArray.getFloat(k.TextAppearance_android_shadowRadius, 0.0f);
        typedArray.recycle();
    }

    public final void a() {
        String string;
        if (this.l == null && (string = this.e) != null) {
            this.l = Typeface.create((String)string, (int)this.c);
        }
        if (this.l == null) {
            int n2 = this.d;
            Typeface typeface = n2 != 1 ? (n2 != 2 ? (n2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE) : Typeface.SERIF) : Typeface.SANS_SERIF;
            this.l = typeface;
            this.l = Typeface.create((Typeface)this.l, (int)this.c);
        }
    }

    public void b(Context context, d d2) {
        this.a();
        if (this.j == 0) {
            this.k = true;
        }
        if (this.k) {
            d2.b(this.l, true);
            return;
        }
        try {
            int n2 = this.j;
            a a2 = new a(this, d2);
            if (context.isRestricted()) {
                a2.a(-4, null);
                return;
            }
            h.i.V0(context, n2, new TypedValue(), 0, (g)a2, null, false);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = c.b.a.a.a.c("Error loading font ");
            stringBuilder.append(this.e);
            Log.d((String)"TextAppearance", (String)stringBuilder.toString(), (Throwable)exception);
            this.k = true;
            d2.a(-3);
            return;
        }
        catch (Resources.NotFoundException notFoundException) {
            this.k = true;
            d2.a(1);
            return;
        }
    }

    public void c(Context context, TextPaint textPaint, d d2) {
        this.a();
        this.d(textPaint, this.l);
        this.b(context, (d)new c(this, textPaint, d2));
        ColorStateList colorStateList = this.b;
        int n2 = colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216;
        textPaint.setColor(n2);
        float f2 = this.i;
        float f3 = this.g;
        float f4 = this.h;
        ColorStateList colorStateList2 = this.f;
        int n3 = colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0;
        textPaint.setShadowLayer(f2, f3, f4, n3);
    }

    public void d(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int n2 = this.c & typeface.getStyle();
        boolean bl = (n2 & 1) != 0;
        textPaint.setFakeBoldText(bl);
        float f2 = (n2 & 2) != 0 ? -0.25f : 0.0f;
        textPaint.setTextSkewX(f2);
        textPaint.setTextSize(this.a);
    }
}

