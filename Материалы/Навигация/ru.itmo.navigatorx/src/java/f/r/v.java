/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  f.h.l.l
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package f.r;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import f.h.l.l;
import f.r.a0;
import f.r.b0;
import f.r.e0;
import f.r.f0;
import f.r.t;
import f.r.u;
import f.r.z;

public class v {
    public static final b0 a;
    public static final Property<View, Float> b;

    public static {
        z z2 = Build.VERSION.SDK_INT >= 29 ? new a0() : new z();
        a = z2;
        b = new Property<View, Float>(Float.class, "translationAlpha"){

            public Object get(Object object) {
                return Float.valueOf((float)v.b((View)object));
            }

            public void set(Object object, Object object2) {
                View view = (View)object;
                float f2 = ((Float)object2).floatValue();
                v.a.e(view, f2);
            }
        };
        new Property<View, Rect>(Rect.class, "clipBounds"){

            public Object get(Object object) {
                return l.h((View)((View)object));
            }

            public void set(Object object, Object object2) {
                l.W((View)((View)object), (Rect)((Rect)object2));
            }
        };
    }

    public static u a(View view) {
        return new t(view);
    }

    public static float b(View view) {
        return a.b(view);
    }

    public static f0 c(View view) {
        return new e0(view);
    }

    public static void d(View view, int n2, int n3, int n4, int n5) {
        a.d(view, n2, n3, n4, n5);
    }

}

