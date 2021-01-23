/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.l;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import c.e.a.a.f;

public class c
extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> a = new c("childrenAlpha");

    public c(String string) {
        super(Float.class, string);
    }

    public Object get(Object object) {
        Float f2 = (Float)((ViewGroup)object).getTag(f.mtrl_internal_children_alpha_tag);
        if (f2 != null) {
            return f2;
        }
        return Float.valueOf((float)1.0f);
    }

    public void set(Object object, Object object2) {
        ViewGroup viewGroup = (ViewGroup)object;
        float f2 = ((Float)object2).floatValue();
        viewGroup.setTag(f.mtrl_internal_children_alpha_tag, (Object)Float.valueOf((float)f2));
        int n2 = viewGroup.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            viewGroup.getChildAt(i2).setAlpha(f2);
        }
    }
}

