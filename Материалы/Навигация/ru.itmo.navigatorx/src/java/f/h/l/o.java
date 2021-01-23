/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  f.h.l.l
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 */
package f.h.l;

import android.view.View;
import f.h.l.l;

public class o
extends l.b<Boolean> {
    public o(int n2, Class class_, int n3) {
        super(n2, class_, n3);
    }

    @Override
    public Object b(View view) {
        return view.isAccessibilityHeading();
    }

    @Override
    public void c(View view, Object object) {
        view.setAccessibilityHeading(((Boolean)object).booleanValue());
    }

    @Override
    public boolean e(Object object, Object object2) {
        return true ^ this.a((Boolean)object, (Boolean)object2);
    }
}

