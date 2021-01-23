/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package f.b.k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import f.b.j;
import f.b.o.a;

public abstract class a {
    public abstract boolean a();

    public abstract void b(boolean var1);

    public abstract int c();

    public abstract Context d();

    public abstract void e(Configuration var1);

    public abstract boolean f(int var1, KeyEvent var2);

    public abstract void g(boolean var1);

    public abstract void h(boolean var1);

    public abstract void i(CharSequence var1);

    public abstract f.b.o.a j(a.a var1);

    public static class a
    extends ViewGroup.MarginLayoutParams {
        public int a = 0;

        public a(int n2, int n3) {
            super(n2, n3);
            this.a = 8388627;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.a = typedArray.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            typedArray.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(a a2) {
            super((ViewGroup.MarginLayoutParams)a2);
            this.a = a2.a;
        }
    }

    public static interface b {
        public void a(boolean var1);
    }

    @Deprecated
    public static abstract class c {
        public abstract void a();
    }

}

