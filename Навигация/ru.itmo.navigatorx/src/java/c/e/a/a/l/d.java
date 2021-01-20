/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.WeakHashMap
 */
package c.e.a.a.l;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public class d
extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> b = new d();
    public final WeakHashMap<Drawable, Integer> a = new WeakHashMap();

    public d() {
        super(Integer.class, "drawableAlphaCompat");
    }

    public Object get(Object object) {
        return ((Drawable)object).getAlpha();
    }

    public void set(Object object, Object object2) {
        ((Drawable)object).setAlpha(((Integer)object2).intValue());
    }
}

