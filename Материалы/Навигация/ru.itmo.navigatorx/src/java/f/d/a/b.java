/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  java.lang.Math
 *  java.lang.Object
 */
package f.d.a;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import f.d.a.c;
import f.d.a.d;
import f.d.a.e;
import f.d.a.f;

public class b
implements d {
    public final e a(c c2) {
        return (e)c2.c();
    }

    public float b(c c2) {
        throw null;
    }

    public float c(c c2) {
        throw null;
    }

    public void d(c c2, ColorStateList colorStateList) {
        throw null;
    }

    public void e(c c2, float f2) {
        e e2 = this.a(c2);
        boolean bl = c2.a();
        boolean bl2 = c2.d();
        if (f2 == e2.b && e2.c == bl && e2.d == bl2) {
            if (!c2.a()) {
                c2.b(0, 0, 0, 0);
                return;
            }
            float f3 = this.a((c)c2).b;
            float f4 = this.a((c)c2).a;
            int n2 = (int)Math.ceil((double)f.a(f3, f4, c2.d()));
            int n3 = (int)Math.ceil((double)f.b(f3, f4, c2.d()));
            c2.b(n2, n3, n2, n3);
            return;
        }
        e2.b = f2;
        e2.c = bl;
        e2.d = bl2;
        e2.b(null);
        throw null;
    }
}

