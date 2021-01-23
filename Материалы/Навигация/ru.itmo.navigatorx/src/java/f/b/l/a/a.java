/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.util.SparseArray
 *  android.util.TypedValue
 *  java.lang.Object
 *  java.lang.ThreadLocal
 *  java.util.WeakHashMap
 */
package f.b.l.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import f.b.p.m0;
import java.util.WeakHashMap;

@SuppressLint(value={"RestrictedAPI"})
public final class a {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal();
    public static final WeakHashMap<Context, SparseArray<Object>> b = new WeakHashMap(0);
    public static final Object c = new Object();

    public static ColorStateList a(Context context, int n2) {
        return context.getColorStateList(n2);
    }

    public static Drawable b(Context context, int n2) {
        return m0.d().f(context, n2);
    }
}

