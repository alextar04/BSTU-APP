/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  f.b.k.h
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import f.b.k.h;
import f.b.l.a.a;
import f.b.p.j;
import f.b.p.m0;
import f.h.e.b.g;

public class w0 {
    public final Context a;
    public final TypedArray b;
    public TypedValue c;

    public w0(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static w0 p(Context context, AttributeSet attributeSet, int[] arrn) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, arrn));
    }

    public static w0 q(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, arrn, n2, n3));
    }

    public boolean a(int n2, boolean bl) {
        return this.b.getBoolean(n2, bl);
    }

    public int b(int n2, int n3) {
        return this.b.getColor(n2, n3);
    }

    public ColorStateList c(int n2) {
        int n3;
        ColorStateList colorStateList;
        if (this.b.hasValue(n2) && (n3 = this.b.getResourceId(n2, 0)) != 0 && (colorStateList = a.a(this.a, n3)) != null) {
            return colorStateList;
        }
        return this.b.getColorStateList(n2);
    }

    public float d(int n2, float f2) {
        return this.b.getDimension(n2, f2);
    }

    public int e(int n2, int n3) {
        return this.b.getDimensionPixelOffset(n2, n3);
    }

    public int f(int n2, int n3) {
        return this.b.getDimensionPixelSize(n2, n3);
    }

    public Drawable g(int n2) {
        int n3;
        if (this.b.hasValue(n2) && (n3 = this.b.getResourceId(n2, 0)) != 0) {
            return a.b(this.a, n3);
        }
        return this.b.getDrawable(n2);
    }

    public Drawable h(int n2) {
        int n3;
        if (this.b.hasValue(n2) && (n3 = this.b.getResourceId(n2, 0)) != 0) {
            j j2 = j.a();
            Context context = this.a;
            j j3 = j2;
            synchronized (j3) {
                Drawable drawable = j2.a.g(context, n3, true);
                return drawable;
            }
        }
        return null;
    }

    public Typeface i(int n2, int n3, g g2) {
        int n4 = this.b.getResourceId(n2, 0);
        if (n4 == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        Context context = this.a;
        TypedValue typedValue = this.c;
        if (context.isRestricted()) {
            return null;
        }
        return h.i.V0(context, n4, typedValue, n3, g2, null, true);
    }

    public int j(int n2, int n3) {
        return this.b.getInt(n2, n3);
    }

    public int k(int n2, int n3) {
        return this.b.getLayoutDimension(n2, n3);
    }

    public int l(int n2, int n3) {
        return this.b.getResourceId(n2, n3);
    }

    public String m(int n2) {
        return this.b.getString(n2);
    }

    public CharSequence n(int n2) {
        return this.b.getText(n2);
    }

    public boolean o(int n2) {
        return this.b.hasValue(n2);
    }
}

